package com.tencent.android.tpush.service.channel.security;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.security.Security;
import com.tencent.tpns.baseapi.base.util.Md5;

public class TpnsSecurity
{
  private static final String DEVICE_ID_KEY_NAME = "deviceId_v1";
  private static final String DEVICE_ID_PREFIX = "deviceId_";
  private static final String DEVICE_ID_VERSION = "v1";
  private static final String SETTINGS_DEVICE_ID_KEY_NAME = ".com.tencent.tpush.cache.deviceId_v1";
  private static final String SETTINGS_DEVICE_ID_PREFIX = ".com.tencent.tpush.cache";
  private static final String SHAREPREFERENCE_FILE_NAME = "device_id.vip";
  private static final String TAG = "TpnsSecurity";
  private static String sApkSignature = "";
  public static d tea = null;
  
  public static String generateLocalSocketServieName(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        paramContext = Security.generateLocalSocketServieNameNative(paramContext);
        return paramContext;
      }
      catch (Throwable paramContext)
      {
        TLogger.e("TpnsSecurity", "generateLocalSocketServieName 未知错误", paramContext);
      }
    }
    throw new SecurityException("generate local socket server name error");
  }
  
  public static String getBusinessDeviceId(Context paramContext)
  {
    if (paramContext == null) {
      throw new SecurityException("get business device id error cause context is null");
    }
    String str = getSettingsLocalDeviceId(paramContext);
    if (str != null) {
      return str;
    }
    str = getPreferenceLocalDeviceId(paramContext);
    if (str != null)
    {
      setSettingsLocalDeviceId(paramContext, str);
      return str;
    }
    str = Security.getBusinessDeviceIdNative(paramContext);
    setPreferenceLocalDeviceId(paramContext, str);
    setSettingsLocalDeviceId(paramContext, str);
    return str;
  }
  
  public static String getEncryptAPKSignature(Context paramContext)
  {
    if (!TextUtils.isEmpty(sApkSignature))
    {
      TLogger.d("TpnsSecurity", "apkSignature already cached ");
      return sApkSignature;
    }
    if (paramContext != null)
    {
      sApkSignature = Security.getEncryptAPKSignatureNative(paramContext);
      return sApkSignature;
    }
    throw new SecurityException("get encrypt apk signature error");
  }
  
  private static String getPreferenceLocalDeviceId(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("device_id.vip", 0);
    if (!paramContext.contains(Md5.md5("deviceId_v1"))) {}
    do
    {
      do
      {
        return null;
        paramContext = paramContext.getString(Md5.md5("deviceId_v1"), null);
      } while ((paramContext == null) || (paramContext.trim().equals("")));
      paramContext = Rijndael.decrypt(paramContext);
    } while (i.b(paramContext));
    return paramContext;
  }
  
  private static String getSettingsLocalDeviceId(Context paramContext)
  {
    paramContext = com.tencent.android.tpush.service.util.d.a(paramContext, ".com.tencent.tpush.cache.deviceId_v1");
    if (paramContext == null) {}
    do
    {
      return null;
      paramContext = Rijndael.decrypt(paramContext);
    } while (i.b(paramContext));
    return paramContext;
  }
  
  public static d getTEA()
  {
    if (tea == null) {
      tea = new d("0123456789abcdef".getBytes());
    }
    return tea;
  }
  
  public static String oiSymmetryDecrypt2(String paramString)
  {
    "".getBytes();
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        TLogger.e("TpnsSecurity", ">> oiSymmetryDecrypt2 解密内容输入为空");
        return "";
      }
      paramString = b.a(paramString);
      if ((paramString == null) || (paramString.length <= 0))
      {
        TLogger.e("TpnsSecurity", ">> oiSymmetryDecrypt2 解码失败，返回空字符串");
        return "failed";
      }
      paramString = Security.oiSymmetryDecrypt2Byte(paramString);
      if ((paramString == null) || (paramString.length <= 0))
      {
        TLogger.e("TpnsSecurity", ">> oiSymmetryDecrypt2 解密失败，返回空字符串");
        return "failed";
      }
    }
    catch (Throwable paramString)
    {
      TLogger.e("TpnsSecurity", ">> oiSymmetryEncrypt2 未知错误", paramString);
      return "failed";
    }
    return new String(paramString);
  }
  
  public static String oiSymmetryEncrypt2(String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        TLogger.e("TpnsSecurity", ">> oiSymmetryEncrypt2 加密内容输入为空");
        return "";
      }
      Object localObject = Security.oiSymmetryEncrypt2Byte(paramString);
      if (localObject == null)
      {
        TLogger.e("TpnsSecurity", ">> oiSymmetryEncrypt2 加密失败，返回空字符串 inBuff:" + paramString);
        return "failed";
      }
      localObject = c.a((byte[])localObject);
      paramString = (String)localObject;
      if (localObject == null)
      {
        TLogger.e("TpnsSecurity", ">> oiSymmetryEncrypt2 Base64编码失败，返回空字符串");
        return "failed";
      }
    }
    catch (Throwable paramString)
    {
      TLogger.e("TpnsSecurity", ">> oiSymmetryEncrypt2 未知错误", paramString);
      paramString = "failed";
    }
    return paramString;
  }
  
  private static void setPreferenceLocalDeviceId(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("device_id.vip", 0).edit();
    paramContext.putString(Md5.md5("deviceId_v1"), Rijndael.encrypt(paramString));
    paramContext.commit();
  }
  
  private static void setSettingsLocalDeviceId(Context paramContext, String paramString)
  {
    com.tencent.android.tpush.service.util.d.a(paramContext, ".com.tencent.tpush.cache.deviceId_v1", Rijndael.encrypt(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.channel.security.TpnsSecurity
 * JD-Core Version:    0.7.0.1
 */