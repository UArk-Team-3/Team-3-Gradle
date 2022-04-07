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
            processData(data(receivedData).toString());
            System.out.println(new String(receivedData));
        }
    }

    public String processData(String data){
        // Grab the size of the codename arrays
        int numRedPlayers = View.blueCode.size();
        int numBluePlayers = View.redCode.size();

        // Split string on the colon
        String[] data2 = data.split(":");

        // Find the ID's of the players in event
        int player1 = Integer.parseInt(data2[0]);
        int player2 = Integer.parseInt(data2[1]);

        // Create a string to hold the action
        String action = "";

        // If blue player hits red player
        if(player1 <= 14){
            // Double check that player two is a red player
            if(player2 >= 15){
                // Grab blue player and red player code name; red is offset by 15
                if(player1 < numBluePlayers && ((player2 - 15) < numRedPlayers)){
                    action = View.blueCode.get(player1) + " hit " + View.redCode.get(player2 - 15);
                }
            }
        }

        // Same as above but if red player hits blue player
        if(player2 >= 15){
            if(player1 <= 14){
                if(((player2 - 15) < numRedPlayers) && player1 < numBluePlayers){
                    action = View.redCode.get(player2 - 15) + " hit " + View.blueCode.get(player1);
                }
            }
        }

        return action;

    }

    // A utility method to convert the byte array
	// data into a string representation.
	public static StringBuilder data(byte[] a)
	{
		if (a == null)
			return null;
		StringBuilder ret = new StringBuilder();
		int i = 0;
		while (a[i] != 0)
		{
			ret.append((char) a[i]);
			i++;
		}
		return ret;
	}
}

