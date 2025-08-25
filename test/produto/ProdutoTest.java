package produto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdutoTest {
	
	Produto livro;
	
	@BeforeEach
	public void inicializa() {
		livro = new Produto("Introdução ao Teste de Software", 100.00);
	}
	
	@Test
	public void testCriaProduto() {
		Assertions.assertAll("livro",
				() -> assertEquals("Introdução ao Teste de Software", livro.getNome()),
				() -> assertTrue(100.00 == livro.getPreco())						
				);
	}
	
	@Test
	public void testProdutosIguais() {
		Produto livro2 = new Produto("Introdução ao Teste de Software", 90.00);
		
		assertNotSame(livro, livro2);
		
	}
	
	@Test
	public void assertionComHamcrestMatcher() {
		assertThat(livro.getPreco(), equalTo(100.00));
		assertThat(livro.getNome(), notNullValue());
		assertThat(livro.getNome(), containsString("Teste"));
		assertThat(livro, instanceOf(Produto.class));
	}

	@Test
    	public void testProdutosComMesmoNome() {
              	Produto livro2 = new Produto("Introdução ao Teste de Software", 100.00);
        	assertEquals(livro, livro2, "Produtos com o mesmo nome e preço deveriam ser considerados iguais.");
    	}

	@Test
    	public void testProdutoComPrecoNegativo() {
        	Produto livroComPrecoNegativo = new Produto("Produto com Preço Negativo", -50.00);
        	assertTrue(livroComPrecoNegativo.getPreco() < 0, "O preço do produto não pode ser negativo");
    	}

	@Test
    	public void testProdutoComPrecoZero() {
        	Produto livroComPrecoZero = new Produto("Livro de Preço Zero", 0.00);
        	assertEquals(0.00, livroComPrecoZero.getPreco(), "O preço do livro deveria ser zero");
    	}

	@Test
    	public void testProdutoComPrecoMuitoAlto() {
               	Produto livroComPrecoMuitoAlto = new Produto("Livro Caro", 1_000_000.00);
        	assertEquals(1_000_000.00, livroComPrecoMuitoAlto.getPreco(), "O preço do produto deveria ser 1 milhão");
    	}
}
