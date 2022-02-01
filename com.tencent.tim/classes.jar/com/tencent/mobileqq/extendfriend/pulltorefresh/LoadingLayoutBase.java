package com.tencent.mobileqq.extendfriend.pulltorefresh;

import afxf;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public abstract class LoadingLayoutBase
  extends FrameLayout
  implements afxf
{
  public LoadingLayoutBase(Context paramContext)
  {
    super(paramContext);
  }
  
  public LoadingLayoutBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LoadingLayoutBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract int DL();
  
  public abstract void ajO();
  
  public abstract void akJ();
  
  public abstract void dbw();
  
  public abstract void onPull(float paramFloat);
  
  public abstract void pullToRefresh();
  
  public final void setHeight(int paramInt)
  {
    getLayoutParams().height = paramInt;
    requestLayout();
  }
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence) {}
  
  public void setLoadingDrawable(Drawable paramDrawable) {}
  
  public void setRefreshResultLabel(CharSequence paramCharSequence) {}
  
  public void setTextTypeface(Typeface paramTypeface) {}
  
  public final void setWidth(int paramInt)
  {
    getLayoutParams().width = paramInt;
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.pulltorefresh.LoadingLayoutBase
 * JD-Core Version:    0.7.0.1
 */