package at.scoreg.webservicedemo.rest.parallel;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import at.scoreg.webservicedemo.entities.WSMemberComplete;
import at.scoreg.webservicedemo.entities.WSScoutIdList;
import at.scoreg.webservicedemo.rest.v1.RestServiceAuthTest;

public class ParallelTest extends RestServiceAuthTest {

	private ExecutorService wsExecutor;
	
	public ParallelTest() {
		wsExecutor = Executors.newFixedThreadPool(50);
	}
	
	@Test
	public void test() {
		String url = getUrl("memberV2", "findScoutIdsForOrganization");
		
		RestTemplate restTemplate = new RestTemplate();
		WSScoutIdList scoutIds = restTemplate.exchange(url, HttpMethod.GET,
				new HttpEntity<Void>(createHeaders()), WSScoutIdList.class).getBody();
		
		System.out.println(scoutIds.getList().size());
		
		for (String requestedScoutId : scoutIds.getList()) {
			FutureTask<WSMemberComplete> task = new FutureTask<>(new Callable<WSMemberComplete>() {
				@Override
				public WSMemberComplete call() throws Exception {
					String url = getUrl("memberV2", "findMemberCompleteByScoutId", requestedScoutId);
					WSMemberComplete memberComplete = restTemplate.exchange(url, HttpMethod.GET,
							new HttpEntity<Void>(createHeaders()), WSMemberComplete.class).getBody();

					System.out.println(memberComplete.getFirstname() + " " + memberComplete.getLastname());
					return memberComplete;
				}
			});
			wsExecutor.execute(task);
		}	
		
		try {
			wsExecutor.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
