package com.tencent.mobileqq.filemanager.data;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.PreViewDataHandler;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import mqq.app.MobileQQ;

public class FMConfig
{
  public static final String a = "FMConfig<FileAssistant>";
  QQAppInterface a;
  
  public FMConfig(QQAppInterface paramQQAppInterface, FileManagerUtil.PreViewDataHandler paramPreViewDataHandler, long paramLong)
  {
    this.a = paramQQAppInterface;
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("OfflineFileConfig", 0);
    paramQQAppInterface.edit().clear().commit();
    SharedPreferences.Editor localEditor = paramQQAppInterface.edit();
    Object localObject1 = (HashMap)paramPreViewDataHandler.a().get("OnlinePreView");
    Object localObject2 = ((HashMap)localObject1).keySet().iterator();
    Object localObject3;
    Object localObject4;
    Object localObject5;
    String str1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      localObject4 = (HashMap)((HashMap)localObject1).get(localObject3);
      localObject5 = ((HashMap)localObject4).keySet().iterator();
      while (((Iterator)localObject5).hasNext())
      {
        str1 = (String)((Iterator)localObject5).next();
        String.valueOf(((HashMap)localObject4).get(str1));
        String str2 = (String)((HashMap)localObject4).get(str1);
        localEditor.putString(("OnlinePreView" + (String)localObject3 + str1).toLowerCase(), str2).commit();
      }
    }
    paramPreViewDataHandler = (HashMap)paramPreViewDataHandler.a().get("OfflineConfig");
    localObject1 = paramPreViewDataHandler.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject3 = (HashMap)paramPreViewDataHandler.get(localObject2);
      localObject4 = ((HashMap)localObject3).keySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (String)((Iterator)localObject4).next();
        str1 = String.valueOf(((HashMap)localObject3).get(localObject5));
        localEditor.putString(("OfflineConfig" + (String)localObject2 + (String)localObject5).toLowerCase(), str1).commit();
      }
    }
    paramQQAppInterface.edit().putLong("FileOnlinePreviewVersionKey", paramLong).commit();
    long l = MessageCache.a();
    paramQQAppInterface.edit().putLong("FMConfigUpdateLastTime", l).commit();
    QLog.i("FMConfig<FileAssistant>", 1, "commit Config data, time[" + l + "], ver[" + paramLong + "]");
  }
  
  public static String a(QQAppInterface paramQQAppInterface, FMConfig.eOfflineFuntion parameOfflineFuntion, FMConfig.eOfflineFileListSubKey parameOfflineFileListSubKey)
  {
    return a(paramQQAppInterface, "OfflineConfig", parameOfflineFuntion.toString(), parameOfflineFileListSubKey.toString());
  }
  
  public static String a(QQAppInterface paramQQAppInterface, FMConfig.eOfflineFuntion parameOfflineFuntion, FMConfig.eOpenForQQAppSubKey parameOpenForQQAppSubKey)
  {
    return a(paramQQAppInterface, "OfflineConfig", parameOfflineFuntion.toString(), parameOpenForQQAppSubKey.toString());
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString, FMConfig.eOnlinePreViewSubkey parameOnlinePreViewSubkey)
  {
    return a(paramQQAppInterface, "OnlinePreView", FileUtil.a(paramString).replace(".", ""), parameOnlinePreViewSubkey.toString());
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("OfflineFileConfig", 0);
    paramString1 = paramString1 + paramString2 + paramString3;
    paramQQAppInterface = paramQQAppInterface.getString(paramString1.toLowerCase(), null);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0)) {
      return paramQQAppInterface;
    }
    return FileManagerUtil.c(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FMConfig
 * JD-Core Version:    0.7.0.1
 */