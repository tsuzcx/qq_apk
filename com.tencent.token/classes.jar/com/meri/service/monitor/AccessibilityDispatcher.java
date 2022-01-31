package com.meri.service.monitor;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Message;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import taiji.cq;
import taiji.ct;

@SuppressLint({"NewApi"})
public class AccessibilityDispatcher
  extends AccessibilityService
{
  public static d a = null;
  private static AccessibilityDispatcher b = null;
  private static boolean d = false;
  private static boolean e = false;
  private static Set f = new HashSet();
  private static Map g = new HashMap();
  private b c;
  
  public static int a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return 1;
    }
    if (!b())
    {
      if (b(paramContext)) {
        return 4;
      }
      return 2;
    }
    paramContext = b.c;
    if ((paramContext != null) && ((b.a(paramContext) != null) || (b.b(paramContext) != null))) {
      return 3;
    }
    return 0;
  }
  
  public static void a()
  {
    if (b == null)
    {
      Log.e("AccessibilityDispatcher", "service not started, why cancel?");
      return;
    }
    if (b.c == null)
    {
      Log.e("AccessibilityDispatcher", "hasn't play, why cancel?");
      return;
    }
    b.c.a();
  }
  
  public static void a(Context paramContext, taiji.b paramb, cq paramcq)
  {
    if ((paramb == null) || (paramb.c == null)) {
      Log.e("AccessibilityDispatcher", "no action to play");
    }
    do
    {
      return;
      int i = a(paramContext);
      if (i != 0)
      {
        Log.e("AccessibilityDispatcher", "canPlay error is " + i);
        return;
      }
      paramContext = b.e();
    } while (paramContext == null);
    b.a(paramContext, -1);
    if (paramcq != null) {
      paramcq.a();
    }
    b.a(paramContext, System.currentTimeMillis());
    b.a(paramContext, paramb);
    b.a(paramContext, paramcq);
    b.a(paramContext, new ct());
    b.c(paramContext).a = paramb.b;
    paramContext.sendEmptyMessage(1001);
  }
  
  public static boolean b()
  {
    if ((e) && ((b == null) || (b.getServiceInfo() == null))) {
      e = false;
    }
    Log.i("AccessibilityDispatcher", "isServerStart: " + e);
    return e;
  }
  
  public static boolean b(Context paramContext)
  {
    for (;;)
    {
      int i;
      try
      {
        String str = paramContext.getPackageName();
        if (TextUtils.isEmpty(str)) {
          return false;
        }
        paramContext = Settings.Secure.getString(paramContext.getContentResolver(), "enabled_accessibility_services");
        if (!TextUtils.isEmpty(paramContext))
        {
          paramContext = paramContext.split(":");
          if ((paramContext != null) && (paramContext.length > 0))
          {
            str = str + "/" + AccessibilityDispatcher.class.getName();
            int j = paramContext.length;
            i = 0;
            if (i < j)
            {
              CharSequence localCharSequence = paramContext[i];
              if (TextUtils.isEmpty(localCharSequence)) {
                break label137;
              }
              boolean bool = localCharSequence.equals(str);
              if (!bool) {
                break label137;
              }
              return true;
            }
          }
        }
      }
      catch (Throwable paramContext)
      {
        if (a != null) {
          a.onException(paramContext);
        }
      }
      return false;
      label137:
      i += 1;
    }
  }
  
  private b e()
  {
    if (this.c != null) {
      return this.c;
    }
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    HandlerThread localHandlerThread = a.getHandlerThread("puppet_thread");
    localHandlerThread.start();
    this.c = new b(this, localHandlerThread.getLooper(), this, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    return this.c;
  }
  
  public void onAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent == null) {}
    do
    {
      int i;
      do
      {
        return;
        i = paramAccessibilityEvent.getEventType();
        Log.i("AccessibilityDispatcher", "eventType=" + i);
      } while (this.c == null);
      if ((32 == i) || (4096 == i)) {
        this.c.a(i);
      }
      if ((32 == i) && (b.d(this.c) != null))
      {
        CharSequence localCharSequence = paramAccessibilityEvent.getPackageName();
        if (!TextUtils.isEmpty(localCharSequence)) {
          b.a(this.c, localCharSequence.toString());
        }
      }
    } while (g.size() <= 0);
    Message.obtain(this.c, 1104, AccessibilityEvent.obtain(paramAccessibilityEvent)).sendToTarget();
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (a != null) {
      a.onCreate();
    }
  }
  
  public void onDestroy()
  {
    Log.i("AccessibilityDispatcher", "onDestroy");
    e = false;
    b = null;
    super.onDestroy();
  }
  
  public void onInterrupt()
  {
    Log.e("AccessibilityDispatcher", "onInterrupt");
  }
  
  protected void onServiceConnected()
  {
    Log.i("AccessibilityDispatcher", "onServiceConnected");
    Object localObject;
    if (a != null)
    {
      localObject = a.onConnected(null);
      if (localObject == null) {
        break label140;
      }
    }
    label140:
    for (boolean bool1 = ((Bundle)localObject).getBoolean("key.c.u.a", true);; bool1 = true)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (Build.VERSION.SDK_INT < 16) {
          bool2 = false;
        }
      }
      if (!bool2) {
        stopSelf();
      }
      do
      {
        do
        {
          return;
          Log.e("AccessibilityDispatcher", "mConfigAndObserver is null!");
          stopSelf();
          return;
          b = this;
          e = true;
          localObject = b.e();
          if (!d) {
            break;
          }
          d = false;
        } while (localObject == null);
        b.a((b)localObject, "");
        ((b)localObject).sendEmptyMessageDelayed(1100, 200L);
        return;
      } while (localObject == null);
      ((b)localObject).sendEmptyMessage(1103);
      return;
    }
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    Log.i("AccessibilityDispatcher", "onUnbind");
    e = false;
    b = null;
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.meri.service.monitor.AccessibilityDispatcher
 * JD-Core Version:    0.7.0.1
 */