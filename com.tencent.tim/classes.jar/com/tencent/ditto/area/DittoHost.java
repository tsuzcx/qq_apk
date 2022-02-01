package com.tencent.ditto.area;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import java.util.List;

public abstract interface DittoHost
{
  public abstract View getContainerView();
  
  public abstract Context getContext();
  
  public abstract Object getCurrentViewModel();
  
  public abstract int getPaddingBottom();
  
  public abstract int getPaddingLeft();
  
  public abstract int getPaddingRight();
  
  public abstract int getPaddingTop();
  
  public abstract void handleSilentRequest(String paramString1, String paramString2, int paramInt, DittoArea paramDittoArea, MotionEvent paramMotionEvent);
  
  public abstract void handleSilentUri(String paramString, DittoArea paramDittoArea, MotionEvent paramMotionEvent);
  
  public abstract void handleUri(String paramString, DittoArea paramDittoArea, MotionEvent paramMotionEvent);
  
  public abstract void invalidate();
  
  public abstract void invalidate(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void invokeAreaClick(String paramString, MotionEvent paramMotionEvent);
  
  public abstract void onContentDescriptionChanged(DittoArea paramDittoArea);
  
  public abstract void postInvalidate();
  
  public abstract void postInvalidateDelayed(long paramLong);
  
  public abstract void removeAccessibilityArea(List<DittoArea> paramList);
  
  public abstract void requestLayout();
  
  public abstract void storageViewModel(boolean paramBoolean);
  
  public abstract void turnOffHardwareAcceleration();
  
  public static abstract interface SilentRequestCallback
  {
    public abstract void onResponse(Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.ditto.area.DittoHost
 * JD-Core Version:    0.7.0.1
 */