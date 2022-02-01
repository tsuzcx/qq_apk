package com.tencent.mobileqq.mini.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;

public class DebugUtil
{
  public static boolean getDebugEnabled(MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppInfo == null) {
      return false;
    }
    return StorageUtil.getPreference().getBoolean(paramMiniAppInfo.appId + "_debug", false);
  }
  
  public static String getPrintableStackTrace(Throwable paramThrowable)
  {
    return getPrintableStackTrace(paramThrowable, false);
  }
  
  private static String getPrintableStackTrace(Throwable paramThrowable, boolean paramBoolean)
  {
    if (paramThrowable == null) {
      return "";
    }
    Object localObject1 = Thread.currentThread();
    StringBuilder localStringBuilder = new StringBuilder();
    if (!paramBoolean)
    {
      localStringBuilder.append("Exception in thread \"");
      localStringBuilder.append(((Thread)localObject1).getName());
      localStringBuilder.append("\"");
      localStringBuilder.append(paramThrowable.toString());
    }
    localObject1 = paramThrowable.getStackTrace();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      localStringBuilder.append("\tat ");
      localStringBuilder.append(localObject2);
      localStringBuilder.append("\n");
      i += 1;
    }
    if ((paramThrowable instanceof InvocationTargetException)) {}
    for (paramThrowable = ((InvocationTargetException)paramThrowable).getTargetException();; paramThrowable = paramThrowable.getCause())
    {
      if (paramThrowable != null)
      {
        localStringBuilder.append("caused by: ");
        localStringBuilder.append(paramThrowable.toString());
        localStringBuilder.append("\n");
        localStringBuilder.append(getPrintableStackTrace(paramThrowable, true));
      }
      return localStringBuilder.toString();
    }
  }
  
  public static String getStackTrace()
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    StringWriter localStringWriter = new StringWriter();
    int j = arrayOfStackTraceElement.length;
    int i = 0;
    while (i < j)
    {
      localStringWriter.write(arrayOfStackTraceElement[i].toString());
      localStringWriter.write("\n");
      i += 1;
    }
    localStringWriter.flush();
    return localStringWriter.toString();
  }
  
  public static void setDebugEnabled(MiniAppInfo paramMiniAppInfo, boolean paramBoolean)
  {
    if (paramMiniAppInfo != null) {
      StorageUtil.getPreference().edit().putBoolean(paramMiniAppInfo.appId + "_debug", paramBoolean).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.DebugUtil
 * JD-Core Version:    0.7.0.1
 */