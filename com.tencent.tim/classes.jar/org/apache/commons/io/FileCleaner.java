package org.apache.commons.io;

import java.io.File;

@Deprecated
public class FileCleaner
{
  static final FileCleaningTracker theInstance = new FileCleaningTracker();
  
  @Deprecated
  public static void exitWhenFinished()
  {
    try
    {
      theInstance.exitWhenFinished();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static FileCleaningTracker getInstance()
  {
    return theInstance;
  }
  
  @Deprecated
  public static int getTrackCount()
  {
    return theInstance.getTrackCount();
  }
  
  @Deprecated
  public static void track(File paramFile, Object paramObject)
  {
    theInstance.track(paramFile, paramObject);
  }
  
  @Deprecated
  public static void track(File paramFile, Object paramObject, FileDeleteStrategy paramFileDeleteStrategy)
  {
    theInstance.track(paramFile, paramObject, paramFileDeleteStrategy);
  }
  
  @Deprecated
  public static void track(String paramString, Object paramObject)
  {
    theInstance.track(paramString, paramObject);
  }
  
  @Deprecated
  public static void track(String paramString, Object paramObject, FileDeleteStrategy paramFileDeleteStrategy)
  {
    theInstance.track(paramString, paramObject, paramFileDeleteStrategy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.FileCleaner
 * JD-Core Version:    0.7.0.1
 */