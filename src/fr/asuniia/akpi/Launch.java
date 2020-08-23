package fr.asuniia.akpi;

import fr.asuniia.akpi.load.LoaderEnvironement;
import fr.asuniia.akpi.logger.Logger;
import fr.asuniia.akpi.pi.API;

public class Launch extends API {
	
	public String name_internal = "AkPI";
	public String version_internal = "0.1";
	
	public static Logger log_launch = new Logger("Launch");
	
	
	public static void main(String[] args) {
		log_launch.info("AkPI is loading.. ");
		LoaderEnvironement.load("ee", "e");
	}

}
