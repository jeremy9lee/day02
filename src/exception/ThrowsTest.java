package exception;

import java.io.IOException;

public class ThrowsTest {
	public void suspiciousMethod() throws IOException {
		throw new IOException();
	}
	
	public void suspiciousMethod2() throws DivideByZeroException {
		throw new DivideByZeroException("test exception occured");
	}
}
