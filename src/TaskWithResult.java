import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id) {this.id =id;}
    public String call() {
        return "результат TaskWithResult "+id;
    }
}
