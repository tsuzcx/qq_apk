package com.tencent.feedback.proguard;

public final class K
  extends j
{
  public String a = "";
  public String b = "";
  public String c = "";
  
  public final void a(h paramh)
  {
    this.a = paramh.b(0, true);
    this.b = paramh.b(1, true);
    this.c = paramh.b(2, false);
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    parami.a(this.b, 1);
    if (this.c != null) {
      parami.a(this.c, 2);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.K
 * JD-Core Version:    0.7.0.1
 */