import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) {
        try{
            ServerSocket serv_socket=new ServerSocket(9200);
            System.out.println("Server Ready");

            Socket req_socket=serv_socket.accept();
            System.out.println("Connection Successful");

            BufferedReader br=new BufferedReader(new InputStreamReader(req_socket.getInputStream()));
            String filename=br.readLine();

            System.out.println(filename+" requested");

            BufferedReader fileContent = new BufferedReader(new FileReader("/root/IdeaProjects/CNLab/src/"+filename));

            PrintWriter pw = new PrintWriter(req_socket.getOutputStream(),true);

            String str;
            while((str=fileContent.readLine())!=null)
                pw.println(str);

            req_socket.close();
        }catch (Exception e){e.printStackTrace();}
    }

}
