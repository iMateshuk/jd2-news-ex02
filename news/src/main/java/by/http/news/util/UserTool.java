package by.http.news.util;

import java.util.HashMap;
import java.util.Map;

import by.http.news.bean.User;
import by.http.news.bean.User.UserBuilder;
import by.http.news.bean.UserData;
import by.http.news.bean.UserData.UserDataBuilder;
import jakarta.servlet.http.HttpServletRequest;

public class UserTool {

	private Map<UserField, String> fieldsData = new HashMap<>();

	private static final String EMPTY = "";

	public UserTool() {

		fieldsData.put(UserField.NAME, EMPTY);
		fieldsData.put(UserField.LOGIN, EMPTY);
		fieldsData.put(UserField.PASSWORD, EMPTY);
		fieldsData.put(UserField.EMAIL, EMPTY);
		fieldsData.put(UserField.ROLE, EMPTY);

	}

	public UserData create(HttpServletRequest request) {

		for (Map.Entry<UserField, String> entry : fieldsData.entrySet()) {

			entry.setValue(request.getParameter(entry.getKey().toString().toLowerCase()));
		}

		return createUserData();
	}

	private UserData createUserData() {
		
		UserDataBuilder userDataBuilder = new UserData.UserDataBuilder();
		
		userDataBuilder.setName(fieldsData.get(UserField.NAME));
		userDataBuilder.setLogin(fieldsData.get(UserField.LOGIN));
		userDataBuilder.setPassword(fieldsData.get(UserField.PASSWORD));
		userDataBuilder.setRole(fieldsData.get(UserField.ROLE));
		userDataBuilder.setEmail(fieldsData.get(UserField.EMAIL));
		
		if (fieldsData.get(UserField.ROLE) == null) {
			
			userDataBuilder.setRole("user");
		}
		
		return userDataBuilder.build();
		
	}

	public User create(UserData userData) {

		fieldsData.replace(UserField.NAME, userData.getName());
		fieldsData.replace(UserField.LOGIN, userData.getLogin());
		fieldsData.replace(UserField.EMAIL, userData.getEmail());
		fieldsData.replace(UserField.ROLE, userData.getRole());

		return createUser();
	}

	private User createUser() {

		UserBuilder userBuilder = new User.UserBuilder(fieldsData.get(UserField.LOGIN), fieldsData.get(UserField.ROLE));

		userBuilder.setName(fieldsData.get(UserField.NAME));

		userBuilder.setEmail(fieldsData.get(UserField.EMAIL));

		return userBuilder.build();

	}

}
