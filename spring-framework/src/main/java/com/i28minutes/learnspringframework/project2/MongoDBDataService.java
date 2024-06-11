package com.i28minutes.learnspringframework.example.project2;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
@Primary
public class MongoDBDataService implements DataServiceInterface {
	@Override
	public int [] retrieveData() {
		return new int[] {11, 22, 33, 44, 55}; // return an array
	}
}
