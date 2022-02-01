package com.tencent.mm.sdk.platformtools;

import android.content.Context;

public final class MMApplicationContext
{
  private static String am = "com.tencent.mm";
  private static Context q;
  
  public static Context getContext()
  {
    return q;
  }
  
  public static String getDefaultPreferencePath()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(am);
    localStringBuilder.append("_preferences");
    return localStringBuilder.toString();
  }
  
  public static String getPackageName()
  {
    return am;
  }
  
  public static void setContext(Context paramContext)
  {
    q = paramContext;
    am = paramContext.getPackageName();
    paramContext = new StringBuilder("setup application context for package: ");
    paramContext.append(am);
    Log.d("MicroMsg.MMApplicationContext", paramContext.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMApplicationContext
 * JD-Core Version:    0.7.0.1
 */