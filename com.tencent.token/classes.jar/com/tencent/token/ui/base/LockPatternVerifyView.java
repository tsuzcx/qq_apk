package com.tencent.token.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.token.ah;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.t;
import java.util.List;

public class LockPatternVerifyView
  extends RelativeLayout
  implements cb
{
  protected Runnable a = new bs(this);
  protected Runnable b = new bt(this);
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
  private bz o;
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
  private Handler z = new bv(this);
  
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
  
  private void a(Context paramContext)
  {
    removeAllViews();
    this.h = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.i = this.h.inflate(2130903208, null);
    this.i.setVisibility(0);
    this.c = this.i.findViewById(2131296536);
    this.d = this.i.findViewById(2131296522);
    this.e = this.i.findViewById(2131296584);
    this.f = ((TextView)this.i.findViewById(2131297123));
    this.g = ((TextView)this.i.findViewById(2131297130));
    this.k = ((LockPatternView)this.i.findViewById(2131297124));
    this.k.a(this);
    this.e.setVisibility(4);
    this.p = t.a(paramContext.getResources(), 2130837920);
    this.q = t.a(paramContext.getResources(), 2130837922);
    this.r = t.a(paramContext.getResources(), 2130837923);
    this.s = t.a(paramContext.getResources(), 2130837913);
    this.t = t.a(paramContext.getResources(), 2130837914);
    if (this.s != null) {
      ((LinearLayout)this.i.findViewById(2131296523)).setBackgroundDrawable(new BitmapDrawable(this.s));
    }
    if (this.t != null)
    {
      ((LinearLayout)this.i.findViewById(2131296524)).setBackgroundDrawable(new BitmapDrawable(this.t));
      ((LinearLayout)this.i.findViewById(2131296525)).setBackgroundDrawable(new BitmapDrawable(this.t));
    }
    if (this.p != null)
    {
      this.u = ((ImageView)this.i.findViewById(2131296583));
      this.u.setImageBitmap(this.p);
    }
    if (!RqdApplication.d())
    {
      this.f.setTextColor(getResources().getColor(2131165237));
      this.f.setText(2131362136);
    }
    this.i.setOnTouchListener(new bq(this));
    addView(this.i, new RelativeLayout.LayoutParams(-1, -1));
    this.g.setOnClickListener(new br(this));
    ah.a();
    this.n = ah.g();
  }
  
  public final void a()
  {
    this.k.removeCallbacks(this.a);
  }
  
  public final void a(int paramInt)
  {
    this.v = paramInt;
  }
  
  public final void a(bz parambz)
  {
    this.o = parambz;
    if (this.n >= 5) {
      this.o.a(true);
    }
  }
  
  public final void a(List paramList)
  {
    paramList = this.k.h();
    if (ah.a().a(paramList))
    {
      RqdApplication.f();
      RqdApplication.a();
      this.f.setTextColor(getResources().getColor(2131165237));
      this.f.setText(2131362142);
      this.k.e();
      f();
      ah.a();
      ah.a(0);
      return;
    }
    if (this.r != null) {
      this.u.setImageBitmap(this.r);
    }
    this.u.postDelayed(this.b, 500L);
    if (this.n >= 4)
    {
      ah.a();
      ah.a(this.n + 1);
      this.k.d();
      this.o.a(false);
      return;
    }
    this.n += 1;
    this.k.a(LockPatternView.DisplayMode.Wrong);
    paramList = this.j.getString(2131362139) + (5 - this.n) + "次！";
    this.f.setTextColor(this.j.getResources().getColor(2131165241));
    this.f.setText(paramList);
    this.k.e();
    ah.a();
    ah.a(this.n);
    this.k.postDelayed(this.a, 500L);
  }
  
  public final void b() {}
  
  public final void c() {}
  
  public final void d()
  {
    if (this.k != null) {
      this.k.a();
    }
  }
  
  public final void e()
  {
    this.k.g();
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
  
  public final void f()
  {
    if (this.q != null) {
      this.u.setImageBitmap(this.q);
    }
    if (this.v == 0)
    {
      this.e.setVisibility(0);
      this.z.post(new bw(this, this.c, this.d, this.e));
    }
    do
    {
      return;
      if (this.v == 1)
      {
        Animation localAnimation = AnimationUtils.loadAnimation(this.j, 2130968584);
        localAnimation.setAnimationListener(new bu(this));
        this.i.startAnimation(localAnimation);
        return;
      }
    } while (this.v != 2);
    this.o.a();
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.l = this.c.getMeasuredHeight();
    this.m = this.d.getMeasuredHeight();
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