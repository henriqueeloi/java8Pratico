package br.com.eloi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Before;
import org.junit.Test;

import br.com.eloi.model.Usuario;

public class Capitulo4 {
	List<Usuario> usuariosList=null;
	
	@Before
	public void setup(){
		Usuario usuario1 = new Usuario("Henrique Eloi", 150);
		Usuario usuario2 = new Usuario("Karina Santander", 120);
		Usuario usuario3 = new Usuario("Isabella Santander", 190);
		usuariosList = Arrays.asList(usuario1, usuario2, usuario3);		
	}
	
	@Test
	public void testUtilizacaoAndThenDefaultMethod(){
		Consumer<Usuario> mostraMensagem = u -> System.out.println("Antes de imprimir os Nomes");
		
		Consumer<Usuario> imprimeNome = u -> System.out.println(u.getNome());
		
		usuariosList.forEach(mostraMensagem.andThen(imprimeNome));
	
	}
}
