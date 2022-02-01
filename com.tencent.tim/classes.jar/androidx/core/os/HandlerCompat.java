package androidx.core.os;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class HandlerCompat
{
  private static final String TAG = "HandlerCompat";
  
  @NonNull
  public static Handler createAsync(@NonNull Looper paramLooper)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return Handler.createAsync(paramLooper);
    }
    if (Build.VERSION.SDK_INT >= 16) {}
    try
    {
      Handler localHandler = (Handler)Handler.class.getDeclaredConstructor(new Class[] { Looper.class, Handler.Callback.class, Boolean.TYPE }).newInstance(new Object[] { paramLooper, null, Boolean.valueOf(true) });
      return localHandler;
    }
    catch (InvocationTargetException paramLooper)
    {
      paramLooper = paramLooper.getCause();
      if ((paramLooper instanceof RuntimeException)) {
        throw ((RuntimeException)paramLooper);
      }
      if ((paramLooper instanceof Error)) {
        throw ((Error)paramLooper);
      }
      throw new RuntimeException(paramLooper);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Log.v("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor");
      return new Handler(paramLooper);
    }
    catch (InstantiationException localInstantiationException)
    {
      break label114;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      label114:
      break label114;
    }
  }
  
  @NonNull
  public static Handler createAsync(@NonNull Looper paramLooper, @NonNull Handler.Callback paramCallback)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return Handler.createAsync(paramLooper, paramCallback);
    }
    if (Build.VERSION.SDK_INT >= 16) {}
    try
    {
      Handler localHandler = (Handler)Handler.class.getDeclaredConstructor(new Class[] { Looper.class, Handler.Callback.class, Boolean.TYPE }).newInstance(new Object[] { paramLooper, paramCallback, Boolean.valueOf(true) });
      return localHandler;
    }
    catch (InvocationTargetException paramLooper)
    {
      paramLooper = paramLooper.getCause();
      if ((paramLooper instanceof RuntimeException)) {
        throw ((RuntimeException)paramLooper);
      }
      if ((paramLooper instanceof Error)) {
        throw ((Error)paramLooper);
      }
      throw new RuntimeException(paramLooper);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      Log.v("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor");
      return new Handler(paramLooper, paramCallback);
    }
    catch (InstantiationException localInstantiationException)
    {
      break label115;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      label115:
      break label115;
    }
  }
  
  public static boolean postDelayed(@NonNull Handler paramHandler, @NonNull Runnable paramRunnable, @Nullable Object paramObject, long paramLong)
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return paramHandler.postDelayed(paramRunnable, paramObject, paramLong);
    }
    paramRunnable = Message.obtain(paramHandler, paramRunnable);
    paramRunnable.obj = paramObject;
    return paramHandler.sendMessageDelayed(paramRunnable, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.os.HandlerCompat
 * JD-Core Version:    0.7.0.1
 */