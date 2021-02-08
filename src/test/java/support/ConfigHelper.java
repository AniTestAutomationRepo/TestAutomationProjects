package support;

import java.util.Map;

public class ConfigHelper {

    public static Map<String, String> configProperties;
    public static String getConfigProperties(String key) {
        return configProperties.get(key);
    }

}
