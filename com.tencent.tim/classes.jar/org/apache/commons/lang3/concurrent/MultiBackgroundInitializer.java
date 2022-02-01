package org.apache.commons.lang3.concurrent;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public class MultiBackgroundInitializer
  extends BackgroundInitializer<MultiBackgroundInitializerResults>
{
  private final Map<String, BackgroundInitializer<?>> childInitializers = new HashMap();
  
  public MultiBackgroundInitializer() {}
  
  public MultiBackgroundInitializer(ExecutorService paramExecutorService)
  {
    super(paramExecutorService);
  }
  
  public void addInitializer(String paramString, BackgroundInitializer<?> paramBackgroundInitializer)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Name of child initializer must not be null!");
    }
    if (paramBackgroundInitializer == null) {
      throw new IllegalArgumentException("Child initializer must not be null!");
    }
    try
    {
      if (isStarted()) {
        throw new IllegalStateException("addInitializer() must not be called after start()!");
      }
    }
    finally {}
    this.childInitializers.put(paramString, paramBackgroundInitializer);
  }
  
  protected int getTaskCount()
  {
    Iterator localIterator = this.childInitializers.values().iterator();
    for (int i = 1; localIterator.hasNext(); i = ((BackgroundInitializer)localIterator.next()).getTaskCount() + i) {}
    return i;
  }
  
  protected MultiBackgroundInitializerResults initialize()
    throws Exception
  {
    Object localObject1;
    try
    {
      HashMap localHashMap = new HashMap(this.childInitializers);
      localObject1 = getActiveExecutor();
      localObject2 = localHashMap.values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (BackgroundInitializer)((Iterator)localObject2).next();
        if (((BackgroundInitializer)localObject3).getExternalExecutor() == null) {
          ((BackgroundInitializer)localObject3).setExternalExecutor((ExecutorService)localObject1);
        }
        ((BackgroundInitializer)localObject3).start();
      }
      localObject1 = new HashMap();
    }
    finally {}
    Object localObject2 = new HashMap();
    Object localObject3 = localMap.entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
      try
      {
        ((Map)localObject1).put(localEntry.getKey(), ((BackgroundInitializer)localEntry.getValue()).get());
      }
      catch (ConcurrentException localConcurrentException)
      {
        ((Map)localObject2).put(localEntry.getKey(), localConcurrentException);
      }
    }
    return new MultiBackgroundInitializerResults(localMap, (Map)localObject1, (Map)localObject2, null);
  }
  
  public static class MultiBackgroundInitializerResults
  {
    private final Map<String, ConcurrentException> exceptions;
    private final Map<String, BackgroundInitializer<?>> initializers;
    private final Map<String, Object> resultObjects;
    
    private MultiBackgroundInitializerResults(Map<String, BackgroundInitializer<?>> paramMap, Map<String, Object> paramMap1, Map<String, ConcurrentException> paramMap2)
    {
      this.initializers = paramMap;
      this.resultObjects = paramMap1;
      this.exceptions = paramMap2;
    }
    
    private BackgroundInitializer<?> checkName(String paramString)
    {
      BackgroundInitializer localBackgroundInitializer = (BackgroundInitializer)this.initializers.get(paramString);
      if (localBackgroundInitializer == null) {
        throw new NoSuchElementException("No child initializer with name " + paramString);
      }
      return localBackgroundInitializer;
    }
    
    public ConcurrentException getException(String paramString)
    {
      checkName(paramString);
      return (ConcurrentException)this.exceptions.get(paramString);
    }
    
    public BackgroundInitializer<?> getInitializer(String paramString)
    {
      return checkName(paramString);
    }
    
    public Object getResultObject(String paramString)
    {
      checkName(paramString);
      return this.resultObjects.get(paramString);
    }
    
    public Set<String> initializerNames()
    {
      return Collections.unmodifiableSet(this.initializers.keySet());
    }
    
    public boolean isException(String paramString)
    {
      checkName(paramString);
      return this.exceptions.containsKey(paramString);
    }
    
    public boolean isSuccessful()
    {
      return this.exceptions.isEmpty();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.concurrent.MultiBackgroundInitializer
 * JD-Core Version:    0.7.0.1
 */