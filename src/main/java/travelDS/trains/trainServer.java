package travelDS.trains;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import org.apache.commons.lang3.ArrayUtils;
import travelDS.trains.travelDSGrpc.travelDSImplBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Properties;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

//train server class
public class trainServer extends travelDSImplBase {

    static int[] trains = {3,67,43,1,18};


    public static void main(String[] args) throws IOException, InterruptedException {

        trainServer server = new trainServer();
        Properties prop = server.getProperties();
        server.register(prop);
        int port = Integer.valueOf(prop.getProperty("service_port"));

        try {
            //creating the server
            Server servers = ServerBuilder.forPort(port).addService(server).build().start();
            System.out.println("Server started, awaiting RPC calls...");
            servers.awaitTermination();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public Properties getProperties() {
        Properties p = null;
        try (InputStream input = new FileInputStream("src/main/resources/properties/train.properties")) {
            p = new Properties();
            p.load(input);
            System.out.println("Service properties...");
            System.out.println("\t service_description: " + p.getProperty("service_description"));
            System.out.println("\t service_type: " + p.getProperty("service_type"));
            System.out.println("\t service_name: " + p.getProperty("service_name"));
            System.out.println("\t service_port: " + p.getProperty("service_port"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return p;

    }

    public void register(Properties paper) throws IOException, InterruptedException {
        //service is discoverable
        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

        String service_type = paper.getProperty("service_type");
        String service_name = paper.getProperty("service_name");
        String service_description_properties = paper.getProperty("service_description");
        int service_port = Integer.valueOf(paper.getProperty("service_port"));

        ServiceInfo serviceInfo = ServiceInfo.create(service_type, service_name, service_port,
                service_description_properties);

        //final register
        jmdns.registerService(serviceInfo);
        System.out.printf("registrering service with type %s and name %s \n", service_type, service_name);
        Thread.sleep(1000);
    }

    @Override
    //delete bus request
    public void deleteBus(trainNumber request, StreamObserver<trainDelete> responseObserver) {

        int trainrequest = Integer.parseInt(request.getTrainNumber());

        for (int i = 0; i < trains.length; i++) {
            if (trainrequest == trains[i]) {
                //removing trains from system
                trains = ArrayUtils.remove(trains, i);
                trainDelete reply = trainDelete.newBuilder().setTrainDelete("Positive").build();
                responseObserver.onNext(reply);
                break;
            } else {
                trainDelete reply = trainDelete.newBuilder().setTrainDelete("Negitive").build();
                responseObserver.onNext(reply);
                break;
            }
        }
        responseObserver.onCompleted();
    }

    @Override
    //get amount of trains
    public void seeBus (trainSpecific request, StreamObserver<trainAmount> responseObserver){
        trainAmount reply = trainAmount.newBuilder().setTrainAmount(String.valueOf(trains)).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    //Is train Sold Out or not
    public void getTimetable(trainNumber request, StreamObserver<trainTimetable> responseObserver){
        trainTimetable reply = trainTimetable.newBuilder().setTrainTimetable("Sold Out").build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}

