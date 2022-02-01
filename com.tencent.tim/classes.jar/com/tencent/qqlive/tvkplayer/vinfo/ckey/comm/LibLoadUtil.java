package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import android.content.Context;
import com.tencent.qqlive.tvkplayer.vinfo.ckey.ModuleUpdateInterface;
import java.io.File;

public class LibLoadUtil
{
  private static ModuleUpdateInterface moduleUpdateInterface;
  
  private static boolean load(Context paramContext, String paramString)
  {
    try
    {
      System.loadLibrary(paramString);
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      VsLog.error("load " + paramString + " failed!", new Object[0]);
      localUnsatisfiedLinkError.printStackTrace();
      if (paramContext == null) {
        return false;
      }
      try
      {
        paramContext = new File(paramContext.getDir("lib", 0), System.mapLibraryName(paramString));
        if (paramContext.exists())
        {
          System.load(paramContext.getAbsolutePath());
          return true;
        }
      }
      catch (Exception paramContext)
      {
        VsLog.error("load " + paramString + " failed!", new Object[0]);
        paramContext.printStackTrace();
      }
    }
    return false;
  }
  
  public static boolean loadso(Context paramContext, String paramString)
  {
    boolean bool1 = false;
    if (moduleUpdateInterface != null) {
      bool1 = moduleUpdateInterface.loadLibrary(paramString);
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = load(paramContext, paramString);
    }
    return bool2;
  }
  
  public static void setModuleLoadInterface(ModuleUpdateInterface paramModuleUpdateInterface)
  {
    moduleUpdateInterface = paramModuleUpdateInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.ckey.comm.LibLoadUtil
 * JD-Core Version:    0.7.0.1
 */