package com.urlshortener;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UrlService {

    private final Map<String, String> urlMap = new HashMap<>();
    private final String baseUrl = "http://localhost:4567/";

    public String shortenUrl(String longUrl) {
        String code = generateCode();
        urlMap.put(code, longUrl);
        return baseUrl + code;
    }

    public String getOriginalUrl(String code) {
        return urlMap.get(code);
    }

    private String generateCode() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();

        for (int i = 0; i < 6; i++) {
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        }

        return sb.toString();
    }
}
