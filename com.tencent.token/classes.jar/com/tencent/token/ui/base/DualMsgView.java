package com.tencent.token.ui.base;

import android.app.Activity;
import android.content.Context;
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
import com.tencent.token.cf;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.a;
import com.tencent.token.cs;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.ui.IndexActivity;
import com.tencent.token.utils.g;
import com.tencent.token.utils.m;

public class DualMsgView
  extends RelativeLayout
{
  private View a;
  private View b;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private Button h;
  private Button i;
  private ImageView j;
  private ImageView k;
  private ImageView l;
  private Activity m;
  private LayoutInflater n;
  private View o;
  private View p;
  private View q;
  private View r;
  private View s;
  private Bitmap t;
  private Bitmap u;
  private int v;
  private int w;
  private f x;
  private Handler y = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage) {}
  };
  
  public DualMsgView(Activity paramActivity)
  {
    super(paramActivity);
    this.m = paramActivity;
  }
  
  public DualMsgView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.m = ((Activity)paramContext);
  }
  
  public DualMsgView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.m = ((Activity)paramContext);
  }
  
  private String a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      String str = null;
      int i1 = 0;
      while (i1 < paramString1.length() - 1)
      {
        if (str == null)
        {
          str = paramString1.substring(i1, i1 + 1);
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append(paramString1.substring(i1, i1 + 1));
          str = localStringBuilder.toString();
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(paramString2);
        str = localStringBuilder.toString();
        i1 += 1;
      }
      paramString2 = new StringBuilder();
      paramString2.append(str);
      paramString2.append(paramString1.substring(paramString1.length() - 1, paramString1.length()));
      return paramString2.toString();
    }
    return "";
  }
  
  public void a()
  {
    Bitmap localBitmap = this.t;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
    localBitmap = this.u;
    if (localBitmap != null) {
      localBitmap.recycle();
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 3)
    {
      d();
      return;
    }
    c();
  }
  
  public void a(a parama)
  {
    this.c.setText(Html.fromHtml(parama.f()));
    this.d.setText(Html.fromHtml(parama.g()));
    this.h.setText(a(parama.h(), " "));
    this.i.setText(a(parama.i(), " "));
    parama = cs.a().c(parama.c());
    if (parama != null)
    {
      ImageView localImageView = this.j;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(parama.b());
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(parama.mUin);
      localStringBuilder.append("");
      localImageView.setImageDrawable(g.a((String)localObject, localStringBuilder.toString()));
      if (parama.mIsZzb)
      {
        this.k.setImageDrawable(getResources().getDrawable(2131100224));
        this.l.setVisibility(0);
      }
      this.g.setText(parama.mNickName);
      return;
    }
    this.g.setText("");
  }
  
  public boolean a(Context paramContext)
  {
    Activity localActivity = this.m;
    if ((localActivity != null) && ((localActivity == null) || (!localActivity.isFinishing())))
    {
      this.n = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
      this.o = this.n.inflate(2131296320, null);
      this.o.setVisibility(4);
      this.p = this.o.findViewById(2131166260);
      this.q = this.o.findViewById(2131166247);
      this.r = this.o.findViewById(2131166261);
      this.s = this.o.findViewById(2131166248);
      this.t = m.a(this.m.getResources(), 2131099827);
      this.u = m.a(this.m.getResources(), 2131099826);
      if (this.t != null) {
        ((LinearLayout)this.o.findViewById(2131166241)).setBackgroundDrawable(new BitmapDrawable(this.t));
      }
      if (this.u != null)
      {
        ((LinearLayout)this.o.findViewById(2131166242)).setBackgroundDrawable(new BitmapDrawable(this.u));
        ((LinearLayout)this.o.findViewById(2131166243)).setBackgroundDrawable(new BitmapDrawable(this.u));
      }
      this.a = this.o.findViewById(2131165760);
      this.c = ((TextView)this.o.findViewById(2131165756));
      this.d = ((TextView)this.o.findViewById(2131165744));
      this.b = this.o.findViewById(2131165761);
      this.e = ((TextView)this.o.findViewById(2131165757));
      this.f = ((TextView)this.o.findViewById(2131165745));
      this.j = ((ImageView)this.o.findViewById(2131165747));
      this.k = ((ImageView)this.o.findViewById(2131165749));
      this.l = ((ImageView)this.o.findViewById(2131165748));
      this.h = ((Button)this.o.findViewById(2131165743));
      this.i = ((Button)this.o.findViewById(2131165753));
      this.g = ((TextView)this.o.findViewById(2131165759));
      this.h.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          DualMsgView.a(DualMsgView.this).a(2);
        }
      });
      this.i.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          DualMsgView.a(DualMsgView.this).a(3);
        }
      });
      addView(this.o, new RelativeLayout.LayoutParams(-1, -1));
      return true;
    }
    return false;
  }
  
  public void b()
  {
    this.y.post(new b(this.p, this.q, this.r, this.s));
  }
  
  public void b(a parama)
  {
    this.e.setText(Html.fromHtml(parama.f()));
    this.f.setText(Html.fromHtml(parama.g()));
    Object localObject1 = this.h;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("  ");
    ((StringBuilder)localObject2).append(Html.fromHtml(parama.h()));
    ((Button)localObject1).setText(((StringBuilder)localObject2).toString());
    localObject1 = this.i;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("  ");
    ((StringBuilder)localObject2).append(Html.fromHtml(parama.i()));
    ((Button)localObject1).setText(((StringBuilder)localObject2).toString());
    parama = cs.a().c(parama.c());
    if (parama != null)
    {
      localObject1 = this.j;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(parama.b());
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(parama.mUin);
      localStringBuilder.append("");
      ((ImageView)localObject1).setImageDrawable(g.a((String)localObject2, localStringBuilder.toString()));
      if (parama.mIsZzb)
      {
        this.k.setImageDrawable(getResources().getDrawable(2131100224));
        this.l.setVisibility(0);
      }
      this.g.setText(parama.mNickName);
    }
    else
    {
      this.g.setText("");
      this.l.setVisibility(4);
    }
    this.y.post(new a(this.a, this.b));
  }
  
  public void c()
  {
    this.y.post(new c(this.p, this.q, this.r, this.s));
    cf.a(RqdApplication.n()).a();
  }
  
  public void d()
  {
    this.y.post(new d(this));
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.v = this.p.getMeasuredHeight();
    this.w = this.q.getMeasuredHeight();
  }
  
  public void setListener(f paramf)
  {
    this.x = paramf;
  }
  
  private class a
    implements Runnable
  {
    private View b;
    private View c;
    private Animation d;
    private Animation e;
    
    public a(View paramView1, View paramView2)
    {
      this.b = paramView1;
      this.c = paramView2;
      this.d = AnimationUtils.loadAnimation(DualMsgView.g(DualMsgView.this), 2130771989);
      this.e = AnimationUtils.loadAnimation(DualMsgView.g(DualMsgView.this), 2130771992);
      this.e.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          DualMsgView.i(DualMsgView.this).setText(DualMsgView.h(DualMsgView.this).getText());
          DualMsgView.k(DualMsgView.this).setText(DualMsgView.j(DualMsgView.this).getText());
          DualMsgView.a.a(DualMsgView.a.this).setVisibility(4);
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    
    public void run()
    {
      this.c.setVisibility(0);
      this.b.startAnimation(this.e);
      this.c.startAnimation(this.d);
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
      this.h = new TranslateAnimation(0.0F, 0.0F, DualMsgView.b(DualMsgView.this), 0.0F);
      this.h.setDuration(400L);
      this.h.setInterpolator(new AccelerateDecelerateInterpolator());
      this.i = new TranslateAnimation(0.0F, 0.0F, -DualMsgView.c(DualMsgView.this) + j, 0.0F);
      this.i.setDuration(400L);
      this.i.setInterpolator(new AccelerateDecelerateInterpolator());
      this.f = new TranslateAnimation(0.0F, 0.0F, DualMsgView.b(DualMsgView.this), 0.0F);
      this.f.setDuration(500L);
      this.g = new TranslateAnimation(0.0F, 0.0F, -DualMsgView.c(DualMsgView.this), 0.0F);
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
      DualMsgView.d(DualMsgView.this).setVisibility(0);
      DualMsgView.e(DualMsgView.this).setEnabled(true);
      DualMsgView.f(DualMsgView.this).setEnabled(true);
      this.c.startAnimation(this.f);
      this.b.startAnimation(this.g);
      this.e.startAnimation(this.h);
      this.d.startAnimation(this.i);
    }
  }
  
  private class c
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
    
    public c(View paramView1, View paramView2, View paramView3, View paramView4)
    {
      this.b = paramView1;
      this.c = paramView2;
      this.d = paramView3;
      this.e = paramView4;
      int j = (int)(IndexActivity.S_DENSITY * 40.0F);
      this.h = new TranslateAnimation(0.0F, 0.0F, 0.0F, -DualMsgView.c(DualMsgView.this) + j);
      this.h.setDuration(600L);
      this.h.setInterpolator(new DualMsgView.e(DualMsgView.this, null));
      this.i = new TranslateAnimation(0.0F, 0.0F, 0.0F, DualMsgView.b(DualMsgView.this));
      this.i.setDuration(600L);
      this.i.setInterpolator(new DualMsgView.e(DualMsgView.this, null));
      this.f = new TranslateAnimation(0.0F, 0.0F, 0.0F, -DualMsgView.c(DualMsgView.this));
      this.f.setDuration(600L);
      this.f.setInterpolator(new AccelerateInterpolator());
      this.f.setFillAfter(true);
      this.g = new TranslateAnimation(0.0F, 0.0F, 0.0F, DualMsgView.b(DualMsgView.this));
      this.g.setDuration(600L);
      this.g.setInterpolator(new AccelerateInterpolator());
      this.g.setFillAfter(true);
      this.i.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          DualMsgView.this.setVisibility(8);
          if (DualMsgView.a(DualMsgView.this) != null) {
            DualMsgView.a(DualMsgView.this).a();
          }
        }
        
        public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    
    public void run()
    {
      DualMsgView.e(DualMsgView.this).setEnabled(false);
      DualMsgView.f(DualMsgView.this).setEnabled(false);
      this.b.startAnimation(this.f);
      this.c.startAnimation(this.g);
      this.d.startAnimation(this.h);
      this.e.startAnimation(this.i);
    }
  }
  
  private class d
    implements Runnable
  {
    private View b;
    private Animation c;
    
    public d(View paramView)
    {
      this.b = paramView;
      this.c = AnimationUtils.loadAnimation(DualMsgView.g(DualMsgView.this), 2130771993);
      this.c.setAnimationListener(new Animation.AnimationListener()
      {
        public void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          DualMsgView.this.setVisibility(8);
          if (DualMsgView.a(DualMsgView.this) != null) {
            DualMsgView.a(DualMsgView.this).a();
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
  
  private class e
    implements Interpolator
  {
    private e() {}
    
    public float getInterpolation(float paramFloat)
    {
      if (paramFloat < 0.3D) {
        return 0.0F;
      }
      paramFloat = (paramFloat - 0.3F) / 0.7F;
      return paramFloat * paramFloat;
    }
  }
  
  public static abstract interface f
  {
    public abstract void a();
    
    public abstract void a(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.DualMsgView
 * JD-Core Version:    0.7.0.1
 */