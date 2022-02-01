package com.tencent.feedback.proguard;

public final class P
  extends j
  implements Cloneable
{
  private String a = "";
  private String b = "";
  
  public final void a(h paramh)
  {
    this.a = paramh.b(0, true);
    this.b = paramh.b(1, true);
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    parami.a(this.b, 1);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.P
 * JD-Core Version:    0.7.0.1
 */