package at.scoreg.webservicedemo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author DI(FH) Hubert Novak
 * @date 14.02.2014
 * 
 */

@XmlRootElement(name="WSMemberList")
public class WSMemberList {

	private List<WSMember> list;

	public List<WSMember> getList() {
		if(list == null)
		{
			list = new ArrayList<>();
		}
		return list;
	}

	public void setList(List<WSMember> list) {
		this.list = list;
	}
	
}
