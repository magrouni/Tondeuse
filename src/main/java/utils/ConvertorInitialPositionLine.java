package utils;

import bean.Direction;
import bean.Position;

public class ConvertorInitialPositionLine extends AbstractConvertorLine<Position>{

	public ConvertorInitialPositionLine(final String line) {
		super(line);
	}

	@Override
	protected Position process() {
		String[] split = line.split(" ");
		Direction direction = Direction.getDirectionFromCode(split[2]);
		return new Position(Integer.valueOf(split[0]), Integer.valueOf(split[1]), direction);
	}
}
