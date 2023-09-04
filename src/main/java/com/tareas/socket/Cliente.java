package com.tareas.socket;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	private final Integer PORT = 13;
	private final String IP = "localhost";
	
	public Cliente() {
		try {
			Socket clienteSocket = new Socket(IP, PORT);
			System.out.println("------------- 1 Iniciando Comunicación ---------------");
			System.out.println("Inet Address : " + clienteSocket.getInetAddress());
			
			File fileOrigen = new File("D:/Client/Jhoset-Llacchua.png");
			FileInputStream fis = new FileInputStream(fileOrigen);
			DataOutputStream salida = new DataOutputStream(clienteSocket.getOutputStream());
			
			int byteLeidos;
			while ( (byteLeidos = fis.read())!= -1) {
				salida.write(byteLeidos);
			}
		
			
			fis.close();
			salida.close();
			
			System.out.println("------------- 2 Finalizando Comunicación -------------");
			clienteSocket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		new Cliente();
	}
	
}
