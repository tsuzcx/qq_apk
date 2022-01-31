package com.tencent.feedback.proguard;

public final class G
  extends j
{
  public String a = "";
  public String b = "";
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  
  public final void a(h paramh)
  {
    this.a = paramh.b(0, true);
    this.c = paramh.b(1, true);
    this.b = paramh.b(2, true);
    this.d = paramh.b(3, true);
    this.e = paramh.b(4, true);
    this.f = paramh.b(5, false);
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    parami.a(this.c, 1);
    parami.a(this.b, 2);
    parami.a(this.d, 3);
    parami.a(this.e, 4);
    if (this.f != null) {
      parami.a(this.f, 5);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.G
 * JD-Core Version:    0.7.0.1
 */