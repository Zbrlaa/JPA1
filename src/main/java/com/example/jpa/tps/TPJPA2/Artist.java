package com.example.jpa.tps.TPJPA2;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;


@Entity
public class Artist {
	@Id @GeneratedValue
	private Long id;
	private String name;
	
	@OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
	private Set<Album> albums = new HashSet<>();

	public Artist() {
	}
	
	public Artist(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", name=" + name + ", albums=" + albums + "]";
	}

	public Artist addAlbum(Album album) {
        album.setArtist(this);
        albums.add(album);
        return this;
    }

    public Artist removeAlbum(Album album) {
        album.setArtist(null);
        albums.remove(album);
        return this;
    }
}