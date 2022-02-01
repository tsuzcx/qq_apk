package com.tencent.superplayer.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.api.TVideoNetInfo.DefinitionInfo;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.config.TPPlayerConfig;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class CommonUtil
{
  private static AtomicInteger PLAYER_ID_BASE = new AtomicInteger(1000);
  public static final String TAG = CommonUtil.class.getSimpleName();
  
  public static String calculateFileIDForVideoInfo(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    if (!TextUtils.isEmpty(paramSuperPlayerVideoInfo.getFileId())) {
      return paramSuperPlayerVideoInfo.getFileId();
    }
    if ((!TextUtils.isEmpty(paramSuperPlayerVideoInfo.getVid())) && (paramSuperPlayerVideoInfo.getTVideoNetInfo() != null) && (paramSuperPlayerVideoInfo.getTVideoNetInfo().getCurrentDefinition() != null)) {
      return paramSuperPlayerVideoInfo.getVid() + paramSuperPlayerVideoInfo.getTVideoNetInfo().getCurrentDefinition().getDefn();
    }
    if (!TextUtils.isEmpty(paramSuperPlayerVideoInfo.getPlayUrl())) {
      return calculateMD5ForInput(paramSuperPlayerVideoInfo.getPlayUrl());
    }
    return null;
  }
  
  public static String calculateMD5ForInput(String paramString)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (paramString != null)
    {
      localObject1 = localObject3;
      if ("".equals(paramString)) {}
    }
    try
    {
      localObject1 = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject1).update(paramString.getBytes());
      paramString = new BigInteger(1, ((MessageDigest)localObject1).digest()).toString(16);
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException1)
    {
      try
      {
        while (paramString.length() < 32)
        {
          localObject1 = "0" + paramString;
          paramString = (String)localObject1;
        }
        localObject1 = paramString.toUpperCase();
        return localObject1;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException2)
      {
        break label97;
      }
      localNoSuchAlgorithmException1 = localNoSuchAlgorithmException1;
      paramString = localObject2;
    }
    label97:
    LogUtil.e(TAG, "calculateMD5ForInput error", localNoSuchAlgorithmException1);
    return paramString;
  }
  
  public static String convertSetToString(Set<String> paramSet)
  {
    if (paramSet == null) {}
    do
    {
      return null;
      localObject = new HashSet(paramSet);
    } while (((Set)localObject).size() == 0);
    paramSet = new StringBuilder();
    Object localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramSet.append((String)((Iterator)localObject).next()).append(",");
    }
    paramSet = paramSet.toString();
    return paramSet.substring(0, paramSet.length() - 1);
  }
  
  public static ArrayList<Map<String, String>> createHttpHeaderForAllUrl(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    int k = 0;
    if (paramSuperPlayerVideoInfo.getPlayUrls() == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i;
    int j;
    if (paramSuperPlayerVideoInfo.getCookie() != null)
    {
      i = paramSuperPlayerVideoInfo.getCookie().size();
      if (paramSuperPlayerVideoInfo.getUrlHostList() == null) {
        break label130;
      }
      j = paramSuperPlayerVideoInfo.getUrlHostList().size();
    }
    for (;;)
    {
      if (k >= paramSuperPlayerVideoInfo.getPlayUrls().length) {
        break label135;
      }
      HashMap localHashMap = new HashMap();
      if (k < i) {
        localHashMap.put("Cookie", paramSuperPlayerVideoInfo.getCookie().get(k));
      }
      if (k < j) {
        localHashMap.put("Host", paramSuperPlayerVideoInfo.getUrlHostList().get(k));
      }
      localArrayList.add(localHashMap);
      k += 1;
      continue;
      i = 0;
      break;
      label130:
      j = 0;
    }
    label135:
    return localArrayList;
  }
  
  public static Map<String, String> createHttpHeaderForFirstUrl(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    HashMap localHashMap = new HashMap();
    if ((paramSuperPlayerVideoInfo.getUrlHostList() != null) && (paramSuperPlayerVideoInfo.getUrlHostList().size() > 0)) {
      localHashMap.put("Host", paramSuperPlayerVideoInfo.getUrlHostList().get(0));
    }
    if ((paramSuperPlayerVideoInfo.getCookie() != null) && (paramSuperPlayerVideoInfo.getCookie().size() > 0)) {
      localHashMap.put("Cookie", paramSuperPlayerVideoInfo.getCookie().get(0));
    }
    return localHashMap;
  }
  
  public static String createPlayerTag()
  {
    return String.valueOf(PLAYER_ID_BASE.getAndAdd(1));
  }
  
  public static String getCurrentProcessName()
  {
    if (SuperPlayerSDKMgr.getContext() == null) {
      localObject = "unknown";
    }
    int i;
    String str;
    Iterator localIterator;
    do
    {
      return localObject;
      i = Process.myPid();
      str = "";
      localIterator = ((ActivityManager)SuperPlayerSDKMgr.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
      localObject = str;
    } while (!localIterator.hasNext());
    Object localObject = (ActivityManager.RunningAppProcessInfo)localIterator.next();
    if (((ActivityManager.RunningAppProcessInfo)localObject).pid == i) {
      str = ((ActivityManager.RunningAppProcessInfo)localObject).processName;
    }
    for (;;)
    {
      break;
    }
  }
  
  public static int getDownloadProxyServiceType(int paramInt)
  {
    if (SuperPlayerSDKMgr.getPlatform() <= 0) {
      return 0;
    }
    String str2 = String.valueOf(SuperPlayerSDKMgr.getPlatform());
    String str1 = str2;
    if (paramInt >= 0) {
      str1 = str2 + String.valueOf(paramInt);
    }
    return Integer.valueOf(str1).intValue();
  }
  
  public static boolean initDataTransportDataFolder(int paramInt)
  {
    if (TextUtils.isEmpty(SuperPlayerSDKMgr.getDataCacheFolder())) {
      return false;
    }
    String str = SuperPlayerSDKMgr.getDataCacheFolder() + File.separator + paramInt;
    try
    {
      File localFile = new File(str);
      if (!localFile.exists())
      {
        localFile.mkdirs();
        LogUtil.d(TAG, "业务缓存目录创建成功，path = " + str);
      }
      for (;;)
      {
        makeSureCacheNotVisible(SuperPlayerSDKMgr.getDataCacheFolder());
        TPPlayerMgr.setProxyConfigsWithServiceType(paramInt, str, str, TPPlayerConfig.getProxyConfigStr());
        return true;
        LogUtil.d(TAG, "业务缓存目录已存在，path = " + str);
      }
      return false;
    }
    catch (Exception localException)
    {
      LogUtil.d(TAG, "业务缓存目录创建失败，path = " + str + ", error = " + localException.getMessage());
    }
  }
  
  public static boolean isLiveFormat(int paramInt)
  {
    return (paramInt == 401) || (paramInt == 402) || (paramInt == 403) || (paramInt == 201) || (paramInt == 202) || (paramInt == 203);
  }
  
  public static boolean isMainProcess()
  {
    try
    {
      boolean bool = SuperPlayerSDKMgr.getContext().getPackageName().equals(getCurrentProcessName());
      return bool;
    }
    catch (Throwable localThrowable)
    {
      LogUtil.e(TAG, "isMainProcess happen error.", localThrowable);
    }
    return false;
  }
  
  private static void makeSureCacheNotVisible(String paramString)
  {
    paramString = new File(paramString, ".nomedia");
    if (!paramString.exists()) {
      try
      {
        boolean bool = paramString.createNewFile();
        LogUtil.d(TAG, ".nomedia file create result:" + bool);
        return;
      }
      catch (IOException paramString)
      {
        LogUtil.w(TAG, ".nomedia file create failed.");
        return;
      }
    }
    LogUtil.d(TAG, ".nomedia file exists");
  }
  
  public static int parseStr2Int(String paramString, int paramInt)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.utils.CommonUtil
 * JD-Core Version:    0.7.0.1
 */