import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) {
        try {
            Scanner in=new Scanner(System.in);

            System.out.println("Enter the filename ");
            String filename=in.nextLine();

            Socket socket = new Socket(InetAddress.getLocalHost(),9200);

            PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);

            pw.println(filename);

            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str;
            while((str=br.readLine())!=null)
                System.out.println(str);

            socket.close();

        }catch (Exception e){e.printStackTrace();}
    }
}
