package test.com.vinicius.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringmvcappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcappApplication.class, args);
	}

}
