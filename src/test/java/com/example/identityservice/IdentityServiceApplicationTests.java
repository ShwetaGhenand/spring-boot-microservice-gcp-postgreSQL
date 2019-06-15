package com.example.identityservice;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.identityservice.common.Constants;
import com.example.identityservice.dto.UserDto;
import com.example.identityservice.dto.UserDtoResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IdentityServiceApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
	}

	String identityServiceURL = Constants.JUNIT_TEST_BASE_URL + Constants.IDENTITY_SERVICE_ENDPOINT
			+ Constants.BACK_SLASH;

	@Test
	public void testCreateUserValidData() throws Exception {
		UserDto userDto = new UserDto();
		userDto.setFirstName("abc");

		String url = identityServiceURL + "user/";

		ResponseEntity<UserDtoResponse> postResponse = restTemplate.postForEntity(url, userDto, UserDtoResponse.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}

}
