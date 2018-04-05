package interpreter.elements.functions;

import interpreter.Element;
import interpreter.elements.Function;
import interpreter.elements.Unknown;

public class Def extends Function {
	private static final long serialVersionUID = 1L;
	
	public Def() {
		super(3);
	}
	
	public Element evaluate() throws Unknown {
		int argN = getArg(2).toInt();
		String name = getArg(1).toText();
		String code = getArg(0).toText();
		
		return new Custom(argN, name, code);
	}
}
