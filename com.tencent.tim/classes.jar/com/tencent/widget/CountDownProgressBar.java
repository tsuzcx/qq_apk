package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import autd;

public class CountDownProgressBar
  extends View
{
  private float CB;
  private float CC;
  private final int MSG_UPDATE_PROGRESS = 1;
  private a a;
  private Handler ar = new autd(this);
  private long ayY;
  private long ayZ = 1000L;
  private int edgeColor;
  private int esK;
  private int esL;
  private int esM;
  private int esN;
  private int esO;
  private final int esP = 0;
  private final int esQ = 2;
  private Paint mPaint = new Paint();
  private int progress;
  private int radio;
  private int ringColor;
  private int ringWidth;
  private int textColor;
  private int textSize;
  
  public CountDownProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CountDownProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.esK = paramContext.getResources().getColor(2131166654);
    this.esL = paramContext.getResources().getColor(2131166651);
    this.ringColor = paramContext.getResources().getColor(2131166655);
    this.textColor = paramContext.getResources().getColor(2131165571);
    this.edgeColor = paramContext.getResources().getColor(2131166652);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.textSize = ((int)(21.0F * f + 0.5F));
    this.ringWidth = ((int)(2.0F * f + 0.5F));
    this.radio = ((int)(18.0F * f + 0.5F));
    this.progress = 0;
    this.esO = Math.max(1, (int)(f * 0.5D + 0.5D));
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (getWidth() > getHeight()) {}
    for (int i = getHeight();; i = getWidth())
    {
      if (this.radio > i) {
        this.radio = i;
      }
      int j = this.radio - this.esO / 2;
      int k = j - this.ringWidth / 2;
      float f1 = i / 2;
      float f2 = i / 2;
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mPaint.setColor(this.esL);
      paramCanvas.drawCircle(f1, f2, this.radio, this.mPaint);
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setAntiAlias(true);
      this.mPaint.setStrokeWidth(this.esO);
      this.mPaint.setColor(this.edgeColor);
      paramCanvas.drawCircle(f1, f2, j, this.mPaint);
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setAntiAlias(true);
      this.mPaint.setStrokeWidth(this.ringWidth);
      this.mPaint.setColor(this.esK);
      paramCanvas.drawCircle(f1, f2, k, this.mPaint);
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mPaint.setTextSize(this.textSize);
      this.mPaint.setColor(this.textColor);
      this.mPaint.setTextAlign(Paint.Align.CENTER);
      float f3 = (this.mPaint.descent() + this.mPaint.ascent()) / 2.0F;
      paramCanvas.drawText(Integer.toString(this.esM), f1, f2 - f3, this.mPaint);
      RectF localRectF = new RectF();
      f2 = k;
      f3 = k;
      localRectF.set(f1 - f2, f1 - k, f3 + f1, k + f1);
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setColor(this.ringColor);
      paramCanvas.drawArc(localRectF, 270.0F, this.progress, false, this.mPaint);
      return;
    }
  }
  
  public void setOnCountDownLinstener(a parama)
  {
    this.a = parama;
  }
  
  public void setTotalMills(long paramLong)
  {
    this.ayY = paramLong;
    this.ayZ = 1000L;
    this.esM = ((int)(this.ayY / 1000L));
  }
  
  public void setTotalMills(long paramLong, int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 1;
    }
    this.ayY = paramLong;
    this.esM = i;
    this.ayZ = (paramLong / i);
  }
  
  public void start()
  {
    this.ar.removeMessages(2);
    this.ar.removeMessages(1);
    this.progress = 0;
    this.esN = 0;
    this.CB = 0.0F;
    this.CC = 0.0F;
    this.ayZ = 1000L;
    if (this.ayY > 0L)
    {
      this.CB = 0.0F;
      this.esN = 100;
      this.ar.sendEmptyMessage(0);
    }
  }
  
  public static abstract interface a
  {
    public abstract void cYs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.CountDownProgressBar
 * JD-Core Version:    0.7.0.1
 */