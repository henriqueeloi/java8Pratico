package br.com.eloi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.junit.Before;
import org.junit.Test;

import br.com.eloi.model.Usuario;

/**
 * default method removeIf que recebe um Predicate
 * O Predicate é uma interface funcional que permite
 * testar objetos de um determinando tipo. Dado um
 * Predicate, o removeIf vai remover todos os elementos
 * que devolverem true para esse predicado.
 * 
 * @author Henrique Eloi
 *
 */

public class Capitulo4d3 {
	List<Usuario> usuariosList=null;
	
	@Before
	public void setup(){
		Usuario usuario1 = new Usuario("Henrique Eloi", 150);
		Usuario usuario2 = new Usuario("Karina Santander", 120);
		Usuario usuario3 = new Usuario("Isabella Santander", 190);
		usuariosList = Arrays.asList(usuario1, usuario2, usuario3);		
	}
	
	@Test
	public void testRemoveIfComListaImutavel(){
		Predicate<Usuario> predicate = new Predicate<Usuario>(){
			public boolean test(Usuario u) {
				return u.getPontos() > 160;
			}
		};
		
		usuariosList.removeIf(predicate);
		usuariosList.forEach(u -> System.out.println(u));
	}
	
	@Test
	public void testRemoveIfComLambdaEListaMutavelArrayList(){
		Usuario usuario1 = new Usuario("Henrique Eloi", 150);
		Usuario usuario2 = new Usuario("Karina Santander", 120);
		Usuario usuario3 = new Usuario("Isabella Santander", 190);
		
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);
		usuarios.add(usuario3);
		
		usuarios.removeIf(u -> u.getPontos() > 160);
		usuarios.forEach(u -> System.out.println(u.getNome() + " - " + u.getPontos()));
	}
}
