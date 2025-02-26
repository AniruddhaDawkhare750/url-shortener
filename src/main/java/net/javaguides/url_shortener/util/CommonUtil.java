package net.javaguides.url_shortener.util;

public class CommonUtil {
    public static final Long BASE_NUMBER = 1000000000L;
    public static final String BASE_URL = "https://localhost:8080/";

    public static String convert(String number, int fromBase, int toBase){
        return Long.toString(Long.parseLong(number,fromBase),toBase);
    }
}
