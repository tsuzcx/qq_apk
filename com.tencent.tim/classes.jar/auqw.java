import android.app.Notification;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.push.BadgeUtilImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.BadgeUtils.1;
import com.tencent.util.BadgeUtils.2;

public class auqw
{
  public static boolean djC;
  public static boolean djD;
  public static boolean djE;
  private static Runnable iw = new BadgeUtils.2();
  public static int mLimitCount;
  private static Handler sHandler = new Handler(Looper.getMainLooper());
  
  static
  {
    djC = true;
    mLimitCount = -1;
  }
  
  public static void clearAll()
  {
    sHandler.removeCallbacksAndMessages(null);
  }
  
  public static void ewn()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BadgeUtils", 2, "enableBadge mobileqq");
    }
    sHandler.removeCallbacksAndMessages(null);
    BadgeUtilImpl.enableBadge(BaseApplicationImpl.sApplication);
  }
  
  public static void ewo()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BadgeUtils", 2, "disableBadge mobileqq");
    }
    sHandler.removeCallbacksAndMessages(null);
    BadgeUtilImpl.disableBadge(BaseApplicationImpl.sApplication);
    sHandler.postDelayed(iw, 2000L);
  }
  
  public static int getLimitCount()
  {
    String str = "";
    int i;
    if (mLimitCount != -1) {
      i = mLimitCount;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BadgeUtils", 2, "getLimitCount Limitcount" + i);
      }
      return i;
      try
      {
        Object localObject = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1|1|999");
        if (QLog.isColorLevel()) {
          QLog.d("BadgeUtils", 2, "LimitConfig:" + (String)localObject);
        }
        localObject = ((String)localObject).split("\\|");
        if (localObject.length > 3) {
          str = localObject[3];
        }
        mLimitCount = Integer.valueOf(str).intValue();
        i = mLimitCount;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BadgeUtils", 2, "getLimitCount e:" + localException.toString());
        }
        mLimitCount = 999;
        i = mLimitCount;
      }
    }
  }
  
  public static boolean isSupportBadge(Context paramContext)
  {
    return BadgeUtilImpl.isSupportBadge(paramContext);
  }
  
  public static void setBadge(Context paramContext, int paramInt)
  {
    if ((!djC) && (paramInt > 0)) {}
    int i;
    do
    {
      do
      {
        return;
      } while (!isSupportBadge(paramContext));
      i = getLimitCount();
      QLog.d("BadgeUtils_UnreadMonitor", 1, "setBadge limit: " + i + ", count: " + paramInt);
      if (Looper.myLooper() == Looper.getMainLooper()) {
        break;
      }
      BadgeUtilImpl.setLimitCount(i);
      try
      {
        BadgeUtilImpl.setBadge(paramContext, paramInt);
        return;
      }
      catch (Exception paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.e("BadgeUtilImpl", 2, "badge not support");
    return;
    ThreadManager.executeOnSubThread(new BadgeUtils.1(i, paramContext, paramInt));
  }
  
  public static void setMIUI6Badge(Context paramContext, int paramInt, Notification paramNotification)
  {
    if (!djE) {
      if (!djD)
      {
        djE = CommonBadgeUtilImpl.isMIUI6();
        djD = true;
        if (djE) {}
      }
      else
      {
        return;
      }
    }
    QLog.d("BadgeUtils_UnreadMonitor", 1, "setMIUI6Badge count: " + paramInt);
    BadgeUtilImpl.setLimitCount(getLimitCount());
    BadgeUtilImpl.setMIUI6Badge(paramContext, paramInt, paramNotification);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auqw
 * JD-Core Version:    0.7.0.1
 */