public class MainApplication {
    /**
     * Private Constructor
     */
    private MainApplication() {
    }

    /**
     * Main Method, Standard MVC
     */
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        view.registerObserver(controller);
    }
}
