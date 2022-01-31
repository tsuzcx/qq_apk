package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.widget.ImageView;

class ImageViewCompat$BaseViewCompatImpl
  implements ImageViewCompat.ImageViewCompatImpl
{
  public ColorStateList getImageTintList(ImageView paramImageView)
  {
    if ((paramImageView instanceof TintableImageSourceView)) {
      return ((TintableImageSourceView)paramImageView).getSupportImageTintList();
    }
    return null;
  }
  
  public PorterDuff.Mode getImageTintMode(ImageView paramImageView)
  {
    if ((paramImageView instanceof TintableImageSourceView)) {
      return ((TintableImageSourceView)paramImageView).getSupportImageTintMode();
    }
    return null;
  }
  
  public void setImageTintList(ImageView paramImageView, ColorStateList paramColorStateList)
  {
    if ((paramImageView instanceof TintableImageSourceView)) {
      ((TintableImageSourceView)paramImageView).setSupportImageTintList(paramColorStateList);
    }
  }
  
  public void setImageTintMode(ImageView paramImageView, PorterDuff.Mode paramMode)
  {
    if ((paramImageView instanceof TintableImageSourceView)) {
      ((TintableImageSourceView)paramImageView).setSupportImageTintMode(paramMode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.ImageViewCompat.BaseViewCompatImpl
 * JD-Core Version:    0.7.0.1
 */