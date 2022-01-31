package com.tencent.mapsdk.net;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.tencent.tencentmap.mapsdk.a.d;

public final class b
{
  private static b c;
  private int a = 0;
  private a b;
  
  public static b a()
  {
    if (c == null) {
      c = new b();
    }
    return c;
  }
  
  public static int c()
  {
    return a().a;
  }
  
  public final void b()
  {
    Object localObject = ((TelephonyManager)NetContext.getContext().getSystemService("phone")).getNetworkOperator();
    if (d.a((String)localObject)) {}
    String str;
    do
    {
      return;
      str = ((String)localObject).substring(0, 3);
    } while ((str == null) || (!str.equals("460")));
    localObject = ((String)localObject).substring(3);
    int j = 0;
    try
    {
      i = Integer.parseInt((String)localObject);
      j = i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      int i;
      label67:
      int k;
      break label67;
    }
    k = 0;
    i = k;
    switch (j)
    {
    default: 
      i = k;
    }
    while (this.a != i)
    {
      this.a = i;
      if (this.b == null) {
        break;
      }
      localObject = this.b;
      return;
      i = 1;
      continue;
      i = 2;
      continue;
      i = 3;
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mapsdk.net.b
 * JD-Core Version:    0.7.0.1
 */