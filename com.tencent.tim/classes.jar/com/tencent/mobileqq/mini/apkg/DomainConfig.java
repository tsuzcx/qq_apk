package com.tencent.mobileqq.mini.apkg;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

public class DomainConfig
{
  public static final String DEFAULT_PREFIX = "https://";
  public static final String HTTP_PREFIX = "http://";
  public static final String WSS_PREFIX = "wss://";
  public static final String WS_PREFIX = "ws://";
  private static ConcurrentHashMap<String, DomainConfig> domainConfigMap = new ConcurrentHashMap();
  private static final int needCheckPost = QzoneConfig.getInstance().getConfig("qqtriton", "MiniGameDomainNeedCheckPort", 0);
  public String host;
  public int port;
  
  public DomainConfig(String paramString, int paramInt)
  {
    this.host = paramString;
    this.port = paramInt;
  }
  
  public static DomainConfig getDomainConfig(String paramString)
  {
    return getDomainConfig(paramString, false);
  }
  
  public static DomainConfig getDomainConfig(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (domainConfigMap.contains(paramString)) {
      return (DomainConfig)domainConfigMap.get(paramString);
    }
    long l = System.currentTimeMillis();
    String str;
    if (paramString.startsWith("wss://"))
    {
      str = paramString;
      if (paramString.length() > 6) {
        str = "https://" + paramString.substring(6);
      }
    }
    try
    {
      for (;;)
      {
        Object localObject = new URL(str);
        paramString = ((URL)localObject).getHost();
        i = ((URL)localObject).getPort();
        localObject = paramString;
        if (!TextUtils.isEmpty(paramString))
        {
          localObject = paramString;
          if (paramString.startsWith("www.")) {
            localObject = paramString.substring(4);
          }
        }
        paramString = new DomainConfig((String)localObject, i);
        if (paramBoolean) {
          domainConfigMap.put(str, paramString);
        }
        if (QLog.isColorLevel()) {
          QLog.i("[mini] http.", 2, "getDomainConfig url for " + str + " costTime:" + (System.currentTimeMillis() - l));
        }
        return paramString;
        str = paramString;
        if (!paramString.startsWith("https://")) {
          if (paramString.startsWith("http://")) {
            str = "https://" + paramString.substring("http://".length());
          } else {
            str = "https://" + paramString;
          }
        }
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      try
      {
        URL localURL = new URL("https://" + str);
        paramString = localURL.getHost();
        int i = localURL.getPort();
      }
      catch (MalformedURLException paramString)
      {
        QLog.e("[mini] http.", 1, "getDomainConfig url error" + str, localMalformedURLException);
      }
    }
    return null;
  }
  
  public static boolean isDomainConfigMatch(DomainConfig paramDomainConfig1, DomainConfig paramDomainConfig2)
  {
    boolean bool1 = true;
    if ((paramDomainConfig1 == null) || (paramDomainConfig2 == null))
    {
      bool1 = false;
      return bool1;
    }
    boolean bool2 = isDomainMatchRfc2019(paramDomainConfig1.host, paramDomainConfig2);
    label40:
    int i;
    if (paramDomainConfig1.port == paramDomainConfig2.port)
    {
      j = 1;
      i = j;
      if (j == 0)
      {
        i = j;
        if (paramDomainConfig1.port <= 0)
        {
          if ((paramDomainConfig2.port != 80) && (paramDomainConfig2.port != 8080) && (paramDomainConfig2.port > 0)) {
            break label175;
          }
          i = 1;
        }
      }
      label83:
      j = i;
      if (i == 0)
      {
        j = i;
        if (paramDomainConfig2.port <= 0) {
          if ((paramDomainConfig1.port != 80) && (paramDomainConfig1.port != 8080) && (paramDomainConfig1.port > 0)) {
            break label180;
          }
        }
      }
    }
    label175:
    label180:
    for (int j = 1;; j = 0)
    {
      if (needCheckPost <= 0) {
        break label185;
      }
      QLog.i("[mini] http.", 1, "isDomainConfigMatch needCheckPost:" + needCheckPost);
      if ((bool2) && (j != 0)) {
        break;
      }
      return false;
      j = 0;
      break label40;
      i = 0;
      break label83;
    }
    label185:
    return bool2;
  }
  
  public static boolean isDomainMatchRfc2019(String paramString, DomainConfig paramDomainConfig)
  {
    if (paramDomainConfig == null) {}
    do
    {
      return false;
      QLog.d("domainValid", 1, "isDomainMatchRfc2019 allowedDomainHost=" + paramString + ", requestDomain=" + paramDomainConfig);
    } while (((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(paramDomainConfig.host)) || (!paramString.startsWith(".")) || (paramString.split("\\.").length < 1) || (!paramDomainConfig.host.endsWith(paramString))) && (!paramString.equals(paramDomainConfig.host)));
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (paramObject == null);
        bool1 = bool2;
      } while (getClass() != paramObject.getClass());
      paramObject = (DomainConfig)paramObject;
      bool1 = bool2;
    } while (this.port != paramObject.port);
    return this.host.equals(paramObject.host);
  }
  
  public int hashCode()
  {
    return this.host.hashCode() * 31 + this.port;
  }
  
  public String toString()
  {
    if (this.port > 0) {}
    for (String str = ", port=" + this.port;; str = "") {
      return "DomainConfig{host='" + this.host + '\'' + str + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.DomainConfig
 * JD-Core Version:    0.7.0.1
 */