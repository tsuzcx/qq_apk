package com.tencent.mobileqq.multimsg.save;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;

public class FileSaveProgressView
  extends TextView
{
  private RectF af = new RectF();
  private String bRJ = "0%";
  private StringBuffer k;
  private Paint mPaint;
  private int mStrokeWidth = -1;
  private int progress;
  private int ringColor = -12680961;
  private int ringWidth = 5;
  
  public FileSaveProgressView(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public FileSaveProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    setText(this.bRJ);
    this.k = new StringBuffer(this.bRJ);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int j = getWidth();
    int m = getHeight();
    int i = paramCanvas.getSaveCount();
    paramCanvas.save();
    if (this.mStrokeWidth > 0) {}
    for (float f = this.mStrokeWidth;; f = 2.5F)
    {
      this.af.set(f, f, j - f, m - f);
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setStrokeWidth(this.ringWidth);
      this.mPaint.setColor(this.ringColor);
      j = this.progress * 360 / 100;
      paramCanvas.drawArc(this.af, 270.0F, j, false, this.mPaint);
      paramCanvas.restoreToCount(i);
      super.onDraw(paramCanvas);
      return;
    }
  }
  
  public void setProgress(int paramInt)
  {
    if (paramInt < 0) {
      this.progress = 0;
    }
    do
    {
      return;
      if (paramInt > 100)
      {
        this.progress = 100;
        return;
      }
      if (paramInt >= this.progress) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("FileSaveProgressView", 0, "progress < currentProgress, so return;");
    return;
    this.progress = paramInt;
    this.k.delete(0, this.k.length());
    this.bRJ = (paramInt + "%");
    setText(this.bRJ);
    invalidate();
  }
  
  public void setRingColor(int paramInt)
  {
    this.ringColor = paramInt;
  }
  
  public void setRingWidth(int paramInt)
  {
    this.ringWidth = paramInt;
  }
  
  public void setStrokeWidth(int paramInt)
  {
    this.mStrokeWidth = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multimsg.save.FileSaveProgressView
 * JD-Core Version:    0.7.0.1
 */