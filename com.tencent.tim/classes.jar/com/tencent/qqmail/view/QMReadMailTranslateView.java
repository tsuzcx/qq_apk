package com.tencent.qqmail.view;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class QMReadMailTranslateView
  extends RelativeLayout
{
  private boolean isInAnimation;
  private TextView mTextView;
  
  public QMReadMailTranslateView(Context paramContext)
  {
    super(paramContext);
  }
  
  public QMReadMailTranslateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void playRotate3dAnimation(CharSequence paramCharSequence)
  {
    TranslateRotateAnimation localTranslateRotateAnimation = new TranslateRotateAnimation(0.0F, 90.0F, getWidth() / 2.0F, getHeight() / 2.0F);
    localTranslateRotateAnimation.setDuration(400L);
    localTranslateRotateAnimation.setFillAfter(true);
    localTranslateRotateAnimation.setInterpolator(new AccelerateInterpolator());
    localTranslateRotateAnimation.setInterpolatedTimeListener(new QMReadMailTranslateView.1(this, paramCharSequence));
    localTranslateRotateAnimation.setAnimationListener(new QMReadMailTranslateView.2(this));
    this.mTextView.setTag(Boolean.valueOf(true));
    this.mTextView.startAnimation(localTranslateRotateAnimation);
  }
  
  public boolean isInAnimation()
  {
    return this.isInAnimation;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.mTextView = ((TextView)findViewById(2131379752));
  }
  
  public void setText(CharSequence paramCharSequence, boolean paramBoolean)
  {
    this.mTextView.clearAnimation();
    if (!paramBoolean)
    {
      this.mTextView.setText(paramCharSequence);
      return;
    }
    playRotate3dAnimation(paramCharSequence);
  }
  
  static class TranslateRotateAnimation
    extends Animation
  {
    private InterpolatedTimeListener listener;
    private Camera mCamera;
    private final float mCenterX;
    private final float mCenterY;
    private final float mMaxDegree;
    private final float mMinDegree;
    
    public TranslateRotateAnimation(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.mMinDegree = paramFloat1;
      this.mMaxDegree = paramFloat2;
      this.mCenterX = paramFloat3;
      this.mCenterY = paramFloat4;
    }
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      if (this.listener != null) {
        this.listener.interpolatedTime(paramFloat);
      }
      if (paramFloat < 0.5F) {}
      for (paramFloat = this.mMinDegree + (this.mMaxDegree - this.mMinDegree) * (paramFloat / 0.5F);; paramFloat = this.mMinDegree + (this.mMaxDegree - this.mMinDegree) * ((1.0F - paramFloat) / 0.5F))
      {
        float f1 = this.mCenterX;
        float f2 = this.mCenterY;
        Camera localCamera = this.mCamera;
        paramTransformation = paramTransformation.getMatrix();
        localCamera.save();
        localCamera.rotateY(paramFloat);
        localCamera.getMatrix(paramTransformation);
        localCamera.restore();
        paramTransformation.preTranslate(-f1, -f2);
        paramTransformation.postTranslate(f1, f2);
        return;
      }
    }
    
    public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
      this.mCamera = new Camera();
    }
    
    public void setInterpolatedTimeListener(InterpolatedTimeListener paramInterpolatedTimeListener)
    {
      this.listener = paramInterpolatedTimeListener;
    }
    
    public static abstract interface InterpolatedTimeListener
    {
      public abstract void interpolatedTime(float paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMReadMailTranslateView
 * JD-Core Version:    0.7.0.1
 */