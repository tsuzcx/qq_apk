import android.content.Context;
import java.lang.reflect.Method;
import mqq.app.IActivityDispatchCallback;

public abstract class sws
  implements IActivityDispatchCallback
{
  public static sws a;
  
  public static void cO(Context paramContext)
  {
    sws localsws = a;
    if (localsws != null) {
      localsws.cQ(paramContext);
    }
  }
  
  public static void cP(Context paramContext)
  {
    sws localsws = a;
    if (localsws != null) {
      localsws.cR(paramContext);
    }
  }
  
  public static void initHandler()
  {
    try
    {
      Method localMethod = Class.forName("com.tencent.mobileqq.screendetect.ScreenShotDetector").getMethod("getInstance", new Class[0]);
      localMethod.setAccessible(true);
      a = (sws)localMethod.invoke(null, new Object[0]);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public abstract void cQ(Context paramContext);
  
  public abstract void cR(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     sws
 * JD-Core Version:    0.7.0.1
 */