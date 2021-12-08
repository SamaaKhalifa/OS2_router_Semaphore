import javax.sound.sampled.SourceDataLine;

class semaphore {
    protected int value;
    protected semaphore(int initial) {
        value = initial;
    }
    public void setValue(int value){
        this.value=value;
    }
    public synchronized void P() {
      //  System.out.println("in P "+value);
        value--;
       // System.out.println("after "+value);
        if (value < 0)
            try {
                wait();
            } catch (InterruptedException e) {
            }
    }

    public synchronized void V( ) {
        value++;
        //System.out.println( );
        if (value <= 0)
            notify();
    }
}
