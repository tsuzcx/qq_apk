package com.tencent.turingfd.sdk.base;

public class ao
  implements cf
{
  public static final byte[] a = new byte[0];
  public final String b;
  public final long c;
  public final int d;
  public final String e;
  public final String f;
  public final String g;
  public final String h;
  public ax i;
  
  public ao(int paramInt, byte[] paramArrayOfByte)
  {
    this.b = "";
    this.c = 0L;
    this.d = paramInt;
    this.e = "";
    this.f = "";
    this.g = "";
    this.h = "";
    this.i = new ax("");
  }
  
  public ao(b paramb)
  {
    this.b = paramb.a;
    this.c = paramb.b;
    this.d = paramb.c;
    byte[] arrayOfByte = paramb.d;
    this.e = paramb.e;
    this.f = paramb.f;
    this.g = paramb.g;
    this.h = paramb.h;
    this.i = paramb.i;
  }
  
  public static ao a(int paramInt)
  {
    return new ao(paramInt, a);
  }
  
  public static b b(int paramInt)
  {
    return new b(paramInt, null);
  }
  
  public static final class b
  {
    public String a;
    public long b;
    public int c;
    public byte[] d;
    public String e;
    public String f;
    public String g;
    public String h;
    public ax i;
    
    public ao a()
    {
      return new ao(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.ao
 * JD-Core Version:    0.7.0.1
 */