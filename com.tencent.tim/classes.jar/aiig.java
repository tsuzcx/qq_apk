import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Looper;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.javahooksdk.HookMethodCallback;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.mobileqq.javahooksdk.MethodHookParam;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class aiig
{
  private static swt a = new swt(BaseApplicationImpl.sApplication);
  
  private static void bo(boolean paramBoolean, int paramInt)
  {
    String str = null;
    Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    if (localObject != null) {
      str = ((QQAppInterface)localObject).getCurrentAccountUin();
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("param_FailCode", Integer.toString(paramInt));
    anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(str, "BitmapOOMHooker", paramBoolean, 0L, 0L, (HashMap)localObject, "", true);
  }
  
  private static void clearCache()
  {
    if (BaseApplicationImpl.sImageCache != null) {
      BaseApplicationImpl.sImageCache.evictAll();
    }
    System.gc();
    Thread.yield();
    System.gc();
    if (ThreadManager.getUIHandler().getLooper() != Looper.myLooper()) {}
    try
    {
      Thread.sleep(1000L);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
    }
  }
  
  public static void start()
  {
    try
    {
      JavaHookBridge.findAndHookMethod(Bitmap.class, "createBitmap", new Object[] { DisplayMetrics.class, Integer.TYPE, Integer.TYPE, Bitmap.Config.class, Boolean.TYPE, new aiig.a(90001) });
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      try
      {
        JavaHookBridge.findAndHookMethod(Bitmap.class, "createBitmap", new Object[] { DisplayMetrics.class, [I.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Bitmap.Config.class, new aiig.a(90002) });
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        try
        {
          for (;;)
          {
            JavaHookBridge.findAndHookMethod(BitmapFactory.class, "decodeResource", new Object[] { Resources.class, Integer.TYPE, BitmapFactory.Options.class, new aiig.a(90003) });
            try
            {
              JavaHookBridge.findAndHookMethod(BitmapFactory.class, "decodeFile", new Object[] { String.class, BitmapFactory.Options.class, new aiig.a(90004) });
              return;
            }
            catch (NoSuchMethodException localNoSuchMethodException4)
            {
              aqft.l(localNoSuchMethodException4);
            }
            localNoSuchMethodException1 = localNoSuchMethodException1;
            aqft.l(localNoSuchMethodException1);
            continue;
            localNoSuchMethodException2 = localNoSuchMethodException2;
            aqft.l(localNoSuchMethodException2);
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException3)
        {
          for (;;)
          {
            aqft.l(localNoSuchMethodException3);
          }
        }
      }
    }
  }
  
  static class a
    implements HookMethodCallback
  {
    private int type;
    
    public a(int paramInt)
    {
      this.type = paramInt;
    }
    
    public void afterHookedMethod(MethodHookParam paramMethodHookParam)
    {
      if (paramMethodHookParam.throwable == null) {
        return;
      }
      Throwable localThrowable;
      if (paramMethodHookParam.throwable.getCause() != null) {
        localThrowable = paramMethodHookParam.throwable.getCause();
      }
      while ((localThrowable instanceof OutOfMemoryError))
      {
        aiig.access$000();
        try
        {
          paramMethodHookParam.result = JavaHookBridge.invokeOriginMethod(paramMethodHookParam.method, paramMethodHookParam.thisObject, paramMethodHookParam.args);
          paramMethodHookParam.throwable = null;
          aiig.bp(true, this.type);
          return;
        }
        catch (Exception paramMethodHookParam)
        {
          aiig.bp(false, this.type);
          return;
          localThrowable = paramMethodHookParam.throwable;
        }
        catch (Error paramMethodHookParam)
        {
          aiig.bp(false, this.type);
        }
      }
    }
    
    public void beforeHookedMethod(MethodHookParam paramMethodHookParam) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiig
 * JD-Core Version:    0.7.0.1
 */