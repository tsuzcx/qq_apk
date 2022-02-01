package com.tencent.bugly.proguard;

import java.util.ArrayList;

public final class ai
  extends k
  implements Cloneable
{
  private static ArrayList<String> c;
  private String a = "";
  private ArrayList<String> b = null;
  
  public final void a(i parami)
  {
    this.a = parami.b(0, true);
    if (c == null)
    {
      c = new ArrayList();
      c.add("");
    }
    this.b = ((ArrayList)parami.a(c, 1, false));
  }
  
  public final void a(j paramj)
  {
    paramj.a(this.a, 0);
    if (this.b != null) {
      paramj.a(this.b, 1);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.ai
 * JD-Core Version:    0.7.0.1
 */