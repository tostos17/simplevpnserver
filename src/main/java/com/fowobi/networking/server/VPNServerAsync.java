package com.fowobi.networking.server;

import com.fowobi.networking.util.EncryptionUtil;
import com.fowobi.networking.util.PropertyReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;

public class VPNServerAsync {
    private static final int PORT = 8888;
    private static final Logger log = LoggerFactory.getLogger(VPNServer.class);

    public void startServer() throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            log.info("VPN Server is running on port: {}", PORT);

            while(true) {
                Socket socket = serverSocket.accept();
                log.info("Client Connected");

                String encodedKey = PropertyReader.getPropertyValue("secret.key");
                log.info("secret key::: {}", encodedKey);
                byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
                SecretKey secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");

                ClientHandler clientHandler = new ClientHandler(socket, secretKey);
                clientHandler.run();
//                handleClient(socket, secretKey);
            }
        }
    }

    private class ClientHandler implements Runnable {

        private final Socket socket;
        private final SecretKey secretKey;

        public ClientHandler(Socket socket, SecretKey secretKey) {
            this.socket = socket;
            this.secretKey = secretKey;
        }

        @Override
        public void run() {
            try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                String message;
//            log.info("captured message: {}", in.readLine());

                while((message = in.readLine()) != null) {
                    String decryptedMessage = EncryptionUtil.decrypt(Base64.getDecoder().decode(message), secretKey);
                    log.info("Message from client: {}", decryptedMessage);
                    byte[] encryptedResponse = EncryptionUtil.encrypt("Echo: " + decryptedMessage, secretKey);
//                out.println(new String(encryptedResponse));
                    out.println(Base64.getEncoder().encodeToString(encryptedResponse));
//                out.println("world");
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    log.error(e.getMessage());
                }
            }
        }
    }

//    private static void handleClient(Socket socket, SecretKey secretKey) {
//
//        try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
//            String message;
////            log.info("captured message: {}", in.readLine());
//
//            while((message = in.readLine()) != null) {
//                String decryptedMessage = EncryptionUtil.decrypt(Base64.getDecoder().decode(message), secretKey);
//                log.info("Message from client: {}", decryptedMessage);
//                byte[] encryptedResponse = EncryptionUtil.encrypt("Echo: " + decryptedMessage, secretKey);
////                out.println(new String(encryptedResponse));
//                out.println(Base64.getEncoder().encodeToString(encryptedResponse));
////                out.println("world");
//            }
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        } finally {
//            try {
//                socket.close();
//            } catch (IOException e) {
//                log.error(e.getMessage());
//            }
//        }
//    }
}
