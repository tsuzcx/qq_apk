package com.tencent.feedback.proguard;

import java.util.ArrayList;

public final class J
  extends j
  implements Cloneable
{
  private static ArrayList<String> c;
  private String a = "";
  private ArrayList<String> b = null;
  
  public final void a(h paramh)
  {
    this.a = paramh.b(0, true);
    if (c == null)
    {
      c = new ArrayList();
      c.add("");
    }
    this.b = ((ArrayList)paramh.a(c, 1, false));
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    ArrayList localArrayList = this.b;
    if (localArrayList != null) {
      parami.a(localArrayList, 1);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.J
 * JD-Core Version:    0.7.0.1
 */