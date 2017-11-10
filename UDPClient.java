import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) {
        DatagramSocket socket;
        try{
            socket=new DatagramSocket();
            String msg="Bye";
            InetAddress host=InetAddress.getByName("127.0.0.1");

            DatagramPacket P=new DatagramPacket(msg.getBytes(),msg.length(),InetAddress.getLocalHost(),9000);
            socket.send(P);

            byte[] buffer=new byte[1000];
            DatagramPacket response = new DatagramPacket(buffer,buffer.length);
            socket.receive(response);
            String responseMessage = (new String(response.getData())).substring(0,response.getLength());
            System.out.println("The response is "+responseMessage);
        }catch (Exception e){System.out.println(e.getCause());}
    }
}
