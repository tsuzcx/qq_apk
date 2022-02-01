package com.tencent.mobileqq.emoticonview;

import afmg;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aqnm;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;

public class EmoticonGuideBubbleView
  extends LinearLayout
{
  protected View BN;
  protected Drawable ev;
  protected Context mContext;
  
  public EmoticonGuideBubbleView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    setOrientation(1);
    setGravity(8388613);
    setVisibility(8);
  }
  
  private int a(LinearLayout paramLinearLayout, ImageView paramImageView, int paramInt, boolean paramBoolean)
  {
    int j = paramLinearLayout.getRight();
    paramLinearLayout = new int[2];
    this.BN.getLocationOnScreen(paramLinearLayout);
    int i = this.BN.getWidth();
    paramImageView.measure(0, 0);
    if (paramBoolean) {}
    for (paramInt = j - (paramLinearLayout[0] - aqnm.dip2px(20.0F)) - paramImageView.getMeasuredWidth() / 4 - paramInt;; paramInt = j - paramLinearLayout[0] - i / 2 - paramImageView.getMeasuredWidth() / 4 - paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonGuideBubbleView", 2, new Object[] { "calcArrowOffset arrowOffset:", Integer.valueOf(paramInt), " ,eW:", Integer.valueOf(i), " ,eLX:", Integer.valueOf(paramLinearLayout[0]) });
      }
      return ho(paramInt);
    }
  }
  
  private int c(View paramView, boolean paramBoolean)
  {
    int i = paramView.getRight();
    paramView = new int[2];
    this.BN.getLocationOnScreen(paramView);
    int j = this.BN.getWidth();
    measure(0, 0);
    int k = getMeasuredWidth();
    if (paramBoolean) {}
    for (i = i - (paramView[0] - aqnm.dip2px(20.0F)) - k / 2;; i = i - (paramView[0] + j / 2) - k / 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonGuideBubbleView", 2, new Object[] { "calcOffset offset:", Integer.valueOf(i), " ,bW:", Integer.valueOf(k), " ,eW:", Integer.valueOf(j), " ,eLX:", Integer.valueOf(paramView[0]) });
      }
      return ho(i);
    }
  }
  
  private int ho(int paramInt)
  {
    int i;
    if (paramInt > 0)
    {
      i = paramInt;
      if (getMeasuredWidth() + paramInt < aqnm.getScreenWidth()) {}
    }
    else
    {
      i = aqnm.dip2px(6.0F);
    }
    return i;
  }
  
  protected Drawable a(String paramString, Drawable paramDrawable, boolean paramBoolean)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    if (paramDrawable == null)
    {
      if (this.ev == null) {
        this.ev = new ColorDrawable(0);
      }
      localURLDrawableOptions.mLoadingDrawable = this.ev;
    }
    for (localURLDrawableOptions.mFailedDrawable = this.ev;; localURLDrawableOptions.mFailedDrawable = paramDrawable)
    {
      localURLDrawableOptions.mPlayGifImage = paramBoolean;
      return a(paramString, localURLDrawableOptions);
      localURLDrawableOptions.mLoadingDrawable = paramDrawable;
    }
  }
  
  protected URLDrawable a(String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    return URLDrawable.getDrawable(paramString, paramURLDrawableOptions);
  }
  
  public boolean a(RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramRelativeLayout == null) || (paramLinearLayout == null) || (TextUtils.isEmpty(paramString)) || (paramInt1 <= 0) || (paramInt2 <= 0)) {
      return false;
    }
    if (getVisibility() == 0)
    {
      z(paramRelativeLayout);
      return false;
    }
    if (paramBoolean) {
      this.BN = paramRelativeLayout.findViewById(2131367818);
    }
    while (this.BN == null)
    {
      return false;
      this.BN = paramLinearLayout.findViewById(2131374752);
      if (this.BN == null) {
        this.BN = paramLinearLayout.findViewById(2131374753);
      }
    }
    View localView = paramRelativeLayout.findViewById(2131369277);
    if (localView == null) {
      return false;
    }
    removeAllViews();
    ImageView localImageView = new ImageView(this.mContext);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    paramString = a(paramString, null, true);
    if (((paramString instanceof URLDrawable)) && (QLog.isColorLevel())) {
      QLog.d("EmoticonGuideBubbleView", 2, "showGuideBubble drawable status: " + ((URLDrawable)paramString).getStatus());
    }
    localImageView.setImageDrawable(paramString);
    paramInt1 = aqnm.dip2px(paramInt1 / 2);
    int i = aqnm.dip2px(paramInt2 / 2);
    if (paramInt1 >= aqnm.getScreenWidth()) {
      paramInt2 = aqnm.getScreenWidth() / 2;
    }
    for (paramInt1 = i * paramInt2 / paramInt1;; paramInt1 = i)
    {
      localImageView.setLayoutParams(new ViewGroup.LayoutParams(paramInt2, paramInt1));
      localImageView.setBackgroundResource(2130838093);
      addView(localImageView);
      setVisibility(0);
      paramString = new AlphaAnimation(0.0F, 1.0F);
      setAnimation(paramString);
      paramString.setDuration(500L);
      paramString.setFillAfter(true);
      startAnimation(paramString);
      paramString = new RelativeLayout.LayoutParams(-2, -2);
      paramString.addRule(2, 2131369277);
      paramString.addRule(7, 2131369277);
      paramInt1 = c(paramLinearLayout, paramBoolean);
      if (paramInt1 > 0)
      {
        paramString.rightMargin = paramInt1;
        localImageView = new ImageView(this.mContext);
        localImageView.setImageDrawable(getResources().getDrawable(2130840182));
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(aqnm.dip2px(13.0F), aqnm.dip2px(8.0F));
        localLayoutParams.gravity = 8388613;
        localLayoutParams.rightMargin = a(paramLinearLayout, localImageView, paramInt1, paramBoolean);
        localLayoutParams.topMargin = (-aqnm.dip2px(1.0F));
        localImageView.setLayoutParams(localLayoutParams);
        addView(localImageView);
        paramString.bottomMargin = (-localView.getPaddingTop());
      }
      paramRelativeLayout.addView(this, paramString);
      return true;
      paramInt2 = paramInt1;
    }
  }
  
  public void z(RelativeLayout paramRelativeLayout)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonGuideBubbleView", 2, "removeGuideBubble ");
    }
    if ((paramRelativeLayout == null) || (getVisibility() == 8)) {
      return;
    }
    setVisibility(8);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    setAnimation(localAlphaAnimation);
    localAlphaAnimation.setDuration(500L);
    localAlphaAnimation.setFillAfter(true);
    startAnimation(localAlphaAnimation);
    localAlphaAnimation.setAnimationListener(new afmg(this));
    paramRelativeLayout.removeView(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonGuideBubbleView
 * JD-Core Version:    0.7.0.1
 */