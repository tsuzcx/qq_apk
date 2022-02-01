package com.tencent.token;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class bh
{
  public final HashMap<String, bf> a = new HashMap();
  
  public final void a()
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((bf)localIterator.next()).a();
    }
    this.a.clear();
  }
  
  public final void a(String paramString, bf parambf)
  {
    bf localbf = (bf)this.a.get(paramString);
    if (localbf != null) {
      localbf.a();
    }
    this.a.put(paramString, parambf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bh
 * JD-Core Version:    0.7.0.1
 */