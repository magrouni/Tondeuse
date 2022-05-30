package utils;

import bean.Command;

import java.util.ArrayList;
import java.util.List;

public class ConvertorCommandLine extends AbstractConvertorLine<List<Command>>{

	public ConvertorCommandLine(final String line) {
		super(line);
	}


	@Override
	protected List<Command> process() {
		List<Command> cmds = new ArrayList<Command>();
		char [] listeCmds = line.toCharArray();
		
		for (char c : listeCmds) {
			cmds.add(Command.getCommandeFromCode(String.valueOf(c)));
		}
		
		return cmds;
	}
}