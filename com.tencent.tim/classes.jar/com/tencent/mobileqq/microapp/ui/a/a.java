package com.tencent.mobileqq.microapp.ui.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.mobileqq.microapp.R.style;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public final class a
  extends ReportDialog
{
  private View a;
  private boolean b = false;
  
  public a(@NonNull Context paramContext)
  {
    super(paramContext, R.style.a);
  }
  
  private void a()
  {
    if (this.a == null) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(200L);
    localAnimationSet.setFillAfter(true);
    this.a.startAnimation(localAnimationSet);
  }
  
  private void b()
  {
    if (this.a == null) {
      return;
    }
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.addAnimation(localTranslateAnimation);
    localAnimationSet.addAnimation(localAlphaAnimation);
    localAnimationSet.setInterpolator(new DecelerateInterpolator());
    localAnimationSet.setDuration(200L);
    localAnimationSet.setFillAfter(true);
    localAnimationSet.setAnimationListener(new b(this));
    this.a.startAnimation(localAnimationSet);
  }
  
  public void dismiss()
  {
    if (this.b) {
      return;
    }
    b();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().getDecorView().setPadding(0, 0, 0, 0);
    paramBundle = getWindow().getAttributes();
    paramBundle.height = -2;
    paramBundle.gravity = 81;
    int i = d.b(getContext());
    int j = d.c(getContext());
    if (i < j) {}
    for (;;)
    {
      paramBundle.width = i;
      getWindow().setAttributes(paramBundle);
      setCanceledOnTouchOutside(true);
      return;
      i = j;
    }
  }
  
  public void setContentView(int paramInt)
  {
    this.a = LayoutInflater.from(getContext()).inflate(paramInt, null);
    super.setContentView(this.a);
  }
  
  public void setContentView(@NonNull View paramView)
  {
    this.a = paramView;
    super.setContentView(paramView);
  }
  
  public void setContentView(@NonNull View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    this.a = paramView;
    super.setContentView(paramView, paramLayoutParams);
  }
  
  public void show()
  {
    super.show();
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.ui.a.a
 * JD-Core Version:    0.7.0.1
 */