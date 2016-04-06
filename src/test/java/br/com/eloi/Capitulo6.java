package br.com.eloi;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import org.junit.Before;
import org.junit.Test;

import br.com.eloi.model.Usuario;

public class Capitulo6 {

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
	
	
	@Test
	public void testCompondoComparators(){
		usuariosList.sort(Comparator.comparingInt(Usuario::getPontos).thenComparing(Usuario::getNome));			
		
		usuariosList.forEach(u -> System.out.println("Composto: " + u.getNome()));		
	}
	
	@Test 
	public void testNullosNoFinal(){
		usuariosListComNull.sort(Comparator.comparing(Usuario::getNome, Comparator.nullsLast(Comparator.naturalOrder())));
		usuariosListComNull.forEach(u -> System.out.println("NullsLast: " + u.getNome()));		
	}
	
	@Test
	public void testNullosNoInicio(){
		usuariosListComNull.sort(Comparator.comparing(Usuario::getNome, Comparator.nullsFirst(Comparator.naturalOrder())));
		usuariosListComNull.forEach(u -> System.out.println("NullsFirst: " + u.getNome()));
	}

}
