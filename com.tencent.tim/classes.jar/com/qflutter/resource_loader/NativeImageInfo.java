package com.qflutter.resource_loader;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;

public class NativeImageInfo
{
  public String assetsPath;
  public Bitmap bitmap;
  public Rect borderRadius;
  public byte[] bytes;
  public Integer color;
  public Drawable drawable;
  public int drawableId = 0;
  public boolean isNinePatch = false;
  public NinePatchInfo ninePatchInfo;
  public String path;
  public double scale;
  public String url;
  
  public boolean isNull()
  {
    return (this.drawableId == 0) && (TextUtils.isEmpty(this.path)) && (TextUtils.isEmpty(this.assetsPath)) && (this.bitmap == null) && (this.drawable == null) && (TextUtils.isEmpty(this.url)) && (this.color == null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.qflutter.resource_loader.NativeImageInfo
 * JD-Core Version:    0.7.0.1
 */