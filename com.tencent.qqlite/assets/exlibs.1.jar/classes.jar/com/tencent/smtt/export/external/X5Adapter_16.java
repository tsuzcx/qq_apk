package com.tencent.smtt.export.external;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;

public class X5Adapter_16
{
  @TargetApi(4)
  public static String getNativeLibraryDirDonut(Context paramContext)
  {
    paramContext = paramContext.getApplicationInfo().dataDir;
    return paramContext + "/lib";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.export.external.X5Adapter_16
 * JD-Core Version:    0.7.0.1
 */