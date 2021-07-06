package net.sf.l2j.tools.instruments;

import java.util.concurrent.TimeUnit;

/**
 *
 * @project acis_public
 * @author finfan: 06.07.2021
 */
public class FormatCalculator {
	public static final Long toMillis(TimeUnit unit, Long value) {
		return unit.toMillis(value);
	}

	public static final Long toSeconds(TimeUnit unit, Long value) {
		return unit.toSeconds(value);
	}

	public static final Long toMinutes(TimeUnit unit, Long value) {
		return unit.toMinutes(value);
	}

	public static final Long toHours(TimeUnit unit, Long value) {
		return unit.toHours(value);
	}

	public static final Long toDays(TimeUnit unit, Long value) {
		return unit.toHours(value);
	}
}
