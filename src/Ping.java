import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class Ping {
    public static void main(String[] args) {
        try{

            String hostAddress = "192.168.1.123";
            InetAddress host = InetAddress.getByName(hostAddress);
            System.out.println(host.isReachable(1000));


            Process process = Runtime.getRuntime().exec("ping -i .5  -t 6 " + hostAddress);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String commandOutput = "";
            boolean isReachable = true;

            while((commandOutput = bufferedReader.readLine()) != null){
                //System.out.println(commandOutput);
                if (commandOutput.contains("Request timeout")){
                    isReachable = false;
                    break;
                }
            }

            if (isReachable){
                System.out.println("Host is reachable!");
            }else{
                System.out.println("Host is not reachable!");
            }




        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
