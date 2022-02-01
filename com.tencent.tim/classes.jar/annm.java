import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.startup.step.ProcessInfoUtil.1;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class annm
{
  public static void QM(String paramString)
  {
    ThreadManager.post(new ProcessInfoUtil.1(paramString), 5, null, true);
  }
  
  public static long aK(String paramString)
  {
    long l2 = 0L;
    int i = getProcessPid(BaseApplicationImpl.getContext(), paramString);
    long l1;
    if (i == -1) {
      l1 = l2;
    }
    do
    {
      long l3;
      do
      {
        int j;
        do
        {
          do
          {
            return l1;
            j = eo(paramString);
            l1 = l2;
          } while (j == -1);
          l1 = l2;
        } while (i != j);
        l3 = aL(paramString);
        l1 = l2;
      } while (l3 == -1L);
      l2 = System.currentTimeMillis() - l3;
      l1 = l2;
    } while (!QLog.isColorLevel());
    QLog.d("ProcessUtils", 2, "getProcessRunningTime - " + paramString + ":" + l2);
    return l2;
  }
  
  public static long aL(String paramString)
  {
    long l = -1L;
    SharedPreferences localSharedPreferences = getPreference();
    if (localSharedPreferences != null) {
      l = localSharedPreferences.getLong("start_time" + paramString, -1L);
    }
    return l;
  }
  
  public static int eo(String paramString)
  {
    int i = -1;
    SharedPreferences localSharedPreferences = getPreference();
    if (localSharedPreferences != null) {
      i = localSharedPreferences.getInt("pid" + paramString, -1);
    }
    return i;
  }
  
  private static SharedPreferences getPreference()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      return localBaseApplicationImpl.getSharedPreferences("process_info_pref", 4);
    }
    return null;
  }
  
  public static int getProcessPid(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (paramContext != null)
      {
        paramContext = paramContext.getRunningAppProcesses();
        if (paramContext != null)
        {
          paramContext = paramContext.iterator();
          while (paramContext.hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
            if (paramString.compareTo(localRunningAppProcessInfo.processName) == 0) {
              return localRunningAppProcessInfo.pid;
            }
          }
        }
      }
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     annm
 * JD-Core Version:    0.7.0.1
 */