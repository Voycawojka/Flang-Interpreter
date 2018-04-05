package interpreter.elements.functions;

import interpreter.Element;
import interpreter.elements.Function;
import interpreter.elements.Text;
import interpreter.elements.Unknown;

public class GetLetter extends Function {
	private static final long serialVersionUID = 1L;
	
	public GetLetter() {
		super(2);
	}
	
	public Element evaluate() throws Unknown {
		int letter = getArg(0).toInt();
		return new Text(getArg(1).toText().substring(letter, letter + 1));
	}
}
