package travelDS.bus;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.FileInputStream;
import travelDS.bus.travelDSGrpc.travelDSImplBase;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Properties;

//bus server class
public class busServer extends travelDSImplBase{

    public static void main(String[] args) throws IOException, InterruptedException {
        busServer server = new busServer();
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
    public Properties getProperties(){
        Properties pt = null;
        try (InputStream input = new FileInputStream("src/main/resources/properties/bus.properties")) {
            pt = new Properties();
            pt.load(input);
            System.out.println("Service properties...");
            System.out.println("\t service_description: " + pt.getProperty("service_description"));
            System.out.println("\t service_type: " + pt.getProperty("service_type"));
            System.out.println("\t service_name: " + pt.getProperty("service_name"));
            System.out.println("\t service_port: " + pt.getProperty("service_port"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return pt;

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

}
