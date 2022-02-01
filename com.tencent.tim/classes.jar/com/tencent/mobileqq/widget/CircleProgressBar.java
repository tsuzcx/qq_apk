package com.tencent.mobileqq.widget;

import acfp;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.os.Handler;
import android.os.Message;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import atau.a;

public class CircleProgressBar
  extends View
{
  public float AP;
  public float AQ;
  public float AR;
  public float AS;
  public float AT;
  public float AU;
  public float AV;
  public float AW;
  public float AX;
  public float AY;
  public float AZ;
  public float Ba;
  public float Bb;
  public float Bc;
  public float Bd;
  public float Be;
  a a = new a();
  public long avu;
  public long avv;
  public long avw;
  public String cAj = "10";
  public int efj;
  public int efk;
  public int efl;
  public int efm;
  public int efn;
  public int efo = -90;
  public int efp = this.efo;
  public boolean isFinish;
  public boolean isStart;
  public int mCenterX;
  public int mCenterY;
  public long mFileSize;
  public Paint mPaint = new Paint();
  public int mProgressColor;
  public float mRadius;
  public int mTextColor;
  public TextPaint mTextPaint = new TextPaint();
  public float mTextSize;
  public RectF w = new RectF();
  
  public CircleProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.pT);
    this.efj = paramContext.getColor(13, Color.parseColor("#999999"));
    this.mProgressColor = paramContext.getColor(10, Color.parseColor("#12b7f5"));
    this.mTextColor = paramContext.getColor(7, Color.parseColor("#000000"));
    this.mTextSize = paramContext.getDimension(8, 25.0F);
    this.AP = paramContext.getDimension(3, 200.0F);
    this.AQ = paramContext.getDimension(6, 250.0F);
    this.AR = paramContext.getInteger(9, 60);
    this.AS = paramContext.getDimension(14, 40.0F);
    this.AT = paramContext.getDimension(12, 200.0F);
    this.AU = paramContext.getDimension(2, 200.0F);
    this.AV = paramContext.getDimension(5, 200.0F);
    this.efk = paramContext.getColor(11, Color.parseColor("#999999"));
    this.efl = paramContext.getColor(1, Color.parseColor("#999999"));
    this.efm = paramContext.getColor(4, Color.parseColor("#999999"));
    this.efn = paramContext.getColor(0, Color.parseColor("#999999"));
    paramContext.recycle();
    this.AW = ((this.AQ - this.AP) / 2.0F);
    this.mRadius = (this.AP / 2.0F + this.AW / 2.0F);
    this.AX = ((this.AT - this.AP) / 2.0F);
    this.AY = ((this.AU - this.AP) / 2.0F);
    this.AZ = ((this.AV - this.AP) / 2.0F);
    this.Ba = this.AW;
    this.Bb = (this.AP / 2.0F + this.AX / 2.0F);
    this.Bc = (this.AP / 2.0F + this.AY / 2.0F);
    this.Bd = (this.AP / 2.0F + this.AZ / 2.0F);
  }
  
  private double a(float paramFloat)
  {
    return paramFloat / 360.0F * 2.0F * 3.141592653589793D;
  }
  
  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.mCenterX = (getWidth() / 2);
    this.mCenterY = (getHeight() / 2);
    float f5;
    float f6;
    if (!this.isFinish)
    {
      this.mPaint.setColor(this.efj);
      this.mPaint.setStyle(Paint.Style.STROKE);
      this.mPaint.setStrokeWidth(this.AW);
      this.mPaint.setAntiAlias(true);
      paramCanvas.drawCircle(this.mCenterX, this.mCenterY, this.mRadius, this.mPaint);
      if (this.isStart)
      {
        this.w.left = (this.mCenterX - this.mRadius);
        this.w.top = (this.mCenterY - this.mRadius);
        this.w.right = (this.mCenterX + this.mRadius);
        this.w.bottom = (this.mCenterY + this.mRadius);
        localObject = new LinearGradient((float)(this.mCenterX + this.mRadius * Math.sin(a(this.efp + 90))), (float)(this.mCenterY - this.mRadius * Math.cos(a(this.efp + 90))), (float)(this.mCenterX + this.mRadius * Math.sin(a(this.efp + 90 + this.AR))), (float)(this.mCenterY - this.mRadius * Math.cos(a(this.efp + 90 + this.AR))), this.efj, this.mProgressColor, Shader.TileMode.MIRROR);
        this.mPaint.setShader((Shader)localObject);
        paramCanvas.drawArc(this.w, this.efp, this.AR, false, this.mPaint);
        this.mPaint.setShader(null);
      }
      this.mTextPaint.setColor(this.mTextColor);
      this.mTextPaint.setAntiAlias(true);
      this.mTextPaint.setTextSize(this.mTextSize);
      f4 = this.mCenterX;
      f5 = this.mTextPaint.measureText(this.cAj);
      f6 = this.AS;
      f3 = this.mCenterY - (this.mTextPaint.descent() + this.mTextPaint.ascent()) / 2.0F;
      f1 = this.mCenterY;
      f2 = (this.mTextPaint.descent() + this.mTextPaint.ascent()) / 2.0F;
      paramCanvas.drawText(this.cAj, f4 - f5 + f6, f3, this.mTextPaint);
      this.mTextPaint.setTextSize(this.mTextSize / 2.0F);
      f4 = this.mCenterX + this.AS;
      paramCanvas.drawText("%", f4, f3, this.mTextPaint);
      this.mTextPaint.setTextSize(this.mTextSize / 4.0F);
      f3 = this.mTextPaint.descent();
      f5 = this.mTextPaint.ascent();
      paramCanvas.drawText(acfp.m(2131703936), f4, f1 + f2 - (f3 + f5), this.mTextPaint);
      this.mPaint.reset();
      return;
    }
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setColor(this.efn);
    this.mPaint.setStrokeWidth(this.Ba);
    paramCanvas.drawCircle(this.mCenterX, this.mCenterY, this.mRadius, this.mPaint);
    float f4 = (float)(this.avu + this.mFileSize + this.avv + this.avw);
    float f2 = 360.0F * (float)this.avu / f4;
    float f1 = f2;
    if (f2 > 0.0F)
    {
      f1 = f2;
      if (f2 < this.Be) {
        f1 = this.Be;
      }
    }
    Object localObject = new RectF();
    ((RectF)localObject).left = (this.mCenterX - this.Bb);
    ((RectF)localObject).top = (this.mCenterY - this.Bb);
    ((RectF)localObject).right = (this.mCenterX + this.Bb);
    ((RectF)localObject).bottom = (this.mCenterY + this.Bb);
    this.mPaint.setColor(this.efk);
    this.mPaint.setStrokeWidth(this.AX);
    paramCanvas.drawArc((RectF)localObject, -90.0F, f1, false, this.mPaint);
    float f3 = 360.0F * (float)this.mFileSize / f4;
    f2 = f3;
    if (f3 > 0.0F)
    {
      f2 = f3;
      if (f3 < this.Be) {
        f2 = this.Be;
      }
    }
    ((RectF)localObject).left = (this.mCenterX - this.Bc);
    ((RectF)localObject).top = (this.mCenterY - this.Bc);
    ((RectF)localObject).right = (this.mCenterX + this.Bc);
    ((RectF)localObject).bottom = (this.mCenterY + this.Bc);
    this.mPaint.setColor(this.efl);
    this.mPaint.setStrokeWidth(this.AY);
    paramCanvas.drawArc((RectF)localObject, -90.0F + f1, f2, false, this.mPaint);
    f3 = 360.0F * (float)this.avv / f4;
    if ((f3 > 0.0F) && (f3 < this.Be)) {
      f3 = this.Be;
    }
    for (;;)
    {
      ((RectF)localObject).left = (this.mCenterX - this.Bd);
      ((RectF)localObject).top = (this.mCenterY - this.Bd);
      ((RectF)localObject).right = (this.mCenterX + this.Bd);
      ((RectF)localObject).bottom = (this.mCenterY + this.Bd);
      this.mPaint.setColor(this.efm);
      this.mPaint.setStrokeWidth(this.AZ);
      paramCanvas.drawArc((RectF)localObject, -90.0F + f1 + f2, f3, false, this.mPaint);
      this.mTextPaint.setColor(this.mTextColor);
      this.mTextPaint.setAntiAlias(true);
      this.mTextPaint.setTextSize(this.mTextSize);
      localObject = "" + (this.avu + this.mFileSize + this.avv) * 100L / (this.avu + this.mFileSize + this.avv + this.avw);
      f4 = this.mCenterX;
      f5 = this.mTextPaint.measureText((String)localObject);
      f6 = this.AS;
      f3 = this.mCenterY - (this.mTextPaint.descent() + this.mTextPaint.ascent()) / 2.0F;
      f1 = this.mCenterY;
      f2 = (this.mTextPaint.descent() + this.mTextPaint.ascent()) / 2.0F;
      paramCanvas.drawText((String)localObject, f4 - f5 + f6, f3, this.mTextPaint);
      this.mTextPaint.setTextSize(this.mTextSize / 2.0F);
      f4 = this.mCenterX + this.AS;
      paramCanvas.drawText("%", f4, f3, this.mTextPaint);
      this.mTextPaint.setTextSize(this.mTextSize / 4.0F);
      f3 = this.mTextPaint.descent();
      f5 = this.mTextPaint.ascent();
      paramCanvas.drawText(acfp.m(2131703937), f4, f1 + f2 - (f3 + f5), this.mTextPaint);
      break;
    }
  }
  
  public void setFinish(long paramLong1, long paramLong2, long paramLong3, long paramLong4, float paramFloat)
  {
    this.avu = paramLong1;
    this.mFileSize = paramLong2;
    this.avv = paramLong3;
    this.avw = paramLong4;
    this.Be = paramFloat;
    stop();
    this.isFinish = true;
    postInvalidate();
  }
  
  public void setPercent(int paramInt)
  {
    if (paramInt < 100) {
      this.cAj = ("" + paramInt);
    }
    for (;;)
    {
      postInvalidate();
      return;
      this.cAj = "100";
      stop();
    }
  }
  
  public void start()
  {
    this.isStart = true;
    this.isFinish = false;
    postInvalidate();
    this.a.sendEmptyMessageDelayed(10000, 50L);
  }
  
  public void stop()
  {
    this.isStart = false;
    this.a.removeMessages(10000);
    postInvalidate();
  }
  
  class a
    extends Handler
  {
    a() {}
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        return;
        paramMessage = CircleProgressBar.this;
        paramMessage.efp += 3;
        CircleProgressBar.this.postInvalidate();
      } while (!CircleProgressBar.this.isStart);
      sendEmptyMessageDelayed(10000, 50L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CircleProgressBar
 * JD-Core Version:    0.7.0.1
 */