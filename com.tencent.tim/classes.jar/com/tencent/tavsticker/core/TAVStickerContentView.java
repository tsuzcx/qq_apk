package com.tencent.tavsticker.core;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class TAVStickerContentView
  extends FrameLayout
{
  private static final String TAG = TAVStickerContentView.class.getSimpleName();
  private DispatchTouchEventListener mDispatchTouchEventListener = null;
  private TAVStickerEditView mStickerEditView = null;
  
  public TAVStickerContentView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TAVStickerContentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TAVStickerContentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void addView(View paramView)
  {
    super.addView(paramView);
    if ((paramView instanceof TAVStickerEditView)) {
      this.mStickerEditView = ((TAVStickerEditView)paramView);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mDispatchTouchEventListener != null) {
      return this.mDispatchTouchEventListener.onDispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.mStickerEditView != null) && (this.mStickerEditView.isNeedInitLocation())) {
      this.mStickerEditView.initLocation(getMeasuredWidth(), getMeasuredHeight());
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  void setDispatchTouchEventListener(DispatchTouchEventListener paramDispatchTouchEventListener)
  {
    this.mDispatchTouchEventListener = paramDispatchTouchEventListener;
  }
  
  public void setLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super.setLayoutParams(paramLayoutParams);
    if (this.mStickerEditView != null) {
      this.mStickerEditView.needInitLocation();
    }
  }
  
  static abstract interface DispatchTouchEventListener
  {
    public abstract boolean onDispatchTouchEvent(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerContentView
 * JD-Core Version:    0.7.0.1
 */