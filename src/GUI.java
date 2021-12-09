import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame {
    private JTextField noOfConnections;
    private JTextField noOfDevices;
    public GUI() {

            this.setBounds(100, 100, 1000, 800);
            this.getContentPane().setBackground(Color.PINK);
            this.setLocationRelativeTo(null);
            this.getContentPane().setLayout(null);
            this.setTitle("Router Semaphore");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ImageIcon img =new ImageIcon("C:src\\router.png");
            JLabel label = new JLabel("Welcome to GUI");
            label.setFont(new Font("Montserrat", Font.BOLD, 29));
            label.setBounds(50, 10, 1000, 100);
            this.setIconImage(img.getImage());
            this.getContentPane().add(label);
            this.setResizable(false);
            this.setVisible(true);

            JButton b1 = new JButton("Start");
            b1.setBounds(320, 522, 400, 50);
            b1.setBackground(new Color(	231, 84, 128));
            b1.setForeground(Color.white);
            b1.setFont(new Font("Montserrat", Font.PLAIN, 20));
            this.getContentPane().add(b1);
            b1.requestFocus();

            JButton b2 = new JButton("Stop");
            b2.setBounds(320, 580, 400, 50);
            b2.setBackground(new Color(	231, 84, 128));
            b2.setForeground(Color.white);
            b2.setFont(new Font("Montserrat", Font.PLAIN, 20));
            this.getContentPane().add(b2);
            b2.requestFocus();

            JLabel Connections = new JLabel("What is the number of WI-FI Connections?");
            Connections.setFont(new Font("Roboto", Font.PLAIN, 20));
            Connections.setBounds(50, 100, 550, 20);
            this.getContentPane().add(Connections);


            JLabel Devices = new JLabel("What is the number of devices Clients want to connect?");
            Devices.setFont(new Font("Roboto", Font.PLAIN, 20));
            Devices.setBounds(50, 200, 550, 20);
            this.getContentPane().add(Devices);

            JLabel NamesAndTypes = new JLabel("Name and type of device separated with white space");
            NamesAndTypes.setFont(new Font("Roboto", Font.PLAIN, 20));
            NamesAndTypes.setBounds(50, 300, 550, 20);
            this.getContentPane().add(NamesAndTypes);

            noOfConnections = new JTextField();
            noOfConnections.setBounds(550, 95, 330, 30);
            this.getContentPane().add(noOfConnections);
            noOfConnections.setColumns(10);
            noOfConnections.setVisible(true);
            noOfConnections.requestFocus();

            noOfDevices = new JTextField();
            noOfDevices.setBounds(550, 200, 320, 30);
            this.getContentPane().add(noOfDevices);
            noOfDevices.setColumns(10);
            noOfDevices.setVisible(true);
            noOfDevices.requestFocus();

            JTextArea NamesTextArea = new JTextArea();
            NamesTextArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
            NamesTextArea.setBounds(530, 293, 100, 225);
            NamesTextArea.setRows(100);
            this.getContentPane().add(NamesTextArea);
            NamesTextArea.requestFocus();

            JTextArea TypesTextArea = new JTextArea();
            TypesTextArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
            TypesTextArea.setBounds(700, 293, 100, 225);
            TypesTextArea.setRows(100);
            this.getContentPane().add(TypesTextArea);
            TypesTextArea.requestFocus();

            b2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            b1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String[] names = NamesTextArea.getText().split("\n");
                    String[] types = TypesTextArea.getText().split("\n");
                    ArrayList<Device> devices = new ArrayList<Device>();
                    Router router=new Router(Integer.parseInt(noOfConnections.getText()));
                    for (int i = 0; i < Integer.parseInt(noOfDevices.getText()); i++) {
                        devices.add(new Device(names[i],types[i],router));
                    }
                    for (int i=0;i<Integer.parseInt(noOfDevices.getText());i++){
                        devices.get(i).start();
                    }


                }
            });


    }
}