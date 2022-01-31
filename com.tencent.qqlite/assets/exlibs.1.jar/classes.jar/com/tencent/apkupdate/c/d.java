package com.tencent.apkupdate.c;

import android.text.TextUtils;

public final class d
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private int g;
  private int h;
  private int i;
  
  public final String a()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("0");
    ((StringBuffer)localObject).append(this.b.subSequence(0, 1));
    ((StringBuffer)localObject).append(this.c);
    localObject = ((StringBuffer)localObject).toString();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("TMASDK_");
    localStringBuffer.append(this.b);
    if (!TextUtils.isEmpty(this.d))
    {
      localStringBuffer.append("_");
      localStringBuffer.append(this.d);
    }
    localStringBuffer.append("/");
    localStringBuffer.append((String)localObject);
    localStringBuffer.append("&NA/");
    localStringBuffer.append((String)localObject);
    localStringBuffer.append("&");
    localStringBuffer.append(this.f);
    localStringBuffer.append("_");
    localStringBuffer.append(this.i);
    localStringBuffer.append("&");
    localStringBuffer.append(this.g / 16);
    localStringBuffer.append("_");
    localStringBuffer.append(this.h / 16);
    localStringBuffer.append("_");
    localStringBuffer.append("14&");
    localStringBuffer.append(this.a);
    localStringBuffer.append("&");
    localStringBuffer.append(this.e);
    localStringBuffer.append("&");
    localStringBuffer.append("NA");
    localStringBuffer.append("&");
    localStringBuffer.append("V3");
    return localStringBuffer.toString();
  }
  
  public final void a(int paramInt)
  {
    this.g = paramInt;
  }
  
  public final void a(String paramString)
  {
    this.a = paramString;
  }
  
  public final void b(int paramInt)
  {
    this.h = paramInt;
  }
  
  public final void b(String paramString)
  {
    this.b = paramString;
  }
  
  public final void c(int paramInt)
  {
    this.i = 0;
  }
  
  public final void c(String paramString)
  {
    this.c = paramString;
  }
  
  public final void d(String paramString)
  {
    this.d = paramString;
  }
  
  public final void e(String paramString)
  {
    this.e = paramString;
  }
  
  public final void f(String paramString)
  {
    this.f = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.apkupdate.c.d
 * JD-Core Version:    0.7.0.1
 */