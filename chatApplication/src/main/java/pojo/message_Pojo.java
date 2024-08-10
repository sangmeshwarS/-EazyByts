package pojo;

public class message_Pojo {
	
	private int id;
	private int sid;
	private String name;
	private String message;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public message_Pojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public message_Pojo(int sid, String name, String message) {
		super();
		this.sid = sid;
		this.name = name;
		this.message = message;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "message_Pojo [id=" + id + ", sid=" + sid + ", name=" + name + ", message=" + message + "]";
	}
	
	

}
