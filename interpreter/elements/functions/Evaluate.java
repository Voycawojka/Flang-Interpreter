package interpreter.elements.functions;

import interpreter.Element;
import interpreter.elements.Expression;
import interpreter.elements.Function;
import interpreter.elements.Unknown;

public class Evaluate extends Function {
	private static final long serialVersionUID = 1L;
	
	public Evaluate() {
		super(1);
	}
	
	public Element evaluate() throws Unknown {
		return new Expression(getArg(0).toText()).evaluate();
	}
}
