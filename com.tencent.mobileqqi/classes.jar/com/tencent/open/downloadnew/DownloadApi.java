package com.tencent.open.downloadnew;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.business.base.OpenConfig;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantExchangeURLListenner;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKURLTool;
import hqk;
import hql;
import hqm;
import hqn;
import hqo;
import hqp;
import hqq;
import hqr;
import hqs;
import hqt;
import hqu;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadApi
{
  public static final int a = 0;
  protected static ITMAssistantExchangeURLListenner a;
  public static Object a;
  public static final String a;
  public static ConcurrentHashMap a;
  public static final int b = 1;
  public static final String b = "com.tencent.android.qqdownloader";
  public static final int c = 2;
  protected static final String c = "Common_QQ_Patch_Switch";
  public static final int d = 3;
  public static final String d = "100686848";
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 0;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  public static final int k = 0;
  public static final int l = 1;
  public static final int m = 2;
  protected static final int n = 3;
  public static final int o = -10;
  
  static
  {
    jdField_a_of_type_JavaLangString = DownloadApi.class.getName();
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_ComTencentTmassistantsdkDownloadclientITMAssistantExchangeURLListenner = new hqm();
  }
  
  public static int a()
  {
    return 3;
  }
  
  public static int a(Bundle paramBundle, int paramInt, ApkUpdateDetail paramApkUpdateDetail)
  {
    if (paramInt == 1) {
      StaticAnalyz.a("200", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848");
    }
    LogUtility.a(jdField_a_of_type_JavaLangString, "doDownloadActionBySDK pParmas =" + paramBundle);
    String str1 = paramBundle.getString(DownloadConstants.jdField_a_of_type_JavaLangString);
    String str2 = paramBundle.getString(DownloadConstants.i);
    String str3 = paramBundle.getString(DownloadConstants.e);
    int i1 = paramBundle.getInt(DownloadConstants.j);
    String str4 = paramBundle.getString(DownloadConstants.h);
    String str5 = paramBundle.getString(DownloadConstants.k);
    paramBundle.getString(DownloadConstants.l);
    boolean bool1 = paramBundle.getBoolean(DownloadConstants.n);
    boolean bool2 = paramBundle.getBoolean(DownloadConstants.x, true);
    boolean bool3 = paramBundle.getBoolean(DownloadConstants.jdField_g_of_type_JavaLangString, true);
    boolean bool4 = paramBundle.getBoolean(DownloadConstants.w);
    switch (i1)
    {
    }
    for (;;)
    {
      return 0;
      paramBundle = new DownloadInfo(str1, str2.trim(), str3, str5, str4, null, paramInt, bool2);
      paramBundle.l = i1;
      if (bool2)
      {
        paramBundle.a = bool3;
        paramBundle.jdField_b_of_type_Boolean = bool4;
      }
      for (;;)
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "doDownloadAction action == Downloader.ACTION_DOWNLOAD");
        DownloadManager.a().a(paramBundle);
        break;
        paramBundle.a = false;
        paramBundle.jdField_b_of_type_Boolean = true;
        paramBundle.f = 2;
      }
      paramBundle = new DownloadInfo(str1, str2.trim(), str3, str5, str4, null, paramInt, bool2);
      paramBundle.l = i1;
      paramBundle.a = bool3;
      paramBundle.jdField_b_of_type_Boolean = bool4;
      bool2 = OpenConfig.a(CommonDataAdapter.a().a(), null).b("Common_QQ_Patch_Switch");
      if (!bool1) {
        DownloadManager.a().a(paramBundle);
      }
      for (;;)
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "doDownloadAction action == Downloader.ACTION_UPDATE " + bool1);
        break;
        if (bool2) {
          DownloadManager.a().a(paramBundle, paramApkUpdateDetail);
        } else {
          DownloadManager.a().a(paramBundle);
        }
      }
      return DownloadManager.a().a(str1);
      if (bool2)
      {
        StaticAnalyz.a("305", str4, str1);
        DownloadInfo localDownloadInfo = DownloadManager.a().a(str1);
        paramApkUpdateDetail = localDownloadInfo;
        if (localDownloadInfo == null)
        {
          paramApkUpdateDetail = new DownloadInfo();
          paramApkUpdateDetail.jdField_b_of_type_JavaLangString = str1;
          paramApkUpdateDetail.jdField_c_of_type_JavaLangString = str2.trim();
          paramApkUpdateDetail.d = str3;
          paramApkUpdateDetail.e = str5;
          paramApkUpdateDetail.jdField_g_of_type_JavaLangString = str4;
          paramApkUpdateDetail.i = paramBundle.getString(DownloadConstants.jdField_b_of_type_JavaLangString);
          paramApkUpdateDetail.j = paramBundle.getString(DownloadConstants.jdField_c_of_type_JavaLangString);
          paramApkUpdateDetail.jdField_g_of_type_Int = paramBundle.getInt(DownloadConstants.d);
          paramApkUpdateDetail.jdField_c_of_type_Boolean = paramBundle.getBoolean(DownloadConstants.x, true);
        }
        DownloadManager.a().c(paramApkUpdateDetail);
        continue;
        DownloadManager.a().a(str1, null, true);
      }
    }
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle)
  {
    if ((paramBundle == null) || (paramActivity == null)) {
      return;
    }
    ThreadManager.b(new hqn(paramActivity, paramBundle));
  }
  
  public static void a(Activity paramActivity, Bundle paramBundle, int paramInt1, ApkUpdateDetail paramApkUpdateDetail, int paramInt2)
  {
    if (paramInt1 == 1) {
      StaticAnalyz.a("100", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848");
    }
    ThreadManager.b().post(new hqk(paramBundle, paramInt1, paramInt2, paramActivity, paramApkUpdateDetail));
  }
  
  public static void a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    ThreadManager.b(new hqo(paramBundle));
  }
  
  public static void a(DownloadListener paramDownloadListener)
  {
    ThreadManager.b().post(new hqs(paramDownloadListener));
  }
  
  public static void a(String paramString)
  {
    ThreadManager.b().post(new hqr(paramString));
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    ThreadManager.b().post(new hqq(paramString1, paramString2, paramBoolean));
  }
  
  public static void a(List paramList, DownloadQueryListener paramDownloadQueryListener)
  {
    if (paramList == null)
    {
      LogUtility.a(jdField_a_of_type_JavaLangString, "getQueryDownloadAction infos == null");
      return;
    }
    if (paramDownloadQueryListener == null) {
      LogUtility.a(jdField_a_of_type_JavaLangString, "getQueryDownloadAction listener == null");
    }
    ThreadManager.b().post(new hqp(paramList, paramDownloadQueryListener));
  }
  
  public static boolean a(Bundle paramBundle)
  {
    if (paramBundle.getInt(DownloadConstants.j) == 5)
    {
      String str1 = paramBundle.getString(DownloadConstants.jdField_a_of_type_JavaLangString);
      String str2 = paramBundle.getString(DownloadConstants.i);
      String str3 = paramBundle.getString(DownloadConstants.e);
      String str4 = paramBundle.getString(DownloadConstants.h);
      String str5 = paramBundle.getString(DownloadConstants.k);
      StaticAnalyz.a("305", str4, str1);
      DownloadInfo localDownloadInfo2 = DownloadManager.a().a(str1);
      DownloadInfo localDownloadInfo1 = localDownloadInfo2;
      if (localDownloadInfo2 == null)
      {
        localDownloadInfo1 = new DownloadInfo();
        localDownloadInfo1.jdField_b_of_type_JavaLangString = str1;
        localDownloadInfo1.jdField_c_of_type_JavaLangString = str2.trim();
        localDownloadInfo1.d = str3;
        localDownloadInfo1.e = str5;
        localDownloadInfo1.jdField_g_of_type_JavaLangString = str4;
        localDownloadInfo1.i = paramBundle.getString(DownloadConstants.jdField_b_of_type_JavaLangString);
        localDownloadInfo1.j = paramBundle.getString(DownloadConstants.jdField_c_of_type_JavaLangString);
        localDownloadInfo1.jdField_g_of_type_Int = paramBundle.getInt(DownloadConstants.d);
      }
      DownloadManager.a().c(localDownloadInfo1);
      return true;
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    paramString = DownloadManager.a().a(paramString);
    return (paramString != null) && (paramString.h == 1);
  }
  
  public static void b(Activity paramActivity, Bundle paramBundle, int paramInt1, ApkUpdateDetail paramApkUpdateDetail, int paramInt2)
  {
    LogUtility.a(jdField_a_of_type_JavaLangString, "doDownloadActionByMyApp pParmas =" + paramBundle + " myAppConfig = " + paramInt2);
    if (paramInt1 == 1) {
      StaticAnalyz.a("300", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848");
    }
    Object localObject1;
    if (paramBundle.getInt(DownloadConstants.d, -10) < 0)
    {
      ??? = TMAssistantDownloadSDKURLTool.getInstance(jdField_a_of_type_ComTencentTmassistantsdkDownloadclientITMAssistantExchangeURLListenner);
      localObject1 = paramBundle.getString(DownloadConstants.e);
      Object localObject3 = paramBundle.getString(DownloadConstants.A);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        StringBuilder localStringBuilder = new StringBuilder((String)localObject1);
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localStringBuilder.append(";");
          localStringBuilder.append((String)localObject3);
        }
        localObject3 = new ArrayList();
        ((ArrayList)localObject3).add(localStringBuilder.toString());
        ((TMAssistantDownloadSDKURLTool)???).exchangeUrlsFromPackageNames((ArrayList)localObject3);
      }
    }
    label252:
    do
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        try
        {
          jdField_a_of_type_JavaLangObject.wait(5000L);
          if (jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
            break label252;
          }
          localObject1 = (Integer)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject1);
          if (localObject1 == null)
          {
            DownloadManager.a().c(CommonDataAdapter.a().a().getString(2131559995));
            return;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
      paramBundle.putInt(DownloadConstants.d, ((Integer)localObject1).intValue());
      if (paramApkUpdateDetail != null)
      {
        paramBundle.putInt(DownloadConstants.s, paramApkUpdateDetail.patchsize);
        paramBundle.putInt(DownloadConstants.t, paramApkUpdateDetail.newapksize);
      }
      if (paramInt2 == 1)
      {
        paramBundle.putInt("source", paramInt1);
        MyAppApi.a().a(paramActivity, paramBundle, new hqu(paramBundle, paramInt1, paramApkUpdateDetail));
        return;
      }
    } while ((paramInt2 != 2) && (paramInt2 != 0));
    MyAppApi.a().b(paramActivity, paramBundle, new hql(paramBundle, paramInt1, paramApkUpdateDetail));
  }
  
  public static void b(DownloadListener paramDownloadListener)
  {
    ThreadManager.b().post(new hqt(paramDownloadListener));
  }
  
  public static boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!"0".equals(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.downloadnew.DownloadApi
 * JD-Core Version:    0.7.0.1
 */