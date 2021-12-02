import java.io.File;
import java.util.Arrays;
import java.util.List;

public class SearchCommand extends Command {

    public SearchCommand() {
        super("search");
    }

    @Override
    public void execute(String[] args, String[] options) {
        if (args.length != 2) {
            respond(String.format("This command takes 2 arguments, <pattern> and <file>, but was given %d.", args.length));
            return;
        }

        String pattern = args[0];
        String filepath = args[1];
        boolean caseInsensitive = Arrays.stream(options).anyMatch(option -> option.equals("-i"));
        
        File file = new File(filepath);
        if (!file.exists() || file.isDirectory()) {
            respond(String.format("File \"%s\" does not exist or is a directory.", filepath));
            return;
        }

        PatternFinder finder = new PatternFinder(file);
        List<String> matches = finder.find(pattern, caseInsensitive);
        for (String match : matches) {
            respond(match);
        }

        if (matches.isEmpty()) {
            respond("No matches found.");
        }
    }
    
}
