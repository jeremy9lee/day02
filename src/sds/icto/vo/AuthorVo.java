package sds.icto.vo;

public class AuthorVo {
	private long id;
	private String name;
	private String bio;
	public AuthorVo(long id, String name, String bio) {
		super();
		this.id = id;
		this.name = name;
		this.bio = bio;
	}
	public AuthorVo() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	@Override
	public String toString() {
		return "AuthorVo [id=" + id + ", name=" + name + ", bio=" + bio + "]";
	}
	
	
	
}
