package com.tencent.android.tpush.inappmessage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.MotionEvent;
import android.view.View;

public class e
  extends View
{
  private Paint a = new Paint();
  private Paint b = new Paint();
  private Paint c = new Paint();
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private boolean i = false;
  
  public e(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    this.a.setAntiAlias(true);
    this.a.setColor(-2236963);
    this.a.setStrokeWidth(2.0F);
    this.a.setStyle(Paint.Style.FILL_AND_STROKE);
    this.b.setAntiAlias(true);
    this.b.setColor(-6710887);
    this.b.setStrokeWidth(2.0F);
    this.b.setStyle(Paint.Style.FILL_AND_STROKE);
    this.c.setAntiAlias(true);
    this.c.setColor(-16777216);
    this.c.setStrokeWidth(3.0F);
    this.c.setStyle(Paint.Style.FILL_AND_STROKE);
    this.d = SizeUtil.dp30;
    this.e = (this.d * 0.3333333F);
    this.g = (this.d * 0.6666667F);
    this.f = (this.d * 0.3333333F);
    this.h = (this.d * 0.6666667F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.i) {}
    for (Paint localPaint = this.b;; localPaint = this.a)
    {
      paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, getWidth() / 2.0F - 1.0F, localPaint);
      paramCanvas.drawLine(this.e, this.f, this.g, this.h, this.c);
      paramCanvas.drawLine(this.g, this.f, this.e, this.h, this.c);
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt1);
    setMeasuredDimension((int)this.d, (int)this.d);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.i = true;
      invalidate();
      return true;
    }
    if (paramMotionEvent.getAction() == 1)
    {
      this.i = false;
      invalidate();
      performClick();
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean performClick()
  {
    return super.performClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.inappmessage.e
 * JD-Core Version:    0.7.0.1
 */