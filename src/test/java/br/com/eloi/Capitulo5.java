package br.com.eloi;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.eloi.model.Usuario;

public class Capitulo5 {

	List<Usuario> usuariosList=null;
	
	@Before
	public void setup(){
		Usuario usuario1 = new Usuario("Henrique Eloi", 150);
		Usuario usuario2 = new Usuario("Karina Santander", 120);
		Usuario usuario3 = new Usuario("Isabella Santander", 190);
		usuariosList = Arrays.asList(usuario1, usuario2, usuario3);		
	}
		
	@Test
	public void testComparetorComLambda(){
		Comparator<Usuario> comparator = new Comparator<Usuario>(){
			@Override
			public int compare(Usuario u1, Usuario u2) {
				return u2.getNome().compareTo(u2.getNome());
			}			
		};
		
		Collections.sort(usuariosList, comparator);
		
		usuariosList.forEach(u -> System.out.println(u.getNome()));
	}
	
}
