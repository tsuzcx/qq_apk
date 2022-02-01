package com.tencent.qqmail.animation;

import android.content.Context;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

public class SlideViewAnimation
{
  public static final String TAG = SlideViewAnimation.class.getSimpleName();
  private boolean isAnimationFinish = true;
  private SlideAction slideAction;
  
  public SlideViewAnimation(SlideAction paramSlideAction)
  {
    this.slideAction = paramSlideAction;
  }
  
  public boolean isAnimFinish()
  {
    return this.isAnimationFinish;
  }
  
  public void slideBottom2Top(Context paramContext, ViewFlipper paramViewFlipper)
  {
    if (paramViewFlipper != null)
    {
      Animation localAnimation = AnimationUtils.loadAnimation(paramContext, 2130772112);
      paramContext = AnimationUtils.loadAnimation(paramContext, 2130772165);
      localAnimation.setAnimationListener(new SlideViewAnimation.2(this));
      paramViewFlipper.setInAnimation(localAnimation);
      paramViewFlipper.setOutAnimation(paramContext);
      paramViewFlipper.showNext();
    }
    Log.d("download", "slide bottom2top");
  }
  
  public void slideLeft2Right(Context paramContext, ViewFlipper paramViewFlipper)
  {
    if (paramViewFlipper != null)
    {
      paramViewFlipper.setInAnimation(paramContext, 2130772113);
      paramViewFlipper.setOutAnimation(paramContext, 2130772166);
      paramViewFlipper.showNext();
    }
    if (this.slideAction != null) {
      this.slideAction.slideLeft2RightAction();
    }
    Log.d("download", "slide left2right");
  }
  
  public void slideRight2Left(Context paramContext, ViewFlipper paramViewFlipper)
  {
    if (paramViewFlipper != null)
    {
      paramViewFlipper.setInAnimation(paramContext, 2130772114);
      paramViewFlipper.setOutAnimation(paramContext, 2130772167);
      paramViewFlipper.showPrevious();
    }
    if (this.slideAction != null) {
      this.slideAction.slideRight2LeftAction();
    }
    Log.d("download", "slide right2left");
  }
  
  public void slideTop2Bottom(Context paramContext, ViewFlipper paramViewFlipper)
  {
    if (paramViewFlipper != null)
    {
      Animation localAnimation = AnimationUtils.loadAnimation(paramContext, 2130772115);
      paramContext = AnimationUtils.loadAnimation(paramContext, 2130772168);
      localAnimation.setAnimationListener(new SlideViewAnimation.1(this));
      paramViewFlipper.setInAnimation(localAnimation);
      paramViewFlipper.setOutAnimation(paramContext);
      paramViewFlipper.showNext();
    }
    Log.d("download", "slide top2bottom");
  }
  
  public static abstract interface SlideAction
  {
    public abstract void slideBottom2TopAction();
    
    public abstract void slideLeft2RightAction();
    
    public abstract void slideRight2LeftAction();
    
    public abstract void slideTop2BottomAction();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.animation.SlideViewAnimation
 * JD-Core Version:    0.7.0.1
 */