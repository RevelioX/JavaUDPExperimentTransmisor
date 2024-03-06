package backend.org;

import java.awt.image.BufferedImage;

public class Image {
    private BufferedImage image;
    private static Image instance;

    public static Image getInstance(){
        if(instance != null){
            return instance;
        }
        Image i = new Image();
        instance = i;
        return i;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
