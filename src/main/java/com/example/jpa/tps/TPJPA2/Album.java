package com.example.jpa.tps.TPJPA2;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class Album {
	@Id @GeneratedValue
	private Long id;
	private String title;
	private LocalDate releaseDate;
	
	@ManyToOne
	private Artist artist;

	public Album() {
	}

	public Album(String title, LocalDate releaseDate) {
		this.title = title;
		this.releaseDate = releaseDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Artist getArtist() {
		return artist;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + ", releaseDate=" + releaseDate + ", artist=" + artist + "]";
	}

	public void setArtist(Artist artist) {
        if (this.artist != null) {
            this.artist.getAlbums().remove(this);
        }
        this.artist = artist;
        if (artist != null) {
            artist.getAlbums().add(this);
        }
    }
}