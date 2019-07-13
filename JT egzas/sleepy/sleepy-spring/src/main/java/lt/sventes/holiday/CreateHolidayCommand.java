package lt.sventes.holiday;

public final class CreateHolidayCommand {
	private long id;
	private String title;
	private String image;
		
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
