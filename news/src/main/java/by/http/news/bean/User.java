package by.http.news.bean;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String login;
	private String email;
	private String role;

	public User() {
	}

	public User(String login, String role) {
		super();
		this.login = login;
		this.role = role;
		this.name = "noName";
		this.email = "noEmail";
	}

	public User(String name, String login, String role) {
		super();
		this.name = name;
		this.login = login;
		this.role = role;
	}

	User(UserBuilder builder) {
		this.name = builder.name;
		this.login = builder.login;
		this.role = builder.role;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, login, name, role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(email, other.email) && Objects.equals(login, other.login)
				&& Objects.equals(name, other.name) && Objects.equals(role, other.role);
	}
	
	@Override
	public String toString() {
		return getClass().getName() + " [name=" + name + ", login=" + login + ", role=" + role + ", email="
				+ email + "]";
	}
	
	// Builder

	public static class UserBuilder {

		// required
		private String login;
		private String role;
		// optional
		private String name;
		private String email;

		public UserBuilder(String login, String role) {
			this.login = login;
			this.role = role;
		}

		public UserBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public UserBuilder setEmail(String email) {
			this.email = email;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}

}
