
// The SAME 5-step delivery workflow as Logistics.planDelivery(),
// written the old way: no Logistics, no shared ModeOfTransport variable.
// The workflow holds concrete classes, so EVERY step has to ask "which one?".
public class OldWayDelivery {

    static void planDelivery(String transportType, int tonnes, int km) {

        RoadTransport road = null;
        SeaTransport sea = null;

        if (transportType.equalsIgnoreCase("road")) {
            road = new RoadTransport();
            log("Selected transport: " + road.name());
        } else if (transportType.equalsIgnoreCase("sea")) {
            sea = new SeaTransport();
            log("Selected transport: " + sea.name());
        } else {
            System.out.println("The mode of transport " + transportType + " is not yet available");
            return;
        }

        int capacity;
        if (road != null) {
            capacity = road.capacityTonnes();
        } else {
            capacity = sea.capacityTonnes();
        }
        int trips = (int) Math.ceil((double) tonnes / capacity);
        log(tonnes + " tonnes needs " + trips + " trip(s) (capacity " + capacity + "t)");

        double costPerKm;
        if (road != null) {
            costPerKm = road.costPerKm();
        } else {
            costPerKm = sea.costPerKm();
        }
        double cost = trips * km * costPerKm;
        log("Cost: " + trips + " trip(s) x " + km + "km x " + costPerKm + "/km = " + cost);

        if (road != null) {
            log(road.book());
        } else {
            log(sea.book());
        }

        String message;
        if (road != null) {
            message = road.transport().getValue();
        } else {
            message = sea.transport().getValue();
        }
        log("Dispatched: " + message);

        // Adding AirTransport = edit ALL FIVE if-chains above,
        // plus declare a third `AirTransport air = null;` variable.
    }

    private static void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
