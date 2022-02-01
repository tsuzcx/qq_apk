package com.tencent.map.sdk.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class y
  implements u
{
  public String a;
  public byte[] b;
  public Map<String, String> c;
  public boolean d = false;
  public boolean e = true;
  public int f = -1;
  public String g = "";
  public s h;
  public au i;
  public volatile boolean j = false;
  public int k = 0;
  public boolean l = true;
  CountDownLatch m = new CountDownLatch(1);
  public volatile boolean n = false;
  public String o;
  private Object p;
  private int q = 0;
  private bh r;
  
  public y(String paramString, byte[] paramArrayOfByte)
  {
    this.a = paramString;
    this.b = paramArrayOfByte;
    this.g = dg.d();
  }
  
  public final void a()
  {
    this.j = true;
    if (this.i != null) {
      this.i.b();
    }
  }
  
  public final void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public final void a(bh parambh)
  {
    try
    {
      this.r = parambh;
      return;
    }
    finally
    {
      parambh = finally;
      throw parambh;
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (this.c == null) {
      this.c = new HashMap();
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      this.c.put(paramString1, paramString2);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public final void b(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    this.k = paramInt;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public final boolean b()
  {
    try
    {
      boolean bool = this.m.await(this.k, TimeUnit.MILLISECONDS);
      return bool;
    }
    catch (InterruptedException localInterruptedException) {}
    return true;
  }
  
  public final bh c()
  {
    try
    {
      bh localbh = this.r;
      return localbh;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("url:" + this.a);
    localStringBuilder.append(",body:" + dg.b(this.b));
    localStringBuilder.append(",isGet:" + this.d);
    localStringBuilder.append(",timeout:" + this.f);
    localStringBuilder.append(",tag:" + this.p);
    localStringBuilder.append(",httpCallback:" + this.h);
    localStringBuilder.append(",testMode:" + this.q);
    localStringBuilder.append(",httpCallback:" + this.h);
    localStringBuilder.append(",testMode:" + this.q);
    localStringBuilder.append(",followRedirects:" + this.e);
    localStringBuilder.append(",isAbort:" + this.j);
    localStringBuilder.append(",headers:" + this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.y
 * JD-Core Version:    0.7.0.1
 */