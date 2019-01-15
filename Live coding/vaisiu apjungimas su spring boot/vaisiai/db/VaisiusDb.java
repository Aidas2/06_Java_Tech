package it.akademija.vaisiai.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VaisiusDb {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String pictureId;
	private String titleVal;
	private String descVal;
	private String linkVal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPictureId() {
		return pictureId;
	}

	public void setPictureId(String pictureId) {
		this.pictureId = pictureId;
	}

	public String getTitleVal() {
		return titleVal;
	}

	public void setTitleVal(String titleVal) {
		this.titleVal = titleVal;
	}

	public String getDescVal() {
		return descVal;
	}

	public void setDescVal(String descVal) {
		this.descVal = descVal;
	}

	public String getLinkVal() {
		return linkVal;
	}

	public void setLinkVal(String linkVal) {
		this.linkVal = linkVal;
	}
}
