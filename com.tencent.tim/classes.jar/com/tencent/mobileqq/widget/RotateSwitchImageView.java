package com.tencent.mobileqq.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RotateSwitchImageView
  extends ImageView
{
  private ObjectAnimator bO;
  
  public RotateSwitchImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RotateSwitchImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RotateSwitchImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void init()
  {
    this.bO = ObjectAnimator.ofFloat(this, "rotation", new float[] { 0.0F, -90.0F }).setDuration(250L);
  }
  
  public void eiK()
  {
    if (this.bO == null) {
      init();
    }
    this.bO.reverse();
  }
  
  public void eiL()
  {
    if (this.bO == null) {
      init();
    }
    this.bO.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RotateSwitchImageView
 * JD-Core Version:    0.7.0.1
 */