package com.tencent.token;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class auy
{
  boolean a;
  private final List<Object> b;
  private Map<String, avc> c;
  
  public final void a(String paramString, float paramFloat)
  {
    if (!this.a) {
      return;
    }
    avc localavc2 = (avc)this.c.get(paramString);
    avc localavc1 = localavc2;
    if (localavc2 == null)
    {
      localavc1 = new avc();
      this.c.put(paramString, localavc1);
    }
    localavc1.a(paramFloat);
    if (paramString.equals("root"))
    {
      paramString = this.b.iterator();
      while (paramString.hasNext()) {
        paramString.next();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.auy
 * JD-Core Version:    0.7.0.1
 */