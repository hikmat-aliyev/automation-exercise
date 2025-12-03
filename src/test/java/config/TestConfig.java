package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class TestConfig {

    private static final Properties props = new Properties();

    static {
        loadConfig();
    }

    private static void loadConfig() {
        try (InputStream input = TestConfig.class.getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException(
                        "config.properties not found! Make sure it's in src/test/resources/");
            }
            props.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static final String APP_URL = props.getProperty("app.url");
    public static final String BROWSER = props.getProperty("browser");
    public static final boolean HEADLESS = Boolean.parseBoolean(props.getProperty("headless"));
    public static final int SLOW_MO = Integer.parseInt(props.getProperty("slowMo"));

    private TestConfig() {}
}