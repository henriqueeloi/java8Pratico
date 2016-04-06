package br.com.eloi;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.eloi.model.Usuario;

/**
 * 
 * @author Henrique Eloi
 *
 * Referenciando métodos que recebem argumentos
 */

public class Capitulo6d5 {

	List<Usuario> usuariosList = null;
	List<Usuario> usuariosListComNull = null;

	@Before
	public void setup() {
		Usuario usuario1 = new Usuario("Henrique Eloi", 150);
		Usuario usuario2 = new Usuario("Karina Santander", 120);
		Usuario usuario3 = new Usuario("Isabella Santander", 190);		
		Usuario usuarioNull = new Usuario(null, 290);		
		usuariosList = Arrays.asList(usuario1, usuario2, usuario3);
		
		usuariosListComNull = Arrays.asList(usuario1, usuario2, usuario3, usuarioNull);
	}

	@Test
	public void testUsandoPrintln(){
		usuariosList.forEach(System.out::println);
	}
	

}
