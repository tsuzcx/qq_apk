import android.content.Context;
import java.lang.reflect.Method;
import mqq.app.IActivityDispatchCallback;

public abstract class xfq
  implements IActivityDispatchCallback
{
  public static xfq a;
  
  public static void a()
  {
    try
    {
      Method localMethod = Class.forName("com.tencent.mobileqq.screendetect.ScreenShotDetector").getMethod("getInstance", new Class[0]);
      localMethod.setAccessible(true);
      a = (xfq)localMethod.invoke(null, new Object[0]);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void a(Context paramContext)
  {
    xfq localxfq = a;
    if (localxfq != null) {
      localxfq.c(paramContext);
    }
  }
  
  public static void b(Context paramContext)
  {
    xfq localxfq = a;
    if (localxfq != null) {
      localxfq.d(paramContext);
    }
  }
  
  public abstract void c(Context paramContext);
  
  public abstract void d(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     xfq
 * JD-Core Version:    0.7.0.1
 */