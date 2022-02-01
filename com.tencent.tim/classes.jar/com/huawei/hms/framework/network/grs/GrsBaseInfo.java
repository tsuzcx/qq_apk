package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.a.c;
import com.huawei.hms.framework.network.grs.local.model.a;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.net.URLEncoder;

public class GrsBaseInfo
  implements Cloneable
{
  private static final String TAG = GrsBaseInfo.class.getSimpleName();
  private String androidVersion;
  private String appName;
  private String countrySource;
  private String deviceModel;
  private String issueCountry;
  private String regCountry;
  private String romVersion;
  private String serCountry;
  private String uid;
  private String versionName;
  
  private StringBuffer getStringBuffer(StringBuffer paramStringBuffer, boolean paramBoolean, Context paramContext)
  {
    String str = getAndroidVersion();
    if (!TextUtils.isEmpty(str))
    {
      if (!TextUtils.isEmpty(paramStringBuffer.toString())) {
        paramStringBuffer.append("&");
      }
      paramStringBuffer.append("android_version");
      paramStringBuffer.append("=");
      paramStringBuffer.append(str);
    }
    str = getRomVersion();
    if (!TextUtils.isEmpty(str))
    {
      if (!TextUtils.isEmpty(paramStringBuffer.toString())) {
        paramStringBuffer.append("&");
      }
      paramStringBuffer.append("rom_version");
      paramStringBuffer.append("=");
      paramStringBuffer.append(str);
    }
    str = getDeviceModel();
    if (!TextUtils.isEmpty(str))
    {
      if (!TextUtils.isEmpty(paramStringBuffer.toString())) {
        paramStringBuffer.append("&");
      }
      paramStringBuffer.append("device_model");
      paramStringBuffer.append("=");
      paramStringBuffer.append(str);
    }
    paramContext = new c(paramContext).a();
    if ((!TextUtils.isEmpty(paramContext)) && (!paramBoolean)) {}
    try
    {
      paramContext = URLEncoder.encode(paramContext, "UTF-8");
      if (!TextUtils.isEmpty(paramStringBuffer.toString())) {
        paramStringBuffer.append("&");
      }
      paramStringBuffer.append("cp");
      paramStringBuffer.append("=");
      paramStringBuffer.append(paramContext);
    }
    catch (UnsupportedEncodingException paramContext)
    {
      for (;;)
      {
        Logger.e(TAG, "cp UnsupportedEncodingException.", paramContext);
      }
    }
    paramContext = getCountrySource();
    if (!TextUtils.isEmpty(paramContext))
    {
      if (!TextUtils.isEmpty(paramStringBuffer.toString())) {
        paramStringBuffer.append("&");
      }
      paramStringBuffer.append("country_source");
      paramStringBuffer.append("=");
      paramStringBuffer.append(paramContext);
    }
    return paramStringBuffer;
  }
  
  private boolean isEqual(String paramString1, String paramString2)
  {
    if ((paramString1 == null) && (paramString2 == null)) {}
    do
    {
      return true;
      if ((paramString1 == null) || (paramString2 == null)) {
        return false;
      }
    } while (paramString1.equals(paramString2));
    return false;
  }
  
  public GrsBaseInfo clone()
  {
    return (GrsBaseInfo)super.clone();
  }
  
  public boolean compare(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      if (!(paramObject instanceof GrsBaseInfo)) {
        break;
      }
      paramObject = (GrsBaseInfo)paramObject;
    } while ((isEqual(this.serCountry, paramObject.serCountry)) && (isEqual(this.versionName, paramObject.versionName)) && (isEqual(this.appName, paramObject.appName)) && (isEqual(this.uid, paramObject.uid)) && (isEqual(this.regCountry, paramObject.regCountry)) && (isEqual(this.issueCountry, paramObject.issueCountry)) && (isEqual(this.androidVersion, paramObject.androidVersion)) && (isEqual(this.romVersion, paramObject.romVersion)) && (isEqual(this.deviceModel, paramObject.deviceModel)) && (isEqual(this.countrySource, paramObject.countrySource)));
    return false;
    return false;
  }
  
  public GrsBaseInfo copy()
  {
    GrsBaseInfo localGrsBaseInfo = new GrsBaseInfo();
    localGrsBaseInfo.setAppName(this.appName);
    localGrsBaseInfo.setSerCountry(this.serCountry);
    localGrsBaseInfo.setRegCountry(this.regCountry);
    localGrsBaseInfo.setIssueCountry(this.issueCountry);
    localGrsBaseInfo.setCountrySource(this.countrySource);
    localGrsBaseInfo.setAndroidVersion(this.androidVersion);
    localGrsBaseInfo.setDeviceModel(this.deviceModel);
    localGrsBaseInfo.setRomVersion(this.romVersion);
    localGrsBaseInfo.setUid(this.uid);
    localGrsBaseInfo.setVersionName(this.versionName);
    return localGrsBaseInfo;
  }
  
  public String getAndroidVersion()
  {
    return this.androidVersion;
  }
  
  public String getAppName()
  {
    return this.appName;
  }
  
  public String getCountrySource()
  {
    return this.countrySource;
  }
  
  public String getDeviceModel()
  {
    return this.deviceModel;
  }
  
  public String getGrsParasKey(boolean paramBoolean1, boolean paramBoolean2, Context paramContext)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject = com.huawei.hms.framework.network.grs.local.b.a(paramContext.getPackageName()).a();
    String str = "";
    if (localObject != null) {
      str = ((a)localObject).a();
    }
    localObject = getAppName();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isEmpty(str)))
    {
      localStringBuffer.append("app_name");
      localStringBuffer.append("=");
      localStringBuffer.append((String)localObject);
    }
    paramContext = getGrsReqParamJoint(paramBoolean1, paramBoolean2, str, paramContext);
    if (!TextUtils.isEmpty(paramContext))
    {
      if (!TextUtils.isEmpty(localStringBuffer.toString())) {
        localStringBuffer.append("&");
      }
      localStringBuffer.append(paramContext);
    }
    return localStringBuffer.toString();
  }
  
  public String getGrsReqParamJoint(boolean paramBoolean1, boolean paramBoolean2, String paramString, Context paramContext)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if ("1.0".equals(paramString))
    {
      Logger.v(TAG, "1.0 interface has no query param appname");
      paramString = getVersionName();
      if (!TextUtils.isEmpty(paramString))
      {
        if (!TextUtils.isEmpty(localStringBuffer.toString())) {
          localStringBuffer.append("&");
        }
        localStringBuffer.append("app_version").append("=").append(paramString);
      }
      paramString = getUid();
      if (!TextUtils.isEmpty(paramString))
      {
        if (!TextUtils.isEmpty(localStringBuffer.toString())) {
          localStringBuffer.append("&");
        }
        localStringBuffer.append("uid").append("=");
        if (!paramBoolean1) {
          break label388;
        }
        localStringBuffer.append(com.huawei.hms.framework.network.grs.c.b.b(paramString));
      }
    }
    for (;;)
    {
      paramString = getRegCountry();
      if ((!TextUtils.isEmpty(paramString)) && (!"UNKNOWN".equals(paramString)))
      {
        if (!TextUtils.isEmpty(localStringBuffer.toString())) {
          localStringBuffer.append("&");
        }
        localStringBuffer.append("reg_country").append("=").append(paramString);
      }
      paramString = getSerCountry();
      if ((!TextUtils.isEmpty(paramString)) && (!"UNKNOWN".equals(paramString)))
      {
        if (!TextUtils.isEmpty(localStringBuffer.toString())) {
          localStringBuffer.append("&");
        }
        localStringBuffer.append("ser_country");
        localStringBuffer.append("=");
        localStringBuffer.append(paramString);
      }
      paramString = getIssueCountry();
      if ((!TextUtils.isEmpty(paramString)) && (!"UNKNOWN".equals(paramString)))
      {
        if (!TextUtils.isEmpty(localStringBuffer.toString())) {
          localStringBuffer.append("&");
        }
        localStringBuffer.append("issue_country");
        localStringBuffer.append("=");
        localStringBuffer.append(paramString);
      }
      return getStringBuffer(localStringBuffer, paramBoolean2, paramContext).toString();
      if (!TextUtils.isEmpty(paramString))
      {
        localStringBuffer.append("app_name").append("=").append(paramString);
        break;
      }
      if (TextUtils.isEmpty(getAppName())) {
        break;
      }
      localStringBuffer.append("app_name").append("=").append(getAppName());
      break;
      label388:
      if (paramBoolean2) {
        localStringBuffer.append(com.huawei.hms.framework.network.grs.c.b.a(paramString));
      } else {
        localStringBuffer.append(paramString);
      }
    }
  }
  
  public String getIssueCountry()
  {
    return this.issueCountry;
  }
  
  public String getRegCountry()
  {
    return this.regCountry;
  }
  
  public String getRomVersion()
  {
    return this.romVersion;
  }
  
  public String getSerCountry()
  {
    return this.serCountry;
  }
  
  public String getUid()
  {
    return this.uid;
  }
  
  public String getVersionName()
  {
    return this.versionName;
  }
  
  public void setAndroidVersion(String paramString)
  {
    this.androidVersion = paramString;
  }
  
  public void setAppName(String paramString)
  {
    this.appName = paramString;
  }
  
  public void setCountrySource(String paramString)
  {
    this.countrySource = paramString;
  }
  
  public void setDeviceModel(String paramString)
  {
    this.deviceModel = paramString;
  }
  
  public void setIssueCountry(String paramString)
  {
    this.issueCountry = paramString;
  }
  
  public void setRegCountry(String paramString)
  {
    this.regCountry = paramString;
  }
  
  public void setRomVersion(String paramString)
  {
    this.romVersion = paramString;
  }
  
  public void setSerCountry(String paramString)
  {
    this.serCountry = paramString;
  }
  
  public void setUid(String paramString)
  {
    this.uid = paramString;
  }
  
  public void setVersionName(String paramString)
  {
    this.versionName = paramString;
  }
  
  int uniqueCode()
  {
    return (this.appName + "#" + this.serCountry + "#" + this.regCountry + "#" + this.issueCountry).hashCode();
  }
  
  public static @interface CountryCodeSource
  {
    public static final String APP = "APP";
    public static final String LOCALE_INFO = "LOCALE_INFO";
    public static final String NETWORK_COUNTRY = "NETWORK_COUNTRY";
    public static final String SIM_COUNTRY = "SIM_COUNTRY";
    public static final String UNKNOWN = "UNKNOWN";
    public static final String VENDOR_COUNTRY = "VENDOR_COUNTRY";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.GrsBaseInfo
 * JD-Core Version:    0.7.0.1
 */