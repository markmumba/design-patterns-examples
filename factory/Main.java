import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Understanding the factory pattern");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your transport type (road / sea)");
        String transportType = scanner.nextLine();
        scanner.close();

        oldWay(transportType);
        simpleFactory(transportType);
        factoryMethod(transportType);
        bigWorkflowComparison(transportType);
    }

    // Shipment used by the workflow examples.
    static final int TONNES = 50;
    static final int KM = 300;

    // =====================================================================
    // 1. OLD WAY: no factory
    // Main creates the concrete classes itself with `new`.
    // Main knows about RoadTransport AND SeaTransport.
    // Adding AirTransport means editing this method.
    // =====================================================================
    static void oldWay(String transportType) {
        System.out.println("\n--- 1. Old way (no factory) ---");

        ModeOfTransport modeOfTransport;

        if (transportType.equalsIgnoreCase("sea")) {
            modeOfTransport = new SeaTransport();
        } else if (transportType.equalsIgnoreCase("road")) {
            modeOfTransport = new RoadTransport();
        } else {
            System.out.println("The mode of transport " + transportType + " is not yet available");
            return;
        }

        TransportResponse response = modeOfTransport.transport();
        System.out.println(response.getValue());
    }

    // =====================================================================
    // 2. SIMPLE FACTORY
    // The if/else moved into ModeOfTransportFactory.
    // Main no longer mentions any concrete transport class.
    // BUT: adding AirTransport still means editing the factory's if-chain
    // (breaks Open/Closed).
    // =====================================================================
    static void simpleFactory(String transportType) {
        System.out.println("\n--- 2. Simple factory ---");

        ModeOfTransportFactory factory = new ModeOfTransportFactory();

        try {
            ModeOfTransport modeOfTransport = factory.createTransport(transportType);
            TransportResponse response = modeOfTransport.transport();
            System.out.println(response.getValue());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // =====================================================================
    // 3. FACTORY METHOD
    // Logistics (abstract creator) declares createTransport().
    // RoadLogistics / SeaLogistics each override it and return ONE transport.
    // No if-chain inside the creators: the subclass IS the decision.
    // The only `if` left is here at the entry point, picking WHICH creator.
    // Adding AirTransport = add AirTransport + AirLogistics; no existing
    // Logistics class is edited.
    // =====================================================================
    static void factoryMethod(String transportType) {
        System.out.println("\n--- 3. Factory method ---");

        Logistics logistics;

        if (transportType.equalsIgnoreCase("sea")) {
            logistics = new SeaLogistics();
        } else if (transportType.equalsIgnoreCase("road")) {
            logistics = new RoadLogistics();
        } else {
            System.out.println("The mode of transport " + transportType + " is not yet available");
            return;
        }

        // Main only talks to the abstract Logistics.
        // planDelivery() calls createTransport() -> subclass decides what gets built.
        TransportResponse response = logistics.planDelivery(TONNES, KM);
        System.out.println(response.getValue());
    }

    // =====================================================================
    // 4. BIG WORKFLOW: old way vs factory method, side by side
    // Same 5 steps (create, trips, cost, booking, dispatch), same output.
    //
    //   Old way (OldWayDelivery):        5 if-chains inside the workflow
    //   Factory method (Logistics):      0 if-chains inside the workflow
    //                                    + 1 at the entry point (above)
    //
    // Adding AirTransport:
    //   Old way        -> edit 5 if-chains in OldWayDelivery
    //   Factory method -> add AirTransport + AirLogistics,
    //                     add 1 else-if at the entry point,
    //                     Logistics.planDelivery() is NOT touched
    // =====================================================================
    static void bigWorkflowComparison(String transportType) {
        System.out.println("\n--- 4. Same workflow, old way (compare with section 3's [LOG] lines) ---");
        OldWayDelivery.planDelivery(transportType, TONNES, KM);
    }
}
