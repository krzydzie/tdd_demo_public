package pl.jenkins.library;

import java.util.ArrayList;
import java.util.List;

public class JsonList implements Json {

    private final List<Json> list;

    JsonList() {
        this(new ArrayList<>());
    }

    JsonList(List<Json> list) {
        this.list = list;
    }

    @Override
    public JsonList asJsonList() {
        return this;
    }

    public JsonMap addItem(String... pairs) {
        JsonMap jsonMap = new JsonMap();
        list.add(jsonMap);
        for (int i = 0; i < pairs.length; i += 2) {
            if (i + 1 == pairs.length) {
                throw new JenkinsException(String.format("Attribute %s without value.", pairs[i]));
            }
            jsonMap.addAttribute(pairs[i], pairs[i + 1]);
        }
        return jsonMap;
    }

    public List<Json> getList() {
        return list;
    }
}
