import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.lang.reflect.Method;

public abstract class ahwd
{
  public static ahwd a;
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    ahwd localahwd = a;
    if (localahwd != null) {
      localahwd.startActivityForResult(paramActivity, paramIntent, paramInt, paramBundle);
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent, Runnable paramRunnable)
  {
    ahwd localahwd = a;
    if (localahwd != null) {
      localahwd.b(paramContext, paramIntent, paramRunnable);
    }
  }
  
  public static void initHandler()
  {
    try
    {
      Method localMethod = Class.forName("com.tencent.mobileqq.haoliyou.JefsClass").getMethod("getInstance", new Class[0]);
      localMethod.setAccessible(true);
      a = (ahwd)localMethod.invoke(null, new Object[0]);
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public abstract void b(Context paramContext, Intent paramIntent, Runnable paramRunnable);
  
  public abstract void startActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     ahwd
 * JD-Core Version:    0.7.0.1
 */