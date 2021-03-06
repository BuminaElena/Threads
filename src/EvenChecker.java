import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements  Runnable {
    private  IntGenerator generator;
    private  final int id;

    public EvenChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val%2!=0) {
                System.out.println(val+" не является четным");
                generator.cancel();
            }
        }
    }

    public  static void test(IntGenerator gp, int count) {
        System.out.println("Нажмите Ctrl+C, чтобы завершить программу");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i<count; i++)
            exec.execute(new EvenChecker(gp, i));
            exec.shutdown();
    }

    public static void test(IntGenerator gp) {
        test(gp, 10);
    }
}