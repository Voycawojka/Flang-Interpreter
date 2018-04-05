package interpreter.elements;

import interpreter.Element;

public class Unknown extends Element {
	private static final long serialVersionUID = 1L;
	
	private String value;
	
	public Unknown(String value) {
		super();
		this.value = value;
		setType("unknown");
	}
	
	public String toText() {return value;}
	public int toInt() {return 0;}
	public double toReal() {return 0;}
	
	public Element add(Element el) {return this;}
	public Element sub(Element el) {return this;}
	public Element mul(Element el) {return this;}
	public Element div(Element el) {return this;}
	public Element mod(Element el) {return this;}
	
	public Element evaluate() {return this;}
}
