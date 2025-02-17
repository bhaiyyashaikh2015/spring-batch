package com.ex.beans;

import org.springframework.batch.item.ItemProcessor;

import com.ex.record.Person;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

	@Override
	public Person process(Person item) throws Exception {

		final String fname = item.firstName().toUpperCase();
		final String lname = item.lastName().toUpperCase();

		final Person tranformedPerson = new Person(fname, lname);
		
		Thread.sleep(5000);

		return tranformedPerson;
	}
}
