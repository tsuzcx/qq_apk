package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.token.bx;
import com.tencent.token.cf;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cs;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.utils.l;
import com.tencent.token.utils.m;
import gameloginsdk.CallbackPushStruct;

public class GameLoginSndConfirmView
  extends RelativeLayout
{
  private TextView a;
  private TextView b;
  private TextView c;
  private Button d;
  private Button e;
  private ImageView f;
  private Activity g;
  private LayoutInflater h;
  private View i;
  private View j;
  private View k;
  private View l;
  private View m;
  private Bitmap n;
  private Bitmap o;
  private int p;
  private int q;
  private e r;
  private AlarmManager s = null;
  private PendingIntent t = null;
  private int u;
  private final String v = "com.tencent.token.update_btn_interval_time_action";
  private BroadcastReceiver w = new BroadcastReceiver()
  {
    public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
    {
      if (paramAnonymousIntent.getAction().equals("com.tencent.token.update_btn_interval_time_action")) {
        GameLoginSndConfirmView.this.e();
      }
    }
  };
  private Handler x = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage) {}
  };
  
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
  
  private void f()
  {
    if (this.s != null) {
      return;
    }
    Object localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.token.update_btn_interval_time_action");
    this.g.registerReceiver(this.w, (IntentFilter)localObject);
    localObject = new Intent("com.tencent.token.update_btn_interval_time_action");
    this.s = ((AlarmManager)this.g.getSystemService("alarm"));
    this.t = PendingIntent.getBroadcast(this.g, 0, (Intent)localObject, 0);
  }
  
  public void a()
  {
    this.x.post(new a(this.j, this.k, this.l, this.m));
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 2)
    {
      c();
      return;
    }
    b();
  }
  
  public void a(CallbackPushStruct paramCallbackPushStruct)
  {
    if (paramCallbackPushStruct == null) {
      return;
    }
    f();
    this.u = (paramCallbackPushStruct.expirtTime + 1 - bx.a(RqdApplication.n()).c());
    this.a.setText(2131493232);
    if (paramCallbackPushStruct.player.length() > 10)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramCallbackPushStruct.player.substring(0, 10));
      ((StringBuilder)localObject1).append("...");
      localObject1 = new StringBuffer(((StringBuilder)localObject1).toString());
    }
    else
    {
      localObject1 = new StringBuffer(paramCallbackPushStruct.player);
    }
    Object localObject2 = "";
    if (((StringBuffer)localObject1).length() != 0)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("(<font color=#df642c>");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append("</font>)");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(l.a(paramCallbackPushStruct.uin));
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(this.g.getResources().getString(2131493220));
    ((StringBuilder)localObject1).append("<font color=#df642c>");
    ((StringBuilder)localObject1).append(paramCallbackPushStruct.gameName);
    ((StringBuilder)localObject1).append("-");
    ((StringBuilder)localObject1).append(paramCallbackPushStruct.world);
    ((StringBuilder)localObject1).append("</font>");
    ((StringBuilder)localObject1).append(this.g.getResources().getString(2131493221));
    localObject1 = new StringBuffer(((StringBuilder)localObject1).toString());
    if (paramCallbackPushStruct.schemeFlag == 2) {
      ((StringBuffer)localObject1).append("。");
    } else {
      ((StringBuffer)localObject1).append(this.g.getString(2131493222));
    }
    this.b.setText(Html.fromHtml(((StringBuffer)localObject1).toString()));
    localObject1 = this.d;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(getResources().getString(2131493218));
    ((StringBuilder)localObject2).append("(");
    ((StringBuilder)localObject2).append(this.u);
    ((StringBuilder)localObject2).append(")");
    ((Button)localObject1).setText(((StringBuilder)localObject2).toString());
    this.e.setText(getResources().getString(2131493229));
    paramCallbackPushStruct = cs.a().d(Long.parseLong(paramCallbackPushStruct.uin));
    if (paramCallbackPushStruct != null)
    {
      localObject1 = this.f;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramCallbackPushStruct.b());
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramCallbackPushStruct.mUin);
      localStringBuilder.append("");
      ((ImageView)localObject1).setImageDrawable(com.tencent.token.utils.g.a((String)localObject2, localStringBuilder.toString()));
      this.c.setText(paramCallbackPushStruct.mNickName);
    }
    else
    {
      this.c.setText("");
    }
    e();
  }
  
  public boolean a(Context paramContext)
  {
    Activity localActivity = this.g;
    if ((localActivity != null) && ((localActivity == null) || (!localActivity.isFinishing())))
    {
      this.h = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
      this.i = this.h.inflate(2131296320, null);
      this.i.setVisibility(4);
      this.j = this.i.findViewById(2131166260);
      this.k = this.i.findViewById(2131166247);
      this.l = this.i.findViewById(2131166261);
      this.m = this.i.findViewById(2131166248);
      this.n = m.a(this.g.getResources(), 2131099827);
      this.o = m.a(this.g.getResources(), 2131099826);
      if (this.n != null) {
        ((LinearLayout)this.i.findViewById(2131166241)).setBackgroundDrawable(new BitmapDrawable(this.n));
      }
      if (this.o != null)
      {
        ((LinearLayout)this.i.findViewById(2131166242)).setBackgroundDrawable(new BitmapDrawable(this.o));
        ((LinearLayout)this.i.findViewById(2131166243)).setBackgroundDrawable(new BitmapDrawable(this.o));
      }
      this.a = ((TextView)this.i.findViewById(2131165756));
      this.b = ((TextView)this.i.findViewById(2131165744));
      this.f = ((ImageView)this.i.findViewById(2131165747));
      this.d = ((Button)this.i.findViewById(2131165743));
      this.e = ((Button)this.i.findViewById(2131165753));
      this.c = ((TextView)this.i.findViewById(2131165759));
      this.d.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          GameLoginSndConfirmView.a(GameLoginSndConfirmView.this).a(1);
        }
      });
      this.e.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          GameLoginSndConfirmView.a(GameLoginSndConfirmView.this).a(2);
        }
      });
      addView(this.i, new RelativeLayout.LayoutParams(-1, -1));
      return true;
    }
    return false;
  }
  
  public void b()
  {
    this.x.post(new b(this.j, this.k, this.l, this.m));
    cf.a(RqdApplication.n()).a();
  }
  
  public void c()
  {
    this.x.post(new c(this));
  }
  
  public void d()
  {
    com.tencent.token.global.g.a("game login unregister interval timer");
    AlarmManager localAlarmManager = this.s;
    if (localAlarmManager != null)
    {
      localAlarmManager.cancel(this.t);
      this.g.unregisterReceiver(this.w);
      this.s = null;
    }
  }
  
  public void e()
  {
    this.u -= 1;
    if (this.u <= 0)
    {
      d();
      this.r.b();
      return;
    }
    Object localObject = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getResources().getString(2131493218));
    localStringBuilder.append("(");
    localStringBuilder.append(this.u);
    localStringBuilder.append(")");
    ((Button)localObject).setText(localStringBuilder.toString());
    long l1 = System.currentTimeMillis();
    localObject = this.s;
    if (localObject != null) {
      ((AlarmManager)localObject).set(1, l1 + 1000L, this.t);
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.p = this.j.getMeasuredHeight();
    this.q = this.k.getMeasuredHeight();
  }
  
  public void setListener(e parame)
  {
    this.r = parame;
  }
  
  private class a
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
        public void onAnimationEnd(Animation paramAnonymousAnimation) {}
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    
    public void run()
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
  
  private class b
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
      this.h.setInterpolator(new GameLoginSndConfirmView.d(GameLoginSndConfirmView.this, null));
      this.i = new TranslateAnimation(0.0F, 0.0F, 0.0F, GameLoginSndConfirmView.b(GameLoginSndConfirmView.this));
      this.i.setDuration(600L);
      this.i.setInterpolator(new GameLoginSndConfirmView.d(GameLoginSndConfirmView.this, null));
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
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          GameLoginSndConfirmView.this.setVisibility(8);
          if (GameLoginSndConfirmView.a(GameLoginSndConfirmView.this) != null) {
            GameLoginSndConfirmView.a(GameLoginSndConfirmView.this).a();
          }
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    
    public void run()
    {
      GameLoginSndConfirmView.e(GameLoginSndConfirmView.this).setEnabled(false);
      GameLoginSndConfirmView.f(GameLoginSndConfirmView.this).setEnabled(false);
      this.b.startAnimation(this.f);
      this.c.startAnimation(this.g);
      this.d.startAnimation(this.h);
      this.e.startAnimation(this.i);
    }
  }
  
  private class c
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
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          GameLoginSndConfirmView.this.setVisibility(8);
          if (GameLoginSndConfirmView.a(GameLoginSndConfirmView.this) != null) {
            GameLoginSndConfirmView.a(GameLoginSndConfirmView.this).a();
          }
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    
    public void run()
    {
      this.b.startAnimation(this.c);
    }
  }
  
  private class d
    implements Interpolator
  {
    private d() {}
    
    public float getInterpolation(float paramFloat)
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