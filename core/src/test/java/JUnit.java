import net.sf.l2j.tools.instruments.FormatCalculator;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 *
 * @project acis_public
 * @author finfan: 06.07.2021
 */
public class JUnit {
	@Test
	public void test() {
		System.out.println(FormatCalculator.toMillis(TimeUnit.HOURS, 1L));
	}
}
