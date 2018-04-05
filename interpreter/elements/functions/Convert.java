package interpreter.elements.functions;

import interpreter.Element;
import interpreter.elements.Function;
import interpreter.elements.Integ;
import interpreter.elements.Real;
import interpreter.elements.Text;
import interpreter.elements.Unknown;

public class Convert extends Function {
	private static final long serialVersionUID = 1L;
	
	public Convert() {
		super(2);
	}
	
	public Element evaluate() throws Unknown {
		if(getArg(0).toText().equals("integer")) return new Integ(getArg(1).toInt());
		if(getArg(0).toText().equals("real")) return new Real(getArg(1).toReal());
		if(getArg(0).toText().equals("text")) return new Text(getArg(1).toText());
		
		return new Unknown("konwersja z " + getArg(1).getType() + " do " + getArg(0).toText() + ".");
	}
}