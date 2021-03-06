package br.com.eloi;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Before;
import org.junit.Test;

import br.com.eloi.model.Usuario;

/**
 * 
 * @author Henrique Eloi
 *
 * Referenciando construtores
 * constructor reference
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
	public void usandoComInterfaceFuncional(){
		Function<String ,Usuario> criadorDeUsuarios = Usuario::new;
		Usuario Roger = criadorDeUsuarios.apply("Roger Eloi");
		
	}
	
	@Test
	public void usandoBiFunction(){
		BiFunction<String, Integer, Usuario> criadorDeUsuarios = Usuario::new;
		
		Usuario isaque = criadorDeUsuarios.apply("Isaque", 50);
		Usuario iolanda = criadorDeUsuarios.apply("Iolanda", 100);
		
	}
	

}
