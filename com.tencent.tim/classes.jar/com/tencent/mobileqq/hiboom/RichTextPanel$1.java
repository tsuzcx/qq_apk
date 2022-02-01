package com.tencent.mobileqq.hiboom;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.RelativeLayout;

class RichTextPanel$1
  extends RelativeLayout
{
  RichTextPanel$1(RichTextPanel paramRichTextPanel, Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (getParent() != null)) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.RichTextPanel.1
 * JD-Core Version:    0.7.0.1
 */