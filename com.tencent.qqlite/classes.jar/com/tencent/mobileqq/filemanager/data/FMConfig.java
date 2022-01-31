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
  public static final String b = "FileMaxSize";
  public static final String c = "FileType";
  public static final String d = "InterfacePage";
  public static final String e = "PreviewMode";
  public static final String f = "FunctionSwitch";
  public static final String g = "WiFiMaxSize";
  public static final String h = "3GMaxSize";
  public static final String i = "OfflineFileList";
  public static final String j = "OpenForQQMusic";
  public static final String k = "OpenForQQBrowse";
  public static final String l = "Merge";
  public static final String m = "FunctionalSwitch";
  public static final String n = "SupportVersion";
  public static final String o = "FormatSupport";
  QQAppInterface a;
  
  public FMConfig(QQAppInterface paramQQAppInterface, FileManagerUtil.PreViewDataHandler paramPreViewDataHandler, long paramLong)
  {
    this.a = paramQQAppInterface;
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("OfflineFileConfig", 0).edit();
    paramQQAppInterface.clear();
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
        paramQQAppInterface.putString(("OnlinePreView" + (String)localObject3 + str1).toLowerCase(), str2);
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
        paramQQAppInterface.putString(("OfflineConfig" + (String)localObject2 + (String)localObject5).toLowerCase(), str1);
      }
    }
    paramQQAppInterface.putLong("FileOnlinePreviewVersionKey", paramLong);
    long l1 = MessageCache.a();
    paramQQAppInterface.putLong("FMConfigUpdateLastTime", l1);
    paramQQAppInterface.commit();
    QLog.i("FMConfig<FileAssistant>", 1, "commit Config data, time[" + l1 + "], ver[" + paramLong + "]");
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("OfflineFileConfig", 0).getString(paramString.toLowerCase(), null);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0)) {
      return paramQQAppInterface;
    }
    return FileManagerUtil.c(paramString);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return a(paramQQAppInterface, "OnlinePreView", FileUtil.a(paramString1).replace(".", ""), paramString2);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    return a(paramQQAppInterface, paramString1 + paramString2 + paramString3);
  }
  
  public static String b(QQAppInterface paramQQAppInterface, String paramString)
  {
    return a(paramQQAppInterface, "OnlinePreView", "AutoPreview", paramString);
  }
  
  public static String b(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return a(paramQQAppInterface, "OfflineConfig", paramString1, paramString2);
  }
  
  public static String c(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    return a(paramQQAppInterface, "OfflineConfig", paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FMConfig
 * JD-Core Version:    0.7.0.1
 */