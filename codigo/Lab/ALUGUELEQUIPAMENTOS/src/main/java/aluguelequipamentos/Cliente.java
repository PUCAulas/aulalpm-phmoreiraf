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

}
