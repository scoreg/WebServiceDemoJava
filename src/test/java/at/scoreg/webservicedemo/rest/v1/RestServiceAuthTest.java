package at.scoreg.webservicedemo.rest.v1;

import java.nio.charset.Charset;
import java.util.Base64;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;

public abstract class RestServiceAuthTest {

	/**
	 * Build URL for WebService Request after release 17.02
	 */
	protected String getUrl(String service, String method, String... parameter) {
		String host = StringUtils.defaultIfBlank(System.getProperty("wshost"), "https://www.scoreg.at/");
		
		String url = host + "ScoregWebServer/services/v1/" + service + "/" + method + "/";
		
		if (parameter.length > 0) {
			url += org.springframework.util.StringUtils.arrayToDelimitedString(parameter, "/");
		}
		
		return url;
	}

	/**
	 * create authentication HTTP headers
	 */
	protected HttpHeaders createHeaders() {
		return new HttpHeaders() {
			private static final long serialVersionUID = -7754140196572841464L;
			{
				String username = StringUtils.defaultIfBlank(System.getProperty("wsusername"), "username");
				String password = StringUtils.defaultIfBlank(System.getProperty("wspassword"), "password");
				
				String accessKey = StringUtils.defaultIfBlank(System.getProperty("wsaccessKey"), "accessKey");
				
				String auth = username + ":" + password;
				byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);
				set("Authorization", authHeader);
				set("accessKey", accessKey);
			}
		};
	}

}
