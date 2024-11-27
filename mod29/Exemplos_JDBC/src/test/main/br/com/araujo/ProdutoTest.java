package br.com.araujo;


import br.com.araujo.dao.IProdutoDAO;
import br.com.araujo.dao.ProdutoDAO;
import br.com.araujo.domain.Produto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ProdutoTest {

    @Test
    public void cadastrarTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setProdutoNome("Xbox serie S");
        produto.getQuantidade(100);
        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = dao.consultar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getId());
        assertEquals(produto.getProdutoNome(), produtoBD.getProdutoNome());
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getQuantidade(), produtoBD.getQuantidade());


        Integer qtdDel = dao.excluir(produtoBD);
        assertNotNull(qtdDel);
    }
    @Test
    public void consultarTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setProdutoNome("Xbox serie S");
        produto.getQuantidade(100);
        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = dao.consultar(produto.getCodigo());
        assertNotNull(produtoBD);
        assertNotNull(produtoBD.getId());
        assertEquals(produto.getProdutoNome(), produtoBD.getProdutoNome());
        assertEquals(produto.getCodigo(), produtoBD.getCodigo());
        assertEquals(produto.getQuantidade(), produtoBD.getQuantidade());


        Integer qtdDel = dao.excluir(produtoBD);
        assertNotNull(qtdDel);
    }

    @Test
    public void atualizarTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();

        Produto produto = new Produto();
        produto.setCodigo("01");
        produto.setProdutoNome("Xbox serie S");
        produto.getQuantidade(100);
        Integer qtd = dao.cadastrar(produto);
        assertTrue(qtd == 1);

        Produto produtoBD = dao.consultar("01");
        assertNotNull(produtoBD.getId());
        // Amarzenar o ID em uma variável
        Long produtoId = produtoBD.getId();
        assertEquals(produtoBD.getCodigo(), produtoBD.getCodigo());
        assertEquals(produtoBD.getProdutoNome(), produtoBD.getProdutoNome());
        assertEquals(produtoBD.getQuantidade(), produtoBD.getQuantidade());

        Produto at = new Produto();
        at.setCodigo("20");
        at.setProdutoNome("Paystion pro");
        at.getQuantidade(50);
        at.setId(produtoId);
        Integer countUpdate = dao.atualizar(at);
        assertTrue(countUpdate == 1);

        Produto produtoUP = dao.consultar("20");
        assertNotNull(produtoUP.getId());
        assertEquals(produtoUP.getCodigo(), produtoUP.getCodigo());
        assertEquals(produtoUP.getProdutoNome(), produtoUP.getProdutoNome());
        assertEquals(produtoUP.getQuantidade(), produtoUP.getQuantidade());


        Integer qtdDel = dao.excluir(produtoUP);
        assertNotNull(qtdDel);

    }

    @Test
    public void buscarTodosTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();

        // Inserir primeiro produto
        Produto produto1 = new Produto();
        produto1.setCodigo("10");
        produto1.setProdutoNome("Playstation Pro");
        produto1.getQuantidade(99);
        Integer countCad1 = dao.cadastrar(produto1);
        assertTrue(countCad1 == 1);

        // Inserir segundo produto
        Produto produto2 = new Produto();
        produto2.setCodigo("20");
        produto2.setProdutoNome("Xbox Series S");
        produto2.getQuantidade(99);
        Integer countCad2 = dao.cadastrar(produto2);
        assertTrue(countCad2 == 1);


        // Consultar todos os produtos
        List<Produto> list = dao.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        // Excluir todos os produtos e verificar a exclusão
        int countDel = 0;
        for (Produto produto : list) {
            dao.excluir(produto);
            countDel++;
        }
        assertEquals(list.size(), countDel);

        // Consultar novamente todos os produtos para garantir que a lista está vazia
        list = dao.buscarTodos();
        assertEquals(0, list.size());
    }

    @Test
    public void excluirTest() throws Exception {
        IProdutoDAO dao = new ProdutoDAO();

        Produto produtoEX = new Produto();
        produtoEX.setCodigo("01");
        produtoEX.setProdutoNome("Xbox serie S");
        produtoEX.getQuantidade(100);
        Integer qtd = dao.cadastrar(produtoEX);
        assertTrue(qtd == 1);

        Integer qtdDel = dao.excluir(produtoEX);
        assertNotNull(qtdDel);

    }
}
