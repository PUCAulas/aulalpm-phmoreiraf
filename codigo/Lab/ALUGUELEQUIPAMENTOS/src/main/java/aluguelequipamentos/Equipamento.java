package aluguelequipamentos;

public class Equipamento {
    private int codigo;
    private String descricao;
    private double valorDiario;

    public Equipamento(int codigo, String descricao, double valorDiario) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valorDiario = valorDiario;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValorDiario(double valorDiario) {
        this.valorDiario = valorDiario;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValorDiario() {
        return valorDiario;
    }
}
