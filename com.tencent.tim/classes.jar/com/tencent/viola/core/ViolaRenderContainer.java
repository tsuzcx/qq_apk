package com.tencent.viola.core;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.viola.utils.ViolaLogUtils;
import java.lang.ref.WeakReference;

public class ViolaRenderContainer
  extends FrameLayout
{
  private boolean mPageHasEvent = false;
  private WeakReference<ViolaInstance> mViolaInstance;
  
  public ViolaRenderContainer(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public ViolaRenderContainer(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ViolaRenderContainer(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    this.mPageHasEvent = true;
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void initLogView(Context paramContext)
  {
    ViolaLogUtils.initLogView(paramContext, this);
  }
  
  public boolean isPageHasEvent()
  {
    return this.mPageHasEvent;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.mViolaInstance != null)
    {
      ViolaInstance localViolaInstance = (ViolaInstance)this.mViolaInstance.get();
      if (localViolaInstance != null) {
        localViolaInstance.setSize(paramInt1, paramInt2);
      }
    }
  }
  
  public void setViolaInstance(ViolaInstance paramViolaInstance)
  {
    this.mViolaInstance = new WeakReference(paramViolaInstance);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.core.ViolaRenderContainer
 * JD-Core Version:    0.7.0.1
 */