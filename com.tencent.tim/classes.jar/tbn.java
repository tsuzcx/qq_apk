import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class tbn
{
  private static tbn a;
  private ExecutorService mThreadPool = Executors.newFixedThreadPool(5);
  
  public static tbn a()
  {
    if (a == null) {
      a = new tbn();
    }
    return a;
  }
  
  public void submit(Runnable paramRunnable)
  {
    this.mThreadPool.submit(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tbn
 * JD-Core Version:    0.7.0.1
 */