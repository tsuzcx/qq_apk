package com.tencent.mobileqq.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class InputMethodLinearLayout
  extends LinearLayout
{
  protected a a;
  private int egw;
  private int egx;
  private boolean isOpen;
  private int screenHeight;
  private int screenWidth;
  
  public InputMethodLinearLayout(Context paramContext)
  {
    super(paramContext);
    paramContext = ((Activity)paramContext).getWindowManager().getDefaultDisplay();
    this.screenWidth = paramContext.getWidth();
    this.screenHeight = paramContext.getHeight();
  }
  
  public InputMethodLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = ((Activity)paramContext).getWindowManager().getDefaultDisplay();
    this.screenWidth = paramContext.getWidth();
    this.screenHeight = paramContext.getHeight();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    this.egw = paramInt1;
    this.egx = paramInt2;
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.a != null) && (paramInt1 == paramInt3) && (paramInt3 != 0) && (paramInt4 != 0)) {
      if ((paramInt2 >= paramInt4) || (Math.abs(paramInt2 - paramInt4) <= this.screenHeight * 1 / 4)) {
        break label90;
      }
    }
    for (this.isOpen = true;; this.isOpen = false)
    {
      this.a.uV(this.isOpen);
      measure(this.egw - paramInt1 + getWidth(), this.egx - paramInt2 + getHeight());
      label90:
      do
      {
        return;
      } while ((paramInt2 <= paramInt4) || (Math.abs(paramInt2 - paramInt4) <= this.screenHeight * 1 / 4));
    }
  }
  
  public void setOnSizeChangedListenner(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void uV(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.InputMethodLinearLayout
 * JD-Core Version:    0.7.0.1
 */