
class Semaphore {
    protected int value;
    protected Semaphore(int initial) {
        value = initial;
    }
    public void setValue(int value){
        this.value=value;
    }
    public synchronized void P(Device device) throws InterruptedException {

      // System.out.println("in P "+value);
        value--;
        if(value<0){
            System.out.println("(" + device.getdeviceName() + ")" + "(" + device.getType()+ ")" + "arrived and waiting");

            wait();
        }else{
            System.out.println("(" + device.getdeviceName() + ")" + "(" + device.getType() + ")" + "arrived");
        }
       
      
        
            
    }

    public synchronized void V( Device device) {
        value++;
        
        if (value <= 0)
            notify();
    }
}
