package br.com.eloi;

import java.util.Arrays;
import java.util.Comparator;
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

public class Capitulo7 {

	List<Usuario> usuariosList = null;
	List<Usuario> usuariosListComNull = null;

	@Before
	public void setup() {
		Usuario usuario1 = new Usuario("Henrique Eloi", 150);
		Usuario usuario2 = new Usuario("Karina Santander", 120);
		Usuario usuario3 = new Usuario("Isabella Santander", 190);		
		Usuario usuario4 = new Usuario("Oliveira", 200);		
		Usuario usuario5 = new Usuario("Eloi", 250);		
		Usuario usuario6 = new Usuario("Roger", 100);		
		usuariosList = Arrays.asList(usuario1, usuario2, usuario3, usuario4, usuario5, usuario6);		
	}

	@Test
	public void testTornarModeradoresOs3UsuariosComMaisPontos(){
		usuariosList.sort(Comparator.comparing(Usuario::getPontos).reversed());
		usuariosList.subList(0, 3).forEach(Usuario::tornarModerador);
	
		usuariosList.subList(0, 3).forEach(u -> System.out.println(u.getNome() + " - " + u.getPontos() + " - " + u.getModerador()));
	}
	

}
