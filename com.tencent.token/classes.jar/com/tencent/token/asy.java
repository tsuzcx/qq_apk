package com.tencent.token;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class asy
{
  boolean a;
  private final List<Object> b;
  private Map<String, atc> c;
  
  public final void a(String paramString, float paramFloat)
  {
    if (!this.a) {
      return;
    }
    atc localatc2 = (atc)this.c.get(paramString);
    atc localatc1 = localatc2;
    if (localatc2 == null)
    {
      localatc1 = new atc();
      this.c.put(paramString, localatc1);
    }
    localatc1.a(paramFloat);
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
 * Qualified Name:     com.tencent.token.asy
 * JD-Core Version:    0.7.0.1
 */