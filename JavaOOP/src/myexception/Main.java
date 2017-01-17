package myexception;

public class Main {
	
	public static void test() throws Exception {
		System.out.println("call");
		Class.forName("com.mysql.jdbc.Driver");

	}

	public static void main(String[] args) {
		
		try {
			test();
		} catch (Exception e) {
			System.out.println(e);
		} 
		
		
		
		System.out.println("success?");

	}

}
