package backend.org;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class CompressImage {
    public static void compressImage(){
        try {
            Image i = Image.getInstance();
            BufferedImage image = i.getImage();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", baos);
            byte[] imageData = baos.toByteArray();

            CompressedImage ci = CompressedImage.getInstancia();
            ci.setImage(imageData);

        }catch(IOException ex){
            System.out.println(ex);
        }

    }
}
