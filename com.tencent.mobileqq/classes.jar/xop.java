import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.SafeModeUtil.1;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class xop
{
  private static final int jdField_a_of_type_Int;
  public static long a;
  private static final CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch;
  private static final AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  public static long b;
  
  static
  {
    if ((System.currentTimeMillis() & 1L) == 0L) {}
    for (int i = 30;; i = 15)
    {
      jdField_a_of_type_Int = i;
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
      jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(2);
      b = -1L;
      return;
    }
  }
  
  public static void a()
  {
    ampi.a().b();
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if ((axrn.b) && (paramContext.getSharedPreferences("pref_safemode_not_exit", 4).getBoolean("key_not_exit_enable", false))) {}
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
    } while ((!a()) || (paramInt <= 3));
    axrn.a(paramContext).a("", "exitSafeModeCrash", true, 0L, 0L, null, null);
    return;
    paramInt = localSharedPreferences.getInt("key_count_start_fail", 0);
    if (paramInt > 0)
    {
      localSharedPreferences.edit().putInt("key_count_start_fail", 0).commit();
      if ((a()) && (paramInt > 3)) {
        axrn.a(paramContext).a("", "exitSafeModeStart_" + jdField_a_of_type_Int, true, 0L, 0L, null, null);
      }
    }
    ampi.a().a();
  }
  
  public static void a(Context paramContext, Object paramObject)
  {
    if ((paramObject != null) && (paramObject.toString().contains("Activity")) && (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)))
    {
      paramObject = paramContext.getSharedPreferences("sp_safe_mode", 0);
      int i = paramObject.getInt("key_count_start_fail", 0);
      if ((i > 3) && (a())) {
        axrn.a(paramContext).a("", "enterSafeModeStart_" + jdField_a_of_type_Int, true, 0L, 0L, null, null);
      }
      ampi.a().a = true;
      ampi.a().b = true;
      paramObject.edit().putInt("key_count_start_fail", i + 1).commit();
      ThreadManager.getSubThreadHandler().postDelayed(new SafeModeUtil.1(paramContext), jdField_a_of_type_Int * 1000L);
    }
  }
  
  public static void a(Context paramContext, String paramString)
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
        if ((i == 3) && (a())) {
          axrn.a(paramContext).a("", "enterSafeModeCrash", true, 0L, 0L, null, null);
        }
        ampi.a().a(false);
        ((SharedPreferences.Editor)localObject).putInt("key_count_crash", i + 1);
        continue;
        ampi.a().a(false);
        ((SharedPreferences.Editor)localObject).putInt("key_count_crash", 1);
        ((SharedPreferences.Editor)localObject).putString("key_crash_info", paramString);
        ((SharedPreferences.Editor)localObject).putLong("key_crash_time", System.currentTimeMillis());
      }
    }
  }
  
  public static void a(String paramString) {}
  
  private static boolean a()
  {
    return true;
  }
  
  public static boolean a(Context paramContext)
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
  
  public static void b()
  {
    try
    {
      jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await(10000L, TimeUnit.MILLISECONDS);
      return;
    }
    catch (InterruptedException localInterruptedException) {}
  }
  
  public static void c()
  {
    jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
  
  public static void d() {}
  
  public static void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     xop
 * JD-Core Version:    0.7.0.1
 */