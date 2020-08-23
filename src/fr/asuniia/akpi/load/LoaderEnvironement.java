package fr.asuniia.akpi.load;

import fr.asuniia.akpi.logger.Strings;
import fr.asuniia.akpi.pi.API;

public class LoaderEnvironement extends API {
	
	public static Strings s = new Strings();
	
	public static void load(String projectname,String token) {
		api_network.isInternetReachable();
		if(token == null) {
			api_system.exit(1, "Aucune token de projet.");
		} else if(projectname == null) {
			api_system.exit(1, "Aucune nom de projet.");
	
		} else {
			token = s.project_token_encrypt;
			projectname = s.project_name;
			
		}
		
	}

}
