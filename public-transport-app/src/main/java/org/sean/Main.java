package org.sean;

import java.sql.Array;

public class Main {
	public static void main(String[] args) {

		Users[] user = new Users[5];

		user[0] = new Users("James", 1500, 0);
		user[1] = new Users("Sean", 99999999, 2);
		user[2] = new Users("Ana", 500, 1);
		user[3] = new Users("Maria", 650, 0);
		user[4] = new Users("Dina", 10000, 1);

		Bus bus100 = new Bus(100);
		Subway subway1 = new Subway(1);

		for (int i = 0; i < user.length; i++) {
			if (i % 2 == 0) {
				user[i].takingOnBus(bus100);
				System.out.println(user[i].toString());
				System.out.println(bus100.toString());
			} else {
				user[i].takingOnSubway(subway1);
				System.out.println(user[i].toString());
				System.out.println(subway1.toString());
			}
		}

	}
}
