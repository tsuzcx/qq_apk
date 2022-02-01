package com.tencent.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewManager;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public abstract class d
{
  private long a = -1L;
  private Animation b;
  private Animation c;
  private boolean d = true;
  private ViewManager e;
  private FrameLayout f;
  private View g;
  private int h = 0;
  private volatile int i = 0;
  protected Context o;
  protected Handler p;
  
  private void a(int paramInt)
  {
    int j = this.h;
    paramInt = 1 << paramInt | j;
    if (paramInt != j)
    {
      this.h = paramInt;
      if (this.h == 15) {
        f();
      }
    }
  }
  
  private void b()
  {
    Object localObject = new Intent(this.o, PActivity.class);
    ((Intent)localObject).setFlags(402653184);
    localObject = PendingIntent.getActivity(this.o, 0, (Intent)localObject, 268435456);
    try
    {
      this.p.removeMessages(65282);
      this.p.sendEmptyMessageDelayed(65282, 6000L);
      ((PendingIntent)localObject).send();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      a(3);
    }
  }
  
  protected abstract View a(Context paramContext);
  
  protected void a()
  {
    final WindowManager localWindowManager = (WindowManager)this.o.getSystemService("window");
    if (localWindowManager == null)
    {
      f();
      return;
    }
    this.p.post(new Runnable()
    {
      public void run()
      {
        d.a(d.this, 0);
        d.a(d.this, 1);
        if ((Build.VERSION.SDK_INT != 25) && (Build.VERSION.SDK_INT >= 19)) {
          int i = Build.VERSION.SDK_INT;
        }
        d.a(d.this, 2);
        d.a(d.this);
      }
    });
  }
  
  protected final void a(long paramLong)
  {
    this.a = paramLong;
  }
  
  protected void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 65283: 
      b();
      return;
    case 65282: 
      a(3);
      return;
    case 65281: 
      if ((paramMessage.obj instanceof b))
      {
        b.a((b)paramMessage.obj, true);
        a(2);
        return;
      }
      break;
    case 65280: 
      if ((this.f != null) && (this.g != null)) {
        a(true);
      }
      break;
    }
  }
  
  public final void a(ViewManager paramViewManager, int paramInt)
  {
    this.p.removeMessages(65281);
    this.p.removeMessages(65282);
    this.p.removeMessages(65283);
    if (j() == 0)
    {
      this.e = paramViewManager;
      this.g = a(this.o);
      if (this.g != null)
      {
        paramViewManager = i();
        this.f = new FrameLayout(this.o);
        this.f.addView(this.g, new FrameLayout.LayoutParams(paramViewManager.width, paramViewManager.height));
      }
    }
    try
    {
      this.e.addView(this.f, paramViewManager);
      if ((this.d) && (this.b != null)) {
        this.g.startAnimation(this.b);
      }
      if (this.a > 0L)
      {
        this.p.removeMessages(65280);
        this.p.sendEmptyMessageDelayed(65280, this.a);
      }
      k();
      return;
    }
    catch (Throwable paramViewManager)
    {
      label180:
      break label180;
    }
    f();
  }
  
  protected final void a(Animation paramAnimation)
  {
    this.b = paramAnimation;
  }
  
  public void a(boolean paramBoolean)
  {
    this.p.removeMessages(65281);
    this.p.removeMessages(65282);
    if ((j() != 0) && (j() != 1) && (j() != 2))
    {
      if (this.d)
      {
        Animation localAnimation = this.c;
        if (localAnimation != null)
        {
          localAnimation.setAnimationListener(new Animation.AnimationListener()
          {
            public void onAnimationEnd(Animation paramAnonymousAnimation)
            {
              d.c(d.this).removeView(d.b(d.this));
              d.a(d.this, null);
            }
            
            public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
            
            public void onAnimationStart(Animation paramAnonymousAnimation) {}
          });
          this.g.startAnimation(this.c);
          break label101;
        }
      }
      this.e.removeView(this.f);
      this.f = null;
      label101:
      if ((j() != 3) && (j() != 8))
      {
        if (paramBoolean)
        {
          e();
          return;
        }
        l();
      }
    }
  }
  
  public final void b(Context paramContext)
  {
    e.e();
    this.o = paramContext;
    this.p = new Handler(Looper.getMainLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        d.this.a(paramAnonymousMessage);
      }
    };
    a();
  }
  
  protected final void b(Animation paramAnimation)
  {
    this.c = paramAnimation;
  }
  
  protected void e()
  {
    this.i = 1;
  }
  
  protected void f()
  {
    if (this.i != 7) {
      this.i = 7;
    }
    this.p.removeCallbacksAndMessages(null);
  }
  
  protected void g()
  {
    this.i = 3;
  }
  
  protected abstract WindowManager.LayoutParams i();
  
  public final int j()
  {
    return this.i;
  }
  
  protected void k()
  {
    this.i = 4;
  }
  
  protected void l()
  {
    this.i = 2;
  }
  
  private class a
    extends ContextWrapper
  {
    private WindowManager b;
    
    public a(Context paramContext, WindowManager paramWindowManager)
    {
      super();
      this.b = paramWindowManager;
    }
    
    public Context getApplicationContext()
    {
      return this;
    }
    
    public Object getSystemService(String paramString)
    {
      if (TextUtils.equals(paramString, "window"))
      {
        paramString = d.this;
        paramString.getClass();
        return new d.c(paramString, this.b, null);
      }
      return super.getSystemService(paramString);
    }
  }
  
  private class b
    extends FrameLayout
  {
    private boolean b = false;
    private boolean c = false;
    
    public b(Context paramContext)
    {
      super();
    }
  }
  
  private class c
    implements WindowManager
  {
    private WindowManager b;
    
    private c(WindowManager paramWindowManager)
    {
      this.b = paramWindowManager;
    }
    
    public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
    {
      if (((paramView instanceof d.b)) && ((paramLayoutParams instanceof WindowManager.LayoutParams)))
      {
        final d.b localb = (d.b)paramView;
        paramLayoutParams = (WindowManager.LayoutParams)paramLayoutParams;
        WindowManager.LayoutParams localLayoutParams = d.this.i();
        localLayoutParams.type = 2005;
        localLayoutParams.token = paramLayoutParams.token;
        d.a(d.this, false);
        this.b.addView(paramView, localLayoutParams);
        paramView = new ViewManager()
        {
          public void addView(View paramAnonymousView, ViewGroup.LayoutParams paramAnonymousLayoutParams)
          {
            if (!d.b.a(localb)) {
              try
              {
                localb.addView(paramAnonymousView, new WindowManager.LayoutParams(paramAnonymousLayoutParams.width, paramAnonymousLayoutParams.height));
                d.b.b(localb, true);
                if (Build.VERSION.SDK_INT > 25)
                {
                  d.this.a(3500L);
                  return;
                }
              }
              catch (Throwable paramAnonymousView)
              {
                paramAnonymousView.printStackTrace();
              }
            }
          }
          
          public void removeView(View paramAnonymousView)
          {
            if (d.b.b(localb)) {
              try
              {
                localb.removeView(paramAnonymousView);
                d.c.a(d.c.this).removeViewImmediate(localb);
                return;
              }
              catch (Throwable paramAnonymousView)
              {
                paramAnonymousView.printStackTrace();
              }
            }
          }
          
          public void updateViewLayout(View paramAnonymousView, ViewGroup.LayoutParams paramAnonymousLayoutParams) {}
        };
        d.this.a(paramView, 2);
      }
    }
    
    public Display getDefaultDisplay()
    {
      return this.b.getDefaultDisplay();
    }
    
    public void removeView(View paramView)
    {
      if (!(paramView instanceof d.b)) {
        this.b.removeView(paramView);
      }
    }
    
    public void removeViewImmediate(View paramView)
    {
      if (!(paramView instanceof d.b)) {
        this.b.removeViewImmediate(paramView);
      }
    }
    
    public void updateViewLayout(View paramView, ViewGroup.LayoutParams paramLayoutParams)
    {
      this.b.updateViewLayout(paramView, paramLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.push.d
 * JD-Core Version:    0.7.0.1
 */