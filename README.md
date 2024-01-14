# Parking Lot System

Implementing parking lot system in Java, using object-oriented principles.

## Additional Assumptions

- Compact spots and regular spots are subsections of car spots.
- A van can park in a single van spot or 3 regular spots.

## Features

- Parking spots for motorcycles, cars, and vans.
- Different types of parking spots for compact cars, regular cars, and vans.
- Methods to check remaining spots, total spots, and occupancy status.
- Support for parking and checking the occupancy of specific vehicle types.

## Class Structure

- `ParkingSpot.java`: Represents a parking spot.
- `ParkingLot.java`: Manages the parking lot and parking spots.
- `VehicleType.java`: Enum representing types of vehicles.

## Usage

To run the provided example:

1. Compile the Java files:

   ```bash
   cd parkinglot
   javac *.java
   ```

2. Run the main class:

   ```bash
   java Main
   ```
