package backend.org;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CaptureImage {
    public static void captureImage(){
        try{
            Robot robot = new Robot();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Rectangle screenRect = new Rectangle(screenSize);
            BufferedImage image = robot.createScreenCapture(screenRect);

            //Codigo que comprime la imagen
            int scaledWidth = screenSize.width / 2;
            int scaledHeight = screenSize.height / 2;
            BufferedImage scaledImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = scaledImage.createGraphics();
            g2d.drawImage(image, 0, 0, scaledWidth, scaledHeight, null);
            g2d.dispose();

            //Codigo para generar un archivo guardando la imagen, no me parece interesante.
            //File outputFile = new File("foto.png");
            //ImageIO.write(scaledImage, "png", outputFile);
            Image i = Image.getInstance();
            i.setImage(scaledImage);

        }catch (AWTException ex){
            System.out.println(ex);
        }


    }
}
