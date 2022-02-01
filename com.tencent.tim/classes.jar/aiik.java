import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import com.tencent.mobileqq.javahooksdk.ReplaceMethodCallback;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class aiik
{
  private static aiik.a a = new aiik.a(null);
  private static int count;
  
  private static void Lb(boolean paramBoolean)
  {
    String str = null;
    try
    {
      Object localObject = BaseApplicationImpl.sApplication.getRuntime();
      if (localObject != null) {
        str = ((AppRuntime)localObject).getAccount();
      }
      long l1 = Runtime.getRuntime().totalMemory();
      long l2 = Runtime.getRuntime().freeMemory();
      long l3 = Runtime.getRuntime().maxMemory();
      localObject = new HashMap();
      ((HashMap)localObject).put("heapSize", String.valueOf(l1 - l2));
      ((HashMap)localObject).put("maxMemory", String.valueOf(l3));
      int i = count + 1;
      count = i;
      ((HashMap)localObject).put("count", String.valueOf(i));
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(str, "TimeoutExceptionHooker", paramBoolean, 0L, 0L, (HashMap)localObject, "", true);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void start()
  {
    if (Build.VERSION.SDK_INT < 17) {
      return;
    }
    try
    {
      JavaHookBridge.findAndReplaceMethod(Class.forName("java.lang.Daemons$FinalizerWatchdogDaemon"), "finalizerTimedOut", new Object[] { Object.class, a });
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
    }
  }
  
  static class a
    implements ReplaceMethodCallback
  {
    public void replaceMethod(MethodHookParam paramMethodHookParam)
    {
      aiik.Lc(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiik
 * JD-Core Version:    0.7.0.1
 */