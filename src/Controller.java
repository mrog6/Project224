public class Controller {
    private Model model;
    private View view;

    public Controller(Model model) {
        this.model = model;
        this.view = new View(this);


    }

    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
    }
}
