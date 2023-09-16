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

    public void setClientes(List<Cliente> clientes) {
        this.clientesCad = clientes;
    }
    
        public Aluguel registrarAluguel(Cliente nomeCliente, Equipamento equipamento, Date inicio, Date fim) {

        Aluguel aluguel = new Aluguel(nomeCliente, equipamento, inicio, fim);
        alugueis.add(aluguel);
        return aluguel;
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
    

}
