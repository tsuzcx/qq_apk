package org.junit.experimental.categories;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.runner.manipulation.Filter;

public final class IncludeCategories
  extends CategoryFilterFactory
{
  protected Filter createFilter(List<Class<?>> paramList)
  {
    return new IncludesAny(paramList);
  }
  
  static class IncludesAny
    extends Categories.CategoryFilter
  {
    public IncludesAny(List<Class<?>> paramList)
    {
      this(new HashSet(paramList));
    }
    
    public IncludesAny(Set<Class<?>> paramSet)
    {
      super(paramSet, true, null);
    }
    
    public String describe()
    {
      return "includes " + super.describe();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.experimental.categories.IncludeCategories
 * JD-Core Version:    0.7.0.1
 */