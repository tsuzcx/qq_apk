import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.List;

public class ihq
  extends ihv.c
{
  public static final String ME = ;
  
  public static void m(String paramString, long paramLong)
  {
    try
    {
      QLog.d("VideoUtils", 1, String.format("requestPartialWakeLock tag=%s timeout=%s", new Object[] { paramString, Long.valueOf(paramLong) }));
      PowerManager localPowerManager = (PowerManager)BaseApplication.getContext().getSystemService("power");
      if (localPowerManager != null) {
        localPowerManager.newWakeLock(1, paramString).acquire(paramLong);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d(paramString, 1, "requestPartialWakeLock fail.", localThrowable);
    }
  }
  
  public static void n(String paramString, long paramLong)
  {
    try
    {
      QLog.d("VideoUtils", 1, String.format("requestScreenBrightWakeLock tag=%s timeout=%s", new Object[] { paramString, Long.valueOf(paramLong) }));
      PowerManager localPowerManager = (PowerManager)BaseApplication.getContext().getSystemService("power");
      if (localPowerManager != null) {
        localPowerManager.newWakeLock(805306378, paramString).acquire(paramLong);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d(paramString, 1, "requestScreenBrightWakeLock fail.", localThrowable);
    }
  }
  
  public static final boolean sH()
  {
    for (;;)
    {
      int j;
      try
      {
        boolean bool = LocalMultiProcConfig.getBool("is_qzone_live_launch", false);
        QLog.d("VideoUtils", 1, "isQzoneLiveExist, isRunning=" + bool);
        if (!bool) {
          return false;
        }
        int i = -2;
        List localList = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
        if (localList != null)
        {
          j = 0;
          if (j < localList.size())
          {
            if ("com.tencent.mobileqq:qzonelive".equals(((ActivityManager.RunningAppProcessInfo)localList.get(j)).processName))
            {
              i = ((ActivityManager.RunningAppProcessInfo)localList.get(j)).pid;
              break label184;
            }
          }
          else
          {
            j = LocalMultiProcConfig.getInt("qzone_live_process_id", -1);
            QLog.d("VideoUtils", 1, "isQzoneLiveExist, processId=" + i + ", id=" + j);
            if (i == j)
            {
              bool = true;
              return bool;
            }
            bool = false;
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("VideoUtils", 1, localException, new Object[0]);
        return false;
      }
      return false;
      label184:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ihq
 * JD-Core Version:    0.7.0.1
 */