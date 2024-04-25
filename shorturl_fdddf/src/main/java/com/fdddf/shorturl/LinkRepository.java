package com.fdddf.shorturl;

import com.fdddf.shorturl.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface LinkRepository extends JpaRepository<Link, Long> {
    Link findByShortUrl(String shortUrl);

    @Modifying
    @Transactional
    @Query("UPDATE Link a SET a.accessCount = a.accessCount + 1 WHERE a.shortUrl = ?1")
    void incrementAccessCountByShortUrl(String shortUrl);

}
