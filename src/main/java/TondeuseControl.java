import bean.Command;
import bean.JardinLimit;
import bean.Position;
import bean.Tondeuse;
import exception.FileFormatInvalidException;
import org.apache.log4j.Logger;
import utils.ConvertorCommandLine;
import utils.ConvertorInitialPositionLine;
import utils.ConvertorJardinSizeLine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TondeuseControl {

	private static final Logger logger = Logger.getLogger(TondeuseControl.class);
	
	private final List<Tondeuse> tondeuses = new ArrayList<Tondeuse>();
	
	public TondeuseControl(final List<String> file) throws FileFormatInvalidException {
		
		if (file == null || file.size() == 0) {
			logger.error("File is empty !");
			throw new FileFormatInvalidException();
		}

		Iterator<String> iterator = file.iterator();
		
		String JardinLimitLine = iterator.next();
		JardinLimit JardinLimit = new ConvertorJardinSizeLine(JardinLimitLine).convert();
		
		while (iterator.hasNext()) {
			String positiontondeuseLine = iterator.next();
			Position position = new ConvertorInitialPositionLine(positiontondeuseLine).convert();
			
			if (!iterator.hasNext()) {
				logger.error("File format is invalid !");
				throw new FileFormatInvalidException();
			}
			
			String tondeuseCommands = iterator.next();
			List<Command> commands = new ConvertorCommandLine(tondeuseCommands).convert();

			Tondeuse tondeuse = new Tondeuse(JardinLimit, position, commands);
			tondeuses.add(tondeuse);	
		}	
	}
	
	public List<Position> process() {
		List<Position> position = new ArrayList<Position>(tondeuses.size());
		for(Tondeuse tondeuse : tondeuses) {
			position.add(tondeuse.process());
		}
		return position;
	}
}