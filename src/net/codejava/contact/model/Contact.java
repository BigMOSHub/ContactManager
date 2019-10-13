package net.codejava.contact.model;

public class Contact {
	private Integer	id;
	private String name;
	private String email;
	private String address;
	private String phone;
	
	public Contact(Integer id, String name, String email, String address, String phone) {
		//getters and setters
		this(name,email, address, phone);
		System.out.println("ContactModel Contact - linea 13 - inicio - -this.otros y id -getters and setters-");
		this.id = id;
//		this.name = name;
//		this.email = email;
//		this.address = address;
//		this.phone = phone;	
		System.out.println("ContactModel Contact - linea 19 - fin- -this.otros y id -getters and setters-");
	}

	
	
	public Contact(String name, String email, String address, String phone) {
		System.out.println("ContactModel Contact - linea 25 inicio -this.los otros campos- constructor-");
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		System.out.println("ContactModel Contact - linea 30 fin -this.los otros campos- constructor-");
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
		System.out.println("ContactModel getEmail - linea 61-return email");
		return email;
	}

	public void setEmail(String email) {
		System.out.println("ContactModel setEmail - linea 66-this.email");
		this.email = email;
	}

	public String getAddress() {
		System.out.println("ContactModel getAddress - linea 71-return address");
		return address;
	}

	public void setAddress(String address) {
		System.out.println("ContactModel setAddress - linea 76-this.address");
		this.address = address;
	}

	public String getPhone() {
		System.out.println("ContactModel getPhone - linea 81-return phone");
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
		System.out.println("ContactModel setPhone - linea 87-this.phone");
	}

	
	@Override
	public String toString() {
		System.out.println("ContactModel - toString - linea 74");
		return "Contact [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", phone=" + phone
				+ "]";
		
	}
	
}

