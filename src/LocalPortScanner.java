import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LocalPortScanner {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(9090);
            System.out.println("waiting for the client.....");

            // writing to the client
            Socket socket = serverSocket.accept();

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello Client");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientInput = bufferedReader.readLine();
            System.out.println(clientInput);

            bufferedReader.close();
            out.close();
            socket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
