package net.javaguides.url_shortener.repository;

import net.javaguides.url_shortener.repository.entity.ShortUrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LinkRepository extends JpaRepository<ShortUrlEntity, Long> {
}
