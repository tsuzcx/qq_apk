package com.tencent.av.ui.funchat.record;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import jgt;

public class QavRecordButtonView
  extends View
{
  private a a;
  private int azd = 1;
  private Bitmap bw;
  private Paint mPaint;
  private float mProgress;
  private Rect mRect;
  private RectF mRectF;
  
  public QavRecordButtonView(Context paramContext)
  {
    super(paramContext);
    initUI();
  }
  
  public QavRecordButtonView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initUI();
  }
  
  public QavRecordButtonView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initUI();
  }
  
  private Bitmap b(int paramInt)
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), paramInt);
      return localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("QavRecordButtonView", 1, "decodeBitmap oom", localOutOfMemoryError);
      return null;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("QavRecordButtonView", 1, "decodeBitmap Throwable", localThrowable);
      }
    }
  }
  
  private void initUI()
  {
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mRectF = new RectF();
    this.mRect = new Rect();
    this.bw = b(2130843083);
    super.setOnTouchListener(new jgt(this));
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    switch (this.azd)
    {
    case 1: 
    case 2: 
    default: 
      return;
    }
    if (this.bw != null)
    {
      this.mRect.set(0, 0, this.bw.getWidth(), this.bw.getHeight());
      this.mRectF.set(0.0F, 0.0F, i, j);
      paramCanvas.drawBitmap(this.bw, this.mRect, this.mRectF, this.mPaint);
    }
    float f1 = 0.08571429F * i;
    float f2 = Math.min(i, j) / 2 - f1 - 0.002857143F * i;
    this.mPaint.setStrokeWidth(f1);
    this.mRectF.set(i / 2 - f2, j / 2 - f2, i / 2 + f2, j / 2 + f2);
    f1 = this.mProgress;
    this.mPaint.setColor(-1);
    paramCanvas.drawArc(this.mRectF, 0.0F, 360.0F, false, this.mPaint);
    this.mPaint.setColor(-48606);
    paramCanvas.drawArc(this.mRectF, -90.0F, 360.0F - 360.0F * (1.0F - f1), false, this.mPaint);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
  }
  
  public int mt()
  {
    return this.azd;
  }
  
  public void setListener(a parama)
  {
    this.a = parama;
  }
  
  public void setProgress(long paramLong1, long paramLong2)
  {
    this.mProgress = Math.min(1.0F, Math.max((float)paramLong1 * 1.0F / (float)paramLong2, 0.0F));
    if (this.azd == 3) {
      invalidate();
    }
  }
  
  public void setShowState(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordButtonView", 2, "setShowState, state=" + paramInt + ", talkBack=" + paramBoolean);
    }
    if (paramInt == this.azd) {
      return;
    }
    this.azd = paramInt;
    switch (this.azd)
    {
    }
    for (;;)
    {
      invalidate();
      if (this.a == null) {
        break;
      }
      this.a.mT(this.azd);
      return;
      super.setAlpha(1.0F);
      if (paramBoolean)
      {
        super.setContentDescription("");
        continue;
        if (paramBoolean)
        {
          super.setContentDescription(getResources().getString(2131697996));
          continue;
          if (paramBoolean) {
            super.setContentDescription(getResources().getString(2131697997));
          }
          this.mProgress = 0.0F;
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void mT(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.QavRecordButtonView
 * JD-Core Version:    0.7.0.1
 */