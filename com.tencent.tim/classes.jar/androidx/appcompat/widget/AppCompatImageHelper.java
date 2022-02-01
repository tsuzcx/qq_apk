package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.widget.ImageViewCompat;
import b.a;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class AppCompatImageHelper
{
  private TintInfo mImageTint;
  private TintInfo mInternalImageTint;
  private TintInfo mTmpInfo;
  private final ImageView mView;
  
  public AppCompatImageHelper(ImageView paramImageView)
  {
    this.mView = paramImageView;
  }
  
  private boolean applyFrameworkTintUsingColorFilter(@NonNull Drawable paramDrawable)
  {
    if (this.mTmpInfo == null) {
      this.mTmpInfo = new TintInfo();
    }
    TintInfo localTintInfo = this.mTmpInfo;
    localTintInfo.clear();
    Object localObject = ImageViewCompat.getImageTintList(this.mView);
    if (localObject != null)
    {
      localTintInfo.mHasTintList = true;
      localTintInfo.mTintList = ((ColorStateList)localObject);
    }
    localObject = ImageViewCompat.getImageTintMode(this.mView);
    if (localObject != null)
    {
      localTintInfo.mHasTintMode = true;
      localTintInfo.mTintMode = ((PorterDuff.Mode)localObject);
    }
    if ((localTintInfo.mHasTintList) || (localTintInfo.mHasTintMode))
    {
      AppCompatDrawableManager.tintDrawable(paramDrawable, localTintInfo, this.mView.getDrawableState());
      return true;
    }
    return false;
  }
  
  private boolean shouldApplyFrameworkTintUsingColorFilter()
  {
    int i = Build.VERSION.SDK_INT;
    if (i > 21) {
      if (this.mInternalImageTint == null) {}
    }
    while (i == 21)
    {
      return true;
      return false;
    }
    return false;
  }
  
  void applySupportImageTint()
  {
    Drawable localDrawable = this.mView.getDrawable();
    if (localDrawable != null) {
      DrawableUtils.fixDrawable(localDrawable);
    }
    if ((localDrawable == null) || ((shouldApplyFrameworkTintUsingColorFilter()) && (applyFrameworkTintUsingColorFilter(localDrawable)))) {}
    do
    {
      return;
      if (this.mImageTint != null)
      {
        AppCompatDrawableManager.tintDrawable(localDrawable, this.mImageTint, this.mView.getDrawableState());
        return;
      }
    } while (this.mInternalImageTint == null);
    AppCompatDrawableManager.tintDrawable(localDrawable, this.mInternalImageTint, this.mView.getDrawableState());
  }
  
  ColorStateList getSupportImageTintList()
  {
    if (this.mImageTint != null) {
      return this.mImageTint.mTintList;
    }
    return null;
  }
  
  PorterDuff.Mode getSupportImageTintMode()
  {
    if (this.mImageTint != null) {
      return this.mImageTint.mTintMode;
    }
    return null;
  }
  
  boolean hasOverlappingRendering()
  {
    Drawable localDrawable = this.mView.getBackground();
    return (Build.VERSION.SDK_INT < 21) || (!(localDrawable instanceof RippleDrawable));
  }
  
  public void loadFromAttributes(AttributeSet paramAttributeSet, int paramInt)
  {
    TintTypedArray localTintTypedArray = TintTypedArray.obtainStyledAttributes(this.mView.getContext(), paramAttributeSet, b.a.AppCompatImageView, paramInt, 0);
    try
    {
      Drawable localDrawable = this.mView.getDrawable();
      paramAttributeSet = localDrawable;
      if (localDrawable == null)
      {
        paramInt = localTintTypedArray.getResourceId(b.a.AppCompatImageView_srcCompat, -1);
        paramAttributeSet = localDrawable;
        if (paramInt != -1)
        {
          localDrawable = AppCompatResources.getDrawable(this.mView.getContext(), paramInt);
          paramAttributeSet = localDrawable;
          if (localDrawable != null)
          {
            this.mView.setImageDrawable(localDrawable);
            paramAttributeSet = localDrawable;
          }
        }
      }
      if (paramAttributeSet != null) {
        DrawableUtils.fixDrawable(paramAttributeSet);
      }
      if (localTintTypedArray.hasValue(b.a.AppCompatImageView_tint)) {
        ImageViewCompat.setImageTintList(this.mView, localTintTypedArray.getColorStateList(b.a.AppCompatImageView_tint));
      }
      if (localTintTypedArray.hasValue(b.a.AppCompatImageView_tintMode)) {
        ImageViewCompat.setImageTintMode(this.mView, DrawableUtils.parseTintMode(localTintTypedArray.getInt(b.a.AppCompatImageView_tintMode, -1), null));
      }
      return;
    }
    finally
    {
      localTintTypedArray.recycle();
    }
  }
  
  public void setImageResource(int paramInt)
  {
    if (paramInt != 0)
    {
      Drawable localDrawable = AppCompatResources.getDrawable(this.mView.getContext(), paramInt);
      if (localDrawable != null) {
        DrawableUtils.fixDrawable(localDrawable);
      }
      this.mView.setImageDrawable(localDrawable);
    }
    for (;;)
    {
      applySupportImageTint();
      return;
      this.mView.setImageDrawable(null);
    }
  }
  
  void setInternalImageTint(ColorStateList paramColorStateList)
  {
    if (paramColorStateList != null)
    {
      if (this.mInternalImageTint == null) {
        this.mInternalImageTint = new TintInfo();
      }
      this.mInternalImageTint.mTintList = paramColorStateList;
      this.mInternalImageTint.mHasTintList = true;
    }
    for (;;)
    {
      applySupportImageTint();
      return;
      this.mInternalImageTint = null;
    }
  }
  
  void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    if (this.mImageTint == null) {
      this.mImageTint = new TintInfo();
    }
    this.mImageTint.mTintList = paramColorStateList;
    this.mImageTint.mHasTintList = true;
    applySupportImageTint();
  }
  
  void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    if (this.mImageTint == null) {
      this.mImageTint = new TintInfo();
    }
    this.mImageTint.mTintMode = paramMode;
    this.mImageTint.mHasTintMode = true;
    applySupportImageTint();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatImageHelper
 * JD-Core Version:    0.7.0.1
 */