package aluguelequipamentos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
        int idCliente = 0;
        //int idClienteAtual = 0;
        Cliente novoCliente = null;
        // Aluguel aluguel = null;
        List<Cliente> clientesCad = new ArrayList<>();
        int escolha = -1;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Escolha uma opção");
        System.out.println("1- Registrar Cliente");
        System.out.println("2- Registrar Aluguel");
        System.out.println("3- Consulta de alugueis passados");
        System.out.println("4- Consulta de alugueis atuais");
        System.out.println("5- Relatório mensal");
        System.out.println("0- Sair");

        while (escolha != 0) {
            escolha = scanner.nextInt();
            scanner.nextLine();
            switch (escolha) {
                case 1:
                    System.out.println("Digite o nome do cliente:");
                    scanner.nextLine(); // Limpar a quebra de linha pendente
                    String nomeCliente = scanner.nextLine();
                    novoCliente = new Cliente(nomeCliente);
                    clientesCad.add(novoCliente); // Adiciona o cliente à lista de clientes cadastrados
                    System.out.println("Cliente registrado com sucesso: " + nomeCliente);
                    break;
                case 2:

                    System.out.println("Clientes disponíveis para aluguel:");
                    for (Cliente cliente : clientesCad) {
                        System.out.println("ID: " + cliente.getID() + ", Nome: " + cliente.getNome());
                    }

                    System.out.println("Digite o ID do cliente:");
                    idCliente = scanner.nextInt();
                    scanner.nextLine();

                    Cliente clienteSelecionado = null;
                    for (Cliente cliente : clientesCad) {
                        if (cliente.getID() == idCliente) {
                            clienteSelecionado = cliente;
                            break;
                        }
                    }

                    if (clienteSelecionado != null) {
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

                        clienteSelecionado.registrarAluguel(equipamento, dataInicio, dataFim);
                    } else {
                        System.out.println("Cliente não encontrado.");
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
            
            System.out.println("Escolha uma opção");
            System.out.println("1- Registrar Cliente");
            System.out.println("2- Registrar Aluguel");
            System.out.println("3- Consulta de alugueis passados");
            System.out.println("4- Consulta de alugueis atuais");
            System.out.println("5- Relatório mensal");
            System.out.println("0- Sair");

            escolha = scanner.nextInt();
        }

        scanner.close();

    }
}

