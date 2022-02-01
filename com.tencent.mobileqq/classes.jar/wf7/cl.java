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
      return null;
    }
    if ((paramWifiInfo != null) && (cb.l(b(paramWifiInfo))))
    {
      SupplicantState localSupplicantState = paramWifiInfo.getSupplicantState();
      if (paramDetailedState == NetworkInfo.DetailedState.DISCONNECTED)
      {
        if (!a(localSupplicantState))
        {
          paramWifiInfo = paramDetailedState;
          if (localSupplicantState != SupplicantState.COMPLETED) {}
        }
        else
        {
          return WifiInfo.getDetailedStateOf(localSupplicantState);
        }
      }
      else
      {
        paramWifiInfo = paramDetailedState;
        if (paramDetailedState == NetworkInfo.DetailedState.CONNECTED)
        {
          paramWifiInfo = paramDetailedState;
          if (localSupplicantState != SupplicantState.COMPLETED) {
            paramWifiInfo = WifiInfo.getDetailedStateOf(localSupplicantState);
          }
        }
      }
      return paramWifiInfo;
    }
    return NetworkInfo.DetailedState.DISCONNECTED;
  }
  
  public static NetworkInfo.DetailedState a(NetworkInfo paramNetworkInfo, WifiInfo paramWifiInfo)
  {
    if ((paramNetworkInfo != null) && (paramNetworkInfo.getType() == 1))
    {
      if (paramNetworkInfo.getState() == NetworkInfo.State.DISCONNECTED) {
        return NetworkInfo.DetailedState.DISCONNECTED;
      }
      if (paramNetworkInfo != null) {
        paramNetworkInfo = paramNetworkInfo.getDetailedState();
      } else {
        paramNetworkInfo = null;
      }
      return a(paramNetworkInfo, paramWifiInfo);
    }
    return NetworkInfo.DetailedState.DISCONNECTED;
  }
  
  public static NetworkInfo.DetailedState a(SupplicantState paramSupplicantState, WifiInfo paramWifiInfo)
  {
    if (paramSupplicantState != null) {
      paramSupplicantState = WifiInfo.getDetailedStateOf(paramSupplicantState);
    } else {
      paramSupplicantState = null;
    }
    return a(paramSupplicantState, paramWifiInfo);
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
    if (paramWifiInfo == null) {
      return "";
    }
    String str = cb.j(paramWifiInfo.getSSID());
    Object localObject = str;
    if (!cb.l(str))
    {
      localObject = bw.as().at();
      WifiConfiguration localWifiConfiguration = null;
      if (paramWifiInfo.getNetworkId() != bx.gI) {
        localWifiConfiguration = bw.a(paramWifiInfo.getNetworkId(), (List)localObject);
      }
      localObject = str;
      if (localWifiConfiguration != null) {
        localObject = cb.j(localWifiConfiguration.SSID);
      }
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     wf7.cl
 * JD-Core Version:    0.7.0.1
 */