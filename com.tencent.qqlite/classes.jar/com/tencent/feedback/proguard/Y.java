package com.tencent.feedback.proguard;

public final class Y
  extends j
{
  private long a = 0L;
  private byte b = 0;
  private String c = "";
  private String d = "";
  
  public Y() {}
  
  public Y(long paramLong, byte paramByte, String paramString1, String paramString2)
  {
    this.a = paramLong;
    this.b = paramByte;
    this.c = paramString1;
    this.d = paramString2;
  }
  
  public final void a(h paramh)
  {
    this.a = paramh.a(this.a, 0, true);
    this.b = paramh.a(this.b, 1, true);
    this.c = paramh.b(2, false);
    this.d = paramh.b(3, false);
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    parami.a(this.b, 1);
    if (this.c != null) {
      parami.a(this.c, 2);
    }
    if (this.d != null) {
      parami.a(this.d, 3);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.Y
 * JD-Core Version:    0.7.0.1
 */