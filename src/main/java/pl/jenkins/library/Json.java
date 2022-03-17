package pl.jenkins.library;

public interface Json {

    private static JenkinsException castException(Class currentClass, String wrongClass) {
        return new JenkinsException(String.format("%s is not %s", currentClass, wrongClass));
    }

    default JsonMap asJsonMap() {
        throw castException(getClass(), "JsonMap");
    }

    default JsonList asJsonList() {
        throw castException(getClass(), "JsonList");
    }

    default JsonValue asJsonValue() {
        throw castException(getClass(), "JsonValue");
    }

}
