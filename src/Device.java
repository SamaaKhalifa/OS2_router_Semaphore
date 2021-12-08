import java.util.Random;


class Device extends Thread {
    private String name;
    private String type;
    private Router router;
    private String thisConn;
    Random random = new Random();

    public Device(String name, String type, Router router) {
        this.name = name;
        this.type = type;
        this.router = router;
    }
    public String getdeviceName() {
        return name;
    }
  
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Router getRouter() {
        return router;
    }

    public void setRouter(Router router) {
        this.router = router;
    }

    public String getThisConn() {
        return thisConn;
    }
    public void setThisConn(String thisConn) {
        this.thisConn = thisConn;
    }


    public void connect() throws InterruptedException {
        thisConn = router.getConnectionPlace(this);
        this.router.occupy(this);

    }
    
    public void performOnlineActivity() throws InterruptedException {
        System.out.println(thisConn + ": " + name + " performs online activity");
        sleep((random.nextInt(2) + 1) * 1000);
    }
    
    public void logout() {
        System.out.println(thisConn + ": " + name + " Logged out");
        router.release(this);
    }
    
  
    @Override
    public void run() {
        try {
            this.connect();
            this.performOnlineActivity();
            this.logout();
            this.interrupt();;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String toString() {
        return "Device [name=" + name + ", type=" + type + "]";
    }
}