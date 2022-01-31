package com.tencent.base.os.info;

import java.util.HashMap;
import java.util.Map;

public enum ServiceProvider
{
  private static final Map<String, ServiceProvider> IMSI_PROVIDER_MAP;
  private String name;
  
  static
  {
    NEVER_HEARD = new ServiceProvider("NEVER_HEARD", 1, "Unknown");
    CHINA_MOBILE = new ServiceProvider("CHINA_MOBILE", 2, "China Mobile");
    CHINA_UNICOM = new ServiceProvider("CHINA_UNICOM", 3, "China Unicom");
    CHINA_TELECOM = new ServiceProvider("CHINA_TELECOM", 4, "China Telecom");
    ENUM$VALUES = new ServiceProvider[] { NONE, NEVER_HEARD, CHINA_MOBILE, CHINA_UNICOM, CHINA_TELECOM };
    IMSI_PROVIDER_MAP = new HashMap();
    IMSI_PROVIDER_MAP.put("46000", CHINA_MOBILE);
    IMSI_PROVIDER_MAP.put("46002", CHINA_MOBILE);
    IMSI_PROVIDER_MAP.put("46007", CHINA_MOBILE);
    IMSI_PROVIDER_MAP.put("46003", CHINA_TELECOM);
    IMSI_PROVIDER_MAP.put("46005", CHINA_TELECOM);
    IMSI_PROVIDER_MAP.put("46001", CHINA_UNICOM);
    IMSI_PROVIDER_MAP.put("46006", CHINA_UNICOM);
    IMSI_PROVIDER_MAP.put("46020", CHINA_MOBILE);
  }
  
  private ServiceProvider(String paramString)
  {
    setName(paramString);
  }
  
  public static ServiceProvider fromIMSI(String paramString)
  {
    if (paramString == null) {
      paramString = NONE;
    }
    ServiceProvider localServiceProvider;
    do
    {
      return paramString;
      if (paramString.length() < 5) {
        return NONE;
      }
      localServiceProvider = (ServiceProvider)IMSI_PROVIDER_MAP.get(paramString.substring(0, 5));
      paramString = localServiceProvider;
    } while (localServiceProvider != null);
    return NEVER_HEARD;
  }
  
  private void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String toString()
  {
    return getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.base.os.info.ServiceProvider
 * JD-Core Version:    0.7.0.1
 */