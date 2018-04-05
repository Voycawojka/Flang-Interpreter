package interpreter.elements;

import interpreter.Element;

public class Integ extends Element {
	private static final long serialVersionUID = 1L;

	private int value;
	
	public Integ(int value) {
		super();
		this.value = value;
		setType("integer");
	}
	
	public String toText() {
		return String.valueOf(value);
	}
	
	public int toInt() {
		return value;
	}
	
	public double toReal() {
		return (double) value;
	}
	
	public Element add(Element el) throws Unknown {
		return new Integ(value + el.toInt());
	}
	
	public Element sub(Element el) throws Unknown {
		return new Integ(value - el.toInt());
	}
	
	public Element mul(Element el) throws Unknown {
		return new Integ(value * el.toInt());
	}
	
	public Element div(Element el) throws Unknown {
		return new Integ(value / el.toInt());
	}
	
	public Element mod(Element el) throws Unknown {
		return new Integ((int) value % el.toInt());
	}
	
	public Element evaluate() {return this;}
}
