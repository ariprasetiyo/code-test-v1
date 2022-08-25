package id.arprast;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
public class SpringApplicationMain {

	public static void main(String[] args) {
		new SpringApplicationBuilder(SpringApplicationMain.class).properties("spring.config.name:application").build()
				.run(args);
	}
}




