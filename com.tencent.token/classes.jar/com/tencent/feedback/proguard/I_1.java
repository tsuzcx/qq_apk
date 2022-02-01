package com.tencent.feedback.proguard;

public final class I
  extends j
  implements Cloneable
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  private String e = "";
  
  public final void a(h paramh)
  {
    this.a = paramh.b(0, true);
    this.b = paramh.b(1, false);
    this.c = paramh.b(2, false);
    this.e = paramh.b(3, false);
    this.d = paramh.b(4, false);
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    String str = this.b;
    if (str != null) {
      parami.a(str, 1);
    }
    str = this.c;
    if (str != null) {
      parami.a(str, 2);
    }
    str = this.e;
    if (str != null) {
      parami.a(str, 3);
    }
    str = this.d;
    if (str != null) {
      parami.a(str, 4);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.I
 * JD-Core Version:    0.7.0.1
 */