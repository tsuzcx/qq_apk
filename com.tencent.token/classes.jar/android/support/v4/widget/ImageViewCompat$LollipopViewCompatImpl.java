package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.widget.ImageView;

@RequiresApi(21)
class ImageViewCompat$LollipopViewCompatImpl
  extends ImageViewCompat.BaseViewCompatImpl
{
  public ColorStateList getImageTintList(ImageView paramImageView)
  {
    return paramImageView.getImageTintList();
  }
  
  public PorterDuff.Mode getImageTintMode(ImageView paramImageView)
  {
    return paramImageView.getImageTintMode();
  }
  
  public void setImageTintList(ImageView paramImageView, ColorStateList paramColorStateList)
  {
    paramImageView.setImageTintList(paramColorStateList);
    if (Build.VERSION.SDK_INT == 21)
    {
      paramColorStateList = paramImageView.getDrawable();
      if ((paramImageView.getImageTintList() == null) || (paramImageView.getImageTintMode() == null)) {
        break label64;
      }
    }
    label64:
    for (int i = 1;; i = 0)
    {
      if ((paramColorStateList != null) && (i != 0))
      {
        if (paramColorStateList.isStateful()) {
          paramColorStateList.setState(paramImageView.getDrawableState());
        }
        paramImageView.setImageDrawable(paramColorStateList);
      }
      return;
    }
  }
  
  public void setImageTintMode(ImageView paramImageView, PorterDuff.Mode paramMode)
  {
    paramImageView.setImageTintMode(paramMode);
    if (Build.VERSION.SDK_INT == 21)
    {
      paramMode = paramImageView.getDrawable();
      if ((paramImageView.getImageTintList() == null) || (paramImageView.getImageTintMode() == null)) {
        break label64;
      }
    }
    label64:
    for (int i = 1;; i = 0)
    {
      if ((paramMode != null) && (i != 0))
      {
        if (paramMode.isStateful()) {
          paramMode.setState(paramImageView.getDrawableState());
        }
        paramImageView.setImageDrawable(paramMode);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.ImageViewCompat.LollipopViewCompatImpl
 * JD-Core Version:    0.7.0.1
 */