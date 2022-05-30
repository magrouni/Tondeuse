import bean.Position;
import exception.FileFormatInvalidException;
import org.apache.log4j.Logger;
import utils.FileReader;

import javax.naming.directory.InvalidAttributesException;
import java.io.FileNotFoundException;
import java.util.List;

public class AppRunner {
	
	static final Logger logger = Logger.getLogger(AppRunner.class);
	
	public static void main(final String[] args) throws InvalidAttributesException, FileFormatInvalidException, FileNotFoundException {
	   
		if(args == null || args.length == 0) {
			logger.error("Filename is mandatory !");
			throw new InvalidAttributesException();
		}
	    
		List<String> fileLine = FileReader.getInstance().read(args[0]);
 
		List<Position> positions = new TondeuseControl(fileLine).process();

		for (int i=0 ; i < positions.size() ; i++) {
			logger.info("   " + i + " : Tondeuse final position : " + positions.get(i));
		}

	}
}
