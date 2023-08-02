package idress.hello.idress.domain.data;

import idress.hello.idress.domain.Now;
import idress.hello.idress.service.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final DataService dataService;
    @Override
    public void run(String... args) throws Exception {
        Data seoulData = dataService.DataLoaderValue("seoul");
        dataService.SaveData(seoulData);
        Data gyeonggiData = dataService.DataLoaderValue("gyeonggi");
        dataService.SaveData(gyeonggiData);
        Data gangwonData = dataService.DataLoaderValue("gangwon");
        dataService.SaveData(gangwonData);
        Data chungbukData = dataService.DataLoaderValue("chungbuk");
        dataService.SaveData(chungbukData);
        Data chungnamData = dataService.DataLoaderValue("chungnam");
        dataService.SaveData(chungnamData);
        Data jeonbukData = dataService.DataLoaderValue("jeonbuk");
        dataService.SaveData(jeonbukData);
        Data jeonnamData = dataService.DataLoaderValue("jeonnam");
        dataService.SaveData(jeonnamData);
        Data gyeongbukData = dataService.DataLoaderValue("gyeongbuk");
        dataService.SaveData(gyeongbukData);
        Data gyeongnamData = dataService.DataLoaderValue("gyeongnam");
        dataService.SaveData(gyeongnamData);
        Data jejuData = dataService.DataLoaderValue("jeju");
        dataService.SaveData(jejuData);

    }

    @Scheduled(initialDelay = 10*60*1000, fixedDelay = 10*60*1000) //10분 (10*60*1000 밀리초)
    @Transactional
    public void loadDataPeriodically() {
        Data seoulData = dataService.findOne("seoul");
        seoulData.setStandardTime(Now.NowTime());
        Data gyeonggiData = dataService.findOne("gyeonggi");
        gyeonggiData.setStandardTime(Now.NowTime());
        Data gangwonData = dataService.findOne("gangwon");
        gangwonData.setStandardTime(Now.NowTime());
        Data chungbukData = dataService.findOne("chungbuk");
        chungbukData.setStandardTime(Now.NowTime());
        Data chungnamData = dataService.findOne("chungnam");
        chungnamData.setStandardTime(Now.NowTime());
        Data jeonbukData = dataService.findOne("jeonbuk");
        jeonbukData.setStandardTime(Now.NowTime());
        Data jeonnamData = dataService.findOne("jeonnam");
        jeonnamData.setStandardTime(Now.NowTime());
        Data gyeongbukData = dataService.findOne("gyeongbuk");
        gyeongbukData.setStandardTime(Now.NowTime());
        Data gyeongnamData = dataService.findOne("gyeongnam");
        gyeongnamData.setStandardTime(Now.NowTime());
        Data jejuData = dataService.findOne("jeju");
        jejuData.setStandardTime(Now.NowTime());



    }
}
