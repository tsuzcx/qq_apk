package com.tencent.mobileqq.ar.view;

import acfp;
import admm;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.LinearInterpolator;
import atau.a;
import com.tencent.qphone.base.util.QLog;
import wja;

public final class ViewfinderView
  extends View
{
  private ValueAnimator animator;
  private RectF aw = new RectF();
  private Rect bA;
  private Rect bE = new Rect();
  private Rect bF = new Rect();
  private Rect bG;
  private Rect bH = new Rect();
  private boolean bPU;
  private String buC;
  private int cIP = 18;
  private int cIQ;
  private int cIR;
  private int cIS;
  private int cIT;
  private int cIU;
  private final int caO;
  private String description;
  private Bitmap eU;
  private boolean flag = true;
  private int mStrokeWidth;
  private final Paint paint = new Paint(1);
  private int textColor;
  private float vf;
  private float vg;
  private float x;
  
  public ViewfinderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.eU = BitmapFactory.decodeResource(paramContext.getResources(), 2130845788);
    this.cIP = this.eU.getHeight();
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.sN);
    this.cIQ = paramAttributeSet.getDimensionPixelSize(4, dip2px(paramContext, 3.0F));
    if ((this.cIQ & 0x1) != 0) {
      this.cIQ += 1;
    }
    this.cIR = paramAttributeSet.getDimensionPixelSize(1, dip2px(paramContext, 16.0F));
    this.mStrokeWidth = paramAttributeSet.getDimensionPixelSize(3, dip2px(paramContext, 2.0F));
    this.cIU = paramAttributeSet.getColor(0, Color.parseColor("#1E6FFF"));
    this.cIT = paramAttributeSet.getColor(2, -16776961);
    this.caO = paramAttributeSet.getColor(5, Color.parseColor("#000000"));
    this.description = paramAttributeSet.getString(7);
    if (TextUtils.isEmpty(this.description)) {
      this.description = acfp.m(2131716495);
    }
    this.textColor = paramAttributeSet.getColor(6, Color.parseColor("#FFFFFF"));
    this.bPU = paramAttributeSet.getBoolean(10, false);
    this.vf = paramAttributeSet.getDimensionPixelSize(8, dip2px(paramContext, 20.0F));
    this.vg = paramAttributeSet.getDimensionPixelSize(9, sp2px(paramContext, 14.0F));
    this.cIS = dip2px(paramContext, 8.0F);
    paramAttributeSet.recycle();
  }
  
  private void a(Rect paramRect, Canvas paramCanvas)
  {
    this.paint.reset();
    this.paint.setStyle(Paint.Style.FILL);
    this.paint.setColor(this.cIU);
    this.paint.setAntiAlias(true);
    this.bE.set(paramRect.left - this.cIS, paramRect.top - this.cIS, paramRect.right + this.cIS, paramRect.bottom + this.cIS);
    this.aw.set(this.bE.left, this.bE.top, this.bE.left + this.cIR, this.bE.top + this.cIQ);
    paramCanvas.drawRoundRect(this.aw, this.cIQ / 2, this.cIQ / 2, this.paint);
    this.aw.set(this.bE.left, this.bE.top, this.bE.left + this.cIQ, this.bE.top + this.cIR);
    paramCanvas.drawRoundRect(this.aw, this.cIQ / 2, this.cIQ / 2, this.paint);
    this.aw.set(this.bE.right - this.cIR, this.bE.top, this.bE.right, this.bE.top + this.cIQ);
    paramCanvas.drawRoundRect(this.aw, this.cIQ / 2, this.cIQ / 2, this.paint);
    this.aw.set(this.bE.right - this.cIQ, this.bE.top, this.bE.right, this.bE.top + this.cIR);
    paramCanvas.drawRoundRect(this.aw, this.cIQ / 2, this.cIQ / 2, this.paint);
    this.aw.set(this.bE.left, this.bE.bottom - this.cIR, this.bE.left + this.cIQ, this.bE.bottom);
    paramCanvas.drawRoundRect(this.aw, this.cIQ / 2, this.cIQ / 2, this.paint);
    this.aw.set(this.bE.left, this.bE.bottom - this.cIQ, this.bE.left + this.cIR, this.bE.bottom);
    paramCanvas.drawRoundRect(this.aw, this.cIQ / 2, this.cIQ / 2, this.paint);
    this.aw.set(this.bE.right - this.cIR, this.bE.bottom - this.cIQ, this.bE.right, this.bE.bottom);
    paramCanvas.drawRoundRect(this.aw, this.cIQ / 2, this.cIQ / 2, this.paint);
    this.aw.set(this.bE.right - this.cIQ, this.bE.bottom - this.cIR, this.bE.right, this.bE.bottom);
    paramCanvas.drawRoundRect(this.aw, this.cIQ / 2, this.cIQ / 2, this.paint);
    this.paint.reset();
  }
  
  private void b(Rect paramRect, Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.clipRect(paramRect);
    if (this.animator == null)
    {
      this.animator = ValueAnimator.ofFloat(new float[] { paramRect.top - this.cIP, paramRect.bottom - this.cIP });
      this.animator.setDuration(3000L);
      this.animator.setRepeatCount(-1);
      this.animator.setRepeatMode(1);
      this.animator.setInterpolator(new LinearInterpolator());
      this.animator.addUpdateListener(new admm(this, paramRect));
      this.flag = true;
    }
    if (this.flag)
    {
      this.animator.start();
      this.flag = false;
    }
    this.paint.setAntiAlias(true);
    this.paint.setDither(true);
    this.paint.setFilterBitmap(true);
    this.bF.set(paramRect.left, (int)this.x, paramRect.right, (int)this.x + this.cIP);
    paramCanvas.drawBitmap(this.eU, null, this.bF, this.paint);
    paramCanvas.restore();
    this.paint.reset();
  }
  
  private void c(Rect paramRect, Canvas paramCanvas)
  {
    if (this.bPU)
    {
      this.paint.setAntiAlias(true);
      this.paint.setTextSize(this.vg);
      this.paint.setColor(this.textColor);
      this.paint.setTextAlign(Paint.Align.CENTER);
      this.paint.getTextBounds(this.description, 0, this.description.length(), this.bH);
      String str = this.description;
      int i = this.description.length();
      float f1 = paramRect.centerX();
      float f2 = paramRect.centerY() + paramRect.height() / 2;
      float f3 = this.vf;
      paramCanvas.drawText(str, 0, i, f1, this.bH.height() + (f2 + f3), this.paint);
      this.paint.reset();
    }
  }
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static int sp2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().scaledDensity * paramFloat + 0.5F);
  }
  
  public void onDetachedFromWindow()
  {
    QLog.d("viewFinderView", 1, "onDetachedFromWindow ");
    super.onDetachedFromWindow();
    stopAnimation();
  }
  
  @SuppressLint({"DrawAllocation"})
  public void onDraw(Canvas paramCanvas)
  {
    if (this.bA == null) {}
    do
    {
      do
      {
        return;
        localObject = this.bA;
      } while (localObject == null);
      int i = paramCanvas.getWidth();
      int j = paramCanvas.getHeight();
      this.paint.setColor(this.caO);
      this.paint.setAntiAlias(true);
      this.paint.setAlpha(123);
      paramCanvas.drawRect(0.0F, 0.0F, i, ((Rect)localObject).top, this.paint);
      paramCanvas.drawRect(0.0F, ((Rect)localObject).top, ((Rect)localObject).left, ((Rect)localObject).bottom, this.paint);
      paramCanvas.drawRect(((Rect)localObject).right, ((Rect)localObject).top, i, ((Rect)localObject).bottom, this.paint);
      paramCanvas.drawRect(0.0F, ((Rect)localObject).bottom, i, j, this.paint);
      a((Rect)localObject, paramCanvas);
      b((Rect)localObject, paramCanvas);
      c((Rect)localObject, paramCanvas);
      if ((this.bG != null) && (this.bG.width() != 0) && (this.bG.height() != 0))
      {
        this.paint.setColor(-65536);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(4.0F);
        paramCanvas.drawRect(this.bG, this.paint);
      }
    } while (TextUtils.isEmpty(this.buC));
    Object localObject = new TextPaint();
    ((TextPaint)localObject).setColor(-65536);
    ((TextPaint)localObject).setStyle(Paint.Style.FILL);
    ((TextPaint)localObject).setStrokeWidth(2.0F);
    ((TextPaint)localObject).setTextSize(wja.dp2px(12.0F, getResources()));
    paramCanvas.drawText(this.buC, 90.0F, 90.0F, (Paint)localObject);
  }
  
  public void onVisibilityChanged(View paramView, int paramInt)
  {
    QLog.d("viewFinderView", 2, "onVisibilityChanged " + paramInt);
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt != 0) {
      stopAnimation();
    }
  }
  
  public void setDetectRect(Rect paramRect)
  {
    this.bG = new Rect();
    if ((paramRect != null) && (paramRect.width() > 0) && (paramRect.height() > 0)) {
      this.bG.set(paramRect);
    }
    postInvalidate();
  }
  
  public void setMiniText(String paramString)
  {
    this.buC = paramString;
    postInvalidate();
  }
  
  public void setRect(Rect paramRect)
  {
    if ((paramRect != null) && (!paramRect.equals(this.bA)))
    {
      this.bA = new Rect(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
      if (this.animator != null)
      {
        this.animator.cancel();
        this.animator = null;
      }
    }
  }
  
  public void stopAnimation()
  {
    if (this.animator != null)
    {
      this.animator.cancel();
      this.animator = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.ViewfinderView
 * JD-Core Version:    0.7.0.1
 */