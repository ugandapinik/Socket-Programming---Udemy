import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class Ping {
    public static void main(String[] args) {
        try{

            String hostAddress = "google.com";
            InetAddress host = InetAddress.getByName(hostAddress);
            System.out.println(host.isReachable(1000));


            Process process = Runtime.getRuntime().exec("ping " + hostAddress);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String commandOutput = "";
            boolean isReachable = false;

            while((commandOutput = bufferedReader.readLine()) != null){
                //System.out.println(commandOutput);
                if (commandOutput.contains("Destination host unreachable")){
                    isReachable = false;
                    break;
                }
            }

            if (isReachable){
                System.out.println();
            }




        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
