package exception;

public class ExceptionTest2 {
	public static void main(String[] args) {
		ThrowsTest tt = new ThrowsTest();

		try {
			tt.suspiciousMethod();
		} catch (Exception ex) {
			System.out.println("예외가 발생했습니다.");
		}
		
		
		try {
			tt.suspiciousMethod2();
		} catch (DivideByZeroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
