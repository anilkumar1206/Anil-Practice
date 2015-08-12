package com.insta.entities;

// Generated Aug 2, 2015 3:40:21 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * InstaAlbum generated by hbm2java
 */
@Entity
@Table(name = "insta_album", schema = "public")
public class InstaAlbum implements java.io.Serializable {

	private long albumId;
	private InstaUser instaUser;
	private String albumName;
	private String albumDescription;
	private boolean albumIsPrivate;
	private Date albumCreatedDate;
	private Date albumUpdatedDate;
	private String albumCreatedBy;
	private String albumUpdatedBy;
	private Set<InstaAlbumAccess> instaAlbumAccesses = new HashSet<InstaAlbumAccess>(
			0);

	public InstaAlbum() {
	}

	public InstaAlbum(long albumId, InstaUser instaUser, String albumName,
			boolean albumIsPrivate, Date albumCreatedDate, Date albumUpdatedDate) {
		this.albumId = albumId;
		this.instaUser = instaUser;
		this.albumName = albumName;
		this.albumIsPrivate = albumIsPrivate;
		this.albumCreatedDate = albumCreatedDate;
		this.albumUpdatedDate = albumUpdatedDate;
	}

	public InstaAlbum(long albumId, InstaUser instaUser, String albumName,
			String albumDescription, boolean albumIsPrivate,
			Date albumCreatedDate, Date albumUpdatedDate,
			String albumCreatedBy, String albumUpdatedBy,
			Set<InstaAlbumAccess> instaAlbumAccesses) {
		this.albumId = albumId;
		this.instaUser = instaUser;
		this.albumName = albumName;
		this.albumDescription = albumDescription;
		this.albumIsPrivate = albumIsPrivate;
		this.albumCreatedDate = albumCreatedDate;
		this.albumUpdatedDate = albumUpdatedDate;
		this.albumCreatedBy = albumCreatedBy;
		this.albumUpdatedBy = albumUpdatedBy;
		this.instaAlbumAccesses = instaAlbumAccesses;
	}

	@Id
	@Column(name = "album_id", unique = true, nullable = false)
	public long getAlbumId() {
		return this.albumId;
	}

	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "album_user_id", nullable = false)
	public InstaUser getInstaUser() {
		return this.instaUser;
	}

	public void setInstaUser(InstaUser instaUser) {
		this.instaUser = instaUser;
	}

	@Column(name = "album_name", nullable = false, length = 100)
	public String getAlbumName() {
		return this.albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	@Column(name = "album_description", length = 4000)
	public String getAlbumDescription() {
		return this.albumDescription;
	}

	public void setAlbumDescription(String albumDescription) {
		this.albumDescription = albumDescription;
	}

	@Column(name = "album_is_private", nullable = false)
	public boolean isAlbumIsPrivate() {
		return this.albumIsPrivate;
	}

	public void setAlbumIsPrivate(boolean albumIsPrivate) {
		this.albumIsPrivate = albumIsPrivate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "album_created_date", nullable = false, length = 29)
	public Date getAlbumCreatedDate() {
		return this.albumCreatedDate;
	}

	public void setAlbumCreatedDate(Date albumCreatedDate) {
		this.albumCreatedDate = albumCreatedDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "album_updated_date", nullable = false, length = 29)
	public Date getAlbumUpdatedDate() {
		return this.albumUpdatedDate;
	}

	public void setAlbumUpdatedDate(Date albumUpdatedDate) {
		this.albumUpdatedDate = albumUpdatedDate;
	}

	@Column(name = "album_created_by", length = 100)
	public String getAlbumCreatedBy() {
		return this.albumCreatedBy;
	}

	public void setAlbumCreatedBy(String albumCreatedBy) {
		this.albumCreatedBy = albumCreatedBy;
	}

	@Column(name = "album_updated_by", length = 100)
	public String getAlbumUpdatedBy() {
		return this.albumUpdatedBy;
	}

	public void setAlbumUpdatedBy(String albumUpdatedBy) {
		this.albumUpdatedBy = albumUpdatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instaAlbum")
	public Set<InstaAlbumAccess> getInstaAlbumAccesses() {
		return this.instaAlbumAccesses;
	}

	public void setInstaAlbumAccesses(Set<InstaAlbumAccess> instaAlbumAccesses) {
		this.instaAlbumAccesses = instaAlbumAccesses;
	}

}
