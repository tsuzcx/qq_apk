package com.tencent.smtt.export.external;

import android.content.Context;
import android.os.Build.VERSION;
import java.io.File;
import java.util.ArrayList;

public class LibraryLoader
{
  private static String[] sLibrarySearchPaths = null;
  
  public static String[] getLibrarySearchPaths(Context paramContext)
  {
    if (sLibrarySearchPaths != null) {
      return sLibrarySearchPaths;
    }
    if (paramContext == null) {
      return new String[] { "/system/lib" };
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(getNativeLibraryDir(paramContext));
    localArrayList.add("/system/lib");
    paramContext = new String[localArrayList.size()];
    localArrayList.toArray(paramContext);
    sLibrarySearchPaths = paramContext;
    return sLibrarySearchPaths;
  }
  
  public static String getNativeLibraryDir(Context paramContext)
  {
    int i = getSdkVersion();
    if (i >= 9) {
      return X5Adapter_23.getNativeLibraryDirGB(paramContext);
    }
    if (i >= 4) {
      return X5Adapter_16.getNativeLibraryDirDonut(paramContext);
    }
    return "/data/data/" + paramContext.getPackageName() + "/lib";
  }
  
  public static int getSdkVersion()
  {
    return Integer.parseInt(Build.VERSION.SDK);
  }
  
  public static void loadLibrary(Context paramContext, String paramString)
    throws UnsatisfiedLinkError
  {
    paramContext = getLibrarySearchPaths(paramContext);
    String str1 = System.mapLibraryName(paramString);
    int j = paramContext.length;
    int i = 0;
    while (i < j)
    {
      String str2 = paramContext[i];
      str2 = str2 + "/" + str1;
      if (!new File(str2).exists())
      {
        i += 1;
      }
      else
      {
        System.load(str2);
        return;
      }
    }
    System.loadLibrary(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.smtt.export.external.LibraryLoader
 * JD-Core Version:    0.7.0.1
 */