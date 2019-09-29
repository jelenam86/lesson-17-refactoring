package optional;

import java.util.ArrayList;
import java.util.List;

/* Extract a Milkshake class from TheYard */

public class TheYard {

	private Milkshake milkshake;
	private List<Boy> theBoys = new ArrayList<Boy>();

	void bringAllTheBoysToTheYard() {
		for (Boy aBoy : theBoys) {
			aBoy.bringToTheYard(milkshake.getIceCreamFlavor(), milkshake.isCherryOnTop(), milkshake.getSyrupFlavor());
		}
	}

	public void addBoy(Boy boy) {
		this.theBoys.add(boy);
	}

	public void setMilkshake(String iceCreamFlavor, boolean cherryOnTop, String syrupFlavor) {
		this.milkshake = new Milkshake(iceCreamFlavor, cherryOnTop, syrupFlavor);
	}

	public static void main(String[] args) {
		TheYard theYard = new TheYard();
		theYard.setMilkshake("vanilla", true, "strawberry");
		theYard.addBoy(new Boy("groucho"));
		theYard.addBoy(new Boy("harpo"));
		theYard.addBoy(new Boy("zeppo"));
		theYard.bringAllTheBoysToTheYard();
	}

}

class Boy {

	private String name;

	public Boy(String name) {
		this.name = name;
	}

	public void bringToTheYard(String iceCreamFlavor, boolean cherryOnTop, String syrupFlavor) {
		System.out.println(cherryOnTop ? "damn right, it's better than yours" : "i could teach you, but i'd have to charge");
	}

}

class Milkshake {
	private String iceCreamFlavor;
	private boolean cherryOnTop;
	private String syrupFlavor;

	public Milkshake(String iceCreamFlavor, boolean cherryOnTop, String syrupFlavor) {
		this.iceCreamFlavor = iceCreamFlavor;
		this.cherryOnTop = cherryOnTop;
		this.syrupFlavor = syrupFlavor;
	}

	public String getIceCreamFlavor() {
		return iceCreamFlavor;
	}

	public void setIceCreamFlavor(String iceCreamFlavor) {
		this.iceCreamFlavor = iceCreamFlavor;
	}

	public boolean isCherryOnTop() {
		return cherryOnTop;
	}

	public void setCherryOnTop(boolean cherryOnTop) {
		this.cherryOnTop = cherryOnTop;
	}

	public String getSyrupFlavor() {
		return syrupFlavor;
	}

	public void setSyrupFlavor(String syrupFlavor) {
		this.syrupFlavor = syrupFlavor;
	}
}
