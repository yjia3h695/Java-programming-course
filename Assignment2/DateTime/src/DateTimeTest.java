public class DateTimeTest {

	public void performTests() {

		DateTime a = new DateTime(2014, 1, 1, 0, 0, 0);
		DateTime b = new DateTime(2014, 1, 2, 3, 4, 5);

		assertTrue(b.getYear() == 2014);
		assertTrue(b.getMonth() == 1);
		assertTrue(b.getdayOfMonth() == 2);
		assertTrue(b.getHourOfDay() == 3);
		assertTrue(b.getMinute() == 4);
		assertTrue(b.getSecond() == 5);

		assertTrue(a.equals(a));
		assertTrue(a.equals(new DateTime(2014, 1, 1, 0, 0, 0)));
		assertTrue(!a.equals(new DateTime(2013, 1, 1, 0, 0, 0)));
		assertTrue(!a.equals(new DateTime(2014, 2, 1, 0, 0, 0)));
		assertTrue(!a.equals(new DateTime(2014, 1, 2, 0, 0, 0)));
		assertTrue(!a.equals(new DateTime(2014, 1, 1, 1, 0, 0)));
		assertTrue(!a.equals(new DateTime(2014, 1, 1, 0, 1, 0)));
		assertTrue(!a.equals(new DateTime(2014, 1, 1, 0, 0, 1)));
		assertTrue((new DateTime(1504, 1, 1, 0, 0, 0)).isLeapYear());
		assertTrue((new DateTime(1796, 1, 1, 0, 0, 0)).isLeapYear());
		assertTrue((new DateTime(2008, 1, 1, 0, 0, 0)).isLeapYear());
		assertTrue(!(new DateTime(2009, 1, 1, 0, 0, 0)).isLeapYear());
		assertTrue(!(new DateTime(2010, 1, 1, 0, 0, 0)).isLeapYear());
		assertTrue(!(new DateTime(2011, 1, 1, 0, 0, 0)).isLeapYear());
		assertTrue((new DateTime(2012, 1, 1, 0, 0, 0)).isLeapYear());
		assertTrue(!(new DateTime(2013, 1, 1, 0, 0, 0)).isLeapYear());

		assertTrue((new DateTime(2014, 1, 0, 0, 0, 0)).getdayOfMonth() == 1);
		assertTrue((new DateTime(2014, 1, 32, 0, 0, 0)).getdayOfMonth() == 31);

		assertTrue((new DateTime(2014, 2, 0, 0, 0, 0)).getdayOfMonth() == 1);
		assertTrue((new DateTime(2007, 2, 29, 0, 0, 0)).getdayOfMonth() == 28);
		assertTrue((new DateTime(2008, 2, 29, 0, 0, 0)).getdayOfMonth() == 29);
		assertTrue((new DateTime(2009, 2, 29, 0, 0, 0)).getdayOfMonth() == 28);

		assertTrue((new DateTime(2014, 3, 0, 0, 0, 0)).getdayOfMonth() == 1);
		assertTrue((new DateTime(2014, 3, 32, 0, 0, 0)).getdayOfMonth() == 31);

		assertTrue((new DateTime(2014, 4, 0, 0, 0, 0)).getdayOfMonth() == 1);
		assertTrue((new DateTime(2014, 4, 31, 0, 0, 0)).getdayOfMonth() == 30);

		assertTrue((new DateTime(2014, 5, 0, 0, 0, 0)).getdayOfMonth() == 1);
		assertTrue((new DateTime(2014, 5, 32, 0, 0, 0)).getdayOfMonth() == 31);

	}

	private static void assertTrue(boolean condition) {
		if (!condition) {
			throw new AssertionError();
		}
	}

	public static void main(String[] args) {
		DateTimeTest tests = new DateTimeTest();
		try {
			tests.performTests();
			System.out.println(new String(new char[] { 0x41, 0x6c, 0x6c, 0x20,
					0x54, 0x65, 0x73, 0x74, 0x73, 0x20, 0x50, 0x61, 0x73, 0x73,
					0x65, 0x64, 0x21 }));
		} catch (AssertionError ex) {
			System.err.println("There were test failure(s)!");
			ex.printStackTrace();
		}
	}
}