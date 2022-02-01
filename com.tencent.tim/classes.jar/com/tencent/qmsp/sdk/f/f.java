package com.tencent.qmsp.sdk.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class f
{
  public static NetworkInfo a(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      return paramContext;
    }
    finally
    {
      g.b("Qp.NU", 0, paramContext.toString());
    }
    return null;
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool = true;
    if (paramContext == null) {
      return false;
    }
    paramContext = a(paramContext);
    if ((paramContext != null) && (paramContext.getType() == 1)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.f.f
 * JD-Core Version:    0.7.0.1
 */