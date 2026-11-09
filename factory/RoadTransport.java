

public class RoadTransport implements ModeOfTransport {

    @Override
    public RoadTransportResponse transport() {
        String message  = "Here we are using the road to get the goods there";
        RoadTransportResponse res = new RoadTransportResponse();
        res.setValue(message);
        return res;
    }

    @Override
    public String name() {
        return "Truck";
    }

    @Override
    public int capacityTonnes() {
        return 20;
    }

    @Override
    public double costPerKm() {
        return 2.0;
    }

    @Override
    public String book() {
        return "Truck booked at the Nairobi depot";
    }
}
