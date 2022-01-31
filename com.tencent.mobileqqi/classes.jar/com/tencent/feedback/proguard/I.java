package com.tencent.feedback.proguard;

import java.util.ArrayList;

public final class I
  extends j
{
  private static ArrayList<H> b;
  public ArrayList<H> a = null;
  
  public final void a(h paramh)
  {
    if (b == null)
    {
      b = new ArrayList();
      H localH = new H();
      b.add(localH);
    }
    this.a = ((ArrayList)paramh.a(b, 0, true));
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.I
 * JD-Core Version:    0.7.0.1
 */