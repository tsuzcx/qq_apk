package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.widget.CompoundButtonCompat;
import android.support.v7.appcompat.R.styleable;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.widget.CompoundButton;

class AppCompatCompoundButtonHelper
{
  private ColorStateList mButtonTintList = null;
  private PorterDuff.Mode mButtonTintMode = null;
  private boolean mHasButtonTint = false;
  private boolean mHasButtonTintMode = false;
  private boolean mSkipNextApply;
  private final CompoundButton mView;
  
  AppCompatCompoundButtonHelper(CompoundButton paramCompoundButton)
  {
    this.mView = paramCompoundButton;
  }
  
  void applyButtonTint()
  {
    Drawable localDrawable = CompoundButtonCompat.getButtonDrawable(this.mView);
    if ((localDrawable != null) && ((this.mHasButtonTint) || (this.mHasButtonTintMode)))
    {
      localDrawable = DrawableCompat.wrap(localDrawable).mutate();
      if (this.mHasButtonTint) {
        DrawableCompat.setTintList(localDrawable, this.mButtonTintList);
      }
      if (this.mHasButtonTintMode) {
        DrawableCompat.setTintMode(localDrawable, this.mButtonTintMode);
      }
      if (localDrawable.isStateful()) {
        localDrawable.setState(this.mView.getDrawableState());
      }
      this.mView.setButtonDrawable(localDrawable);
    }
  }
  
  int getCompoundPaddingLeft(int paramInt)
  {
    int i = paramInt;
    if (Build.VERSION.SDK_INT < 17)
    {
      Drawable localDrawable = CompoundButtonCompat.getButtonDrawable(this.mView);
      i = paramInt;
      if (localDrawable != null) {
        i = paramInt + localDrawable.getIntrinsicWidth();
      }
    }
    return i;
  }
  
  ColorStateList getSupportButtonTintList()
  {
    return this.mButtonTintList;
  }
  
  PorterDuff.Mode getSupportButtonTintMode()
  {
    return this.mButtonTintMode;
  }
  
  void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = this.mView.getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.CompoundButton, paramInt, 0);
    try
    {
      if (paramAttributeSet.hasValue(R.styleable.CompoundButton_android_button))
      {
        paramInt = paramAttributeSet.getResourceId(R.styleable.CompoundButton_android_button, 0);
        if (paramInt != 0) {
          this.mView.setButtonDrawable(AppCompatResources.getDrawable(this.mView.getContext(), paramInt));
        }
      }
      if (paramAttributeSet.hasValue(R.styleable.CompoundButton_buttonTint)) {
        CompoundButtonCompat.setButtonTintList(this.mView, paramAttributeSet.getColorStateList(R.styleable.CompoundButton_buttonTint));
      }
      if (paramAttributeSet.hasValue(R.styleable.CompoundButton_buttonTintMode)) {
        CompoundButtonCompat.setButtonTintMode(this.mView, DrawableUtils.parseTintMode(paramAttributeSet.getInt(R.styleable.CompoundButton_buttonTintMode, -1), null));
      }
      return;
    }
    finally
    {
      paramAttributeSet.recycle();
    }
  }
  
  void onSetButtonDrawable()
  {
    if (this.mSkipNextApply)
    {
      this.mSkipNextApply = false;
      return;
    }
    this.mSkipNextApply = true;
    applyButtonTint();
  }
  
  void setSupportButtonTintList(ColorStateList paramColorStateList)
  {
    this.mButtonTintList = paramColorStateList;
    this.mHasButtonTint = true;
    applyButtonTint();
  }
  
  void setSupportButtonTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    this.mButtonTintMode = paramMode;
    this.mHasButtonTintMode = true;
    applyButtonTint();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatCompoundButtonHelper
 * JD-Core Version:    0.7.0.1
 */