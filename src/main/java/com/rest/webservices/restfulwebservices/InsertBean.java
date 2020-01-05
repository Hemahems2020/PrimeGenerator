package com.rest.webservices.restfulwebservices;

public class InsertBean {
	String UpperLimit;
	String User;
	String LowerLimit;
	String ElapsedTime;
	String Algorithm;
	int NoPrimeReturned;

//parameterized constructor of InsertBean
	public InsertBean(String upperLimit, String user, String lowerLimit, String elapsedTime, String algorithm,
			int noPrimeReturned) {
		super();
		UpperLimit = upperLimit;
		User = user;
		LowerLimit = lowerLimit;
		ElapsedTime = elapsedTime;
		Algorithm = algorithm;
		NoPrimeReturned = noPrimeReturned;
	}

	public InsertBean() {
// calling constructor of the parent class
		super();
	}

//getter function for User
	public String getUser() {
		return User;
	}

//setter function for User
	public void setUser(String user) {
		this.User = user;
	}

// getter function for UpperLimit
	public String getUpperLimit() {
		return UpperLimit;
	}

// setter function for UpperLimit
	public void setUpperLimit(String upperLimit) {
		this.UpperLimit = upperLimit;
	}

// getter function for LowerLimit
	public String getLowerLimit() {
		return LowerLimit;
	}

// setter function for LowerLimit
	public void setLowerLimit(String lowerLimit) {
		this.LowerLimit = lowerLimit;
	}

// getter function for ElapsedTime
	public String getElapsedTime() {
		return ElapsedTime;
	}

// setter function for ElapsedTime
	public void setElapsedTime(String elapsedTime) {
		this.ElapsedTime = elapsedTime;
	}

// getter function for Algorithm
	public String getAlgorithm() {
		return Algorithm;
	}

// setter function for Algorithm
	public void setAlgorithm(String algorithm) {
		this.Algorithm = algorithm;
	}

	// getter function for User
	public int getNoPrimeReturned() {
		return NoPrimeReturned;
	}

	// getter function for User
	public void setNoPrimeReturned(int noPrimeReturned) {
		this.NoPrimeReturned = noPrimeReturned;
	}

	@Override
	public String toString() {
		return "InsertBean [UpperLimit=" + UpperLimit + ", User=" + User + ", LowerLimit=" + LowerLimit
				+ ", ElapsedTime=" + ElapsedTime + ", Algorithm=" + Algorithm + ", NoPrimeReturned=" + NoPrimeReturned
				+ "]";
	}

}
