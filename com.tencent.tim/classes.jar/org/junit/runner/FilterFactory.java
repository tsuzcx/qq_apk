package org.junit.runner;

import org.junit.runner.manipulation.Filter;

public abstract interface FilterFactory
{
  public abstract Filter createFilter(FilterFactoryParams paramFilterFactoryParams)
    throws FilterFactory.FilterNotCreatedException;
  
  public static class FilterNotCreatedException
    extends Exception
  {
    public FilterNotCreatedException(Exception paramException)
    {
      super(paramException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.runner.FilterFactory
 * JD-Core Version:    0.7.0.1
 */