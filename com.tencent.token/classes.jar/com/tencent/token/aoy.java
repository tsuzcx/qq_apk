package com.tencent.token;

import android.content.Context;
import android.os.Handler;
import java.util.concurrent.ConcurrentHashMap;
import tmsdk.common.c.a.b;

public final class aoy
{
  private static aoy d;
  private static Object e = new Object();
  public Context a = aos.a();
  public ConcurrentHashMap b = new ConcurrentHashMap();
  private Handler c = null;
  
  public static aoy a()
  {
    if (d == null) {
      synchronized (e)
      {
        if (d == null) {
          d = new aoy();
        }
      }
    }
    return d;
  }
  
  public final void a(String paramString)
  {
    paramString = (b)this.b.remove(paramString);
    if (paramString != null) {
      this.a.unregisterReceiver(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aoy
 * JD-Core Version:    0.7.0.1
 */