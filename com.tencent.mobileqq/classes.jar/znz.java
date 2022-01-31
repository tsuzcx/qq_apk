import android.os.HandlerThread;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import mqq.os.MqqHandler;

public class znz
  extends ThreadPoolExecutor
{
  private static MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private int jdField_a_of_type_Int;
  protected long a;
  private zoa jdField_a_of_type_Zoa = new zoa(this);
  
  public znz(int paramInt1, int paramInt2, long paramLong, BlockingQueue paramBlockingQueue, zjv paramzjv)
  {
    super(paramInt1, paramInt2, paramLong, TimeUnit.SECONDS, paramBlockingQueue, paramzjv);
    this.jdField_a_of_type_Long = -1L;
    setRejectedExecutionHandler(this.jdField_a_of_type_Zoa);
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  private StringBuilder a(String paramString)
  {
    QLog.e("ThreadManager", 1, "\ngetRunningJob from: " + paramString);
    paramString = new StringBuilder();
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((ConcurrentLinkedQueue)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        paramString.append("\nRunning_J_InAllPool: " + str);
      }
    }
    return paramString;
  }
  
  private static MqqHandler c()
  {
    if (jdField_a_of_type_MqqOsMqqHandler == null) {
      try
      {
        Object localObject = ThreadExcutor.a().a("Rejected_Handler", 10);
        ((HandlerThread)localObject).start();
        jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(((HandlerThread)localObject).getLooper());
        localObject = jdField_a_of_type_MqqOsMqqHandler;
        return localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("ThreadManager", 1, "getRejectedHandler:", localOutOfMemoryError);
      }
    }
    return jdField_a_of_type_MqqOsMqqHandler;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected String a()
  {
    return "ThreadSmartPool";
  }
  
  protected ConcurrentLinkedQueue a()
  {
    return null;
  }
  
  protected void a()
  {
    if (!ThreadExcutor.a) {}
  }
  
  public void execute(Runnable paramRunnable)
  {
    if (ThreadManager.IsRunTimeShutDown) {
      QLog.e("ThreadManager", 1, "pool has shutdown:" + paramRunnable.toString());
    }
    for (;;)
    {
      return;
      try
      {
        if ((QLog.isColorLevel()) && (ThreadManager.logcatBgTaskMonitor)) {
          QLog.d("ThreadManager", 2, "tsp execute:" + paramRunnable.toString());
        }
        super.execute(paramRunnable);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("ThreadManager", 1, "commamd:" + paramRunnable.toString(), localOutOfMemoryError);
        jdField_a_of_type_MqqOsMqqHandler = c();
        if (jdField_a_of_type_MqqOsMqqHandler != null)
        {
          jdField_a_of_type_MqqOsMqqHandler.post(paramRunnable);
          return;
        }
      }
      catch (InternalError paramRunnable)
      {
        QLog.e("ThreadManager", 1, "java.lang.InternalError: Thread starting during runtime shutdown", paramRunnable);
      }
    }
  }
  
  protected void terminated()
  {
    super.terminated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     znz
 * JD-Core Version:    0.7.0.1
 */