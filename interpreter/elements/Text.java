package interpreter.elements;

import interpreter.Element;
import interpreter.elements.Unknown;

public class Text extends Element {
	private static final long serialVersionUID = 1L;
	
	private String value;
	
	public Text(String value) {
		super();
		this.value = value;
		setType("text");
	}
	
	public String toText() {return value;}
	
	public int toInt() throws Unknown {
		try {
			return Integer.valueOf(value);
		}catch(NumberFormatException e) {
			throw new Unknown("konwersja z \"" + value + "\" do liczby calkowitej (integer)");
		}
	}
	
	public double toReal() throws Unknown {
		try {
			return Double.valueOf(value);
		}catch(NumberFormatException e) {
			throw new Unknown("konwersja z \"" + value + "\" do liczby rzeczywistej (real)");
		}
	}
	
	public Element add(Element el) {return new Text(value + el.toText());}
	public Element sub(Element el) {return this;}
	public Element mul(Element el) {return this;}
	public Element div(Element el) {return this;}
	public Element mod(Element el) {return this;}
	
	public Element evaluate() {return this;}
}
