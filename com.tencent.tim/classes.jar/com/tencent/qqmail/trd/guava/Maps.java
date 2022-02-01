package com.tencent.qqmail.trd.guava;

import java.util.HashMap;

public class Maps
{
  public static <K, V> InnerMap<K, V> newHashMap(K paramK, V paramV)
  {
    return InnerMap.init(paramK, paramV);
  }
  
  public static <T, N> HashMap<T, N> newHashMap()
  {
    return new HashMap();
  }
  
  public static class InnerMap<K, V>
  {
    private HashMap<K, V> mValue = new HashMap();
    
    private InnerMap(K paramK, V paramV)
    {
      this.mValue.put(paramK, paramV);
    }
    
    protected static <M, N> InnerMap<M, N> init(M paramM, N paramN)
    {
      return new InnerMap(paramM, paramN);
    }
    
    public InnerMap<K, V> add(K paramK, V paramV)
    {
      this.mValue.put(paramK, paramV);
      return this;
    }
    
    public HashMap<K, V> commit()
    {
      return this.mValue;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.trd.guava.Maps
 * JD-Core Version:    0.7.0.1
 */