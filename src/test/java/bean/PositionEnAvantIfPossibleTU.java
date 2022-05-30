package bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PositionEnAvantIfPossibleTU {
	
	private final Position position;
	private final JardinLimit limit;
	private final int resultX;
	private final int resultY;
	
	public PositionEnAvantIfPossibleTU(final Position position, final JardinLimit limit, final int resultX, final int resultY) {
		this.position = position;
		this.limit = limit;
		this.resultX = resultX;
		this.resultY = resultY;
	}
	
	@Parameters
	public static Collection<Object[]> params() {
	    return Arrays.asList(
	    		new Object[] { new Position(5, 5, Direction.North), new JardinLimit(5, 5), 5, 5 },
	    		new Object[] { new Position(5, 5, Direction.East), new JardinLimit(5, 5), 5, 5 },
	    		new Object[] { new Position(0, 5, Direction.West), new JardinLimit(5, 5), 0, 5 },
	    		new Object[] { new Position(5, 0, Direction.South), new JardinLimit(5, 5), 5, 0 }
	    	        );
	}

	@Test
	public void enAvantIfPossible() {
		// When
		position.enAvantIfPossible(limit);
		
		// Then
		assertEquals(position.getX(), resultX);
		assertEquals(position.getY(), resultY);
	}
}
