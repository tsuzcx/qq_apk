package com.tencent.qqprotect.singleupdate;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EDEntity
{
  private static final String a = "EmulatorDetect";
  
  private boolean a(String paramString, String[] paramArrayOfString)
  {
    Object localObject = new File(paramString);
    if ((!((File)localObject).exists()) || (!((File)localObject).canRead())) {
      return false;
    }
    int i = (int)((File)localObject).length();
    if (i != 0) {
      paramString = new byte[i];
    }
    for (;;)
    {
      try
      {
        localObject = new FileInputStream((File)localObject);
        i = ((InputStream)localObject).read(paramString);
        ((InputStream)localObject).close();
        paramString = new String(paramString, 0, i);
        int j = paramArrayOfString.length;
        i = 0;
        if (i >= j) {
          break;
        }
        if (paramString.indexOf(paramArrayOfString[i]) == -1) {
          break label118;
        }
        return true;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return false;
      }
      paramString = new byte[1024];
      continue;
      label118:
      i += 1;
    }
  }
  
  private boolean a(String[] paramArrayOfString)
  {
    List localList = BaseApplication.getContext().getPackageManager().getInstalledPackages(0);
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false;; bool1 = bool2)
    {
      bool2 = bool1;
      PackageInfo localPackageInfo;
      int j;
      if (i < localList.size())
      {
        localPackageInfo = (PackageInfo)localList.get(i);
        j = 0;
      }
      for (;;)
      {
        bool2 = bool1;
        if (j < paramArrayOfString.length)
        {
          if (localPackageInfo.packageName.equals(paramArrayOfString[j]))
          {
            int k = localPackageInfo.applicationInfo.flags;
            ApplicationInfo localApplicationInfo = localPackageInfo.applicationInfo;
            if ((k & 0x1) > 0) {
              bool2 = true;
            }
          }
        }
        else
        {
          if (!bool2) {
            break;
          }
          return bool2;
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  private boolean b(String[] paramArrayOfString)
  {
    int i = 0;
    String str = Build.BRAND;
    boolean bool = false;
    while (i < paramArrayOfString.length)
    {
      if (paramArrayOfString[i].equals(str)) {
        bool = true;
      }
      i += 1;
    }
    return bool;
  }
  
  public boolean a()
  {
    boolean bool = false;
    HashMap localHashMap = new HashMap();
    localHashMap.put("processx", "com.bluestacks.accelerometerui;com.bluestacks.BstCommandProcessor;com.bluestacks.bstfolder");
    if (((Build.BRAND.equals("generic")) && (Build.DEVICE.equals("generic"))) || (b(localHashMap))) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(Map paramMap)
  {
    String str = (String)paramMap.get("filepath");
    if (str == null) {}
    do
    {
      return false;
      paramMap = (String)paramMap.get("apnx");
    } while (paramMap == null);
    if (!a(str, paramMap.split(";"))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean b(Map paramMap)
  {
    paramMap = (String)paramMap.get("processx");
    if (paramMap == null) {
      return false;
    }
    if (a(paramMap.split(";"))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean c(Map paramMap)
  {
    paramMap = (String)paramMap.get("filex");
    if (paramMap == null) {
      return false;
    }
    paramMap = paramMap.split(";");
    int j = paramMap.length;
    int i = 0;
    if (i < j) {
      if (!new File(paramMap[i]).exists()) {}
    }
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i += 1;
      break;
    }
  }
  
  public boolean d(Map paramMap)
  {
    String str1 = (String)paramMap.get("filepath");
    if (str1 == null) {}
    String str2;
    do
    {
      do
      {
        return false;
        str2 = (String)paramMap.get("serialportname");
      } while (str2 == null);
      paramMap = (String)paramMap.get("driverx");
    } while (paramMap == null);
    paramMap = paramMap.split(";");
    if (new File(str2).exists()) {}
    for (boolean bool = a(str1, paramMap);; bool = false) {
      return bool;
    }
  }
  
  public boolean e(Map paramMap)
  {
    String str1 = (String)paramMap.get("emulatorcountry");
    if (str1 == null)
    {
      bool2 = false;
      return bool2;
    }
    Object localObject = (String)paramMap.get("phonenumberx");
    if (localObject == null) {
      return false;
    }
    localObject = ((String)localObject).split(";");
    String str2 = (String)paramMap.get("IMSI");
    paramMap = (String)paramMap.get("NetOper");
    TelephonyManager localTelephonyManager = (TelephonyManager)BaseApplication.getContext().getSystemService("phone");
    if (localTelephonyManager == null) {
      return false;
    }
    int i;
    if (str1.equals(localTelephonyManager.getSimCountryIso()))
    {
      str1 = localTelephonyManager.getLine1Number();
      int j = localObject.length;
      i = 0;
      label124:
      if (i < j) {
        if (!localObject[i].equals(str1)) {}
      }
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      boolean bool1 = bool2;
      if (str2 != null)
      {
        bool1 = bool2;
        if (str2.equals(localTelephonyManager.getSubscriberId())) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (paramMap == null) {
        break;
      }
      bool2 = bool1;
      if (!paramMap.equalsIgnoreCase(localTelephonyManager.getNetworkOperatorName())) {
        break;
      }
      return true;
      i += 1;
      break label124;
    }
  }
  
  public boolean f(Map paramMap)
  {
    if ((String)paramMap.get("filepath") == null) {
      return false;
    }
    paramMap = (String)paramMap.get("cpux");
    if (paramMap == null) {
      return false;
    }
    return a(paramMap, paramMap.split(";"));
  }
  
  public boolean g(Map paramMap)
  {
    Object localObject = (String)paramMap.get("brandx");
    String str1 = (String)paramMap.get("model");
    String str2 = (String)paramMap.get("product");
    paramMap = (String)paramMap.get("hardward");
    localObject = ((String)localObject).split(";");
    return ((Build.BRAND.equals("generic")) && (Build.DEVICE.equals("generic"))) || (b((String[])localObject)) || ((str1 != null) && (Build.MODEL.equals(str1))) || ((str2 != null) && (Build.PRODUCT.equals(str2))) || ((paramMap != null) && (Build.HARDWARE.equals(paramMap)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.EDEntity
 * JD-Core Version:    0.7.0.1
 */