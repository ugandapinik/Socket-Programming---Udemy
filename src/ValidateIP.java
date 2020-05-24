import java.net.InetAddress;

public class ValidateIP {

    /*
    valid IP Address
    ============================
    192.168.0.12
    10.10.10.10
    86.123.6.230

    Invalid IP Address:
    ============================
    192.168.0.321
    10.10.10.10.10
    232.0.0.ac

    */

    public static void main(String[] args) {
        ValidateIP validateIP = new ValidateIP();
        String ipAddress = "192.168.0.1022";
        boolean isValid = validateIP.validateIPAddress(ipAddress);

        if (isValid){
            System.out.println(ipAddress + " is valid");
        }
    }


    public boolean validateIPAddress(String ipAddress){
        String[] numbers = ipAddress.split("\\.");
        if (numbers.length != 4) return false;

        for (String number: numbers){
            int i = Integer.parseInt(number);
            if (i < 0 || i > 255){
                return false;
            }
        }

        return true;
    }
}
