package fr.asuniia.akpi;

import fr.asuniia.akpi.logger.Logger;

public class Launch {
	
	public String name_internal = "AkPI";
	public String version_internal = "0.1";
	
	public static Logger log_launch = new Logger("Launch");
	
	
	public static void main(String[] args) {
		log_launch.info("AkPI is loading..");
		
	}

}
