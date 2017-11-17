package br.ufc.quixada.app;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import br.ufc.quixada.calc.Calculadora.Request;
import br.ufc.quixada.calc.Calculadora.Request.Operacao;

public class Cliente {
	static int id = 0;

	public static void main(String[] args) {

	}

	public static void iniciarCliente(String ip, int porta) throws UnknownHostException, IOException {
		Socket cliente = new Socket(ip, porta);
	}

	public static Request obterDados() {
		Scanner entrada = new Scanner(System.in);
		Request.Builder req = Request.newBuilder();

		req.setId(++id);

		System.out.println("Digite o primeiro numero!");
		req.setN1(entrada.nextDouble());

		System.out.println("Digite a operação!");
		String op = entrada.nextLine();
		req.setOp(getOperacao(op));

		System.out.println("Digite o segundo número!");
		req.setN2(entrada.nextDouble());

		entrada.close();

		return req.build();
	}

	public static Operacao getOperacao(String op) {
		if (op.equals("+")) {
			return Operacao.SOM;
		} else if (op.equals("-")) {
			return Operacao.SUB;
		} else if (op.equals("*")) {
			return Operacao.MUL;
		} else if (op.equals("/")) {
			return Operacao.DIV;
		} else {
			return null;
		}
	}
}
