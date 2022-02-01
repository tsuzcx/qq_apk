package com.tencent.token;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.Window.Callback;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class adt
{
  public static boolean a = false;
  public static Handler b;
  public static Set<adv> c = new CopyOnWriteArraySet();
  public static Set<adq> d = new CopyOnWriteArraySet();
  public static adr e;
  public static boolean f = false;
  public static Set<String> g = new HashSet();
  public static final aed h = new a();
  public static final aef i = new c();
  public static final adq j = new b();
  
  public final class a
    extends aed
  {
    public final void a(Activity paramActivity)
    {
      if ((adt.g.contains(paramActivity.getClass().getName())) || (adt.f)) {
        try
        {
          Object localObject1 = adt.i;
          Object localObject2 = paramActivity.getWindow();
          String str = paramActivity.getClass().getName();
          Window.Callback localCallback = ((Window)localObject2).getCallback();
          if ((localCallback != null) && (!(localCallback instanceof aeg))) {
            ((Window)localObject2).setCallback(new aeg(localCallback, (aef)localObject1, str));
          }
          localObject1 = paramActivity.getWindow();
          paramActivity = paramActivity.getClass().getName();
          localObject2 = adt.j;
          ((Window)localObject1).getDecorView().getViewTreeObserver().addOnPreDrawListener(new adx((Window)localObject1, paramActivity, (adq)localObject2));
          return;
        }
        finally
        {
          paramActivity.printStackTrace();
        }
      }
    }
    
    public final void onActivityPaused(Activity paramActivity)
    {
      adt.e.b(paramActivity);
    }
    
    public final void onActivityResumed(Activity paramActivity)
    {
      a(paramActivity);
      adt.e.a(paramActivity);
    }
  }
  
  public final class b
    implements adq
  {
    public final void a(String paramString, View paramView)
    {
      Iterator localIterator = adt.d.iterator();
      while (localIterator.hasNext()) {
        ((adq)localIterator.next()).a(paramString, paramView);
      }
    }
  }
  
  public final class c
    implements aef
  {}
  
  public static final class d
    extends Handler
  {
    public d(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 1)
      {
        paramMessage = paramMessage.obj;
        if ((paramMessage != null) && ((paramMessage instanceof adw)))
        {
          paramMessage = (adw)paramMessage;
          ??? = adt.c.iterator();
          while (((Iterator)???).hasNext()) {
            ((adv)((Iterator)???).next()).a(paramMessage);
          }
          if (!paramMessage.e) {
            synchronized (adw.c)
            {
              paramMessage.f = 0;
              paramMessage.g = 0;
              paramMessage.h = 0;
              paramMessage.i = 0.0F;
              paramMessage.j = 0.0F;
              paramMessage.k = 0.0F;
              paramMessage.l = 0.0F;
              paramMessage.m = "";
              int i = adw.b;
              if (i < 20)
              {
                paramMessage.d = adw.a;
                paramMessage.e = true;
                adw.a = paramMessage;
                adw.b = i + 1;
              }
              return;
            }
          }
          throw new IllegalStateException("Already recycled.");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.adt
 * JD-Core Version:    0.7.0.1
 */