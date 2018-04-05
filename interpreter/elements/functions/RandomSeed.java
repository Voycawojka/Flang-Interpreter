package interpreter.elements.functions;

import interpreter.Element;
import interpreter.elements.Function;

public class RandomSeed extends Function {
	private static final long serialVersionUID = 1L;
	
	public RandomSeed() {
		super(0);
	}
	
	public Element evaluate() {
		Rand.gen.setSeed(System.currentTimeMillis());
		return null;
	}
}
