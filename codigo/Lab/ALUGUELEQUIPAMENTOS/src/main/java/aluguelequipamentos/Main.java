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

                    System.out.println("Digite o nome do cliente:");
                    scanner.nextLine(); // Limpar a quebra de linha pendente
                    String nomeCliente = scanner.nextLine();
                    cliente = new Cliente(nomeCliente);
                    System.out.println("Cliente registrado com sucesso: " + nomeCliente);
                    break;

                case 2:
                     if (cliente == null) {
                        System.out.println("Por favor, registre um cliente primeiro.");
                        break;
                    }

                    System.out.println("Digite a data de início (dd/MM/yyyy):");
                    Date dataInicio = dateFormat.parse(scanner.next());

                    System.out.println("Digite a data de término (dd/MM/yyyy):");
                    Date dataFim = dateFormat.parse(scanner.next());

                    System.out.println("Digite o código do equipamento:");
                    int codigoEquipamento = scanner.nextInt();

                    System.out.println("Digite a descrição do equipamento:");
                    scanner.nextLine(); // Limpar a quebra de linha pendente
                    String descricaoEquipamento = scanner.nextLine();

                    System.out.println("Digite o valor diário do equipamento:");
                    double valorDiarioEquipamento = scanner.nextDouble();

                    Equipamento equipamento = new Equipamento(codigoEquipamento, descricaoEquipamento,
                            valorDiarioEquipamento);

                    aluguel = cliente.registrarAluguel(cliente, equipamento, dataInicio, dataFim);

                    if (aluguel != null) {
                        System.out.println("Aluguel registrado com sucesso.");
                        System.out.println("Valor total do aluguel: " + aluguel.calcularValorTotal());
                    } else {
                        System.out.println("Erro ao registrar o aluguel.");
                    }
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

