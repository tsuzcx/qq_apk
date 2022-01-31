package com.tencent.mobileqq.profile.view.helper;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import eag;

public class ShakeEffectGenerator
{
  private static final int jdField_a_of_type_Int = 50;
  private static final int b = 80;
  private View jdField_a_of_type_AndroidViewView;
  private Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new eag(this);
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private boolean jdField_a_of_type_Boolean = false;
  private final int c;
  private final int d;
  private int e = 0;
  private int f = 0;
  
  public ShakeEffectGenerator(View paramView)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidViewView = paramView;
      this.c = a(15.0F);
      this.d = ((int)(this.c / 1.5D));
      return;
    }
    throw new IllegalArgumentException("Wrapped View shouldn't be null!");
  }
  
  private int a(float paramFloat)
  {
    return (int)(this.jdField_a_of_type_AndroidViewView.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.e = 0;
    this.f = 0;
    for (;;)
    {
      int j = (int)(this.d * (Math.random() * 2.0D - 1.0D));
      int i = (int)Math.sqrt(this.d * this.d - j * j);
      if (Math.random() > 0.5D) {}
      while ((this.e + j) * (this.e + j) + (this.f + i) * (this.f + i) <= this.c * this.c)
      {
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(this.e, this.e + j, this.f, this.f + i);
        this.e = (j + this.e);
        this.f = (i + this.f);
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(this.d * (int)(50.0D + Math.random() * 30.0D));
        this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
        this.jdField_a_of_type_AndroidViewView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
        return;
        i = -i;
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidViewView.getAnimation() == this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    if (a()) {
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.helper.ShakeEffectGenerator
 * JD-Core Version:    0.7.0.1
 */