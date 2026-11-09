

public class RoadTransport implements ModeOfTransport {

    @Override
    public RoadTransportResponse transport() {
        String message  = "Here we are using the road to get the goods there";
        RoadTransportResponse res = new RoadTransportResponse();
        res.setValue(message);
        return res;
    }
}