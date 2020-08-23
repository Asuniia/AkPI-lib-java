package fr.asuniia.akpi.pi;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;

import fr.asuniia.akpi.logger.Logger;

public class API_network {
	
	public static Logger pi_network_log = new Logger("API-Network");
	
	public static void downloadFile(String url, File file,String name_file) {
        try {
            FileOutputStream fos = new FileOutputStream(file + "/" + name_file + ".lak");
            fos.getChannel().transferFrom(Channels.newChannel(new URL(url).openStream()), 0, Long.MAX_VALUE);
            fos.close();
          }
          catch(Exception e) {
        	  pi_network_log.error("An Exception was caught when trying to download the " + name_file + " URL:" + url +"!");
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
