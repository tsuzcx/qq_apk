package com.tencent.mobileqq.extendfriend.wiget;

import afzc;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import aqdj;
import com.nineoldandroids.animation.AnimatorInflater;
import com.nineoldandroids.animation.AnimatorSet;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.mini.ui.RoundImageView;

public class MatchingView
  extends FrameLayout
{
  private View Cy;
  private AnimatorSet jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet;
  private RoundImageView jdField_a_of_type_ComTencentMobileqqMiniUiRoundImageView;
  private boolean cbU;
  private TextView jdField_do;
  private LottieDrawable j;
  
  public MatchingView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MatchingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MatchingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView(paramContext);
  }
  
  private void dea()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
    String str = ((QQAppInterface)localObject).getCurrentAccountUin();
    Drawable localDrawable = aqdj.g(1, 4);
    localObject = aqdj.a((AppInterface)localObject, 1, str, 1, localDrawable, localDrawable, null);
    this.jdField_a_of_type_ComTencentMobileqqMiniUiRoundImageView.setImageDrawable((Drawable)localObject);
  }
  
  private void deb()
  {
    ThreadManager.post(new MatchingView.1(this), 5, null, true);
  }
  
  private void initView(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131561336, this, true);
    this.jdField_a_of_type_ComTencentMobileqqMiniUiRoundImageView = ((RoundImageView)findViewById(2131371181));
    this.jdField_do = ((TextView)findViewById(2131371182));
    this.Cy = findViewById(2131371186);
    this.jdField_a_of_type_ComTencentMobileqqMiniUiRoundImageView.setBorderColor(-1);
    this.jdField_a_of_type_ComTencentMobileqqMiniUiRoundImageView.setBorderWidth(6);
    dea();
    deb();
  }
  
  public void Iw(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqMiniUiRoundImageView.setImageDrawable(null);
    this.jdField_do.setText(null);
    dea();
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_do.setText(paramString);
    }
  }
  
  public void dec()
  {
    this.cbU = false;
    if (this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet != null)
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet.cancel();
      this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet.end();
    }
    if (this.j != null) {
      this.j.endAnimation();
    }
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
  }
  
  public void oo()
  {
    if (this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet == null)
    {
      this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet = ((AnimatorSet)AnimatorInflater.loadAnimator(getContext(), 2130903040));
      this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet.setTarget(this.jdField_a_of_type_ComTencentMobileqqMiniUiRoundImageView);
      this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet.setStartDelay(1000L);
      this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet.addListener(new afzc(this));
    }
    if (this.j != null) {
      this.j.playAnimation();
    }
    this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet.start();
    this.cbU = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.MatchingView
 * JD-Core Version:    0.7.0.1
 */