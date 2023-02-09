import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Wget {
    public static void main(String[] args) throws IOException {
        String endpoint = args[0];
        File file = new File(calculateFileName(endpoint));
        OutputStreamWriter fileWriter = new FileWriter(file);
        URL url = new URL(endpoint);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            fileWriter.append(inputLine);
        }
        in.close();
        con.disconnect();
        fileWriter.flush();
        fileWriter.close();
    }

    static String calculateFileName(String url) {
        //find the last /
        char[] chars = url.toCharArray();
        int i = chars.length-1;
        for (; i > 0; i--) {
            if (chars[i] == '/') {
                break;
            }
        }
        return url.substring(i+1);
    }
}