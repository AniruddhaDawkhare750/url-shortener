package net.javaguides.url_shortener.service;


import net.javaguides.url_shortener.service.model.ShortUrl;

import java.util.UUID;

public interface UrlService {
    ShortUrl createShortUrl(ShortUrl shortUrl);
    ShortUrl getShortUrl(String id);
}
