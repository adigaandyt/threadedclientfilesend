import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;

    //Constructor
    public ClientHandler(Socket clientSocket) throws IOException {
        this.client = clientSocket;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(),true);
        System.out.println("Socket made");
    }

    public void run()  {
        try{
            while(true){
                String msg = in.readLine();
                out.println("You said: " + msg);
                }
            }catch (Exception e){
            System.out.printf("error while handling client");
        }finally {
            out.close();
            try {
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
