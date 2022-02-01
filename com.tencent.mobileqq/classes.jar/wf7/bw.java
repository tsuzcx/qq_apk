package wf7;

import android.net.wifi.WifiConfiguration;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bw
{
  private static boolean gv = false;
  private static Field gw;
  private static Field gx;
  private static Class gy;
  private static Field gz;
  
  public static WifiConfiguration a(int paramInt, List<WifiConfiguration> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        WifiConfiguration localWifiConfiguration = (WifiConfiguration)paramList.next();
        if (localWifiConfiguration.networkId == paramInt) {
          return localWifiConfiguration;
        }
      }
    }
    return null;
  }
  
  public static WifiConfiguration a(String paramString, int paramInt, List<WifiConfiguration> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        WifiConfiguration localWifiConfiguration = (WifiConfiguration)paramList.next();
        if ((cb.j(localWifiConfiguration.SSID).compareTo(paramString) == 0) && (cb.d(localWifiConfiguration) == paramInt)) {
          return localWifiConfiguration;
        }
      }
    }
    return null;
  }
  
  public static final bw as()
  {
    return bw.b.gF;
  }
  
  public static int b(WifiConfiguration paramWifiConfiguration)
  {
    if (paramWifiConfiguration == null) {
      return 0;
    }
    if (paramWifiConfiguration.status == 1) {
      if (!gv)
      {
        gv = true;
        try
        {
          gw = WifiConfiguration.class.getDeclaredField("disableReason");
          gw.setAccessible(true);
        }
        catch (Throwable localThrowable1)
        {
          localThrowable1.printStackTrace();
        }
        if (gw == null) {
          try
          {
            gx = WifiConfiguration.class.getDeclaredField("mNetworkSelectionStatus");
            gx.setAccessible(true);
            gy = Class.forName("android.net.wifi.WifiConfiguration$NetworkSelectionStatus");
            gz = gy.getDeclaredField("mNetworkSelectionDisableReason");
            gz.setAccessible(true);
          }
          catch (Throwable localThrowable2)
          {
            localThrowable2.printStackTrace();
          }
        }
      }
    }
    int i;
    label240:
    label247:
    do
    {
      try
      {
        if (gw != null) {
          return ((Integer)gw.get(paramWifiConfiguration)).intValue();
        }
        if ((gx == null) || (gy == null) || (gz == null)) {
          break label240;
        }
        paramWifiConfiguration = gx.get(paramWifiConfiguration);
        j = ((Integer)gz.get(paramWifiConfiguration)).intValue();
        if (bw.c.i("NETWORK_SELECTION_DISABLED_MAX") < 13) {
          if (j != bw.c.i("DISABLED_AUTHENTICATION_FAILURE")) {
            break label247;
          }
        } else {
          if (j != bw.c.i("DISABLED_BY_WRONG_PASSWORD")) {
            break label247;
          }
        }
      }
      catch (Throwable paramWifiConfiguration)
      {
        int j;
        paramWifiConfiguration.printStackTrace();
      }
      if (j == bw.c.i("DISABLED_DNS_FAILURE")) {
        return 1;
      }
      if (j == bw.c.i("DISABLED_DHCP_FAILURE")) {
        return 2;
      }
      i = bw.c.i("DISABLED_ASSOCIATION_REJECTION");
      if (j == i) {
        return 4;
      }
      return 0;
      i = 1;
      continue;
      i = 0;
    } while (i == 0);
    return 3;
  }
  
  public static bw.a c(WifiConfiguration paramWifiConfiguration)
  {
    if (paramWifiConfiguration == null) {
      return bw.a.gA;
    }
    if (paramWifiConfiguration.status == 1)
    {
      int i = b(paramWifiConfiguration);
      if (i == 0) {
        return bw.a.gA;
      }
      if (i == 3) {
        return bw.a.gB;
      }
      return bw.a.gC;
    }
    return bw.a.gC;
  }
  
  public boolean C(int paramInt)
  {
    if (ca.removeNetwork(paramInt))
    {
      ca.saveConfiguration();
      return true;
    }
    return false;
  }
  
  public List<WifiConfiguration> at()
  {
    return ca.getConfiguredNetworks();
  }
  
  public List<WifiConfiguration> b(String paramString, int paramInt)
  {
    Object localObject3 = at();
    Object localObject2 = null;
    Object localObject1 = null;
    if (localObject3 != null)
    {
      localObject3 = ((List)localObject3).iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        WifiConfiguration localWifiConfiguration = (WifiConfiguration)((Iterator)localObject3).next();
        if ((cb.j(localWifiConfiguration.SSID).compareTo(paramString) == 0) && (cb.d(localWifiConfiguration) == paramInt))
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new ArrayList();
          }
          ((List)localObject2).add(localWifiConfiguration);
          localObject1 = localObject2;
        }
      }
    }
    return localObject2;
  }
  
  public boolean c(String paramString, int paramInt)
  {
    paramString = b(paramString, paramInt);
    if ((paramString != null) && (paramString.size() > 0))
    {
      boolean bool = false;
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        bool |= C(((WifiConfiguration)paramString.next()).networkId);
      }
      return bool;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.bw
 * JD-Core Version:    0.7.0.1
 */