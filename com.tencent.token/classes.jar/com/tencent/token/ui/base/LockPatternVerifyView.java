package com.tencent.token.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.token.cy;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.x;
import java.util.List;

public class LockPatternVerifyView
  extends RelativeLayout
  implements bu
{
  protected Runnable a = new bl(this);
  protected Runnable b = new bm(this);
  private View c;
  private View d;
  private View e;
  private TextView f;
  private TextView g;
  private LayoutInflater h;
  private View i;
  private Context j;
  private LockPatternView k;
  private int l;
  private int m;
  private int n;
  private bs o;
  private Bitmap p;
  private Bitmap q;
  private Bitmap r;
  private Bitmap s;
  private Bitmap t;
  private ImageView u;
  private int v = 0;
  private TranslateAnimation w;
  private TranslateAnimation x;
  private RotateAnimation y;
  private Handler z = new bo(this);
  
  public LockPatternVerifyView(Context paramContext)
  {
    super(paramContext);
    this.j = paramContext;
    a(paramContext);
  }
  
  public LockPatternVerifyView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.j = paramContext;
    a(paramContext);
  }
  
  public LockPatternVerifyView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.j = paramContext;
    a(paramContext);
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.f.setTextColor(this.j.getResources().getColor(2131493044));
    }
    for (;;)
    {
      this.f.setText(paramInt);
      return;
      this.f.setTextColor(getResources().getColor(2131493043));
    }
  }
  
  private void a(String paramString)
  {
    this.f.setTextColor(this.j.getResources().getColor(2131493044));
    this.f.setText(paramString);
  }
  
  private void b(Context paramContext)
  {
    this.h = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.i = this.h.inflate(2130968770, null);
    this.i.setVisibility(0);
    this.c = this.i.findViewById(2131558822);
    this.d = this.i.findViewById(2131558808);
    this.e = this.i.findViewById(2131558871);
    this.f = ((TextView)this.i.findViewById(2131559284));
    this.g = ((TextView)this.i.findViewById(2131559291));
    this.k = ((LockPatternView)this.i.findViewById(2131559285));
    this.k.setOnPatternListener(this);
    this.e.setVisibility(4);
    this.p = x.a(paramContext.getResources(), 2130837982);
    this.q = x.a(paramContext.getResources(), 2130837984);
    this.r = x.a(paramContext.getResources(), 2130837985);
    this.s = x.a(paramContext.getResources(), 2130837975);
    this.t = x.a(paramContext.getResources(), 2130837976);
    if (this.s != null) {
      ((LinearLayout)this.i.findViewById(2131558809)).setBackgroundDrawable(new BitmapDrawable(this.s));
    }
    if (this.t != null)
    {
      ((LinearLayout)this.i.findViewById(2131558810)).setBackgroundDrawable(new BitmapDrawable(this.t));
      ((LinearLayout)this.i.findViewById(2131558811)).setBackgroundDrawable(new BitmapDrawable(this.t));
    }
    if (this.p != null)
    {
      this.u = ((ImageView)this.i.findViewById(2131558870));
      this.u.setImageBitmap(this.p);
    }
    if (!RqdApplication.g()) {
      a(2131231103, false);
    }
    this.i.setOnTouchListener(new bj(this));
    addView(this.i, new RelativeLayout.LayoutParams(-1, -1));
    this.g.setOnClickListener(new bk(this));
  }
  
  private void c(Context paramContext)
  {
    this.n = cy.a().b(paramContext);
  }
  
  public void a()
  {
    this.k.removeCallbacks(this.a);
  }
  
  public void a(Context paramContext)
  {
    removeAllViews();
    b(paramContext);
    c(paramContext);
  }
  
  public void a(List paramList) {}
  
  public void b() {}
  
  public void b(List paramList)
  {
    paramList = this.k.getPatternString();
    if (cy.a().a(paramList))
    {
      RqdApplication.i();
      RqdApplication.d();
      a(2131231110, false);
      this.k.b();
      d();
      cy.a().a(this.j, 0);
      return;
    }
    if (this.r != null) {
      this.u.setImageBitmap(this.r);
    }
    this.u.postDelayed(this.b, 500L);
    if (this.n >= 4)
    {
      cy.a().a(this.j, this.n + 1);
      this.k.a();
      this.o.a(false);
      return;
    }
    this.n += 1;
    this.k.setDisplayMode(LockPatternView.DisplayMode.Wrong);
    a(this.j.getString(2131231112) + (5 - this.n) + "次！");
    this.k.b();
    cy.a().a(this.j, this.n);
    this.k.postDelayed(this.a, 500L);
  }
  
  public void c()
  {
    this.k.d();
    if (this.s != null) {
      this.s.recycle();
    }
    if (this.t != null) {
      this.t.recycle();
    }
    if (this.p != null) {
      this.p.recycle();
    }
    if (this.q != null) {
      this.q.recycle();
    }
    if (this.r != null) {
      this.r.recycle();
    }
  }
  
  public void d()
  {
    if (this.q != null) {
      this.u.setImageBitmap(this.q);
    }
    if (this.v == 0)
    {
      this.e.setVisibility(0);
      this.z.post(new bp(this, this.c, this.d, this.e));
    }
    do
    {
      return;
      if (this.v == 1)
      {
        Animation localAnimation = AnimationUtils.loadAnimation(this.j, 2131034134);
        localAnimation.setAnimationListener(new bn(this));
        this.i.startAnimation(localAnimation);
        return;
      }
    } while (this.v != 2);
    this.o.a();
  }
  
  protected int getScreenHeight()
  {
    return ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getHeight();
  }
  
  protected int getScreenWidth()
  {
    return ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getWidth();
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.l = this.c.getMeasuredHeight();
    this.m = this.d.getMeasuredHeight();
  }
  
  public void setAnimType(int paramInt)
  {
    this.v = paramInt;
  }
  
  public void setPatternViewInStealthMode(boolean paramBoolean)
  {
    if (this.k != null) {
      this.k.setInStealthMode(paramBoolean);
    }
  }
  
  public void setVerifyListener(bs parambs)
  {
    this.o = parambs;
    if (this.n >= 5) {
      this.o.a(true);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.LockPatternVerifyView
 * JD-Core Version:    0.7.0.1
 */