package com.qzone.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.qzone.common.logging.QDLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils
{
  private static final Pattern domainPattern = Pattern.compile("[^//]*?\\.(com|cn|net)", 2);
  
  public static Object convertToObject(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = new ByteArrayInputStream(Base64.decode(paramString.getBytes(), 0));
    try
    {
      paramString = new ObjectInputStream(paramString);
      if (paramString != null) {}
      label46:
      label57:
      label68:
      return null;
    }
    catch (StreamCorruptedException paramString)
    {
      try
      {
        paramString = paramString.readObject();
        return paramString;
      }
      catch (Throwable paramString)
      {
        break label68;
      }
      catch (IOException paramString)
      {
        break label57;
      }
      catch (StreamCorruptedException paramString)
      {
        break label46;
      }
      paramString = paramString;
      QDLog.e("http", "convertToObject exception", paramString);
      return null;
    }
    catch (IOException paramString)
    {
      QDLog.e("http", "convertToObject exception", paramString);
      return null;
    }
    catch (Throwable paramString)
    {
      QDLog.e("http", "convertToObject exception", paramString);
      return null;
    }
  }
  
  public static String convertToString(Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return null;
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      try
      {
        ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
        if (localObjectOutputStream != null)
        {
          localObjectOutputStream.writeObject(paramObject);
          paramObject = new String(Base64.encode(localByteArrayOutputStream.toByteArray(), 0));
          return paramObject;
        }
      }
      catch (Throwable paramObject)
      {
        QDLog.e("http", "convertToString exception", paramObject);
      }
    }
    return null;
  }
  
  public static int count(String paramString, char paramChar)
  {
    int k;
    if (paramString == null)
    {
      k = 0;
      return k;
    }
    int m = paramString.length();
    int i = 0;
    int j = 0;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      k = i;
      if (paramChar == paramString.charAt(j)) {
        k = i + 1;
      }
      j += 1;
      i = k;
    }
  }
  
  public static String getCurrentProcessName(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return null;
      int i = Process.myPid();
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (paramContext != null) {
        try
        {
          paramContext = paramContext.getRunningAppProcesses();
          if ((paramContext != null) && (paramContext.size() > 0))
          {
            paramContext = paramContext.iterator();
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
            do
            {
              if (!paramContext.hasNext()) {
                break;
              }
              localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
            } while (localRunningAppProcessInfo.pid != i);
            paramContext = localRunningAppProcessInfo.processName;
            return paramContext;
          }
        }
        catch (Throwable paramContext) {}
      }
    }
    return null;
  }
  
  public static String getDomin(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    Object localObject;
    for (;;)
    {
      return paramString;
      localObject = null;
      try
      {
        String str = new URL(paramString).getAuthority();
        paramString = str;
        localObject = str;
        if (!TextUtils.isEmpty(str))
        {
          localObject = str;
          int i = str.indexOf(":");
          paramString = str;
          if (i >= 0)
          {
            paramString = str;
            localObject = str;
            if (i < str.length())
            {
              localObject = str;
              paramString = str.substring(0, i);
              return paramString;
            }
          }
        }
      }
      catch (Throwable paramString)
      {
        QDLog.e("http", "getDomin exception", paramString);
      }
    }
    return localObject;
  }
  
  public static String getDominWithPort(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new URL(paramString).getAuthority();
      return paramString;
    }
    catch (Throwable paramString)
    {
      QDLog.e("http", "getDominWithPort exception", paramString);
    }
    return null;
  }
  
  public static int getPort(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return -1;
      try
      {
        paramString = new URL(paramString).getAuthority();
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        int i = paramString.indexOf(":");
        if (i < 0) {
          continue;
        }
        int j = paramString.length();
        if (i >= j) {
          continue;
        }
        try
        {
          i = Integer.valueOf(paramString.substring(i + 1)).intValue();
          return i;
        }
        catch (Exception paramString)
        {
          QDLog.e("http", "getPort exception", paramString);
          return -1;
        }
        return -1;
      }
      catch (Throwable paramString)
      {
        QDLog.e("http", "getPort exception", paramString);
      }
    }
  }
  
  public static boolean isPortValid(int paramInt)
  {
    return (paramInt > 0) && (paramInt <= 65535);
  }
  
  public static boolean match(Pattern paramPattern, String paramString)
  {
    if ((paramPattern == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    try
    {
      boolean bool = paramPattern.matcher(paramString).matches();
      return bool;
    }
    catch (Throwable paramPattern)
    {
      QDLog.e("http", "match exception", paramPattern);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.qzone.utils.Utils
 * JD-Core Version:    0.7.0.1
 */