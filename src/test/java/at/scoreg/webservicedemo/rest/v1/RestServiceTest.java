package at.scoreg.webservicedemo.rest.v1;

import org.apache.commons.lang3.StringUtils;

public abstract class RestServiceTest {

	/**
	 * Build URL for WebService Request until release 16.11
	 */
	protected String getUrl(String service, String method, String... parameter) {
		String host = StringUtils.defaultIfBlank(System.getProperty("wshost"), "https://www.scoreg.at/");
		
		String url = host + "ScoregWebServer/services/v1/" + service + "/" + method + "/";
		String username = StringUtils.defaultIfBlank(System.getProperty("wsusername"), "username");
		String password = StringUtils.defaultIfBlank(System.getProperty("wspassword"), "password");
		
		String serviceId = StringUtils.defaultIfBlank(System.getProperty("wsserviceId"), "serviceId");
		String orgId = StringUtils.defaultIfBlank(System.getProperty("wsorgId"), "orgId");
	
		url += username + "/" + password + "/" + orgId + "/" + serviceId + "/";
		
		if (parameter.length > 0) {
			url += org.springframework.util.StringUtils.arrayToDelimitedString(parameter, "/");
		}
		
		return url;
	}

}
