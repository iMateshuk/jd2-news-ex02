package by.http.news.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import by.http.news.bean.News;
import by.http.news.bean.News.NewsBuilder;

public class NewsTool {

	private Map<NewsField, String> newsesData = new HashMap<>();
	private static final String EMPTY = "";

	public NewsTool() {

		newsesData.put(NewsField.TITLE, EMPTY);
		newsesData.put(NewsField.BRIEF, EMPTY);
		newsesData.put(NewsField.BODY, EMPTY);
	}

	public News create() {

		return generate();

	}

	private News generate() {
		
		newsesData.replace(NewsField.TITLE, genString((int) (Math.random() * 10 + 1)));
		newsesData.replace(NewsField.BRIEF, genString((int) (Math.random() * 10 + 1)));
		newsesData.replace(NewsField.BODY, genString((int) (Math.random() * 50 + 1)));

		NewsBuilder newsBuilder = new NewsBuilder();

		newsBuilder.setTitle(newsesData.get(NewsField.TITLE));
		newsBuilder.setBrief(newsesData.get(NewsField.BRIEF));
		newsBuilder.setBody(newsesData.get(NewsField.BODY));

		return newsBuilder.builder();

	}
	
	private String genString(int stringLenght) {

		// final String AZNUMBER =
		// "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		final String AZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

		Random random = new Random();

		StringBuilder sb = new StringBuilder(stringLenght);
		sb.append(AZ.charAt(random.nextInt(AZ.length())));
		for (int i = 0; i < stringLenght; i++) {
			sb.append(AZ.charAt(random.nextInt(AZ.length())));
		}
		String strnig = sb.toString().toLowerCase();
		return strnig.substring(0, 1).toUpperCase().concat(strnig.substring(1));

	}

}
