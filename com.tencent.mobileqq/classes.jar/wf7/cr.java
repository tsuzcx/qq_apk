package wf7;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.os.Handler;
import com.tencent.qqpimsecure.wificore.api.connect.b;
import com.tencent.qqpimsecure.wificore.api.connect.d;
import com.tencent.qqpimsecure.wificore.api.event.CurrentSessionItem;
import com.tencent.qqpimsecure.wificore.api.event.a;
import com.tencent.qqpimsecure.wificore.api.event.c;
import java.util.Iterator;
import java.util.List;

public class cr
  implements c
{
  private ConnectivityManager hT;
  private a hU = null;
  private final CurrentSessionItem hV = new CurrentSessionItem();
  
  protected cr()
  {
    try
    {
      this.hT = ((ConnectivityManager)bz.av().t().getSystemService("connectivity"));
      return;
    }
    catch (Exception localException) {}
  }
  
  public static int a(NetworkInfo.DetailedState paramDetailedState)
  {
    if (paramDetailedState == null) {}
    do
    {
      return -1;
      switch (cr.3.hZ[paramDetailedState.ordinal()])
      {
      default: 
        if (paramDetailedState.ordinal() == 10) {
          return 4;
        }
        break;
      case 1: 
      case 2: 
      case 3: 
        return 0;
      case 4: 
        return 1;
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
        return 4;
      }
      if (paramDetailedState.ordinal() == 11) {
        return 0;
      }
    } while (paramDetailedState.ordinal() != 12);
    return 0;
  }
  
  private void a(long paramLong, NetworkInfo.DetailedState paramDetailedState, WifiInfo paramWifiInfo)
  {
    int j = a(paramDetailedState);
    int i = b(paramDetailedState);
    if (j == 0) {
      i = b(paramDetailedState);
    }
    label401:
    label403:
    for (;;)
    {
      n(paramLong + " handleWifiEvent state:" + CurrentSessionItem.o(j));
      n(paramLong + " handleWifiEvent detailState:" + CurrentSessionItem.a(j, i));
      CurrentSessionItem localCurrentSessionItem = new CurrentSessionItem();
      localCurrentSessionItem.ey = cl.b(paramWifiInfo);
      paramDetailedState = ((bq)ao.c().i(1)).a(paramWifiInfo);
      if (paramDetailedState != null)
      {
        localCurrentSessionItem.eV = paramDetailedState.ab();
        localCurrentSessionItem.eY = paramDetailedState.ae().i();
        localCurrentSessionItem.fa = paramDetailedState.ac().am();
      }
      for (;;)
      {
        localCurrentSessionItem.eW = j;
        localCurrentSessionItem.eX = i;
        localCurrentSessionItem.eZ = false;
        if ((localCurrentSessionItem.eW == 1) && (this.hV.eW == 1) && (this.hV.eX > 4097) && (cb.c(this.hV.ey, localCurrentSessionItem.ey)))
        {
          return;
          if (j == 1)
          {
            paramDetailedState = bu.ar();
            if ((paramDetailedState != null) && (paramDetailedState.isAvailable())) {}
            for (i = 4097;; i = 4096) {
              break;
            }
          }
          if (j != 4) {
            break label403;
          }
          i = 8;
          break;
          paramDetailedState = bw.as().at();
          if ((paramWifiInfo != null) && (paramWifiInfo.getNetworkId() != bx.gI)) {
            paramDetailedState = bw.a(paramWifiInfo.getNetworkId(), paramDetailedState);
          }
        }
        for (;;)
        {
          if (paramDetailedState == null) {
            break label401;
          }
          localCurrentSessionItem.eV = cb.d(paramDetailedState);
          break;
          if (paramDetailedState != null)
          {
            Iterator localIterator = paramDetailedState.iterator();
            for (;;)
            {
              if (localIterator.hasNext())
              {
                paramDetailedState = (WifiConfiguration)localIterator.next();
                if ((paramWifiInfo != null) && (cb.c(paramDetailedState.SSID, paramWifiInfo.getSSID())))
                {
                  break;
                  c(localCurrentSessionItem);
                  return;
                }
              }
            }
          }
          paramDetailedState = null;
        }
      }
    }
  }
  
  private void aY()
  {
    switch (this.hV.eW)
    {
    }
    if (this.hU != null) {
      this.hU.a(this.hV.l());
    }
  }
  
  private int b(NetworkInfo.DetailedState paramDetailedState)
  {
    if (paramDetailedState == null) {}
    do
    {
      return -1;
      switch (cr.3.hZ[paramDetailedState.ordinal()])
      {
      default: 
        if (paramDetailedState.ordinal() == 10) {
          return 10;
        }
        break;
      case 1: 
        return 3;
      case 2: 
        return 4;
      case 5: 
        return 0;
      case 6: 
        return 1;
      case 3: 
        return 2;
      case 4: 
        return 5;
      case 7: 
        return 8;
      case 8: 
        return 7;
      case 9: 
        return 9;
      case 10: 
        return 6;
      }
      if (paramDetailedState.ordinal() == 11) {
        return 12;
      }
    } while (paramDetailedState.ordinal() != 12);
    return 11;
  }
  
  private void n(String paramString) {}
  
  public void a(Intent paramIntent)
  {
    int i = -1;
    long l = System.currentTimeMillis();
    if (((d)ao.c().i(4)).k())
    {
      n(l + " handleSupplicantStateChange|wifimanager connecting , ignore");
      return;
    }
    for (;;)
    {
      try
      {
        localObject1 = (SupplicantState)paramIntent.getParcelableExtra("newState");
        localObject1 = paramIntent;
      }
      catch (Exception paramIntent)
      {
        try
        {
          j = paramIntent.getIntExtra("supplicantError", -1);
          i = j;
          n(l + " state: " + ((SupplicantState)localObject1).toString() + ", suplError: " + j);
          if (j != 1) {
            break;
          }
          paramIntent = new CurrentSessionItem();
          paramIntent.eW = 3;
          paramIntent.eX = 3;
          paramIntent.eZ = false;
          localObject1 = ca.getConnectionInfo();
          localObject1 = ((bq)ao.c().i(1)).a((WifiInfo)localObject1);
          localObject2 = new StringBuilder().append(l).append("handleSupplicantStateChange  ap == null ? ");
          if (localObject1 == null) {
            break label287;
          }
          bool = true;
          n(bool);
          if (localObject1 == null) {
            break label293;
          }
          paramIntent.ey = ((bn)localObject1).Z();
          paramIntent.eV = ((bn)localObject1).ab();
          paramIntent.fa = ((bn)localObject1).ac().am();
          if (!cb.l(paramIntent.ey))
          {
            paramIntent.eW = 4;
            paramIntent.eX = 8;
          }
          c(paramIntent);
          return;
        }
        catch (Exception paramIntent)
        {
          for (;;)
          {
            Object localObject1;
            int j;
            Object localObject2;
            boolean bool;
            paramIntent = (Intent)localObject1;
          }
        }
        paramIntent = paramIntent;
        i = -1;
        paramIntent = null;
      }
      j = i;
      continue;
      label287:
      bool = false;
      continue;
      label293:
      paramIntent.ey = this.hV.ey;
      paramIntent.eV = this.hV.eV;
    }
    localObject2 = ca.getConnectionInfo();
    paramIntent = bu.ar();
    n(l + " currentWifiInfo:" + localObject2);
    if ((paramIntent != null) && (paramIntent.isConnected()) && (paramIntent.getType() == 1))
    {
      localObject1 = new CurrentSessionItem();
      localObject2 = ((bq)ao.c().i(1)).a((WifiInfo)localObject2);
      if (localObject2 != null)
      {
        ((CurrentSessionItem)localObject1).ey = ((bn)localObject2).Z();
        ((CurrentSessionItem)localObject1).eV = ((bn)localObject2).ab();
        ((CurrentSessionItem)localObject1).eY = ((bn)localObject2).ae().i();
        ((CurrentSessionItem)localObject1).fa = ((bn)localObject2).ac().am();
        if (!paramIntent.isAvailable()) {
          break label500;
        }
      }
      label500:
      for (i = 4097;; i = 4096)
      {
        ((CurrentSessionItem)localObject1).eX = i;
        return;
        ((CurrentSessionItem)localObject1).ey = this.hV.ey;
        ((CurrentSessionItem)localObject1).eV = this.hV.eV;
        break;
      }
    }
    a(l, cl.a((SupplicantState)localObject1, (WifiInfo)localObject2), (WifiInfo)localObject2);
  }
  
  public void aW()
  {
    long l = System.currentTimeMillis();
    n("syncCurrentSession | logIdGroupId=" + l);
    bz.av().ax().post(new cr.2(this, l));
  }
  
  public void b(Intent paramIntent)
  {
    long l = System.currentTimeMillis();
    if (((d)ao.c().i(4)).k())
    {
      n(l + " handleNetworkStateChange|wifimanager connecting , ignore");
      return;
    }
    n(l + " ----------start NETWORK_STATE_CHANGED_ACTION----------");
    paramIntent = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
    n(l + " getParcelableExtra NetworkInfo:" + paramIntent);
    WifiInfo localWifiInfo = ca.getConnectionInfo();
    n(l + " currentWifiInfo:" + localWifiInfo);
    a(l, cl.a(paramIntent, localWifiInfo), localWifiInfo);
    int i = cb.gI;
    if (localWifiInfo != null) {
      localWifiInfo.getNetworkId();
    }
    paramIntent = getActiveNetworkInfo();
    if (paramIntent != null) {
      n(l + " activeNetworkInfo:" + paramIntent);
    }
    for (;;)
    {
      n(l + " ----------finish NETWORK_STATE_CHANGED_ACTION----------");
      return;
      n(l + " activeNetworkInfo == null");
    }
  }
  
  public void c(Intent paramIntent)
  {
    long l = System.currentTimeMillis();
    if (((d)ao.c().i(4)).k())
    {
      n(l + " handleConnectivityChange|wifimanager connecting , ignore");
      return;
    }
    n(l + " ----------start CONNECTIVITY_ACTION----------");
    Object localObject = ca.getConnectionInfo();
    n(l + " WifiInfo:" + localObject);
    NetworkInfo localNetworkInfo = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
    n(l + " NetworkInfo getParcelableExtra:" + localNetworkInfo);
    int j;
    int i;
    if ((localNetworkInfo != null) && (localNetworkInfo.getType() == 1))
    {
      paramIntent = new CurrentSessionItem();
      NetworkInfo.DetailedState localDetailedState = cl.a(localNetworkInfo, (WifiInfo)localObject);
      j = a(localDetailedState);
      i = b(localDetailedState);
      if (j == 1)
      {
        localObject = ((bq)ao.c().i(1)).a((WifiInfo)localObject);
        if (localObject != null)
        {
          paramIntent.ey = ((bn)localObject).Z();
          paramIntent.eV = ((bn)localObject).ab();
          paramIntent.eY = ((bn)localObject).ae().i();
          paramIntent.fa = ((bn)localObject).ac().am();
          if (!localNetworkInfo.isAvailable()) {
            break label415;
          }
          i = 4097;
          label278:
          n(l + " getParcelableExtra NetworkInfo state:" + CurrentSessionItem.o(j));
          n(l + " getParcelableExtra NetworkInfo detailState:" + CurrentSessionItem.a(j, i));
          paramIntent.eW = j;
          paramIntent.eX = i;
          paramIntent.eZ = false;
        }
      }
    }
    for (;;)
    {
      c(paramIntent);
      n(l + " ----------finish CONNECTIVITY_ACTION----------");
      return;
      paramIntent.ey = this.hV.ey;
      paramIntent.eV = this.hV.eV;
      break;
      label415:
      i = 4096;
      break label278;
      if (j == 4)
      {
        paramIntent.ey = this.hV.ey;
        paramIntent.eV = this.hV.eV;
        i = 8;
        break label278;
      }
      break label278;
      paramIntent = null;
    }
  }
  
  public void c(a parama)
  {
    this.hU = parama;
  }
  
  protected boolean c(CurrentSessionItem paramCurrentSessionItem)
  {
    CurrentSessionItem localCurrentSessionItem = paramCurrentSessionItem;
    if (paramCurrentSessionItem == null) {
      localCurrentSessionItem = new CurrentSessionItem();
    }
    if (!this.hV.equals(localCurrentSessionItem))
    {
      paramCurrentSessionItem = this.hV;
      paramCurrentSessionItem.eU += 1L;
      this.hV.ey = localCurrentSessionItem.ey;
      this.hV.eV = localCurrentSessionItem.eV;
      this.hV.eW = localCurrentSessionItem.eW;
      this.hV.eX = localCurrentSessionItem.eX;
      this.hV.eZ = localCurrentSessionItem.eZ;
      this.hV.fa = localCurrentSessionItem.fa;
      this.hV.eY = localCurrentSessionItem.eY;
      aY();
      return true;
    }
    return false;
  }
  
  public NetworkInfo getActiveNetworkInfo()
  {
    try
    {
      NetworkInfo localNetworkInfo = this.hT.getActiveNetworkInfo();
      return localNetworkInfo;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public CurrentSessionItem n()
  {
    return this.hV;
  }
  
  public void onCreate()
  {
    ((d)ao.c().i(4)).a(new cr.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.cr
 * JD-Core Version:    0.7.0.1
 */