package MJacademy.test;

public class Switchdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String weekend = "Sunday";

		switch (weekend) {
		case "Tuesday":
			System.out.println("Today is a weekday");
			break;

		case "Wednesday":
			System.out.println("Wednesday is a weekday");
			break;
		case "Sunday":
			System.out.println("Test case is passed");
			break;
		default:
			System.out.println("Weekend is holiday");
			break;

		}

	}

}
