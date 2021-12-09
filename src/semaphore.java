import java.io.IOException;

class Semaphore {
    protected int value;
    protected Semaphore(int initial) {
        value = initial;
    }
    public void setValue(int value){
        this.value=value;
    }
    
    public synchronized void P(Device device) throws InterruptedException, IOException {
      // System.out.println("in P "+value);
        value--;
        if(value<0){
            SingleFile file =new SingleFile("(" + device.getdeviceName() + ")" + "(" + device.getType()+ ")" + "arrived and waiting");
            System.out.println("(" + device.getdeviceName() + ")" + "(" + device.getType()+ ")" + "arrived and waiting");

            wait();
        }else{
            SingleFile file =new SingleFile("(" + device.getdeviceName() + ")" + "(" + device.getType() + ")" + "arrived");
            System.out.println("(" + device.getdeviceName() + ")" + "(" + device.getType() + ")" + "arrived");
        }
            
    }

    public synchronized void V( Device device) {
        value++;
        
        if (value <= 0)
            notify();
    }
}
