package by.http.news.bean;

import java.io.Serializable;
import java.util.Objects;

public class UserData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String login;
	private String password;
	private String email;
	private String role;

	public UserData() {

	}

	UserData(UserDataBuilder builder) {
		this.name = builder.name;
		this.login = builder.login;
		this.role = builder.role;
		this.password = builder.password;
		this.email = builder.email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(email, login, name, password, role);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserData other = (UserData) obj;
		return Objects.equals(email, other.email) && Objects.equals(login, other.login)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password)
				&& Objects.equals(role, other.role);
	}

	@Override
	public String toString() {
		return getClass().getName() + " [name=" + name + ", login=" + login + ", password=" + password + ", email="
				+ email + ", role=" + role + "]";
	}

	// Builder

	public static class UserDataBuilder {

		// required

		// optional
		private String login;
		private String role;
		private String password;
		private String name;
		private String email;

		public UserDataBuilder() {
		}

		public UserDataBuilder setLogin(String login) {
			this.login = login;
			return this;
		}

		public UserDataBuilder setRole(String role) {
			this.role = role;
			return this;
		}

		public UserDataBuilder setPassword(String password) {
			this.password = password;
			return this;
		}

		public UserDataBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public UserDataBuilder setEmail(String email) {
			this.email = email;
			return this;
		}

		public UserData build() {
			return new UserData(this);
		}
	}

}
