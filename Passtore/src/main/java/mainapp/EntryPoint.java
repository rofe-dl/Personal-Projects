package mainapp;

//this is needed as JAR file won't start with a main class that inherits a third party class (weird)
//so program has to start here
public class EntryPoint {
    public static void main(String[] args) {
        Passtore.main(args);
    }
}
