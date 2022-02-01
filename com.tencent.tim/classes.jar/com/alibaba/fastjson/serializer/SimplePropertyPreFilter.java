package com.alibaba.fastjson.serializer;

import java.util.HashSet;
import java.util.Set;

public class SimplePropertyPreFilter
  implements PropertyPreFilter
{
  private final Class<?> clazz;
  private final Set<String> excludes = new HashSet();
  private final Set<String> includes = new HashSet();
  private int maxLevel = 0;
  
  public SimplePropertyPreFilter(Class<?> paramClass, String... paramVarArgs)
  {
    this.clazz = paramClass;
    int j = paramVarArgs.length;
    while (i < j)
    {
      paramClass = paramVarArgs[i];
      if (paramClass != null) {
        this.includes.add(paramClass);
      }
      i += 1;
    }
  }
  
  public SimplePropertyPreFilter(String... paramVarArgs)
  {
    this(null, paramVarArgs);
  }
  
  public boolean apply(JSONSerializer paramJSONSerializer, Object paramObject, String paramString)
  {
    if (paramObject == null) {}
    do
    {
      do
      {
        return true;
      } while ((this.clazz != null) && (!this.clazz.isInstance(paramObject)));
      if (this.excludes.contains(paramString)) {
        return false;
      }
      if (this.maxLevel > 0)
      {
        paramJSONSerializer = paramJSONSerializer.context;
        int i = 0;
        while (paramJSONSerializer != null)
        {
          i += 1;
          if (i > this.maxLevel) {
            return false;
          }
          paramJSONSerializer = paramJSONSerializer.parent;
        }
      }
    } while ((this.includes.size() == 0) || (this.includes.contains(paramString)));
    return false;
  }
  
  public Class<?> getClazz()
  {
    return this.clazz;
  }
  
  public Set<String> getExcludes()
  {
    return this.excludes;
  }
  
  public Set<String> getIncludes()
  {
    return this.includes;
  }
  
  public int getMaxLevel()
  {
    return this.maxLevel;
  }
  
  public void setMaxLevel(int paramInt)
  {
    this.maxLevel = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.serializer.SimplePropertyPreFilter
 * JD-Core Version:    0.7.0.1
 */