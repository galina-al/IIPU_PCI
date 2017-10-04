import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) {
        String s;
        Process p;

        try {
            p = Runtime.getRuntime().exec("lspci -mmnn");
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while ((s = br.readLine()) != null) {
                String[] id = s.split("\"" + " " + "\"");
                System.out.print("VendorID: " + id[1] + "\t DeviceID: " + id[2].split("\"")[0] + "\n");
            }

            p.waitFor();
            System.out.println ("exit: " + p.exitValue());
            p.destroy();

        } catch (Exception e) {}
    }
}
