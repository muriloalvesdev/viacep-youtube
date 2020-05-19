package br.com.viacep.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.viacep.utils.Format;
import br.com.viacep.utils.Utils;

@Service
public class ViaCepService {

	private RestTemplate restTemplate;
	private String urlBase;

	public ViaCepService(RestTemplate restTemplate, @Value("${url.base}") String urlBase) {
		this.restTemplate = restTemplate;
		this.urlBase = urlBase;
	}

	public Object consumer(String zipCode, long format) {
		String code = zipCode.replace("-", "");
		Utils.validateZipCode(code);

		String urlComplete = new StringBuilder(urlBase).append(code).append("/").append(Format.getById(format))
				.toString();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML));

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		return restTemplate.exchange(urlComplete, HttpMethod.GET, entity, String.class).getBody();
	}

}
