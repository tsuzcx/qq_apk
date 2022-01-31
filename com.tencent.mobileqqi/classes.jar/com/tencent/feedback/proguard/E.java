package com.tencent.feedback.proguard;

public final class E
  extends j
{
  public String a = "";
  public String b = "";
  public String c = "";
  private String d = "";
  
  public final void a(h paramh)
  {
    this.a = paramh.b(0, false);
    this.b = paramh.b(1, false);
    this.c = paramh.b(2, false);
    this.d = paramh.b(3, false);
  }
  
  public final void a(i parami)
  {
    if (this.a != null) {
      parami.a(this.a, 0);
    }
    if (this.b != null) {
      parami.a(this.b, 1);
    }
    if (this.c != null) {
      parami.a(this.c, 2);
    }
    if (this.d != null) {
      parami.a(this.d, 3);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.E
 * JD-Core Version:    0.7.0.1
 */