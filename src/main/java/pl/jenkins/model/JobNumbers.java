package pl.jenkins.model;

import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.List;
import pl.jenkins.library.Json;
import pl.jenkins.library.JsonList;
import pl.jenkins.library.JsonMap;

public class JobNumbers {

    private final List<String> numbers = new ArrayList<>();

    public JobNumbers(JsonMap json) {
        List<Json> buildList = json.findList("builds").map(JsonList::getList).orElse(emptyList());

        for (Json item : buildList) {
            String number = item.asJsonMap().getAttribute("number");
            numbers.add(number);
        }
    }

    public List<String> getNumbers() {
        return numbers;
    }
}
