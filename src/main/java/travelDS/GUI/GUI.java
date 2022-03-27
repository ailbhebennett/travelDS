package travelDS.GUI;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import sun.security.x509.IPAddressName;
import travelDS.trains.*;
import travelDS.trains.travelDSGrpc.travelDSBlockingStub;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import travelDS.trains.travelDSGrpc.*;
import travelDS.trains.trainNumber;
import travelDS.trains.travelDSGrpc.travelDSStub;


public class GUI {
    public JFrame frame;
    public static ServiceInfo serviceinfo;
    public static travelDSBlockingStub traveldsstub;
    public static void main (String[]args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    GUI window = new GUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
}
    public GUI() throws IOException, InterruptedException {
        String service_type = "_http._tcp.local.";
        discoveryService(service_type);
        String host = serviceinfo.getHostAddresses()[0];
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, 50053).usePlaintext().build();
        ManagedChannel channel2 = ManagedChannelBuilder.forAddress(host, 50052).usePlaintext().build();
        traveldsstub = travelDSGrpc.newBlockingStub(channel);
        intializer();
    }

    public void intializer(){
        frame = new JFrame();
        frame.setTitle("Client - Service Controller");
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui(frame);
    }

    public void discoveryService(String service_type) throws IOException, InterruptedException {
        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
        jmdns.addServiceListener(service_type, new MyServiceListener());
        Thread.sleep(10000);
        jmdns.close();
    }

    private static class MyServiceListener implements ServiceListener {
        public void serviceAdded(ServiceEvent event) {
            System.out.println("Service added: " + event.getInfo());
        }

        public void serviceRemoved(ServiceEvent event) {
            System.out.println("Service removed: " + event.getInfo());
        }

        public void serviceResolved(ServiceEvent event) {
            System.out.println("Service resolved: " + event.getInfo());
            serviceinfo = event.getInfo();
        }
    }

    //buttons
    public void ui(JFrame frame){
        //train Buttons
        JButton getTrainNumberBtn = new JButton("Get train Number");
        JButton trainAmountBtn = new JButton("Amount of trains out on route");
        JButton deleteTrainBtn = new JButton("Delete train from route");
        // train text fields
        JTextField getTrainNumberTf = new JTextField();
        JTextField trainAmountTf = new JTextField();
        JTextField deleteTrainTf = new JTextField();

        //adding to the GUI
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(deleteTrainTf);
        panel.add(deleteTrainBtn);
        panel.add(getTrainNumberTf);
        panel.add(getTrainNumberBtn);
        panel.add(trainAmountTf);
        panel.add(trainAmountBtn);
        frame.add(panel);

        getTrainNumberBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int request = Integer.parseInt(getTrainNumberTf.getText());
                    trainNumber requests = trainNumber.newBuilder().setTrainNumber(getTrainNumberTf.getText()).build();
                    trainTimetable reply =  traveldsstub.getTimetable(requests);
                    JOptionPane.showMessageDialog(frame, reply.getTrainTimetable());

                }
                catch(Exception yes){
                    JOptionPane.showMessageDialog(frame, "Only Numbers");
                }
            }
        });


        trainAmountBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //get amount of trains
                trainSpecific request = trainSpecific.newBuilder().setTrainSpecific("Hi").build();
                trainAmount reply = traveldsstub.seeBus(request);
                JOptionPane.showMessageDialog(frame, reply.getTrainAmount());

            }

        });



        deleteTrainBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //reading from the TF
                try{
                    //if non convertable string is entered it will fail to convert and not send message
                    int number = Integer.parseInt(deleteTrainTf.getText());
                    trainNumber request = trainNumber.newBuilder().setTrainNumber(deleteTrainTf.getText()).build();
                    trainDelete hellos = traveldsstub.deleteBus(request);
                    JOptionPane.showMessageDialog(frame, hellos.getTrainDelete());
                }
                //error handling
                catch(Exception yes){
                    JOptionPane.showMessageDialog(frame, "Only Numbers");
                }

            }


        });
    }

}
