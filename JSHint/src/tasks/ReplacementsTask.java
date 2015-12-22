package tasks;

import static java.util.Collections.unmodifiableMap;
import static tasks.TaskType.REPLACE;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReplacementsTask implements ITask {

    private Map<String, String> replacements;

    public ReplacementsTask() {
        this.replacements = new LinkedHashMap<String, String>();
    }

    @Override
    public TaskType getType() {
        return REPLACE;
    }

    @Override
    public String getText() {
        return null;
    }

    public void addReplacements(final String key, final String value) {
        this.replacements.put(key, value);
    }

    public Map<String, String> getReplacements() {
        return unmodifiableMap(this.replacements);
    }

}
