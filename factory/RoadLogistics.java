
public class RoadLogistics extends Logistics {


	@Override
	ModeOfTransport createTransport() {
		return new RoadTransport();
	}
}
