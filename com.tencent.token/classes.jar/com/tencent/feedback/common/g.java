package com.tencent.feedback.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class g
{
  private static boolean a = false;
  private static boolean b = false;
  
  public static boolean a(Context paramContext)
  {
    paramContext = d(paramContext);
    return (paramContext != null) && (paramContext.getType() == 1);
  }
  
  public static boolean b(Context paramContext)
  {
    paramContext = d(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public static String c(Context paramContext)
  {
    paramContext = d(paramContext);
    if (paramContext == null) {
      return "unknown";
    }
    if (paramContext.getType() == 1) {
      return "wifi";
    }
    Object localObject = paramContext.getExtraInfo();
    paramContext = (Context)localObject;
    if (localObject != null)
    {
      paramContext = (Context)localObject;
      if (((String)localObject).length() > 64) {
        paramContext = ((String)localObject).substring(0, 64);
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext);
    return ((StringBuilder)localObject).toString();
  }
  
  private static NetworkInfo d(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      if (!e.a(paramContext)) {
        paramContext.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.common.g
 * JD-Core Version:    0.7.0.1
 */