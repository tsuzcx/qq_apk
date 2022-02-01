import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.parcelUtils.ParcelHelper;
import com.tencent.mobileqq.activity.recent.parcelUtils.ParcelHelper.FieldChangedException;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

public class aako
{
  private static AtomicInteger aH = new AtomicInteger(-1);
  private static AtomicInteger aI = new AtomicInteger(-1);
  private static AtomicBoolean bU = new AtomicBoolean(true);
  private static AtomicBoolean bV = new AtomicBoolean(false);
  
  public static boolean L(@NonNull QQAppInterface paramQQAppInterface)
  {
    if (bU.get())
    {
      bV.set(M(paramQQAppInterface));
      bU.set(false);
    }
    return bV.get();
  }
  
  private static boolean M(@NonNull QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("BootOptimize", 0);
    boolean bool2 = paramQQAppInterface.getBoolean("_useParcelForBoot", true);
    boolean bool3 = paramQQAppInterface.getBoolean("3.4.4_has_crash_when_parcel", false);
    long l = paramQQAppInterface.getLong("_last_crash_time", 0L);
    if (System.currentTimeMillis() - l < 1800000L) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BootOptimize", 2, new Object[] { "getUseBootOptimize=[isDebugVersion=", Boolean.valueOf(false), ", use_parcel:", Boolean.valueOf(bool2), ", has_crash=", Boolean.valueOf(bool3), ", appVersion=", "3.4.4", ", lastCrashTime=", Long.valueOf(l), " recentCrash=", Boolean.valueOf(bool1), "]" });
      }
      if ((!bool2) || (bool3) || (bool1)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  @Nullable
  public static RecentBaseData a(QQAppInterface paramQQAppInterface, Context paramContext, @NonNull RecentUser paramRecentUser)
  {
    try
    {
      paramQQAppInterface = aaiv.a(paramRecentUser, paramQQAppInterface, paramContext, false);
      if (paramRecentUser.parceledRecentBaseData == null) {
        return null;
      }
      boolean bool = ParcelHelper.a(paramQQAppInterface, paramRecentUser.parceledRecentBaseData);
      if (QLog.isColorLevel())
      {
        QLog.e("RecentParcelUtil", 1, new Object[] { "bytesToObject status=", Boolean.valueOf(bool), " user=", paramRecentUser.uin });
        paramQQAppInterface.cuP();
        if (((paramQQAppInterface instanceof RecentUserBaseData)) && (((RecentUserBaseData)paramQQAppInterface).a() != null)) {
          QLog.d("RecentParcelUtil", 1, new Object[] { "RecentUser info=[showUpTime=", Long.valueOf(((RecentUserBaseData)paramQQAppInterface).a().showUpTime), " opTime=", Long.valueOf(((RecentUserBaseData)paramQQAppInterface).a().opTime) });
        }
      }
      if (!bool) {
        return null;
      }
    }
    catch (ParcelHelper.FieldChangedException paramQQAppInterface)
    {
      QLog.e("RecentParcelUtil", 1, "FieldChangedException ", paramQQAppInterface);
      return null;
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("RecentParcelUtil", 1, "getRecentUserData fail, 请对应的开发检查是否使用了不该使用的字段", paramQQAppInterface);
      a(paramContext, false, paramQQAppInterface);
      paramQQAppInterface = null;
    }
    return paramQQAppInterface;
  }
  
  public static void a(Context paramContext, boolean paramBoolean, @Nullable Throwable paramThrowable)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("BootOptimize", 0).edit();
      if (paramBoolean) {
        paramContext.putLong("_last_crash_time", System.currentTimeMillis());
      }
      for (;;)
      {
        paramContext.apply();
        bU.set(true);
        return;
        paramContext.putBoolean("3.4.4_has_crash_when_parcel", true);
        if (paramThrowable != null)
        {
          while (paramThrowable.getCause() != null) {
            paramThrowable = paramThrowable.getCause();
          }
          StringWriter localStringWriter = new StringWriter();
          paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
          paramContext.putString("3.4.4_has_crash_when_parcel_because", localStringWriter.getBuffer().toString());
        }
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static boolean aR(Context paramContext)
  {
    return paramContext.getSharedPreferences("BootOptimize", 0).getBoolean("3.4.4_has_crash_when_parcel", false);
  }
  
  public static String av(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("BootOptimize", 0);
    String str = paramContext.getString("3.4.4_has_crash_when_parcel_because", "");
    paramContext.edit().putString("3.4.4_has_crash_when_parcel_because", "").apply();
    return str;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, @NonNull List<Object> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    label170:
    do
    {
      return;
      int i = Math.min(paramInt, paramList.size());
      int j = 0;
      if (j < paramList.size())
      {
        Object localObject = paramList.get(j);
        int k;
        if ((localObject instanceof RecentBaseData))
        {
          localObject = (RecentBaseData)localObject;
          if (i <= 0) {
            continue;
          }
          k = i - 1;
          localObject = ((RecentUserBaseData)localObject).mUser;
          paramQQAppInterface.a().a().a((RecentUser)localObject, true);
          i = k;
          if (QLog.isColorLevel()) {
            if (localObject != null) {
              break label170;
            }
          }
        }
        for (localObject = "";; localObject = ((RecentUser)localObject).uin)
        {
          QLog.d("RecentParcelUtil", 2, new Object[] { "saveRecentUserData, ", localObject, " forceUpdateParcelData=true" });
          i = k;
          j += 1;
          break;
          new Object[2][0] = "saveRecentUserData, ignore data class=";
          throw new NullPointerException();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("RecentParcelUtil", 2, new Object[] { "saveRecentUserData, size=", Integer.valueOf(paramInt), " lastData.size()=", Integer.valueOf(paramList.size()) });
  }
  
  public static void cvf()
  {
    bU.set(true);
  }
  
  static void gq(int paramInt1, int paramInt2)
  {
    aH.set(paramInt1);
    aI.set(paramInt2);
  }
  
  public static void r(@NonNull QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface.getApp().getSharedPreferences("BootOptimize", 0).edit().putBoolean("_useParcelForBoot", paramBoolean).apply();
    bU.set(true);
  }
  
  public static void t(Context paramContext, boolean paramBoolean)
  {
    a(paramContext, paramBoolean, null);
  }
  
  public static int yI()
  {
    return aH.get();
  }
  
  public static int yJ()
  {
    return aI.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aako
 * JD-Core Version:    0.7.0.1
 */