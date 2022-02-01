package c.t.m.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;

public final class cd
{
  public float a = -1.0F;
  public float b;
  public long c = -1L;
  public double d = -1.0D;
  public double e = -1.0D;
  public double f = -1.0D;
  public double g;
  public double h = 0.0D;
  public double i = 0.0D;
  
  public static int a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {}
    for (int j = 1; j != 0; j = 0) {
      return -1;
    }
    try
    {
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext != null)
      {
        j = paramContext.getType();
        return j;
      }
    }
    catch (Exception paramContext) {}
    return -1;
  }
  
  public static boolean b(Context paramContext)
  {
    int j;
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null) {
        break label62;
      }
      j = 1;
    }
    catch (Exception paramContext)
    {
      NetworkInfo.State localState;
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if ((paramContext != null) && (paramContext.isConnected()))
    {
      paramContext = paramContext.getState();
      localState = NetworkInfo.State.CONNECTED;
      if (paramContext == localState) {
        return true;
      }
    }
    return false;
    while (j != 0)
    {
      return false;
      label62:
      j = 0;
    }
  }
  
  public final void a()
  {
    this.f = -1.0D;
    this.a = -1.0F;
    this.c = -1L;
    this.h = 0.0D;
    this.i = 0.0D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.cd
 * JD-Core Version:    0.7.0.1
 */