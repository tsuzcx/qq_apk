package com.tencent.mobileqq.olympic.view;

import akrg;
import akrh;
import akri;
import akrj;
import akrk;
import akrl;
import akrm;
import akrn;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.qphone.base.util.QLog;
import wja;

public class ScanIconAnimateView
  extends View
{
  DrawFilter a;
  public a a;
  ValueAnimator aA;
  ValueAnimator aB;
  ValueAnimator aC;
  ValueAnimator aD;
  ValueAnimator aE;
  ValueAnimator aF;
  ValueAnimator aG;
  AnimatorSet at;
  Paint backgroundPaint;
  Paint ce;
  private boolean cup;
  Bitmap fE;
  Bitmap fF;
  public float yg = 0.0F;
  public float yh = 0.5F;
  public float yi = 1.0F;
  public float yj = 0.0F;
  public float yk = 1.0F;
  public float yl = 1.0F;
  
  public ScanIconAnimateView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScanIconAnimateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScanIconAnimateView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    try
    {
      paramContext = BitmapFactory.decodeResource(getResources(), 2130844102);
      Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), 2130844104);
      int i = wja.dp2px(32.0F, getResources());
      this.fE = Bitmap.createScaledBitmap(paramContext, i * 2, i * 2, true);
      this.fF = Bitmap.createScaledBitmap(localBitmap, i, i, true);
      this.ce = new Paint();
      this.ce.setAntiAlias(true);
      this.backgroundPaint = new Paint();
      this.backgroundPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsDrawFilter = new PaintFlagsDrawFilter(0, 3);
      this.aA = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.1333333F, 8.0F), Keyframe.ofFloat(0.2F, -6.0F), Keyframe.ofFloat(0.2666667F, 3.0F), Keyframe.ofFloat(0.3333333F, 0.0F), Keyframe.ofFloat(0.6666667F, 0.0F), Keyframe.ofFloat(1.0F, 0.0F) }) });
      this.aA.setDuration(1500L);
      this.aA.setRepeatCount(-1);
      this.aA.addUpdateListener(new akrg(this));
      this.aB = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("", new Keyframe[] { Keyframe.ofFloat(0.0F, -90.0F), Keyframe.ofFloat(0.2F, 40.0F), Keyframe.ofFloat(0.4F, -20.0F), Keyframe.ofFloat(0.6F, 5.0F), Keyframe.ofFloat(0.8F, -5.0F), Keyframe.ofFloat(0.9F, 3.0F), Keyframe.ofFloat(1.0F, 0.0F) }) });
      this.aB.setDuration(1000L);
      this.aB.setInterpolator(new AccelerateDecelerateInterpolator());
      this.aB.addUpdateListener(new akrh(this));
      this.aC = ValueAnimator.ofFloat(new float[] { 0.5F, 1.0F, 1.0F, 1.0F, 0.5F, 0.5F });
      this.aC.setDuration(1000L);
      this.aC.setInterpolator(new AccelerateDecelerateInterpolator());
      this.aC.addUpdateListener(new akri(this));
      this.aD = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F });
      this.aD.setDuration(1000L);
      this.aD.addUpdateListener(new akrj(this));
      this.aE = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F });
      this.aE.setDuration(1000L);
      this.aE.addUpdateListener(new akrk(this));
      this.aF = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.6F, 1.0F), Keyframe.ofFloat(0.8F, 1.08F), Keyframe.ofFloat(0.9F, 1.0F), Keyframe.ofFloat(1.0F, 1.0F) }) });
      this.aF.setDuration(1000L);
      this.aF.addUpdateListener(new akrl(this));
      this.aG = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofKeyframe("", new Keyframe[] { Keyframe.ofFloat(0.0F, 0.0F), Keyframe.ofFloat(0.6F, 0.0F), Keyframe.ofFloat(0.9F, 1.0F), Keyframe.ofFloat(1.0F, 1.0F) }) });
      this.aG.setDuration(1000L);
      this.aG.addUpdateListener(new akrm(this));
      this.at = new AnimatorSet();
      this.at.setDuration(1000L);
      this.at.playTogether(new Animator[] { this.aB, this.aC, this.aE, this.aD, this.aF, this.aG });
      this.at.addListener(new akrn(this));
      return;
    }
    catch (OutOfMemoryError paramContext)
    {
      QLog.d("ScanIconAnimateView", 1, "init failed ", paramContext);
    }
  }
  
  public boolean asH()
  {
    boolean bool = this.aA.isRunning();
    if (QLog.isColorLevel()) {
      QLog.d("ScanIconAnimateView", 2, "isPendulumRunning = " + bool);
    }
    return bool;
  }
  
  public void dDe()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanIconAnimateView", 2, "startPendulumAnim ");
    }
    if (!this.cup) {
      return;
    }
    this.aA.start();
  }
  
  public void dDf()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanIconAnimateView", 2, "stopPendulumAnim ");
    }
    this.aA.cancel();
    this.yg = 0.0F;
    invalidate();
  }
  
  public void dDg()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanIconAnimateView", 2, "startPopUpAnim ");
    }
    if (this.cup) {
      return;
    }
    this.at.start();
  }
  
  public void dDh()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScanIconAnimateView", 2, "stopPopUpAnim ");
    }
    this.at.cancel();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.save();
    this.backgroundPaint.setAlpha((int)(this.yk * 255.0F));
    paramCanvas.scale(this.yl, this.yl, wja.dp2px(16.0F, getResources()), wja.dp2px(16.0F, getResources()));
    paramCanvas.drawBitmap(this.fF, 0.0F, 0.0F, this.backgroundPaint);
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.yj);
    paramCanvas.scale(this.yh, this.yh, wja.dp2px(16.0F, getResources()), wja.dp2px(23.0F, getResources()));
    paramCanvas.rotate(this.yg, wja.dp2px(16.0F, getResources()), wja.dp2px(23.0F, getResources()));
    this.ce.setAlpha((int)(this.yi * 255.0F));
    paramCanvas.setDrawFilter(this.jdField_a_of_type_AndroidGraphicsDrawFilter);
    paramCanvas.drawBitmap(this.fE, wja.dp2px(-16.0F, getResources()), wja.dp2px(-23.0F, getResources()), this.ce);
    paramCanvas.restore();
  }
  
  public void setPopUpListener(a parama)
  {
    this.jdField_a_of_type_ComTencentMobileqqOlympicViewScanIconAnimateView$a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onEnd();
    
    public abstract void onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.view.ScanIconAnimateView
 * JD-Core Version:    0.7.0.1
 */