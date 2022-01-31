package com.tencent.component.network.downloader;

import android.text.TextUtils;

public abstract class a
{
  public static final a a = new b((byte)0);
  
  static
  {
    new a((byte)0);
  }
  
  public abstract String a(String paramString);
  
  static class a
    extends a
  {
    public String a(String paramString)
    {
      String str = null;
      int i;
      if (a.a(paramString, "http://")) {
        i = paramString.indexOf("/", 7);
      }
      for (;;)
      {
        if (i != -1) {
          str = paramString.substring(i);
        }
        return str;
        if (a.a(paramString, "https://")) {
          i = paramString.indexOf("/", 8);
        } else {
          i = paramString.indexOf("/");
        }
      }
    }
  }
  
  static final class b
    extends a.a
  {
    private b()
    {
      super();
    }
    
    public final String a(String paramString)
    {
      paramString = super.a(paramString);
      if (TextUtils.isEmpty(paramString)) {}
      int i;
      do
      {
        return paramString;
        i = paramString.indexOf('#');
      } while (i <= 0);
      return paramString.substring(0, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.downloader.a
 * JD-Core Version:    0.7.0.1
 */