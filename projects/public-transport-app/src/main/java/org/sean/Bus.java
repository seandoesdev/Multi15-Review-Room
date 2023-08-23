package org.sean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bus implements Moving {

	private final int maxCapacity = 55;
	private int busNumber;
	private int passengers = 0;
	private int revenue = 0;

	public Bus() {
	}

	public Bus(int busNumber) {
		this.busNumber = busNumber;
	}



	@Override
	public void gettingOn(int fee) {
		int person = 1;
		int capacity = passengers + person;
		if (maxCapacity < capacity)
			return;
		passengers = capacity;
		revenue += fee;
	}

	@Override
	public void getingOff() {
		int person = 1;
		int capacity = passengers - person;
		if (capacity < 0)
			return;
		passengers = capacity;
	}

	@Override
	public String toString() {
		return "버스 " +
			busNumber + "번의 승객은 " +
			passengers + "명이고, 버스 수입은 " +
			revenue + "원입니다.";
	}
}
