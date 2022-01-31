package com.tencent.av.utils;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import bme;
import bmf;
import bmg;

public class RingAnimator
{
  static final int jdField_a_of_type_Int = 1;
  static final int jdField_b_of_type_Int = 2;
  static final int c = 3;
  static final int d = 9;
  static final int e = 10;
  Context jdField_a_of_type_AndroidContentContext = null;
  Handler jdField_a_of_type_AndroidOsHandler = null;
  Animation.AnimationListener jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
  Animation jdField_a_of_type_AndroidViewAnimationAnimation = null;
  ImageView jdField_a_of_type_AndroidWidgetImageView = null;
  public boolean a;
  Animation.AnimationListener jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener = null;
  public Animation b;
  public ImageView b;
  public Animation c;
  public ImageView c;
  
  public RingAnimator(Context paramContext, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3)
  {
    this.jdField_b_of_type_AndroidWidgetImageView = null;
    this.jdField_c_of_type_AndroidWidgetImageView = null;
    this.jdField_b_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_c_of_type_AndroidViewAnimationAnimation = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_AndroidWidgetImageView = paramImageView1;
    this.jdField_c_of_type_AndroidWidgetImageView = paramImageView2;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView3;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new bme(this);
    this.jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener = new bmf(this);
    this.jdField_a_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130968636);
    this.jdField_b_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130968643);
    this.jdField_c_of_type_AndroidViewAnimationAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130968642);
    this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
    this.jdField_c_of_type_AndroidViewAnimationAnimation.setAnimationListener(this.jdField_b_of_type_AndroidViewAnimationAnimation$AnimationListener);
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new bmg(this, Looper.getMainLooper());
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
    if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_c_of_type_AndroidWidgetImageView != null)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_c_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_b_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_c_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.av.utils.RingAnimator
 * JD-Core Version:    0.7.0.1
 */