/**
 * 
 */
package br.com.araujo;

import br.com.araujo.dao.IProdutoDAO;
import br.com.araujo.dao.ProdutoDAO;
import br.com.araujo.domain.Produto;
import org.junit.Test;

import br.com.araujo.dao.ClienteDAO;
import br.com.araujo.dao.IClienteDAO;
import br.com.araujo.domain.Cliente;

import java.util.List;

import static org.junit.Assert.*;

public class ClienteTest {

	@Test
	public void cadastrarTest() throws Exception {
		IClienteDAO dao = new ClienteDAO();

		Cliente cliente = new Cliente();
		cliente.setCodigo("01");
		cliente.setNome("Henrique araujo");
		Integer qtd = dao.cadastrar(cliente);
		assertTrue(qtd == 1);

		Cliente clienteBD = dao.consultar(cliente.getCodigo());
		assertNotNull(clienteBD);
		assertNotNull(clienteBD.getId());
		assertEquals(clienteBD.getNome(), clienteBD.getNome());
		assertEquals(clienteBD.getCodigo(), clienteBD.getCodigo());


		Integer qtdDel = dao.excluir(clienteBD);
		assertNotNull(qtdDel);
	}

	@Test
	public void consultarTeste() throws Exception {
		IClienteDAO dao = new ClienteDAO();

		Cliente cliente = new Cliente();
		cliente.setCodigo("01");
		cliente.setNome("Henrique araujo");
		Integer qtd = dao.cadastrar(cliente);
		assertTrue(qtd == 1);

		Cliente clienteBD = dao.consultar(cliente.getCodigo());
		assertNotNull(clienteBD);
		assertNotNull(clienteBD.getId());
		assertEquals(clienteBD.getCodigo(), clienteBD.getCodigo());
		assertEquals(clienteBD.getNome(), clienteBD.getNome());

		Integer qtdDel = dao.excluir(clienteBD);
		assertNotNull(qtdDel);
	}

	@Test
	public void atualizarTest() throws Exception {
		IClienteDAO dao = new ClienteDAO();

		Cliente cliente = new Cliente();
		cliente.setCodigo("01");
		cliente.setNome("Henrique ");
		Integer countCad = dao.cadastrar(cliente);
		assertTrue(countCad == 1);

		Cliente clienteBD = dao.consultar("01");
		assertNotNull(clienteBD.getId());
		// Amarzenar o ID em uma variável
		Long clienteId = clienteBD.getId();
		assertEquals(clienteBD.getCodigo(), clienteBD.getCodigo());
		assertEquals(clienteBD.getNome(), clienteBD.getNome());

		Cliente c1 = new Cliente();
		c1.setCodigo("20");
		c1.setNome("Israel");
		c1.setId(clienteId);
		Integer countUpdate = dao.atualizar(c1);
		assertTrue(countUpdate == 1);

		Cliente clienteUP = dao.consultar("20");
		assertNotNull(clienteUP.getId());
		assertEquals(clienteUP.getCodigo(), clienteUP.getCodigo());
		assertEquals(clienteUP.getNome(), clienteUP.getNome());

		Integer qtdDel = dao.excluir(clienteUP);
		assertNotNull(qtdDel);

	}

	@Test
	public void buscarTodosTest() throws Exception {
		IClienteDAO dao = new ClienteDAO();

		// Inserir primeiro cliente
		Cliente cliente1 = new Cliente();
		cliente1.setCodigo("10");
		cliente1.setNome("Isrsel Araujo");
		Integer countCad1 = dao.cadastrar(cliente1);
		assertTrue(countCad1 == 1);

		// Inserir segundo cliente
		Cliente cliente2 = new Cliente();
		cliente2.setCodigo("20");
		cliente2.setNome("Henrique Araujo");
		Integer countCad2 = dao.cadastrar(cliente2);
		assertTrue(countCad2 == 1);


		// Consultar todos os clientes
		List<Cliente> list = dao.buscarTodos();
		assertNotNull(list);
		assertEquals(2, list.size());

		// Excluir todos os clientes e verificar a exclusão
		int countDel = 0;
		for (Cliente cliente : list) {
			dao.excluir(cliente);
			countDel++;
		}
		assertEquals(list.size(), countDel);

		// Consultar novamente todos os clientes para garantir que a lista está vazia
		list = dao.buscarTodos();
		assertEquals(0, list.size());
	}

	@Test
	public void excluirTest() throws Exception {
		IClienteDAO dao = new ClienteDAO();

		Cliente cliente = new Cliente();
		cliente.setCodigo("01");
		cliente.setNome("Henrique araujo");
		Integer qtd = dao.cadastrar(cliente);
		assertTrue(qtd == 1);

		Cliente clienteBD = dao.consultar(cliente.getCodigo());
		assertNotNull(clienteBD);
		assertNotNull(clienteBD.getId());
		assertEquals(clienteBD.getNome(), clienteBD.getNome());
		assertEquals(clienteBD.getCodigo(), clienteBD.getCodigo());

		Integer qtdDel = dao.excluir(clienteBD);
		assertNotNull(qtdDel);

	}
}
