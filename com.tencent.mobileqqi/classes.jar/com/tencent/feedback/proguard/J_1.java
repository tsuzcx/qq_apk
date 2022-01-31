package com.tencent.feedback.proguard;

public final class J
  extends j
{
  public String a = "";
  public String b = "";
  
  public final void a(h paramh)
  {
    this.a = paramh.b(0, true);
    this.b = paramh.b(1, false);
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    if (this.b != null) {
      parami.a(this.b, 1);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.J
 * JD-Core Version:    0.7.0.1
 */