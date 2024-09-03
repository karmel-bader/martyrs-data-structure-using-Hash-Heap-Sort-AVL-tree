package application;

import java.util.ArrayList;
import java.util.Objects;

public class District implements Comparable<District>{
	
	private String district;
	private ArrayList<String> martyrList = new ArrayList<String>();
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public ArrayList<String> getMartyrList() {
		return martyrList;
	}
	public void setMartyrList(ArrayList<String> martyrList) {
		this.martyrList = martyrList;
	}
	@Override
	public int compareTo(District o) {
		return this.district.toLowerCase().compareTo(o.district.toLowerCase());
	}
	public District(String district) {
		super();
		this.district = district;
		martyrList = new ArrayList<String>();
	}
	@Override
	public String toString() {
		return district;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof District) {
			return this.district.equals(((District)obj).district);
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
		for (int i = 0; i < district.length(); i++) {
			hash = hash + (int)district.charAt(i);
		}
		return hash;
	}
	
	

}
