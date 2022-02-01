package com.tencent.qmsp.sdk.g.f;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.qmsp.sdk.base.c;

public class b
{
  private static final Uri a = Uri.parse("content://cn.nubia.identity/identity");
  
  public static String a(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = null;
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 17)
        {
          localObject = paramContext.getContentResolver().acquireUnstableContentProviderClient(a);
          paramString = ((ContentProviderClient)localObject).call("getAAID", paramString, null);
          paramContext = paramString;
          if (localObject != null)
          {
            if (Build.VERSION.SDK_INT >= 24)
            {
              ((ContentProviderClient)localObject).close();
              paramContext = paramString;
            }
          }
          else
          {
            int i = paramContext.getInt("code", -1);
            if (i != 0) {
              break label151;
            }
            paramString = paramContext.getString("id");
            paramContext = paramString;
          }
        }
      }
      catch (Exception paramString)
      {
        paramContext = localStringBuilder;
      }
      try
      {
        localStringBuilder = new StringBuilder();
        paramContext = paramString;
        localStringBuilder = localStringBuilder.append("NubiaLog succeed:").append(paramString);
        paramContext = paramString;
        c.c(localStringBuilder.toString());
        return paramString;
      }
      catch (Exception paramString)
      {
        break label121;
      }
      ((ContentProviderClient)localObject).release();
      paramContext = paramString;
      continue;
      label121:
      paramString.printStackTrace();
      return paramContext;
      paramContext = paramContext.getContentResolver();
      Object localObject = a;
      paramContext = paramContext.call((Uri)localObject, "getAAID", paramString, null);
      continue;
      label151:
      paramString = paramContext.getString("message");
      paramContext = paramString;
      localStringBuilder = new StringBuilder();
      paramContext = paramString;
      localStringBuilder = localStringBuilder.append("NubiaLog failed:").append(paramString);
    }
  }
  
  public static boolean a(Context paramContext)
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 17)
        {
          ContentProviderClient localContentProviderClient = paramContext.getContentResolver().acquireUnstableContentProviderClient(a);
          localObject = localContentProviderClient.call("isSupport", null, null);
          paramContext = (Context)localObject;
          if (localContentProviderClient != null)
          {
            if (Build.VERSION.SDK_INT >= 24)
            {
              localContentProviderClient.close();
              paramContext = (Context)localObject;
            }
          }
          else
          {
            int i = paramContext.getInt("code", -1);
            if (i != 0) {
              break;
            }
            c.c("NubiaLog succeed");
            return paramContext.getBoolean("issupport", true);
          }
          localContentProviderClient.release();
          paramContext = (Context)localObject;
          continue;
        }
        paramContext = paramContext.getContentResolver();
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return false;
      }
      localObject = a;
      paramContext = paramContext.call((Uri)localObject, "isSupport", null, null);
    }
    paramContext = paramContext.getString("message");
    Object localObject = new StringBuilder();
    c.c("NubiaLog failed:" + paramContext);
    return false;
  }
  
  public static String b(Context paramContext)
  {
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT >= 17)
        {
          localContentProviderClient = paramContext.getContentResolver().acquireUnstableContentProviderClient(a);
          localObject2 = localContentProviderClient.call("getOAID", null, null);
          paramContext = (Context)localObject2;
          if (localContentProviderClient != null)
          {
            if (Build.VERSION.SDK_INT >= 24)
            {
              localContentProviderClient.close();
              paramContext = (Context)localObject2;
            }
          }
          else
          {
            int i = paramContext.getInt("code", -1);
            if (i != 0) {
              break label153;
            }
            paramContext = paramContext.getString("id");
            localObject1 = paramContext;
            paramContext = (Context)localObject1;
          }
        }
      }
      catch (Exception localException2)
      {
        ContentProviderClient localContentProviderClient;
        Object localObject2;
        paramContext = (Context)localObject1;
        localObject1 = localException2;
      }
      try
      {
        localObject2 = new StringBuilder();
        paramContext = (Context)localObject1;
        localObject2 = ((StringBuilder)localObject2).append("NubiaLog succeed:").append((String)localObject1);
        paramContext = (Context)localObject1;
        c.c(((StringBuilder)localObject2).toString());
        return localObject1;
      }
      catch (Exception localException1)
      {
        Object localObject3;
        break label125;
      }
      localContentProviderClient.release();
      paramContext = (Context)localObject2;
      continue;
      label125:
      ((Exception)localObject1).printStackTrace();
      return paramContext;
      paramContext = paramContext.getContentResolver();
      localObject3 = a;
      paramContext = paramContext.call((Uri)localObject3, "getOAID", null, null);
      continue;
      label153:
      paramContext = paramContext.getString("message");
      localObject1 = paramContext;
      paramContext = (Context)localObject1;
      localObject3 = new StringBuilder();
      paramContext = (Context)localObject1;
      localObject3 = ((StringBuilder)localObject3).append("NubiaLog failed:").append((String)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qmsp.sdk.g.f.b
 * JD-Core Version:    0.7.0.1
 */