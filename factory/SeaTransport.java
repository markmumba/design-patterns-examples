

public class SeaTransport implements ModeOfTransport {

	@Override
	public SeaTransportResponse transport() {
		String message = "Here we will be moving the goods by sea";
		SeaTransportResponse resp  = new SeaTransportResponse();
		resp.setValue(message);
		return resp;
	}

	@Override
	public String name() {
		return "Ship";
	}

	@Override
	public int capacityTonnes() {
		return 5000;
	}

	@Override
	public double costPerKm() {
		return 15.0;
	}

	@Override
	public String book() {
		return "Container slot booked at Mombasa port";
	}
}
