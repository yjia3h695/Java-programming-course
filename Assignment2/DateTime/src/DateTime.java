public class DateTime {

	int year;
	int month;
	int dayOfMonth;
	int hourOfDay;
	int minute;
	int second;

	public DateTime(int y, int m, int d, int h, int min, int sec) {

		year = y;
		month = m;
		dayOfMonth = d;
		hourOfDay = h;
		minute = min;
		second = sec;
	}

	public void setYear(int y) {
		year = y;
	}

	public void setMonth(int m) {
		month = limitWithinRange(m, 1, 12);
	}

	public void setdayOfMonth(int d) {
		if ((month == 1) || (month == 3) || (month == 5) || (month == 7)
				|| (month == 8) || (month == 10) || (month == 12))
			dayOfMonth = limitWithinRange(d, 1, 31);
		else if ((month == 4) || (month == 6) || (month == 9) || (month == 12))
			dayOfMonth = limitWithinRange(d, 1, 30);
		else if (isLeapYear())
			dayOfMonth = limitWithinRange(d, 1, 29);
		else
			dayOfMonth = limitWithinRange(d, 1, 28);
	}

	public void sethourOfDay(int h) {
		hourOfDay = limitWithinRange(h, 1, 23);
	}

	public void setminutes(int min) {
		minute = limitWithinRange(min, 1, 59);
	}

	public void setsecond(int sec) {
		second = limitWithinRange(sec, 1, 59);
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getdayOfMonth() {
		return dayOfMonth;
	}

	public int getHourOfDay() {
		return hourOfDay;
	}

	public int getMinute() {
		return minute;
	}

	public int getSecond() {
		return second;
	}

	private static int limitWithinRange(int value, int min, int max) {
		if (value < min) {
			value = min;
		}
		if (value > max) {
			value = max;
		}
		return value;
	}

	public boolean isLeapYear() {
		return ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0));
	}
}
