

abstract class Logistics {

	// THE FACTORY METHOD: subclasses decide WHICH transport gets built.
	abstract ModeOfTransport createTransport();

	// THE WORKFLOW: written once, shared by every subclass.
	// It never names RoadTransport or SeaTransport, so there is no if-chain here.
	TransportResponse planDelivery(int tonnes, int km) {

		ModeOfTransport transport = createTransport();
		log("Selected transport: " + transport.name());

		int trips = (int) Math.ceil((double) tonnes / transport.capacityTonnes());
		log(tonnes + " tonnes needs " + trips + " trip(s) (capacity " + transport.capacityTonnes() + "t)");

		double cost = trips * km * transport.costPerKm();
		log("Cost: " + trips + " trip(s) x " + km + "km x " + transport.costPerKm() + "/km = " + cost);

		log(transport.book());

		TransportResponse response = transport.transport();
		log("Dispatched: " + response.getValue());

		return response;
	}

	private void log(String message) {
		System.out.println("[LOG] " + message);
	}
}
