package com.tencent.feedback.proguard;

public final class X
  extends j
{
  public String a = "";
  public String b = "";
  public int c = 0;
  public int d = 0;
  
  public final void a(h paramh)
  {
    this.a = paramh.b(0, true);
    this.b = paramh.b(1, true);
    this.c = paramh.a(this.c, 2, true);
    this.d = paramh.a(this.d, 3, true);
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    parami.a(this.b, 1);
    parami.a(this.c, 2);
    parami.a(this.d, 3);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.X
 * JD-Core Version:    0.7.0.1
 */