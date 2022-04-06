package com.team3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

class DatagramServer {
    private DatagramSocket sender;
    private DatagramSocket receiver;

    DatagramServer(int receiverPort, int senderPort) throws Exception {
        // Create and assign ports for two DatagramSockets that will handle sending and
        // receiving data
        this.sender = new DatagramSocket(senderPort);
        this.receiver = new DatagramSocket(receiverPort);

        // Define IP address to send UDP packet to (currently the local machine)
        InetAddress address = InetAddress.getLocalHost();

        // Sample integer to send
        int sampleData = 2043;
        // Convert int to byte array
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.putInt(sampleData);
        // Create sample data packet to send
        DatagramPacket packetOut = new DatagramPacket(buffer.array(), buffer.array().length, address, receiverPort);

        // Sample data packet to receive (idk how large the data will be yet)
        byte[] dataIn = new byte[4];
        DatagramPacket packetIn = new DatagramPacket(dataIn, dataIn.length);

        // Testing if data is even being received by the port
        this.sender.send(packetOut);
        this.receiver.receive(packetIn);

        // Convert byte arrays back to integers to see if the data was sent properly
        ByteBuffer packetOutBuffer = ByteBuffer.allocate(4);
        packetOutBuffer.put(packetOut.getData());
        packetOutBuffer.rewind();
        System.out.println("[+] Data sent from sender socket: "+ packetOutBuffer.getInt());

        ByteBuffer packetInBuffer = ByteBuffer.allocate(4);
        packetInBuffer.put(packetIn.getData());
        packetInBuffer.rewind();
        System.out.println("[+] Data received by receiver socket: " + packetInBuffer.getInt());
    }
}