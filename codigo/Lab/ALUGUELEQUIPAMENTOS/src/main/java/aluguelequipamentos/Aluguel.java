package aluguelequipamentos;

import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.Date;
//import java.util.List;

public class Aluguel {
    private Cliente nome;
    private Cliente id;
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

    public Aluguel(Cliente nome, Equipamento equipamento, Date dataInicio, Date dataFim) {
        this.nome = nome;
        this.equipamento = equipamento;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public Cliente getNome() {
        return nome;
    }

    public Cliente getID() {
        return id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }
