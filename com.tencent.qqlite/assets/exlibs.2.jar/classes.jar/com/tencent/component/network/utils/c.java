package com.tencent.component.network.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public final class c<K, V>
  extends HashMap<K, HashSet<V>>
{
  public final int a(K paramK)
  {
    paramK = (Collection)get(paramK);
    if (paramK == null) {
      return 0;
    }
    return paramK.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.c
 * JD-Core Version:    0.7.0.1
 */