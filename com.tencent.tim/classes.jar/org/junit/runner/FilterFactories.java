package org.junit.runner;

import java.lang.reflect.Constructor;
import org.junit.internal.Classes;
import org.junit.runner.manipulation.Filter;

class FilterFactories
{
  public static Filter createFilter(Class<? extends FilterFactory> paramClass, FilterFactoryParams paramFilterFactoryParams)
    throws FilterFactory.FilterNotCreatedException
  {
    return createFilterFactory(paramClass).createFilter(paramFilterFactoryParams);
  }
  
  public static Filter createFilter(String paramString, FilterFactoryParams paramFilterFactoryParams)
    throws FilterFactory.FilterNotCreatedException
  {
    return createFilterFactory(paramString).createFilter(paramFilterFactoryParams);
  }
  
  static FilterFactory createFilterFactory(Class<? extends FilterFactory> paramClass)
    throws FilterFactory.FilterNotCreatedException
  {
    try
    {
      paramClass = (FilterFactory)paramClass.getConstructor(new Class[0]).newInstance(new Object[0]);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      throw new FilterFactory.FilterNotCreatedException(paramClass);
    }
  }
  
  static FilterFactory createFilterFactory(String paramString)
    throws FilterFactory.FilterNotCreatedException
  {
    try
    {
      paramString = Classes.getClass(paramString).asSubclass(FilterFactory.class);
      return createFilterFactory(paramString);
    }
    catch (Exception paramString)
    {
      throw new FilterFactory.FilterNotCreatedException(paramString);
    }
  }
  
  public static Filter createFilterFromFilterSpec(Request paramRequest, String paramString)
    throws FilterFactory.FilterNotCreatedException
  {
    Description localDescription = paramRequest.getRunner().getDescription();
    if (paramString.contains("=")) {
      paramRequest = paramString.split("=", 2);
    }
    for (;;)
    {
      return createFilter(paramRequest[0], new FilterFactoryParams(localDescription, paramRequest[1]));
      paramRequest = new String[2];
      paramRequest[0] = paramString;
      paramRequest[1] = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.runner.FilterFactories
 * JD-Core Version:    0.7.0.1
 */