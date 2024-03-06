package backend.org;

import javax.xml.crypto.Data;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SendSocket {
    private static final int PACKET_SIZE = 1024;
    public static void sendSocket(){
    try{
        DatagramSocket datagramSocket = new DatagramSocket(23);
        InetAddress address = InetAddress.getLocalHost();
        CompressedImage ic = CompressedImage.getInstancia();
        byte[] image = ic.getImage();
        FragmentImage fragmentador = new FragmentImage(image, PACKET_SIZE);

        while(true){
            if(fragmentador.haTerminado()) break;
            byte[] fragmento = fragmentador.getNext();

            DatagramPacket paquete = new DatagramPacket(fragmento, fragmento.length, address, 44);
            datagramSocket.send(paquete);
            System.out.println(paquete);
        }
        byte[] datoVacio = new byte[1024];
        DatagramPacket paqueteVacio = new DatagramPacket(datoVacio, datoVacio.length, address, 44);
        datagramSocket.send(paqueteVacio);
    }catch(IOException ex){
        System.out.println(ex);
    }}




}
