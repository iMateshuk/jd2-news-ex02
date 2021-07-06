package by.http.news.controller;

import java.util.HashMap;
import java.util.Map;

import by.http.news.controller.impl.GoToAnswerPage;
import by.http.news.controller.impl.GoToAuthorizationPage;
import by.http.news.controller.impl.GoToMainPage;
import by.http.news.controller.impl.GoToRegistrationPage;
import by.http.news.controller.impl.GoToUserActionPage;
import by.http.news.controller.impl.LoggedOut;
import by.http.news.controller.impl.UnknownCommand;
import by.http.news.controller.impl.UserAuthorization;
import by.http.news.controller.impl.UserRegistration;

public class CommandProvider {

	private Map<CommandName, Command> commands = new HashMap<>();

	public CommandProvider() {
		
		commands.put(CommandName.AUTHORIZATION, new GoToAuthorizationPage());
		commands.put(CommandName.REGISTRATION, new GoToRegistrationPage());
		commands.put(CommandName.USER_ACTION, new GoToUserActionPage());
		commands.put(CommandName.USER_ANSWER, new GoToAnswerPage());
		commands.put(CommandName.INDEX, new GoToMainPage());
		commands.put(CommandName.MAIN, new GoToMainPage());
		commands.put(CommandName.USER_AUTHORIZATION, new UserAuthorization());
		commands.put(CommandName.USER_REGISTRATION, new UserRegistration());
		commands.put(CommandName.LOGGEDOUT, new LoggedOut());

		commands.put(CommandName.UNKNOWN_COMMAND, new UnknownCommand());
		
	}

	public Command findCommand(String name) {

		if (name == null || name.isEmpty() || name.isBlank()) {

			name = CommandName.UNKNOWN_COMMAND.toString();
		}

		CommandName commandName;
		
		try {
			
			commandName = CommandName.valueOf(name.toUpperCase());
			
		} catch (IllegalArgumentException e) {
			
			// logging
			commandName = CommandName.UNKNOWN_COMMAND;
		}

		return commands.get(commandName);
	}

}
