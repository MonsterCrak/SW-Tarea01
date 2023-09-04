package com.tareas.socket;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private final Integer PORT = 13;
	
	public Server() {
		
		try {
			Socket clienteSocket;
			
			ServerSocket serverSocket = new ServerSocket(PORT);
			while(true) {
				System.out.println("------------- 1 Iniciando ServerSocket ---------------");
				System.out.println("------------- 2 A la espera de  clienteSocket ---------");
				clienteSocket = serverSocket.accept();
				System.out.println("------------- 3 Llegada de un clienteSocket -----------");
				
				File fileDestino = new File("D:/Server/imagen.png");
				FileOutputStream fos = new FileOutputStream(fileDestino);
				DataInputStream entrada = new DataInputStream(clienteSocket.getInputStream());
				
				int byteLeidos;
				while ( (byteLeidos = entrada.read())!= -1) {
					fos.write(byteLeidos);
				}
				fos.close();
				
				clienteSocket.close();
				System.out.println("------------- 4 Finaliza atención al clienteSocket ----");
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Server();
	}
	
}
