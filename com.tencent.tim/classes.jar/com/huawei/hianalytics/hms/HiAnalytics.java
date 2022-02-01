package com.huawei.hianalytics.hms;

import android.content.Context;
import com.huawei.hianalytics.ab.bc.kl.gh;
import com.huawei.hianalytics.ab.fg.cd;
import java.util.LinkedHashMap;

public abstract class HiAnalytics
{
  private static cd defaultInstance = null;
  
  public static void clearCachedData()
  {
    if (gh.ab().bc()) {
      com.huawei.hianalytics.ab.fg.ab.ab().bc();
    }
  }
  
  private static cd getDefaultInstance()
  {
    try
    {
      if (defaultInstance == null) {
        defaultInstance = ab.ab().bc();
      }
      cd localcd = defaultInstance;
      return localcd;
    }
    finally {}
  }
  
  public static boolean getInitFlag()
  {
    return ab.ab().cd();
  }
  
  public static void onEvent(int paramInt, String paramString, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    if ((getDefaultInstance() != null) && (gh.ab().bc()))
    {
      if ((paramInt == 1) || (paramInt == 0)) {
        defaultInstance.ab(paramInt, paramString, paramLinkedHashMap);
      }
    }
    else {
      return;
    }
    com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "Data type no longer collects range.type: " + paramInt);
  }
  
  @Deprecated
  public static void onEvent(Context paramContext, String paramString1, String paramString2)
  {
    if (getDefaultInstance() != null) {
      defaultInstance.ab(paramContext, paramString1, paramString2);
    }
  }
  
  public static void onEvent(String paramString, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    if ((getDefaultInstance() != null) && (gh.ab().bc())) {
      defaultInstance.ab(0, paramString, paramLinkedHashMap);
    }
  }
  
  public static void onPause(Context paramContext)
  {
    if ((getDefaultInstance() != null) && (gh.ab().bc())) {
      defaultInstance.ab(paramContext);
    }
  }
  
  public static void onPause(Context paramContext, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    if ((getDefaultInstance() != null) && (gh.ab().bc())) {
      defaultInstance.ab(paramContext, paramLinkedHashMap);
    }
  }
  
  public static void onPause(String paramString, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    if ((getDefaultInstance() != null) && (gh.ab().bc())) {
      defaultInstance.ab(paramString, paramLinkedHashMap);
    }
  }
  
  public static void onReport()
  {
    if ((getDefaultInstance() != null) && (gh.ab().bc())) {
      defaultInstance.ab(-1);
    }
  }
  
  @Deprecated
  public static void onReport(Context paramContext)
  {
    if ((getDefaultInstance() != null) && (gh.ab().bc())) {
      defaultInstance.ab(paramContext, -1);
    }
  }
  
  public static void onResume(Context paramContext)
  {
    if ((getDefaultInstance() != null) && (gh.ab().bc())) {
      defaultInstance.bc(paramContext);
    }
  }
  
  public static void onResume(Context paramContext, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    if ((getDefaultInstance() != null) && (gh.ab().bc())) {
      defaultInstance.bc(paramContext, paramLinkedHashMap);
    }
  }
  
  public static void onResume(String paramString, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    if ((getDefaultInstance() != null) && (gh.ab().bc())) {
      defaultInstance.bc(paramString, paramLinkedHashMap);
    }
  }
  
  public static void onStreamEvent(int paramInt, String paramString, LinkedHashMap<String, String> paramLinkedHashMap)
  {
    if ((getDefaultInstance() != null) && (gh.ab().bc()))
    {
      if ((paramInt == 1) || (paramInt == 0)) {
        defaultInstance.bc(paramInt, paramString, paramLinkedHashMap);
      }
    }
    else {
      return;
    }
    com.huawei.hianalytics.ab.bc.ef.ab.bc("hmsSdk", "Data type no longer collects range.type: " + paramInt);
  }
  
  public static void setIsOaidTracking(boolean paramBoolean)
  {
    if (getDefaultInstance() != null)
    {
      defaultInstance.ab(1, paramBoolean);
      defaultInstance.ab(0, paramBoolean);
    }
  }
  
  public static void setOAID(String paramString)
  {
    if (getDefaultInstance() != null)
    {
      defaultInstance.bc(1, paramString);
      defaultInstance.bc(0, paramString);
    }
  }
  
  public static void setUPID(String paramString)
  {
    if (getDefaultInstance() != null)
    {
      defaultInstance.ab(1, paramString);
      defaultInstance.ab(0, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.hms.HiAnalytics
 * JD-Core Version:    0.7.0.1
 */