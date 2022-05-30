package utils;

public abstract class AbstractConvertorLine<T> {
	

	protected final String line;
	
	protected AbstractConvertorLine(final String line) {
		this.line = line;
	}
	

	protected abstract T process();
	
	public T convert() {

		return process();
	}
}