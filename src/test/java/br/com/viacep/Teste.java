package br.com.viacep;

import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.lang.NonNull;

public class Teste {

	@Test
	public void testando() {
		HttpMethod resolve = HttpMethod.resolve("arroz");
		System.out.println(resolve);
		
		HttpMethod valueOf = HttpMethod.valueOf("GET");
		System.out.println(valueOf);
		
		
	}
	
}
