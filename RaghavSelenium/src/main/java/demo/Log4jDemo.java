package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jDemo {

	private static Logger log = LogManager.getLogger(Log4jDemo.class);
	
	
	
	public static void main(String[] args) {
		
		System.out.println("\n Hello world...!   \n");
		log.info("This is information message");
		log.error("This is an error message");
		log.warn("This is warn message");
		log.fatal("This is fatal message");
		log.trace("TRACE MESAGE");
		
		
		System.out.println("\n completed   \n");
	}
	
	
}
