public abstract class Command {

    private String name;

    public Command(String name) {
        this.name = name;
    }

    /**
     * @return The name of the command, which is used to execute it by the user.
     */
    public String getName() {
        return name;
    };

    /**
     * Formats the output of the command.
     * @param output The text to write to the user.
     */
    public void respond(String output) {
        System.out.println(String.format("< %s", output));
    }

    /**
     * Executes this command with the given arguments and options.
     * @param args The arguments of the command (e.g. ["cat", "README.md"]).
     * @param options The options of the command (e.g. ["-i"]). These all start with "-".
     */
    public abstract void execute(String[] args, String[] options);

}