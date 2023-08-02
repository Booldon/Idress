package idress.hello.idress.service;

import idress.hello.idress.domain.WeatherData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@Service
public class GetJsonDataService {

    private final RestTemplate restTemplate;

    public GetJsonDataService() {
        this.restTemplate = createRestTemplate();
    }

    private RestTemplate createRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        // JSON 응답을 처리하기 위해 MappingJackson2HttpMessageConverter 추가
        MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
        restTemplate.setMessageConverters(Collections.singletonList(jsonMessageConverter));

        return restTemplate;
    }
    public WeatherData getData(String url) {
        //Spring restTemplate
        HashMap<String, Object> result = new HashMap<String, Object>();
        String jsonString ="";

//        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<?> entity = new HttpEntity<>(headers);

        UriComponents uri = UriComponentsBuilder.fromHttpUrl(url).build();

        //Json 정보 WeatherData 객체에 저장
        ResponseEntity<WeatherData> resultMap = restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, WeatherData.class);

        result.put("statusCode", resultMap.getStatusCodeValue()); //http status code를 확인
        result.put("header", resultMap.getHeaders()); // 헤더 정보 확인
        result.put("body", resultMap.getBody()); // 실제 데이터 정보 확인

        return resultMap.getBody();

//        //데이터를 제대로 전달 받았는지 확인 string형태로 파싱해줌
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            jsonString = mapper.writeValueAsString(resultMap.getBody());
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }
//        return jsonString;
    }

    //weatherData에서 category별 obsrValue값 맵에 매핑
    public Map<String, String> DataManufacturer(WeatherData weatherData){

        Map<String, String> categoryObsValueMap = new HashMap<>();
        List<WeatherData.ItemData> itemList = weatherData.getResponse().getBody().getItems().getItem();
        for(WeatherData.ItemData itemData : itemList) {
            categoryObsValueMap.put(itemData.getCategory(), itemData.getObsrValue());
        }

        return categoryObsValueMap;

    }
}
