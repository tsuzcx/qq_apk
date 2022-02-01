package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.tencent.widget.AbsListView.e;
import com.tencent.widget.immersive.ImmersiveUtils;
import ncw;
import ncx;

public class DailyTitleBarSwitcher
  extends FrameLayout
{
  private DailyTitleBar a;
  private DailyTitleBar b;
  private View.OnClickListener cr;
  private View.OnClickListener cs;
  private final AbsListView.e h = new ncx(this);
  private boolean init;
  private final Interpolator interpolator = new ncw(this);
  
  public DailyTitleBarSwitcher(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public DailyTitleBarSwitcher(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DailyTitleBarSwitcher(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void aVF()
  {
    if (this.cs == null) {}
    while ((this.a == null) || (this.b == null)) {
      return;
    }
    if (this.a.getAlpha() < 0.1F)
    {
      this.a.setOnTitleClickListener(this.cs);
      this.b.setOnTitleClickListener(this.cs);
      return;
    }
    this.a.setOnTitleClickListener(this.cr);
    this.b.setOnTitleClickListener(this.cr);
  }
  
  private void initViews()
  {
    if (getChildCount() >= 2)
    {
      this.b = ((DailyTitleBar)getChildAt(0));
      this.a = ((DailyTitleBar)getChildAt(1));
      updateAlpha(0.0F);
      ImmersiveUtils.setStatusTextColor(false, ((Activity)getContext()).getWindow());
      this.init = true;
    }
  }
  
  private void updateAlpha(float paramFloat)
  {
    if ((this.a != null) && (this.b != null))
    {
      this.a.setAlpha(paramFloat);
      this.b.setAlpha(1.0F - paramFloat);
      if (paramFloat <= 0.0F) {
        break label58;
      }
      ImmersiveUtils.setStatusTextColor(true, ((Activity)getContext()).getWindow());
    }
    for (;;)
    {
      aVF();
      return;
      label58:
      ImmersiveUtils.setStatusTextColor(false, ((Activity)getContext()).getWindow());
    }
  }
  
  public AbsListView.e getOnScrollListener()
  {
    return this.h;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!this.init) {
      initViews();
    }
  }
  
  public void setBackgroundViewTitle(String paramString, float paramFloat)
  {
    if (!this.init) {
      initViews();
    }
    if (this.b != null)
    {
      this.b.setTitleText(paramString);
      this.b.setTitleTextSize(paramFloat);
    }
  }
  
  public void setOnLeftButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    if (!this.init) {
      initViews();
    }
    if ((this.a != null) && (this.b != null))
    {
      this.a.setOnLeftButtonClickListener(paramOnClickListener);
      this.b.setOnLeftButtonClickListener(paramOnClickListener);
    }
  }
  
  public void setOnRightButtonClickListener(View.OnClickListener paramOnClickListener)
  {
    if (!this.init) {
      initViews();
    }
    if ((this.a != null) && (this.b != null))
    {
      this.a.setOnRightButtonClickListener(paramOnClickListener);
      this.b.setOnRightButtonClickListener(paramOnClickListener);
    }
  }
  
  public void setOnTitleClickListener(View.OnClickListener paramOnClickListener)
  {
    if (!this.init) {
      initViews();
    }
    if ((this.a != null) && (this.b != null))
    {
      this.cr = paramOnClickListener;
      this.a.setOnTitleClickListener(paramOnClickListener);
      this.b.setOnTitleClickListener(paramOnClickListener);
    }
  }
  
  public void setOnTitleClickWeatherListener(View.OnClickListener paramOnClickListener)
  {
    if (!this.init) {
      initViews();
    }
    if ((this.a != null) && (this.b != null))
    {
      this.cs = paramOnClickListener;
      this.a.setOnTitleClickListener(paramOnClickListener);
      this.b.setOnTitleClickListener(paramOnClickListener);
      if (this.cs == null)
      {
        this.a.setOnTitleClickListener(this.cr);
        this.b.setOnTitleClickListener(this.cr);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.DailyTitleBarSwitcher
 * JD-Core Version:    0.7.0.1
 */