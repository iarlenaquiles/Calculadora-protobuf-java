package br.ufc.quixada.app;

import static br.ufc.quixada.calc.Calculadora.Request.Operacao.SOM;
import static br.ufc.quixada.calc.Calculadora.Request.Operacao.SUB;
import static br.ufc.quixada.calc.Calculadora.Request.Operacao.DIV;
import static br.ufc.quixada.calc.Calculadora.Request.Operacao.MUL;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import br.ufc.quixada.calc.Calculadora.Reply;
import br.ufc.quixada.calc.Calculadora.Request;
import br.ufc.quixada.calc.Calculadora.Request.Operacao;

public class Servidor {

	public static void main(String[] args) throws IOException {
		iniciarServidor(8789);
	}

	public static void iniciarServidor(int porta) throws IOException {
		ServerSocket socket = new ServerSocket(porta);

		System.out.println("Servidor rodando");

		while (true) {
			Socket sock = socket.accept();

			Request req = Request.parseDelimitedFrom(sock.getInputStream());

			Double resultado = calcular(req);

			Reply res = Reply.newBuilder().setId(req.getId()).setRes(resultado).build();

			res.writeDelimitedTo(sock.getOutputStream());

		}
	}

	public static double calcular(Request req) {
		double n1 = req.getN1();
		Operacao op = req.getOp();
		double n2 = req.getN2();

		if (op == SOM) {
			return n1 + n2;
		} else if (op == SUB) {
			return n1 - n2;
		} else if (op == MUL) {
			return n1 * n2;
		} else if (op == DIV) {
			if (n2 > 0) {
				return n1 / n2;
			} else {
				return 0;
			}
		} else {
			return 0;
		}

	}

}
