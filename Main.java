public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(10, 10, 20, 5);

        System.out.println("Remaining Spots: " + parkingLot.getRemainingSpots());
        System.out.println("Total Spots: " + parkingLot.getTotalSpots());
        System.out.println("Is Full: " + parkingLot.isFull());
        System.out.println("Is Empty: " + parkingLot.isEmpty());

        parkingLot.parkVehicle(VehicleType.MOTORCYCLE);
        parkingLot.parkVehicle(VehicleType.CAR);
        parkingLot.parkVehicle(VehicleType.VAN);

        System.out.println("Remaining Spots: " + parkingLot.getRemainingSpots());
        System.out.println("Total Spots: " + parkingLot.getTotalSpots());
        System.out.println("Is Full: " + parkingLot.isFull());
        System.out.println("Is Empty: " + parkingLot.isEmpty());
        System.out.println("Is Motorcycle Spot Full: " + parkingLot.isSpotFull(VehicleType.MOTORCYCLE));
        System.out.println("Occupied Van Spots: " + parkingLot.getOccupiedVanSpots());
    }
}