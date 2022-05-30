import bean.CommandTU;
import bean.DirectionTU;
import bean.PositionEnAvantIfPossibleTU;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses(value={
	CommandTU.class,
	DirectionTU.class,
	PositionEnAvantIfPossibleTU.class,
	TondeuseControlTI.class
	})
public class AllTests{ 
}
