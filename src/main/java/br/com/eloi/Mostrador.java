package br.com.eloi;

import java.util.function.Consumer;

import br.com.eloi.model.Usuario;

public class Mostrador implements Consumer<Usuario> {

	@Override
	public void accept(Usuario t) {
		System.out.println(t.getNome());
	}
	
}
