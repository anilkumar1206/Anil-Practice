package com.insta.entities;

// Generated Aug 2, 2015 3:40:21 PM by Hibernate Tools 4.3.1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * InstaAlbumAccess generated by hbm2java
 */
@Entity
@Table(name = "insta_album_access", schema = "public")
public class InstaAlbumAccess implements java.io.Serializable {

	private long albumAccessId;
	private InstaAlbum instaAlbum;
	private long albumUserId;
	private boolean albumIsReadonly;
	private Date albumAccessCreatedDate;
	private Date albumAccessUpdatedDate;
	private String albumAccessCreatedBy;
	private String albumAccessUpdatedBy;

	public InstaAlbumAccess() {
	}

	public InstaAlbumAccess(long albumAccessId, InstaAlbum instaAlbum,
			long albumUserId, boolean albumIsReadonly,
			Date albumAccessCreatedDate, Date albumAccessUpdatedDate) {
		this.albumAccessId = albumAccessId;
		this.instaAlbum = instaAlbum;
		this.albumUserId = albumUserId;
		this.albumIsReadonly = albumIsReadonly;
		this.albumAccessCreatedDate = albumAccessCreatedDate;
		this.albumAccessUpdatedDate = albumAccessUpdatedDate;
	}

	public InstaAlbumAccess(long albumAccessId, InstaAlbum instaAlbum,
			long albumUserId, boolean albumIsReadonly,
			Date albumAccessCreatedDate, Date albumAccessUpdatedDate,
			String albumAccessCreatedBy, String albumAccessUpdatedBy) {
		this.albumAccessId = albumAccessId;
		this.instaAlbum = instaAlbum;
		this.albumUserId = albumUserId;
		this.albumIsReadonly = albumIsReadonly;
		this.albumAccessCreatedDate = albumAccessCreatedDate;
		this.albumAccessUpdatedDate = albumAccessUpdatedDate;
		this.albumAccessCreatedBy = albumAccessCreatedBy;
		this.albumAccessUpdatedBy = albumAccessUpdatedBy;
	}

	@Id
	@Column(name = "album_access_id", unique = true, nullable = false)
	public long getAlbumAccessId() {
		return this.albumAccessId;
	}

	public void setAlbumAccessId(long albumAccessId) {
		this.albumAccessId = albumAccessId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "album_id", nullable = false)
	public InstaAlbum getInstaAlbum() {
		return this.instaAlbum;
	}

	public void setInstaAlbum(InstaAlbum instaAlbum) {
		this.instaAlbum = instaAlbum;
	}

	@Column(name = "album_user_id", nullable = false)
	public long getAlbumUserId() {
		return this.albumUserId;
	}

	public void setAlbumUserId(long albumUserId) {
		this.albumUserId = albumUserId;
	}

	@Column(name = "album_is_readonly", nullable = false)
	public boolean isAlbumIsReadonly() {
		return this.albumIsReadonly;
	}

	public void setAlbumIsReadonly(boolean albumIsReadonly) {
		this.albumIsReadonly = albumIsReadonly;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "album_access_created_date", nullable = false, length = 29)
	public Date getAlbumAccessCreatedDate() {
		return this.albumAccessCreatedDate;
	}

	public void setAlbumAccessCreatedDate(Date albumAccessCreatedDate) {
		this.albumAccessCreatedDate = albumAccessCreatedDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "album_access_updated_date", nullable = false, length = 29)
	public Date getAlbumAccessUpdatedDate() {
		return this.albumAccessUpdatedDate;
	}

	public void setAlbumAccessUpdatedDate(Date albumAccessUpdatedDate) {
		this.albumAccessUpdatedDate = albumAccessUpdatedDate;
	}

	@Column(name = "album_access_created_by", length = 100)
	public String getAlbumAccessCreatedBy() {
		return this.albumAccessCreatedBy;
	}

	public void setAlbumAccessCreatedBy(String albumAccessCreatedBy) {
		this.albumAccessCreatedBy = albumAccessCreatedBy;
	}

	@Column(name = "album_access_updated_by", length = 100)
	public String getAlbumAccessUpdatedBy() {
		return this.albumAccessUpdatedBy;
	}

	public void setAlbumAccessUpdatedBy(String albumAccessUpdatedBy) {
		this.albumAccessUpdatedBy = albumAccessUpdatedBy;
	}

}
