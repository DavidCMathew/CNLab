import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {
        DatagramSocket socket;
        try {
                socket=new DatagramSocket(9000);
                byte[] buffer=new byte[1000];

                while(true){
                    DatagramPacket request=new DatagramPacket(buffer,buffer.length);
                    socket.receive(request);

                    String data=(new String(request.getData())).substring(0,request.getLength());

                    System.out.println("The server recieved "+data);
                    String responseMessage = "Modified " + data + " From Server";

                    DatagramPacket response = new DatagramPacket(responseMessage.getBytes(),responseMessage.length()
                                                                ,request.getAddress(),request.getPort());
                    socket.send(response);
            }

        }catch (Exception e){e.printStackTrace();}
    }
}
