import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.SingleThreadExecutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class acmo
  extends AbstractExecutorService
{
  private final int type;
  
  protected acmo(int paramInt)
  {
    this.type = paramInt;
  }
  
  public static ExecutorService a(int paramInt)
  {
    return new acmo(paramInt);
  }
  
  public static ExecutorService b(int paramInt)
  {
    return new SingleThreadExecutor(paramInt);
  }
  
  public boolean awaitTermination(long paramLong, @NonNull TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return false;
  }
  
  public void execute(@NonNull Runnable paramRunnable)
  {
    ThreadManagerV2.excute(paramRunnable, this.type, null, false);
  }
  
  public boolean isShutdown()
  {
    return false;
  }
  
  public boolean isTerminated()
  {
    return false;
  }
  
  public void shutdown()
  {
    throw new UnsupportedOperationException();
  }
  
  @NonNull
  public List<Runnable> shutdownNow()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     acmo
 * JD-Core Version:    0.7.0.1
 */