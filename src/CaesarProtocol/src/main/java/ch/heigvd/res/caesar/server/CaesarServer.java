package ch.heigvd.res.caesar.server;

import ch.heigvd.res.caesar.client.*;
import ch.heigvd.res.caesar.protocol.Protocol;

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



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.setProperty("java.util.logging.SimpleFormatter.format", "[%1$tH:%1$tM:%1$tS::%1$tL] Server > %5$s%n");
        LOG.info("Caesar server starting...");
        LOG.info("Protocol constant: " + Protocol.A_CONSTANT_SHARED_BY_CLIENT_AND_SERVER);
    }

}
