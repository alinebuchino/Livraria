package livraria.model;

import java.util.Date;

public class Devolucao_model {
    
    private int idItemDevolutivo;
    private int idItemEmprestimo;
    private String nomeLivro;
    private String cpf;
    private Date dataDevolucao;

    public int getIdItemDevolutivo() {
        return idItemDevolutivo;
    }

    public void setIdItemDevolutivo(int idItemDevolutivo) {
        this.idItemDevolutivo = idItemDevolutivo;
    }

    public int getIdItemEmprestimo() {
        return idItemEmprestimo;
    }

    public void setIdItemEmprestimo(int idItemEmprestimo) {
        this.idItemEmprestimo = idItemEmprestimo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String NomeLivro) {
        this.nomeLivro = NomeLivro;
    }
    
}
