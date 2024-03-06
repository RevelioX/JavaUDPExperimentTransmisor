package backend.org;

public class CompressedImage {
    private static byte[] image;
    private static CompressedImage instancia;

    public static CompressedImage getInstancia() {
        if(instancia != null) {
            return instancia;
        }else{
            return new CompressedImage();
        }
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
