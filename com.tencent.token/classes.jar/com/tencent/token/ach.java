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

public class ach
{
  public static boolean a = false;
  public static Handler b;
  public static Set<aci> c = new CopyOnWriteArraySet();
  public static Set<acf> d = new CopyOnWriteArraySet();
  public static acg e;
  public static boolean f = false;
  public static Set<String> g = new HashSet();
  public static final acm h = new a();
  public static final aco i = new c();
  public static final acf j = new b();
  
  public final class a
    extends acm
  {
    public final void a(Activity paramActivity)
    {
      if ((ach.g.contains(paramActivity.getClass().getName())) || (ach.f)) {
        try
        {
          Object localObject1 = ach.i;
          Object localObject2 = paramActivity.getWindow();
          String str = paramActivity.getClass().getName();
          Window.Callback localCallback = ((Window)localObject2).getCallback();
          if ((localCallback != null) && (!(localCallback instanceof acp))) {
            ((Window)localObject2).setCallback(new acp(localCallback, (aco)localObject1, str));
          }
          localObject1 = paramActivity.getWindow();
          paramActivity = paramActivity.getClass().getName();
          localObject2 = ach.j;
          ((Window)localObject1).getDecorView().getViewTreeObserver().addOnPreDrawListener(new ack((Window)localObject1, paramActivity, (acf)localObject2));
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
      ach.e.b(paramActivity);
    }
    
    public final void onActivityResumed(Activity paramActivity)
    {
      a(paramActivity);
      ach.e.a(paramActivity);
    }
  }
  
  public final class b
    implements acf
  {
    public final void a(String paramString, View paramView)
    {
      Iterator localIterator = ach.d.iterator();
      while (localIterator.hasNext()) {
        ((acf)localIterator.next()).a(paramString, paramView);
      }
    }
  }
  
  public final class c
    implements aco
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
        if ((paramMessage != null) && ((paramMessage instanceof acj)))
        {
          paramMessage = (acj)paramMessage;
          ??? = ach.c.iterator();
          while (((Iterator)???).hasNext()) {
            ((aci)((Iterator)???).next()).a(paramMessage);
          }
          if (!paramMessage.e) {
            synchronized (acj.c)
            {
              paramMessage.f = 0;
              paramMessage.g = 0;
              paramMessage.h = 0;
              paramMessage.i = 0.0F;
              paramMessage.j = 0.0F;
              paramMessage.k = 0.0F;
              paramMessage.l = 0.0F;
              paramMessage.m = "";
              int i = acj.b;
              if (i < 20)
              {
                paramMessage.d = acj.a;
                paramMessage.e = true;
                acj.a = paramMessage;
                acj.b = i + 1;
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
 * Qualified Name:     com.tencent.token.ach
 * JD-Core Version:    0.7.0.1
 */