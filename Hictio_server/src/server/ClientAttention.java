package server;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Observable;

public class ClientAttention extends Observable implements Runnable {

	// Socket that writes and read, it connects the client to the server
	private Socket socket_atention;
	private boolean online;
	private int id;
	private String UID;

	public ClientAttention(Socket reference, int id) {
		this.socket_atention = reference;
		this.online = true;
		this.id = id;
		answerClientRequest();
	}

	public String getUID() {
		return UID;
	}

	public int getId() {
		return id;
	}

	public Socket getSocket_atention() {
		return socket_atention;
	}

	@Override
	public void run() {
		while (online) {
			// Blocking operation, ClientAttention is waiting for the client
			receiveString();
			try {
				Thread.sleep(60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void answerClientRequest() {
		// Input
		DataInputStream input = null;
		try {
			input = new DataInputStream(socket_atention.getInputStream());
			String request = input.readUTF();
			this.UID = request;
			sendString("acuario");//Server send the space where the interaction takes place.
			System.out.println("Connection accepted for user UID: "+request);

		} catch (IOException e) {
			e.printStackTrace();
			disconnect_client(input);
		}
	}

	private void disconnect_client(DataInput input) {
		setChanged();
		System.err.println("=============================");
		System.err.println("Connection lost with:" + id);
		System.err.println("=============================");
		this.online = false;
		try {
			((FilterInputStream) input).close();
			this.socket_atention.close();
			this.socket_atention = null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		notifyObservers("offClient");
		clearChanged();
	}

	private void receiveString() {
		DataInputStream input = null;
		try {
			input = new DataInputStream(socket_atention.getInputStream());
			String val = input.readUTF();
			setChanged();
			notifyObservers(val);
			clearChanged();
			System.out.println("Receive: " + val + " from user " + this.getUID());
		} catch (IOException e) {
			disconnect_client(input);
		}
	}

	public void sendString(String message) {
		try {
			DataOutputStream output = new DataOutputStream(socket_atention.getOutputStream());
			output.writeUTF(message);
			System.out.println("Message: " + message + " / send to client: " + this.id);
			output.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
