package com.tencent.token;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class avw
{
  boolean a;
  private final List<Object> b;
  private Map<String, awa> c;
  
  public final void a(String paramString, float paramFloat)
  {
    if (!this.a) {
      return;
    }
    awa localawa2 = (awa)this.c.get(paramString);
    awa localawa1 = localawa2;
    if (localawa2 == null)
    {
      localawa1 = new awa();
      this.c.put(paramString, localawa1);
    }
    localawa1.a(paramFloat);
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
 * Qualified Name:     com.tencent.token.avw
 * JD-Core Version:    0.7.0.1
 */