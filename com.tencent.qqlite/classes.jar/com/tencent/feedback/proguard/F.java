package com.tencent.feedback.proguard;

public final class F
  extends j
{
  private static byte[] d;
  public byte a = 0;
  public String b = "";
  public byte[] c = null;
  
  public F() {}
  
  public F(byte paramByte, String paramString, byte[] paramArrayOfByte)
  {
    this.a = 2;
    this.b = paramString;
    this.c = paramArrayOfByte;
  }
  
  public final void a(h paramh)
  {
    this.a = paramh.a(this.a, 0, true);
    this.b = paramh.b(1, false);
    if (d == null)
    {
      arrayOfByte = new byte[1];
      d = arrayOfByte;
      arrayOfByte[0] = 0;
    }
    byte[] arrayOfByte = d;
    this.c = paramh.c(2, true);
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    if (this.b != null) {
      parami.a(this.b, 1);
    }
    parami.a(this.c, 2);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.F
 * JD-Core Version:    0.7.0.1
 */