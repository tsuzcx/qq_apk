package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.widget.TintableCompoundButton;
import android.support.v7.appcompat.R.attr;
import android.support.v7.content.res.AppCompatResources;
import android.util.AttributeSet;
import android.widget.CheckBox;

public class AppCompatCheckBox
  extends CheckBox
  implements TintableCompoundButton
{
  private final AppCompatCompoundButtonHelper mCompoundButtonHelper = new AppCompatCompoundButtonHelper(this);
  
  public AppCompatCheckBox(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppCompatCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.checkboxStyle);
  }
  
  public AppCompatCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(TintContextWrapper.wrap(paramContext), paramAttributeSet, paramInt);
    this.mCompoundButtonHelper.loadFromAttributes(paramAttributeSet, paramInt);
  }
  
  public int getCompoundPaddingLeft()
  {
    int j = super.getCompoundPaddingLeft();
    int i = j;
    if (this.mCompoundButtonHelper != null) {
      i = this.mCompoundButtonHelper.getCompoundPaddingLeft(j);
    }
    return i;
  }
  
  @Nullable
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public ColorStateList getSupportButtonTintList()
  {
    if (this.mCompoundButtonHelper != null) {
      return this.mCompoundButtonHelper.getSupportButtonTintList();
    }
    return null;
  }
  
  @Nullable
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public PorterDuff.Mode getSupportButtonTintMode()
  {
    if (this.mCompoundButtonHelper != null) {
      return this.mCompoundButtonHelper.getSupportButtonTintMode();
    }
    return null;
  }
  
  public void setButtonDrawable(@DrawableRes int paramInt)
  {
    setButtonDrawable(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  public void setButtonDrawable(Drawable paramDrawable)
  {
    super.setButtonDrawable(paramDrawable);
    if (this.mCompoundButtonHelper != null) {
      this.mCompoundButtonHelper.onSetButtonDrawable();
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setSupportButtonTintList(@Nullable ColorStateList paramColorStateList)
  {
    if (this.mCompoundButtonHelper != null) {
      this.mCompoundButtonHelper.setSupportButtonTintList(paramColorStateList);
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setSupportButtonTintMode(@Nullable PorterDuff.Mode paramMode)
  {
    if (this.mCompoundButtonHelper != null) {
      this.mCompoundButtonHelper.setSupportButtonTintMode(paramMode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.AppCompatCheckBox
 * JD-Core Version:    0.7.0.1
 */