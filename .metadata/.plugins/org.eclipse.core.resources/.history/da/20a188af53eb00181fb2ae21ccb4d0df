/**
 * 
 */
package app;

/**
 * @author github.com/josedavidgm1995
 * 
 * This Enum class is use to map the "Sparkfun Pi Wedge 40-pin"'s pins
 * to the WiringPi/Ri4J's RaspiPin class.
 * 
 * LINK: https://learn.sparkfun.com/tutorials/preassembled-40-pin-pi-wedge-hookup-guide/all#pin-mapping
 *
 */
import com.pi4j.io.gpio.*;

public enum PiWedge{
	
	G17(RaspiPin.GPIO_00), 
	G16(RaspiPin.GPIO_27), 
	G13(RaspiPin.GPIO_23), 
	G12(RaspiPin.GPIO_26),
	G6(RaspiPin.GPIO_22),
	G5(RaspiPin.GPIO_21),
	G4(RaspiPin.GPIO_07),
	G18(RaspiPin.GPIO_01),
	G19(RaspiPin.GPIO_24),
	G20(RaspiPin.GPIO_28), 
	G21(RaspiPin.GPIO_29), 
	G22(RaspiPin.GPIO_03), 
	G23(RaspiPin.GPIO_04), 
	G24(RaspiPin.GPIO_05), 
	G25(RaspiPin.GPIO_06), 
	G26(RaspiPin.GPIO_25), 
	G27(RaspiPin.GPIO_02),
	SCK(RaspiPin.GPIO_14), 
	SCL(RaspiPin.GPIO_09), 
	SDA(RaspiPin.GPIO_08), 
	IDSC(RaspiPin.GPIO_31), 
	IDSD(RaspiPin.GPIO_30), 
	CE1(RaspiPin.GPIO_11), 
	CE0(RaspiPin.GPIO_10), 
	MOSI(RaspiPin.GPIO_12), 
	MISO(RaspiPin.GPIO_12), 
	RXI(RaspiPin.GPIO_16), 
	TXO(RaspiPin.GPIO_15);

	private Pin pin;

	PiWedge(Pin pin) {
		this.pin = pin;
	}
	
	public Pin pin(){return pin;}

}
