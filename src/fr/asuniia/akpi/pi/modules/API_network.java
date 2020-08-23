package fr.asuniia.akpi.pi.modules;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;

import fr.asuniia.akpi.logger.Logger;

public class API_network {
	
	public static Logger pi_network_log = new Logger("API-Network");
	
    public static String makeRequest(String url) throws Exception {
        final URL urlobj = new URL(url);
        final URLConnection yc = urlobj.openConnection();
        final BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String finalLine = null;
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            if (finalLine == null) {
                finalLine = inputLine;
            }
            else {
                finalLine = "\n" + inputLine;
            }
        }
        in.close();
        return finalLine;
    }
	
	public static void downloadFile(String url, File file,String name_file) {
        try {
            FileOutputStream fos = new FileOutputStream(file + "/" + name_file + ".lak");
            fos.getChannel().transferFrom(Channels.newChannel(new URL(url).openStream()), 0, Long.MAX_VALUE);
            fos.close();
          }
          catch(Exception e) {
        	  pi_network_log.error("An Exception was caught when trying to download the " + name_file + " URL: " + url +"!");
           // Controllerupdater.info_ver.setText("PROBLEME DL");
          }
	}

	
    public static boolean isInternetReachable() {
        return isWebsiteReachable("http://www.google.com") || isWebsiteReachable("http://www.apple.com");
    }

    public static boolean isWebsiteReachable(final String urlStr) {
        try {
            final URL url = new URL(urlStr);
            final URLConnection conn = url.openConnection();
            conn.setReadTimeout(2000);
            conn.connect();
            pi_network_log.info("Vérification connectivité réseau..");
            return true;
        }
        catch (Exception e) {
        	pi_network_log.error("Aucune connectivité réseau detecté. Vérifiez branchement.");
            return false;
        }
    }
}
