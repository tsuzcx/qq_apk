package com.tencent.feedback.proguard;

import java.util.ArrayList;

public final class M
  extends j
  implements Cloneable
{
  private static ArrayList<L> b;
  public ArrayList<L> a = null;
  
  public final void a(h paramh)
  {
    if (b == null)
    {
      b = new ArrayList();
      L localL = new L();
      b.add(localL);
    }
    this.a = ((ArrayList)paramh.a(b, 0, true));
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.M
 * JD-Core Version:    0.7.0.1
 */