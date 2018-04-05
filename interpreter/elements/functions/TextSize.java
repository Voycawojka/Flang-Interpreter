package interpreter.elements.functions;

import interpreter.Element;
import interpreter.elements.Function;
import interpreter.elements.Integ;
import interpreter.elements.Unknown;

public class TextSize extends Function {
	private static final long serialVersionUID = 1L;
	
	public TextSize() {
		super(1);
	}
	
	public Element evaluate() throws Unknown {
		return new Integ(getArg(0).toText().length());
	}
}