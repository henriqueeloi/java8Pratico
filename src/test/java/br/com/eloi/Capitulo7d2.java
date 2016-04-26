package br.com.eloi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import br.com.eloi.model.Usuario;

/**
 * 
 * @author Henrique Eloi
 *
 * Streams: tornando moderadores os usuários com mais de 100 pontos
 */

public class Capitulo7d2 {

	List<Usuario> usuariosList = null;

	@Before
	public void setup() {
		Usuario usuario1 = new Usuario("Henrique Eloi", 150);
		Usuario usuario2 = new Usuario("Karina Santander", 120);
		Usuario usuario3 = new Usuario("Isabella Santander", 190);		
		Usuario usuario4 = new Usuario("Oliveira", 20);		
		Usuario usuario5 = new Usuario("Eloi", 250);		
		Usuario usuario6 = new Usuario("Roger", 100);		
		usuariosList = Arrays.asList(usuario1, usuario2, usuario3, usuario4, usuario5, usuario6);		
	}

	
	public void testTornarModeradoresOs3UsuariosComMaisPontosComStreams(){
		usuariosList.stream().filter(u -> u.getPontos() > 100).sorted(Comparator.comparing(Usuario::getPontos).reversed())
		.forEach(u -> System.out.println(u.getNome() + " - " + u.getPontos() + " - " + u.getModerador()));
	}
	
	@Test
	public void testUsandoCollect(){
		List<Usuario> maisQue100 = usuariosList.stream().filter(u -> u.getPontos() > 100)
				.sorted(Comparator.comparing(Usuario::getPontos)).collect(Collectors.toList());
		
		maisQue100.forEach(Usuario::tornarModerador);
		maisQue100.forEach(u -> System.out.println(u.getNome() + " - " + u.getPontos() + " - " + u.getModerador()));
	}

}
