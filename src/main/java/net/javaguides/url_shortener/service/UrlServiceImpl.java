package net.javaguides.url_shortener.service;

import net.javaguides.url_shortener.repository.LinkRepository;
import net.javaguides.url_shortener.repository.entity.ShortUrlEntity;
import net.javaguides.url_shortener.service.model.ShortUrl;
import net.javaguides.url_shortener.util.CommonUtil;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static net.javaguides.url_shortener.util.CommonUtil.BASE_NUMBER;
import static net.javaguides.url_shortener.util.CommonUtil.BASE_URL;

@Service
public class UrlServiceImpl implements UrlService {

    private final LinkRepository linkRepository;

    public UrlServiceImpl(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public ShortUrl createShortUrl(ShortUrl shortUrl) {
        ShortUrlEntity shortUrlEntity = new ShortUrlEntity();
        shortUrlEntity.setLink(shortUrl.getLongUrl());
        ShortUrlEntity savedShortUrlEntity = linkRepository.save(shortUrlEntity);
        shortUrl = savedShortUrlEntity.toModel();
        shortUrl.setShortUrl(BASE_URL + CommonUtil.convert(Long.toString(BASE_NUMBER + shortUrl.getId()), 10, 26));
        return shortUrl;
    }

    @Override
    public ShortUrl getShortUrl(String id) {
        Long dbId = Long.parseLong(CommonUtil.convert(id, 26, 10)) - BASE_NUMBER;
        ShortUrl shortUrl = new ShortUrl();
        return linkRepository.findById(dbId).map(shortUrlEntity -> {
            shortUrl.setId(shortUrlEntity.getId());
            shortUrl.setLongUrl(shortUrlEntity.getLink());
            shortUrl.setShortUrl(BASE_URL + id);
            return shortUrl;
        }).orElseThrow(() -> new RuntimeException("No Long URL found"));
    }
}
