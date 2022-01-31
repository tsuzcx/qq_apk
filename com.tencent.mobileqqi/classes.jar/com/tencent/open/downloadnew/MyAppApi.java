package com.tencent.open.downloadnew;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.TicketUtils;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.openSDK.BaseQQDownloaderOpenSDK;
import com.tencent.tmassistantsdk.openSDK.ITMQQDownloaderOpenSDKListener;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK_V2;
import hrs;
import hrt;
import hru;
import hrx;
import hry;
import hrz;
import hsa;
import hsb;
import hsc;
import hsd;
import hsh;
import hsk;
import mqq.app.AppActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class MyAppApi
{
  protected static final int a = 3;
  protected static MyAppApi a;
  protected static final String a = "MyAppApi";
  protected long a;
  protected DialogInterface.OnClickListener a;
  public MyAppApi.InstallParams a;
  protected MyAppApi.YYBDownloadListener a;
  public MyAppDialog a;
  public BaseQQDownloaderOpenSDK a;
  protected ITMQQDownloaderOpenSDKListener a;
  public TMQQDownloaderOpenSDKParam a;
  protected boolean a;
  protected long b;
  TMQQDownloaderOpenSDKParam b;
  public String b;
  protected boolean b;
  protected final long c;
  public boolean c;
  public long d;
  boolean d;
  public boolean e = false;
  
  protected MyAppApi()
  {
    this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKITMQQDownloaderOpenSDKListener = new MyAppApi.QQDownloadListener(this);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Long = -1L;
    this.jdField_c_of_type_Long = 180000L;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener = null;
    try
    {
      a();
      d();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        LogUtility.c("MyAppApi", "MyAppApi init>>>", localThrowable);
      }
    }
  }
  
  public static MyAppApi a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi == null) {
        jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi = new MyAppApi();
      }
      MyAppApi localMyAppApi = jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi;
      return localMyAppApi;
    }
    finally {}
  }
  
  /* Error */
  public static boolean d()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 76	com/tencent/open/downloadnew/MyAppApi:jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi	Lcom/tencent/open/downloadnew/MyAppApi;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +10 -> 18
    //   11: iconst_1
    //   12: istore_0
    //   13: ldc 2
    //   15: monitorexit
    //   16: iload_0
    //   17: ireturn
    //   18: iconst_0
    //   19: istore_0
    //   20: goto -7 -> 13
    //   23: astore_1
    //   24: ldc 2
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	8	0	bool	boolean
    //   6	2	1	localMyAppApi	MyAppApi
    //   23	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	23	finally
  }
  
  public int a()
  {
    return TMQQDownloaderOpenSDK.getQQDownloadApiLevel(CommonDataAdapter.a().a());
  }
  
  public int a(Bundle paramBundle)
  {
    int j = 1;
    int i = j;
    if (paramBundle != null)
    {
      i = j;
      if (paramBundle.getInt(DownloadConstants.j) == 3) {
        i = 2;
      }
    }
    return i;
  }
  
  public long a(Bundle paramBundle)
  {
    LogUtility.c("MyAppApi", "--addDownloadTaskFromAppDetail--params = " + paramBundle);
    if (paramBundle == null) {
      return -1L;
    }
    paramBundle = paramBundle.getString("url");
    b();
    return this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK.addDownloadTaskFromWebview(paramBundle);
  }
  
  protected long a(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    LogUtility.c("MyAppApi", "--addDownloadTaskFromTaskList--params = " + paramBundle + "autoDownload = " + paramBoolean1);
    if (paramBundle == null) {
      return -1L;
    }
    paramBundle = a(paramBundle);
    this.jdField_b_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam = paramBundle;
    b();
    return this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK.addDownloadTaskFromTaskList(paramBundle, paramBoolean1, paramBoolean1);
  }
  
  public DownloadInfo a(TMQQDownloaderOpenSDKParam paramTMQQDownloaderOpenSDKParam, Bundle paramBundle)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.h = 1;
    localDownloadInfo.jdField_b_of_type_JavaLangString = paramTMQQDownloaderOpenSDKParam.SNGAppId;
    localDownloadInfo.i = paramTMQQDownloaderOpenSDKParam.taskAppId;
    localDownloadInfo.d = paramTMQQDownloaderOpenSDKParam.taskPackageName;
    localDownloadInfo.j = paramTMQQDownloaderOpenSDKParam.taskApkId;
    localDownloadInfo.jdField_g_of_type_Int = paramTMQQDownloaderOpenSDKParam.taskVersion;
    if (paramBundle != null)
    {
      localDownloadInfo.jdField_g_of_type_JavaLangString = paramBundle.getString(DownloadConstants.h);
      localDownloadInfo.e = paramBundle.getString(DownloadConstants.k);
    }
    return localDownloadInfo;
  }
  
  public TMAssistantDownloadTaskInfo a(Bundle paramBundle)
  {
    if ((paramBundle == null) || (!b())) {
      return null;
    }
    paramBundle = a(paramBundle);
    c();
    if (a() <= 2) {
      return ((TMQQDownloaderOpenSDK)this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK).getDownloadTaskState(paramBundle);
    }
    return ((TMQQDownloaderOpenSDK_V2)this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK).getDownloadTaskState(paramBundle);
  }
  
  protected TMQQDownloaderOpenSDKParam a(Bundle paramBundle)
  {
    String str3 = paramBundle.getString(DownloadConstants.a);
    String str4 = paramBundle.getString(DownloadConstants.jdField_b_of_type_JavaLangString);
    String str5 = paramBundle.getString(DownloadConstants.c);
    String str6 = paramBundle.getString(DownloadConstants.e);
    Object localObject1 = paramBundle.getString(DownloadConstants.h);
    int i = paramBundle.getInt(DownloadConstants.d);
    String str1;
    Object localObject3;
    Object localObject2;
    int j;
    if (this.jdField_a_of_type_Boolean)
    {
      str1 = StaticAnalyz.a((String)localObject1, "NEWYYB");
      localObject3 = paramBundle.getString(DownloadConstants.u);
      localObject1 = paramBundle.getString(DownloadConstants.v);
      localObject2 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject2 = Long.valueOf(CommonDataAdapter.a().a()).toString();
      }
      localObject3 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject3 = "qqNumber";
      }
      paramBundle.getString(DownloadConstants.y);
      localObject1 = paramBundle.getString(DownloadConstants.A);
      j = paramBundle.getInt(DownloadConstants.z);
      if (j != 1) {
        break label233;
      }
      paramBundle = "ANDROIDQQ-gray";
      localObject1 = "1";
    }
    for (;;)
    {
      LogUtility.b("State_Log", " channelId:" + paramBundle);
      return new TMQQDownloaderOpenSDKParam(str3, str4, str5, i, str1, str6, (String)localObject2, (String)localObject3, paramBundle, (String)localObject1);
      str1 = StaticAnalyz.a((String)localObject1, "YYB");
      break;
      label233:
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        paramBundle = "ANDROIDQQ";
        localObject1 = j + "";
      }
      else
      {
        String str2 = j + "";
        paramBundle = (Bundle)localObject1;
        localObject1 = str2;
      }
    }
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams != null) && (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle != null)) {
      return this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle.getString(DownloadConstants.a);
    }
    return "";
  }
  
  protected void a()
  {
    if (a() <= 2) {}
    for (this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK = TMQQDownloaderOpenSDK.getInstance();; this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK = TMQQDownloaderOpenSDK_V2.getInstance())
    {
      this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK.initQQDownloaderOpenSDK(CommonDataAdapter.a().a());
      g();
      return;
    }
  }
  
  public void a(Activity paramActivity)
  {
    ThreadManager.b().post(new hry(this, paramActivity));
  }
  
  protected void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener, int paramInt3, boolean paramBoolean, String paramString2)
  {
    LogUtility.c("TIME-STATISTIC", "MyAppApi--showTipDialog");
    LogUtility.c("MyAppApi", "-showTipDialog-");
    if (paramActivity == null) {
      return;
    }
    Resources localResources = paramActivity.getResources();
    String str;
    label56:
    Object localObject;
    if (paramInt2 == 1) {
      if (paramInt1 == 2)
      {
        paramInt1 = 1;
        if (!TextUtils.isEmpty(paramString2)) {
          break label324;
        }
        str = ControlPolicyUtil.a(paramInt1, paramInt3);
        localObject = str;
        if (TextUtils.isEmpty(str)) {}
        switch (paramInt1)
        {
        default: 
          localObject = localResources.getString(2131560004);
          label110:
          if (((paramInt1 != 2) && (paramInt1 != 4)) || (!TextUtils.isEmpty(paramString2))) {
            break;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramString1 = String.format((String)localObject, new Object[] { paramString1 });
        paramString2 = localResources.getString(2131560000);
        localObject = new MyAppDialog(paramActivity);
        ((MyAppDialog)localObject).b(2131560001, paramOnClickListener2, true);
        if (!paramBoolean)
        {
          paramBoolean = true;
          ((MyAppDialog)localObject).a(2131560002, paramOnClickListener1, paramBoolean);
          ((MyAppDialog)localObject).a(paramString2);
          ((MyAppDialog)localObject).b(paramString1);
          ((MyAppDialog)localObject).setCancelable(true);
          ((MyAppDialog)localObject).setOnCancelListener(paramOnCancelListener);
          ((MyAppDialog)localObject).setOnDismissListener(new hsk(this));
          if ((!(paramActivity instanceof AppActivity)) || (((AppActivity)paramActivity).isResume())) {
            continue;
          }
          LogUtility.c("TIME-STATISTIC", "MyAppApi--showTipDialog---cancel !isResume");
          return;
          if ((paramInt1 == 12) && (!TextUtils.isEmpty(paramString1)))
          {
            paramInt1 = 2;
            break;
          }
          paramInt1 = 1;
          break;
          if (paramInt1 == 2)
          {
            paramInt1 = 3;
            break;
          }
          if ((paramInt1 == 12) && (!TextUtils.isEmpty(paramString1)))
          {
            paramInt1 = 4;
            break;
          }
          paramInt1 = 3;
          break;
          label324:
          str = paramString2;
          break label56;
          localObject = localResources.getString(2131560004);
          break label110;
          localObject = localResources.getString(2131560005, new Object[] { paramString1 });
          break label110;
          localObject = localResources.getString(2131560006);
          break label110;
          localObject = localResources.getString(2131560007, new Object[] { paramString1 });
        }
      }
      catch (Exception paramString2)
      {
        if (paramInt1 == 2)
        {
          paramString1 = localResources.getString(2131560004);
          LogUtility.c("MyAppApi", " errorMsg = " + paramString2.getMessage());
          continue;
        }
        paramString1 = localResources.getString(2131560006);
        continue;
        paramBoolean = false;
        continue;
        if (!paramActivity.isFinishing()) {
          ((MyAppDialog)localObject).show();
        }
        LogUtility.c("TIME-STATISTIC", "MyAppApi--showTipDialog---complete");
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog = ((MyAppDialog)localObject);
        return;
      }
      paramString1 = (String)localObject;
    }
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    LogUtility.c("TIME-STATISTIC", "MyAppApi--handleDownloadAction");
    c();
    int i = this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK.checkQQDownloaderInstalled();
    boolean bool2 = paramBundle.getBoolean(DownloadConstants.f, false);
    boolean bool3 = paramBundle.getBoolean(DownloadConstants.jdField_g_of_type_JavaLangString, true);
    int k = paramBundle.getInt(DownloadConstants.m);
    int j = paramBundle.getInt(DownloadConstants.j);
    String str2 = paramBundle.getString(DownloadConstants.h);
    String str1 = paramBundle.getString(DownloadConstants.a);
    int m = paramBundle.getInt(DownloadConstants.s, 0);
    int n = paramBundle.getInt(DownloadConstants.t, 0);
    boolean bool4 = ControlPolicyUtil.c();
    boolean bool5 = ControlPolicyUtil.e();
    LogUtility.c("OpenConfig-MyAppApi", " useMyAppFlag = " + bool4);
    Object localObject1 = DownloadManager.a().a(str1);
    boolean bool1;
    if ((localObject1 != null) && (((DownloadInfo)localObject1).h == 1))
    {
      bool1 = true;
      if (((bool4) && (bool5)) || (bool1)) {
        break label254;
      }
      if (paramOnClickListener != null)
      {
        LogUtility.a("MyAppApi", "allowMyApp=" + bool4 + " allowMyAppDownload=" + bool5 + " taskExist=" + bool1);
        paramOnClickListener.onClick(null, 0);
      }
      StaticAnalyz.a("200", str2, str1);
    }
    for (;;)
    {
      return;
      bool1 = false;
      break;
      label254:
      if ((i == 2) || (i == 1)) {
        if ((this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog != null) && (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing())) {
          if (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a() == paramActivity)
          {
            LogUtility.a("MyAppApi", "tipDialog is showing return");
            return;
          }
        }
      }
      try
      {
        this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.dismiss();
        label310:
        for (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog = null; (!ControlPolicyUtil.d()) || ((j != 2) && (j != 12)); this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog = null)
        {
          LogUtility.a("MyAppApi", "not allowShowDialog return actionCode = " + j);
          if (paramOnClickListener != null) {
            paramOnClickListener.onClick(null, 0);
          }
          StaticAnalyz.a("200", str2, str1);
          return;
        }
        ThreadManager.b().post(new hsa(this, str2, str1));
        bool4 = ControlPolicyUtil.a();
        hsb localhsb = new hsb(this, bool2, bool3, paramOnClickListener, paramBundle, k, bool4, paramActivity, str2, bool1, str1);
        MyAppApi.ClickListenerProxy localClickListenerProxy = new MyAppApi.ClickListenerProxy(this, paramOnClickListener, str2, str1);
        MyAppApi.BackListener localBackListener = new MyAppApi.BackListener(this, str2, str1);
        Object localObject2 = null;
        localObject1 = localObject2;
        if (n > 0)
        {
          localObject1 = localObject2;
          if (m > 0)
          {
            k = n - m;
            localObject1 = localObject2;
            if (k > 0) {
              localObject1 = YybHandleUtil.a(k);
            }
          }
        }
        a(paramActivity, j, i, (String)localObject1, localhsb, localClickListenerProxy, localBackListener, paramBundle.getInt("source"), bool4, paramBundle.getString(DownloadConstants.o));
        ThreadManager.b().post(new hsc(this, str2, str1));
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = paramOnClickListener;
        return;
        if (i != 0) {
          continue;
        }
        if ((ControlPolicyUtil.f()) || (bool1))
        {
          if (k == 0) {
            a(paramActivity, paramBundle, bool2, bool3);
          }
          for (;;)
          {
            paramActivity = StaticAnalyz.a(str2, "YYB");
            if ((localObject1 != null) || ((j != 2) && (j != 12))) {
              break;
            }
            StaticAnalyz.a("202", paramActivity, str1);
            return;
            a(paramActivity, paramBundle, bool2, bool3);
          }
          StaticAnalyz.a("200", paramActivity, str1);
          return;
        }
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(null, 0);
        }
        StaticAnalyz.a("200", str2, str1);
        return;
      }
      catch (Exception localException)
      {
        break label310;
      }
    }
  }
  
  public void a(Activity paramActivity, String paramString)
  {
    LogUtility.c("MyAppApi", "downloadYyb");
    if (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener == null) {
      this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener = new MyAppApi.YYBDownloadListener(this);
    }
    DownloadManager.a().a(this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$YYBDownloadListener);
    DownloadInfo localDownloadInfo = DownloadManager.a().a("1101070898");
    if (localDownloadInfo != null) {
      DownloadManager.a().a(localDownloadInfo);
    }
    do
    {
      return;
      a(paramActivity, "http://softfile.3g.qq.com/msoft/allen/qq_com.tencent.android.qqdownloader.apk", paramString);
    } while ((this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog == null) || (!this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.isShowing()));
    this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppDialog.a(0, 1);
  }
  
  protected void a(Activity paramActivity, String paramString1, String paramString2)
  {
    LogUtility.c("MyAppApi", "startDownloadYyb");
    Bundle localBundle = new Bundle();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "http://softfile.3g.qq.com/msoft/allen/qq_com.tencent.android.qqdownloader.apk";
    }
    localBundle.putString(DownloadConstants.a, "1101070898");
    localBundle.putString(DownloadConstants.i, str);
    localBundle.putString(DownloadConstants.e, "com.tencent.android.qqdownloader");
    localBundle.putInt(DownloadConstants.j, 2);
    localBundle.putString(DownloadConstants.h, paramString2);
    localBundle.putString(DownloadConstants.k, "应用宝");
    localBundle.putBoolean(DownloadConstants.w, false);
    localBundle.putString(DownloadConstants.l, "yyb");
    localBundle.putString(DownloadConstants.jdField_b_of_type_JavaLangString, "5848");
    localBundle.putBoolean(DownloadConstants.f, true);
    localBundle.putBoolean(DownloadConstants.jdField_g_of_type_JavaLangString, false);
    localBundle.putInt(DownloadConstants.m, 1);
    DownloadApi.a(paramActivity, localBundle, 0, null, 0);
  }
  
  public void a(Context paramContext, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    LogUtility.c("TIME-STATISTIC", "MyAppApi--startToDownloadTaskList");
    if ((paramBundle == null) || (paramContext == null)) {
      return;
    }
    TMQQDownloaderOpenSDKParam localTMQQDownloaderOpenSDKParam = a(paramBundle);
    boolean bool = ControlPolicyUtil.b();
    long l = CommonDataAdapter.a().a();
    int i;
    if ((bool) && (l > 0L) && (l != this.jdField_d_of_type_Long)) {
      i = 1;
    }
    Object localObject;
    label281:
    int j;
    while ((i == 0) || (paramContext == null) || (!(paramContext instanceof BaseActivity)))
    {
      localObject = a(localTMQQDownloaderOpenSDKParam, paramBundle);
      DownloadManager.a().e((DownloadInfo)localObject);
      try
      {
        LogUtility.a("State_Log", "OpenSDK startToDownloadTaskList param SNGAppId=" + localTMQQDownloaderOpenSDKParam.SNGAppId + " apkId=" + localTMQQDownloaderOpenSDKParam.taskApkId + " taskAppId=" + localTMQQDownloaderOpenSDKParam.taskAppId + " packageName=" + localTMQQDownloaderOpenSDKParam.taskPackageName + " version=" + localTMQQDownloaderOpenSDKParam.taskVersion + " uin=" + localTMQQDownloaderOpenSDKParam.uin + " via=" + localTMQQDownloaderOpenSDKParam.via);
        LogUtility.c("TIME-STATISTIC", "downloadSdk.startToDownloadTaskList");
        c();
        if (a() > 2) {
          break label281;
        }
        ((TMQQDownloaderOpenSDK)this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK).startToDownloadTaskList(paramContext, localTMQQDownloaderOpenSDKParam, paramBoolean1, paramBoolean2);
        return;
      }
      catch (Exception paramContext)
      {
        LogUtility.e("MyAppApi", "--startToDownloadTaskList--Exception = " + paramContext);
        return;
      }
      i = 0;
      continue;
      i = paramBundle.getInt(DownloadConstants.j);
      j = a(paramBundle);
      if (i != 3) {
        break label386;
      }
      paramBoolean1 = false;
      paramBoolean2 = false;
    }
    label386:
    for (;;)
    {
      ((TMQQDownloaderOpenSDK_V2)this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK).startToDownloadTaskList(paramContext, localTMQQDownloaderOpenSDKParam, paramBoolean1, paramBoolean2, j);
      return;
      localObject = new TicketUtils();
      ((TicketUtils)localObject).a(new hsh(this, (TicketUtils)localObject, localTMQQDownloaderOpenSDKParam, paramBundle, l, paramContext, paramBoolean1, paramBoolean2));
      if (!(paramContext instanceof BaseActivity)) {
        break;
      }
      ((TicketUtils)localObject).a(((BaseActivity)paramContext).getAppRuntime(), 710020706L, "com.tencent.android.qqdownloader");
      return;
    }
  }
  
  public void a(String paramString, Activity paramActivity)
  {
    ThreadManager.b().post(new hrt(this, paramString, paramActivity));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.jdField_d_of_type_Boolean = paramBoolean;
      this.jdField_b_of_type_JavaLangString = paramString;
    } while (!this.jdField_d_of_type_Boolean);
    SharedPreferences.Editor localEditor = CommonDataAdapter.a().a().getSharedPreferences("showTost_pf", 0).edit();
    localEditor.putBoolean("showToast", this.jdField_d_of_type_Boolean);
    localEditor.putString("toast_msg", paramString);
    localEditor.commit();
  }
  
  protected boolean a()
  {
    return !TMQQDownloaderOpenSDK.isExistActoin(this.jdField_a_of_type_Long);
  }
  
  public boolean a(Context paramContext, Bundle paramBundle)
  {
    LogUtility.c("TIME-STATISTIC", "MyAppApi--startToWebView");
    if (paramBundle == null) {
      return false;
    }
    paramBundle = paramBundle.getString("url");
    LogUtility.c("TIME-STATISTIC", "downloadSdk.startToAppDetail");
    c();
    this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK.startToWebView(paramContext, paramBundle);
    return true;
  }
  
  public boolean a(Context paramContext, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    LogUtility.c("TIME-STATISTIC", "MyAppApi--startToAppDetail ");
    if (paramBundle == null) {
      return false;
    }
    TMQQDownloaderOpenSDKParam localTMQQDownloaderOpenSDKParam = a(paramBundle);
    if (!DownloadApi.b(localTMQQDownloaderOpenSDKParam.SNGAppId)) {
      return false;
    }
    boolean bool = ControlPolicyUtil.b();
    long l = CommonDataAdapter.a().a();
    if ((bool) && (l > 0L) && (l != this.jdField_d_of_type_Long)) {}
    for (int i = 1;; i = 0)
    {
      Object localObject;
      if ((i == 0) || (paramContext == null) || (!(paramContext instanceof BaseActivity)))
      {
        localObject = a(localTMQQDownloaderOpenSDKParam, paramBundle);
        DownloadManager.a().e((DownloadInfo)localObject);
      }
      for (;;)
      {
        try
        {
          LogUtility.a("State_Log", "OpenSDK startToAppDetail param SNGAppId=" + localTMQQDownloaderOpenSDKParam.SNGAppId + " apkId=" + localTMQQDownloaderOpenSDKParam.taskApkId + " taskAppId=" + localTMQQDownloaderOpenSDKParam.taskAppId + " packageName=" + localTMQQDownloaderOpenSDKParam.taskPackageName + " version=" + localTMQQDownloaderOpenSDKParam.taskVersion + " uin=" + localTMQQDownloaderOpenSDKParam.uin + " via=" + localTMQQDownloaderOpenSDKParam.via + " autoDownload=" + paramBoolean1 + " autoInstall=" + paramBoolean2);
          LogUtility.c("TIME-STATISTIC", "downloadSdk.startToAppDetail");
          c();
          if (a() <= 2)
          {
            ((TMQQDownloaderOpenSDK)this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK).startToAppDetail(paramContext, localTMQQDownloaderOpenSDKParam, paramBoolean1, paramBoolean2);
          }
          else
          {
            i = paramBundle.getInt(DownloadConstants.j);
            int j = a(paramBundle);
            if (i == 3)
            {
              paramBoolean1 = false;
              paramBoolean2 = false;
              ((TMQQDownloaderOpenSDK_V2)this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK).startToAppDetail(paramContext, localTMQQDownloaderOpenSDKParam, paramBoolean1, paramBoolean2, j);
            }
          }
        }
        catch (Exception paramContext)
        {
          LogUtility.b("MyAppApi", "startToAppDetail err", paramContext);
          return false;
        }
        localObject = new TicketUtils();
        ((TicketUtils)localObject).a(new hsd(this, (TicketUtils)localObject, localTMQQDownloaderOpenSDKParam, paramBundle, l, paramContext, paramBoolean1, paramBoolean2));
        if ((paramContext instanceof BaseActivity)) {
          ((TicketUtils)localObject).a(((BaseActivity)paramContext).getAppRuntime(), 710020706L, "com.tencent.android.qqdownloader");
        }
        return true;
      }
      return true;
    }
  }
  
  protected long b(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    LogUtility.c("MyAppApi", "--addDownloadTaskFromAppDetail--params = " + paramBundle + "autoDownload = " + paramBoolean1);
    if (paramBundle == null) {
      return -1L;
    }
    paramBundle = a(paramBundle);
    this.jdField_b_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam = paramBundle;
    b();
    return this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK.addDownloadTaskFromAppDetail(paramBundle, paramBoolean1, paramBoolean1);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK = TMQQDownloaderOpenSDK_V2.getInstance();
    this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK.initQQDownloaderOpenSDK(CommonDataAdapter.a().a());
    g();
  }
  
  public void b(Activity paramActivity)
  {
    long l = System.currentTimeMillis() - this.jdField_b_of_type_Long;
    LogUtility.c("MyAppApi", "judgeInstallFlag -- installedFlag = " + this.jdField_a_of_type_Boolean + "installTime = " + this.jdField_b_of_type_Long + " countTime =" + l);
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_b_of_type_Long != -1L) && (l <= 180000L)) {
        break label341;
      }
      i = 1;
      if (!b()) {
        break label408;
      }
      if (a()) {
        break label346;
      }
      this.jdField_b_of_type_Boolean = false;
      label107:
      if ((!this.jdField_b_of_type_Boolean) && (i == 0))
      {
        if (this.jdField_a_of_type_Long != -1L)
        {
          c();
          this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK.removeDownloadTask(this.jdField_a_of_type_Long);
        }
        if (!ControlPolicyUtil.f()) {
          break label383;
        }
        if (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams != null)
        {
          if (this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Int != 0) {
            break label354;
          }
          a(paramActivity, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_b_of_type_Boolean);
        }
      }
    }
    label408:
    for (;;)
    {
      e();
      if ((!this.jdField_d_of_type_Boolean) && (!b()))
      {
        paramActivity = CommonDataAdapter.a().a().getSharedPreferences("showTost_pf", 0);
        this.jdField_d_of_type_Boolean = paramActivity.getBoolean("showToast", false);
        this.jdField_b_of_type_JavaLangString = paramActivity.getString("toast_msg", "");
      }
      if (this.jdField_d_of_type_Boolean)
      {
        if (!b()) {
          new Handler(Looper.getMainLooper()).postDelayed(new hrz(this), 2000L);
        }
        this.jdField_d_of_type_Boolean = false;
        paramActivity = CommonDataAdapter.a().a().getSharedPreferences("showTost_pf", 0).edit();
        paramActivity.putBoolean("showToast", this.jdField_d_of_type_Boolean);
        paramActivity.commit();
      }
      return;
      label341:
      i = 0;
      break;
      label346:
      this.jdField_b_of_type_Boolean = true;
      break label107;
      label354:
      a(paramActivity, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams.jdField_b_of_type_Boolean);
      continue;
      label383:
      if ((i == 0) && (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null))
      {
        this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
        continue;
        if ((!this.jdField_b_of_type_Boolean) && (i == 0))
        {
          if (this.jdField_a_of_type_Long != -1L)
          {
            c();
            this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK.removeDownloadTask(this.jdField_a_of_type_Long);
          }
          if ((i == 0) && (this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener != null)) {
            this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener.onClick(null, 0);
          }
        }
      }
    }
  }
  
  public void b(Activity paramActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    c();
    int j = this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK.checkQQDownloaderInstalled();
    boolean bool1 = paramBundle.getBoolean(DownloadConstants.f, false);
    boolean bool2 = paramBundle.getBoolean(DownloadConstants.jdField_g_of_type_JavaLangString, true);
    int k = paramBundle.getInt(DownloadConstants.m);
    int m = paramBundle.getInt(DownloadConstants.j);
    boolean bool3 = ControlPolicyUtil.c();
    boolean bool4 = ControlPolicyUtil.e();
    String str1 = paramBundle.getString(DownloadConstants.a);
    String str2 = paramBundle.getString(DownloadConstants.h);
    DownloadInfo localDownloadInfo = DownloadManager.a().a(str1);
    if ((localDownloadInfo != null) && (localDownloadInfo.h == 1)) {}
    for (int i = 1;; i = 0)
    {
      LogUtility.c("OpenConfig-MyAppApi", " useMyAppFlag = " + bool3);
      if (((bool3) && (bool4)) || (i != 0)) {
        break;
      }
      if (paramOnClickListener != null) {
        paramOnClickListener.onClick(null, 0);
      }
      StaticAnalyz.a("200", str2, str1);
      return;
    }
    if ((j == 2) || (j == 1))
    {
      if (paramOnClickListener != null) {
        paramOnClickListener.onClick(null, 0);
      }
      StaticAnalyz.a("202", str2, str1);
      return;
    }
    if ((ControlPolicyUtil.f()) || (i != 0))
    {
      if (k == 0) {
        a(paramActivity, paramBundle, bool1, bool2);
      }
      for (;;)
      {
        paramActivity = StaticAnalyz.a(str2, "YYB");
        if ((localDownloadInfo != null) || ((m != 2) && (m != 12))) {
          break;
        }
        StaticAnalyz.a("202", paramActivity, str1);
        return;
        a(paramActivity, paramBundle, bool1, bool2);
      }
      StaticAnalyz.a("200", paramActivity, str1);
      return;
    }
    if (paramOnClickListener != null) {
      paramOnClickListener.onClick(null, 0);
    }
    StaticAnalyz.a("200", str2, str1);
  }
  
  public void b(Activity paramActivity, String paramString)
  {
    new YybHandleUtil.InstallBaseTask(paramActivity, paramString).execute(new Void[0]);
  }
  
  public void b(String paramString, Activity paramActivity)
  {
    for (;;)
    {
      String str5;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        String str3 = localJSONObject.optString("appid", "");
        localJSONObject.optString("myAppid", "");
        localJSONObject.optString("apkId", "");
        String str2 = localJSONObject.optString("versionCode", "");
        String str4 = localJSONObject.optString("via", "");
        localJSONObject.optString("appPackageName", "");
        str5 = localJSONObject.optString("appName", "该游戏");
        localJSONObject.optString("channelId", "");
        String str1 = localJSONObject.optString("appAuthorizedStr", "");
        Bundle localBundle = new Bundle();
        paramString = str2;
        if (TextUtils.isEmpty(str2)) {
          paramString = "1";
        }
        int i = Integer.parseInt(paramString);
        localBundle.putString(DownloadConstants.a, localJSONObject.optString("appid", ""));
        localBundle.putString(DownloadConstants.jdField_b_of_type_JavaLangString, localJSONObject.optString("myAppid", ""));
        localBundle.putString(DownloadConstants.c, localJSONObject.optString("apkId"));
        localBundle.putInt(DownloadConstants.d, i);
        localBundle.putString(DownloadConstants.e, localJSONObject.optString("appPackageName"));
        localBundle.putString(DownloadConstants.h, localJSONObject.optString("via"));
        localBundle.putString(DownloadConstants.k, localJSONObject.optString("appName"));
        localBundle.putString(DownloadConstants.y, localJSONObject.optString("channelId"));
        localBundle.putString(DownloadConstants.u, localJSONObject.optString("uin"));
        this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam = a(localBundle);
        this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam.actionFlag = "2";
        if (b())
        {
          d(paramActivity);
          return;
        }
        if (!TextUtils.isEmpty(str1))
        {
          paramString = str1;
          boolean bool = ControlPolicyUtil.a();
          a(paramActivity, 1, 1, "0", new hrx(this, localBundle, bool, paramActivity, str4, str3), new MyAppApi.ClickListenerProxy(this, null, str4, str3), new MyAppApi.BackListener(this, str4, str3), 0, bool, paramString);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      paramString = str5 + "限量内测中，可以到应用宝抢号并下载游戏哦~";
    }
  }
  
  public boolean b()
  {
    boolean bool = true;
    try
    {
      c();
      int i = this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK.checkQQDownloaderInstalled();
      if ((i == 2) || (i == 1)) {
        bool = false;
      }
      return bool;
    }
    catch (Exception localException)
    {
      LogUtility.c("MyAppApi", "hasValidQQDownloader>>>", localException);
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK == null) {
      a();
    }
    for (;;)
    {
      return;
      if (((a() <= 2) && ((this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK instanceof TMQQDownloaderOpenSDK))) || ((a() == 3) && ((this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK instanceof TMQQDownloaderOpenSDK_V2)))) {}
      for (int i = 0; i != 0; i = 1)
      {
        a();
        return;
      }
    }
  }
  
  public void c(Activity paramActivity)
  {
    new YybHandleUtil.InstallBaseTask(paramActivity, null).execute(new Void[0]);
  }
  
  public boolean c()
  {
    return (b()) && (ControlPolicyUtil.c()) && (ControlPolicyUtil.f());
  }
  
  protected void d()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.i.intent.action.ACCOUNT_EXPIRED");
    hrs localhrs = new hrs(this);
    CommonDataAdapter.a().a().registerReceiver(localhrs, localIntentFilter);
  }
  
  public void d(Activity paramActivity)
  {
    boolean bool = ControlPolicyUtil.b();
    long l = CommonDataAdapter.a().a();
    int i;
    if ((bool) && (l > 0L) && (l != this.jdField_d_of_type_Long))
    {
      i = 1;
      if (i != 0) {
        break label117;
      }
      c();
      if (this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam == null) {
        break label108;
      }
      if (a() > 2) {
        break label87;
      }
      ((TMQQDownloaderOpenSDK)this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK).startToAuthorized(paramActivity, this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam, "2");
      label76:
      this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam = null;
    }
    label87:
    label108:
    label117:
    TicketUtils localTicketUtils;
    do
    {
      return;
      i = 0;
      break;
      ((TMQQDownloaderOpenSDK_V2)this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK).startToAuthorized(paramActivity, this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam, "2");
      break label76;
      LogUtility.e("MyAppApi", "startToAuthorizedDirect lastAuthorizeParam = null, needCarryQQIdentity = false");
      return;
      localTicketUtils = new TicketUtils();
      localTicketUtils.a(new hru(this, localTicketUtils, l, paramActivity));
    } while (!(paramActivity instanceof BaseActivity));
    localTicketUtils.a(((BaseActivity)paramActivity).getAppRuntime(), 710020706L, "com.tencent.android.qqdownloader");
  }
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidContentDialogInterface$OnClickListener = null;
    this.jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi$InstallParams = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam = null;
  }
  
  public void e(Activity paramActivity)
  {
    if ((this.e) && (this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam != null))
    {
      if ((!a()) && (a().b()))
      {
        if (this.jdField_a_of_type_Long != -1L)
        {
          c();
          this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK.removeDownloadTask(this.jdField_a_of_type_Long);
        }
        d(paramActivity);
      }
      this.e = false;
      e();
      return;
    }
    this.e = false;
    this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKTMQQDownloaderOpenSDKParam = null;
    e();
  }
  
  public boolean e()
  {
    return a() > 2;
  }
  
  public void f()
  {
    this.jdField_d_of_type_Long = 0L;
  }
  
  protected void g()
  {
    this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK.registerListener(this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKITMQQDownloaderOpenSDKListener);
  }
  
  public void h()
  {
    try
    {
      this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK.unregisterListener(this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKITMQQDownloaderOpenSDKListener);
      this.jdField_a_of_type_ComTencentTmassistantsdkOpenSDKBaseQQDownloaderOpenSDK.destroyQQDownloaderOpenSDK();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          jdField_a_of_type_ComTencentOpenDownloadnewMyAppApi = null;
          return;
        }
        finally {}
        localException = localException;
        LogUtility.a("MyAppApi", "onDestroy>>>", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi
 * JD-Core Version:    0.7.0.1
 */