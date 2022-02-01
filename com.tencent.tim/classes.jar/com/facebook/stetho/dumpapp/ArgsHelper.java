package com.facebook.stetho.dumpapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArgsHelper
{
  public static String[] drainToArray(Iterator<String> paramIterator)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramIterator.hasNext()) {
      localArrayList.add(paramIterator.next());
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }
  
  public static String nextArg(Iterator<String> paramIterator, String paramString)
    throws DumpUsageException
  {
    if (!paramIterator.hasNext()) {
      throw new DumpUsageException(paramString);
    }
    return (String)paramIterator.next();
  }
  
  public static String nextOptionalArg(Iterator<String> paramIterator, String paramString)
  {
    if (paramIterator.hasNext()) {
      return (String)paramIterator.next();
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.dumpapp.ArgsHelper
 * JD-Core Version:    0.7.0.1
 */