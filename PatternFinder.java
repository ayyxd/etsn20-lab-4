import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PatternFinder {

    private File file;

    public PatternFinder(File file) {
        this.file = file;
    }

    /**
     * @param pattern The text that needs to be contained within a line for it to be returned.
     * @return A list of lines containing the given pattern.
     */
    public List<String> find(String pattern, boolean caseInsensitive) {
        List<String> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (caseInsensitive) {
                    line = line.toLowerCase();
                    pattern = pattern.toLowerCase();
                }

                if (line.contains(pattern)) {
                    result.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }
}
