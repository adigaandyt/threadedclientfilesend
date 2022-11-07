import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public static void main(String[] args) throws IOException {
        //Get ip+port
        int port = 5000;
        InetAddress ipAddress = Inet4Address.getByName("localhost");
        //Create socket using IP and port
        ServerSocket serverSocket = new ServerSocket(port,10,ipAddress);

        //put socket in thread here

        //Wait for client
        while(true){
            Socket clientSocket = serverSocket.accept();
            System.out.printf("Client connected");
            //Created in clinethanlder thread
            //BufferedReader brIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            //PrintWriter pwOut = new PrintWriter(clientSocket.getOutputStream(),true);

            Thread newClient = new ClientHandler(clientSocket);
            newClient.run();


        }




    }
}
