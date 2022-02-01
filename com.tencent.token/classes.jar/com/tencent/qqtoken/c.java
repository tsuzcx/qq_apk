package com.tencent.qqtoken;

import android.content.Context;

public class c
{
  public a r;
  
  private String ab()
  {
    return this.r.d();
  }
  
  private String c()
  {
    a locala = this.r;
    if (locala != null) {
      return locala.d();
    }
    return null;
  }
  
  private long e2()
  {
    return this.r.b();
  }
  
  public static native long j();
  
  private String o()
  {
    a locala = this.r;
    if (locala == null) {
      return "";
    }
    return locala.a();
  }
  
  public native String a();
  
  void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    this.r.a(paramLong, paramInt, paramString1, paramString2);
  }
  
  void a(long paramLong, String paramString1, String paramString2)
  {
    a locala = this.r;
    if (locala != null) {
      locala.a(paramLong, paramString1, paramString2);
    }
  }
  
  void a3(String paramString)
  {
    a locala = this.r;
    if (locala != null) {
      locala.a(paramString);
    }
  }
  
  boolean aa(long paramLong)
  {
    return this.r.a(paramLong);
  }
  
  public native long b();
  
  public native void c(long paramLong, String paramString1, String paramString2);
  
  public native void c(long paramLong, String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2);
  
  public native void c(long paramLong, String paramString1, String paramString2, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5);
  
  public native void c(long paramLong, String paramString, byte[] paramArrayOfByte);
  
  public native long c2();
  
  public native boolean c3();
  
  public native long d2();
  
  public native void d2(long paramLong);
  
  public native String n();
  
  public native void n(Context paramContext, String paramString, long paramLong, int paramInt);
  
  long r()
  {
    return this.r.c();
  }
  
  public native boolean w(String paramString, long paramLong1, long paramLong2);
  
  public static abstract interface a
  {
    public abstract String a();
    
    public abstract void a(long paramLong, int paramInt, String paramString1, String paramString2);
    
    public abstract void a(long paramLong, String paramString1, String paramString2);
    
    public abstract void a(String paramString);
    
    public abstract boolean a(long paramLong);
    
    public abstract long b();
    
    public abstract long c();
    
    public abstract String d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqtoken.c
 * JD-Core Version:    0.7.0.1
 */