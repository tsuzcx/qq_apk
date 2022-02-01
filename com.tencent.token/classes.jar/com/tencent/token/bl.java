package com.tencent.token;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class bl
{
  public final HashMap<String, bj> a = new HashMap();
  
  public final void a()
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((bj)localIterator.next()).a();
    }
    this.a.clear();
  }
  
  public final void a(String paramString, bj parambj)
  {
    bj localbj = (bj)this.a.get(paramString);
    if (localbj != null) {
      localbj.a();
    }
    this.a.put(paramString, parambj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bl
 * JD-Core Version:    0.7.0.1
 */