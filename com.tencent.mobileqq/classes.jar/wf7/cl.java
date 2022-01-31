package wf7;

import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.NetworkInfo.State;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import java.util.List;

public class cl
{
  public static NetworkInfo.DetailedState a(NetworkInfo.DetailedState paramDetailedState, WifiInfo paramWifiInfo)
  {
    if (paramDetailedState == null) {
      paramWifiInfo = null;
    }
    SupplicantState localSupplicantState;
    label59:
    do
    {
      do
      {
        do
        {
          return paramWifiInfo;
          if ((paramWifiInfo == null) || (!cb.l(b(paramWifiInfo)))) {
            return NetworkInfo.DetailedState.DISCONNECTED;
          }
          localSupplicantState = paramWifiInfo.getSupplicantState();
          if (paramDetailedState != NetworkInfo.DetailedState.DISCONNECTED) {
            break label59;
          }
          if (a(localSupplicantState)) {
            break;
          }
          paramWifiInfo = paramDetailedState;
        } while (localSupplicantState != SupplicantState.COMPLETED);
        return WifiInfo.getDetailedStateOf(localSupplicantState);
        paramWifiInfo = paramDetailedState;
      } while (paramDetailedState != NetworkInfo.DetailedState.CONNECTED);
      paramWifiInfo = paramDetailedState;
    } while (localSupplicantState == SupplicantState.COMPLETED);
    return WifiInfo.getDetailedStateOf(localSupplicantState);
  }
  
  public static NetworkInfo.DetailedState a(NetworkInfo paramNetworkInfo, WifiInfo paramWifiInfo)
  {
    if ((paramNetworkInfo == null) || (paramNetworkInfo.getType() != 1)) {
      return NetworkInfo.DetailedState.DISCONNECTED;
    }
    if (paramNetworkInfo.getState() == NetworkInfo.State.DISCONNECTED) {
      return NetworkInfo.DetailedState.DISCONNECTED;
    }
    if (paramNetworkInfo != null) {}
    for (paramNetworkInfo = paramNetworkInfo.getDetailedState();; paramNetworkInfo = null) {
      return a(paramNetworkInfo, paramWifiInfo);
    }
  }
  
  public static NetworkInfo.DetailedState a(SupplicantState paramSupplicantState, WifiInfo paramWifiInfo)
  {
    if (paramSupplicantState != null) {}
    for (paramSupplicantState = WifiInfo.getDetailedStateOf(paramSupplicantState);; paramSupplicantState = null) {
      return a(paramSupplicantState, paramWifiInfo);
    }
  }
  
  public static boolean a(SupplicantState paramSupplicantState)
  {
    switch (cl.1.hA[paramSupplicantState.ordinal()])
    {
    case 6: 
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    default: 
      return false;
    }
    return true;
  }
  
  public static String b(WifiInfo paramWifiInfo)
  {
    Object localObject;
    if (paramWifiInfo == null) {
      localObject = "";
    }
    WifiConfiguration localWifiConfiguration;
    do
    {
      String str;
      do
      {
        return localObject;
        str = cb.j(paramWifiInfo.getSSID());
        localObject = str;
      } while (cb.l(str));
      localObject = bw.as().at();
      localWifiConfiguration = null;
      if (paramWifiInfo.getNetworkId() != bx.gI) {
        localWifiConfiguration = bw.a(paramWifiInfo.getNetworkId(), (List)localObject);
      }
      localObject = str;
    } while (localWifiConfiguration == null);
    return cb.j(localWifiConfiguration.SSID);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     wf7.cl
 * JD-Core Version:    0.7.0.1
 */