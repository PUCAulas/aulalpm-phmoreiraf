package aluguelequipamentos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente {
    private static int proximoID = 0;
    private int id;
    private String nome;
    private List<Aluguel> alugueis = new ArrayList<>();

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

    public List<Aluguel> getAlugueis() {
        return alugueis;
    }
    
    public void registrarAluguel(Equipamento equipamento, Date inicio, Date fim) {
        Aluguel aluguel = new Aluguel(this, equipamento, inicio, fim);
        alugueis.add(aluguel);
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

     public List<Aluguel> getAlugueisPassados() {
        List<Aluguel> passados = new ArrayList<>();
        Date dataAtual = new Date();

        for (Aluguel aluguel : alugueis) {
            if (aluguel.getDataFim().before(dataAtual)) {
                passados.add(aluguel);
            }
        }
        return passados;
    }

    public List<Aluguel> getAlugueisAtuais() {
        List<Aluguel> atuais = new ArrayList<>();
        Date dataAtual = new Date();

        for (Aluguel aluguel : alugueis) {
            if (!aluguel.getDataFim().before(dataAtual)) {
                atuais.add(aluguel);
            }
        }
        return atuais;
    }

    public double gerarRelatorioMensal(int mes) {
        double faturamentoMensal = 0.0;
        for (Aluguel aluguel : alugueis) {
            Date dataInicio = aluguel.getDataInicio();
            if (dataInicio.getMonth() == mes - 1) {
                faturamentoMensal += aluguel.calcularValorTotal();
            }
        }
        return faturamentoMensal;
    }
}
