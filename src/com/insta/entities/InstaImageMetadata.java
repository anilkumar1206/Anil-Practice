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
 * InstaImageMetadata generated by hbm2java
 */
@Entity
@Table(name = "insta_image_metadata", schema = "public")
public class InstaImageMetadata implements java.io.Serializable {

	private long imageMetadataId;
	private InstaImage instaImage;
	private String propertyName;
	private String propertyValue;
	private Date imageMetadataCreatedDate;

	public InstaImageMetadata() {
	}

	public InstaImageMetadata(long imageMetadataId, InstaImage instaImage,
			String propertyName, String propertyValue,
			Date imageMetadataCreatedDate) {
		this.imageMetadataId = imageMetadataId;
		this.instaImage = instaImage;
		this.propertyName = propertyName;
		this.propertyValue = propertyValue;
		this.imageMetadataCreatedDate = imageMetadataCreatedDate;
	}

	@Id
	@Column(name = "image_metadata_id", unique = true, nullable = false)
	public long getImageMetadataId() {
		return this.imageMetadataId;
	}

	public void setImageMetadataId(long imageMetadataId) {
		this.imageMetadataId = imageMetadataId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "image_id", nullable = false)
	public InstaImage getInstaImage() {
		return this.instaImage;
	}

	public void setInstaImage(InstaImage instaImage) {
		this.instaImage = instaImage;
	}

	@Column(name = "property_name", nullable = false, length = 1000)
	public String getPropertyName() {
		return this.propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	@Column(name = "property_value", nullable = false, length = 1000)
	public String getPropertyValue() {
		return this.propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "image_metadata_created_date", nullable = false, length = 29)
	public Date getImageMetadataCreatedDate() {
		return this.imageMetadataCreatedDate;
	}

	public void setImageMetadataCreatedDate(Date imageMetadataCreatedDate) {
		this.imageMetadataCreatedDate = imageMetadataCreatedDate;
	}

}