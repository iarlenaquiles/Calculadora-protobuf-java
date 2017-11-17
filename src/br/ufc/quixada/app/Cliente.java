package br.ufc.quixada.app;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

	public static void main(String[] args) {

	}

	public static void iniciarCliente(String ip, int porta) throws UnknownHostException, IOException {
		Socket cliente = new Socket(ip, porta);
	}
	
	public static Request obterDados(){
		
		return null;
	}
}
