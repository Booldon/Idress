package idress.hello.idress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // 스케쥴링 활성화
public class IdressApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdressApplication.class, args);
	}

}
