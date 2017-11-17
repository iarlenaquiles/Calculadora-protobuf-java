package br.ufc.quixada.app;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import br.ufc.quixada.calc.Calculadora.Reply;
import br.ufc.quixada.calc.Calculadora.Request;
import br.ufc.quixada.calc.Calculadora.Request.Operacao;

public class Cliente {
	static int id = 0;

	public static void main(String[] args) throws UnknownHostException, IOException {
		iniciarCliente("localhost", 8789);
	}

	public static void iniciarCliente(String ip, int porta) throws UnknownHostException, IOException {
		Socket cliente = new Socket(ip, porta);

		Request req = obterDados();

		req.writeDelimitedTo(cliente.getOutputStream());

		Reply res = Reply.parseDelimitedFrom(cliente.getInputStream());

		System.out.println("Resultado: " + res.getRes());
	}

	public static Request obterDados() {
		Scanner entrada = new Scanner(System.in);
		Request.Builder req = Request.newBuilder();

		req.setId(++id);

		System.out.println("Digite o primeiro numero!");
		req.setN1(entrada.nextDouble());

		System.out.println("Digite a operação!");
		entrada.nextLine();
		req.setOp(Operacao.forNumber(getOperacao(entrada.nextLine())));

		System.out.println("Digite o segundo número!");
		req.setN2(entrada.nextDouble());

		entrada.close();

		return req.build();
	}

	public static Integer getOperacao(String op) {
		if (op.equals("+")) {
			return 0;
		} else if (op.equals("-")) {
			return 1;
		} else if (op.equals("*")) {
			return 2;
		} else if (op.equals("/")) {
			return 3;
		} else {
			return null;
		}
	}
}
