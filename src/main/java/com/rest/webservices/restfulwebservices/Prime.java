package com.rest.webservices.restfulwebservices;

import java.util.ArrayList;

public class Prime {

	ArrayList<Object> PrimeList;

	public Prime(ArrayList<Object> primeList) {
		super();
		this.PrimeList = primeList;
	}

	public ArrayList<Object> getPrimeList() {
		return PrimeList;
	}

	public void setPrimeList(ArrayList<Object> primeList) {
		this.PrimeList = primeList;
	}

	@Override
	public String toString() {
		return "Prime [PrimeList=" + PrimeList + "]";
	}

}