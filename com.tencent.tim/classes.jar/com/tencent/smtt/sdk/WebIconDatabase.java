package com.tencent.smtt.sdk;

import android.content.ContentResolver;
import android.graphics.Bitmap;

@Deprecated
public class WebIconDatabase
{
  private static WebIconDatabase a;
  
  private static WebIconDatabase a()
  {
    try
    {
      if (a == null) {
        a = new WebIconDatabase();
      }
      WebIconDatabase localWebIconDatabase = a;
      return localWebIconDatabase;
    }
    finally {}
  }
  
  public static WebIconDatabase getInstance()
  {
    return a();
  }
  
  public void bulkRequestIconForPageUrl(ContentResolver paramContentResolver, String paramString, a parama) {}
  
  public void close()
  {
    y localy = y.a();
    if ((localy != null) && (localy.b()))
    {
      localy.c().m();
      return;
    }
    android.webkit.WebIconDatabase.getInstance().close();
  }
  
  public void open(String paramString)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b()))
    {
      localy.c().b(paramString);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().open(paramString);
  }
  
  public void releaseIconForPageUrl(String paramString)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b()))
    {
      localy.c().d(paramString);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().releaseIconForPageUrl(paramString);
  }
  
  public void removeAllIcons()
  {
    y localy = y.a();
    if ((localy != null) && (localy.b()))
    {
      localy.c().l();
      return;
    }
    android.webkit.WebIconDatabase.getInstance().removeAllIcons();
  }
  
  public void requestIconForPageUrl(String paramString, a parama)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b()))
    {
      localy.c().a(paramString, new WebIconDatabase.1(this, parama));
      return;
    }
    android.webkit.WebIconDatabase.getInstance().requestIconForPageUrl(paramString, new WebIconDatabase.2(this, parama));
  }
  
  public void retainIconForPageUrl(String paramString)
  {
    y localy = y.a();
    if ((localy != null) && (localy.b()))
    {
      localy.c().c(paramString);
      return;
    }
    android.webkit.WebIconDatabase.getInstance().retainIconForPageUrl(paramString);
  }
  
  @Deprecated
  public static abstract interface a
  {
    public abstract void a(String paramString, Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebIconDatabase
 * JD-Core Version:    0.7.0.1
 */