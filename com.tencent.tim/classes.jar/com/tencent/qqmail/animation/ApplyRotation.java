package com.tencent.qqmail.animation;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;

public class ApplyRotation
{
  public ViewGroup mContainer;
  public View mLayoutBack;
  public View mLayoutFront;
  public RotationAction mRotationAction;
  
  public ApplyRotation() {}
  
  public ApplyRotation(ViewGroup paramViewGroup, View paramView1, View paramView2, RotationAction paramRotationAction)
  {
    this.mContainer = paramViewGroup;
    this.mLayoutFront = paramView1;
    this.mLayoutBack = paramView2;
    this.mRotationAction = paramRotationAction;
  }
  
  public void applyRotation(int paramInt, float paramFloat1, float paramFloat2)
  {
    Rotate3dAnimation localRotate3dAnimation = new Rotate3dAnimation(paramFloat1, paramFloat2, this.mContainer.getWidth() / 2.0F, this.mContainer.getHeight() / 2.0F, 310.0F, true);
    localRotate3dAnimation.setDuration(400L);
    localRotate3dAnimation.setFillAfter(true);
    localRotate3dAnimation.setInterpolator(new AccelerateInterpolator());
    localRotate3dAnimation.setAnimationListener(new DisplayNextView(paramInt, this.mRotationAction, null));
    this.mContainer.startAnimation(localRotate3dAnimation);
  }
  
  final class DisplayNextView
    implements Animation.AnimationListener
  {
    private final int mPosition;
    public RotationAction mRotationAction;
    
    private DisplayNextView(int paramInt, RotationAction paramRotationAction)
    {
      this.mPosition = paramInt;
      this.mRotationAction = paramRotationAction;
    }
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      ApplyRotation.this.mContainer.post(new ApplyRotation.SwapViews(ApplyRotation.this, this.mPosition, this.mRotationAction));
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
  
  final class SwapViews
    implements Runnable
  {
    private final int mPosition;
    private RotationAction mRotationAction;
    
    public SwapViews(int paramInt, RotationAction paramRotationAction)
    {
      this.mPosition = paramInt;
      this.mRotationAction = paramRotationAction;
    }
    
    public void run()
    {
      float f1 = ApplyRotation.this.mContainer.getWidth() / 2.0F;
      float f2 = ApplyRotation.this.mContainer.getHeight() / 2.0F;
      if (this.mPosition > -1)
      {
        if (ApplyRotation.this.mLayoutFront != null) {
          ApplyRotation.this.mLayoutFront.setVisibility(8);
        }
        if (ApplyRotation.this.mLayoutBack != null)
        {
          ApplyRotation.this.mLayoutBack.setVisibility(0);
          ApplyRotation.this.mLayoutBack.requestFocus();
        }
        this.mRotationAction.doAfterRotationFront();
      }
      for (Rotate3dAnimation localRotate3dAnimation = new Rotate3dAnimation(270.0F, 360.0F, f1, f2, 310.0F, false);; localRotate3dAnimation = new Rotate3dAnimation(90.0F, 0.0F, f1, f2, 310.0F, false))
      {
        localRotate3dAnimation.setDuration(500L);
        localRotate3dAnimation.setFillAfter(true);
        localRotate3dAnimation.setInterpolator(new DecelerateInterpolator());
        ApplyRotation.this.mContainer.startAnimation(localRotate3dAnimation);
        return;
        if (ApplyRotation.this.mLayoutBack != null) {
          ApplyRotation.this.mLayoutBack.setVisibility(8);
        }
        if (ApplyRotation.this.mLayoutFront != null)
        {
          ApplyRotation.this.mLayoutFront.setVisibility(0);
          ApplyRotation.this.mLayoutFront.requestFocus();
        }
        this.mRotationAction.doAfterRotationBack();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.animation.ApplyRotation
 * JD-Core Version:    0.7.0.1
 */