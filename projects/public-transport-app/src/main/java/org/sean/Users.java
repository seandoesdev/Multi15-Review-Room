package org.sean;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Objects;

@Getter
@Setter
public class Users {

	private String name;
	private int money;
	private HashMap<Integer, String> ageCategory = new HashMap<Integer, String>(){{
		put(0, "Child");
		put(1, "Teenager");
		put(2, "Adults");
	}};
	private int ageElement;


	public Users() {
	}

	public Users(String name, int money, int ageElement) {
		this.name = name;
		this.money = money;
		this.ageElement = ageElement;
	}

	// 중복된 작업처리를 어떻게 할까요.. 메서드 추가?
	public void takingOnBus(Bus bus){
		int fee = 0;
		if (ageCategory.containsValue("Child")){
			if (money >= 500) {
				System.out.println("ddddd");
				money -= 500;
				fee = money;
			}
		}
		else if (ageCategory.containsValue("Teenager")  && money >= 1000) {
			money -= 1000;
			fee = money;
		}
		else if (money >= 1500) {
			money -= 1500;
			fee = money;
		}
		else{
			System.out.println("No Balance");
			return;
		}
		bus.gettingOn(fee);
	}

	public void takingOnSubway(Subway subway){
		int fee = 0;
		if (ageCategory.containsValue("Child"))
			if (money >= 500) {
				money -= 500;
				fee = money;
			}
		else if (ageCategory.containsValue("Teenager"))
				if (money >= 1000) {
					money -= 1000;
					fee = money;
				}
		else if (money >= 1500){
				money -= 1500;
				fee = money;
			}
		else{
			System.out.println("No Balance");
			return;
		}
		subway.gettingOn(fee);
	}

	public void takingOffBus(Bus bus){
		bus.getingOff();
	}

	public void takingOffSubway(Subway subway){
		subway.getingOff();
	}

	@Override
	public String toString() {
		return name + "님의 남은 잔액은 " +
			   money + "원 입니다.";
	}
}
