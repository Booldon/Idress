package idress.hello.idress.service;

import idress.hello.idress.domain.Now;
import idress.hello.idress.domain.UrlString;
import idress.hello.idress.domain.WeatherData;
import idress.hello.idress.domain.data.Data;
import idress.hello.idress.exception.NoDataException;
import idress.hello.idress.repository.DataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DataService {

    private final DataRepository dataRepository;

    private final GetJsonDataService getDataService;


    public void SaveData(Data data) {
        dataRepository.save(data);
    }
    public Data findOne(String area) {
        Optional<Data> findData = dataRepository.findByDataArea(area);
        if(findData.isPresent()) {
            Data data = findData.get();
            return data;
        } else {
            throw new NoDataException("데이터가 없음");
        }
    }

    public Data DataLoaderValue(String area) {
        WeatherData weatherDataSeoul = getDataService.getData(UrlString.UrlMaker(area));
        Map<String, String> categoryObsrValue= getDataService.DataManufacturer(weatherDataSeoul);
        Double sensoryTem = SensoryTem(categoryObsrValue);
        String dressTem = DressTem(sensoryTem);
        Data setData = new Data();
        setData.setArea(area);
        setData.setDress(dressTem);
        setData.setSenT(sensoryTem);
        setData.setStandardTime(Now.NowTime());

        return setData;
    }

    public Double SensoryTem(Map<String, String> categoryObsrValueMap){

        Double T = Double.valueOf(categoryObsrValueMap.get("T1H"));
        Double V = 3.6 * Double.valueOf(categoryObsrValueMap.get("WSD"));
        Double PV = Math.pow(V,0.16);
        Double SenT = 13.12 + (0.6215*T)-(11.37*PV)+(0.3965*PV)*T;

        DecimalFormat df = new DecimalFormat("0.00");

        return Double.valueOf(df.format(SenT));


    }
    public String DressTem(Double SenT){

        if (SenT>=28) {
            return "VH";

        } else if (SenT>=23 && SenT<28) {
            return "H";
        }
        else if (SenT>=20 && SenT<23) {
            return "LH";
        }
        else if (SenT>=17 && SenT<20) {
            return "W";
        }
        else if (SenT>=12 && SenT<17) {
            return "N";
        }
        else if (SenT>=9 && SenT<12) {
            return "LC";
        }
        else if (SenT>=5 && SenT<9) {
            return "C";
        }
        else
            return "VC";
    }
}
