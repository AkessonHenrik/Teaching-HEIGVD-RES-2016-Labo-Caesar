package ch.heigvd.res.caesar.server;

import ch.heigvd.res.caesar.client.*;
import ch.heigvd.res.caesar.protocol.Protocol;
import com.sun.org.apache.regexp.internal.RE;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Olivier Liechti (olivier.liechti@heig-vd.ch)
 * modified by: Henrik Akesson
 */
public class CaesarServer {

    private static final Logger LOG = Logger.getLogger(CaesarServer.class.getName());
    int port;

    private CaesarServer() {
        this.port = Protocol.PORT;
    }


    public void serveClients() {
        LOG.info("Starting the Receptionist Worker on a new thread...");
        new Thread(new ReceptionistWorker()).start();
    }

    /**
     * This inner class implements the behavior of the "receptionist", whose
     * responsibility is to listen for incoming connection requests. As soon as a
     * new client has arrived, the receptionist delegates the processing to a
     * "servant" who will execute on its own thread.
     */





    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tH:%1$tM:%1$tS::%1$tL] Server > %5$s%n");
        LOG.info("Caesar server starting...");
        LOG.info("Protocol constant: " + Protocol.PORT);
        ReceptionistWorker receptionist = new ReceptionistWorker();
        receptionist.run();
    }

}
