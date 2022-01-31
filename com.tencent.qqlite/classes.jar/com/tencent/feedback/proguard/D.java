package com.tencent.feedback.proguard;

public final class D
  extends j
{
  private static byte[] i;
  public byte a = 0;
  public int b = 0;
  public byte[] c = null;
  public String d = "";
  public byte e = 0;
  public byte f = 0;
  public long g = 0L;
  private String h = "";
  
  public final void a(h paramh)
  {
    this.a = paramh.a(this.a, 0, true);
    this.b = paramh.a(this.b, 1, true);
    if (i == null)
    {
      arrayOfByte = new byte[1];
      i = arrayOfByte;
      arrayOfByte[0] = 0;
    }
    byte[] arrayOfByte = i;
    this.c = paramh.c(2, true);
    this.d = paramh.b(3, true);
    this.e = paramh.a(this.e, 4, false);
    this.f = paramh.a(this.f, 5, false);
    this.g = paramh.a(this.g, 6, false);
    this.h = paramh.b(7, false);
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    parami.a(this.b, 1);
    parami.a(this.c, 2);
    parami.a(this.d, 3);
    parami.a(this.e, 4);
    parami.a(this.f, 5);
    parami.a(this.g, 6);
    if (this.h != null) {
      parami.a(this.h, 7);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.D
 * JD-Core Version:    0.7.0.1
 */