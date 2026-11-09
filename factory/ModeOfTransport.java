
public interface ModeOfTransport {
    TransportResponse transport();

    // Details the delivery workflow needs. Each transport answers differently.
    String name();
    int capacityTonnes();
    double costPerKm();
    String book();
}
