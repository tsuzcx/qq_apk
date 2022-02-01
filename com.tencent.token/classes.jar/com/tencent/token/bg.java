package com.tencent.token;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

public final class bg
  implements ay
{
  private static final bg i = new bg();
  int a = 0;
  int b = 0;
  boolean c = true;
  boolean d = true;
  Handler e;
  final az f = new az(this);
  Runnable g = new Runnable()
  {
    public final void run()
    {
      bg.a(bg.this);
      bg.b(bg.this);
    }
  };
  private bh.a h = new bh.a()
  {
    public final void a()
    {
      bg localbg = bg.this;
      localbg.a += 1;
      if ((localbg.a == 1) && (localbg.d))
      {
        localbg.f.a(av.a.ON_START);
        localbg.d = false;
      }
    }
    
    public final void b()
    {
      bg localbg = bg.this;
      localbg.b += 1;
      if (localbg.b == 1)
      {
        if (localbg.c)
        {
          localbg.f.a(av.a.ON_RESUME);
          localbg.c = false;
          return;
        }
        localbg.e.removeCallbacks(localbg.g);
      }
    }
  };
  
  public static ay a()
  {
    return i;
  }
  
  public static void a(Context paramContext)
  {
    bg localbg = i;
    localbg.e = new Handler();
    localbg.f.a(av.a.ON_CREATE);
    ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new at()
    {
      public final void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        bh.b(paramAnonymousActivity).a = bg.c(bg.this);
      }
      
      public final void onActivityPaused(Activity paramAnonymousActivity)
      {
        paramAnonymousActivity = bg.this;
        paramAnonymousActivity.b -= 1;
        if (paramAnonymousActivity.b == 0) {
          paramAnonymousActivity.e.postDelayed(paramAnonymousActivity.g, 700L);
        }
      }
      
      public final void onActivityStopped(Activity paramAnonymousActivity)
      {
        paramAnonymousActivity = bg.this;
        paramAnonymousActivity.a -= 1;
        paramAnonymousActivity.b();
      }
    });
  }
  
  final void b()
  {
    if ((this.a == 0) && (this.c))
    {
      this.f.a(av.a.ON_STOP);
      this.d = true;
    }
  }
  
  public final av getLifecycle()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bg
 * JD-Core Version:    0.7.0.1
 */