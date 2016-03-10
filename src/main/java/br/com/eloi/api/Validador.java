package br.com.eloi.api;

@FunctionalInterface
public interface Validador<T> {
	boolean valida(T t);
}
