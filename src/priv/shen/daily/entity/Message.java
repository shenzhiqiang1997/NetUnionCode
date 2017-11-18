package priv.shen.daily.entity;

import java.util.Date;



public class Message {
	private Long id;
	private String name;
	private String message;
	
	private Date time;
	
	public Message() {
		super();
	}

	
	public Message(String name, String message) {
		super();
		this.name = name;
		this.message = message;
	}


	public Message(String name, String message, Date time) {
		super();
		this.name = name;
		this.message = message;
		this.time = time;
	}


	public Message(Long id, String name, String message, Date time) {
		super();
		this.id = id;
		this.name = name;
		this.message = message;
		this.time = time;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", name=" + name + ", message=" + message + ", time=" + time + "]";
	}
	
	
	
}
