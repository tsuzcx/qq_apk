package com.tencent.smtt.export.external.interfaces;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public abstract interface IX5WebHistoryItem
{
  public abstract boolean canDrawBaseLayer();
  
  public abstract boolean drawBaseLayer(Canvas paramCanvas, boolean paramBoolean);
  
  public abstract Object getCustomData();
  
  public abstract Bitmap getFavicon();
  
  public abstract int getId();
  
  public abstract boolean getIsSubmitForm();
  
  public abstract String getOriginalUrl();
  
  public abstract String getTitle();
  
  public abstract String getTouchIconUrl();
  
  public abstract String getUrl();
  
  public abstract void setCustomData(Object paramObject);
  
  public abstract void setFavicon(Bitmap paramBitmap);
  
  public abstract void setUrl(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem
 * JD-Core Version:    0.7.0.1
 */