package com.tencent.gdtad.views.videoceiling;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;
import tkw;

public class GdtVideoCeilingScrollVIew
  extends ScrollView
{
  public GdtVideoCeilingScrollVIew(Context paramContext)
  {
    super(paramContext);
  }
  
  public GdtVideoCeilingScrollVIew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public GdtVideoCeilingScrollVIew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    tkw.i("GdtVideoCeilingScrollVIew", "dispatchTouchEvent");
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    tkw.i("GdtVideoCeilingScrollVIew", "onInterceptTouchEvent");
    return false;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    tkw.i("GdtVideoCeilingScrollVIew", "onScrollChanged: t -> " + paramInt2 + ", oldt -> " + paramInt4 + ", l -> " + paramInt1 + ", oldl -> " + paramInt3);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    tkw.i("GdtVideoCeilingScrollVIew", "onTouchEvent");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtVideoCeilingScrollVIew
 * JD-Core Version:    0.7.0.1
 */