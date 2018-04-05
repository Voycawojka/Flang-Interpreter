package interpreter.elements.functions;

import interpreter.Element;
import interpreter.elements.Function;
import interpreter.elements.Integ;
import interpreter.elements.Unknown;

public class Equal extends Function {
	private static final long serialVersionUID = 1L;
	
	public Equal() {
		super(2);
	}
	
	public Element evaluate() throws Unknown {
		boolean v = (getArg(1).toText().equals(getArg(0).toText()));
		
		if(v) return new Integ(1);
		else return new Integ(0);
	}
}
