package com.tencent.common.app;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public abstract class AppInterface
  extends AppRuntime
{
  private Handler a;
  protected BaseApplicationImpl a;
  protected final Map a;
  protected String c = "";
  
  public AppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
    this.c = paramString;
  }
  
  public static void a(PluginRuntime paramPluginRuntime, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    paramPluginRuntime.sendAppDataIncerment(paramString, a(paramString, paramBoolean, paramInt1, paramInt2, paramInt3, paramLong), paramLong);
  }
  
  private static void a(boolean paramBoolean, int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("album_flow", 2, "doPortraitIncreate() isUp = " + paramBoolean);
    }
    if (paramInt1 == 1)
    {
      paramArrayList.add("param_WIFIPicFlow");
      if (paramBoolean)
      {
        paramArrayList.add("param_WIFICardPicUploadFlow");
        return;
      }
      paramArrayList.add("param_WIFICardPicUploadFlow");
      return;
    }
    paramArrayList.add("param_XGPicFlow");
    if (paramBoolean)
    {
      paramArrayList.add("param_XGCardPicUploadFlow");
      return;
    }
    paramArrayList.add("param_XGCardPicDownloadFlow");
  }
  
  private static String[] a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FlowStat", 2, "uin:" + paramString + ",isUp:" + paramBoolean + ",netType:" + paramInt1 + ",fileType:" + paramInt2 + ",busiType:" + paramInt3 + ",flow:" + paramLong);
    }
    paramString = new ArrayList();
    paramString.add("param_Flow");
    if (paramInt1 == 1)
    {
      paramString.add("param_WIFIFlow");
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      return (String[])paramString.toArray(new String[0]);
      paramString.add("param_XGFlow");
      break;
      b(paramBoolean, paramInt1, paramInt3, paramString);
      continue;
      a(paramBoolean, paramInt1, paramInt3, paramString);
      continue;
      c(paramBoolean, paramInt1, paramInt3, paramString);
      continue;
      d(paramBoolean, paramInt1, paramInt3, paramString);
      continue;
      if (paramInt1 == 1)
      {
        paramString.add("param_WIFIUniformDLDownloadFlow");
      }
      else
      {
        paramString.add("param_XGUniformDLDownloadFlow");
        continue;
        if (paramInt1 == 1)
        {
          paramString.add("param_WIFIThemeDownloadFlow");
        }
        else
        {
          paramString.add("param_XGThemeDownloadFlow");
          continue;
          if (paramInt1 == 1)
          {
            paramString.add("param_WIFIAvatarPicDownloadFlow");
          }
          else
          {
            paramString.add("param_XGAvatarPicDownloadFlow");
            continue;
            if (paramInt1 == 1) {
              paramString.add("param_WIFICircleDownloadFlow");
            } else {
              paramString.add("param_XGCircleDownloadFlow");
            }
          }
        }
      }
    }
  }
  
  private static void b(boolean paramBoolean, int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    if (paramInt1 == 1)
    {
      paramArrayList.add("param_WIFIPicFlow");
      if (paramBoolean) {
        if (paramInt2 == 0) {
          paramArrayList.add("param_WIFIC2CPicUploadFlow");
        }
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((paramInt2 == 1) || (paramInt2 == 3000))
            {
              paramArrayList.add("param_WIFIGroupPicUploadFlow");
              return;
            }
          } while ((paramInt2 != 1001) && (paramInt2 != 1003));
          paramArrayList.add("param_WIFINearbyPicUploadFlow");
          return;
          if (paramInt2 == 0)
          {
            paramArrayList.add("param_WIFIC2CPicDownloadFlow");
            return;
          }
          if ((paramInt2 == 1) || (paramInt2 == 3000))
          {
            paramArrayList.add("param_WIFIGroupPicDownloadFlow");
            return;
          }
        } while ((paramInt2 != 1001) && (paramInt2 != 1003));
        paramArrayList.add("param_WIFINearbyPicDownloadFlow");
        return;
        paramArrayList.add("param_XGPicFlow");
        if (!paramBoolean) {
          break;
        }
        if (paramInt2 == 0)
        {
          paramArrayList.add("param_XGC2CPicUploadFlow");
          return;
        }
        if ((paramInt2 == 1) || (paramInt2 == 3000))
        {
          paramArrayList.add("param_XGGroupPicUploadFlow");
          return;
        }
      } while ((paramInt2 != 1001) && (paramInt2 != 1003));
      paramArrayList.add("param_XGNearbyPicUploadFlow");
      return;
      if (paramInt2 == 0)
      {
        paramArrayList.add("param_XGC2CPicDownloadFlow");
        return;
      }
      if ((paramInt2 == 1) || (paramInt2 == 3000))
      {
        paramArrayList.add("param_XGGroupPicDownloadFlow");
        return;
      }
    } while ((paramInt2 != 1001) && (paramInt2 != 1003));
    paramArrayList.add("param_XGNearbyPicDownloadFlow");
  }
  
  private static void c(boolean paramBoolean, int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    if (paramInt1 == 1)
    {
      paramArrayList.add("param_WIFIVoiceFlow");
      return;
    }
    paramArrayList.add("param_XGVoiceFlow");
  }
  
  private static void d(boolean paramBoolean, int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    if (paramInt1 == 1)
    {
      paramArrayList.add("param_WIFIFileFlow");
      return;
    }
    paramArrayList.add("param_XGFileFlow");
  }
  
  public abstract int a();
  
  public Handler a(Class paramClass)
  {
    if (this.jdField_a_of_type_JavaUtilMap.get(paramClass) != null) {
      return (Handler)this.jdField_a_of_type_JavaUtilMap.get(paramClass);
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public abstract EntityManagerFactory a(String paramString);
  
  public abstract BaseApplication a();
  
  public abstract String a();
  
  public void a(Class paramClass)
  {
    this.jdField_a_of_type_JavaUtilMap.remove(paramClass);
  }
  
  public void a(Class paramClass, Handler paramHandler)
  {
    this.jdField_a_of_type_JavaUtilMap.put(paramClass, paramHandler);
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    a(paramString, a(paramString, paramBoolean, paramInt1, paramInt2, paramInt3, paramLong), paramLong);
  }
  
  public void a(String paramString, String[] paramArrayOfString, long paramLong)
  {
    if (paramArrayOfString != null)
    {
      if (!BaseActivity.q)
      {
        String[] arrayOfString = new String[paramArrayOfString.length];
        int i = 0;
        while (i < paramArrayOfString.length)
        {
          arrayOfString[i] = (paramArrayOfString[i] + "_bg");
          i += 1;
        }
        sendAppDataIncermentMsg(paramString, arrayOfString, paramLong);
      }
    }
    else {
      return;
    }
    sendAppDataIncermentMsg(paramString, paramArrayOfString, paramLong);
  }
  
  public String d()
  {
    return "";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    SecurityUtile.a(getApplication());
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.common.app.AppInterface
 * JD-Core Version:    0.7.0.1
 */