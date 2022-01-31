package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

public class ImageViewCompat
{
  static final ImageViewCompat.ImageViewCompatImpl IMPL = new ImageViewCompat.BaseViewCompatImpl();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      IMPL = new ImageViewCompat.LollipopViewCompatImpl();
      return;
    }
  }
  
  @Nullable
  public static ColorStateList getImageTintList(@NonNull ImageView paramImageView)
  {
    return IMPL.getImageTintList(paramImageView);
  }
  
  @Nullable
  public static PorterDuff.Mode getImageTintMode(@NonNull ImageView paramImageView)
  {
    return IMPL.getImageTintMode(paramImageView);
  }
  
  public static void setImageTintList(@NonNull ImageView paramImageView, @Nullable ColorStateList paramColorStateList)
  {
    IMPL.setImageTintList(paramImageView, paramColorStateList);
  }
  
  public static void setImageTintMode(@NonNull ImageView paramImageView, @Nullable PorterDuff.Mode paramMode)
  {
    IMPL.setImageTintMode(paramImageView, paramMode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.ImageViewCompat
 * JD-Core Version:    0.7.0.1
 */