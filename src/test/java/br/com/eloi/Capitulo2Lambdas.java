package br.com.eloi;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.eloi.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Java8Application.class)
public class Capitulo2Lambdas {

	List<Usuario> usuariosList = null;

	@Before
	public void setup() {
		Usuario usuario1 = new Usuario("Henrique Eloi", 150);
		Usuario usuario2 = new Usuario("Karina Santander", 120);
		Usuario usuario3 = new Usuario("Isabella Santander", 190);
		usuariosList = Arrays.asList(usuario1, usuario2, usuario3);
	}

	@Test
	public void ConsumerLambda() {
		Consumer<Usuario> mostrador = (Usuario u) -> {
			System.out.println(u.getNome());
		};						
		usuariosList.forEach(mostrador);
				
		Consumer<Usuario> mostrador2 = u -> System.out.println(u.getNome());
		usuariosList.forEach(mostrador);
		
		//Forma mais simples ainda
		usuariosList.forEach(u -> System.out.println(u.getNome()));		
	}
	
	@Test
	public void tornarModerador() {
		usuariosList.forEach(u -> u.tornarModerador());
		usuariosList.forEach(u -> System.out.println("É moderador? " + u.isModerador()));
	}

}
