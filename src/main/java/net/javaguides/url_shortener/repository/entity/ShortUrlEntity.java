package net.javaguides.url_shortener.repository.entity;

import jakarta.persistence.*;
import net.javaguides.url_shortener.service.model.ShortUrl;


@Entity
@Table(name="short_url_entity")
public class ShortUrlEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "link")
    private String link;

    public ShortUrlEntity() {
    }

    public ShortUrlEntity(Long id, String link) {
        this.id = id;
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public ShortUrl toModel() {
        ShortUrl shortUrl = new ShortUrl();
        shortUrl.setId(id);
        shortUrl.setLongUrl(link);
        return shortUrl;
    }
}
