package org.junit.experimental.categories;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.runner.manipulation.Filter;

public final class ExcludeCategories
  extends CategoryFilterFactory
{
  protected Filter createFilter(List<Class<?>> paramList)
  {
    return new ExcludesAny(paramList);
  }
  
  static class ExcludesAny
    extends Categories.CategoryFilter
  {
    public ExcludesAny(List<Class<?>> paramList)
    {
      this(new HashSet(paramList));
    }
    
    public ExcludesAny(Set<Class<?>> paramSet)
    {
      super(null, true, paramSet);
    }
    
    public String describe()
    {
      return "excludes " + super.describe();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.experimental.categories.ExcludeCategories
 * JD-Core Version:    0.7.0.1
 */