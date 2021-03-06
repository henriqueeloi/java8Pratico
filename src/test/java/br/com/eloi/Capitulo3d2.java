package br.com.eloi;

import org.junit.Assert;
import org.junit.Test;

import br.com.eloi.api.Validador;

public class Capitulo3d2 {

	@Test
	public void testInterfaceFuncionalPropriaComClassAnonima() {
		Validador<String> validadorCEP = new Validador<String>(){
			@Override
			public boolean valida(String valor) {
				return valor.matches("[0-9]{5}-[0-9]{3}");
			}			
		};
		
		Assert.assertTrue(validadorCEP.valida("06603-112"));
	}
	
	@Test
	public void testInterfaceFuncionalPropriaComLambda() {
		Validador<String> validadorCEP = valor -> {
			return valor.matches("[0-9]{5}-[0-9]{3}");
		};		
		
		Assert.assertTrue(validadorCEP.valida("06604-205"));
	}	
	
	public void testInterfaceFuncionalSimplicadaComLambda(){
		Validador<String> validadorCEP = valor -> valor.matches("[0-9]{5}-[0-9]{3}");		
		Assert.assertTrue(validadorCEP.valida("06612-012"));
	}
}
