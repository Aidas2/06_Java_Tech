package lt.sventes.holiday;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public final class Holiday {
	@Id
	private long id;
	@Column
	private String title;
	@Column
	private String image;
	
	public Holiday() {
	}

	public Holiday(long id, String title, String image) {
		this.id = id;
		this.title = title;
		this.image = image;
	}
	
	// toliau - get ir set metodai

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
