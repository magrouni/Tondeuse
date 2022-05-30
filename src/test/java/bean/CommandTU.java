package bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CommandTU {
	
	private final String code;
	private final Command commandResult;
	
	public CommandTU(final String code, final Command commandResult) {
		this.code = code;
		this.commandResult = commandResult;
	}
	
	@Parameters
	public static Collection<Object[]> params() {
	    return Arrays.asList(
	    		new Object[] { "A", Command.Avance },
	    		new Object[] { "G", Command.Gauche },
	    		new Object[] { "D", Command.Droite }
	        );
	}
	
	@Test
	public void getCommandeFromCode() {
		// When
		Command commandeFromCode = Command.getCommandeFromCode(code);
		
		// Then
		assertEquals(commandResult, commandeFromCode);
	}
}