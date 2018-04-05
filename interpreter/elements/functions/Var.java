package interpreter.elements.functions;

import interpreter.Element;
import interpreter.elements.Function;
import interpreter.elements.Unknown;

public class Var extends Function {
	private static final long serialVersionUID = 1L;
	
	public Var() {
		super(2);
	}
	
	public Element evaluate() throws Unknown {
		String name = getArg(1).toText();
		String code = getArg(0).toText();
		
		return new Custom(0, name, code);
	}
}
