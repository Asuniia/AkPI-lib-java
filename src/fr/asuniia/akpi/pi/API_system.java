package fr.asuniia.akpi.pi;

import fr.asuniia.akpi.logger.Logger;

public class API_system {
	
	public static Logger pi_system_log = new Logger("API-System");

	
	public static void exit(int exitCode,String reason) {

		if(exitCode == 1) {
			pi_system_log.error("Exit code : " + exitCode + " / [" + reason + "]");
		} else {
			pi_system_log.info("Exit code : " + exitCode + " / [" + reason + "]");
		}
		
	}

}
