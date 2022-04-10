package be.adidas.cedeno.klara.data;

import java.util.Arrays;
import java.util.List;


public class Pet {

	private Category category;
	
	private Long id;
	
	private String name;
	
	private String[] photoUrls;
	
	private String status;
	
	private List<Tag> tags;
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
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
	public String[] getPhotoUrls() {
		return photoUrls;
	}
	public void setPhotoUrls(String[] photoUrls) {
		this.photoUrls = photoUrls;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	@Override
	public String toString() {
		return "Pet [category=" + category + ", id=" + id + ", name=" + name + ", photoUrls="
				+ Arrays.toString(photoUrls) + ", status=" + status + ", tags=" + tags + "]";
	}
	
	
}
