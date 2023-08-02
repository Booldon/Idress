package idress.hello.idress.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class WeatherData {
    private ResponseData response;

    @Getter @Setter
    public static class ResponseData {
        private HeaderData header;
        private BodyData body;
    }

    @Getter @Setter
    public static class HeaderData {
        private String resultCode;
        private String resultMsg;
    }

    @Getter @Setter
    public static class BodyData {
        private String dataType;
        private ItemsData items;
    }

    @Getter @Setter
    public static class ItemsData {
        private List<ItemData> item;
    }

    @Getter @Setter
    public static class ItemData {
        private String baseDate;
        private String baseTime;
        private String category;
        private int nx;
        private int ny;
        private String obsrValue;
    }

}

