import java.util.ArrayList;
public class Router {

    ArrayList<String> connections =new ArrayList<String>();

    int NumOfConnections;
    semaphore spaces = new semaphore(0);
    semaphore elements =new semaphore(NumOfConnections);
    public Router(int numOfConnections) {
        NumOfConnections = numOfConnections;
        spaces.setValue(0);
        elements.setValue(NumOfConnections);
        for (int i=1;i<=NumOfConnections;i++){
            connections.add("connection"+i);
        }
    }
    private int inptr=0;
    private int outptr=0;
    public int getNumOfConnections() {
        return NumOfConnections;
    }
    public void setNumOfConnections(int numOfConnections) {
        NumOfConnections = numOfConnections;
    }


    public String occupy(){
        String value;
        elements.P();//wait
        value=connections.get(outptr);
        //connections.remove(outptr);
        outptr=(outptr+1)%NumOfConnections;
        // occupy
        spaces.V();//notify
        return value;
    }
    public void release(String value){
        spaces.P();
        connections.add(inptr,value);
        inptr = (inptr + 1) % NumOfConnections;
        elements.V();

    }

}
