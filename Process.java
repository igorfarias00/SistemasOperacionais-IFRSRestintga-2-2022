import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Process {
    BufferedReader tcl = new BufferedReader(new InputStreamReader(System.in));
    public int execution;
    public int arrivalTime;
    public int waitingTime;
    public int id;
    public int priority;

    Random generator = new Random();

    public Process(boolean randomico, int id) throws IOException {
        if (randomico == true) {
            this.execution = generator.nextInt(1, 12);
        } else {
            this.execution = Integer.parseInt(tcl.readLine());
        }
        
        this.id = id;
    }

}
