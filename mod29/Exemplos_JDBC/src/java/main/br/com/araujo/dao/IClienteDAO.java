/**
 * 
 */
package br.com.araujo.dao;

import br.com.araujo.domain.Cliente;

import java.util.List;

public interface IClienteDAO {

	
	public Integer cadastrar(Cliente cliente) throws Exception;

	public Cliente consultar(String codigo) throws Exception;

	public Integer atualizar(Cliente cliente) throws Exception;

	public Integer excluir(Cliente clienteBD) throws Exception;

	List<Cliente> buscarTodos() throws Exception;



}
