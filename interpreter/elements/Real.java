package interpreter.elements;

import interpreter.Element;

public class Real extends Element {
	private static final long serialVersionUID = 1L;

	private double value;
	
	public Real(double value) {
		super();
		this.value = value;
		setType("real");
	}
	
	public String toText() {
		return String.valueOf(value);
	}
	
	public int toInt() {
		return (int) value;
	}
	
	public double toReal() {
		return value;
	}
	
	public Element add(Element el) throws Unknown {
		return new Real(value + el.toReal());
	}
	
	public Element sub(Element el) throws Unknown {
		return new Real(value - el.toReal());
	}
	
	public Element mul(Element el) throws Unknown {
		return new Real(value * el.toReal());
	}
	
	public Element div(Element el) throws Unknown {
		return new Real(value / el.toReal());
	}
	
	public Element mod(Element el) throws Unknown {
		return new Real((int) value % el.toInt());
	}
	
	public Element evaluate() {return this;}
}
