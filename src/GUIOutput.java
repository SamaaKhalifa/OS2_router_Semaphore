import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class GUIOutput extends JFrame {

    JTextArea textArea;
    JButton solveButton;

    public GUIOutput() {
        this.setTitle("Router Semaphore");
        setBackground(Color.PINK);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setSize(300, 300);

        textArea = new JTextArea();

        solveButton = new JButton("Simulate");
        solveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                solveButton.setEnabled(false);
                try {
                    solveMysteryOfTheUniverse();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        this.getContentPane().add(solveButton, BorderLayout.NORTH);
        this.getContentPane().add(new JScrollPane(textArea));

    }

    public void solveMysteryOfTheUniverse() throws IOException {
        (new MysteryWorker()).execute();
    }

    class MysteryWorker extends SwingWorker<String, Object> {
        String[]arr;
        String out=""; int i=0;
        String currentDirectory = System.getProperty("user.dir");
        File f = new File(currentDirectory + "\\" + "logFile.txt");
        MysteryWorker() throws IOException {
            BufferedReader br2 = new BufferedReader(new FileReader(f));
            String st;
            String input = "";
            while ((st = br2.readLine()) != null) {
                input = input+"QQQQ" +st ;

            }
            arr=input.split("QQQQ");
        }
        @Override
        public String doInBackground() {
            if (i>=arr.length) {
                solveButton.setEnabled(true);
                return out;
            }
            else {
                try {
                    Thread.currentThread().sleep(555);
                } catch (InterruptedException ignore) {}
                out+=arr[i++]+"\n";
                textArea.setText(out);
                return doInBackground();
            }

        }

        @Override
        protected void done() {
            try {
                textArea.setText(get());
            } catch (Exception ignore) {}
        }
    }

}