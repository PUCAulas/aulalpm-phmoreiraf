package aluguelequipamentos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        //Cliente clienteNovo = null;
        // String nomeCliente;
        // List<Cliente> clienteEntrar = null;
        // Cliente clienteNovo = null;
        // int clienteExistente = 0;
        int idCliente = 0;
        int idClienteAtual = 0;
        Cliente cliente = null;
        Aluguel aluguel = null;
        int escolha = -1;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Escolha uma opcao");
        System.out.println("1- Registrar Cliente");
        System.out.println("2- Registrar Aluguel");
        System.out.println("3- Consulta de aluguéis passados");
        System.out.println("4- Consulta de aluguéis atuais");
        System.out.println("5- Relatório mensal");
        System.out.println("0- Sair");

        escolha = scanner.nextInt();

        while (escolha != 0) {
            switch (escolha) {
                case 1:

                    break;

                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opcao invalida");
                    scanner.close();
                    break;

            }
        }
    }
}

