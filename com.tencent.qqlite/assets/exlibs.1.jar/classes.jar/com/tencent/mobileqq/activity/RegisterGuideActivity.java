package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import bhe;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppActivity;

public class RegisterGuideActivity
  extends AppActivity
  implements View.OnClickListener
{
  private static final float jdField_a_of_type_Float = 0.95F;
  private static final int jdField_a_of_type_Int = 800;
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private boolean jdField_a_of_type_Boolean = false;
  
  private void a()
  {
    int i = (int)(getResources().getDisplayMetrics().heightPixels * 0.15F);
    int j = getResources().getDimensionPixelSize(2131493095);
    this.jdField_a_of_type_AndroidViewView.getLayoutParams().height = Math.max(i, j);
    this.jdField_a_of_type_AndroidViewView.requestLayout();
  }
  
  private void b()
  {
    try
    {
      BitmapDrawable localBitmapDrawable = new BitmapDrawable(super.getResources(), super.getAssets().open("splash.png"));
      if (localBitmapDrawable != null)
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localBitmapDrawable);
        int i = super.getResources().getDisplayMetrics().widthPixels;
        int j = super.getResources().getDisplayMetrics().heightPixels;
        int k = localBitmapDrawable.getIntrinsicHeight() * i / localBitmapDrawable.getIntrinsicWidth();
        this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(new RelativeLayout.LayoutParams(i, k));
        if (k <= j)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.FIT_XY);
          return;
        }
        if (k > j)
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void c()
  {
    AnimationSet localAnimationSet = new AnimationSet(true);
    Object localObject = new ScaleAnimation(1.0F, 0.95F, 1.0F, 0.95F, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setDuration(800L);
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -(this.jdField_a_of_type_AndroidViewView.getHeight() / 2));
    localTranslateAnimation.setDuration(800L);
    localAnimationSet.addAnimation((Animation)localObject);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.setFillAfter(true);
    localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    ((Animation)localObject).setDuration(800L);
    ((Animation)localObject).setFillBefore(true);
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localAnimationSet);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
  }
  
  protected void doOnBackPressed()
  {
    finish();
    if ((getAppRuntime() instanceof QQAppInterface)) {
      ((QQAppInterface)super.getAppRuntime()).b(false);
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    super.doOnCreate(paramBundle);
    super.setContentView(2130903226);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131297258));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131297259);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    a();
    b();
    super.findViewById(2131297260).setOnClickListener(this);
    super.findViewById(2131297261).setOnClickListener(this);
    return true;
  }
  
  public void doOnWindowFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      new Handler().post(new bhe(this));
    }
  }
  
  public void finish()
  {
    super.finish();
    com.tencent.common.app.BaseApplicationImpl.d = System.currentTimeMillis() - this.jdField_a_of_type_Long;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297260: 
      paramView = new Intent(this, LoginActivity.class);
      paramView.addFlags(67108864);
      paramView.putExtra("from_register_guide", true);
      super.startActivity(paramView);
      finish();
      return;
    }
    paramView = new Intent(this, RegisterPhoneNumActivity.class);
    paramView.putExtra("leftViewText", super.getString(2131363113));
    paramView.addFlags(67108864);
    super.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterGuideActivity
 * JD-Core Version:    0.7.0.1
 */