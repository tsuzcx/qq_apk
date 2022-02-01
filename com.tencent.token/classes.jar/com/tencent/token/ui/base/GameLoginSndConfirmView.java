package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.xv;

public class GameLoginSndConfirmView
  extends RelativeLayout
{
  TextView a;
  TextView b;
  TextView c;
  Button d;
  Button e;
  ImageView f;
  Activity g;
  LayoutInflater h;
  View i;
  View j;
  View k;
  View l;
  View m;
  Bitmap n;
  Bitmap o;
  AlarmManager p = null;
  PendingIntent q = null;
  int r;
  BroadcastReceiver s = new BroadcastReceiver()
  {
    public final void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("com.tencent.token.update_btn_interval_time_action")) {
        GameLoginSndConfirmView.this.b();
      }
    }
  };
  Handler t = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage) {}
  };
  private int u;
  private int v;
  private e w;
  private final String x = "com.tencent.token.update_btn_interval_time_action";
  
  public GameLoginSndConfirmView(Activity paramActivity)
  {
    super(paramActivity);
    this.g = paramActivity;
  }
  
  public GameLoginSndConfirmView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.g = ((Activity)paramContext);
  }
  
  public GameLoginSndConfirmView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.g = ((Activity)paramContext);
  }
  
  public final void a()
  {
    xv.a("game login unregister interval timer");
    AlarmManager localAlarmManager = this.p;
    if (localAlarmManager != null)
    {
      localAlarmManager.cancel(this.q);
      this.g.unregisterReceiver(this.s);
      this.p = null;
    }
  }
  
  public final void b()
  {
    this.r -= 1;
    if (this.r <= 0)
    {
      a();
      this.w.b();
      return;
    }
    Object localObject = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getResources().getString(2131493220));
    localStringBuilder.append("(");
    localStringBuilder.append(this.r);
    localStringBuilder.append(")");
    ((Button)localObject).setText(localStringBuilder.toString());
    long l1 = System.currentTimeMillis();
    localObject = this.p;
    if (localObject != null) {
      ((AlarmManager)localObject).set(1, l1 + 1000L, this.q);
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.u = this.j.getMeasuredHeight();
    this.v = this.k.getMeasuredHeight();
  }
  
  public void setListener(e parame)
  {
    this.w = parame;
  }
  
  final class a
    implements Runnable
  {
    private View b;
    private View c;
    private View d;
    private View e;
    private TranslateAnimation f;
    private TranslateAnimation g;
    private TranslateAnimation h;
    private TranslateAnimation i;
    
    public a(View paramView1, View paramView2, View paramView3, View paramView4)
    {
      this.b = paramView1;
      this.c = paramView2;
      this.d = paramView3;
      this.e = paramView4;
      int j = (int)(IndexActivity.S_DENSITY * 40.0F);
      this.h = new TranslateAnimation(0.0F, 0.0F, GameLoginSndConfirmView.b(GameLoginSndConfirmView.this), 0.0F);
      this.h.setDuration(400L);
      this.h.setInterpolator(new AccelerateDecelerateInterpolator());
      this.i = new TranslateAnimation(0.0F, 0.0F, -GameLoginSndConfirmView.c(GameLoginSndConfirmView.this) + j, 0.0F);
      this.i.setDuration(400L);
      this.i.setInterpolator(new AccelerateDecelerateInterpolator());
      this.f = new TranslateAnimation(0.0F, 0.0F, GameLoginSndConfirmView.b(GameLoginSndConfirmView.this), 0.0F);
      this.f.setDuration(500L);
      this.g = new TranslateAnimation(0.0F, 0.0F, -GameLoginSndConfirmView.c(GameLoginSndConfirmView.this), 0.0F);
      this.g.setDuration(500L);
      this.g.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    
    public final void run()
    {
      GameLoginSndConfirmView.d(GameLoginSndConfirmView.this).setVisibility(0);
      GameLoginSndConfirmView.e(GameLoginSndConfirmView.this).setEnabled(true);
      GameLoginSndConfirmView.f(GameLoginSndConfirmView.this).setEnabled(true);
      this.c.startAnimation(this.f);
      this.b.startAnimation(this.g);
      this.e.startAnimation(this.h);
      this.d.startAnimation(this.i);
    }
  }
  
  final class b
    implements Runnable
  {
    private View b;
    private View c;
    private View d;
    private View e;
    private TranslateAnimation f;
    private TranslateAnimation g;
    private TranslateAnimation h;
    private TranslateAnimation i;
    
    public b(View paramView1, View paramView2, View paramView3, View paramView4)
    {
      this.b = paramView1;
      this.c = paramView2;
      this.d = paramView3;
      this.e = paramView4;
      int j = (int)(IndexActivity.S_DENSITY * 40.0F);
      this.h = new TranslateAnimation(0.0F, 0.0F, 0.0F, -GameLoginSndConfirmView.c(GameLoginSndConfirmView.this) + j);
      this.h.setDuration(600L);
      this.h.setInterpolator(new GameLoginSndConfirmView.d(GameLoginSndConfirmView.this, (byte)0));
      this.i = new TranslateAnimation(0.0F, 0.0F, 0.0F, GameLoginSndConfirmView.b(GameLoginSndConfirmView.this));
      this.i.setDuration(600L);
      this.i.setInterpolator(new GameLoginSndConfirmView.d(GameLoginSndConfirmView.this, (byte)0));
      this.f = new TranslateAnimation(0.0F, 0.0F, 0.0F, -GameLoginSndConfirmView.c(GameLoginSndConfirmView.this));
      this.f.setDuration(600L);
      this.f.setInterpolator(new AccelerateInterpolator());
      this.f.setFillAfter(true);
      this.g = new TranslateAnimation(0.0F, 0.0F, 0.0F, GameLoginSndConfirmView.b(GameLoginSndConfirmView.this));
      this.g.setDuration(600L);
      this.g.setInterpolator(new AccelerateInterpolator());
      this.g.setFillAfter(true);
      this.i.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          GameLoginSndConfirmView.this.setVisibility(8);
          if (GameLoginSndConfirmView.a(GameLoginSndConfirmView.this) != null) {
            GameLoginSndConfirmView.a(GameLoginSndConfirmView.this).a();
          }
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    
    public final void run()
    {
      GameLoginSndConfirmView.e(GameLoginSndConfirmView.this).setEnabled(false);
      GameLoginSndConfirmView.f(GameLoginSndConfirmView.this).setEnabled(false);
      this.b.startAnimation(this.f);
      this.c.startAnimation(this.g);
      this.d.startAnimation(this.h);
      this.e.startAnimation(this.i);
    }
  }
  
  final class c
    implements Runnable
  {
    private View b;
    private Animation c;
    
    public c(View paramView)
    {
      this.b = paramView;
      this.c = AnimationUtils.loadAnimation(GameLoginSndConfirmView.g(GameLoginSndConfirmView.this), 2130771993);
      this.c.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          GameLoginSndConfirmView.this.setVisibility(8);
          if (GameLoginSndConfirmView.a(GameLoginSndConfirmView.this) != null) {
            GameLoginSndConfirmView.a(GameLoginSndConfirmView.this).a();
          }
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    
    public final void run()
    {
      this.b.startAnimation(this.c);
    }
  }
  
  final class d
    implements Interpolator
  {
    private d() {}
    
    public final float getInterpolation(float paramFloat)
    {
      if (paramFloat < 0.3D) {
        return 0.0F;
      }
      paramFloat = (paramFloat - 0.3F) / 0.7F;
      return paramFloat * paramFloat;
    }
  }
  
  public static abstract interface e
  {
    public abstract void a();
    
    public abstract void a(int paramInt);
    
    public abstract void b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.GameLoginSndConfirmView
 * JD-Core Version:    0.7.0.1
 */