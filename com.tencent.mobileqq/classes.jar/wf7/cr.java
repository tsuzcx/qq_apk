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
    if (paramDetailedState == null) {
      return -1;
    }
    switch (cr.3.hZ[paramDetailedState.ordinal()])
    {
    default: 
      if (paramDetailedState.ordinal() != 10) {
        break;
      }
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
      return 4;
    case 4: 
      return 1;
    case 1: 
    case 2: 
    case 3: 
      return 0;
    }
    if (paramDetailedState.ordinal() == 11) {
      return 0;
    }
    if (paramDetailedState.ordinal() == 12) {
      return 0;
    }
    return -1;
  }
  
  private void a(long paramLong, NetworkInfo.DetailedState paramDetailedState, WifiInfo paramWifiInfo)
  {
    int j = a(paramDetailedState);
    int i = b(paramDetailedState);
    if (j == 0)
    {
      i = b(paramDetailedState);
    }
    else if (j == 1)
    {
      paramDetailedState = bu.ar();
      if ((paramDetailedState != null) && (paramDetailedState.isAvailable())) {
        i = 4097;
      } else {
        i = 4096;
      }
    }
    else if (j == 4)
    {
      i = 8;
    }
    paramDetailedState = new StringBuilder();
    paramDetailedState.append(paramLong);
    paramDetailedState.append(" handleWifiEvent state:");
    paramDetailedState.append(CurrentSessionItem.o(j));
    n(paramDetailedState.toString());
    paramDetailedState = new StringBuilder();
    paramDetailedState.append(paramLong);
    paramDetailedState.append(" handleWifiEvent detailState:");
    paramDetailedState.append(CurrentSessionItem.a(j, i));
    n(paramDetailedState.toString());
    CurrentSessionItem localCurrentSessionItem = new CurrentSessionItem();
    localCurrentSessionItem.ey = cl.b(paramWifiInfo);
    paramDetailedState = ((bq)ao.c().i(1)).a(paramWifiInfo);
    if (paramDetailedState != null)
    {
      localCurrentSessionItem.eV = paramDetailedState.ab();
      localCurrentSessionItem.eY = paramDetailedState.ae().i();
      localCurrentSessionItem.fa = paramDetailedState.ac().am();
    }
    else
    {
      Object localObject2 = bw.as().at();
      Object localObject1 = null;
      if ((paramWifiInfo != null) && (paramWifiInfo.getNetworkId() != bx.gI))
      {
        paramDetailedState = bw.a(paramWifiInfo.getNetworkId(), (List)localObject2);
      }
      else
      {
        paramDetailedState = localObject1;
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          do
          {
            paramDetailedState = localObject1;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            paramDetailedState = (WifiConfiguration)((Iterator)localObject2).next();
          } while ((paramWifiInfo == null) || (!cb.c(paramDetailedState.SSID, paramWifiInfo.getSSID())));
        }
      }
      if (paramDetailedState != null) {
        localCurrentSessionItem.eV = cb.d(paramDetailedState);
      }
    }
    localCurrentSessionItem.eW = j;
    localCurrentSessionItem.eX = i;
    localCurrentSessionItem.eZ = false;
    if ((localCurrentSessionItem.eW == 1) && (this.hV.eW == 1) && (this.hV.eX > 4097) && (cb.c(this.hV.ey, localCurrentSessionItem.ey))) {
      return;
    }
    c(localCurrentSessionItem);
  }
  
  private void aY()
  {
    int i = this.hV.eW;
    if ((i != 0) && (i != 1)) {}
    a locala = this.hU;
    if (locala != null) {
      locala.a(this.hV.l());
    }
  }
  
  private int b(NetworkInfo.DetailedState paramDetailedState)
  {
    if (paramDetailedState == null) {
      return -1;
    }
    switch (cr.3.hZ[paramDetailedState.ordinal()])
    {
    default: 
      if (paramDetailedState.ordinal() == 10) {
        return 10;
      }
      break;
    case 10: 
      return 6;
    case 9: 
      return 9;
    case 8: 
      return 7;
    case 7: 
      return 8;
    case 6: 
      return 1;
    case 5: 
      return 0;
    case 4: 
      return 5;
    case 3: 
      return 2;
    case 2: 
      return 4;
    case 1: 
      return 3;
    }
    if (paramDetailedState.ordinal() == 11) {
      return 12;
    }
    if (paramDetailedState.ordinal() == 12) {
      return 11;
    }
    return -1;
  }
  
  private void n(String paramString) {}
  
  public void a(Intent paramIntent)
  {
    long l = System.currentTimeMillis();
    if (((d)ao.c().i(4)).k())
    {
      paramIntent = new StringBuilder();
      paramIntent.append(l);
      paramIntent.append(" handleSupplicantStateChange|wifimanager connecting , ignore");
      n(paramIntent.toString());
      return;
    }
    int i = -1;
    try
    {
      localObject1 = (SupplicantState)paramIntent.getParcelableExtra("newState");
    }
    catch (Exception paramIntent)
    {
      int j;
      label155:
      label157:
      boolean bool;
      Object localObject2;
      StringBuilder localStringBuilder;
      break label155;
    }
    try
    {
      j = paramIntent.getIntExtra("supplicantError", -1);
      i = j;
      paramIntent = new StringBuilder();
      i = j;
      paramIntent.append(l);
      i = j;
      paramIntent.append(" state: ");
      i = j;
      paramIntent.append(((SupplicantState)localObject1).toString());
      i = j;
      paramIntent.append(", suplError: ");
      i = j;
      paramIntent.append(j);
      i = j;
      n(paramIntent.toString());
      i = j;
      paramIntent = (Intent)localObject1;
    }
    catch (Exception paramIntent)
    {
      paramIntent = (Intent)localObject1;
      break label157;
    }
    paramIntent = null;
    bool = true;
    if (i == 1)
    {
      paramIntent = new CurrentSessionItem();
      paramIntent.eW = 3;
      paramIntent.eX = 3;
      paramIntent.eZ = false;
      localObject1 = ca.getConnectionInfo();
      localObject1 = ((bq)ao.c().i(1)).a((WifiInfo)localObject1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append("handleSupplicantStateChange  ap == null ? ");
      if (localObject1 == null) {
        bool = false;
      }
      ((StringBuilder)localObject2).append(bool);
      n(((StringBuilder)localObject2).toString());
      if (localObject1 != null)
      {
        paramIntent.ey = ((bn)localObject1).Z();
        paramIntent.eV = ((bn)localObject1).ab();
        paramIntent.fa = ((bn)localObject1).ac().am();
      }
      else
      {
        paramIntent.ey = this.hV.ey;
        paramIntent.eV = this.hV.eV;
      }
      if (!cb.l(paramIntent.ey))
      {
        paramIntent.eW = 4;
        paramIntent.eX = 8;
      }
      c(paramIntent);
      return;
    }
    localObject2 = ca.getConnectionInfo();
    localObject1 = bu.ar();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(l);
    localStringBuilder.append(" currentWifiInfo:");
    localStringBuilder.append(localObject2);
    n(localStringBuilder.toString());
    if ((localObject1 != null) && (((NetworkInfo)localObject1).isConnected()) && (((NetworkInfo)localObject1).getType() == 1))
    {
      paramIntent = new CurrentSessionItem();
      localObject2 = ((bq)ao.c().i(1)).a((WifiInfo)localObject2);
      if (localObject2 != null)
      {
        paramIntent.ey = ((bn)localObject2).Z();
        paramIntent.eV = ((bn)localObject2).ab();
        paramIntent.eY = ((bn)localObject2).ae().i();
        paramIntent.fa = ((bn)localObject2).ac().am();
      }
      else
      {
        paramIntent.ey = this.hV.ey;
        paramIntent.eV = this.hV.eV;
      }
      if (((NetworkInfo)localObject1).isAvailable()) {
        i = 4097;
      } else {
        i = 4096;
      }
      paramIntent.eX = i;
      return;
    }
    a(l, cl.a(paramIntent, (WifiInfo)localObject2), (WifiInfo)localObject2);
  }
  
  public void aW()
  {
    long l = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("syncCurrentSession | logIdGroupId=");
    localStringBuilder.append(l);
    n(localStringBuilder.toString());
    bz.av().ax().post(new cr.2(this, l));
  }
  
  public void b(Intent paramIntent)
  {
    long l = System.currentTimeMillis();
    if (((d)ao.c().i(4)).k())
    {
      paramIntent = new StringBuilder();
      paramIntent.append(l);
      paramIntent.append(" handleNetworkStateChange|wifimanager connecting , ignore");
      n(paramIntent.toString());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append(" ----------start NETWORK_STATE_CHANGED_ACTION----------");
    n(((StringBuilder)localObject).toString());
    paramIntent = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append(" getParcelableExtra NetworkInfo:");
    ((StringBuilder)localObject).append(paramIntent);
    n(((StringBuilder)localObject).toString());
    localObject = ca.getConnectionInfo();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(l);
    localStringBuilder.append(" currentWifiInfo:");
    localStringBuilder.append(localObject);
    n(localStringBuilder.toString());
    a(l, cl.a(paramIntent, (WifiInfo)localObject), (WifiInfo)localObject);
    int i = cb.gI;
    if (localObject != null) {
      ((WifiInfo)localObject).getNetworkId();
    }
    paramIntent = getActiveNetworkInfo();
    if (paramIntent != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append(" activeNetworkInfo:");
      ((StringBuilder)localObject).append(paramIntent);
      n(((StringBuilder)localObject).toString());
    }
    else
    {
      paramIntent = new StringBuilder();
      paramIntent.append(l);
      paramIntent.append(" activeNetworkInfo == null");
      n(paramIntent.toString());
    }
    paramIntent = new StringBuilder();
    paramIntent.append(l);
    paramIntent.append(" ----------finish NETWORK_STATE_CHANGED_ACTION----------");
    n(paramIntent.toString());
  }
  
  public void c(Intent paramIntent)
  {
    long l = System.currentTimeMillis();
    if (((d)ao.c().i(4)).k())
    {
      paramIntent = new StringBuilder();
      paramIntent.append(l);
      paramIntent.append(" handleConnectivityChange|wifimanager connecting , ignore");
      n(paramIntent.toString());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append(" ----------start CONNECTIVITY_ACTION----------");
    n(((StringBuilder)localObject).toString());
    WifiInfo localWifiInfo = ca.getConnectionInfo();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append(" WifiInfo:");
    ((StringBuilder)localObject).append(localWifiInfo);
    n(((StringBuilder)localObject).toString());
    NetworkInfo localNetworkInfo = (NetworkInfo)paramIntent.getParcelableExtra("networkInfo");
    paramIntent = new StringBuilder();
    paramIntent.append(l);
    paramIntent.append(" NetworkInfo getParcelableExtra:");
    paramIntent.append(localNetworkInfo);
    n(paramIntent.toString());
    localObject = null;
    paramIntent = (Intent)localObject;
    if (localNetworkInfo != null)
    {
      paramIntent = (Intent)localObject;
      if (localNetworkInfo.getType() == 1)
      {
        paramIntent = new CurrentSessionItem();
        localObject = cl.a(localNetworkInfo, localWifiInfo);
        int j = a((NetworkInfo.DetailedState)localObject);
        int i = b((NetworkInfo.DetailedState)localObject);
        if (j == 1)
        {
          localObject = ((bq)ao.c().i(1)).a(localWifiInfo);
          if (localObject != null)
          {
            paramIntent.ey = ((bn)localObject).Z();
            paramIntent.eV = ((bn)localObject).ab();
            paramIntent.eY = ((bn)localObject).ae().i();
            paramIntent.fa = ((bn)localObject).ac().am();
          }
          else
          {
            paramIntent.ey = this.hV.ey;
            paramIntent.eV = this.hV.eV;
          }
          if (localNetworkInfo.isAvailable()) {
            i = 4097;
          } else {
            i = 4096;
          }
        }
        else if (j == 4)
        {
          paramIntent.ey = this.hV.ey;
          paramIntent.eV = this.hV.eV;
          i = 8;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append(" getParcelableExtra NetworkInfo state:");
        ((StringBuilder)localObject).append(CurrentSessionItem.o(j));
        n(((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(l);
        ((StringBuilder)localObject).append(" getParcelableExtra NetworkInfo detailState:");
        ((StringBuilder)localObject).append(CurrentSessionItem.a(j, i));
        n(((StringBuilder)localObject).toString());
        paramIntent.eW = j;
        paramIntent.eX = i;
        paramIntent.eZ = false;
      }
    }
    c(paramIntent);
    paramIntent = new StringBuilder();
    paramIntent.append(l);
    paramIntent.append(" ----------finish CONNECTIVITY_ACTION----------");
    n(paramIntent.toString());
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
    catch (Throwable localThrowable)
    {
      label10:
      break label10;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.cr
 * JD-Core Version:    0.7.0.1
 */