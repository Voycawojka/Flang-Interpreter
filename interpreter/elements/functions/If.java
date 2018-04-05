package interpreter.elements.functions;

import interpreter.Element;
import interpreter.elements.Expression;
import interpreter.elements.Function;
import interpreter.elements.Unknown;

public class If extends Function {
	private static final long serialVersionUID = 1L;
	
	public If() {
		super(3);
	}
	
	public Element evaluate() throws Unknown {
		if(getArg(2).toInt() != 0) return new Expression(getArg(1).toText()).evaluate();
		else return new Expression(getArg(0).toText()).evaluate();
	}
}
