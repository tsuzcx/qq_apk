package com.tencent.tmassistantsdk.f;

import android.text.TextUtils;

public final class i
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public int g;
  public int h;
  public int i;
  
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.f.i
 * JD-Core Version:    0.7.0.1
 */