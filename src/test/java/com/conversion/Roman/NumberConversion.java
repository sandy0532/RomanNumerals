package com.conversion.Roman;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class NumberConversion {

	@LocalServerPort
	private int port;
	TestRestTemplate restTemplate = new TestRestTemplate();
	HttpHeaders headers = new HttpHeaders();

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
	
	@Test
	public void TestGetRomanNumeral() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/romantonumeric?query=IX"),
				HttpMethod.GET, entity, String.class);

		String expected = "{number:9}";

		// disable strict checking so we don't have to worry about escaping strings
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	@Test
	public void TestDefaultRomanNumeral() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/romantonumeric"),
				HttpMethod.GET, entity, String.class);

		// roman numeral defaults to I if no query param is provided.
		String expected = "{ romanNumeral: I}";
		String actual = response.getBody();

		JSONAssert.assertEquals(expected, actual, false);
	}

}

