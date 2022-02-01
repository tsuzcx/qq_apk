package com.hp.hpl.sparta;

import java.util.Hashtable;

public class Sparta
{
  private static CacheFactory cacheFactory_ = new Sparta.2();
  private static Internment internment_ = new Sparta.1();
  
  public static String intern(String paramString)
  {
    return internment_.intern(paramString);
  }
  
  static Cache newCache()
  {
    return cacheFactory_.create();
  }
  
  public static void setCacheFactory(CacheFactory paramCacheFactory)
  {
    cacheFactory_ = paramCacheFactory;
  }
  
  public static void setInternment(Internment paramInternment)
  {
    internment_ = paramInternment;
  }
  
  public static abstract interface Cache
  {
    public abstract Object get(Object paramObject);
    
    public abstract Object put(Object paramObject1, Object paramObject2);
    
    public abstract int size();
  }
  
  public static abstract interface CacheFactory
  {
    public abstract Sparta.Cache create();
  }
  
  static class HashtableCache
    extends Hashtable
    implements Sparta.Cache
  {
    private HashtableCache() {}
    
    HashtableCache(Sparta.1 param1)
    {
      this();
    }
  }
  
  public static abstract interface Internment
  {
    public abstract String intern(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.hp.hpl.sparta.Sparta
 * JD-Core Version:    0.7.0.1
 */