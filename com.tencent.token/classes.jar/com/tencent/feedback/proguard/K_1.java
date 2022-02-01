package com.tencent.feedback.proguard;

public final class K
  extends j
  implements Cloneable
{
  private static byte[] d;
  public byte a = 0;
  public String b = "";
  public byte[] c = null;
  
  public K() {}
  
  public K(byte paramByte, String paramString, byte[] paramArrayOfByte)
  {
    this.a = paramByte;
    this.b = paramString;
    this.c = paramArrayOfByte;
  }
  
  public final void a(h paramh)
  {
    this.a = paramh.a(this.a, 0, true);
    this.b = paramh.b(1, true);
    if (d == null)
    {
      arrayOfByte = (byte[])new byte[1];
      d = arrayOfByte;
      ((byte[])arrayOfByte)[0] = 0;
    }
    byte[] arrayOfByte = d;
    this.c = ((byte[])paramh.c(2, false));
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    parami.a(this.b, 1);
    byte[] arrayOfByte = this.c;
    if (arrayOfByte != null) {
      parami.a(arrayOfByte, 2);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.K
 * JD-Core Version:    0.7.0.1
 */