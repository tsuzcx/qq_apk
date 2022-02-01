package com.tencent.mobileqq.extendfriend.pulltorefresh.internal;

import afxl;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.extendfriend.pulltorefresh.LoadingLayoutBase;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Mode;
import com.tencent.mobileqq.extendfriend.pulltorefresh.PullToRefreshBase.Orientation;

@SuppressLint({"ViewConstructor"})
public abstract class LoadingLayout
  extends LoadingLayoutBase
{
  static final Interpolator k = new LinearInterpolator();
  private CharSequence P;
  private CharSequence Q;
  private CharSequence R;
  private CharSequence S;
  protected final ProgressBar Z;
  protected final PullToRefreshBase.Mode a;
  protected final PullToRefreshBase.Orientation a;
  private FrameLayout bC;
  private boolean cbF;
  protected final ImageView gl;
  private final TextView mHeaderText;
  private final TextView mv;
  
  public LoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Mode = paramMode;
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Orientation = paramOrientation;
    FrameLayout.LayoutParams localLayoutParams;
    int i;
    switch (afxk.le[paramOrientation.ordinal()])
    {
    default: 
      LayoutInflater.from(paramContext).inflate(2131559795, this);
      this.bC = ((FrameLayout)findViewById(2131367178));
      this.mHeaderText = ((TextView)this.bC.findViewById(2131373855));
      this.Z = ((ProgressBar)this.bC.findViewById(2131373853));
      this.mv = ((TextView)this.bC.findViewById(2131373854));
      this.gl = ((ImageView)this.bC.findViewById(2131373850));
      localLayoutParams = (FrameLayout.LayoutParams)this.bC.getLayoutParams();
      switch (afxk.lg[paramMode.ordinal()])
      {
      default: 
        if (paramOrientation == PullToRefreshBase.Orientation.VERTICAL)
        {
          i = 80;
          label179:
          localLayoutParams.gravity = i;
          this.P = paramContext.getString(2131697492);
          this.Q = paramContext.getString(2131697493);
          this.R = paramContext.getString(2131697494);
          if (paramTypedArray.hasValue(7))
          {
            paramOrientation = paramTypedArray.getDrawable(7);
            if (paramOrientation != null) {
              afxl.setBackground(this, paramOrientation);
            }
          }
          if (paramTypedArray.hasValue(11))
          {
            paramOrientation = new TypedValue();
            paramTypedArray.getValue(11, paramOrientation);
            setTextAppearance(paramOrientation.data);
          }
          if (paramTypedArray.hasValue(21))
          {
            paramOrientation = new TypedValue();
            paramTypedArray.getValue(21, paramOrientation);
            ND(paramOrientation.data);
          }
          if (paramTypedArray.hasValue(12))
          {
            paramOrientation = paramTypedArray.getColorStateList(12);
            if (paramOrientation != null) {
              setTextColor(paramOrientation);
            }
          }
          if (paramTypedArray.hasValue(10))
          {
            paramOrientation = paramTypedArray.getColorStateList(10);
            if (paramOrientation != null) {
              setSubTextColor(paramOrientation);
            }
          }
          paramOrientation = null;
          if (paramTypedArray.hasValue(2)) {
            paramOrientation = paramTypedArray.getDrawable(2);
          }
          switch (afxk.lg[paramMode.ordinal()])
          {
          default: 
            if (paramTypedArray.hasValue(5)) {
              paramMode = paramTypedArray.getDrawable(5);
            }
            break;
          }
        }
        break;
      }
      break;
    }
    for (;;)
    {
      paramOrientation = paramMode;
      if (paramMode == null) {
        paramOrientation = paramContext.getResources().getDrawable(DQ());
      }
      setLoadingDrawable(paramOrientation);
      reset();
      return;
      LayoutInflater.from(paramContext).inflate(2131559794, this);
      break;
      if (paramOrientation == PullToRefreshBase.Orientation.VERTICAL) {}
      for (i = 48;; i = 3)
      {
        localLayoutParams.gravity = i;
        this.P = paramContext.getString(2131697489);
        this.Q = paramContext.getString(2131697490);
        this.R = paramContext.getString(2131697491);
        break;
      }
      i = 5;
      break label179;
      paramMode = paramOrientation;
      if (paramTypedArray.hasValue(6))
      {
        paramMode = paramTypedArray.getDrawable(6);
        continue;
        if (paramTypedArray.hasValue(4))
        {
          paramMode = paramTypedArray.getDrawable(4);
        }
        else
        {
          paramMode = paramOrientation;
          if (paramTypedArray.hasValue(3)) {
            paramMode = paramTypedArray.getDrawable(3);
          }
        }
      }
    }
  }
  
  private void ND(int paramInt)
  {
    if (this.mv != null) {
      this.mv.setTextAppearance(getContext(), paramInt);
    }
  }
  
  private void setSubHeaderText(CharSequence paramCharSequence)
  {
    if (this.mv != null) {
      this.mv.setText(paramCharSequence);
    }
  }
  
  private void setSubTextColor(ColorStateList paramColorStateList)
  {
    if (this.mv != null) {
      this.mv.setTextColor(paramColorStateList);
    }
  }
  
  private void setTextAppearance(int paramInt)
  {
    if (this.mHeaderText != null) {
      this.mHeaderText.setTextAppearance(getContext(), paramInt);
    }
    if (this.mv != null) {
      this.mv.setTextAppearance(getContext(), paramInt);
    }
  }
  
  private void setTextColor(ColorStateList paramColorStateList)
  {
    if (this.mHeaderText != null) {
      this.mHeaderText.setTextColor(paramColorStateList);
    }
    if (this.mv != null) {
      this.mv.setTextColor(paramColorStateList);
    }
  }
  
  public final int DL()
  {
    switch (afxk.le[this.jdField_a_of_type_ComTencentMobileqqExtendfriendPulltorefreshPullToRefreshBase$Orientation.ordinal()])
    {
    default: 
      return this.bC.getHeight();
    }
    return this.bC.getWidth();
  }
  
  protected abstract int DQ();
  
  protected abstract void T(Drawable paramDrawable);
  
  protected abstract void aM(float paramFloat);
  
  public final void ajO()
  {
    if (this.mHeaderText != null) {
      this.mHeaderText.setText(this.R);
    }
    ddK();
  }
  
  public final void akJ()
  {
    if (this.mHeaderText != null) {
      this.mHeaderText.setText(this.Q);
    }
    if (this.cbF) {
      ((AnimationDrawable)this.gl.getDrawable()).start();
    }
    for (;;)
    {
      if (this.mv != null) {
        this.mv.setVisibility(8);
      }
      return;
      ddJ();
    }
  }
  
  public final void dbw()
  {
    if (this.mHeaderText != null) {
      this.mHeaderText.setText(this.S);
    }
    if (this.Z != null) {
      this.Z.setVisibility(4);
    }
  }
  
  protected abstract void ddI();
  
  protected abstract void ddJ();
  
  protected abstract void ddK();
  
  protected abstract void ddL();
  
  public final void onPull(float paramFloat)
  {
    if (!this.cbF) {
      aM(paramFloat);
    }
  }
  
  public final void pullToRefresh()
  {
    reset();
    if (this.mHeaderText != null) {
      this.mHeaderText.setText(this.P);
    }
    ddI();
  }
  
  public final void reset()
  {
    if (this.mHeaderText != null) {
      this.mHeaderText.setText(this.P);
    }
    this.gl.setVisibility(0);
    if (this.cbF) {
      ((AnimationDrawable)this.gl.getDrawable()).stop();
    }
    for (;;)
    {
      if (this.mv != null)
      {
        if (!TextUtils.isEmpty(this.mv.getText())) {
          break;
        }
        this.mv.setVisibility(8);
      }
      return;
      ddL();
    }
    this.mv.setVisibility(0);
  }
  
  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    setSubHeaderText(paramCharSequence);
  }
  
  public final void setLoadingDrawable(Drawable paramDrawable)
  {
    this.gl.setImageDrawable(paramDrawable);
    this.cbF = (paramDrawable instanceof AnimationDrawable);
    T(paramDrawable);
  }
  
  public void setPullLabel(CharSequence paramCharSequence)
  {
    this.P = paramCharSequence;
  }
  
  public void setRefreshResultLabel(CharSequence paramCharSequence)
  {
    this.S = paramCharSequence;
  }
  
  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    this.Q = paramCharSequence;
  }
  
  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    this.R = paramCharSequence;
  }
  
  public void setTextTypeface(Typeface paramTypeface)
  {
    this.mHeaderText.setTypeface(paramTypeface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.pulltorefresh.internal.LoadingLayout
 * JD-Core Version:    0.7.0.1
 */