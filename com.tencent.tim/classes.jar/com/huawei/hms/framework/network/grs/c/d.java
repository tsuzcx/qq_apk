package com.huawei.hms.framework.network.grs.c;

import android.os.SystemClock;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  private static Map<String, a> a = new ConcurrentHashMap(16);
  
  public static a a(String paramString)
  {
    Logger.v("RequestUtil", "map size of get is before:" + a.size());
    paramString = (a)a.get(paramString);
    Logger.v("RequestUtil", "map size of get is after:" + a.size());
    return paramString;
  }
  
  public static void a(String paramString, a parama)
  {
    Logger.v("RequestUtil", "map size of put is before:" + a.size());
    a.put(paramString, parama);
    Logger.v("RequestUtil", "map size of put is after:" + a.size());
  }
  
  public static class a
  {
    private long a;
    private long b;
    
    public a(long paramLong1, long paramLong2)
    {
      this.a = paramLong1;
      this.b = paramLong2;
    }
    
    public boolean a()
    {
      return SystemClock.elapsedRealtime() - this.b <= this.a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.c.d
 * JD-Core Version:    0.7.0.1
 */