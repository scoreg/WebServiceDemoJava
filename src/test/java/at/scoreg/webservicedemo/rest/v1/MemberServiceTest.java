package at.scoreg.webservicedemo.rest.v1;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import at.scoreg.webservicedemo.entities.WSMemberComplete;
import at.scoreg.webservicedemo.entities.WSScoutIdList;

public class MemberServiceTest extends RestServiceTest {

	@Test
	public void testFindScoutIdsForOrganization() {
		String orgId = StringUtils.defaultIfBlank(System.getProperty("wsorgId"), "orgId");
		String url = getUrl("member", "findScoutIdsForOrganization", orgId);
		
		RestTemplate restTemplate = new RestTemplate();
		WSScoutIdList scoutIds = restTemplate.getForEntity(url, WSScoutIdList.class).getBody();
		
		System.out.println(scoutIds.getList().size());
	}
	
	@Test
	public void testFindMemberByScoutId() {
		
		String requestedScoutId = "4-GA-000126";
		String url = getUrl("member", "findMemberByScoutId", requestedScoutId);
		
		RestTemplate restTemplate = new RestTemplate();
		WSMemberComplete memberComplete = restTemplate.getForEntity(url, WSMemberComplete.class).getBody();
		
		System.out.println(memberComplete.getFirstname() + " " + memberComplete.getLastname());
	}
	
	@Test
	public void testFindMemberCompleteByScoutId() {
		
		String requestedScoutId = "4-GA-000126";
		String url = getUrl("member", "findMemberCompleteByScoutId", requestedScoutId);
		
		RestTemplate restTemplate = new RestTemplate();
		WSMemberComplete memberComplete = restTemplate.getForEntity(url, WSMemberComplete.class).getBody();
		
		System.out.println(memberComplete.getFirstname() + " " + memberComplete.getLastname());
	}
	
}
