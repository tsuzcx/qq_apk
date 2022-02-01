package c.t.m.g;

import alkz;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import java.util.LinkedList;

public final class ao
{
  public LinkedList<bh> a = null;
  public bi b = null;
  public bi c = null;
  public float d = 0.0F;
  public float e = 0.0F;
  public long f = 0L;
  public boolean g = true;
  public float h = 0.0F;
  public at i;
  private final float j = 1.0F;
  private final float k = 0.6F;
  
  @Deprecated
  @SuppressLint({"MissingPermission"})
  public static WifiInfo a(Context paramContext)
  {
    Object localObject;
    label114:
    do
    {
      try
      {
        localObject = (WifiManager)ad.a().getApplicationContext().getSystemService("wifi");
        if (paramContext == null) {
          paramContext = null;
        } else {
          paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        }
      }
      catch (Throwable paramContext)
      {
        boolean bool;
        int m;
        return null;
      }
      localObject = alkz.a((WifiManager)localObject);
      paramContext = paramContext.getNetworkInfo(1);
      if ((localObject == null) || (paramContext == null) || (!paramContext.isConnected())) {
        break label134;
      }
      paramContext = ((WifiInfo)localObject).getBSSID();
      if ((paramContext != null) && (!paramContext.equals("000000000000")) && (!paramContext.equals("00-00-00-00-00-00")))
      {
        bool = paramContext.equals("00:00:00:00:00:00");
        if (!bool) {
          break label114;
        }
      }
      for (m = 0;; m = 1)
      {
        paramContext = (Context)localObject;
        if (m != 0) {
          break;
        }
        return null;
      }
    } while ((localObject != null) && (paramContext != null));
    paramContext = null;
    return paramContext;
    label134:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.ao
 * JD-Core Version:    0.7.0.1
 */