package com.tencent.token;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import java.util.HashMap;
import java.util.List;

public final class akb
{
  static TelephonyManager a;
  static boolean b = false;
  static String c;
  static HashMap<Integer, String> d = new HashMap();
  static boolean e = false;
  static String f = null;
  static HashMap<Integer, String> g = new HashMap();
  static boolean h = false;
  static String i = null;
  static HashMap<Integer, String> j = new HashMap();
  
  @SuppressLint({"MissingPermission"})
  public static CellLocation a()
  {
    if (!ll.b()) {
      return null;
    }
    akg.a("[API]TelephonyManagerInvoke_");
    return a.getCellLocation();
  }
  
  @SuppressLint({"MissingPermission"})
  public static String a(int paramInt)
  {
    boolean bool = ll.a();
    StringBuilder localStringBuilder = new StringBuilder("getDeviceId, slot:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]isAllow:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    if (!bool) {
      return "";
    }
    return d(paramInt);
  }
  
  public static void a(PhoneStateListener paramPhoneStateListener, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("listen, events:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    if (!ll.a()) {
      return;
    }
    localStringBuilder = new StringBuilder("listen, events:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    akg.a("[API]TelephonyManagerInvoke_");
    a.listen(paramPhoneStateListener, paramInt);
  }
  
  @SuppressLint({"MissingPermission"})
  public static String b(int paramInt)
  {
    boolean bool = ll.a();
    StringBuilder localStringBuilder = new StringBuilder("getImei, slot:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]isAllow:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    if (!bool) {
      return "";
    }
    return e(paramInt);
  }
  
  @SuppressLint({"MissingPermission"})
  public static List<CellInfo> b()
  {
    if (!ll.b()) {
      return null;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      akg.a("[API]TelephonyManagerInvoke_");
      return a.getAllCellInfo();
    }
    return null;
  }
  
  @SuppressLint({"MissingPermission"})
  public static String c()
  {
    boolean bool = ll.a();
    StringBuilder localStringBuilder = new StringBuilder("getDeviceId, isAllow:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    if (!bool) {
      return "";
    }
    return j();
  }
  
  @SuppressLint({"MissingPermission"})
  public static String c(int paramInt)
  {
    boolean bool = ll.a();
    StringBuilder localStringBuilder = new StringBuilder("getMeid, slot:[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]isAllow:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    if (!bool) {
      return "";
    }
    return f(paramInt);
  }
  
  @SuppressLint({"MissingPermission"})
  public static String d()
  {
    boolean bool = ll.a();
    StringBuilder localStringBuilder = new StringBuilder("getImei, isAllow:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    if (!bool) {
      return "";
    }
    return k();
  }
  
  @SuppressLint({"MissingPermission"})
  public static String d(int paramInt)
  {
    try
    {
      Object localObject1 = new StringBuilder("getDeviceId, slot:[");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("]VERSION.SDK_INT:[");
      ((StringBuilder)localObject1).append(Build.VERSION.SDK_INT);
      ((StringBuilder)localObject1).append("]");
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject1 = (String)d.get(Integer.valueOf(paramInt));
        if (localObject1 != null)
        {
          paramInt = ((String)localObject1).compareToIgnoreCase("nulnul");
          if (paramInt == 0) {
            return null;
          }
          return localObject1;
        }
        localObject1 = a.getDeviceId(paramInt);
        StringBuilder localStringBuilder = new StringBuilder("getDeviceId, slot:[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("][");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("]");
        akg.a("[API]TelephonyManagerInvoke_");
        if (localObject1 == null) {
          d.put(Integer.valueOf(paramInt), "nulnul");
        } else {
          d.put(Integer.valueOf(paramInt), localObject1);
        }
      }
      return "";
    }
    finally {}
  }
  
  @SuppressLint({"MissingPermission"})
  public static String e()
  {
    boolean bool = ll.a();
    Object localObject = new StringBuilder("getSubscriberId, isAllow:[");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append("]");
    if (!bool) {
      return "";
    }
    localObject = a.getSubscriberId();
    StringBuilder localStringBuilder = new StringBuilder("getSubscriberId:[");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("]");
    akg.a("[API]TelephonyManagerInvoke_");
    return localObject;
  }
  
