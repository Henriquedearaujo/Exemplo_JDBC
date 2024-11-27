package br.com.araujo.domain;

public class Produto {
    private Long id;

    private String codigo;

    private String produtoNome;

    private Integer quantidade;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produto) {
        this.produtoNome = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void getQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
