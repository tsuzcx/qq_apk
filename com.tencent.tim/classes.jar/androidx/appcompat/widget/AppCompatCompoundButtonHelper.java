package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;
import b.a;

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
    i = 0;
    paramAttributeSet = this.mView.getContext().obtainStyledAttributes(paramAttributeSet, b.a.CompoundButton, paramInt, 0);
    paramInt = i;
    try
    {
      if (paramAttributeSet.hasValue(b.a.CompoundButton_buttonCompat))
      {
        j = paramAttributeSet.getResourceId(b.a.CompoundButton_buttonCompat, 0);
        paramInt = i;
        if (j == 0) {}
      }
    }
    finally
    {
      int j;
      label69:
      paramAttributeSet.recycle();
    }
    try
    {
      this.mView.setButtonDrawable(AppCompatResources.getDrawable(this.mView.getContext(), j));
      paramInt = 1;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      paramInt = i;
      break label69;
    }
    if ((paramInt == 0) && (paramAttributeSet.hasValue(b.a.CompoundButton_android_button)))
    {
      paramInt = paramAttributeSet.getResourceId(b.a.CompoundButton_android_button, 0);
      if (paramInt != 0) {
        this.mView.setButtonDrawable(AppCompatResources.getDrawable(this.mView.getContext(), paramInt));
      }
    }
    if (paramAttributeSet.hasValue(b.a.CompoundButton_buttonTint)) {
      CompoundButtonCompat.setButtonTintList(this.mView, paramAttributeSet.getColorStateList(b.a.CompoundButton_buttonTint));
    }
    if (paramAttributeSet.hasValue(b.a.CompoundButton_buttonTintMode)) {
      CompoundButtonCompat.setButtonTintMode(this.mView, DrawableUtils.parseTintMode(paramAttributeSet.getInt(b.a.CompoundButton_buttonTintMode, -1), null));
    }
    paramAttributeSet.recycle();
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
  
  static abstract interface DirectSetButtonDrawableInterface
  {
    public abstract void setButtonDrawable(Drawable paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatCompoundButtonHelper
 * JD-Core Version:    0.7.0.1
 */