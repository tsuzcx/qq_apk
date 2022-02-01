package com.tencent.token;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class bz
{
  public final HashMap<String, bx> a = new HashMap();
  
  public final void a()
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((bx)localIterator.next()).a();
    }
    this.a.clear();
  }
  
  public final void a(String paramString, bx parambx)
  {
    bx localbx = (bx)this.a.get(paramString);
    if (localbx != null) {
      localbx.a();
    }
    this.a.put(paramString, parambx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bz
 * JD-Core Version:    0.7.0.1
 */