package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import atau.a;
import wja;
import ypm;

public class LoadingAvatarProgressView
  extends View
{
  private Path A;
  private a a;
  private int aCx;
  private RectF al;
  private RectF am;
  private boolean boa;
  private Paint bt;
  private int cav = 1500;
  private int caw;
  private int cax = 30;
  private int cay;
  private int centerX;
  private int centerY;
  private int color;
  private int loadType;
  private Paint mLinePaint;
  private Paint mPaint;
  private PathMeasure mPathMeasure;
  private RectF mRectF;
  private float qK;
  private float qL;
  private float qM;
  private Path z;
  
  public LoadingAvatarProgressView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LoadingAvatarProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LoadingAvatarProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    d(paramContext, paramAttributeSet);
  }
  
  private void aE(Canvas paramCanvas)
  {
    if (this.aCx < 100)
    {
      this.bt.setStyle(Paint.Style.STROKE);
      this.bt.setColor(Color.parseColor("#8E8E93"));
      paramCanvas.drawArc(this.am, -90.0F, this.aCx * 360 / 100, false, this.bt);
      this.aCx += 2;
      postInvalidateDelayed(this.cax);
      return;
    }
    this.aCx = 0;
    postInvalidateDelayed(this.cax);
  }
  
  private void aF(Canvas paramCanvas)
  {
    if (this.qL < this.qM)
    {
      this.A.reset();
      this.A.lineTo(0.0F, 0.0F);
      this.mPathMeasure.getSegment(0.0F, this.qL, this.A, false);
      paramCanvas.drawPath(this.A, this.mPaint);
    }
    do
    {
      return;
      if (this.boa)
      {
        this.mPaint.setStyle(Paint.Style.FILL);
        paramCanvas.drawRoundRect(this.al, this.cay, this.cay, this.mPaint);
        paramCanvas.drawPath(this.z, this.mLinePaint);
      }
    } while (this.a == null);
    this.a.Er(this.caw);
  }
  
  private void aG(Canvas paramCanvas)
  {
    if (this.caw < 100)
    {
      paramCanvas.drawArc(this.mRectF, -90.0F, this.caw * 360 / 100, false, this.mPaint);
      this.caw += 2;
      postInvalidateDelayed(this.cax);
    }
    do
    {
      return;
      if (this.boa)
      {
        this.mPaint.setStyle(Paint.Style.FILL);
        paramCanvas.drawCircle(this.centerX, this.centerY, Math.min(this.centerX, this.centerY), this.mPaint);
        paramCanvas.drawPath(this.z, this.mLinePaint);
      }
    } while (this.a == null);
    this.a.Er(this.caw);
  }
  
  private void ckC()
  {
    this.A = new Path();
    int i = this.centerX * 2;
    int j = this.centerY * 2;
    this.al = new RectF(0.0F, 0.0F, i, j);
    Object localObject = new Path();
    ((Path)localObject).moveTo(this.centerX, 0.0F);
    ((Path)localObject).lineTo(i, 0.0F);
    ((Path)localObject).lineTo(i, j);
    ((Path)localObject).lineTo(0.0F, j);
    ((Path)localObject).lineTo(0.0F, 0.0F);
    ((Path)localObject).lineTo(this.centerX, 0.0F);
    ((Path)localObject).close();
    this.mPathMeasure = new PathMeasure((Path)localObject, false);
    this.qM = this.mPathMeasure.getLength();
    localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    ((ValueAnimator)localObject).setDuration(this.cav);
    ((ValueAnimator)localObject).addUpdateListener(new ypm(this));
    ((ValueAnimator)localObject).start();
  }
  
  private void ckD()
  {
    int i = wja.dp2px(12.0F, getResources());
    int j = wja.dp2px(4.0F, getResources());
    float f1 = this.centerX - i + j;
    float f2 = this.centerY;
    float f3 = this.centerX - i / 2 + j;
    float f4 = this.centerY + i / 2;
    float f5 = j + (this.centerX + i * 2 / 4);
    float f6 = this.centerY - i * 2 / 4;
    this.z = new Path();
    this.z.reset();
    this.z.moveTo(f1, f2);
    this.z.lineTo(f3, f4);
    this.z.lineTo(f5, f6);
  }
  
  private void d(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.pR);
    this.qK = paramContext.getInteger(2, 5);
    this.qK = wja.dp2px(this.qK, getResources());
    this.cay = paramContext.getInteger(1, 5);
    this.cay = wja.dp2px(this.cay, getResources());
    this.color = paramContext.getInteger(0, -16776961);
    paramContext.recycle();
    this.mPaint = new Paint();
    this.mPaint.setAntiAlias(true);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setStrokeWidth(this.qK);
    this.mPaint.setColor(this.color);
    this.bt = new Paint();
    this.bt.setAntiAlias(true);
    this.bt.setStyle(Paint.Style.FILL);
    this.bt.setStrokeWidth(this.qK);
    this.bt.setColor(this.color);
    this.mLinePaint = new Paint();
    this.mLinePaint.setAntiAlias(true);
    this.mLinePaint.setStyle(Paint.Style.STROKE);
    this.mLinePaint.setStrokeWidth(this.qK);
    this.mLinePaint.setColor(this.color);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.loadType == 0) {
      aG(paramCanvas);
    }
    do
    {
      return;
      if (this.loadType == 1)
      {
        aF(paramCanvas);
        return;
      }
    } while (this.loadType != 2);
    aE(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    this.centerX = (paramInt1 / 2);
    this.centerY = (paramInt2 / 2);
    this.mRectF = new RectF(this.qK / 2.0F, this.qK / 2.0F, paramInt1 - this.qK / 2.0F, paramInt2 - this.qK / 2.0F);
    this.am = new RectF(this.qK / 2.0F, this.qK / 2.0F, paramInt1 - this.qK / 2.0F, paramInt2 - this.qK / 2.0F);
    ckC();
    if (this.boa) {
      ckD();
    }
  }
  
  public void setAnimDuration(int paramInt)
  {
    this.cav = paramInt;
    this.cax = (paramInt / 50);
  }
  
  public void setLoadType(int paramInt)
  {
    this.caw = 0;
    this.loadType = paramInt;
  }
  
  public void setNeedCover(boolean paramBoolean)
  {
    this.boa = paramBoolean;
  }
  
  public void setProgressListener(a parama)
  {
    this.a = parama;
  }
  
  public void setRoundSize(int paramInt)
  {
    this.cay = paramInt;
  }
  
  static abstract interface a
  {
    public abstract void Er(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.LoadingAvatarProgressView
 * JD-Core Version:    0.7.0.1
 */