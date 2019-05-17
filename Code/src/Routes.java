public class Routes {

    private String source;
    private String destination;
    private int distance;

    public Routes(String origen, String destino, int distancia) {
        this.source = origen;
        this.destination = destino;
        this.distance = distancia;
    }
    public void setSource(String source) {
        this.source = source;
    }

    public String getSource() {
        return source;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public String toString() {
        return " Origen: " + source + " ; Destino: " + destination + " ; Distancia: " + distance + " km" ;
    }
}
