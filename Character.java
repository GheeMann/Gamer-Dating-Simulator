public class Character {
    private String name;
    private String description;
    private String portraitPath;

    public Character(String name, String description, String portraitPath) {
        this.name = name;
        this.description = description;
        this.portraitPath = portraitPath;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getPortraitPath() { return portraitPath; }
}
