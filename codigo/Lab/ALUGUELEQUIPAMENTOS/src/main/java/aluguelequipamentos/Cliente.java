package aluguelequipamentos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente {
    private static int proximoID = 0;
    private int id;
    private String nome;
    private List<Aluguel> alugueis = new ArrayList<>();
    private List<Cliente> clientesCad = new ArrayList<>();

    public Cliente(String nome) {
        this.id = proximoID++;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public void setAlugueis(List<Aluguel> alugueis) {
        this.alugueis = alugueis;
    }

    public Cliente encontrarClientePorID(int idProcurado) {
        for (Cliente clienteCadastrado : clientesCad) {
            if (clienteCadastrado.getID() == idProcurado) {
                return clienteCadastrado;
            }
        }
        return null; // Retorne null se o cliente não for encontrado
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientesCad = clientes;
    }

    /*
     * public Cliente registrarCliente(String nome){
     * Cliente cliente = new Cliente(nome);
     * clientes.add(id, cliente);
     * return cliente;
     * }
     */

    /*
     * public List<Cliente> getClientesCad() {
     * List<Cliente> cadastrados = new ArrayList<>();
     *
     * for (Cliente clientesC: clientes) {
     * cadastrados.add(clientesC);
     *
     * }
     * return cadastrados;
     * }
     */

    public Aluguel registrarAluguel(Cliente nomeCliente, Equipamento equipamento, Date inicio, Date fim) {

        Aluguel aluguel = new Aluguel(nomeCliente, equipamento, inicio, fim);
        alugueis.add(aluguel);
        return aluguel;
    }

    public List<Aluguel> getAlugueisPassados(int idCliente) {
        List<Aluguel> passados = new ArrayList<>();
        Date dataAtual = new Date();

        for (Aluguel aluguel : alugueis) {
            if (getID() == idCliente) {
                if (aluguel.getDataFim().before(dataAtual)) {
                    passados.add(aluguel);
                    // System.out.println("O cliente " + nome + ", possui o seguinte aluguel: ");
                }
            }
        }
        return passados;
    }

    public List<Aluguel> getAlugueisAtuais(int idClienteAtual) {
        List<Aluguel> atuais = new ArrayList<>();
        Date dataAtual = new Date();
        for (Aluguel aluguel : alugueis) {
            if (getID() == idClienteAtual) {
                if (!aluguel.getDataFim().before(dataAtual)) {
                    atuais.add(aluguel);
                }
            }

        }
        return atuais;
    }

    public double gerarRelatorioMensal(int mes) {
        double faturamentoMensal = 0.0;
        for (Aluguel aluguel : alugueis) {
            Date dataInicio = aluguel.getDataInicio();
            if (dataInicio.getMonth() == mes - 1) { // O mês começa em 0, então subtrai 1
                faturamentoMensal += aluguel.calcularValorTotal();
            }
        }
        return faturamentoMensal;

    }

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }

    public double consultarReceitaMensal(int mes) {
        double receitaMensal = 0.0;
        for (Aluguel aluguel : alugueis) {
            int mesAluguel = aluguel.getDataInicio().getMonth() + 1; // +1 porque os meses em Date começam em 0
            if (mesAluguel == mes) {
                receitaMensal += aluguel.calcularValorTotal();
            }
        }
        return receitaMensal;
    }

    public void add(String nomeCliente) {
    }
}
