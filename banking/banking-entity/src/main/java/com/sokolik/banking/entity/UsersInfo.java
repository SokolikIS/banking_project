package com.sokolik.banking.entity;





public class UsersInfo {
	
	private int id;
	
	private String eMail;
	
	private String firstName;
	
	private String lastName;
	
	private String adress;
	
	private String sex;

	
	public UsersInfo() {
		
	}
	public UsersInfo(int id, String eMail, String firstName, String lastName, String adress, String sex) {
		
		this.id = id;
		this.eMail = eMail;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.sex = sex;
	}

	public UsersInfo(int id, String eMail) {
		
		this.id = id;
		this.eMail = eMail;
		
	}
	
	public UsersInfo( String eMail) {
		
	
		this.eMail = eMail;
		
	}
	
	public UsersInfo(int id) {
		
		this.id = id;
		
	}
	
	public UsersInfo(String eMail, String firstName, String lastName, String adress, String sex) {
		
		this.eMail = eMail;
		this.firstName = firstName;
		this.lastName = lastName;
		this.adress = adress;
		this.sex = sex;
	}
	
	public UsersInfo(String eMail, String sex) {
	
		this.eMail = eMail;
		this.sex = sex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((eMail == null) ? 0 : eMail.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
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
		UsersInfo other = (UsersInfo) obj;
			if (adress == null) {
				if (other.adress != null)
					return false;
			} else if (!adress.equals(other.adress))
				return false;
			if (eMail == null) {
				if (other.eMail != null)
					return false;
			} else if (!eMail.equals(other.eMail))
				return false;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (id != other.id)
				return false;
			if (lastName == null) {
				if (other.lastName != null)
					return false;
			} else if (!lastName.equals(other.lastName))
				return false;
			if (sex == null) {
				if (other.sex != null)
					return false;
			} else if (!sex.equals(other.sex))
				return false;
			return true;
	}

	@Override
	public String toString() {
		return "UsersInfo [id=" + id + ", eMail=" + eMail + ", firstName=" + firstName + ", lastName=" + lastName
			+ ", adress=" + adress + ", sex=" + sex + "]";
	}

}
