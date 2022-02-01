import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.SafeModeUtil.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class swu
{
  public static long DH;
  public static long DI;
  private static final AtomicBoolean bl;
  private static final int bzN;
  private static final CountDownLatch e;
  
  static
  {
    if ((System.currentTimeMillis() & 1L) == 0L) {}
    for (int i = 30;; i = 15)
    {
      bzN = i;
      bl = new AtomicBoolean(false);
      e = new CountDownLatch(2);
      DI = -1L;
      return;
    }
  }
  
  private static boolean Nt()
  {
    return true;
  }
  
  public static void Y(Context paramContext, int paramInt)
  {
    if ((anpc.cJd) && (paramContext.getSharedPreferences("pref_safemode_not_exit", 4).getBoolean("key_not_exit_enable", false))) {}
    SharedPreferences localSharedPreferences;
    do
    {
      do
      {
        return;
        localSharedPreferences = paramContext.getSharedPreferences("sp_safe_mode", 0);
        switch (paramInt)
        {
        default: 
          return;
        case 1: 
          paramInt = localSharedPreferences.getInt("key_count_crash", 0);
        }
      } while (paramInt <= 0);
      localSharedPreferences.edit().putInt("key_count_crash", 0).commit();
    } while ((!Nt()) || (paramInt <= 3));
    anpc.a(paramContext).collectPerformance("", "exitSafeModeCrash", true, 0L, 0L, null, null);
    return;
    paramInt = localSharedPreferences.getInt("key_count_start_fail", 0);
    if (paramInt > 0)
    {
      localSharedPreferences.edit().putInt("key_count_start_fail", 0).commit();
      if ((Nt()) && (paramInt > 3)) {
        anpc.a(paramContext).collectPerformance("", "exitSafeModeStart_" + bzN, true, 0L, 0L, null, null);
      }
    }
    aeid.a().cXf();
  }
  
  public static boolean aE(Context paramContext)
  {
    boolean bool = false;
    paramContext = paramContext.getSharedPreferences("sp_safe_mode", 0);
    int i = paramContext.getInt("key_count_start_fail", 0);
    int j = paramContext.getInt("key_count_crash", 0);
    if ((i > 3) || (j > 3)) {
      bool = true;
    }
    return bool;
  }
  
  public static void bBA()
  {
    try
    {
      e.await(10000L, TimeUnit.MILLISECONDS);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  public static void bBB()
  {
    e.countDown();
  }
  
  public static void bBC() {}
  
  public static void bBD() {}
  
  public static void bBz()
  {
    aeid.a().clear();
  }
  
  public static void bg(Context paramContext, String paramString)
  {
    Object localObject = paramContext.getSharedPreferences("sp_safe_mode", 0);
    int i = ((SharedPreferences)localObject).getInt("key_count_crash", 0);
    String str = ((SharedPreferences)localObject).getString("key_crash_info", "");
    long l = ((SharedPreferences)localObject).getLong("key_crash_time", 0L);
    localObject = ((SharedPreferences)localObject).edit();
    if (str.equals(paramString)) {
      if (Math.abs(System.currentTimeMillis() - l) > 21600000L)
      {
        ((SharedPreferences.Editor)localObject).putInt("key_count_crash", 1);
        ((SharedPreferences.Editor)localObject).putLong("key_crash_time", System.currentTimeMillis());
      }
    }
    for (;;)
    {
      ((SharedPreferences.Editor)localObject).commit();
      return;
      if (i <= 3)
      {
        if ((i == 3) && (Nt())) {
          anpc.a(paramContext).collectPerformance("", "enterSafeModeCrash", true, 0L, 0L, null, null);
        }
        aeid.a().Hs(false);
        ((SharedPreferences.Editor)localObject).putInt("key_count_crash", i + 1);
        continue;
        aeid.a().Hs(false);
        ((SharedPreferences.Editor)localObject).putInt("key_count_crash", 1);
        ((SharedPreferences.Editor)localObject).putString("key_crash_info", paramString);
        ((SharedPreferences.Editor)localObject).putLong("key_crash_time", System.currentTimeMillis());
      }
    }
  }
  
  public static void c(Context paramContext, Object paramObject)
  {
    if ((paramObject != null) && (paramObject.toString().contains("Activity")) && (bl.compareAndSet(false, true)))
    {
      paramObject = paramContext.getSharedPreferences("sp_safe_mode", 0);
      int i = paramObject.getInt("key_count_start_fail", 0);
      if ((i > 3) && (Nt())) {
        anpc.a(paramContext).collectPerformance("", "enterSafeModeStart_" + bzN, true, 0L, 0L, null, null);
      }
      aeid.a().bUa = true;
      aeid.a().bUb = true;
      paramObject.edit().putInt("key_count_start_fail", i + 1).commit();
      ThreadManager.getSubThreadHandler().postDelayed(new SafeModeUtil.1(paramContext), bzN * 1000L);
    }
  }
  
  public static void showToastForSafeModeTest(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     swu
 * JD-Core Version:    0.7.0.1
 */