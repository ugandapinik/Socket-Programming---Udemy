import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadServer {
    public static void main(String[] args) {
        try{
            // creating a server socket
            ServerSocket serverSocket = new ServerSocket(9090);

            // accept multiple client
            boolean stop = false;
            while(!stop){
                System.out.println("Waiting for the client....");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client is Connected");


                // Separate the multiple Thread
                ClientThread client = new ClientThread(clientSocket);
                client.start();

            }



        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
