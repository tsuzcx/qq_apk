package com.tencent.qqmail.calendar.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public class CalColorView
  extends View
{
  private int mColor;
  private Paint mPaint = new Paint();
  private int mRingWidth = QMUIKit.dpToPx(1);
  private int mSize = QMUIKit.dpToPx(DrawBitmapUtil.CIRCLE_DIAMETER_NORMAL);
  
  public CalColorView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.mColor = paramInt;
    this.mPaint.setColor(this.mColor);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeWidth(this.mRingWidth);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    paramCanvas.drawCircle(this.mSize / 2, this.mSize / 2, this.mSize / 2 - this.mRingWidth, this.mPaint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(this.mSize, this.mSize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.view.CalColorView
 * JD-Core Version:    0.7.0.1
 */