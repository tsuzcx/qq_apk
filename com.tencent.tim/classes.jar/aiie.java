import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager.BadTokenException;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.javahook.BadTokenHooker.2;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import java.lang.reflect.Field;
import mqq.os.MqqHandler;

@TargetApi(14)
public class aiie
{
  private static aiie.a a = new aiie.a(null);
  
  private static void i(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new BadTokenHooker.2(paramString1, paramString2, paramInt1), paramInt2);
  }
  
  public static void start()
  {
    try
    {
      localClass1 = Class.forName("android.view.ViewRootImpl");
      JavaHookBridge.findAndHookMethod(localClass1, "setView", new Object[] { View.class, WindowManager.LayoutParams.class, View.class, new aiif(localClass1) });
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      for (;;)
      {
        try
        {
          localClass1 = Class.forName("android.view.WindowManagerImpl");
          if (Build.VERSION.SDK_INT > 16) {
            break;
          }
        }
        catch (ClassNotFoundException localClassNotFoundException2)
        {
          Class localClass1;
          Class localClass2;
          aqft.l(localClassNotFoundException2);
          return;
        }
        try
        {
          localClass2 = Class.forName("android.view.CompatibilityInfoHolder");
          if (localClass2 != null) {
            JavaHookBridge.findAndHookMethod(localClass1, "addView", new Object[] { View.class, ViewGroup.LayoutParams.class, localClass2, Boolean.class, a });
          }
          return;
        }
        catch (NoSuchMethodException localNoSuchMethodException2)
        {
          aqft.l(localNoSuchMethodException2);
          return;
        }
        catch (ClassNotFoundException localClassNotFoundException3)
        {
          aqft.l(localClassNotFoundException3);
          return;
        }
        localNoSuchMethodException1 = localNoSuchMethodException1;
        aqft.l(localNoSuchMethodException1);
      }
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      for (;;)
      {
        aqft.l(localClassNotFoundException1);
      }
    }
    try
    {
      JavaHookBridge.findAndHookMethod(localClassNotFoundException3, "addView", new Object[] { View.class, ViewGroup.LayoutParams.class, a });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException3)
    {
      aqft.l(localNoSuchMethodException3);
    }
  }
  
  static class a
    implements HookMethodCallback
  {
    public void afterHookedMethod(MethodHookParam paramMethodHookParam)
    {
      if (paramMethodHookParam.throwable == null) {}
      View localView;
      do
      {
        return;
        localView = (View)paramMethodHookParam.args[0];
      } while (localView == null);
      Object localObject1 = localView.getContext();
      Object localObject2 = localObject1;
      if ("android.view.ContextThemeWrapper".equals(localObject1.getClass().getName())) {}
      label295:
      for (;;)
      {
        try
        {
          localObject2 = Class.forName("android.view.ContextThemeWrapper").getDeclaredField("mBase");
          ((Field)localObject2).setAccessible(true);
          localObject2 = ((Field)localObject2).get(localView.getContext());
          if ((localObject2 == null) || (!(localObject2 instanceof Context))) {
            break label295;
          }
          localObject2 = (Context)localObject2;
          localObject1 = localObject2;
          localObject2 = localObject1;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          aqft.l(localClassNotFoundException);
          Object localObject3 = localObject1;
          continue;
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          aqft.l(localNoSuchFieldException);
          Object localObject4 = localObject1;
          continue;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          aqft.l(localIllegalArgumentException);
          Object localObject5 = localObject1;
          continue;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          aqft.l(localIllegalAccessException);
          Object localObject6 = localObject1;
          continue;
          localObject1 = paramMethodHookParam.throwable;
          continue;
          paramMethodHookParam.throwable = new RuntimeException(paramMethodHookParam.throwable.getMessage() + " -- context is " + localObject6.getClass().getName(), paramMethodHookParam.throwable);
          return;
        }
        if (paramMethodHookParam.throwable.getCause() != null)
        {
          localObject1 = paramMethodHookParam.throwable.getCause();
          if ((!(localObject2 instanceof Activity)) || (((Activity)localObject2).isFinishing()) || (!(localObject1 instanceof WindowManager.BadTokenException))) {
            continue;
          }
          aiie.j(1, localObject2.getClass().getName(), paramMethodHookParam.throwable.getMessage(), 0);
          aiie.j(2, localObject2.getClass().getName(), null, 10000);
          aiie.j(3, localObject2.getClass().getName(), null, 60000);
          paramMethodHookParam.throwable = null;
          ((Activity)localObject2).finish();
        }
      }
    }
    
    public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiie
 * JD-Core Version:    0.7.0.1
 */