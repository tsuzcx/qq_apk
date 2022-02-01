package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import now;

public class KandianUrlImageView
  extends ResizeURLImageView
{
  private boolean mIsRecyclerView;
  private a mVisibilityChangedListener;
  
  public KandianUrlImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public KandianUrlImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public KandianUrlImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onDetachedFromWindow()
  {
    if (!this.mIsRecyclerView) {
      super.onDetachedFromWindow();
    }
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.mVisibilityChangedListener != null) {
      this.mVisibilityChangedListener.onVisibilityChanged(paramView, paramInt);
    }
  }
  
  public void release()
  {
    if (this.mController != null) {
      this.mController.op("onKandianUrlImageView release");
    }
  }
  
  public void setIsRecyclerView(boolean paramBoolean)
  {
    this.mIsRecyclerView = paramBoolean;
  }
  
  public void setVisibilityChangedListener(a parama)
  {
    this.mVisibilityChangedListener = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onVisibilityChanged(@NonNull View paramView, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView
 * JD-Core Version:    0.7.0.1
 */