package interpreter.elements.functions;

import interpreter.Element;
import interpreter.elements.Function;
import interpreter.elements.Unknown;

public class Mul extends Function {
	private static final long serialVersionUID = 1L;
	
	public Mul() {
		super(2);
	}
	
	public Element evaluate() throws Unknown {
		return getArg(1).mul(getArg(0));
	}
}
