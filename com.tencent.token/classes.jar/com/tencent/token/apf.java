package com.tencent.token;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable.Callback;
import android.text.TextUtils;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

public final class apf
{
  public avr a;
  private final Context b;
  private String c;
  private final Map<String, Object> d;
  
  public apf(Drawable.Callback paramCallback, String paramString, avr paramavr, Map<String, Object> paramMap)
  {
    this.c = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = this.c;
      if (paramString.charAt(paramString.length() - 1) != '/')
      {
        paramString = new StringBuilder();
        paramString.append(this.c);
        paramString.append('/');
        this.c = paramString.toString();
      }
    }
    if (!(paramCallback instanceof View))
    {
      this.d = new HashMap();
      this.b = null;
      return;
    }
    this.b = ((View)paramCallback).getContext();
    this.d = paramMap;
    this.a = paramavr;
  }
  
  public final Bitmap a(String paramString)
  {
    if ((this.a != null) && (this.d.get(paramString) != null))
    {
      avr localavr = this.a;
      this.d.get(paramString);
      return localavr.a();
    }
    return null;
  }
  
  public final boolean a(Context paramContext)
  {
    return ((paramContext == null) && (this.b == null)) || ((paramContext != null) && (this.b.equals(paramContext)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.apf
 * JD-Core Version:    0.7.0.1
 */