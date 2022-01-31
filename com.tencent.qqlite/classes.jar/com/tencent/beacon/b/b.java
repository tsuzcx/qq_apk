package com.tencent.beacon.b;

import java.io.Serializable;

public final class b
  implements Serializable
{
  private String a;
  private long b;
  private String c;
  private String d;
  private String e;
  private boolean f;
  private boolean g;
  
  public final String a()
  {
    return this.a;
  }
  
  public final void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public final void a(String paramString)
  {
    this.a = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public final String b()
  {
    return this.c;
  }
  
  public final void b(String paramString)
  {
    this.c = paramString;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public final String c()
  {
    return this.d;
  }
  
  public final void c(String paramString)
  {
    this.d = paramString;
  }
  
  public final String d()
  {
    return this.e;
  }
  
  public final void d(String paramString)
  {
    this.e = paramString;
  }
  
  public final boolean e()
  {
    return this.f;
  }
  
  public final boolean f()
  {
    return this.g;
  }
  
  public final String toString()
  {
    return "type:" + this.a + "\ntime:" + this.b + "\ndest:" + this.c + "\n";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.beacon.b.b
 * JD-Core Version:    0.7.0.1
 */