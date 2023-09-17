package aluguelequipamentos;

import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.Date;
//import java.util.List;

public class Aluguel {
    private Cliente cliente;
    private Equipamento equipamento;
    private Date dataInicio;
    private Date dataFim;

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Aluguel(Cliente cliente, Equipamento equipamento, Date dataInicio, Date dataFim) {
        this.cliente = cliente;
        this.equipamento = equipamento;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public double calcularValorTotal() {
        long diffInDays = (dataFim.getTime() - dataInicio.getTime()) / (1000 * 60 * 60 * 24);
        return diffInDays * equipamento.getValorDiario();
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Equipamento: " + equipamento.getDescricao() + ", Data Início: " + dateFormat.format(dataInicio)
                + ", Data Fim: " + dateFormat.format(dataFim) + ", Valor Total: " + calcularValorTotal();
    }
}
