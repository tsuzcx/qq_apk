package com.tencent.token.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.token.aau;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.sx;
import com.tencent.token.sy;
import com.tencent.token.tt;
import com.tencent.token.ui.IndexActivity;

public class DualMsgView
  extends RelativeLayout
{
  View a;
  View b;
  TextView c;
  TextView d;
  TextView e;
  TextView f;
  TextView g;
  Button h;
  Button i;
  ImageView j;
  ImageView k;
  ImageView l;
  Activity m;
  LayoutInflater n;
  View o;
  View p;
  View q;
  View r;
  View s;
  Bitmap t;
  Bitmap u;
  Handler v = new Handler()
  {
    public final void handleMessage(Message paramAnonymousMessage) {}
  };
  private int w;
  private int x;
  private f y;
  
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
  
  private static String a(String paramString1, String paramString2)
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
  
  private void b()
  {
    this.v.post(new c(this.p, this.q, this.r, this.s));
    sx.a(RqdApplication.n()).a();
  }
  
  private void c()
  {
    this.v.post(new d(this));
  }
  
  public final void a()
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
  
  public final void a(int paramInt)
  {
    if (paramInt == 3)
    {
      c();
      return;
    }
    b();
  }
  
  public final void a(sy paramsy)
  {
    this.c.setText(Html.fromHtml(paramsy.f));
    this.d.setText(Html.fromHtml(paramsy.g));
    this.h.setText(a(paramsy.h, " "));
    this.i.setText(a(paramsy.i, " "));
    paramsy = tt.a().c(paramsy.c);
    if (paramsy != null)
    {
      ImageView localImageView = this.j;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramsy.mRealUin);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramsy.mUin);
      localImageView.setImageDrawable(aau.a((String)localObject, localStringBuilder.toString()));
      if (paramsy.mIsZzb)
      {
        this.k.setImageDrawable(getResources().getDrawable(2131100233));
        this.l.setVisibility(0);
      }
      this.g.setText(paramsy.mNickName);
      return;
    }
    this.g.setText("");
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.w = this.p.getMeasuredHeight();
    this.x = this.q.getMeasuredHeight();
  }
  
  public void setListener(f paramf)
  {
    this.y = paramf;
  }
  
  final class a
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
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          DualMsgView.i(DualMsgView.this).setText(DualMsgView.h(DualMsgView.this).getText());
          DualMsgView.k(DualMsgView.this).setText(DualMsgView.j(DualMsgView.this).getText());
          DualMsgView.a.a(DualMsgView.a.this).setVisibility(4);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    
    public final void run()
    {
      this.c.setVisibility(0);
      this.b.startAnimation(this.e);
      this.c.startAnimation(this.d);
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
        public final void onAnimationEnd(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    
    public final void run()
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
  
  final class c
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
      this.h.setInterpolator(new DualMsgView.e(DualMsgView.this, (byte)0));
      this.i = new TranslateAnimation(0.0F, 0.0F, 0.0F, DualMsgView.b(DualMsgView.this));
      this.i.setDuration(600L);
      this.i.setInterpolator(new DualMsgView.e(DualMsgView.this, (byte)0));
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
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          DualMsgView.this.setVisibility(8);
          if (DualMsgView.a(DualMsgView.this) != null) {
            DualMsgView.a(DualMsgView.this).a();
          }
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    
    public final void run()
    {
      DualMsgView.e(DualMsgView.this).setEnabled(false);
      DualMsgView.f(DualMsgView.this).setEnabled(false);
      this.b.startAnimation(this.f);
      this.c.startAnimation(this.g);
      this.d.startAnimation(this.h);
      this.e.startAnimation(this.i);
    }
  }
  
  final class d
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
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          DualMsgView.this.setVisibility(8);
          if (DualMsgView.a(DualMsgView.this) != null) {
            DualMsgView.a(DualMsgView.this).a();
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
  
  final class e
    implements Interpolator
  {
    private e() {}
    
    public final float getInterpolation(float paramFloat)
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