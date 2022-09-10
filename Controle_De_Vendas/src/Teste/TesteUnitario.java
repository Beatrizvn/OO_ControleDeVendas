package Teste;

import static org.junit.jupiter.api.Assertions.*;
import Control.ControleDados;
import Control.ControleProdutos;
import Model.Produto;
import Model.ProdutoVendido;
import org.junit.jupiter.api.Test;

public class TesteUnitario {
    private ControleDados cv = new ControleDados();
    
    @Test
    void testCadastrarMaisProduto(){
        Produto p = new Produto("Notebook","Tecnologia",3000,9000);
        ProdutoVendido pv = new ProdutoVendido(p);
        pv.cadastrarMaisProduto(3);

        Double valorErrado = 9000.0;
        Double valorCorreto = 27000.0;

        assertFalse(pv.getValor() == valorErrado);
        assertTrue(pv.getValor() == valorCorreto);

    }
    @Test
    void testChecarSeENumero(){
        String valorCorreto = "123";
        String valorErrado = "abc";
        String valorErrado2 = "";

        assertTrue(cv.checarSeENumero(valorCorreto));
        assertFalse(cv.checarSeENumero(valorErrado));
        assertFalse(cv.checarSeENumero(valorErrado2));
    }
    @Test
    void testNomeProduto(){
        ControleProdutos cp = new ControleProdutos(cv);

        String a = cp.NomeProduto()[0];
        String b = cp.NomeProduto()[4];
        String valorCorreto = "Produto0";
        String valorCorreto2 = "Produto4";

        assertEquals(valorCorreto, a);
        assertEquals(valorCorreto2, b);
    }
}
