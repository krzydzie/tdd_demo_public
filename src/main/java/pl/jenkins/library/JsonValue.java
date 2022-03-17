package pl.jenkins.library;

public class JsonValue implements Json {

    private final String value;

    public JsonValue(String value) {
        this.value = value;
    }

    @Override
    public JsonValue asJsonValue() {
        return this;
    }

    public String getValue() {
        return value;
    }
}
