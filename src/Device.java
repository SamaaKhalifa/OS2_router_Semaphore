import java.util.Random;

import static java.lang.Thread.sleep;

class Device extends Thread{
    private String name;
    private String type;
    private Router router;
    private String thisConn;
    Random random = new Random();
    public Device(String name,String type,Router router) {
        this.name = name;
        this.type = type;
        this.router = router;
    }

    public void setRouter(Router router) {this.router = router;}

   /* public void setName(String name) {
        this.name = name;
    }*/

    public void setType(String type) {
        this.type = type;
    }

   /* public String getName() {
        return name;
    }*/

    public String getType() {
        return type;
    }

    public Router getRouter() {return router;}

    public void connect() throws InterruptedException {

        thisConn=router.occupy();
        //System.out.println("this connection is: "+thisConn);
        if (router.elements.value>=0){
            System.out.println("("+name+")"+"("+type+")"+"arrived");
            System.out.println(thisConn+": "+name+" Occupied");
            this.performOnlineActivity();
        }else {
            System.out.println("("+name+")"+"("+type+")"+"arrived and waiting");
            thisConn=router.occupy();
            System.out.println(thisConn+": "+name+" Occupied");
            this.performOnlineActivity();
        }
    }
    public void performOnlineActivity() throws InterruptedException {
        System.out.println(thisConn+": "+name+" performs online activity");
        sleep((random.nextInt(2)+1)*1000);
    }
    public void logout(){
        System.out.println(thisConn+": "+name+" Logged out");
        router.release(thisConn);
    }


    @Override
    public void run() {
        try {
            this.connect();
            this.logout();
            this.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}