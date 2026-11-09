

public class ModeOfTransportFactory {

	public  ModeOfTransport createTransport(String transportType) {
		ModeOfTransport modeOfTransport = null;
		if(transportType.equalsIgnoreCase("sea")) {
			modeOfTransport = new SeaTransport();
		}
		else if(transportType.equalsIgnoreCase("road")) {
			modeOfTransport = new RoadTransport();
		}
		else {
			throw new IllegalArgumentException("unknow transport mode   ");
		}
		return modeOfTransport;
	}
}
