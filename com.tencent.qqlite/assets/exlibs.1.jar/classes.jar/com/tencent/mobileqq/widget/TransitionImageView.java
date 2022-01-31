package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLImageView;

public class TransitionImageView
  extends FrameLayout
  implements Animation.AnimationListener
{
  private static final int jdField_a_of_type_Int = 0;
  private static final int jdField_b_of_type_Int = 1;
  private static final int c = 2;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  private int d;
  
  public TransitionImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TransitionImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TransitionImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(paramContext);
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.jdField_b_of_type_ComTencentImageURLImageView = new URLImageView(paramContext);
    this.jdField_b_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView(this.jdField_a_of_type_ComTencentImageURLImageView, -1, -1);
    addView(this.jdField_b_of_type_ComTencentImageURLImageView, -1, -1);
    this.d = 0;
    this.jdField_a_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(1500L);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(1500L);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
  }
  
  public Drawable a()
  {
    if (this.d == 0) {}
    do
    {
      return null;
      if (this.d == 1) {
        return this.jdField_a_of_type_ComTencentImageURLImageView.getDrawable();
      }
    } while (this.d != 2);
    return this.jdField_b_of_type_ComTencentImageURLImageView.getDrawable();
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_ComTencentImageURLImageView.clearAnimation();
    this.jdField_b_of_type_ComTencentImageURLImageView.clearAnimation();
    this.jdField_a_of_type_AndroidViewAnimationAnimation.reset();
    this.jdField_b_of_type_AndroidViewAnimationAnimation.reset();
    if (this.d == 0)
    {
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramDrawable);
      this.jdField_a_of_type_ComTencentImageURLImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      this.d = 1;
    }
    do
    {
      return;
      if (this.d == 1)
      {
        this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(paramDrawable);
        this.jdField_b_of_type_ComTencentImageURLImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
        this.d = 2;
        this.jdField_a_of_type_ComTencentImageURLImageView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
        return;
      }
    } while (this.d != 2);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramDrawable);
    this.jdField_a_of_type_ComTencentImageURLImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    this.d = 1;
    this.jdField_b_of_type_ComTencentImageURLImageView.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_b_of_type_AndroidViewAnimationAnimation)
    {
      if (this.d != 1) {
        break label25;
      }
      this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(null);
    }
    label25:
    while (this.d != 2) {
      return;
    }
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.d = 0;
    this.jdField_a_of_type_ComTencentImageURLImageView.clearAnimation();
    this.jdField_b_of_type_ComTencentImageURLImageView.clearAnimation();
    this.jdField_a_of_type_AndroidViewAnimationAnimation.reset();
    this.jdField_b_of_type_AndroidViewAnimationAnimation.reset();
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramDrawable);
    this.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(null);
  }
  
  public void setImageResource(int paramInt)
  {
    setImageDrawable(getResources().getDrawable(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TransitionImageView
 * JD-Core Version:    0.7.0.1
 */