package optional;

import java.awt.Color;

/* Use the following refactorings to reduce the long parameter list;
 * 		Introduce Parameter Object
 *  	Change Method Signature
 */

public class WorkIt {

	void putMyThingDown(LongParameter parameter, int numberOfGrammyAwards, boolean isSupaDupaFly) {
		flipIt(parameter);
	}

	void flipIt(LongParameter parameter) {
		reverseIt(parameter);
	}

	void reverseIt(LongParameter parameter) {
		System.out.println(parameter.missySneakerSize + parameter.bling + parameter.missyCapColor);
	}
}

class LongParameter {
	public int missySneakerSize;
	public Color missyCapColor;
	public String bling;

	public LongParameter(int missySneakerSize, Color missyCapColor, String bling) {
		this.missySneakerSize = missySneakerSize;
		this.missyCapColor = missyCapColor;
		this.bling = bling;
	}
}