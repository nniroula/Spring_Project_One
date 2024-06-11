package com.i28minutes.learnspringframework.example.project2;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class MySQLDataService implements DataServiceInterface {
	@Override
	public int [] retrieveData() {
		return new int[] {1, 2, 3, 4, 5}; // return an array
	}
}
