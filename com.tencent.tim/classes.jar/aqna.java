import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

public class aqna
{
  private static aqna.a a;
  
  public static void ap(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (a == null) {
      a = new aqna.a(3, 10L);
    }
    a.execute(paramRunnable);
  }
  
  static class a
    extends ThreadPoolExecutor
  {
    private static int eaa;
    
    public a(int paramInt, long paramLong)
    {
      super(2147483647, paramLong, TimeUnit.SECONDS, new LinkedBlockingQueue(), new aqnb(), new ThreadPoolExecutor.CallerRunsPolicy());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqna
 * JD-Core Version:    0.7.0.1
 */