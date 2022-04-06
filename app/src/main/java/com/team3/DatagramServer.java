package com.team3;

import java.net.DatagramSocket;
import java.net.SocketException;

class DatagramServer{
    private DatagramSocket receiver;
    private DatagramSocket sender;
    
    DatagramServer(int receiverPort, int senderPort)
    {
        try {
            this.receiver = new DatagramSocket(receiverPort);
        } catch (SocketException exception) {
            System.err.println("[-] Receiver socket not created due to a network error:");
            exception.printStackTrace();
        }
        
        try {
            this.sender = new DatagramSocket(senderPort);
        } catch (SocketException exception) {
            System.err.println("[-] Sender socket not created due to a network error:");
            exception.printStackTrace();
        }
    }
}