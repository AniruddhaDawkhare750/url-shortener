package net.javaguides.url_shortener.controller.dto;

import net.javaguides.url_shortener.service.model.ShortUrl;


public class ShortUrlDto {
    private String longUrl;

    public ShortUrlDto() {
    }

    public ShortUrlDto(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public ShortUrl toModel() {
        return new ShortUrl(null,longUrl,null);
    }
}
