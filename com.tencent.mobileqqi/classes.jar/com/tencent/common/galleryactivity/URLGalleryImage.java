package com.tencent.common.galleryactivity;

import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import java.net.URL;

public abstract class URLGalleryImage
  extends GalleryImage
{
  public Drawable a()
  {
    return null;
  }
  
  public abstract URLDrawable a(Drawable paramDrawable1, Drawable paramDrawable2);
  
  public abstract URL a();
  
  @Deprecated
  public abstract boolean a();
  
  public abstract Drawable b();
  
  public abstract URLDrawable b(Drawable paramDrawable1, Drawable paramDrawable2);
  
  @Deprecated
  public abstract String b();
  
  public abstract URL b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.common.galleryactivity.URLGalleryImage
 * JD-Core Version:    0.7.0.1
 */