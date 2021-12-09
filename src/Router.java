import java.util.ArrayList;

public class Router {

    ArrayList<String> connections = new ArrayList<String>();
    int NumOfConnections;
    private int ptr = 0;

    Semaphore semaphore = new Semaphore(NumOfConnections);

    public Router(int numOfConnections) {
        NumOfConnections = numOfConnections;
        semaphore.setValue(NumOfConnections);
        for (int i = 1; i <= NumOfConnections; i++) {
            connections.add("connection" + i);
        }
    }

    public int getNumOfConnections() {
        return NumOfConnections;
    }

    public void setNumOfConnections(int numOfConnections) {
        NumOfConnections = numOfConnections;
    }
    public String getConnectionPlace(Device device){
        String connectionPlace;
        connectionPlace = connections.get(ptr);
        ptr = (ptr + 1) % NumOfConnections;
        return connectionPlace;
    }

    public void occupy(Device device) throws InterruptedException {
        this.semaphore.P(device);
        System.out.println(device.getThisConn() +": "+ device.getdeviceName() +" Occupied");

    }

    public void release(Device device) {
        semaphore.V(device);
    }

    
}
