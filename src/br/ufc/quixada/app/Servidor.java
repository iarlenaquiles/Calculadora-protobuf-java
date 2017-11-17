package br.ufc.quixada.app;

import java.io.IOException;
import java.net.ServerSocket;



public class Servidor {
	
	public static void main(String[] args) throws IOException {
		iniciarServidor(8789);
	}
	
	public static void iniciarServidor(int porta) throws IOException{
		ServerSocket socket = null;
		
		socket = new ServerSocket(porta);
		
		System.out.println("Servidor rodando");
	}

}
