package com.tencent.token;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.support.v7.widget.ActionMenuPresenter;
import android.support.v7.widget.ActionMenuView;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

public abstract class is
  extends ViewGroup
{
  protected final a a = new a();
  protected final Context b;
  protected ActionMenuView c;
  protected ActionMenuPresenter d;
  protected int e;
  protected fr f;
  private boolean g;
  private boolean h;
  
  is(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  protected is(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = new TypedValue();
    if ((paramContext.getTheme().resolveAttribute(hg.a.actionBarPopupTheme, paramAttributeSet, true)) && (paramAttributeSet.resourceId != 0))
    {
      this.b = new ContextThemeWrapper(paramContext, paramAttributeSet.resourceId);
      return;
    }
    this.b = paramContext;
  }
  
  protected static int a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramInt1 - paramInt2;
    }
    return paramInt1 + paramInt2;
  }
  
  protected static int a(View paramView, int paramInt1, int paramInt2)
  {
    paramView.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648), paramInt2);
    return Math.max(0, paramInt1 - paramView.getMeasuredWidth() - 0);
  }
  
  protected static int a(View paramView, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = paramView.getMeasuredWidth();
    int j = paramView.getMeasuredHeight();
    paramInt2 += (paramInt3 - j) / 2;
    if (paramBoolean) {
      paramView.layout(paramInt1 - i, paramInt2, paramInt1, j + paramInt2);
    } else {
      paramView.layout(paramInt1, paramInt2, paramInt1 + i, j + paramInt2);
    }
    if (paramBoolean) {
      return -i;
    }
    return i;
  }
  
  public fr a(int paramInt, long paramLong)
  {
    fr localfr = this.f;
    if (localfr != null) {
      localfr.b();
    }
    if (paramInt == 0)
    {
      if (getVisibility() != 0) {
        setAlpha(0.0F);
      }
      localfr = fo.f(this).a(1.0F);
      localfr.a(paramLong);
      localfr.a(this.a.a(localfr, paramInt));
      return localfr;
    }
    localfr = fo.f(this).a(0.0F);
    localfr.a(paramLong);
    localfr.a(this.a.a(localfr, paramInt));
    return localfr;
  }
  
  public boolean a()
  {
    ActionMenuPresenter localActionMenuPresenter = this.d;
    if (localActionMenuPresenter != null) {
      return localActionMenuPresenter.d();
    }
    return false;
  }
  
  public int getAnimatedVisibility()
  {
    if (this.f != null) {
      return this.a.a;
    }
    return getVisibility();
  }
  
  public int getContentHeight()
  {
    return this.e;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = getContext().obtainStyledAttributes(null, hg.j.ActionBar, hg.a.actionBarStyle, 0);
    setContentHeight(paramConfiguration.getLayoutDimension(hg.j.ActionBar_height, 0));
    paramConfiguration.recycle();
    paramConfiguration = this.d;
    if (paramConfiguration != null) {
      paramConfiguration.b();
    }
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 9) {
      this.h = false;
    }
    if (!this.h)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i == 9) && (!bool)) {
        this.h = true;
      }
    }
    if ((i == 10) || (i == 3)) {
      this.h = false;
    }
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      this.g = false;
    }
    if (!this.g)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i == 0) && (!bool)) {
        this.g = true;
      }
    }
    if ((i == 1) || (i == 3)) {
      this.g = false;
    }
    return true;
  }
  
  public void setContentHeight(int paramInt)
  {
    this.e = paramInt;
    requestLayout();
  }
  
  public void setVisibility(int paramInt)
  {
    if (paramInt != getVisibility())
    {
      fr localfr = this.f;
      if (localfr != null) {
        localfr.b();
      }
      super.setVisibility(paramInt);
    }
  }
  
  public final class a
    implements fs
  {
    int a;
    private boolean c = false;
    
    protected a() {}
    
    public final a a(fr paramfr, int paramInt)
    {
      is.this.f = paramfr;
      this.a = paramInt;
      return this;
    }
    
    public final void a(View paramView)
    {
      is.a(is.this);
      this.c = false;
    }
    
    public final void b(View paramView)
    {
      if (this.c) {
        return;
      }
      paramView = is.this;
      paramView.f = null;
      is.a(paramView, this.a);
    }
    
    public final void c(View paramView)
    {
      this.c = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.is
 * JD-Core Version:    0.7.0.1
 */