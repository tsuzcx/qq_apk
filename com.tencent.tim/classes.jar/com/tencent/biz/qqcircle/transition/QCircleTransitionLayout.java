package com.tencent.biz.qqcircle.transition;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewPropertyAnimator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import common.config.service.QzoneConfig;
import pdo;

public class QCircleTransitionLayout
  extends FrameLayout
{
  private QCircleTransitionInnerLayout jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout;
  private a jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout$a;
  private boolean azA = true;
  private boolean azy = QzoneConfig.getQQCircleEnableTransitionCloseAnim();
  private boolean azz = true;
  private int bhE = 500;
  private int bhF;
  private int bhG;
  private ColorDrawable g;
  private boolean iO = true;
  private float lQ;
  private float lR;
  private int mAlpha = 255;
  private float mMinScale = 0.5F;
  private int mOriginalHeight;
  private int mOriginalWidth;
  private float mScale = 1.0F;
  private float mTranslateX;
  private float mTranslateY;
  
  public QCircleTransitionLayout(@android.support.annotation.NonNull @androidx.annotation.NonNull Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public QCircleTransitionLayout(@android.support.annotation.NonNull @androidx.annotation.NonNull Context paramContext, @android.support.annotation.Nullable @androidx.annotation.Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public QCircleTransitionLayout(@android.support.annotation.NonNull @androidx.annotation.NonNull Context paramContext, @android.support.annotation.Nullable @androidx.annotation.Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void H(MotionEvent paramMotionEvent)
  {
    if (!HR()) {}
    label210:
    label240:
    do
    {
      for (;;)
      {
        return;
        float f1 = paramMotionEvent.getRawY();
        float f2 = paramMotionEvent.getRawX();
        switch (paramMotionEvent.getAction())
        {
        default: 
          return;
        case 1: 
        case 3: 
          if (this.mScale >= 0.85F) {
            break label433;
          }
          if (this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout$a != null)
          {
            this.g.setAlpha(0);
            this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout$a.C(this.mTranslateX, this.mTranslateY);
            return;
          }
          break;
        case 2: 
          if (getBackground() == null)
          {
            if (Build.VERSION.SDK_INT >= 16) {
              setBackground(this.g);
            }
          }
          else
          {
            if (this.iO)
            {
              this.iO = false;
              if (this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout$a != null) {
                this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout$a.bjm();
              }
            }
            this.mTranslateX = (f2 - this.lR);
            this.mTranslateY = (f1 - this.lQ);
            this.mAlpha = ((int)((1.0F - d(f2, f1, this.lR, this.lQ) / this.bhE) * 255.0F));
            if (this.mAlpha <= 255) {
              break label390;
            }
            this.mAlpha = 255;
            f1 = Math.abs(this.mTranslateX);
            f2 = Math.abs(this.mTranslateY);
            if (f1 <= f2) {
              break label405;
            }
            f1 /= this.bhF;
            if ((this.mScale >= this.mMinScale) && (this.mScale <= 1.0F)) {
              this.mScale = (1.0F - f1);
            }
            if (this.mScale >= this.mMinScale) {
              break label416;
            }
            this.mScale = this.mMinScale;
          }
          for (;;)
          {
            if (this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout == null) {
              break label431;
            }
            this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.setTranslationX(this.mTranslateX);
            this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.setTranslationY(this.mTranslateY);
            this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.setPivotX(this.mOriginalWidth / 2.0F);
            this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.setPivotY(this.mOriginalHeight / 2.0F);
            this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.setScaleX(this.mScale);
            this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.setScaleY(this.mScale);
            this.g.setAlpha(this.mAlpha);
            return;
            setBackgroundDrawable(this.g);
            break;
            if (this.mAlpha >= 0) {
              break label210;
            }
            this.mAlpha = 0;
            break label210;
            f1 = f2 / this.bhG;
            break label240;
            if (this.mScale > 1.0F) {
              this.mScale = 1.0F;
            }
          }
        }
      }
    } while (this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout == null);
    label390:
    label405:
    label416:
    label431:
    label433:
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.animate().translationX(0.0F).setDuration(300L).setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.animate().translationY(0.0F).setDuration(300L).setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.animate().scaleX(1.0F).setDuration(300L).setInterpolator(new DecelerateInterpolator());
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.animate().scaleY(1.0F).setDuration(300L).setInterpolator(new DecelerateInterpolator()).setListener(new pdo(this));
  }
  
  private boolean HR()
  {
    return (this.azz) && (this.azA) && (this.azy);
  }
  
  private float d(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    paramFloat1 = Math.abs(paramFloat1 - paramFloat3);
    paramFloat2 = Math.abs(paramFloat2 - paramFloat4);
    return (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
  }
  
  private void init()
  {
    this.mOriginalWidth = ImmersiveUtils.getScreenWidth();
    this.mOriginalHeight = ImmersiveUtils.getScreenHeight();
    this.g = new ColorDrawable(-16777216);
    this.bhF = this.mOriginalWidth;
    this.bhG = this.mOriginalHeight;
  }
  
  public void a(QCircleTransitionInnerLayout paramQCircleTransitionInnerLayout, a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout = paramQCircleTransitionInnerLayout;
    this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionLayout$a = parama;
  }
  
  public void bkd()
  {
    this.azA = false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    while (paramMotionEvent.getAction() == 0)
    {
      return false;
      QLog.d("QCircleTransitionLayout", 1, "onInterceptTouchEvent: MotionEvent.ACTION_DOWN ");
      continue;
      this.lQ = paramMotionEvent.getRawY();
      this.lR = paramMotionEvent.getRawX();
      this.iO = true;
      QLog.d("QCircleTransitionLayout", 1, "onInterceptTouchEvent: MotionEvent.ACTION_MOVE StarX:" + this.lR + ",mStarY:" + this.lQ);
      continue;
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      QLog.d("QCircleTransitionLayout", 1, "onInterceptTouchEvent: MotionEvent.ACTION_UP x:" + f1 + ",y:" + f2);
    }
    return HR();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    H(paramMotionEvent);
    return HR();
  }
  
  public void rr(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout != null) {
      this.jdField_a_of_type_ComTencentBizQqcircleTransitionQCircleTransitionInnerLayout.rr(paramBoolean);
    }
  }
  
  public void rs(boolean paramBoolean)
  {
    this.azz = paramBoolean;
  }
  
  public static abstract interface a
  {
    public abstract void C(float paramFloat1, float paramFloat2);
    
    public abstract void bjm();
    
    public abstract void bjn();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.transition.QCircleTransitionLayout
 * JD-Core Version:    0.7.0.1
 */