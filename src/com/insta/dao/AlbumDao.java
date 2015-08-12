package com.insta.dao;

import java.util.List;

import com.insta.entities.InstaAlbum;



public interface AlbumDao {
	
	public Long persistAlbum(InstaAlbum album);
	public InstaAlbum getAlbumById(Long albumId);
	public List<InstaAlbum> getAlbumsByUserName(String username);
	public void deleteAlbumByAlbumId(Long albumId);

}
