package com.tencent.mm.sdk.platformtools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import com.tencent.token.pq;
import com.tencent.token.ps;
import com.tencent.token.pt;
import com.tencent.token.pt.b;
import com.tencent.token.py;
import java.util.LinkedList;
import java.util.List;

public class LBSManager
  extends BroadcastReceiver
{
  private static a e;
  boolean a;
  boolean b;
  boolean c;
  int d;
  private b f;
  private Context g;
  private ps h;
  
  private String a()
  {
    Object localObject2 = (WifiManager)this.g.getSystemService("wifi");
    if (localObject2 == null) {}
    for (Object localObject1 = "no wifi service";; localObject1 = "WIFILocation wifi info null")
    {
      pq.a("MicroMsg.LBSManager", (String)localObject1);
      return "";
      if (((WifiManager)localObject2).getConnectionInfo() != null) {
        break;
      }
    }
    localObject1 = new LinkedList();
    localObject2 = ((WifiManager)localObject2).getScanResults();
    if (localObject2 != null)
    {
      int i = 0;
      while (i < ((List)localObject2).size())
      {
        String str = ((ScanResult)((List)localObject2).get(i)).BSSID;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((ScanResult)((List)localObject2).get(i)).level);
        ((List)localObject1).add(new pt.b(str, localStringBuilder.toString()));
        i += 1;
      }
    }
    return pt.a((List)localObject1);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramIntent = (Location)paramIntent.getExtras().get("location");
    this.d += 1;
    if (paramIntent != null)
    {
      boolean bool = "gps".equals(paramIntent.getProvider());
      if (((bool) && (paramIntent.getAccuracy() <= 200.0F)) || ((!bool) && (paramIntent.getAccuracy() <= 1000.0F) && (paramIntent.getAccuracy() > 0.0F)))
      {
        int i = bool ^ true;
        float f1 = (float)paramIntent.getLatitude();
        float f2 = (float)paramIntent.getLongitude();
        int j = (int)paramIntent.getAccuracy();
        if (j != 0)
        {
          paramContext = new StringBuilder("setLocationCache [");
          paramContext.append(f1);
          paramContext.append(",");
          paramContext.append(f2);
          paramContext.append("] acc:");
          paramContext.append(j);
          paramContext.append(" source:");
          paramContext.append(i);
          pq.d("MicroMsg.LBSManager", paramContext.toString());
          if (e == null) {
            e = new a();
          }
          paramContext = e;
          paramContext.a = f1;
          paramContext.b = f2;
          paramContext.c = j;
          paramContext.d = System.currentTimeMillis();
          e.e = i;
        }
        if ((this.f != null) && ((!this.a) || (!this.b) || (!this.c)))
        {
          py.a(a());
          py.a(pt.b(pt.a(this.g)));
          if (!this.a)
          {
            this.h.a();
            this.a = true;
            this.a = true;
            paramContext = new StringBuilder("location by provider ok:[");
          }
          for (;;)
          {
            paramContext.append(paramIntent.getLatitude());
            paramContext.append(" , ");
            paramContext.append(paramIntent.getLongitude());
            paramContext.append("]  accuracy:");
            paramContext.append(paramIntent.getAccuracy());
            paramContext.append("  retry count:");
            paramContext.append(this.d);
            paramContext.append(" isGpsProvider:");
            paramContext.append(bool);
            pq.d("MicroMsg.LBSManager", paramContext.toString());
            paramIntent.getLatitude();
            paramIntent.getLongitude();
            paramIntent.getAccuracy();
            return;
            if ((!this.b) && (i == 0))
            {
              this.b = true;
              paramContext = new StringBuilder("report location by GPS ok:[");
            }
            else
            {
              if ((this.c) || (i != 1)) {
                break;
              }
              this.c = true;
              paramContext = new StringBuilder("report location by Network ok:[");
            }
          }
        }
      }
    }
  }
  
  static final class a
  {
    float a = -1000.0F;
    float b = -1000.0F;
    int c = -1000;
    long d;
    int e = 1;
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.LBSManager
 * JD-Core Version:    0.7.0.1
 */