package loggerpackageone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class LoggingDemo {
	
	private static final Logger log = (Logger) LogManager.getLogger(LoggingDemo.class.getName());

	
	public static void main(String[] args)
	{
		//config file is in resources folder and added to sources in Java Build path
		//All
		//trace
		//debug
		//info
		//warn
		//error
		//fatal
		//off
		log.error("logging an error");
		log.fatal("logging a fatal message");
		//after adding config file, depending on the root level in the config, it prints the messages
		log.warn("logging a warning msg");
		//with root level  info, it prints warn, error and fatal
		
		//if logger root level is trace
		log.trace("trace has been logged");
		log.debug("debug has been logged");
		log.info("info has been logged");
	}
}
