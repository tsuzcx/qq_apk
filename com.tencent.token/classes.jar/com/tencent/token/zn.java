package com.tencent.token;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import com.tencent.token.global.RqdApplication;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zn
{
  public static String a(int paramInt)
  {
    do
    {
      try
      {
        str = a("gsm.sim.state", zk.a);
        if (str.indexOf(',') == -1) {
          continue;
        }
        if (paramInt == 0) {
          return str.substring(0, str.indexOf(','));
        }
        if (paramInt == 1) {
          return str.substring(str.indexOf(',') + 1, str.length());
        }
        return zk.a;
      }
      catch (Exception localException)
      {
        String str;
        localException.printStackTrace();
        return zk.a;
      }
      str = zk.a;
      return str;
    } while (paramInt != 0);
    return localException;
  }
  
  private static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = (String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class, String.class }).invoke(null, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return paramString2;
  }
  
  public static boolean a()
  {
    try
    {
      Object localObject = n(RqdApplication.n());
      if (localObject != null)
      {
        localObject = ((ConnectivityManager)localObject).getAllNetworkInfo();
        if (localObject != null)
        {
          int i = 0;
          while (i < localObject.length)
          {
            NetworkInfo.State localState1 = localObject[i].getState();
            NetworkInfo.State localState2 = NetworkInfo.State.CONNECTED;
            if (localState1 == localState2) {
              return true;
            }
            i += 1;
          }
        }
      }
      return false;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      int i = Settings.System.getInt(paramContext.getContentResolver(), "airplane_mode_on", 0);
      return i == 1;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null) {
        return paramContext.getSimOperator();
      }
      paramContext = zk.a;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return zk.a;
  }
  
  public static JSONArray b()
  {
    Object localObject = e();
    JSONArray localJSONArray = new JSONArray();
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return localJSONArray;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        NetworkInterface localNetworkInterface = (NetworkInterface)((Iterator)localObject).next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("name", localNetworkInterface.getName());
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        localJSONArray.put(localJSONObject);
      }
      return localJSONArray;
    }
    return localJSONArray;
  }
  
  public static int c(Context paramContext)
  {
    int i;
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if ((paramContext != null) && (paramContext.getActiveNetworkInfo() != null))
      {
        i = paramContext.getActiveNetworkInfo().getType();
        if (i == 1)
        {
          i = 1;
          break label51;
        }
      }
      i = 0;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      i = 0;
    }
    label51:
    if (i != 0) {
      return 1;
    }
    return 0;
  }
  
  public static String c()
  {
    Object localObject2 = zk.a;
    Object localObject1 = localObject2;
    try
    {
      Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
      localObject1 = localObject2;
      Object localObject3 = localObject2;
      if (localEnumeration1.hasMoreElements())
      {
        localObject1 = localObject2;
        Enumeration localEnumeration2 = ((NetworkInterface)localEnumeration1.nextElement()).getInetAddresses();
        localObject3 = localObject2;
        for (;;)
        {
          localObject2 = localObject3;
          localObject1 = localObject3;
          if (!localEnumeration2.hasMoreElements()) {
            break;
          }
          localObject1 = localObject3;
          localObject2 = (InetAddress)localEnumeration2.nextElement();
          localObject1 = localObject3;
          if (!((InetAddress)localObject2).isLoopbackAddress())
          {
            localObject1 = localObject3;
            localObject3 = ((InetAddress)localObject2).getHostAddress();
          }
        }
      }
      return localObject3;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject3 = localObject1;
    }
  }
  
  public static int d(Context paramContext)
  {
    int j;
    if (c(paramContext) == 1) {
      try
      {
        Object localObject2 = (WifiManager)paramContext.getSystemService("wifi");
        WifiInfo localWifiInfo = ((WifiManager)localObject2).getConnectionInfo();
        Object localObject1 = localWifiInfo.getSSID();
        paramContext = (Context)localObject1;
        if (localObject1 != null)
        {
          paramContext = (Context)localObject1;
          if (((String)localObject1).startsWith("\""))
          {
            paramContext = (Context)localObject1;
            if (((String)localObject1).endsWith("\"")) {
              paramContext = ((String)localObject1).substring(1, ((String)localObject1).length() - 1);
            }
          }
        }
        localObject1 = ((WifiManager)localObject2).getScanResults();
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = ((List)localObject1).iterator();
          int i = 0;
          for (;;)
          {
            j = i;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (ScanResult)((Iterator)localObject1).next();
            if ((((ScanResult)localObject2).SSID.equals(paramContext)) && (((ScanResult)localObject2).BSSID.equals(localWifiInfo.getBSSID())) && (((ScanResult)localObject2).capabilities != null))
            {
              localObject2 = ((ScanResult)localObject2).capabilities.trim();
              if (localObject2 != null) {
                if (!((String)localObject2).equals(""))
                {
                  boolean bool = ((String)localObject2).equals("[ESS]");
                  if (!bool) {}
                }
                else
                {
                  i = 0;
                  continue;
                }
              }
              i = 1;
            }
          }
        }
        j = 0;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        j = 0;
      }
    } else {
      j = 0;
    }
    if (j == 0) {
      return 0;
    }
    return 1;
  }
  
  public static JSONArray d()
  {
    localJSONArray = new JSONArray();
    try
    {
      Enumeration localEnumeration = NetworkInterface.getNetworkInterfaces();
      while (localEnumeration.hasMoreElements())
      {
        NetworkInterface localNetworkInterface = (NetworkInterface)localEnumeration.nextElement();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("name", localNetworkInterface.getDisplayName());
        localJSONArray.put(localJSONObject);
      }
      return localJSONArray;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static List e()
  {
    ArrayList localArrayList1 = new ArrayList();
    try
    {
      ArrayList localArrayList2 = Collections.list(NetworkInterface.getNetworkInterfaces());
      return localArrayList2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localArrayList1;
  }
  
  public static JSONArray e(Context paramContext)
  {
    localJSONArray = new JSONArray();
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getScanResults();
      if ((paramContext != null) && (paramContext.size() > 0))
      {
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          ScanResult localScanResult = (ScanResult)paramContext.next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("SSID", localScanResult.SSID);
          localJSONObject.put("BSSID", localScanResult.BSSID);
          localJSONObject.put("capabilities", localScanResult.capabilities);
          localJSONObject.put("level", localScanResult.level);
          localJSONArray.put(localJSONObject);
        }
      }
      return localJSONArray;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static String f(Context paramContext)
  {
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext != null) {
        return paramContext.getSSID();
      }
      paramContext = zk.a;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return zk.a;
  }
  
  public static String g(Context paramContext)
  {
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext != null) {
        return paramContext.getBSSID();
      }
      paramContext = zk.a;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return zk.a;
  }
  
  public static int h(Context paramContext)
  {
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext != null)
      {
        int i = WifiManager.calculateSignalLevel(paramContext.getRssi(), 5);
        return i;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static String i(Context paramContext)
  {
    String str = zk.a;
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperator();
      if ((paramContext != null) && (paramContext.length() > 3))
      {
        paramContext = paramContext.substring(0, 3);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return str;
  }
  
  public static String j(Context paramContext)
  {
    String str = zk.a;
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getNetworkOperator();
      if ((paramContext != null) && (paramContext.length() > 4))
      {
        paramContext = paramContext.substring(3, 5);
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return str;
  }
  
  public static String k(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null) {
        return paramContext.getNetworkOperatorName();
      }
      paramContext = zk.a;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return zk.a;
  }
  
  public static String l(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramContext.getNetworkType());
        return localStringBuilder.toString();
      }
      paramContext = zk.a;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return zk.a;
  }
  
  public static String m(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null) {
        return "unknow";
      }
      switch (paramContext.getType())
      {
      case 0: 
        switch (paramContext.getSubtype())
        {
        case 1: 
        case 2: 
        case 4: 
        case 7: 
        case 11: 
          return "2G";
        }
        break;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      return "unknow";
    }
    return "unknow";
    return "WIFI";
    return "unknow";
    return "4G";
    return "3G";
  }
  
  private static ConnectivityManager n(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.zn
 * JD-Core Version:    0.7.0.1
 */