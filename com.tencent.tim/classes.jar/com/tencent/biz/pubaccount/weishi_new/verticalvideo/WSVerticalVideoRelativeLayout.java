package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class WSVerticalVideoRelativeLayout
  extends RelativeLayout
{
  private a a;
  
  public WSVerticalVideoRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public WSVerticalVideoRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.a != null) && (this.a.dispatchTouchEvent(paramMotionEvent))) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void setDispatchTouchEventListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract boolean dispatchTouchEvent(MotionEvent paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalVideoRelativeLayout
 * JD-Core Version:    0.7.0.1
 */