import bean.Position;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(Parameterized.class)
public class TondeuseControlTI {

	private final List<String> file;
	private final List<String> result;
	
	public TondeuseControlTI(List<String> file, List<String> result) {
		this.file = file;
		this.result = result;
	}
	
	@Parameters
	public static Collection<Object[]> params() {
	    return Arrays.asList(
	    		new Object[] {
	    				Arrays.asList("8 2", "4 1 E", "GAAADA"),
	    				Arrays.asList("5 2 E") },
	            new Object[] {
	            		Arrays.asList("5 5", "1 2 N", "GAGAGAGAA", "3 3 E",  "AADAADADDA"),
	            		Arrays.asList("1 3 N", "5 1 E") }
	        );
	}
	
	@Test
	public void process() throws Exception {
		// Given
		TondeuseControl startEngine = new TondeuseControl(file);
		
		// When
		List<Position> positions = startEngine.process();
		
		// Then
		assertNotNull(positions);
		assertEquals(result.size(), positions.size());
		
		for (int i = 0 ; i < positions.size() ; i++) {
			assertNotNull(positions.get(i));
			assertEquals(result.get(i), positions.get(i).toString());
		}
	}
}
