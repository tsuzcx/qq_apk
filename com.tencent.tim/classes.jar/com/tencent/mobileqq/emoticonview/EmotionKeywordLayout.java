package com.tencent.mobileqq.emoticonview;

import afof;
import afog;
import afoh;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;
import aqmr;
import com.tencent.qphone.base.util.QLog;
import wja;

public class EmotionKeywordLayout
  extends LinearLayout
{
  private a a;
  private ValueAnimator ao;
  private ValueAnimator ap;
  private boolean bZU;
  private EmotionKeywordHorizonListView c;
  private LinearLayout iH;
  private LinearLayout iI;
  private Animator.AnimatorListener mAnimatorListener = new afoh(this);
  private int mHeight;
  private TextView mTitleView;
  
  public EmotionKeywordLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmotionKeywordLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mHeight = wja.dp2px(81.0F, paramContext.getResources());
  }
  
  private void dbb()
  {
    if (this.iH == null) {
      this.iH = ((LinearLayout)findViewById(2131366342));
    }
    if (this.mTitleView == null) {
      this.mTitleView = ((TextView)findViewById(2131366341));
    }
    if (this.c == null) {
      this.c = ((EmotionKeywordHorizonListView)findViewById(2131366371));
    }
    if (this.iI == null) {
      this.iI = ((LinearLayout)findViewById(2131362720));
    }
  }
  
  private void dbc()
  {
    if (this.iH.getVisibility() == 0) {}
    for (int i = 100;; i = 81)
    {
      this.mHeight = wja.dp2px(i, getResources());
      return;
    }
  }
  
  public void hide()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionKeywordLayout", 2, "hide");
    }
    dbb();
    if (getVisibility() == 8) {}
    do
    {
      return;
      if (!this.bZU)
      {
        setVisibility(8);
        return;
      }
    } while ((this.ap != null) && (this.ap.isRunning()));
    if ((this.ao != null) && (this.ao.isRunning())) {
      this.ao.cancel();
    }
    if (this.ap == null)
    {
      this.ap = ValueAnimator.ofFloat(new float[] { 0.0F, this.mHeight });
      this.ap.addUpdateListener(new afog(this));
      this.ap.setDuration(200L);
      this.ap.addListener(this.mAnimatorListener);
    }
    this.ap.start();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void setEnableAnim(boolean paramBoolean)
  {
    this.bZU = paramBoolean;
  }
  
  public void setOnVisibilityListener(a parama)
  {
    this.a = parama;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (this.a != null) {
      this.a.onVisibilityChanged(paramInt);
    }
  }
  
  public void show(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionKeywordLayout", 2, "show");
    }
    dbb();
    if (aqmr.isEmpty(paramString))
    {
      this.mTitleView.setText("");
      this.iH.setVisibility(8);
      dbc();
      if (getVisibility() != 0) {
        break label74;
      }
    }
    label74:
    do
    {
      return;
      this.mTitleView.setText(paramString);
      this.iH.setVisibility(0);
      break;
      setVisibility(0);
    } while ((this.ao != null) && (this.ao.isRunning()));
    if ((this.ap != null) && (this.ap.isRunning())) {
      this.ap.cancel();
    }
    if (this.ao == null)
    {
      this.ao = ValueAnimator.ofFloat(new float[] { this.mHeight, 0.0F });
      this.ao.addUpdateListener(new afof(this));
      this.ao.setDuration(200L);
      this.ao.addListener(this.mAnimatorListener);
    }
    this.ao.start();
    invalidate();
  }
  
  public static abstract interface a
  {
    public abstract void onVisibilityChanged(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionKeywordLayout
 * JD-Core Version:    0.7.0.1
 */