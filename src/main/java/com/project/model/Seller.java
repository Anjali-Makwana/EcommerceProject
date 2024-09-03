package com.project.model;

public class Seller {

	private int id;
	private long contact;
	private String name;
	private String addres;
	private String email;
	private String pass;
	private String cpass;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getCpass() {
		return cpass;
	}

	public void setCpass(String cpass) {
		this.cpass = cpass;
	}

	@Override
	public String toString() {
		return "Seller [id=" + id + ", contact=" + contact + ", name=" + name + ", addres=" + addres + ", email="
				+ email + ", pass=" + pass + ", cpass=" + cpass + "]";
	}

}