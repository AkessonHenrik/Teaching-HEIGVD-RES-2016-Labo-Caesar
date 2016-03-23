package ch.heigvd.res.caesar.protocol;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
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

    public static String getDecodedMessage(byte[] messageToDecode) throws UnsupportedEncodingException {
        byte offset = messageToDecode[0];
        byte[] messageBytes = Arrays.copyOfRange(messageToDecode, 1, messageToDecode.length);
        for (int i = 0; i < messageBytes.length; i++) {
            messageBytes[i] -= offset;
        }
        return new String(messageBytes, "UTF-8");
    }

    public byte[] getEncodedMessage() {
        offset = (byte) new Random().nextInt();
        byte[] messageBytes = message.getBytes();
        int encodedMessageLength = message.getBytes().length;
        byte[] encodedMessage = new byte[encodedMessageLength + 1];
        encodedMessage[0] = offset;
        for (int i = 1; i < encodedMessage.length; i++) {
            encodedMessage[i] = (byte) (messageBytes[i - 1] + offset);
        }
        return encodedMessage;
    }

}
