package com.rest.webservices.restfulwebservices;

import java.util.ArrayList;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	InsertBean insertbean = new InsertBean();

	@RequestMapping(method = RequestMethod.GET, path = "/hello-bean/Path-variable/{n1},{n2},{Method}")
	public Prime primePath(@PathVariable int n1, @PathVariable int n2, @PathVariable String Method) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String User = authentication.getName();
		insertbean.setUser(User);
		insertbean.setLowerLimit(String.valueOf(n1));
		insertbean.setUpperLimit(String.valueOf(n2));
		insertbean.setAlgorithm(Method);

		System.out.println(User);

		ArrayList<Object> PrimeList = null;
		if (Method.equals("Traditional")) {
			long startTime = System.nanoTime();
			PrimeList = TraditionalApproach(n1, n2);
			long endTime = System.nanoTime();
			long timeElapsed = endTime - startTime;
			System.out.println("Execution time in Miliseconds : " + timeElapsed / 1000000);
			insertbean.setElapsedTime(String.valueOf(timeElapsed / 1000000));
			System.out.print("Traditional");
			return new Prime(PrimeList);
		}
		if (Method.equals("BruteForce")) {
			long startTime = System.nanoTime();
			PrimeList = BruteForceApproach(n1, n2);
			long endTime = System.nanoTime();
			long timeElapsed = endTime - startTime;
			System.out.println("Execution time in Miliseconds : " + timeElapsed / 1000000);
			insertbean.setElapsedTime(String.valueOf(timeElapsed / 1000000));
			System.out.print("BruteForce");
			return new Prime(PrimeList);
		}
		if (Method.equals("SieveOfEratosthenes")) {
			long startTime = System.nanoTime();
			PrimeList = SieveOfEratosthenes(n1, n2);
			long endTime = System.nanoTime();
			long timeElapsed = endTime - startTime;
			System.out.println("Execution time in Miliseconds : " + timeElapsed / 1000000);
			insertbean.setElapsedTime(String.valueOf(timeElapsed / 1000000));
			System.out.print("SieveOfEratosthenes");
			return new Prime(PrimeList);
		}
		return null;
	}

	private ArrayList<Object> SieveOfEratosthenes(int n1, int n2) {
		ArrayList<Object> PrimeList = new ArrayList<>();
//boolean array with true are initial value
		boolean prime[] = new boolean[n2 + 1];
		// loops over all numbers from n1 and n2
		for (int i = 0; i <= n2; i++) {
			// Skip 0 and 1 as they are neither prime nor composite
			if (i == 0 || i == 1)
				prime[i] = false;
			else
				prime[i] = true;
		}

		for (int p = 2; p * p <= n2; p++) {
			// If prime[p] is not changed, then it is a prime
			if (prime[p] == true) {
				// Update all multiples of p
				for (int i = p * 2; i <= n2; i += p)
					prime[i] = false;
			}
		}
		// A value in prime[i] will finally be false if i is Not a prime, else true.
		// Print all prime numbers
		for (int i = n1; i <= n2; i++) {
			if (prime[i] == true)
				PrimeList.add(i);
		}
		int s = PrimeList.size();
		System.out.println(s);
		insertbean.setNoPrimeReturned(s);
		H2jdbcInsert repo = new H2jdbcInsert();
		repo.insert(insertbean);
		return PrimeList;
	}

	private ArrayList<Object> BruteForceApproach(int n1, int n2) {
		ArrayList<Object> PrimeList = new ArrayList<>();
		int i, j, flag;
		double sqrtOfUl = Math.sqrt(n2);
// loops over all numbers from n1 and n2
		for (i = n1; i <= n2; i++) {
			// Skip 0 and 1 as they are neither prime nor composite
			if (i == 0 || i == 1)
				continue;
			flag = 1;
			// divisor can take values from 2 to sqrt(n2)
			for (j = 2; j <= sqrtOfUl; ++j) {
				// checks if a number is divisible If yes then its not a prime number. Hence
				// flag is set to false.
				if (i % j == 0 && i != j) {
					flag = 0;
					break;
				}
			}
			// flag = 1 means i is prime and flag = 0 means i is not prime
			if (flag == 1)
				PrimeList.add(i);
		}
		int s = PrimeList.size();
		System.out.println(s);
		insertbean.setNoPrimeReturned(s);
		H2jdbcInsert repo = new H2jdbcInsert();
		repo.insert(insertbean);
		return PrimeList;
	}

	private ArrayList<Object> TraditionalApproach(int n1, int n2) {
		ArrayList<Object> PrimeList = new ArrayList<>();
		int i, j, flag;
		// loops over all numbers from n1 and n2
		for (i = n1; i <= n2; i++) {
			// Skip 0 and 1 as they are neither prime nor composite
			if (i == 0 || i == 1)
				continue;
			flag = 1;
			// divisor can take values from 2 to n2/2
			for (j = 2; j <= n2 / 2; ++j) {
				// checks if a number is divisible If yes then its not a prime number. Hence
				// flag is set to false.
				if (i % j == 0 && i != j) {
					flag = 0;
					break;
				}
			}
			// flag = 1 means i is prime and flag = 0 means i is not prime
			if (flag == 1)
				PrimeList.add(i);

		}
		int s = PrimeList.size();
		System.out.println(s);
		insertbean.setNoPrimeReturned(s);
		H2jdbcInsert repo = new H2jdbcInsert();
		repo.insert(insertbean);
		return PrimeList;
	}
}
