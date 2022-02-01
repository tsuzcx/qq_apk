package com.tencent.token;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class aes
  implements afm
{
  public aes(Set paramSet) {}
  
  public final Map<Integer, Integer> a()
  {
    HashMap localHashMap = new HashMap();
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localHashMap.put((Integer)((Iterator)localObject).next(), Integer.valueOf(0));
      }
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aes
 * JD-Core Version:    0.7.0.1
 */