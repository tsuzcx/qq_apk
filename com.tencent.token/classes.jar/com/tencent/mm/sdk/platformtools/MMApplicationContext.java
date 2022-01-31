package com.tencent.mm.sdk.platformtools;

import android.content.Context;

public final class MMApplicationContext
{
  private static String am = "com.tencent.mm";
  private static Context q = null;
  
  public static Context getContext()
  {
    return q;
  }
  
  public static String getDefaultPreferencePath()
  {
    return am + "_preferences";
  }
  
  public static String getPackageName()
  {
    return am;
  }
  
  public static void setContext(Context paramContext)
  {
    q = paramContext;
    am = paramContext.getPackageName();
    Log.d("MicroMsg.MMApplicationContext", "setup application context for package: " + am);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMApplicationContext
 * JD-Core Version:    0.7.0.1
 */