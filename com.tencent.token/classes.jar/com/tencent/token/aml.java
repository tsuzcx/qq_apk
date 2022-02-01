package com.tencent.token;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable.Callback;
import android.text.TextUtils;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

public final class aml
{
  public asu a;
  private final Context b;
  private String c;
  private final Map<String, Object> d;
  
  public aml(Drawable.Callback paramCallback, String paramString, asu paramasu, Map<String, Object> paramMap)
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
    this.a = paramasu;
  }
  
  public final Bitmap a(String paramString)
  {
    if ((this.a != null) && (this.d.get(paramString) != null))
    {
      asu localasu = this.a;
      this.d.get(paramString);
      return localasu.a();
    }
    return null;
  }
  
  public final boolean a(Context paramContext)
  {
    return ((paramContext == null) && (this.b == null)) || ((paramContext != null) && (this.b.equals(paramContext)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aml
 * JD-Core Version:    0.7.0.1
 */