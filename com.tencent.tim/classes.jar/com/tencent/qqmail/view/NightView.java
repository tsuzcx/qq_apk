package com.tencent.qqmail.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

public class NightView
  extends View
{
  public static final String TAG = "NightView";
  private int a;
  private boolean attached;
  private int b;
  private int g;
  private int r;
  
  public NightView(Context paramContext)
  {
    super(paramContext);
  }
  
  public NightView attach(WindowManager paramWindowManager)
  {
    if (isAttached()) {
      return this;
    }
    Object localObject = paramWindowManager.getDefaultDisplay();
    Point localPoint = new Point();
    ((Display)localObject).getSize(localPoint);
    localObject = new WindowManager.LayoutParams(localPoint.x, localPoint.y + 200, 0, 0, 2005, 312, -2);
    this.attached = true;
    paramWindowManager.addView(this, (ViewGroup.LayoutParams)localObject);
    return this;
  }
  
  public NightView detach(WindowManager paramWindowManager)
  {
    try
    {
      if (isAttached()) {
        paramWindowManager.removeView(this);
      }
      this.attached = false;
      return this;
    }
    catch (Exception paramWindowManager)
    {
      for (;;)
      {
        paramWindowManager.printStackTrace();
      }
    }
  }
  
  public boolean isAttached()
  {
    return this.attached;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawARGB(this.a, this.r, this.b, this.g);
  }
  
  public NightView setAlpha(int paramInt)
  {
    this.a = paramInt;
    invalidate();
    return this;
  }
  
  public NightView setColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.r = paramInt2;
    this.b = paramInt3;
    this.g = paramInt4;
    invalidate();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.NightView
 * JD-Core Version:    0.7.0.1
 */