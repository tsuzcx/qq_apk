package com.facebook.stetho.inspector.console;

import com.facebook.stetho.inspector.helper.ChromePeerManager;
import javax.annotation.Nullable;

public class ConsolePeerManager
  extends ChromePeerManager
{
  private static ConsolePeerManager sInstance;
  
  @Nullable
  public static ConsolePeerManager getInstanceOrNull()
  {
    try
    {
      ConsolePeerManager localConsolePeerManager = sInstance;
      return localConsolePeerManager;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static ConsolePeerManager getOrCreateInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new ConsolePeerManager();
      }
      ConsolePeerManager localConsolePeerManager = sInstance;
      return localConsolePeerManager;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.inspector.console.ConsolePeerManager
 * JD-Core Version:    0.7.0.1
 */