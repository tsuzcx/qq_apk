package org.extra.relinker;

import android.content.Context;
import java.io.File;

public class ReLinker
{
  public static ReLinkerInstance force()
  {
    return new ReLinkerInstance().force();
  }
  
  public static void loadLibrary(Context paramContext, String paramString)
  {
    loadLibrary(paramContext, paramString, null, null);
  }
  
  public static void loadLibrary(Context paramContext, String paramString1, String paramString2)
  {
    loadLibrary(paramContext, paramString1, paramString2, null);
  }
  
  public static void loadLibrary(Context paramContext, String paramString1, String paramString2, LoadListener paramLoadListener)
  {
    new ReLinkerInstance().loadLibrary(paramContext, paramString1, paramString2, paramLoadListener);
  }
  
  public static void loadLibrary(Context paramContext, String paramString, LoadListener paramLoadListener)
  {
    loadLibrary(paramContext, paramString, null, paramLoadListener);
  }
  
  public static ReLinkerInstance log(Logger paramLogger)
  {
    return new ReLinkerInstance().log(paramLogger);
  }
  
  public static ReLinkerInstance recursively()
  {
    return new ReLinkerInstance().recursively();
  }
  
  public static abstract interface LibraryInstaller
  {
    public abstract void installLibrary(Context paramContext, String[] paramArrayOfString, String paramString, File paramFile, ReLinkerInstance paramReLinkerInstance);
  }
  
  public static abstract interface LibraryLoader
  {
    public abstract void loadLibrary(String paramString);
    
    public abstract void loadPath(String paramString);
    
    public abstract String mapLibraryName(String paramString);
    
    public abstract String[] supportedAbis();
    
    public abstract String unmapLibraryName(String paramString);
  }
  
  public static abstract interface LoadListener
  {
    public abstract void failure(Throwable paramThrowable);
    
    public abstract void success();
  }
  
  public static abstract interface Logger
  {
    public abstract void log(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.extra.relinker.ReLinker
 * JD-Core Version:    0.7.0.1
 */