package test;
import org.junit.Test;

import kr.or.kosta.shoppingmall.log4j.SomeService;

/**
 * Annotation을 이용하여 Test 클래스를 정의하는 방법(JUnit 4)
 */
public class Log4jTest {
	SomeService service = new SomeService();
	

	@Test
	public void testLog4j() {
		service.someMethod();
	}
}
