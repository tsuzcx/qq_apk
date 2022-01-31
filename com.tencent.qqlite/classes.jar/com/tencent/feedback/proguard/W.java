package com.tencent.feedback.proguard;

public final class W
  extends j
{
  public int a = 0;
  public String b = "";
  public boolean c = true;
  
  public final void a(h paramh)
  {
    this.a = paramh.a(this.a, 0, true);
    this.b = paramh.b(1, true);
    boolean bool = this.c;
    this.c = paramh.a(2, false);
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    parami.a(this.b, 1);
    parami.a(this.c, 2);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.W
 * JD-Core Version:    0.7.0.1
 */