package com.tencent.base.os.info;

import java.util.HashMap;

public enum AccessPoint
{
  private static HashMap<String, AccessPoint> ACCESS_POINT_MAP;
  private String name;
  private ServiceProvider provider;
  private boolean wap;
  
  static
  {
    int i = 0;
    NONE = new AccessPoint("NONE", 0, "", ServiceProvider.NONE, false);
    NEVER_HEARD = new AccessPoint("NEVER_HEARD", 1, "I don't know", ServiceProvider.NEVER_HEARD, false);
    CMNET = new AccessPoint("CMNET", 2, "cmnet", ServiceProvider.CHINA_MOBILE, false);
    CMWAP = new AccessPoint("CMWAP", 3, "cmwap", ServiceProvider.CHINA_MOBILE, true);
    UNINET = new AccessPoint("UNINET", 4, "uninet", ServiceProvider.CHINA_UNICOM, false);
    UNIWAP = new AccessPoint("UNIWAP", 5, "uniwap", ServiceProvider.CHINA_UNICOM, true);
    _3GNET = new AccessPoint("_3GNET", 6, "3gnet", ServiceProvider.CHINA_UNICOM, false);
    _3GWAP = new AccessPoint("_3GWAP", 7, "3gwap", ServiceProvider.CHINA_UNICOM, true);
    CTNET = new AccessPoint("CTNET", 8, "ctnet", ServiceProvider.CHINA_TELECOM, false);
    CTWAP = new AccessPoint("CTWAP", 9, "ctwap", ServiceProvider.CHINA_TELECOM, true);
    SHARP777 = new AccessPoint("SHARP777", 10, "#777", ServiceProvider.CHINA_TELECOM, false);
    ENUM$VALUES = new AccessPoint[] { NONE, NEVER_HEARD, CMNET, CMWAP, UNINET, UNIWAP, _3GNET, _3GWAP, CTNET, CTWAP, SHARP777 };
    ACCESS_POINT_MAP = new HashMap();
    AccessPoint[] arrayOfAccessPoint = values();
    int j = arrayOfAccessPoint.length;
    for (;;)
    {
      if (i >= j) {
        return;
      }
      AccessPoint localAccessPoint = arrayOfAccessPoint[i];
      ACCESS_POINT_MAP.put(localAccessPoint.getName(), localAccessPoint);
      i += 1;
    }
  }
  
  private AccessPoint(String paramString, ServiceProvider paramServiceProvider, boolean paramBoolean)
  {
    setName(paramString);
    setProvider(paramServiceProvider);
    setWap(paramBoolean);
  }
  
  public static AccessPoint forName(String paramString)
  {
    if (paramString == null) {
      paramString = NONE;
    }
    AccessPoint localAccessPoint;
    do
    {
      return paramString;
      localAccessPoint = (AccessPoint)ACCESS_POINT_MAP.get(paramString.toLowerCase());
      paramString = localAccessPoint;
    } while (localAccessPoint != null);
    return NEVER_HEARD;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public ServiceProvider getProvider()
  {
    return this.provider;
  }
  
  public boolean isWap()
  {
    return this.wap;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setProvider(ServiceProvider paramServiceProvider)
  {
    this.provider = paramServiceProvider;
  }
  
  public void setWap(boolean paramBoolean)
  {
    this.wap = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.base.os.info.AccessPoint
 * JD-Core Version:    0.7.0.1
 */