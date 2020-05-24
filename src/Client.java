import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    public static void main(String[] args) {
        try{
            InetAddress severAddress = InetAddress.getByName("localhost");
            System.out.println("Server IP Address: " + severAddress.getAddress());
            Socket socket = new Socket("localhost", 9090);


            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println(input.readLine());
            output.println("Hello Server!");

            //close all connection
            input.close();
            output.close();
            socket.close();




        }catch (UnknownHostException e){
            System.out.println("Unknown host exception: " + e.toString());

        }catch (IOException ioException){
            System.out.println("IOException: " + ioException.toString());

        }catch (IllegalArgumentException illegalArgumentException){
            System.out.println("Illegal Argument Exception: " + illegalArgumentException.toString());

        }catch (Exception exception){
            System.out.println(exception.toString());
        }
    }

}
