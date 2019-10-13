package net.codejava.contact.model;

public class Contact {
	private Integer	id;
	private String name;
	private String email;
	private String address;
	private String phone;
	
//	public Contact() {
//		
//	}

	public Contact(Integer id, String name, String email, String address, String phone) {
//		this(name,email, address, phone);
		System.out.println("ContactModel Contact - linea 16 -this.id y otros -getters and setters-");
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;	
		//getters and setters
		System.out.println("ContactModel Contact - linea 23 -this.id y otros -getters and setters-");
	}

	
	public Contact(String name, String email, String address, String phone) {
		System.out.println("ContactModel Contact - linea 25 inicio -this.los otros campos- getters and setters-");
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		System.out.println("ContactModel Contact - linea 30 fin -this.los otros campos- getters and setters-");
	}

	
	public Contact() {
		// TODO Auto-generated constructor stub
		System.out.println("ContactModel Contact - linea 36 -Constructor-");
	}


	public Integer getId() {
		System.out.println("ContactModel getId - linea 41-return id");
		return id;
	}

	public void setId(Integer id) {
		System.out.println("ContactModel setId - linea 46-this.id");
		this.id = id;
	}

	public String getName() {
		System.out.println("ContactModel getName - linea 51-return name");
		return name;
	}

	public void setName(String name) {
		System.out.println("ContactModel setName - linea 56-this.name");
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	@Override
	public String toString() {
		System.out.println("Contact linea 74");
		
		return "Contact [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", phone=" + phone
				+ "]";
		
	}
	
}

