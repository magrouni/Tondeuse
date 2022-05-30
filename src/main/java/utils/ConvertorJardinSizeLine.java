package utils;

import bean.JardinLimit;

public class ConvertorJardinSizeLine extends AbstractConvertorLine<JardinLimit>{

	public ConvertorJardinSizeLine(final String line) {
		super(line);
	}

	@Override
	protected JardinLimit process() {
		String[] pos = line.split(" ");
		return new JardinLimit(Integer.valueOf(pos[0]), Integer.valueOf(pos[1]));
	}
}
