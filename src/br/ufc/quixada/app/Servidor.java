package br.ufc.quixada.app;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import br.ufc.quixada.calc.Calculadora.Request;



public class Servidor {
	
	public static void main(String[] args) throws IOException {
		iniciarServidor(8789);
	}
	
	public static void iniciarServidor(int porta) throws IOException{
		ServerSocket socket = new ServerSocket(porta);
		
		System.out.println("Servidor rodando");
		
		while(true){
			Socket sock = socket.accept();
			
			Request req = Request.parseDelimitedFrom(sock.getInputStream());
			
			Double resultado = calcular(req);
			
		}
	}
	
	public static Double calcular(Request req){
		return null;
	}

}
