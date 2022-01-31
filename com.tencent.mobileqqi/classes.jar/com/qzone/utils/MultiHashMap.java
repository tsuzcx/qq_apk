package com.qzone.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class MultiHashMap<K, V>
  extends HashMap<K, HashSet<V>>
{
  public boolean add(K paramK, V paramV)
  {
    if (paramV == null) {
      return false;
    }
    HashSet localHashSet2 = (HashSet)get(paramK);
    HashSet localHashSet1 = localHashSet2;
    if (localHashSet2 == null)
    {
      localHashSet1 = new HashSet();
      put(paramK, localHashSet1);
    }
    return localHashSet1.add(paramV);
  }
  
  public boolean remove(K paramK, V paramV)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if (paramV == null)
    {
      if (remove(paramK) != null) {
        return bool2;
      }
      return false;
    }
    Collection localCollection = (Collection)get(paramK);
    if ((localCollection != null) && (localCollection.remove(paramV))) {}
    for (;;)
    {
      bool2 = bool1;
      if (localCollection == null) {
        break;
      }
      bool2 = bool1;
      if (!localCollection.isEmpty()) {
        break;
      }
      remove(paramK);
      return bool1;
      bool1 = false;
    }
  }
  
  public int sizeOf(K paramK)
  {
    paramK = (Collection)get(paramK);
    if (paramK == null) {
      return 0;
    }
    return paramK.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.utils.MultiHashMap
 * JD-Core Version:    0.7.0.1
 */