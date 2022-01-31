package com.tencent.mobileqq.trick;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

public class FrontWindow
  extends View
{
  private boolean a = false;
  
  public FrontWindow(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.a) {
      TrickHelper.a().a(true);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setListening(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.trick.FrontWindow
 * JD-Core Version:    0.7.0.1
 */