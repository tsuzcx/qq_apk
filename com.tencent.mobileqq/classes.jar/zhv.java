import android.content.Context;
import java.lang.reflect.Method;
import mqq.app.IActivityDispatchCallback;

public abstract class zhv
  implements IActivityDispatchCallback
{
  public static zhv a;
  
  public static void a()
  {
    try
    {
      Method localMethod = Class.forName("com.tencent.mobileqq.screendetect.ScreenShotDetector").getMethod("getInstance", new Class[0]);
      localMethod.setAccessible(true);
      a = (zhv)localMethod.invoke(null, new Object[0]);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void a(Context paramContext)
  {
    zhv localzhv = a;
    if (localzhv != null) {
      localzhv.c(paramContext);
    }
  }
  
  public static void b(Context paramContext)
  {
    zhv localzhv = a;
    if (localzhv != null) {
      localzhv.d(paramContext);
    }
  }
  
  public abstract void c(Context paramContext);
  
  public abstract void d(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zhv
 * JD-Core Version:    0.7.0.1
 */