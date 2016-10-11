package at.scoreg.webservicedemo.rest.v1;

import java.nio.charset.Charset;
import java.util.Base64;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import at.scoreg.webservicedemo.entities.WSMemberComplete;

public class TestMemberService {

	@Test
	public void test() {
		
		String host = StringUtils.defaultIfBlank(System.getProperty("wshost"), "https://www.scoreg.at/");
		
		String url = host + "ScoregWebServer/services/v1/member/findMemberCompleteByScoutId/";
		String username = StringUtils.defaultIfBlank(System.getProperty("wsusername"), "username");
		String password = StringUtils.defaultIfBlank(System.getProperty("wspassword"), "password");
		
		String accessKey = StringUtils.defaultIfBlank(System.getProperty("wsaccessKey"), "accessKey");
		
		String requestedScoutId = "4-GA-000126";
		
		RestTemplate restTemplate = new RestTemplate();
		WSMemberComplete memberComplete = restTemplate.exchange(url + requestedScoutId, HttpMethod.GET,
				new HttpEntity<Void>(createHeaders(username, password, accessKey)), WSMemberComplete.class).getBody();
		
		System.out.println(memberComplete.getFirstname() + " " + memberComplete.getLastname());
				
	}

	private HttpHeaders createHeaders(String username, String password, String accessKey) {
		return new HttpHeaders() {
			private static final long serialVersionUID = -7754140196572841464L;
			{
				String auth = username + ":" + password;
				byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				set("Authorization", authHeader);
				set("accessKey", accessKey);
			}
		};
	}
}
