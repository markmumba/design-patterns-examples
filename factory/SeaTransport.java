

public class SeaTransport implements ModeOfTransport {

	@Override
	public SeaTransportResponse transport() {
		String message = "Here we will be moving the goods by sea";
		SeaTransportResponse resp  = new SeaTransportResponse();
		resp.setValue(message);
		return resp;
	}
}