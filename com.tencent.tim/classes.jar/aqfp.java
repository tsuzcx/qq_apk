import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aqfp
{
  private static int dYX = 1;
  private static Handler mHandler = new aqfq(ThreadManager.getSubThreadLooper());
  private static HashMap<Long, Integer> oO = new HashMap(40);
  
  public static void Sz(boolean paramBoolean)
  {
    Handler localHandler = mHandler;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      localHandler.sendEmptyMessage(i);
      return;
    }
  }
  
  private static Thread[] a()
  {
    try
    {
      ThreadGroup localThreadGroup = Thread.currentThread().getThreadGroup();
      Thread[] arrayOfThread = new Thread[localThreadGroup.activeCount()];
      localThreadGroup.enumerate(arrayOfThread);
      return arrayOfThread;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThreadPriorityManager", 2, "", localException);
      }
    }
    return new Thread[0];
  }
  
  private static void edB()
  {
    mHandler.removeMessages(1);
    mHandler.sendEmptyMessageDelayed(1, 30000L);
    if (oO.size() > 0) {}
    Thread[] arrayOfThread;
    Thread localThread1;
    Thread localThread2;
    int j;
    int i;
    do
    {
      return;
      arrayOfThread = a();
      if (arrayOfThread.length < 2)
      {
        mHandler.removeMessages(1);
        return;
      }
      localThread1 = Looper.getMainLooper().getThread();
      localThread2 = ThreadManager.getSubThread();
      j = arrayOfThread.length;
      i = 0;
    } while (i >= j);
    Thread localThread3 = arrayOfThread[i];
    if ((localThread3 != null) && (localThread1 != null) && (localThread2 != null) && (localThread3.getId() != localThread2.getId()) && (localThread3.getId() != localThread1.getId()) && (localThread3.isAlive())) {}
    for (;;)
    {
      try
      {
        l = localThread3.getId();
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        try
        {
          oO.put(Long.valueOf(l), Integer.valueOf(localThread3.getPriority()));
          localThread3.setPriority(dYX);
          i += 1;
        }
        catch (IllegalArgumentException localIllegalArgumentException2)
        {
          long l;
          break label175;
        }
        localIllegalArgumentException1 = localIllegalArgumentException1;
        l = -1L;
      }
      label175:
      if (l != -1L) {
        oO.remove(Long.valueOf(l));
      }
    }
  }
  
  private static void edC()
  {
    if (oO.size() <= 0) {
      return;
    }
    Thread[] arrayOfThread = a();
    int k = arrayOfThread.length;
    int j = 0;
    int i = 0;
    for (;;)
    {
      Thread localThread;
      if (j < k)
      {
        localThread = arrayOfThread[j];
        if ((localThread == null) || (!localThread.isAlive())) {
          break label130;
        }
        Integer localInteger = (Integer)oO.get(Long.valueOf(localThread.getId()));
        if (localInteger == null) {
          break label127;
        }
        i = localInteger.intValue();
      }
      label127:
      for (;;)
      {
        if ((i != 0) && (i <= 10) && (i >= 1)) {}
        try
        {
          localThread.setPriority(i);
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          QLog.e("ThreadPriorityManager", 1, "setPriority error");
        }
        localThread.setPriority(5);
        break;
        oO.clear();
        return;
      }
      label130:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqfp
 * JD-Core Version:    0.7.0.1
 */