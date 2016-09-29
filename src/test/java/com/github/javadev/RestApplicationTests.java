package com.github.javadev;

import com.github.javadev.model.ResultResponse;
import com.github.javadev.model.StringsParam;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RestApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
		StringsParam stringsParam = new StringsParam();
		stringsParam.strings = Arrays.asList(
				"Sound boy proceed to blast into the galaxy",
						"Go back rocket man into the sky you'll see",
						"Hear it all the time, come back rewind",
						"Aliens are watching up in the sky",
						"Sound boy process to blast into the galaxy",
						"No one gonna harm you",
						"They all want you to play I watch the birds of prey"
		);
		ResponseEntity<ResultResponse> entity = this.restTemplate.postForEntity("/strings", stringsParam,
				ResultResponse.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody().result.toString()).isEqualTo(
				"[string=Aliens are watching up in the sky, longestWord=8,"
				+ " string=Sound boy proceed to blast into the galaxy, longestWord=7,"
				+ " string=Sound boy process to blast into the galaxy, longestWord=7,"
				+ " string=Go back rocket man into the sky you'll see, longestWord=6,"
				+ " string=Hear it all the time, come back rewind, longestWord=6]");
	}
}
