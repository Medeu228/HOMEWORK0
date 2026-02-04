package edu.narxoz.galactic.edu.narxoz.galactic.drones;

public class HeavyDrone extends Drone {

    public HeavyDrone(String id, double maxPayloadKg) {
        super(id, maxPayloadKg);
    }

    @Override
    public double speedKmPerMin() {
        return 10.0;
    }
}
