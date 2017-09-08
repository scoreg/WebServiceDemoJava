package at.scoreg.webservicedemo.rest.v1;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import at.scoreg.webservicedemo.entities.WSMemberComplete;
import at.scoreg.webservicedemo.entities.WSScoutIdList;

public class MemberServiceAuthTest extends RestServiceAuthTest {

	@Test
	public void testFindScoutIdsForOrganization() {
		
		String url = getUrl("memberV2", "findScoutIdsForOrganization");
		
		RestTemplate restTemplate = new RestTemplate();
		WSScoutIdList scoutIds = restTemplate.exchange(url, HttpMethod.GET,
				new HttpEntity<Void>(createHeaders()), WSScoutIdList.class).getBody();
		
		System.out.println(scoutIds.getList().size());
	}
	
	@Test
	public void testFindMemberByScoutId() {
		
		String requestedScoutId = "4-GA-000126";
		String url = getUrl("memberV2", "findMemberByScoutId", requestedScoutId);
		
		RestTemplate restTemplate = new RestTemplate();
		WSMemberComplete memberComplete = restTemplate.exchange(url, HttpMethod.GET,
				new HttpEntity<Void>(createHeaders()), WSMemberComplete.class).getBody();
		
		System.out.println(memberComplete.getFirstname() + " " + memberComplete.getLastname());
	}
	
	@Test
	public void testFindMemberCompleteByScoutId() {
		
		String requestedScoutId = "4-GA-000126";
		String url = getUrl("memberV2", "findMemberCompleteByScoutId", requestedScoutId);
		
		RestTemplate restTemplate = new RestTemplate();
		WSMemberComplete memberComplete = restTemplate.exchange(url, HttpMethod.GET,
				new HttpEntity<Void>(createHeaders()), WSMemberComplete.class).getBody();
		
		System.out.println(memberComplete.getFirstname() + " " + memberComplete.getLastname());
	}
	
	@Test
	public void testFindScoutIdsAndMemberForOrganization() {
		String url = getUrl("memberV2", "findScoutIdsForOrganization");
		
		RestTemplate restTemplate = new RestTemplate();
		WSScoutIdList scoutIds = restTemplate.exchange(url, HttpMethod.GET,
				new HttpEntity<Void>(createHeaders()), WSScoutIdList.class).getBody();
		
		for (String requestedScoutId : scoutIds.getList()) {
			url = getUrl("memberV2", "findMemberCompleteByScoutId", requestedScoutId);
			WSMemberComplete memberComplete = restTemplate.exchange(url, HttpMethod.GET,
				new HttpEntity<Void>(createHeaders()), WSMemberComplete.class).getBody();
			
			System.out.println(memberComplete.getFirstname() + " " + memberComplete.getLastname());
		}
	}
}
