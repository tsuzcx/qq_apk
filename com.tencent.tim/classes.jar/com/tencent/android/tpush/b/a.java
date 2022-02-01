package com.tencent.android.tpush.b;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.message.PushMessageManager;
import java.lang.reflect.Method;

public class a
{
  private static String a = "InMsgManagerInstance";
  private static String b = "com.tencent.android.tpush.inapp.InMsgManager";
  private static String c = "show";
  private static String d = "dismiss";
  private static Class<?> e;
  private static Method f;
  private static boolean g;
  
  public static void a()
  {
    try
    {
      if (!g)
      {
        if (e == null) {
          e = Class.forName(b);
        }
        if (f == null) {
          f = e.getDeclaredMethod(c, new Class[] { Context.class, PushMessageManager.class });
        }
        g = true;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.w(a, "invoke method show() error: " + localThrowable.toString());
    }
  }
  
  public static void a(Context paramContext, PushMessageManager paramPushMessageManager)
  {
    try
    {
      a();
      f.invoke(e, new Object[] { paramContext, paramPushMessageManager });
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.w(a, "invoke method show() error: " + paramContext.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.b.a
 * JD-Core Version:    0.7.0.1
 */