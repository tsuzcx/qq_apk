package com.tencent.feedback.proguard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class Z
  extends j
{
  private static Map<String, byte[]> h;
  private static ArrayList<Y> i;
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public byte e = 0;
  public ArrayList<Y> f = null;
  private Map<String, byte[]> g = null;
  
  public final void a(h paramh)
  {
    this.a = paramh.b(0, true);
    this.b = paramh.b(1, false);
    this.c = paramh.b(2, false);
    this.d = paramh.b(3, false);
    if (h == null)
    {
      h = new HashMap();
      h.put("", new byte[] { 0 });
    }
    this.g = ((Map)paramh.a(h, 4, false));
    this.e = paramh.a(this.e, 5, false);
    if (i == null)
    {
      i = new ArrayList();
      Y localY = new Y();
      i.add(localY);
    }
    this.f = ((ArrayList)paramh.a(i, 6, false));
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
    if (this.b != null) {
      parami.a(this.b, 1);
    }
    if (this.c != null) {
      parami.a(this.c, 2);
    }
    if (this.d != null) {
      parami.a(this.d, 3);
    }
    if (this.g != null) {
      parami.a(this.g, 4);
    }
    parami.a(this.e, 5);
    if (this.f != null) {
      parami.a(this.f, 6);
    }
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.Z
 * JD-Core Version:    0.7.0.1
 */