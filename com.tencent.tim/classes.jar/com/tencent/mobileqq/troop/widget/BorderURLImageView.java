package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.image.URLImageView;

public class BorderURLImageView
  extends URLImageView
{
  protected int color = -1;
  protected Paint paint = new Paint();
  protected Rect rect = new Rect();
  protected int width;
  
  public BorderURLImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BorderURLImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BorderURLImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.width <= 0) {
      return;
    }
    paramCanvas.getClipBounds(this.rect);
    this.paint.setColor(this.color);
    this.paint.setStyle(Paint.Style.STROKE);
    this.paint.setStrokeWidth(this.width);
    paramCanvas.drawRect(this.rect, this.paint);
  }
  
  public void setBorderColor(int paramInt)
  {
    this.color = paramInt;
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.width = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.BorderURLImageView
 * JD-Core Version:    0.7.0.1
 */