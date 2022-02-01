package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class CircleProgressView
  extends View
{
  private RectF H;
  private int arq;
  private Handler bT = new Handler();
  private int cQI;
  private int cQJ;
  private boolean cZG;
  private Paint ct;
  private int efq = 40;
  private int efr = 3;
  private int efs = 4;
  private boolean fU = true;
  private boolean mIsSend = true;
  private Paint mPaint;
  private int mProgress;
  private int mStrokeWidth = 10;
  
  public CircleProgressView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public CircleProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mStrokeWidth = ((int)(getResources().getDisplayMetrics().density * 3.0F + 0.5F));
    this.efs = ((int)(getResources().getDisplayMetrics().density * 2.0F + 0.5F));
    this.mPaint = new Paint();
    this.mPaint.setColor(-15550475);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeWidth(this.mStrokeWidth);
    this.mPaint.setFlags(1);
    this.H = new RectF();
    this.ct = new Paint();
    this.ct.setColor(-1);
    this.ct.setStyle(Paint.Style.STROKE);
    this.ct.setStrokeWidth(this.mStrokeWidth);
    this.ct.setFlags(1);
    setBackgroundColor(0);
  }
  
  private int kv(int paramInt)
  {
    return (int)(paramInt / 100.0F * 360.0F);
  }
  
  public void ehM()
  {
    if (QLog.isColorLevel()) {
      QLog.e("CircleProgressView", 2, "dismissLoading() mIndeterminate = " + this.fU);
    }
    if (!this.fU)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CircleProgressView", 2, "dismissLoading() mIndeterminate = false, just return");
      }
      return;
    }
    setVisibility(4);
    this.bT.removeCallbacksAndMessages(null);
    this.cZG = false;
    this.arq = 0;
    this.mProgress = 0;
  }
  
  public void hide()
  {
    if (QLog.isColorLevel()) {
      QLog.e("CircleProgressView", 2, "hide() mIndeterminate = " + this.fU);
    }
    setVisibility(4);
    if (this.fU)
    {
      ehM();
      return;
    }
    this.mProgress = 0;
    this.arq = 0;
    this.cZG = false;
  }
  
  public boolean isShowing()
  {
    return getVisibility() == 0;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if (!this.fU)
    {
      paramCanvas.save();
      if (this.mIsSend)
      {
        paramCanvas.rotate(-36.0F, this.cQI / 2, this.cQJ / 2);
        paramCanvas.drawArc(this.H, 0.0F, this.arq, false, this.mPaint);
      }
      for (;;)
      {
        paramCanvas.restore();
        return;
        paramCanvas.rotate(222.0F, this.cQI / 2, this.cQJ / 2);
        paramCanvas.drawArc(this.H, 0.0F, this.arq, false, this.mPaint);
      }
    }
    paramCanvas.save();
    paramCanvas.rotate(this.arq, this.cQI / 2, this.cQJ / 2);
    paramCanvas.drawArc(this.H, 0.0F, this.efq, false, this.ct);
    paramCanvas.restore();
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.cQI = paramInt1;
    this.cQJ = paramInt2;
    this.mStrokeWidth -= this.efs;
    this.H.set(this.mStrokeWidth, this.mStrokeWidth, this.cQI - this.mStrokeWidth, this.cQJ - this.mStrokeWidth);
  }
  
  public void setIndeterminate(boolean paramBoolean)
  {
    if (this.fU != paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CircleProgressView", 2, "setIndeterminate() change mIndeterminate = " + this.fU);
      }
      this.fU = paramBoolean;
    }
  }
  
  public void setIndeterminate(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.fU != paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CircleProgressView", 2, "setIndeterminate() change mIndeterminate = " + this.fU);
      }
      this.fU = paramBoolean;
    }
    this.efq = paramInt1;
    this.efr = paramInt2;
  }
  
  public void setIsSend(boolean paramBoolean)
  {
    this.mIsSend = paramBoolean;
  }
  
  public void setProgress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("CircleProgressView", 2, "setProgress() progress = " + paramInt);
    }
    if ((paramInt < 0) || (paramInt > 100)) {}
    do
    {
      return;
      if (!this.fU) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("CircleProgressView", 2, "setProgress() mIndeterminate = true, just return");
    return;
    if (!isShowing()) {
      setVisibility(0);
    }
    if (this.cZG) {
      this.bT.removeCallbacksAndMessages(null);
    }
    int i = paramInt;
    if (paramInt <= 2) {
      i = 2;
    }
    this.mProgress = i;
    this.arq = kv(this.mProgress);
    invalidate();
  }
  
  public void showLoading()
  {
    if (QLog.isColorLevel()) {
      QLog.e("CircleProgressView", 2, "showLoading() mIndeterminate = " + this.fU + ",mAnimationRuning = " + this.cZG);
    }
    if ((!this.fU) || (this.cZG))
    {
      if (QLog.isColorLevel()) {
        QLog.e("CircleProgressView", 2, "showLoading()  just return");
      }
      return;
    }
    setVisibility(0);
    this.bT.removeCallbacksAndMessages(null);
    this.cZG = true;
    this.arq = 0;
    this.mProgress = 0;
    this.bT.post(new Animator(null));
  }
  
  class Animator
    implements Runnable
  {
    private Animator() {}
    
    public void run()
    {
      if (CircleProgressView.a(CircleProgressView.this)) {
        CircleProgressView.a(CircleProgressView.this, CircleProgressView.a(CircleProgressView.this) + CircleProgressView.b(CircleProgressView.this));
      }
      for (;;)
      {
        CircleProgressView.a(CircleProgressView.this, CircleProgressView.a(CircleProgressView.this) % 360);
        CircleProgressView.a(CircleProgressView.this).postDelayed(this, 16L);
        CircleProgressView.this.invalidate();
        return;
        CircleProgressView.a(CircleProgressView.this, CircleProgressView.a(CircleProgressView.this) + 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CircleProgressView
 * JD-Core Version:    0.7.0.1
 */