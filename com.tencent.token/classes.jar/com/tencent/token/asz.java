package com.tencent.token;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class asz
{
  boolean a;
  private final List<Object> b;
  private Map<String, atd> c;
  
  public final void a(String paramString, float paramFloat)
  {
    if (!this.a) {
      return;
    }
    atd localatd2 = (atd)this.c.get(paramString);
    atd localatd1 = localatd2;
    if (localatd2 == null)
    {
      localatd1 = new atd();
      this.c.put(paramString, localatd1);
    }
    localatd1.a(paramFloat);
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
 * Qualified Name:     com.tencent.token.asz
 * JD-Core Version:    0.7.0.1
 */