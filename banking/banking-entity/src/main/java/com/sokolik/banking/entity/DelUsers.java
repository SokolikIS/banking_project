package com.sokolik.banking.entity;





public class DelUsers {

	
	private int id;
	
	private String login;
	
	private String password;

	private String ip;
	
	private int del_status;
	
	private String email;
	public DelUsers(int id, String login, String password, String ip, int del_status, String email) {
		
		this.id = id;
		this.login = login;
		this.password = password;
		this.ip = ip;
		this.del_status = del_status;
		this.email = email;
	}
	public DelUsers() {
		
	}
	public DelUsers(int id) {
		
		this.id = id;
		
	}
	public DelUsers(String login, String password, String email) {
		
		this.login = login;
		this.password = password;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getDel_status() {
		return del_status;
	}
	public void setDel_status(int del_status) {
		this.del_status = del_status;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + del_status;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((ip == null) ? 0 : ip.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DelUsers other = (DelUsers) obj;
		if (del_status != other.del_status)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (ip == null) {
			if (other.ip != null)
				return false;
		} else if (!ip.equals(other.ip))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DelUsers [id=" + id + ", login=" + login + ", password=" + password + ", ip=" + ip + ", del_status="
				+ del_status + ", email=" + email + "]";
	}
	
	
	
}
