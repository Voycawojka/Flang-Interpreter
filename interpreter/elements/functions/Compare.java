package interpreter.elements.functions;

import interpreter.Element;
import interpreter.elements.Function;
import interpreter.elements.Integ;
import interpreter.elements.Unknown;

public class Compare extends Function {
	private static final long serialVersionUID = 1L;
	
	public Compare() {
		super(3);
	}
	
	public Element evaluate() throws Unknown {
		boolean v = logicOperator(getArg(2).toReal(), getArg(1).toReal(), getArg(0).toText());
		if(v) return new Integ(1);
		else return new Integ(0);
	}
}