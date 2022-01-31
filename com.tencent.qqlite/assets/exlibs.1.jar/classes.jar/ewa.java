import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.TimeUnit;

public class ewa
  extends ThreadPoolExecutor
{
  private static int a = 0;
  public static final String a = "InfiniteTaskThread_";
  
  public ewa(int paramInt, long paramLong)
  {
    super(paramInt, 2147483647, paramLong, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ewb(), new ThreadPoolExecutor.CallerRunsPolicy());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ewa
 * JD-Core Version:    0.7.0.1
 */