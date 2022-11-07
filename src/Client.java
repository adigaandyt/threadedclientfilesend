import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        //TTTTEEEESSSTTT
        int port = 5000;
        InetAddress ipAddress = Inet4Address.getByName("localhost");
        Socket clientSocket = new Socket(ipAddress, port);
        //Read data from server
        BufferedReader brIn =  new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        //Write data to server
        PrintWriter pwOut =new PrintWriter(clientSocket.getOutputStream(),true);
        while(true){
            //get a sentence
            System.out.print("Enter a sentence to send: ");
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String sentenceIn = userInput.readLine();
            //send the sentence
            pwOut.println(sentenceIn);
            pwOut.flush();

            String serverMsg = brIn.readLine();
            System.out.println(serverMsg);
        }



    }
}
