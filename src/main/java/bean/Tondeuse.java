package bean;

import java.util.List;


public class Tondeuse {
	

	private final Position position;
	private final JardinLimit limite;
	private final List<Command> cmds;
	
	public Tondeuse(final JardinLimit limit, final Position position, final List<Command> cmds) {

		this.position = position;
		this.limite = limit;
		this.cmds = cmds;
	}

	public Position process() {
		for(Command cmd : cmds) {
			processCommand(cmd);
		}
		return position;
	}
	
	private void processCommand(final Command cmd) {
		switch(cmd) {
			case Avance :
				position.enAvantIfPossible(limite);
				break;
			case Droite :
				position.turnRightDirection();
				break;
			case Gauche :
				position.turnLeftDirection();
				break;	
		}
	}
}