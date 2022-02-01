package com.tencent.feedback.proguard;

public final class O
  extends j
  implements Cloneable
{
  private static byte[] f;
  public byte a = 0;
  public int b = 0;
  public byte[] c = null;
  public String d = "";
  public long e = 0L;
  
  public final void a(h paramh)
  {
    this.a = paramh.a(this.a, 0, true);
    this.b = paramh.a(this.b, 1, true);
    if (f == null)
    {
      byte[] arrayOfByte = (byte[])new byte[1];
      f = arrayOfByte;
      ((byte[])arrayOfByte)[0] = 0;
    }
    this.c = ((byte[])paramh.c(2, false));
    this.d = paramh.b(3, false);
    this.e = paramh.a(this.e, 4, false);
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    parami.a(this.b, 1);
    Object localObject = this.c;
    if (localObject != null) {
      parami.a((byte[])localObject, 2);
    }
    localObject = this.d;
    if (localObject != null) {
      parami.a((String)localObject, 3);
    }
    parami.a(this.e, 4);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.O
 * JD-Core Version:    0.7.0.1
 */