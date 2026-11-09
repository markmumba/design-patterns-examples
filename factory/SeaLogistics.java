

public class SeaLogistics extends Logistics{

	@Override
	ModeOfTransport createTransport() {
		return new SeaTransport();
	}
}
