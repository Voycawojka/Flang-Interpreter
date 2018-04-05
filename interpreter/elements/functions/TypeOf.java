package interpreter.elements.functions;

import interpreter.Element;
import interpreter.elements.Function;
import interpreter.elements.Text;
import interpreter.elements.Unknown;

public class TypeOf extends Function {
	private static final long serialVersionUID = 1L;
	
	public TypeOf() {
		super(1);
	}
	
	public Element evaluate() throws Unknown {
		return new Text(getArg(0).getType());
	}
}
