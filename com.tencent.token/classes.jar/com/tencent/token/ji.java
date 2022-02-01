package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnHoverListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

final class ji
  implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener
{
  private static ji i;
  private static ji j;
  private final View a;
  private final CharSequence b;
  private final Runnable c = new Runnable()
  {
    public final void run()
    {
      ji.a(ji.this);
    }
  };
  private final Runnable d = new Runnable()
  {
    public final void run()
    {
      ji.b(ji.this);
    }
  };
  private int e;
  private int f;
  private jj g;
  private boolean h;
  
  private ji(View paramView, CharSequence paramCharSequence)
  {
    this.a = paramView;
    this.b = paramCharSequence;
    this.a.setOnLongClickListener(this);
    this.a.setOnHoverListener(this);
  }
  
  private void a()
  {
    if (j == this)
    {
      j = null;
      jj localjj = this.g;
      if (localjj != null)
      {
        localjj.a();
        this.g = null;
        this.a.removeOnAttachStateChangeListener(this);
      }
    }
    if (i == this) {
      c(null);
    }
    this.a.removeCallbacks(this.d);
  }
  
  public static void a(View paramView, CharSequence paramCharSequence)
  {
    ji localji = i;
    if ((localji != null) && (localji.a == paramView)) {
      c(null);
    }
    if (TextUtils.isEmpty(paramCharSequence))
    {
      paramCharSequence = j;
      if ((paramCharSequence != null) && (paramCharSequence.a == paramView)) {
        paramCharSequence.a();
      }
      paramView.setOnLongClickListener(null);
      paramView.setLongClickable(false);
      paramView.setOnHoverListener(null);
      return;
    }
    new ji(paramView, paramCharSequence);
  }
  
  private void a(boolean paramBoolean)
  {
    if (!ex.s(this.a)) {
      return;
    }
    c(null);
    ji localji = j;
    if (localji != null) {
      localji.a();
    }
    j = this;
    this.h = paramBoolean;
    this.g = new jj(this.a.getContext());
    this.g.a(this.a, this.e, this.f, this.h, this.b);
    this.a.addOnAttachStateChangeListener(this);
    long l;
    if (this.h) {
      l = 2500L;
    } else if ((ex.i(this.a) & 0x1) == 1) {
      l = 3000L - ViewConfiguration.getLongPressTimeout();
    } else {
      l = 15000L - ViewConfiguration.getLongPressTimeout();
    }
    this.a.removeCallbacks(this.d);
    this.a.postDelayed(this.d, l);
  }
  
  private void b()
  {
    this.a.postDelayed(this.c, ViewConfiguration.getLongPressTimeout());
  }
  
  private void c()
  {
    this.a.removeCallbacks(this.c);
  }
  
  private static void c(ji paramji)
  {
    ji localji = i;
    if (localji != null) {
      localji.c();
    }
    i = paramji;
    if (paramji != null) {
      i.b();
    }
  }
  
  public final boolean onHover(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.g != null) && (this.h)) {
      return false;
    }
    paramView = (AccessibilityManager)this.a.getContext().getSystemService("accessibility");
    if ((paramView.isEnabled()) && (paramView.isTouchExplorationEnabled())) {
      return false;
    }
    int k = paramMotionEvent.getAction();
    if (k != 7)
    {
      if (k != 10) {
        return false;
      }
      a();
      return false;
    }
    if ((this.a.isEnabled()) && (this.g == null))
    {
      this.e = ((int)paramMotionEvent.getX());
      this.f = ((int)paramMotionEvent.getY());
      c(this);
    }
    return false;
  }
  
  public final boolean onLongClick(View paramView)
  {
    this.e = (paramView.getWidth() / 2);
    this.f = (paramView.getHeight() / 2);
    a(true);
    return true;
  }
  
  public final void onViewAttachedToWindow(View paramView) {}
  
  public final void onViewDetachedFromWindow(View paramView)
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ji
 * JD-Core Version:    0.7.0.1
 */