package com.tencent.qqmini.miniapp.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.qqmini.sdk.widget.CoverView;

public class CoverImageView
  extends CoverView
{
  private ImageView imageView;
  
  public CoverImageView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.imageView = new ImageView(paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    this.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
    addView(this.imageView, paramContext);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.imageView.setImageBitmap(paramBitmap);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.imageView.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.CoverImageView
 * JD-Core Version:    0.7.0.1
 */