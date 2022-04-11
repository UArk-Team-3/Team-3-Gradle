package com.team3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;

//Worked with Furqaan in-person while implmenting the following code. Feel free to verify with him about my participation

class DatagramServer {
    private DatagramSocket receiver;
    private DatagramSocket sender;
    private InetAddress broadcastAddress;

    DatagramServer(int receiverPort, int senderPort) throws Exception {
        this.receiver = new DatagramSocket(receiverPort);
        this.sender = new DatagramSocket(senderPort);
        this.broadcastAddress = InetAddress.getLocalHost();
    }

    protected void listen() throws Exception {
        while (true) {
            // Data packet specifications
            byte[] data = new byte[32];
            DatagramPacket packet = new DatagramPacket(data, data.length);

            // Listen for packet
            this.receiver.receive(packet);

            // Data validation after packet is received
            String strData = this.data(data).toString().replaceAll(" ", "");
            if (this.validate(strData)) {
                this.processData(strData);
                this.broadcast(Integer.parseInt(strData.split(":")[1]));
            }
        }
    }

    private void broadcast(int id) throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.putInt(id);

        DatagramPacket packet = new DatagramPacket(buffer.array(), buffer.array().length, this.broadcastAddress,
                this.sender.getLocalPort());

        this.sender.send(packet);
        System.out.println(
                "[+] '" + id + "' has been sent to " + this.broadcastAddress + " from port " + this.sender.getLocalPort());
    }

    private String processData(String data){
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

                    // Update the score of the player and team
                    View.blueScores[player1] += 10;
                    View.blueScore += 10;
                }
            }
        }

        // Same as above but if red player hits blue player
        else if(player1 >= 15){
            if(player2 <= 14){
                if(((player1 - 15) < numRedPlayers) && player2 < numBluePlayers){
                    action = View.redCode.get(player1 - 15) + " hit " + View.blueCode.get(player2);

                    // Update the score of the player an team
                    View.redScores[player1-15] += 10;
                    View.redScore += 10;
                }
            }
        }

        //System.out.println("action: " + action);
        //System.out.println("Blue Team Score: " + View.blueScore + " Red Team Score: " + View.redScore);
        return action;

    }

    // A utility method to convert the byte array
	// data into a string representation.
	private StringBuilder data(byte[] a)
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

    private boolean validate(String data) {
        // If input is empty
        if (data.isEmpty()) {
            System.out.println("[-] No value entered for input.");
            return false;
        }

        // If input does not have two distinct values
        String[] strInput = data.split(":");
        if (strInput.length != 2) {
            System.out.println("[-] Input '" + data + "' does not have two numerical values separated by ':'.");
            return false;
        }

        int[] intInput = new int[strInput.length];

        // If input is non-numeric
        try {
            for (int i = 0; i < strInput.length; i++) {
                intInput[i] = Integer.parseInt(strInput[i]);
            }
        } catch (NumberFormatException exception) {
            System.out.println("[-] Input '" + data + "' does not contain only numerical values or an integer is too large.");
            return false;
        }

        // If integer is not positive
        for (int i = 0; i < strInput.length; i++) {
            if (intInput[i] < 0) {
                System.out.println("[-] Integer '" + strInput[i] + "' is not positive.");
                return false;
            }
        }
    
        System.out.println("[+] Input '" + data + "' accepted.");
        return true;
    }
}

