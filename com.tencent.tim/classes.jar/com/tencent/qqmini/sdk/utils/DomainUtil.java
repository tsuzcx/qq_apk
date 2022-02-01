package com.tencent.qqmini.sdk.utils;

import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.DomainConfig;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.Nullable;

public class DomainUtil
{
  private static final String CONFIG_SPLIT = ";";
  private static final String[] DOMAIN_NAME_LIST = { "Request", "Websocket", "Download", "Upload", "Webview" };
  public static final int DOMIAN_TYPE_DOWNLOAD = 2;
  public static final int DOMIAN_TYPE_REQUEST = 0;
  public static final int DOMIAN_TYPE_UPLOAD = 3;
  public static final int DOMIAN_TYPE_WEBSOCKET = 1;
  public static final int DOMIAN_TYPE_WEBVIEW = 4;
  private static ConcurrentHashMap<Integer, ArrayList<DomainConfig>> mCachedDomainConfigMap;
  private static String mCurWhiteListConfig;
  private static ArrayList<String> sDominWhiteList = null;
  
  private static boolean checkAppConfig(MiniAppInfo paramMiniAppInfo, String paramString, int paramInt, DomainConfig paramDomainConfig)
  {
    if ((paramDomainConfig != null) && (!TextUtils.isEmpty(paramDomainConfig.host)) && (paramMiniAppInfo != null))
    {
      Object localObject = paramMiniAppInfo.requestDomainList;
      switch (paramInt)
      {
      default: 
        paramMiniAppInfo = (MiniAppInfo)localObject;
        if (paramMiniAppInfo != null) {
          paramMiniAppInfo = paramMiniAppInfo.iterator();
        }
        break;
      case 1: 
      case 2: 
      case 3: 
      case 4: 
        for (;;)
        {
          for (;;)
          {
            if (!paramMiniAppInfo.hasNext()) {
              break label224;
            }
            localObject = (String)paramMiniAppInfo.next();
            try
            {
              if (!TextUtils.isEmpty((CharSequence)localObject))
              {
                localObject = DomainConfig.getDomainConfig(((String)localObject).toLowerCase());
                if (DomainConfig.isDomainConfigMatch((DomainConfig)localObject, paramDomainConfig))
                {
                  putDomainConfigToCache(paramDomainConfig, paramInt);
                  return true;
                  paramMiniAppInfo = paramMiniAppInfo.socketDomainList;
                  break;
                  paramMiniAppInfo = paramMiniAppInfo.downloadFileDomainList;
                  break;
                  paramMiniAppInfo = paramMiniAppInfo.uploadFileDomainList;
                  break;
                  paramMiniAppInfo = paramMiniAppInfo.businessDomainList;
                  break;
                }
                QMLog.i("[mini] http.domainValid", "request:" + paramDomainConfig + ",allow:" + localObject);
              }
            }
            catch (Throwable localThrowable)
            {
              QMLog.e("[mini] http.domainValid", "check domainValid error, requestUrl:" + paramString, localThrowable);
            }
          }
        }
      }
    }
    label224:
    return false;
  }
  
