import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class aeej
{
  private static boolean init;
  private static boolean initSuccess;
  private static Method o;
  private static Method p;
  private static Class<?> u;
  
  public static void a(Activity paramActivity, InvocationHandler paramInvocationHandler)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      b(paramActivity, paramInvocationHandler);
      return;
    }
    convertActivityToTranslucentBeforeL(paramActivity);
  }
  
  public static boolean agw()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return false;
    }
    init();
    return initSuccess;
  }
  
  @RequiresApi(api=16)
  private static void b(Activity paramActivity, InvocationHandler paramInvocationHandler)
  {
    
    try
    {
      Object localObject = o.invoke(paramActivity, new Object[0]);
      Class localClass = u;
      paramInvocationHandler = Proxy.newProxyInstance(u.getClassLoader(), new Class[] { localClass }, paramInvocationHandler);
      p.invoke(paramActivity, new Object[] { paramInvocationHandler, localObject });
      return;
    }
    catch (Throwable paramActivity) {}
  }
  
  public static void convertActivityFromTranslucent(Activity paramActivity)
  {
    try
    {
      Method localMethod = Activity.class.getDeclaredMethod("convertFromTranslucent", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(paramActivity, new Object[0]);
      return;
    }
    catch (Throwable paramActivity) {}
  }
  
  public static void convertActivityToTranslucentBeforeL(Activity paramActivity)
  {
    Object localObject = null;
    for (;;)
    {
      int i;
      try
      {
        Class[] arrayOfClass = Activity.class.getDeclaredClasses();
        int j = arrayOfClass.length;
        i = 0;
        if (i < j)
        {
          Class localClass = arrayOfClass[i];
          if (localClass.getSimpleName().contains("TranslucentConversionListener")) {
            localObject = localClass;
          }
        }
        else
        {
          localObject = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[] { localObject });
          ((Method)localObject).setAccessible(true);
          ((Method)localObject).invoke(paramActivity, new Object[] { null });
          return;
        }
      }
      catch (Throwable paramActivity)
      {
        return;
      }
      i += 1;
    }
  }
  
  @RequiresApi(api=16)
  private static void init()
  {
    if (init) {
      return;
    }
    try
    {
      o = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
      o.setAccessible(true);
      arrayOfClass = Activity.class.getDeclaredClasses();
      u = null;
      j = arrayOfClass.length;
      i = 0;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Class[] arrayOfClass;
        int j;
        int i;
        Class localClass;
        if (QLog.isColorLevel())
        {
          QLog.e("SwipeLayoutUtils", 2, localThrowable, new Object[0]);
          continue;
          i += 1;
        }
      }
    }
    if (i < j)
    {
      localClass = arrayOfClass[i];
      if (localClass.getSimpleName().contains("TranslucentConversionListener")) {
        u = localClass;
      }
    }
    else
    {
      p = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[] { u, ActivityOptions.class });
      p.setAccessible(true);
      initSuccess = true;
      init = true;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeej
 * JD-Core Version:    0.7.0.1
 */