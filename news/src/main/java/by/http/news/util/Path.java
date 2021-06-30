package by.http.news.util;

public enum Path {
	
	TEMP_DIR(System.getProperty("java.io.tmpdir")),
	LOG_FILE(TEMP_DIR + System.getProperty("path.separator") +"progectJava.log");

	private String string;

	Path(String string) {
		this.string = string;

	}

	public String getPath() {
		return string;
	}

}
