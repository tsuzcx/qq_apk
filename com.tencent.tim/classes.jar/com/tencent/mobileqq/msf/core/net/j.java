package com.tencent.mobileqq.msf.core.net;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.d;
import com.tencent.mobileqq.msf.sdk.g;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class j
{
  public static final String a = "MsfNetUtil";
  private static final int b = 16;
  private static final int c = 17;
  private static final int d = 18;
  private static final int e = 19;
  private static final int f = 20;
  private static final int g = 10;
  private static final int h = 11;
  private static final int i = 12;
  private static final int j = 14;
  private static final int k = 15;
  
  public static int a(NetworkInfo paramNetworkInfo)
  {
    int n;
    int m;
    if ((paramNetworkInfo != null) && (paramNetworkInfo.isAvailable()))
    {
      n = paramNetworkInfo.getType();
      switch (n)
      {
      case 1: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 13: 
      default: 
        m = -1;
        QLog.d("MsfNetUtil", 1, "Unexcepted Mobile Type:" + n);
      }
    }
    for (;;)
    {
      QLog.d("MsfNetUtil", 1, "Mobile Type:" + m);
      return m;
      paramNetworkInfo = (TelephonyManager)BaseApplication.getContext().getSystemService("phone");
      n = g.b(paramNetworkInfo);
      switch (n)
      {
      default: 
        m = g.a(paramNetworkInfo, n);
        QLog.d("MsfNetUtil", 1, "Unexcepted networkType:" + n + " ,mobileInfo:" + m);
        break;
      case 20: 
        m = 4;
        break;
      case 13: 
      case 18: 
      case 19: 
        m = 3;
        break;
      case 3: 
      case 5: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      case 12: 
      case 14: 
      case 15: 
      case 17: 
        m = 2;
        break;
      case 0: 
      case 1: 
      case 2: 
      case 4: 
      case 7: 
      case 11: 
      case 16: 
        m = 1;
        continue;
        m = 0;
      }
    }
  }
  
  public static boolean a(d paramd)
  {
    boolean bool2 = true;
    if ((paramd == null) || (TextUtils.isEmpty(paramd.i))) {}
    label77:
    label80:
    for (;;)
    {
      return false;
      int m;
      if ("00000".equals(paramd.i))
      {
        m = 2;
        if (NetConnInfoCenter.isWifiConn())
        {
          bool1 = bool2;
          if (m == 1) {}
        }
        else
        {
          if ((!NetConnInfoCenter.isMobileConn()) || (m != 2)) {
            break label77;
          }
        }
      }
      for (boolean bool1 = bool2;; bool1 = false)
      {
        if ("00000".equals(paramd.i)) {
          break label80;
        }
        return bool1;
        m = 1;
        break;
      }
    }
  }
  
  public static NetworkInfo[] a()
  {
    try
    {
      NetworkInfo[] arrayOfNetworkInfo = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getAllNetworkInfo();
      return arrayOfNetworkInfo;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static byte b()
  {
    int n = 254;
    if (NetConnInfoCenter.isWifiConn()) {
      return 1;
    }
    if (NetConnInfoCenter.isMobileConn())
    {
      int i1 = NetConnInfoCenter.getMobileNetworkType();
      int m = i1;
      if (i1 != 20) {
        m = i1 + 100;
      }
      if (m > 254)
      {
        m = n;
        if (QLog.isColorLevel())
        {
          QLog.d("MsfNetUtil", 2, "error,netWorkType is " + 254);
          m = n;
        }
      }
      for (;;)
      {
        return (byte)m;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.j
 * JD-Core Version:    0.7.0.1
 */