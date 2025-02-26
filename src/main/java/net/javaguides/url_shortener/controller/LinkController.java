package net.javaguides.url_shortener.controller;

import lombok.AllArgsConstructor;
import net.javaguides.url_shortener.controller.dto.ShortUrlDto;
import net.javaguides.url_shortener.service.UrlService;
import net.javaguides.url_shortener.service.model.ShortUrl;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping
public class LinkController {
    private final UrlService urlService;

    public LinkController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping(value = "/api/short-url")
    public ResponseEntity<String> createShortUrl(@RequestBody ShortUrlDto shortUrlDto) {
        ShortUrl shortUrl = urlService.createShortUrl(shortUrlDto.toModel());
        return new ResponseEntity<>(shortUrl.getShortUrl(), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<String> getLongUrl(@PathVariable("id") String id) {
        try {
            validate(id);
            ShortUrl shortUrl = urlService.getShortUrl(id);
            return new ResponseEntity<>(shortUrl.getLongUrl(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    private void validate(String id){
        if(Strings.isBlank(id) || id.length() != 7){
            throw new RuntimeException("Invalid URL");
        }
    }

}
