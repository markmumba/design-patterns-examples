

abstract class Logistics {
	abstract ModeOfTransport createTransport();

	TransportResponse planDelivery() {
		return createTransport().transport();
	}
}
