import java.util.HashMap;
import java.util.Map;

class ParkingLot {
    private Map<VehicleType, ParkingSpot[]> parkingSpots;

    public ParkingLot(int motorcycleSpots, int compactCarSpots, int regularCarSpots, int vanSpots) {
        parkingSpots = new HashMap<>();

        parkingSpots.put(VehicleType.MOTORCYCLE, new ParkingSpot[motorcycleSpots]);
        parkingSpots.put(VehicleType.CAR, new ParkingSpot[compactCarSpots + regularCarSpots]);
        parkingSpots.put(VehicleType.VAN, new ParkingSpot[vanSpots]);

        initializeParkingSpots();
    }

    private void initializeParkingSpots() {
        for (ParkingSpot[] spots : parkingSpots.values()) {
            for (int i = 0; i < spots.length; i++) {
                spots[i] = new ParkingSpot();
            }
        }
    }

    public int getRemainingSpots() {
        int remaining = 0;
        for (ParkingSpot[] spots : parkingSpots.values()) {
            for (ParkingSpot spot : spots) {
                if (!spot.isOccupied()) {
                    remaining++;
                }
            }
        }
        return remaining;
    }

    public int getTotalSpots() {
        int total = 0;
        for (ParkingSpot[] spots : parkingSpots.values()) {
            total += spots.length;
        }
        return total;
    }

    public boolean isFull() {
        return getRemainingSpots() == 0;
    }

    public boolean isEmpty() {
        return getRemainingSpots() == getTotalSpots();
    }

    public boolean isSpotFull(VehicleType vehicleType) {
        for (ParkingSpot spot : parkingSpots.get(vehicleType)) {
            if (!spot.isOccupied()) {
                return false;
            }
        }
        return true;
    }

    public int getOccupiedVanSpots() {
        int occupiedSpots = 0;
        for (ParkingSpot spot : parkingSpots.get(VehicleType.VAN)) {
            if (spot.isOccupied()) {
                occupiedSpots++;
            }
        }
        int occupiedRegularSpots = 0;
        for (ParkingSpot spot : parkingSpots.get(VehicleType.CAR)) {
            if (!spot.isOccupied()) {
                occupiedRegularSpots++;
            }
        }
        return occupiedSpots + occupiedRegularSpots / 3;
    }

    public void parkVehicle(VehicleType vehicleType) {
        switch (vehicleType) {
            case MOTORCYCLE: {
                boolean isParked = false;
                for (ParkingSpot spot : parkingSpots.get(vehicleType)) {
                    if (!spot.isOccupied()) {
                        spot.occupy();
                        isParked = true;
                        break;
                    }
                }
                if (!isParked) {
                    for (ParkingSpot[] spots : parkingSpots.values()) {
                        for (ParkingSpot spot : spots) {
                            if (!spot.isOccupied()) {
                                spot.occupy();
                                break;
                            }
                        }
                    }
                }
                break;
            }
            case CAR: {
                for (ParkingSpot spot : parkingSpots.get(vehicleType)) {
                    if (!spot.isOccupied()) {
                        spot.occupy();
                        break;
                    }
                }
                break;
            }
            case VAN: {
                boolean isParked = false;
                for (ParkingSpot spot : parkingSpots.get(vehicleType)) {
                    if (!spot.isOccupied()) {
                        spot.occupy();
                        isParked = true;
                        break;
                    }
                }
                if (!isParked) {
                    for (int i = 0; i < parkingSpots.get(VehicleType.CAR).length; i += 3) {
                        boolean isOccupied = false;
                        for (int j = 0; j < 3; j++) {
                            if (i + j < parkingSpots.get(VehicleType.CAR).length &&
                                    parkingSpots.get(VehicleType.CAR)[i + j].isOccupied()) {
                                isOccupied = true;
                                break;
                            }
                        }
                        if (!isOccupied) {
                            for (int j = 0; j < 3; j++) {
                                if (i + j < parkingSpots.get(VehicleType.CAR).length) {
                                    parkingSpots.get(VehicleType.CAR)[i + j].occupy();
                                }
                            }
                            break;
                        }
                    }
                }
                break;
            }
            default:
                break;
        }

    }
}