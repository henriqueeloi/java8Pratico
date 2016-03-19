package br.com.eloi;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.eloi.model.Usuario;

public class Capitulo5 {

	List<Usuario> usuariosList = null;

	@Before
	public void setup() {
		Usuario usuario1 = new Usuario("Henrique Eloi", 150);
		Usuario usuario2 = new Usuario("Karina Santander", 120);
		Usuario usuario3 = new Usuario("Isabella Santander", 190);
		Usuario usuario4 = new Usuario(null, 190);
		usuariosList = Arrays.asList(usuario1, usuario2, usuario3, usuario4);
	}

	// Compartor é um intreface funcional, com apenas um metodo
	// abstrato. Podemos tirar proveito do lambda e reescrever a instanciação
	// daquela classe anônima de maneira mais simples.
	@Test
	public void testComparetorSemLambda() {
		Comparator<Usuario> comparator = new Comparator<Usuario>() {
			@Override
			public int compare(Usuario u1, Usuario u2) {
				return u1.getNome().compareTo(u2.getNome());
			}
		};
		Collections.sort(usuariosList, comparator);
		usuariosList.forEach(u -> System.out.println(u.getNome()));
	}

	@Test
	public void testComparetorComLambda() {
		Comparator<Usuario> comparator = 
				(u1, u2) -> u2.getNome().compareTo(u1.getNome());
	
		Collections.sort(usuariosList, comparator);
		
		usuariosList.forEach(u -> System.out.println("List2 -> " + u.getNome()));
	}
	
	@Test
	public void testComparatorComLambdaSimples(){
		Collections.sort(usuariosList, 
				(u1,u2) -> u1.getNome().compareTo(u2.getNome()));
	
		usuariosList.forEach(u -> System.out.println("List 3 -> " + u.getNome()));
	}
	
	//Ordenar lista com elementos nulos
	@Test
	public void testCheckSortNull(){
		usuariosList.sort(Comparator.comparing(Usuario::getNome, Comparator.nullsLast(Comparator.naturalOrder())));
		usuariosList.forEach(u -> System.out.println("List 5 -> " + u.getNome()));
	}

}
