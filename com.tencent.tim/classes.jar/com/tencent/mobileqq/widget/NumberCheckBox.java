package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.widget.CheckBox;

public class NumberCheckBox
  extends CheckBox
{
  private Paint cy = new Paint();
  private boolean das;
  private int mNumber = -1;
  
  public NumberCheckBox(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public NumberCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NumberCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.cy.setColor(paramContext.getResources().getColor(2131167665));
    this.cy.setStyle(Paint.Style.FILL);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.das) {
      paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, Math.min(getWidth() / 2.0F, getHeight() / 2.0F), this.cy);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    super.setChecked(paramBoolean);
    String str2 = "";
    String str1 = str2;
    if (paramBoolean)
    {
      str1 = str2;
      if (this.mNumber >= 0) {
        str1 = String.valueOf(this.mNumber);
      }
    }
    if (!str1.equals(getText())) {
      setText(str1);
    }
  }
  
  public void setCheckedNumber(int paramInt)
  {
    if (this.mNumber != paramInt)
    {
      this.mNumber = paramInt;
      setText(String.valueOf(paramInt));
    }
    setChecked(true);
  }
  
  public void setForegroundColor(int paramInt)
  {
    this.cy.setColor(paramInt);
  }
  
  public void setNeedForeground(boolean paramBoolean)
  {
    this.das = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NumberCheckBox
 * JD-Core Version:    0.7.0.1
 */