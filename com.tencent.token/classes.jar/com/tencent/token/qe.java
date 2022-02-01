package com.tencent.token;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewManager;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.push.PActivity;

public abstract class qe
{
  protected Context A;
  protected Handler B;
  private View a;
  private int b = 0;
  long t = -1L;
  Animation u;
  public Animation v;
  boolean w = true;
  ViewManager x;
  FrameLayout y;
  public volatile int z = 0;
  
  private void a(int paramInt)
  {
    int i = this.b;
    paramInt = 1 << paramInt | i;
    if (paramInt != i)
    {
      this.b = paramInt;
      if (this.b == 15) {
        e();
      }
    }
  }
  
  private void b()
  {
    Object localObject = new Intent(this.A, PActivity.class);
    ((Intent)localObject).setFlags(402653184);
    localObject = PendingIntent.getActivity(this.A, 0, (Intent)localObject, 268435456);
    try
    {
      this.B.removeMessages(65282);
      this.B.sendEmptyMessageDelayed(65282, 6000L);
      ((PendingIntent)localObject).send();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      a(3);
    }
  }
  
  protected void a()
  {
    final WindowManager localWindowManager = (WindowManager)this.A.getSystemService("window");
    if (localWindowManager == null)
    {
      e();
      return;
    }
    this.B.post(new Runnable()
    {
      public final void run()
      {
        qe.a(qe.this, 0);
        qe.a(qe.this, 1);
        if ((Build.VERSION.SDK_INT != 25) && (Build.VERSION.SDK_INT >= 19)) {
          int i = Build.VERSION.SDK_INT;
        }
        qe.a(qe.this, 2);
        qe.a(qe.this);
      }
    });
  }
  
  public final void a(Context paramContext)
  {
    qf.d();
    this.A = paramContext;
    this.B = new Handler(Looper.getMainLooper())
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        qe.this.a(paramAnonymousMessage);
      }
    };
    a();
  }
  
  protected final void a(Message paramMessage)
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
      if ((paramMessage.obj instanceof a))
      {
        a.a((a)paramMessage.obj);
        a(2);
        return;
      }
      break;
    case 65280: 
      if ((this.y != null) && (this.a != null))
      {
        a(true);
        return;
      }
      break;
    }
  }
  
  public final void a(ViewManager paramViewManager)
  {
    this.B.removeMessages(65281);
    this.B.removeMessages(65282);
    this.B.removeMessages(65283);
    if (this.z == 0)
    {
      this.x = paramViewManager;
      this.a = g();
      if (this.a != null)
      {
        paramViewManager = h();
        this.y = new FrameLayout(this.A);
        this.y.addView(this.a, new FrameLayout.LayoutParams(paramViewManager.width, paramViewManager.height));
      }
    }
    try
    {
      this.x.addView(this.y, paramViewManager);
      if ((this.w) && (this.u != null)) {
        this.a.startAnimation(this.u);
      }
      if (this.t > 0L)
      {
        this.B.removeMessages(65280);
        this.B.sendEmptyMessageDelayed(65280, this.t);
      }
      this.z = 4;
      return;
    }
    catch (Throwable paramViewManager)
    {
      label177:
      break label177;
    }
    e();
  }
  
  public final void a(boolean paramBoolean)
  {
    this.B.removeMessages(65281);
    this.B.removeMessages(65282);
    if ((this.z != 0) && (this.z != 1) && (this.z != 2))
    {
      if (this.w)
      {
        Animation localAnimation = this.v;
        if (localAnimation != null)
        {
          localAnimation.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymousAnimation)
            {
              qe.this.x.removeView(qe.this.y);
              qe.this.y = null;
            }
            
            public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
            
            public final void onAnimationStart(Animation paramAnonymousAnimation) {}
          });
          this.a.startAnimation(this.v);
          break label101;
        }
      }
      this.x.removeView(this.y);
      this.y = null;
      label101:
      if ((this.z != 3) && (this.z != 8))
      {
        if (paramBoolean)
        {
          d();
          return;
        }
        this.z = 2;
      }
    }
  }
  
  protected void d()
  {
    this.z = 1;
  }
  
  protected void e()
  {
    if (this.z != 7) {
      this.z = 7;
    }
    this.B.removeCallbacksAndMessages(null);
  }
  
  protected void f()
  {
    this.z = 3;
  }
  
  protected abstract View g();
  
  public abstract WindowManager.LayoutParams h();
  
  final class a
    extends FrameLayout
  {
    private boolean a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.qe
 * JD-Core Version:    0.7.0.1
 */