package com.google.android.exoplayer2;

import java.util.HashSet;

public final class ExoPlayerLibraryInfo
{
  public static final boolean ASSERTIONS_ENABLED = true;
  public static final String TAG = "ExoPlayer";
  public static final boolean TRACE_ENABLED = true;
  public static final String VERSION = "2.7.1";
  public static final int VERSION_INT = 2007001;
  public static final String VERSION_SLASHY = "ExoPlayerLib/2.7.1";
  private static final HashSet<String> registeredModules = new HashSet();
  private static String registeredModulesString = "goog.exo.core";
  
  public static void registerModule(String paramString)
  {
    try
    {
      if (registeredModules.add(paramString)) {
        registeredModulesString = registeredModulesString + ", " + paramString;
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static String registeredModules()
  {
    try
    {
      String str = registeredModulesString;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.ExoPlayerLibraryInfo
 * JD-Core Version:    0.7.0.1
 */