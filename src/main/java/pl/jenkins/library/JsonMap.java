package pl.jenkins.library;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class JsonMap implements Json {

    private final Map<String, Json> map;

    JsonMap() {
        map = new HashMap<>();
    }

    public static final JsonMap create() {
        return new JsonMap();
    }

    @Override
    public JsonMap asJsonMap() {
        return this;
    }

    public JsonList addList(String key) {
        JsonList jsonList = new JsonList();
        map.put(key, jsonList);
        return jsonList;
    }

    public Optional<JsonList> findList(String key) {
        return Optional.ofNullable(map.get(key)).map(Json::asJsonList);
    }

    public JsonList getList(String key) {
        return Optional.of(map.get(key)).map(Json::asJsonList).orElseThrow();
    }

    public void addAttribute(String key, String val) {
        map.put(key, new JsonValue(val));
    }

    public Optional<JsonValue> findAttribute(String key) {
        return Optional.ofNullable(map.get(key)).map(Json::asJsonValue);
    }

    public String getAttribute(String key) {
        if (!map.containsKey(key)) {
            return null;
        }
        return map.get(key).asJsonValue().getValue();
    }

    public JsonMap addMap(String key) {
        JsonMap jsonMap = create();
        map.put(key, jsonMap);
        return jsonMap;
    }

    public JsonMap getMap(String key) {
        return Optional.of(map.get(key)).map(Json::asJsonMap).orElseThrow();
    }
}
