package com.team3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

class DatagramServer {
    private DatagramSocket receiver;

    DatagramServer(int receiverPort, int senderPort) throws Exception {
        // Create a receiver for, well, receiving packets
        this.receiver = new DatagramSocket(receiverPort);

        while (true) {
            // Sample data packet to receive
            byte[] receivedData = new byte[32];
            DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);

            // Testing if data is being received by our socket
            this.receiver.receive(receivedPacket);
            System.out.println(new String(receivedData));
        }
    }
}