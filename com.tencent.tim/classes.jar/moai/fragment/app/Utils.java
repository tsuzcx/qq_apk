package moai.fragment.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Build.VERSION;
import java.lang.reflect.Method;

public class Utils
{
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
  
  public static void convertActivityToTranslucent(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      convertActivityToTranslucentAfterL(paramActivity);
      return;
    }
    convertActivityToTranslucentBeforeL(paramActivity);
  }
  
  private static void convertActivityToTranslucentAfterL(Activity paramActivity)
  {
    Object localObject1 = null;
    for (;;)
    {
      int i;
      try
      {
        Method localMethod = Activity.class.getDeclaredMethod("getActivityOptions", new Class[0]);
        localMethod.setAccessible(true);
        Object localObject2 = localMethod.invoke(paramActivity, new Object[0]);
        Class[] arrayOfClass = Activity.class.getDeclaredClasses();
        int j = arrayOfClass.length;
        i = 0;
        if (i < j)
        {
          localMethod = arrayOfClass[i];
          if (localMethod.getSimpleName().contains("TranslucentConversionListener")) {
            localObject1 = localMethod;
          }
        }
        else
        {
          localObject1 = Activity.class.getDeclaredMethod("convertToTranslucent", new Class[] { localObject1, ActivityOptions.class });
          ((Method)localObject1).setAccessible(true);
          ((Method)localObject1).invoke(paramActivity, new Object[] { null, localObject2 });
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.fragment.app.Utils
 * JD-Core Version:    0.7.0.1
 */