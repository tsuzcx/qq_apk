package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;

public class FloatView
  extends ImageView
{
  private GestureDetector.OnGestureListener b;
  private WindowManager.LayoutParams h;
  private GestureDetector mGestureDetector;
  private float mTouchX;
  private float mTouchY;
  private WindowManager windowManager;
  private float x;
  private float y;
  
  public FloatView(Context paramContext)
  {
    super(paramContext);
    this.windowManager = ((WindowManager)paramContext.getApplicationContext().getSystemService("window"));
    this.h = new WindowManager.LayoutParams();
  }
  
  private void ecc()
  {
    this.h.x = ((int)(this.x - this.mTouchX));
    this.h.y = ((int)(this.y - this.mTouchY));
    this.windowManager.updateViewLayout(this, this.h);
  }
  
  public void destroy()
  {
    if (this.windowManager != null) {
      this.windowManager.removeView(this);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Rect localRect = new Rect();
    getWindowVisibleDisplayFrame(localRect);
    int i = localRect.top;
    this.x = paramMotionEvent.getRawX();
    this.y = (paramMotionEvent.getRawY() - i);
    switch (paramMotionEvent.getAction())
    {
    }
    while (this.mGestureDetector == null)
    {
      return true;
      this.mTouchX = paramMotionEvent.getX();
      this.mTouchY = paramMotionEvent.getY();
      continue;
      ecc();
      continue;
      ecc();
      this.mTouchY = 0.0F;
      this.mTouchX = 0.0F;
    }
    return this.mGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnGestureListener(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this.b = paramOnGestureListener;
    this.mGestureDetector = new GestureDetector(paramContext, paramOnGestureListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.FloatView
 * JD-Core Version:    0.7.0.1
 */