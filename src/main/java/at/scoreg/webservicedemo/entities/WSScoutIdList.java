package at.scoreg.webservicedemo.entities;

import java.util.ArrayList;
import java.util.List;

public class WSScoutIdList {

	private List<String> list;

	public List<String> getList() {
		if (list == null) {
			list = new ArrayList<>();
		}
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

}