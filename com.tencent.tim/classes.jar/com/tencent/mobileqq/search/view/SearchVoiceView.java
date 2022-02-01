package com.tencent.mobileqq.search.view;

import amzl;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import atau.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;

public class SearchVoiceView
  extends View
{
  public static int dEg;
  public static int dEh;
  private Path O;
  private Path P;
  private a a;
  private RectF aR = new RectF();
  private RectF aS = new RectF();
  private long akp;
  private PorterDuffXfermode jdField_b_of_type_AndroidGraphicsPorterDuffXfermode;
  private SweepGradient jdField_b_of_type_AndroidGraphicsSweepGradient;
  private Paint cn;
  private Paint co;
  private int dEA = -15559179;
  private int dEB = -1610638853;
  private int dEC = -11993345;
  private int dED = 30;
  private int dEE = 200;
  private int dEF;
  private int dEG;
  public final int dEf = 140;
  private int dEi = 2098045951;
  private int dEj = 2097217526;
  public int dEk;
  public int dEl;
  private int dEm;
  private int dEn;
  private int dEo;
  private int dEp;
  private int dEq;
  private int dEr;
  private int dEs;
  private int dEt;
  private int dEu;
  private int dEv;
  private int dEw;
  private int dEx = 2;
  private int dEy = 255;
  private int dEz = -11021825;
  private Drawable fy;
  private Bitmap gj;
  private int height;
  private float mDensity;
  private Handler mHandler = new Handler(new amzl(this));
  private Paint mPaint;
  private int mState = 0;
  private int mStrokeWidth = 6;
  private Paint mTempPaint;
  private int width;
  private float zA;
  private float zB = 5.0F;
  private float zC = 2.0F;
  private float zD;
  private float zE;
  private float zv;
  private float zw;
  private float zx;
  private float zy;
  private float zz;
  
  public SearchVoiceView(Context paramContext)
  {
    super(paramContext, null);
  }
  
  public SearchVoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.rY);
    this.fy = paramAttributeSet.getDrawable(1);
    int i = TypedValue.complexToDimensionPixelSize(140, paramContext.getResources().getDisplayMetrics());
    this.width = paramAttributeSet.getDimensionPixelSize(2, i);
    this.height = paramAttributeSet.getDimensionPixelSize(0, i);
    paramAttributeSet.recycle();
    init();
  }
  
  private void R(Canvas paramCanvas)
  {
    dOH();
    dOI();
    paramCanvas.drawPath(this.P, this.co);
    paramCanvas.drawPath(this.O, this.cn);
  }
  
  private void b(Canvas paramCanvas, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mPaint.setAlpha(this.dEy);
    }
    paramCanvas.drawBitmap(this.gj, this.dEF, this.dEG, this.mPaint);
    this.mPaint.setAlpha(255);
  }
  
  @TargetApi(21)
  private void bg(Canvas paramCanvas)
  {
    int i = paramCanvas.saveLayer(this.aS, this.mPaint);
    paramCanvas.drawColor(-1);
    this.mTempPaint.setColor(this.dEA);
    this.mTempPaint.setStyle(Paint.Style.STROKE);
    this.mTempPaint.setStrokeWidth(this.mStrokeWidth);
    this.mTempPaint.setShader(this.jdField_b_of_type_AndroidGraphicsSweepGradient);
    paramCanvas.drawCircle(this.width / 2, this.width / 2, this.width / 2 - this.mStrokeWidth, this.mTempPaint);
    this.mTempPaint.setShader(null);
    this.mTempPaint.setColor(0);
    this.mTempPaint.setStyle(Paint.Style.FILL);
    this.mTempPaint.setXfermode(this.jdField_b_of_type_AndroidGraphicsPorterDuffXfermode);
    paramCanvas.drawCircle(this.width / 2, this.width / 2, this.width / 2 - this.mStrokeWidth * 3 / 2, this.mTempPaint);
    this.mTempPaint.setXfermode(null);
    paramCanvas.restoreToCount(i);
  }
  
  @TargetApi(21)
  private void bh(Canvas paramCanvas)
  {
    int i = paramCanvas.saveLayer(this.aS, this.mPaint);
    paramCanvas.drawColor(-1);
    this.mTempPaint.setColor(this.dEA);
    this.mTempPaint.setStyle(Paint.Style.STROKE);
    this.mTempPaint.setAntiAlias(true);
    this.mTempPaint.setStrokeWidth(this.mStrokeWidth);
    paramCanvas.drawArc(this.aR, this.zv, this.zy, false, this.mTempPaint);
    this.mTempPaint.setColor(this.dEB);
    if (this.zz >= 0.0F) {
      paramCanvas.drawArc(this.aR, this.zw, this.zz, false, this.mTempPaint);
    }
    this.mTempPaint.setColor(this.dEC);
    if (this.zA >= 0.0F) {
      paramCanvas.drawArc(this.aR, this.zx, this.zA, false, this.mTempPaint);
    }
    this.mTempPaint.setColor(0);
    this.mTempPaint.setStyle(Paint.Style.FILL);
    this.mTempPaint.setXfermode(this.jdField_b_of_type_AndroidGraphicsPorterDuffXfermode);
    paramCanvas.drawCircle(this.width / 2, this.width / 2, this.width / 2 - this.mStrokeWidth * 3 / 2 + 2, this.mTempPaint);
    this.mTempPaint.setXfermode(null);
    paramCanvas.restoreToCount(i);
  }
  
  private void dOH()
  {
    this.O.reset();
    this.O.moveTo(this.dEm, this.dEl);
    this.O.quadTo(this.dEm + this.dEo, this.dEl - this.dEk * 2, this.dEm + this.dEp, this.dEl);
    this.O.quadTo(this.dEm + this.dEq, this.dEl + this.dEk * 2, this.dEm + this.width, this.dEl);
    this.O.quadTo(this.dEm + this.dEr, this.dEl - this.dEk * 2, this.dEm + this.dEs, this.dEl);
    this.O.quadTo(this.dEm + this.dEt, this.dEl + this.dEk * 2, this.dEm + this.dEu, this.dEl);
    this.O.lineTo(this.dEm + this.dEu, this.height);
    this.O.lineTo(this.dEm, this.height);
    this.O.close();
  }
  
  private void dOI()
  {
    this.P.reset();
    this.P.moveTo(this.dEn, this.dEl);
    this.P.quadTo(this.dEn + this.dEo, this.dEl - this.dEk * 2, this.dEn + this.dEp, this.dEl);
    this.P.quadTo(this.dEn + this.dEq, this.dEl + this.dEk * 2, this.dEn + this.width, this.dEl);
    this.P.quadTo(this.dEn + this.dEr, this.dEl - this.dEk * 2, this.dEn + this.dEs, this.dEl);
    this.P.quadTo(this.dEn + this.dEt, this.dEl + this.dEk * 2, this.dEn + this.dEu, this.dEl);
    this.P.lineTo(this.dEn + this.dEu, this.height);
    this.P.lineTo(this.dEn, this.height);
    this.P.close();
  }
  
  private void init()
  {
    this.P = new Path();
    this.O = new Path();
    this.cn = new Paint();
    this.cn.setAntiAlias(true);
    this.cn.setColor(this.dEi);
    this.co = new Paint();
    this.co.setAntiAlias(true);
    this.co.setColor(this.dEj);
    this.mDensity = getResources().getDisplayMetrics().density;
    dEg = (int)(this.mDensity * 3.0F + 0.5D);
    int i = this.width * 2 / 50;
    dEh = i;
    this.dEv = i;
    this.dEo = (this.width / 4);
    this.dEp = (this.width / 2);
    this.dEq = (this.width * 3 / 4);
    this.dEr = (this.width * 5 / 4);
    this.dEs = (this.width * 3 / 2);
    this.dEt = (this.width * 7 / 4);
    this.dEu = (this.width * 2);
    this.mTempPaint = new Paint();
    this.mTempPaint.setAntiAlias(true);
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    if ((this.fy instanceof SkinnableBitmapDrawable)) {}
    for (this.gj = ((SkinnableBitmapDrawable)this.fy).getBitmap();; this.gj = ((BitmapDrawable)this.fy).getBitmap())
    {
      this.jdField_b_of_type_AndroidGraphicsPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
      this.jdField_b_of_type_AndroidGraphicsSweepGradient = new SweepGradient(this.width / 2, this.height / 2, this.dEA, this.dEz);
      this.dEF = (this.width / 2 - this.gj.getWidth() / 2);
      this.dEG = (this.height / 2 - this.gj.getHeight() / 2);
      this.aS.left = 0.0F;
      this.aS.bottom = this.height;
      this.aS.right = this.width;
      this.aS.top = 0.0F;
      this.aR.left = this.mStrokeWidth;
      this.aR.bottom = (this.height - this.mStrokeWidth);
      this.aR.right = (this.width - this.mStrokeWidth);
      this.aR.top = this.mStrokeWidth;
      dOG();
      return;
    }
  }
  
  public void UE(int paramInt)
  {
    this.mState = paramInt;
    this.mHandler.sendEmptyMessage(paramInt);
  }
  
  public void dOG()
  {
    this.dEk = dEg;
    this.dEv = dEh;
    this.dEl = this.height;
    this.dEn = (this.width * -2 / 4);
    this.dEm = (-this.width);
    this.zv = 0.0F;
    this.zy = 270.0F;
    this.zz = 20.0F;
    this.zw = (this.zv - this.zz);
    this.zx = (this.zw - this.zz);
    this.zA = 20.0F;
    float f = this.dEE / this.dED;
    this.zC = (this.zy / f);
    this.zB = this.zC;
    this.zD = (this.zz / f * 1.25F);
    this.zE = (this.zA / f * 1.25F);
    this.dEw = (this.height * 3 / 5);
    this.dEy = 255;
    this.mState = 0;
    this.akp = 0L;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    UE(5);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(-1);
    switch (this.mState)
    {
    default: 
      return;
    case 0: 
    case 1: 
      R(paramCanvas);
      b(paramCanvas, false);
      bg(paramCanvas);
      return;
    case 2: 
      R(paramCanvas);
      b(paramCanvas, false);
      bh(paramCanvas);
      return;
    case 3: 
      b(paramCanvas, false);
      bh(paramCanvas);
      return;
    case 4: 
      b(paramCanvas, false);
      bh(paramCanvas);
      return;
    }
    paramCanvas.drawColor(-1);
  }
  
  public void setAmplitude(float paramFloat)
  {
    if (this.mState < 1) {}
    for (;;)
    {
      return;
      float f = paramFloat;
      if (paramFloat > 0.0F) {
        f = 0.0F;
      }
      if (f < -45.0F)
      {
        this.dEw = ((int)(this.height * 0.65F));
        this.dEk = dEg;
      }
      while (QLog.isDevelopLevel())
      {
        QLog.i("SearchVoiceView", 2, " setAmplitude " + f + " mWaterHeight = " + this.dEw + " mWaveHeightOffset = " + this.dEx + " mMoveOffset = " + this.dEv + " amplitude = " + this.dEk);
        return;
        if ((f >= -45.0F) && (f < -5.0F))
        {
          paramFloat = (45.0F + f) / 40.0F;
          this.dEw = ((int)(this.height * (0.65D - paramFloat * 0.15D)));
          if (this.dEl < (int)(this.height * 0.65F)) {
            this.dEk = ((int)(dEg * (paramFloat * 2.0F + 1.0F)));
          }
          this.dEv = ((int)((paramFloat + 1.0F) * dEh));
        }
        else
        {
          paramFloat = (5.0F + f) / 5.0F;
          this.dEw = ((int)(this.height * (0.5D - 4.0F * paramFloat / 10.0F)));
          if (this.dEl < (int)(this.height * 0.65F)) {
            this.dEk = ((int)(dEg * (2.0F + paramFloat)));
          }
          this.dEv = ((int)((paramFloat + 2.0F) * dEh));
        }
      }
    }
  }
  
  public void setOnStateEndListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onStateEnd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.SearchVoiceView
 * JD-Core Version:    0.7.0.1
 */