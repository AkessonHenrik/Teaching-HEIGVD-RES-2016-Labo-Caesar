package ch.heigvd.res.caesar.protocol;

import java.util.Random;

/**
 * @author Olivier Liechti
 */
public class Protocol {

    public static final int PORT = 2205;
    String message;
    byte offset;

    public Protocol(String message) {
        offset = (byte) new Random().nextInt();
        this.message = message;
    }

    public byte[] getEncodedMessage() {
        byte[] messageBytes = message.getBytes();
        int encodedMessageLength = message.getBytes().length;
        byte[] encodedMessage = new byte[encodedMessageLength+1];
        encodedMessage[0] = offset;
        for(int i = 1; i < encodedMessage.length; i++) {
            encodedMessage[i] = messageBytes[i-1];
        }
        return encodedMessage;
    }

}
