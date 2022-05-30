package bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DirectionTU {
	
	private final String code;
	private final Direction direction;
	private final Direction directionLeftResult;
	private final Direction directionRightResult;
	
	public DirectionTU(final String code, final Direction direction, 
			final Direction directionLeftResult, final Direction directionRightResult) {
		this.code = code;
		this.direction = direction;
		this.directionLeftResult = directionLeftResult;
		this.directionRightResult = directionRightResult;
	}
	
	@Parameters
	public static Collection<Object[]> params() {
	    return Arrays.asList(
	    		new Object[] { "N", Direction.North, Direction.West, Direction.East},
	    		new Object[] { "S", Direction.South, Direction.East, Direction.West },
	    		new Object[] { "E", Direction.East, Direction.North, Direction.South },
	    		new Object[] { "W", Direction.West, Direction.South, Direction.North }
	        );
	}
	
	@Test
	public void getDirectionFromCode() {
		// When
		Direction directionFromCode = Direction.getDirectionFromCode(code);
		
		// Then
		assertEquals(direction, directionFromCode);
	}
	
	@Test
	public void getLeftDirection() {
		// When
		Direction directionLeft = direction.getGaucheDirection();
		
		// Then
		assertEquals(directionLeftResult, directionLeft);
	}
	
	@Test
	public void getRightDirection() {
		// When
		Direction directionRight = direction.getDroitDirection();
		
		// Then
		assertEquals(directionRightResult, directionRight);
	}
}