package fr.asuniia.akpi.pi.modules;

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
	
    public static String getUser() {
    	return System.getProperty("user.name");
    }
	
    public static EnumOS getOSType() {
        String var0 = System.getProperty("os.name").toLowerCase();
        return var0.contains("win") ? EnumOS.WINDOWS : (var0.contains("mac") ? EnumOS.OSX : (var0.contains("solaris") ? EnumOS.SOLARIS : (var0.contains("sunos") ? EnumOS.SOLARIS : (var0.contains("linux") ? EnumOS.LINUX : (var0.contains("unix") ? EnumOS.LINUX : EnumOS.UNKNOWN)))));
    }

    public enum EnumOS {
        LINUX("LINUX", 0), SOLARIS("SOLARIS", 1), WINDOWS("WINDOWS", 2), OSX("OSX", 3), UNKNOWN("UNKNOWN", 4);

        EnumOS(String p, int pp) {
        }
    }

}
