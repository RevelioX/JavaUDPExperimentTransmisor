package backend.org;

public class FragmentImage {
    private byte[] image;
    private int packetSize;

    private int actual;

    public FragmentImage(byte[] image, int packetSize){
        this.image = image;
        this.packetSize = packetSize;
        this.actual = 0;
    }

    public byte[] getNext(){
        byte[] fragmento = new byte[1024];
        System.arraycopy(image,actual*packetSize,fragmento,0, packetSize);
        actual++;
        return fragmento;
    }

    public boolean haTerminado(){
        int cantFragmentostotales = image.length / packetSize;
        if( cantFragmentostotales <= actual){
            return true;
        }else{
            return false;
        }
    }


}