  private static boolean checkIsReportDomain(String paramString)
  {
    if (((QUAUtil.isRdmBuild()) || (((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).isDebugVersion())) && (paramString.startsWith(WnsConfig.getConfig("qqminiapp", "MiniAppRMDDomainWhiteList", "https://www.urlshare.cn/"))))
    {
      QMLog.d("[mini] http.domainValid", "rdm mode, https://www.urlshare.cn/ is valid, current Url is: " + paramString);
      return true;
    }
    return false;
  }
  
  private static boolean checkProtocol(MiniAppInfo paramMiniAppInfo, String paramString1, int paramInt, String paramString2)
  {
    if (paramInt == 4) {}
    for (boolean bool = true; !isValidPrefix(paramString2, bool); bool = false)
    {
      QMLog.e("[mini] http.domainValid", DOMAIN_NAME_LIST[paramInt] + ":请求域名不合法，请使用https或wss协议,reqeustUrl:" + paramString1);
      if (!isOnlineVersion(paramMiniAppInfo)) {
        ThreadManager.getUIHandler().post(new DomainUtil.2(paramInt, paramString2));
      }
      return true;
    }
    return false;
  }
  
  @Nullable
  private static Boolean checkVersionAndDebug(MiniAppInfo paramMiniAppInfo, String paramString1, int paramInt, String paramString2)
  {
    if ((!isOnlineVersion(paramMiniAppInfo)) && (getEnableDebug(paramMiniAppInfo.appId)))
    {
      if (!isValidPrefix(paramString2, true))
      {
        QMLog.d("[mini] http.domainValid", DOMAIN_NAME_LIST[paramInt] + "域名不合法，需使用https或wss协议:" + paramString1);
        return Boolean.valueOf(false);
      }
      QMLog.d("[mini] http.domainValid", "debug opened and not online version, skip:" + paramString1);
      return Boolean.valueOf(true);
    }
    return null;
  }
  
  private static boolean checkWnsConfig(String paramString, int paramInt, DomainConfig paramDomainConfig)
  {
    Object localObject = getDomainWhiteList();
    try
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (DomainConfig.isDomainMatchRfc2019((String)((Iterator)localObject).next(), paramDomainConfig))
        {
          putDomainConfigToCache(paramDomainConfig, paramInt);
          return true;
        }
      }
    }
    catch (Throwable paramDomainConfig)
    {
      QMLog.e("[mini] http.domainValid", "check domainValid error, requestUrl:" + paramString, paramDomainConfig);
    }
    return false;
  }
  
  private static ArrayList<String> getDomainWhiteList()
  {
    try
    {
      if (sDominWhiteList == null)
      {
        String str1 = WnsConfig.getConfig("qqminiapp", "defaultAllowedHostList", ".qlogo.cn;.tcb.qcloud.la;open.mp.qq.com;api-report.q.qq.com;rpt.gdt.qq.com;.gtimg.cn");
        if ((str1 != null) && (!str1.equals(mCurWhiteListConfig)))
        {
          QMLog.i("[mini] http.domainValid", "Default white domain:" + str1);
          sDominWhiteList = new ArrayList();
          try
          {
            String[] arrayOfString = str1.split(";");
            if (arrayOfString != null)
            {
              int j = arrayOfString.length;
              int i = 0;
              while (i < j)
              {
                String str2 = arrayOfString[i];
                if (!TextUtils.isEmpty(str2)) {
                  sDominWhiteList.add(str2);
                }
                i += 1;
              }
            }
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
            mCurWhiteListConfig = str1;
          }
        }
      }
      return sDominWhiteList;
    }
    finally {}
  }
  
  public static boolean getEnableDebug(String paramString)
  {
    return StorageUtil.getPreference().getBoolean(paramString + "_debug", false);
  }
  
  private static boolean isDomainConfigCached(DomainConfig paramDomainConfig, int paramInt)
  {
    if (paramDomainConfig == null) {
      return false;
    }
    Object localObject = mCachedDomainConfigMap;
    if (localObject == null) {
      return false;
    }
    localObject = (ArrayList)((Map)localObject).get(Integer.valueOf(paramInt));
    return (localObject != null) && (((ArrayList)localObject).contains(paramDomainConfig));
  }
  
  public static boolean isDomainValid(MiniAppInfo paramMiniAppInfo, boolean paramBoolean, String paramString, int paramInt)
  {
    boolean bool = true;
    if ((TextUtils.isEmpty(paramString)) || (paramMiniAppInfo == null))
    {
      QMLog.e("[mini] http.domainValid", "url or appcconfig is null. url : " + paramString + "; appconfig : " + paramMiniAppInfo);
      paramBoolean = false;
    }
    Object localObject;
    do
    {
      do
      {
        do
        {
          do
          {
            return paramBoolean;
            if (paramBoolean)
            {
              QMLog.d("[mini] http.domainValid", DOMAIN_NAME_LIST[paramInt] + ":域名检查 skipDomainCheckFromJs:" + paramString);
              return true;
            }
            if (paramMiniAppInfo.skipDomainCheck == 1) {}
            for (int i = 1; i != 0; i = 0)
            {
              QMLog.d("[mini] http.domainValid", DOMAIN_NAME_LIST[paramInt] + ":域名检查 skip:" + paramString);
              return true;
            }
            localObject = paramString.toLowerCase();
            Boolean localBoolean = checkVersionAndDebug(paramMiniAppInfo, paramString, paramInt, (String)localObject);
            if (localBoolean != null) {
              return localBoolean.booleanValue();
            }
            paramBoolean = bool;
          } while (checkIsReportDomain(paramString));
          if (checkProtocol(paramMiniAppInfo, paramString, paramInt, (String)localObject)) {
            return false;
          }
          localObject = DomainConfig.getDomainConfig((String)localObject);
          paramBoolean = bool;
        } while (isDomainConfigCached((DomainConfig)localObject, paramInt));
        paramBoolean = bool;
      } while (checkAppConfig(paramMiniAppInfo, paramString, paramInt, (DomainConfig)localObject));
      paramBoolean = bool;
    } while (checkWnsConfig(paramString, paramInt, (DomainConfig)localObject));
    QMLog.e("[mini] http.domainValid", DOMAIN_NAME_LIST[paramInt] + ":请求域名不合法，请配置，requestUrl:" + paramString);
    if (!isOnlineVersion(paramMiniAppInfo))
    {
      ThreadManager.getUIHandler().post(new DomainUtil.1(paramInt, (DomainConfig)localObject));
      return false;
    }
    return false;
  }
  
  private static boolean isOnlineVersion(MiniAppInfo paramMiniAppInfo)
  {
    return (paramMiniAppInfo != null) && (paramMiniAppInfo.verType == 3);
  }
  
  private static boolean isValidPrefix(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      if ((TextUtils.isEmpty(paramString)) || ((!paramString.startsWith("https://")) && (!paramString.startsWith("wss://")) && (!paramString.startsWith("http://")))) {}
    }
    while ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("https://")) || (paramString.startsWith("wss://"))))
    {
      return true;
      return false;
    }
    return false;
  }
  
  private static void putDomainConfigToCache(DomainConfig paramDomainConfig, int paramInt)
  {
    if (paramDomainConfig == null) {}
    ArrayList localArrayList1;
    do
    {
      return;
      if (mCachedDomainConfigMap == null) {
        mCachedDomainConfigMap = new ConcurrentHashMap();
      }
      ArrayList localArrayList2 = (ArrayList)mCachedDomainConfigMap.get(Integer.valueOf(paramInt));
      localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        mCachedDomainConfigMap.put(Integer.valueOf(paramInt), localArrayList1);
      }
    } while (localArrayList1.contains(paramDomainConfig));
    localArrayList1.add(paramDomainConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.DomainUtil
 * JD-Core Version:    0.7.0.1
 */