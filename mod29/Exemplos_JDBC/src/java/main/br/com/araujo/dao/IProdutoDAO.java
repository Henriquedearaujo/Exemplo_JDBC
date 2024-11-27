package br.com.araujo.dao;

import br.com.araujo.domain.Cliente;
import br.com.araujo.domain.Produto;

import java.util.List;

public interface IProdutoDAO {

    public Integer cadastrar(Produto produto) throws Exception;

    public Produto consultar(String codigo) throws Exception;

    public Integer atualizar(Produto produto) throws Exception;

    public Integer excluir(Produto produtoBD) throws Exception;

    List<Produto> buscarTodos() throws Exception;
}
