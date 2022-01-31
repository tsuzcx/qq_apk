import android.content.Context;
import java.lang.reflect.Method;
import mqq.app.IActivityDispatchCallback;

public abstract class xon
  implements IActivityDispatchCallback
{
  public static xon a;
  
  public static void a()
  {
    try
    {
      Method localMethod = Class.forName("com.tencent.mobileqq.screendetect.ScreenShotDetector").getMethod("getInstance", new Class[0]);
      localMethod.setAccessible(true);
      a = (xon)localMethod.invoke(null, new Object[0]);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static void a(Context paramContext)
  {
    xon localxon = a;
    if (localxon != null) {
      localxon.c(paramContext);
    }
  }
  
  public static void b(Context paramContext)
  {
    xon localxon = a;
    if (localxon != null) {
      localxon.d(paramContext);
    }
  }
  
  public abstract void c(Context paramContext);
  
  public abstract void d(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     xon
 * JD-Core Version:    0.7.0.1
 */