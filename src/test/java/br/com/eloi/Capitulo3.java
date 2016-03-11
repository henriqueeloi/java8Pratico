package br.com.eloi;

import org.junit.Test;

public class Capitulo3 {

	@Test
	public void testNormalRunnable() {
		// Intanciar uma Thread e um Runnable que conta de 0 a 100
		Runnable r = new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i <= 100; i++) {
					System.out.println("1- " + i);
				}
			}
		};
		new Thread(r).start();
	}

	@Test
	public void testRunnableComInterfaceFuncional() {
		Runnable r = () -> {
			for (int i = 0; i <= 100; i++) {
				System.out.println("2- " + i);
			}
		};
		new Thread(r).start();
	}

	@Test
	public void testThreadUnicoStatement() {
		new Thread(() -> {
			for (int i = 0; i <= 100; i++) {
				System.out.println("3- " + i);
			}
		}).start();
	}

}
