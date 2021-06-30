package by.http.news.util;

import java.util.HashMap;
import java.util.Map;

import by.http.news.bean.User;
import by.http.news.bean.User.UserBuilder;
import jakarta.servlet.http.HttpServletRequest;

public class UserCreator {

	private Map<UserField, String> fields = new HashMap<>();

	private static final String EMPTY = "";

	public UserCreator() {

		fields.put(UserField.NAME, EMPTY);
		fields.put(UserField.LOGIN, EMPTY);
		fields.put(UserField.PASSWORD, EMPTY);
		fields.put(UserField.EMAIL, EMPTY);

	}

	public User create(HttpServletRequest request) {
		
		for (Map.Entry<UserField, String> entry : fields.entrySet()) {

			entry.setValue(request.getParameter(entry.getKey().toString().toLowerCase()));
		}

		return create();
	}

	private User create() {

		UserBuilder userBuilder = new User.UserBuilder(fields.get(UserField.LOGIN), fields.get(UserField.PASSWORD));

		userBuilder.setName(fields.get(UserField.NAME));
		
		userBuilder.setEmail(fields.get(UserField.EMAIL));

		return userBuilder.build();

	}

}
