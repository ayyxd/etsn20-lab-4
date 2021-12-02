import java.util.ArrayList;
import java.util.List;

public class CommandHandler {
    
    private static List<Command> commands = new ArrayList<Command>() {{
    }};

    /**
     * Attempts to find and execute the command contained within the given input string, if any.
     * @param input The input from the user.
     * @return Whether a command was executed.
     * @example execute("search cat README.md") -> true
     */
    public static boolean execute(String input) {
        String name = input.split(" ")[0];
        String[] args = getArguments(input);
        String[] options = getOptions(input);

        for (Command command : commands) {
            if (command.getName().equals(name)) {
                command.execute(args, options);
                return true;
            }
        }

        return false;
    }

    /**
     * @param input The text to split.
     * @return All words after the command name, excluding options.
     * @example getArguments("search cat README.md -i") -> ["cat", "README.md"]
     */
    public static String[] getArguments(String input) {
        String[] splits = input.split(" ");
        List<String> args = new ArrayList<String>();

        for (int i = 0; i < splits.length; ++i) {
            String split = splits[i];

            boolean isCommandName = i == 0;
            boolean isOption = split.startsWith("-");

            if (isCommandName || isOption) {
                continue;
            }

            args.add(split);
        }

        return args.toArray(new String[0]);
    }

    /**
     * @param input The text to split.
     * @return All words starting with, and including, "-".
     * @example getOptions("search cat README.md -i") -> ["-i"]
     */
    public static String[] getOptions(String input) {
        String[] splits = input.split(" ");
        List<String> options = new ArrayList<String>();

        for (String split : splits) {
            if (split.startsWith("-")) {
                options.add(split);
            }
        }

        return options.toArray(new String[0]);
    }
}