  @SuppressLint({"MissingPermission"})
  public static String e(int paramInt)
  {
    try
    {
      Object localObject1 = new StringBuilder("getImei, slot:[");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("]VERSION.SDK_INT:[");
      ((StringBuilder)localObject1).append(Build.VERSION.SDK_INT);
      ((StringBuilder)localObject1).append("]");
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject1 = (String)g.get(Integer.valueOf(paramInt));
        if (localObject1 != null)
        {
          paramInt = ((String)localObject1).compareToIgnoreCase("nulnul");
          if (paramInt == 0) {
            return null;
          }
          return localObject1;
        }
        localObject1 = a.getImei(paramInt);
        StringBuilder localStringBuilder = new StringBuilder("getImei, slot:[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("][");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("]");
        akg.a("[API]TelephonyManagerInvoke_");
        if (localObject1 == null) {
          g.put(Integer.valueOf(paramInt), "nulnul");
        } else {
          g.put(Integer.valueOf(paramInt), localObject1);
        }
      }
      return "";
    }
    finally {}
  }
  
  @SuppressLint({"MissingPermission"})
  public static String f()
  {
    boolean bool = ll.a();
    StringBuilder localStringBuilder = new StringBuilder("getMeid, isAllow:[");
    localStringBuilder.append(bool);
    localStringBuilder.append("]");
    if (!bool) {
      return "";
    }
    return l();
  }
  
  @SuppressLint({"MissingPermission"})
  public static String f(int paramInt)
  {
    try
    {
      Object localObject1 = new StringBuilder("getMeid, slot:[");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("]VERSION.SDK_INT:[");
      ((StringBuilder)localObject1).append(Build.VERSION.SDK_INT);
      ((StringBuilder)localObject1).append("]");
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject1 = (String)j.get(Integer.valueOf(paramInt));
        if (localObject1 != null)
        {
          paramInt = ((String)localObject1).compareToIgnoreCase("nulnul");
          if (paramInt == 0) {
            return null;
          }
          return localObject1;
        }
        localObject1 = a.getMeid(paramInt);
        StringBuilder localStringBuilder = new StringBuilder("getMeid, slot:[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("][");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("]");
        akg.a("[API]TelephonyManagerInvoke_");
        if (localObject1 == null) {
          j.put(Integer.valueOf(paramInt), "nulnul");
        } else {
          j.put(Integer.valueOf(paramInt), localObject1);
        }
      }
      return "";
    }
    finally {}
  }
  
  @SuppressLint({"MissingPermission"})
  public static String g()
  {
    if (!ll.a()) {
      return "";
    }
    akg.a("[API]TelephonyManagerInvoke_");
    return a.getSimSerialNumber();
  }
  
  @SuppressLint({"MissingPermission"})
  public static String h()
  {
    if (!ll.a()) {
      return "";
    }
    akg.a("[API]TelephonyManagerInvoke_");
    return a.getLine1Number();
  }
  
  @SuppressLint({"MissingPermission"})
  public static ServiceState i()
  {
    if (!ll.b()) {
      return null;
    }
    akg.a("[API]TelephonyManagerInvoke_");
    if (Build.VERSION.SDK_INT >= 26) {
      return a.getServiceState();
    }
    return null;
  }
  
  @SuppressLint({"MissingPermission"})
  public static String j()
  {
    try
    {
      Object localObject1 = new StringBuilder("getDeviceId:[");
      ((StringBuilder)localObject1).append(c);
      ((StringBuilder)localObject1).append("]");
      if (b)
      {
        localObject1 = c;
        return localObject1;
      }
      c = a.getDeviceId();
      b = true;
      localObject1 = new StringBuilder("getDeviceId:[");
      ((StringBuilder)localObject1).append(c);
      ((StringBuilder)localObject1).append("]");
      akg.a("[API]TelephonyManagerInvoke_");
      localObject1 = c;
      return localObject1;
    }
    finally {}
  }
  
  @SuppressLint({"MissingPermission"})
  public static String k()
  {
    try
    {
      Object localObject1 = new StringBuilder("getImei:[");
      ((StringBuilder)localObject1).append(f);
      ((StringBuilder)localObject1).append("]");
      if (e)
      {
        localObject1 = f;
        return localObject1;
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        f = a.getImei();
        e = true;
        localObject1 = new StringBuilder("getImei:[");
        ((StringBuilder)localObject1).append(f);
        ((StringBuilder)localObject1).append("]");
        akg.a("[API]TelephonyManagerInvoke_");
        localObject1 = f;
        return localObject1;
      }
      return "";
    }
    finally {}
  }
  
  @SuppressLint({"MissingPermission"})
  public static String l()
  {
    try
    {
      Object localObject1 = new StringBuilder("getMeid:[");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append("]");
      if (h)
      {
        localObject1 = i;
        return localObject1;
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        i = a.getMeid();
        h = true;
        localObject1 = new StringBuilder("getMeid:[");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append("]");
        akg.a("[API]TelephonyManagerInvoke_");
        localObject1 = i;
        return localObject1;
      }
      return "";
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.akb
 * JD-Core Version:    0.7.0.1
 */