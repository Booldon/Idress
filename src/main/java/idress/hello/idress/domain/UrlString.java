package idress.hello.idress.domain;

public class UrlString {
    public static String UrlMaker(String area) {

        String nx;
        String ny;

        if(area == "seoul") {
            nx = String.valueOf(60);
            ny = String.valueOf(127);
        }

        else if(area =="gyeonggi") {
        nx = String.valueOf(60);
        ny = String.valueOf(120);
        }

        else if(area =="gangwon") {
            nx = String.valueOf(73);
            ny = String.valueOf(134);
        }

        else if(area =="jeonbuk") {
            nx = String.valueOf(63);
            ny = String.valueOf(89);
        }

        else if(area =="jeonnam") {
            nx = String.valueOf(51);
            ny = String.valueOf(67);
        }

        else if(area =="gyeongbuk") {
            nx = String.valueOf(89);
            ny = String.valueOf(91);
        }

        else if(area =="gyeongnam") {
            nx = String.valueOf(91);
            ny = String.valueOf(77);
        }

        else if(area =="chungbuk") {
            nx = String.valueOf(69);
            ny = String.valueOf(107);
        }
        else if(area =="chungnam") {
            nx = String.valueOf(68);
            ny = String.valueOf(100);
        }
        else if(area =="jeju") {
            nx = String.valueOf(52);
            ny = String.valueOf(38);
        }
        else {
            throw new RuntimeException();
        }

        String url = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst"+
                "?serviceKey=Ilzrff4zU3MHi3ieHAQnIG/NTXqa19qHPdzKbApW/A5VaKOvlHemyPQxHy7Fh8orRGOiprJt5L1rBkLD7QYlpg==" +
                "&numOfRows=10" +
                "&pageNo=1" +
                "&dataType=JSON" +
                "&base_date="+Now.NowDate() +
                "&base_time="+Now.NowTime() +
                "&nx=" + nx +
                "&ny=" + ny ;

        return url;

    }


}
