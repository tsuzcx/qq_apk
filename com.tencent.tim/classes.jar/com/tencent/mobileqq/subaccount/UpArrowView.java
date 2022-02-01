package com.tencent.mobileqq.subaccount;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class UpArrowView
  extends View
{
  int dNi;
  Paint paint = new Paint();
  int solidColor;
  
  public UpArrowView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public UpArrowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public UpArrowView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public void init()
  {
    this.solidColor = Color.argb(255, 255, 255, 255);
    this.dNi = Color.argb(255, 241, 242, 249);
    setDuplicateParentStateEnabled(true);
    int i = getResources().getColor(2131167363);
    if (this.solidColor != i) {
      this.solidColor = i;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((isSelected()) || (isPressed())) {
      this.paint.setColor(this.dNi);
    }
    for (;;)
    {
      this.paint.setAntiAlias(true);
      int i = getWidth();
      int j = getHeight();
      Path localPath = new Path();
      localPath.moveTo(0.0F, j);
      localPath.lineTo(i / 2, 0.0F);
      localPath.lineTo(i, j);
      localPath.close();
      paramCanvas.drawPath(localPath, this.paint);
      return;
      this.paint.setColor(this.solidColor);
    }
  }
  
  public void setPressed(boolean paramBoolean)
  {
    super.setPressed(paramBoolean);
    invalidate();
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    invalidate();
  }
  
  public void setTheme(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.solidColor = Color.argb(255, 0, 0, 0);
      this.dNi = Color.argb(255, 31, 31, 31);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.UpArrowView
 * JD-Core Version:    0.7.0.1
 */