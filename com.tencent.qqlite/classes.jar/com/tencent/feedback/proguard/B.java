package com.tencent.feedback.proguard;

import java.util.HashMap;
import java.util.Map;

public final class B
  extends j
{
  private static Map<Integer, byte[]> b;
  public Map<Integer, byte[]> a = null;
  
  public final void a(h paramh)
  {
    if (b == null)
    {
      b = new HashMap();
      b.put(Integer.valueOf(0), new byte[] { 0 });
    }
    this.a = ((Map)paramh.a(b, 0, true));
  }
  
  public final void a(i parami)
  {
    parami.a(this.a, 0);
  }
  
  public final void a(StringBuilder paramStringBuilder, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.B
 * JD-Core Version:    0.7.0.1
 */