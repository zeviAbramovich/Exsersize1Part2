public class Train implements Comparable, Movable {
    public static final int PASSENGER_LIMIT = 500;
    public static final int STATION_LIMIT = 5;
    int licenceNumber;
    Location source, destination;
    int numberOfStations;
    int currentStation;
    int maximalPassenger;

    public Train(int id, Location src, Location dst, int numOfStations, int maxPassengers) {
        licenceNumber = id;
        source = src;
        destination = dst;
        numberOfStations = numOfStations;
        currentStation = 0;
        maximalPassenger = maxPassengers;
    }

    @Override
    public String toString() {
        return String.format("licence = %d, source = %s, destination = %s, station = %d, maxPassengers = %d",
                licenceNumber, source, destination, currentStation, maximalPassenger);
    }

    @Override
    public String getType() {
        return "Train";
    }

    @Override
    public int getId() {
        return licenceNumber;
    }

    @Override
    public Location getSource() {
        return source;
    }

    @Override
    public Location getDestination() {
        return destination;
    }

    @Override
    public String getCurrentLocation() {
        if (currentStation == 0)
            return source.toString();
        return "station " + currentStation + " between " + source.toString() + " and " + destination.toString();
    }

    @Override
    public void move() {
        currentStation += 1;
        if (currentStation == numberOfStations) {
            Location temp = source;
            source = destination;
            destination = temp;
            currentStation = 0;
        }
    }

    @Override
    public int compareTo(Object o) {
        Train train = (Train) o;
        return this.maximalPassenger - train.maximalPassenger;
    }
}
