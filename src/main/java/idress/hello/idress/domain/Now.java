package idress.hello.idress.domain;

import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Now {


    @Scheduled(fixedDelay = 10*60*1000) //10분 (10*60*1000 밀리초)
    public static String NowDate(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formattedDateTime = now.format(formatter);

        return formattedDateTime;
    }

    @Scheduled(fixedDelay = 10*60*1000) //10분 (10*60*1000 밀리초)
    public static String NowTime() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime modifiedTime = now.minusMinutes(30); // 30분을 뺀 시간
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmm");
        String formattedDateTime = modifiedTime.format(formatter);

        return formattedDateTime;
    }
}
