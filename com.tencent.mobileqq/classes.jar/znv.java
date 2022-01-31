import com.tencent.mobileqq.app.ThreadOptimizer;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ThreadFactory;

public final class znv
  implements ThreadFactory
{
  public Thread newThread(Runnable paramRunnable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThreadManager", 2, "new NetExcutor5Thread");
    }
    paramRunnable = new Thread(paramRunnable, "NetExcutor5Thread");
    if (ThreadOptimizer.a().c()) {
      paramRunnable.setPriority(1);
    }
    return paramRunnable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     znv
 * JD-Core Version:    0.7.0.1
 */