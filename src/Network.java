import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class Network{
    
    
    public static void main(String[]args) throws InterruptedException, IOException {
        int choice;
        final String currentDirectory = System.getProperty("user.dir");
        while(true){
        Thread.currentThread().sleep(5000);
        System.out.println("1) Console Application 2)GUI 3)exit");
        Scanner sc= new Scanner(System.in);
        choice=sc.nextInt();

        if (choice == 1) {
        ArrayList<Device> devices = new ArrayList<Device>();
        System.out.println("What is the number of WI-FI Connections?");
        sc= new Scanner(System.in);
        int noCon=sc.nextInt();
        Router router=new Router(noCon);
        System.out.println("What is the number of devices Clients want to connect?");
        int noDev=sc.nextInt();
        Scanner scStr= new Scanner(System.in);
        String name, type;
        for (int i=0;i<noDev;i++){
                name=scStr.next();
                type=scStr.next();
                devices.add(new Device(name,type,router));
        }
       
        for (int i=0;i<noDev;i++) {
            devices.get(i).start();


        }

        }
        else if(choice==2) {
            GUI gui = new GUI();
        }
        else if(choice==3){
            System.out.println("Bye!");
            break;
        }

        else{
            System.out.println("You've entered wrong input!");
        }
        File f1=new File(currentDirectory + "\\" + "logFile.txt");
        f1.delete();
        }}

    }

