package com.tencent.token;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

public final class bu
  implements bm
{
  private static final bu i = new bu();
  int a = 0;
  int b = 0;
  boolean c = true;
  boolean d = true;
  Handler e;
  final bn f = new bn(this);
  Runnable g = new Runnable()
  {
    public final void run()
    {
      bu.a(bu.this);
      bu.b(bu.this);
    }
  };
  private bv.a h = new bv.a()
  {
    public final void a()
    {
      bu localbu = bu.this;
      localbu.a += 1;
      if ((localbu.a == 1) && (localbu.d))
      {
        localbu.f.a(bj.a.ON_START);
        localbu.d = false;
      }
    }
    
    public final void b()
    {
      bu localbu = bu.this;
      localbu.b += 1;
      if (localbu.b == 1)
      {
        if (localbu.c)
        {
          localbu.f.a(bj.a.ON_RESUME);
          localbu.c = false;
          return;
        }
        localbu.e.removeCallbacks(localbu.g);
      }
    }
  };
  
  public static bm a()
  {
    return i;
  }
  
  public static void a(Context paramContext)
  {
    bu localbu = i;
    localbu.e = new Handler();
    localbu.f.a(bj.a.ON_CREATE);
    ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new bh()
    {
      public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        bv.b(paramAnonymousActivity).a = bu.c(bu.this);
      }
      
      public final void onActivityPaused(Activity paramAnonymousActivity)
      {
        paramAnonymousActivity = bu.this;
        paramAnonymousActivity.b -= 1;
        if (paramAnonymousActivity.b == 0) {
          paramAnonymousActivity.e.postDelayed(paramAnonymousActivity.g, 700L);
        }
      }
      
      public final void onActivityStopped(Activity paramAnonymousActivity)
      {
        paramAnonymousActivity = bu.this;
        paramAnonymousActivity.a -= 1;
        paramAnonymousActivity.b();
      }
    });
  }
  
  final void b()
  {
    if ((this.a == 0) && (this.c))
    {
      this.f.a(bj.a.ON_STOP);
      this.d = true;
    }
  }
  
  public final bj getLifecycle()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bu
 * JD-Core Version:    0.7.0.1
 */