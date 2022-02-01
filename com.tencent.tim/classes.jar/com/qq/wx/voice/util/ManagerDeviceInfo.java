package com.qq.wx.voice.util;

import alkz;
import alla;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import java.io.ByteArrayInputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;

public class ManagerDeviceInfo
{
  private Context a = null;
  private int b;
  private int c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private int i;
  private String j;
  private boolean k;
  private String l;
  private int m = 0;
  private String n;
  
  private String a(String paramString)
  {
    for (;;)
    {
      StringBuffer localStringBuffer;
      int i1;
      try
      {
        paramString = this.a.getPackageManager().getPackageInfo(paramString, 64).signatures;
        paramString = a((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(paramString[0].toByteArray())));
        localStringBuffer = new StringBuffer();
        i1 = 0;
        if (i1 >= paramString.length()) {
          return localStringBuffer.toString();
        }
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      catch (CertificateException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      localStringBuffer.append(paramString.charAt(i1));
      i1 += 1;
    }
  }
  
  private static String a(X509Certificate paramX509Certificate)
  {
    try
    {
      paramX509Certificate = Hex.encode(Hex.generateMD5(paramX509Certificate.getEncoded()));
      return paramX509Certificate;
    }
    catch (CertificateEncodingException paramX509Certificate)
    {
      paramX509Certificate.printStackTrace();
    }
    return null;
  }
  
  public String getAndroid_package_name()
  {
    return this.f;
  }
  
  public String getAndroid_signature()
  {
    return this.e;
  }
  
  public String getDeviceInfo()
  {
    return this.j;
  }
  
  public String getGuid()
  {
    return this.g;
  }
  
  public String getIP()
  {
    return this.n;
  }
  
  public boolean getIsWap()
  {
    return this.k;
  }
  
  public String getNetType()
  {
    return this.h;
  }
  
  public int getNetTypeNum()
  {
    if (this.h == "2g") {
      return 1;
    }
    if (this.h == "ct3g") {
      return 2;
    }
    if (this.h == "cu3g") {
      return 3;
    }
    if (this.h == "wifi") {
      return 4;
    }
    return 0;
  }
  
  public int getOs()
  {
    return this.b;
  }
  
  public int getOsver()
  {
    return this.c;
  }
  
  public String getSigInfo()
  {
    return this.d;
  }
  
  public String getWapProxyIP()
  {
    if (this.l != null) {
      return this.l;
    }
    return null;
  }
  
  public int getWapProxyPort()
  {
    return this.m;
  }
  
  public int init(Context paramContext)
  {
    this.a = paramContext;
    this.b = 2;
    setOSver();
    setGuid();
    setDeviceInfo();
    return setSigInfo();
  }
  
  public void setAndroid_package_name(String paramString)
  {
    this.f = paramString;
  }
  
  public void setAndroid_signature(String paramString)
  {
    this.e = paramString;
  }
  
  public void setDeviceInfo()
  {
    this.j = Build.MODEL;
  }
  
  public void setGuid()
  {
    if (this.a != null) {
      this.g = "Guid";
    }
  }
  
  public void setGuidNeedService()
  {
    if (this.a != null)
    {
      this.g = alla.a((TelephonyManager)this.a.getSystemService("phone"));
      this.g += "-";
      WifiInfo localWifiInfo = alkz.a((WifiManager)this.a.getSystemService("wifi"));
      this.g += alkz.c(localWifiInfo);
    }
  }
  
  public void setIpAddr()
  {
    try
    {
      localEnumeration1 = alkz.getNetworkInterfaces();
      boolean bool = localEnumeration1.hasMoreElements();
      if (bool) {
        break label21;
      }
    }
    catch (SocketException localSocketException)
    {
      for (;;)
      {
        Enumeration localEnumeration1;
        label21:
        Enumeration localEnumeration2;
        localSocketException.printStackTrace();
      }
    }
    this.n = null;
    return;
    localEnumeration2 = ((NetworkInterface)localEnumeration1.nextElement()).getInetAddresses();
    while (localEnumeration2.hasMoreElements())
    {
      InetAddress localInetAddress = (InetAddress)localEnumeration2.nextElement();
      if (!localInetAddress.isLoopbackAddress()) {
        this.n = localInetAddress.getHostAddress();
      }
    }
  }
  
  public int setNetType()
  {
    if (this.a == null) {
      return -101;
    }
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.a.getSystemService("connectivity")).getActiveNetworkInfo();
    if (localNetworkInfo == null) {
      return -201;
    }
    int i1 = localNetworkInfo.getType();
    if (i1 == 0)
    {
      this.h = localNetworkInfo.getExtraInfo();
      this.i = localNetworkInfo.getSubtype();
      switch (this.i)
      {
      case 5: 
      case 7: 
      case 14: 
      default: 
        this.h = "other";
      }
    }
    for (;;)
    {
      this.h = "wifi";
      return 0;
      this.h = "2g";
      continue;
      this.h = "2g";
      continue;
      this.h = "2g";
      continue;
      this.h = "ct3g";
      continue;
      this.h = "ct3g";
      continue;
      this.h = "cu3g";
      continue;
      this.h = "cu3g";
      continue;
      this.h = "other";
      continue;
      this.h = "other";
      continue;
      this.h = "other";
      continue;
      this.h = "other";
      continue;
      this.h = "other";
      continue;
      if (i1 == 1) {
        this.h = "wifi";
      }
    }
  }
  
  public void setNetType(String paramString)
  {
    this.h = paramString;
  }
  
  public void setOSver()
  {
    this.c = Build.VERSION.SDK_INT;
  }
  
  public int setSigInfo()
  {
    String str1 = this.a.getPackageName();
    setAndroid_package_name(str1);
    String str2 = a(str1);
    setAndroid_signature(str2);
    if ((str1 == null) || (str2 == null)) {
      return -1;
    }
    this.d = (str1 + ";" + str2);
    return 0;
  }
  
  public void setWap()
  {
    this.k = false;
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.a.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.getType() == 0))
    {
      this.k = true;
      if (Proxy.getDefaultPort() != -1) {
        break label64;
      }
    }
    label64:
    for (int i1 = 80;; i1 = Proxy.getDefaultPort())
    {
      this.m = i1;
      this.l = Proxy.getDefaultHost();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.qq.wx.voice.util.ManagerDeviceInfo
 * JD-Core Version:    0.7.0.1
 */