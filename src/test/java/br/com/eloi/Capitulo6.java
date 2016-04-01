package br.com.eloi;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import static java.util.Comparator.comparing;

import org.junit.Before;
import org.junit.Test;

import br.com.eloi.model.Usuario;

public class Capitulo6 {

	List<Usuario> usuariosList = null;

	@Before
	public void setup() {
		Usuario usuario1 = new Usuario("Henrique Eloi", 150);
		Usuario usuario2 = new Usuario("Karina Santander", 120);
		Usuario usuario3 = new Usuario("Isabella Santander", 190);		
		usuariosList = Arrays.asList(usuario1, usuario2, usuario3);
	}

	@Test
	public void testMethodReference(){
		usuariosList.forEach(u -> System.out.println(u.getNome() + " - " + u.getModerador()));
				
		usuariosList.forEach(Usuario::tornarModerador);
		
		usuariosList.forEach(u -> System.out.println(u.getNome() + " - " + u.getModerador()));
	}

	
	@Test
	public void testComparandoDeformaMaisEnxuta(){
		usuariosList.sort(Comparator.comparing(Usuario::getNome));
		usuariosList.forEach(u -> System.out.println(u.getNome()));
	}
	
	@Test
	public void testComparandoDeformaMaisEnxutaSimplicada(){
		
		Function<Usuario, String> byName = Usuario::getNome;
		usuariosList.sort(comparing(byName));
				
		usuariosList.forEach(u -> System.out.println(u.getNome()));
	}
	

}
