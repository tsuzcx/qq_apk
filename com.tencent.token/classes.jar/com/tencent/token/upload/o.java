package com.tencent.token.upload;

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

public class o
{
  public static ConnectivityManager a(Context paramContext)
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
  
  public static String a(int paramInt)
  {
    try
    {
      String str1 = a("gsm.sim.state", g.a);
      if (str1.indexOf(',') != -1)
      {
        if (paramInt == 0) {
          return str1.substring(0, str1.indexOf(','));
        }
        if (paramInt == 1) {
          return str1.substring(str1.indexOf(',') + 1, str1.length());
        }
        return g.a;
      }
      if (paramInt != 0)
      {
        str1 = g.a;
        return str1;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      String str2 = g.a;
      return str2;
    }
  }
  
  public static String a(String paramString1, String paramString2)
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
    boolean bool2 = false;
    try
    {
      Object localObject = a(RqdApplication.l());
      boolean bool1 = bool2;
      int i;
      if (localObject != null)
      {
        localObject = ((ConnectivityManager)localObject).getAllNetworkInfo();
        bool1 = bool2;
        if (localObject != null) {
          i = 0;
        }
      }
      for (;;)
      {
        bool1 = bool2;
        if (i < localObject.length)
        {
          NetworkInfo.State localState1 = localObject[i].getState();
          NetworkInfo.State localState2 = NetworkInfo.State.CONNECTED;
          if (localState1 == localState2) {
            bool1 = true;
          }
        }
        else
        {
          return bool1;
        }
        i += 1;
      }
      return false;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static String b(Context paramContext)
  {
    Object localObject2 = g.a;
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
        localObject1 = localObject2;
        if (localEnumeration1.hasMoreElements())
        {
          localObject1 = localObject2;
          Enumeration localEnumeration2 = ((NetworkInterface)localEnumeration1.nextElement()).getInetAddresses();
          paramContext = (Context)localObject2;
          localObject2 = paramContext;
          localObject1 = paramContext;
          if (localEnumeration2.hasMoreElements())
          {
            localObject1 = paramContext;
            localObject2 = (InetAddress)localEnumeration2.nextElement();
            localObject1 = paramContext;
            if (!((InetAddress)localObject2).isLoopbackAddress())
            {
              localObject1 = paramContext;
              paramContext = ((InetAddress)localObject2).getHostAddress();
            }
          }
        }
        else
        {
          return localObject2;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return localObject1;
      }
    }
  }
  
  public static List b()
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
  
  public static JSONArray c()
  {
    Object localObject = b();
    JSONArray localJSONArray = new JSONArray();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return localJSONArray;
    }
    localObject = ((List)localObject).iterator();
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        NetworkInterface localNetworkInterface = (NetworkInterface)((Iterator)localObject).next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("name", localNetworkInterface.getName());
          localJSONArray.put(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
          }
        }
      }
    }
    return localJSONArray;
  }
  
  public static boolean c(Context paramContext)
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
  
  public static String d(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null) {
        return paramContext.getSimOperator();
      }
      paramContext = g.a;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return g.a;
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
  
  public static int e(Context paramContext)
  {
    for (;;)
    {
      try
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        if ((paramContext == null) || (paramContext.getActiveNetworkInfo() == null)) {
          continue;
        }
        i = paramContext.getActiveNetworkInfo().getType();
        if (i != 1) {
          continue;
        }
        i = 1;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        int i = 0;
        continue;
      }
      if (i == 0) {
        break label57;
      }
      return 1;
      i = 0;
    }
    label57:
    return 0;
  }
  
  public static int f(Context paramContext)
  {
    if (e(paramContext) == 1) {}
    label231:
    for (;;)
    {
      int j;
      try
      {
        Object localObject1 = (WifiManager)paramContext.getSystemService("wifi");
        WifiInfo localWifiInfo = ((WifiManager)localObject1).getConnectionInfo();
        paramContext = localWifiInfo.getSSID();
        if ((paramContext == null) || (!paramContext.startsWith("\"")) || (!paramContext.endsWith("\""))) {
          break label231;
        }
        paramContext = paramContext.substring(1, paramContext.length() - 1);
        localObject1 = ((WifiManager)localObject1).getScanResults();
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject1 = ((List)localObject1).iterator();
          int i = 0;
          j = i;
          if (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (ScanResult)((Iterator)localObject1).next();
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
              continue;
            }
          }
          else if (j != 0) {}
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        j = 0;
      }
      for (;;)
      {
        return 0;
        return 1;
        break;
        j = 0;
      }
    }
  }
  
  public static JSONArray g(Context paramContext)
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
  
  public static String h(Context paramContext)
  {
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext != null) {
        return paramContext.getSSID();
      }
      paramContext = g.a;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return g.a;
  }
  
  public static String i(Context paramContext)
  {
    try
    {
      paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
      if (paramContext != null) {
        return paramContext.getBSSID();
      }
      paramContext = g.a;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return g.a;
  }
  
  public static int j(Context paramContext)
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
  
  public static String k(Context paramContext)
  {
    String str = g.a;
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
  
  public static String l(Context paramContext)
  {
    String str = g.a;
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
  
  public static String m(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null) {
        return paramContext.getNetworkOperatorName();
      }
      paramContext = g.a;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return g.a;
  }
  
  public static String n(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null) {
        return paramContext.getNetworkType() + "";
      }
      paramContext = g.a;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return g.a;
  }
  
  public static String o(Context paramContext)
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
        case 13: 
          paramContext = "4G";
        }
        break;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      paramContext = "unknow";
    }
    paramContext = "unknow";
    for (;;)
    {
      return paramContext;
      paramContext = "WIFI";
      continue;
      paramContext = "unknow";
      continue;
      paramContext = "2G";
      continue;
      paramContext = "3G";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.upload.o
 * JD-Core Version:    0.7.0.1
 */