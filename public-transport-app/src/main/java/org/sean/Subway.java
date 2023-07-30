package org.sean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Subway implements Moving{
	private final int maxCapacity = 128041;
	private int lineNumber;
	private int passengers = 0;
	private int revenue = 0;

	public Subway() {
	}

	public Subway(int lineNumber) {
		this.lineNumber = lineNumber;
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
		return "지하철 " +
			lineNumber + "호선의 승객은 " +
			passengers + "명이고, " +
			"지하철 수입은 " +
			revenue + "원입니다.";
	}
}
