package com.tencent.viola.commons;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageAdapterHolder
{
  public static String BUNDLE_HEIGHT = "bundle_img_real_height";
  public static String BUNDLE_WIDTH = "bundle_img_real_width";
  private ImageListener mImageListener;
  private ImgSpanListener mImgSpanListener;
  
  public ImageListener getImageListener()
  {
    return this.mImageListener;
  }
  
  public ImgSpanListener getImgSpanListener()
  {
    return this.mImgSpanListener;
  }
  
  public void setImageListener(ImageListener paramImageListener)
  {
    this.mImageListener = paramImageListener;
  }
  
  public void setImgSpanListener(ImgSpanListener paramImgSpanListener)
  {
    this.mImgSpanListener = paramImgSpanListener;
  }
  
  public static abstract interface ImageListener
  {
    public abstract void onImageFinish(String paramString, ImageView paramImageView, boolean paramBoolean, Bundle paramBundle);
  }
  
  public static abstract interface ImgSpanListener
  {
    public abstract void onSpanFInish(String paramString, Drawable paramDrawable, boolean paramBoolean, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.viola.commons.ImageAdapterHolder
 * JD-Core Version:    0.7.0.1
 */