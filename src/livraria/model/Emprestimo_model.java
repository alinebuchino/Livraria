package livraria.model;

import java.util.Date;

public class Emprestimo_model {
    
    private int idItemEmprestimo;
    private String nomeLivro;
    private int idLivro;
    private String cpf;
    private Date dataEmprestimo;
    private int qtdDias;

    public int getIdItemEmprestimo() {
        return idItemEmprestimo;
    }

    public void setIdItemEmprestimo(int idItemEmprestimo) {
        this.idItemEmprestimo = idItemEmprestimo;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public int getQtdDias() {
        return qtdDias;
    }

    public void setQtdDias(int qtdDias) {
        this.qtdDias = qtdDias;
    } 

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String NomeLivro) {
        this.nomeLivro = NomeLivro;
    }
    
}
