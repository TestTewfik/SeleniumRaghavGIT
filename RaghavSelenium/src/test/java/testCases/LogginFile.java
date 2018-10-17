package testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogginFile {
	
	static final Logger log = LogManager.getLogger(LogginFile.class.getName());
	
	public static void main(String[] args) {
		log.debug("Debug");
		
	}

}
