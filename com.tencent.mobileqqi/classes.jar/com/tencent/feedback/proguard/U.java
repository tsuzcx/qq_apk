package com.tencent.feedback.proguard;

import java.util.ArrayList;

public final class U
  extends j
{
  private static ArrayList<W> h;
  private static X i;
  public ArrayList<W> a = null;
  public X b = null;
  public int c = 0;
  public int d = 0;
  public String e = "";
  public boolean f = true;
  public boolean g = true;
  
  public final void a(h paramh)
  {
    if (h == null)
    {
      h = new ArrayList();
      W localW = new W();
      h.add(localW);
    }
    this.a = ((ArrayList)paramh.a(h, 0, true));
    if (i == null) {
      i = new X();
    }
    this.b = ((X)paramh.a(i, 1, true));
    this.c = paramh.a(this.c, 2, true);
    this.d = paramh.a(this.d, 3, true);
    this.e = paramh.b(4, true);
    boolean bool = this.f;
    this.f = paramh.a(5, false);
    bool = this.g;
    this.g = paramh.a(6, false);
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    parami.a(this.b, 1);
    parami.a(this.c, 2);
    parami.a(this.d, 3);
    parami.a(this.e, 4);
    parami.a(this.f, 5);
    parami.a(this.g, 6);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.U
 * JD-Core Version:    0.7.0.1
 */