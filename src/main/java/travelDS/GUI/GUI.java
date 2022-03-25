package travelDS.GUI;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import travelDS.trains.trainDelete;
import travelDS.trains.travelDSGrpc;
import travelDS.trains.trainNumber;
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
        ManagedChannel channe2 = ManagedChannelBuilder.forAddress(host, 50052).usePlaintext().build();
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
        JTextField t;
        //JButton getTrainNumberBtn = new JButton("Get train Number");
        //JButton trainAmountBtn = new JButton("Amount of trains out on route");
        JButton deleteTrainBtn = new JButton("Delete train from route");
        t = new JTextField(16);
        deleteTrainBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hello = "hi";
                trainNumber request = trainNumber.newBuilder().setTrainNumber(hello).build();
                traveldsstub.deleteBus(request);
            }
        });
        deleteTrainBtn.setSize(10,10);
        frame.add(t);
        frame.add(deleteTrainBtn);
    }

}
