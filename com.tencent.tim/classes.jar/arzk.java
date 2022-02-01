import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper.a;
import com.tencent.open.business.base.appreport.AppReportReceiver;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.MyAppApi.1;
import com.tencent.open.downloadnew.MyAppApi.13;
import com.tencent.open.downloadnew.MyAppApi.14;
import com.tencent.open.downloadnew.MyAppApi.17;
import com.tencent.open.downloadnew.MyAppApi.18;
import com.tencent.open.downloadnew.MyAppApi.19;
import com.tencent.open.downloadnew.MyAppApi.3;
import com.tencent.open.downloadnew.MyAppApi.4;
import com.tencent.open.downloadnew.MyAppApi.5;
import com.tencent.open.downloadnew.MyAppApi.7;
import com.tencent.open.downloadnew.MyAppApi.8;
import com.tencent.open.downloadnew.MyAppApi.9;
import com.tencent.open.downloadnew.MyAppApi.QQDownloadListener.1;
import com.tencent.open.downloadnew.MyAppApi.QQDownloadListener.2;
import com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.1;
import com.tencent.open.downloadnew.MyAppApi.YYBDownloadListener.2;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistant.st.SDKReportManager2;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantsdk.ITMAssistantCallBackListener;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V2;
import com.tencent.tmassistantsdk.internal.logreport.OuterCallReportModel;
import com.tencent.tmassistantsdk.internal.openSDK.TMAssistantBaseCallYYB;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arzk
{
  protected static arzk a;
  public arzk.d a;
  protected arzk.f a;
  public arzs a;
  protected ITMAssistantCallBackListener a;
  protected TMAssistantBaseCallYYB a;
  protected DialogInterface.OnClickListener af;
  protected long awO = -1L;
  protected final long awP = 180000L;
  public long awQ;
  public TMAssistantCallYYBParamStruct b;
  TMAssistantCallYYBParamStruct c;
  public String cDK = "";
  private boolean coN;
  protected boolean ddA;
  protected boolean ddB;
  boolean ddC = false;
  public boolean ddD;
  private boolean ddE;
  protected boolean ddz;
  private final int eln = 7090000;
  protected long mTaskId;
  
  protected arzk()
  {
    this.jdField_a_of_type_ComTencentTmassistantsdkITMAssistantCallBackListener = new arzk.e();
    try
    {
      emi();
      bxb();
      emh();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        arwt.e("MyAppApi", "MyAppApi init>>>", localThrowable);
      }
    }
  }
  
  public static int Nl()
  {
    return TMAssistantCallYYB_V2.getQQDownloadApiLevel(BaseApplicationImpl.getApplication());
  }
  
  /* Error */
  public static boolean PN()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 113	arzk:jdField_a_of_type_Arzk	Larzk;
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
    //   6	2	1	localarzk	arzk
    //   23	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	23	finally
  }
  
  private static Uri a(OuterCallReportModel paramOuterCallReportModel)
  {
    return Uri.parse("tmast://sdk_wake?jump_code=" + arxs.a(aroi.a().getContext(), null).getInt("Common_jump_code") + "&outerCallTime=" + paramOuterCallReportModel.mOuterCallTime + "&outerCallType=" + paramOuterCallReportModel.mOuterCallType + "&outerCallMode=" + paramOuterCallReportModel.mOuterCallMode + "&hostpname=com.tencent.mobileqq&hostversion=" + GlobalUtil.getAppVersionCode(aroi.a().getContext()));
  }
  
  public static arzk a()
  {
    try
    {
      if (jdField_a_of_type_Arzk == null) {
        jdField_a_of_type_Arzk = new arzk();
      }
      emk();
      arzk localarzk = jdField_a_of_type_Arzk;
      return localarzk;
    }
    finally {}
  }
  
  @NonNull
  private static OuterCallReportModel a()
  {
    OuterCallReportModel localOuterCallReportModel = OuterCallReportModel.getDefaultModel();
    localOuterCallReportModel.mOuterCallMode = 0;
    localOuterCallReportModel.mOuterCallType = 1;
    localOuterCallReportModel.mOuterCallTime = System.currentTimeMillis();
    localOuterCallReportModel.mComponentName = "SplashActivity";
    return localOuterCallReportModel;
  }
  
  private static void a(OuterCallReportModel paramOuterCallReportModel)
  {
    GlobalUtil.getInstance().setContext(aroi.a().getContext());
    SDKReportManager2.getInstance().postReport(15, paramOuterCallReportModel.toString());
  }
  
  private static boolean aHv()
  {
    return (aryq.aHt()) && (TMAssistantCallYYB_V1.getQQDownloadApiLevel(aroi.a().getContext()) >= 7);
  }
  
  public static boolean aHx()
  {
    boolean bool = true;
    try
    {
      int i = checkQQDownloaderInstalled();
      if (i == 2) {
        return false;
      }
      if (i != 1) {}
      for (;;)
      {
        return bool;
        bool = false;
      }
      return false;
    }
    catch (Exception localException)
    {
      arwt.e("MyAppApi", "hasValidQQDownloader>>>", localException);
    }
  }
  
  private static void b(OuterCallReportModel paramOuterCallReportModel)
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setPackage("com.tencent.android.qqdownloader");
    localIntent.setData(a(paramOuterCallReportModel));
    localIntent.addFlags(32768);
    if (!(aroi.a().getContext() instanceof Activity)) {
      localIntent.addFlags(268435456);
    }
    try
    {
      aroi.a().getContext().startActivity(localIntent);
      return;
    }
    catch (SecurityException paramOuterCallReportModel)
    {
      paramOuterCallReportModel.printStackTrace();
      return;
    }
    catch (ActivityNotFoundException paramOuterCallReportModel)
    {
      arwt.e("TAMST_WAKE", "activity not found error:" + paramOuterCallReportModel.getMessage());
    }
  }
  
  public static int checkQQDownloaderInstalled()
  {
    Object localObject = aroi.a().getContext();
    if (localObject == null) {}
    for (;;)
    {
      return 1;
      localObject = ((Context)localObject).getPackageManager();
      if (localObject != null) {
        try
        {
          if (((PackageManager)localObject).getPackageInfo("com.tencent.android.qqdownloader", 0) != null)
          {
            int i = GlobalUtil.getInstance().getQQDownloaderAPILevel();
            if (2 > i) {
              return 2;
            }
            return 0;
          }
        }
        catch (PackageManager.NameNotFoundException localNameNotFoundException)
        {
          arwt.e("TAMST_WAKE", "yyb installed check error:" + localNameNotFoundException.getMessage());
        }
      }
    }
    return 1;
  }
  
  private void emh()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    aroi.a().getContext().registerReceiver(new AppReportReceiver(), localIntentFilter);
  }
  
  public static void emk()
  {
    ThreadManager.executeOnSubThread(new MyAppApi.1());
  }
  
  public String DC()
  {
    if ((this.jdField_a_of_type_Arzk$d != null) && (this.jdField_a_of_type_Arzk$d.y != null)) {
      return this.jdField_a_of_type_Arzk$d.y.getString(aryv.PARAM_SNG_APPID);
    }
    return "";
  }
  
  public int H(Bundle paramBundle)
  {
    int j = 1;
    int i = j;
    if (paramBundle != null)
    {
      i = j;
      if (paramBundle.getInt(aryv.PARAM_ACTIONCODE) == 3) {
        i = 2;
      }
    }
    return i;
  }
  
  public void S(Activity paramActivity, String paramString)
  {
    arwt.d("NewUpgradeDialog", "preDownload called,get updateDetail info");
    ThreadManager.getSubThreadHandler().postDelayed(new MyAppApi.18(this, paramActivity), 0L);
  }
  
  public void Up(boolean paramBoolean)
  {
    this.coN = paramBoolean;
  }
  
  protected void Xs(String paramString)
  {
    aryy localaryy = aryy.a();
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.appId = paramString;
    localDownloadInfo.setState(10);
    if (localDownloadInfo != null) {
      localaryy.b(10, localDownloadInfo);
    }
  }
  
  protected long a(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    arwt.d("MyAppApi", "--addDownloadTaskFromTaskList--params = " + paramBundle + "autoDownload = " + paramBoolean1);
    if (paramBundle == null) {
      return -1L;
    }
    paramBundle = a(paramBundle);
    this.c = paramBundle;
    return a().addDownloadTaskFromTaskList(paramBundle, paramBoolean1, paramBoolean1);
  }
  
  public DownloadInfo a(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, Bundle paramBundle)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.downloadType = 1;
    localDownloadInfo.appId = paramTMAssistantCallYYBParamStruct.SNGAppId;
    localDownloadInfo.cDG = paramTMAssistantCallYYBParamStruct.taskAppId;
    localDownloadInfo.packageName = paramTMAssistantCallYYBParamStruct.taskPackageName;
    localDownloadInfo.cCL = paramTMAssistantCallYYBParamStruct.taskApkId;
    localDownloadInfo.versionCode = paramTMAssistantCallYYBParamStruct.taskVersion;
    localDownloadInfo.recommendId = paramTMAssistantCallYYBParamStruct.recommendId;
    localDownloadInfo.channelId = paramTMAssistantCallYYBParamStruct.channelId;
    if (paramBundle != null)
    {
      localDownloadInfo.via = paramBundle.getString(aryv.PARAM_VIA);
      localDownloadInfo.pushTitle = paramBundle.getString(aryv.PARAM_APPNAME);
      localDownloadInfo.urlStr = paramBundle.getString(aryv.PARAM_URL);
      localDownloadInfo.elk = paramBundle.getInt(aryv.PARAM_WOWNLOAD_TYPE);
    }
    return localDownloadInfo;
  }
  
  public TMAssistantDownloadTaskInfo a(Bundle paramBundle)
  {
    if ((paramBundle == null) || (!aHx())) {
      return null;
    }
    paramBundle = a(paramBundle);
    if (getApiLevel() <= 2)
    {
      paramBundle = ((TMAssistantCallYYB_V1)a()).getDownloadTaskState(paramBundle);
      if (paramBundle != null) {
        return new TMAssistantDownloadTaskInfo(paramBundle.mUrl, paramBundle.mSavePath, paramBundle.mState, paramBundle.mReceiveDataLen, paramBundle.mTotalDataLen, paramBundle.mContentType);
      }
      return null;
    }
    paramBundle = ((TMAssistantCallYYB_V2)a()).getDownloadTaskState(paramBundle);
    if (paramBundle != null) {
      return new TMAssistantDownloadTaskInfo(paramBundle.mUrl, paramBundle.mSavePath, paramBundle.mState, paramBundle.mReceiveDataLen, paramBundle.mTotalDataLen, paramBundle.mContentType);
    }
    return null;
  }
  
  protected TMAssistantCallYYBParamStruct a(Bundle paramBundle)
  {
    String str3 = paramBundle.getString(aryv.PARAM_SNG_APPID);
    String str4 = paramBundle.getString(aryv.PARAM_TASK_APPID);
    String str5 = paramBundle.getString(aryv.PARAM_TASK_APK_ID);
    String str6 = paramBundle.getString(aryv.PARAM_TASK_PACKNAME);
    Object localObject = paramBundle.getString(aryv.PARAM_VIA);
    int j = paramBundle.getInt(aryv.PARAM_TASK_VERSION);
    int i = j;
    if (j == 0) {}
    try
    {
      i = Integer.valueOf(paramBundle.getString(aryv.PARAM_TASK_VERSION)).intValue();
      String str2;
      String str1;
      if (this.ddz)
      {
        str2 = arxt.cj((String)localObject, "NEWYYB");
        paramBundle.getString(aryv.PARAM_CHANNELID);
        localObject = paramBundle.getString(aryv.cDC);
        j = paramBundle.getInt(aryv.cDB);
        if (j != 1) {
          break label418;
        }
        localObject = "ANDROIDQQ-gray";
        str1 = "1";
      }
      for (;;)
      {
        arwt.i("State_Log", " channelId:" + (String)localObject);
        localObject = new TMAssistantCallYYBParamStruct(str3, str4, str5, i, str2, str6, "", "", (String)localObject, str1);
        if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(aroi.a().getContext()) >= 6)
        {
          ((TMAssistantCallYYBParamStruct)localObject).timePointMap.put("OuterCall_JS_DoDownloadAction", Long.valueOf(paramBundle.getLong("OuterCall_JS_DoDownloadAction", 0L)));
          ((TMAssistantCallYYBParamStruct)localObject).timePointMap.put("OuterCall_DownloadApi_DoDownloadAction", Long.valueOf(paramBundle.getLong("OuterCall_DownloadApi_DoDownloadAction", 0L)));
          ((TMAssistantCallYYBParamStruct)localObject).timePointMap.put("OuterCall_DownloadApi_DoDownloadActionByMyApp", Long.valueOf(paramBundle.getLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", 0L)));
          ((TMAssistantCallYYBParamStruct)localObject).timePointMap.put("OuterCall_MyAppApi_HandleDownloadAction", Long.valueOf(paramBundle.getLong("OuterCall_MyAppApi_HandleDownloadAction", 0L)));
          ((TMAssistantCallYYBParamStruct)localObject).timePointMap.put("OuterCall_MyAppApi_StartToAppDetail", Long.valueOf(paramBundle.getLong("OuterCall_MyAppApi_StartToAppDetail", 0L)));
          ((TMAssistantCallYYBParamStruct)localObject).timePointMap.put("OuterCall_MyAppApi_StartToDownloadList", Long.valueOf(paramBundle.getLong("OuterCall_MyAppApi_StartToDownloadList", 0L)));
        }
        ((TMAssistantCallYYBParamStruct)localObject).source = paramBundle.getString("big_brother_source_key");
        ((TMAssistantCallYYBParamStruct)localObject).recommendId = paramBundle.getString("recommendId");
        arwt.i("MyAppApi", "recommendId:" + ((TMAssistantCallYYBParamStruct)localObject).recommendId);
        return localObject;
        str2 = arxt.cj((String)localObject, "YYB");
        break;
        label418:
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = "ANDROIDQQ";
          str1 = j + "";
        }
        else
        {
          str1 = j + "";
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  public TMAssistantBaseCallYYB a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB == null) {
        emi();
      }
      TMAssistantBaseCallYYB localTMAssistantBaseCallYYB = this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB;
      return localTMAssistantBaseCallYYB;
    }
    finally {}
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2, String paramString1, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnCancelListener paramOnCancelListener, String paramString2, boolean paramBoolean, Bundle paramBundle)
  {
    String str = paramBundle.getString(aryv.PARAM_WORDING);
    int i = paramBundle.getInt("dialogType");
    int j = paramBundle.getInt("auto_start_yyb_download");
    arwt.d("TIME-STATISTIC", "MyAppApi--showTipDialog");
    arwt.d("MyAppApi", "-showTipDialog-");
    if (paramActivity == null) {
      return;
    }
    Resources localResources = paramActivity.getResources();
    Object localObject;
    if (paramInt2 == 1) {
      if (paramInt1 == 2)
      {
        paramInt1 = 1;
        if (!TextUtils.isEmpty(str)) {
          break label463;
        }
        localObject = aryq.P(paramInt1, paramString2);
        label86:
        paramString2 = (String)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
        switch (paramInt1)
        {
        default: 
          paramString2 = localResources.getString(2131692652);
          label138:
          if (((paramInt1 != 2) && (paramInt1 != 4)) || (!TextUtils.isEmpty(str))) {
            break;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        paramString1 = String.format(paramString2, new Object[] { paramString1 });
        localObject = localResources.getString(2131692674);
        if ((paramInt2 == 1) && (i == 1))
        {
          paramString1 = localResources.getString(2131692675);
          paramString2 = localResources.getString(2131692656);
          localObject = new arzs(paramActivity);
          ((arzs)localObject).b(2131692667, paramOnClickListener2, true);
          if (!paramBoolean)
          {
            bool = true;
            ((arzs)localObject).a(2131692672, paramOnClickListener1, bool);
            ((arzs)localObject).a(paramString1);
            ((arzs)localObject).b(paramString2);
            if (i == 1)
            {
              ((arzs)localObject).b(2131692667, Color.parseColor("#D2D1D1"), paramOnClickListener2, true);
              paramInt1 = Color.parseColor("#3AC8FF");
              if (paramBoolean) {
                continue;
              }
              paramBoolean = true;
              ((arzs)localObject).a(2131692672, paramInt1, paramOnClickListener1, paramBoolean);
              ((arzs)localObject).ag(paramActivity.getResources().getDrawable(2130842714));
              ((arzs)localObject).a(Color.parseColor("#848484"));
            }
            ((arzs)localObject).setCancelable(true);
            ((arzs)localObject).setOnCancelListener(paramOnCancelListener);
            ((arzs)localObject).setOnDismissListener(new arzn(this));
            if ((!(paramActivity instanceof AppActivity)) || (((AppActivity)paramActivity).isResume())) {
              continue;
            }
            arwt.d("TIME-STATISTIC", "MyAppApi--showTipDialog---cancel !isResume");
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
            label463:
            localObject = str;
            break label86;
            paramString2 = localResources.getString(2131692652);
            break label138;
            paramString2 = localResources.getString(2131692653, new Object[] { paramString1 });
            break label138;
            paramString2 = localResources.getString(2131692654);
            break label138;
            paramString2 = localResources.getString(2131692655, new Object[] { paramString1 });
          }
        }
      }
      catch (Exception paramString2)
      {
        if (paramInt1 == 2)
        {
          paramString1 = localResources.getString(2131692652);
          arwt.d("MyAppApi", " errorMsg = " + paramString2.getMessage());
          continue;
        }
        paramString1 = localResources.getString(2131692654);
        continue;
        boolean bool = false;
        continue;
        paramBoolean = false;
        continue;
        try
        {
          if (!paramActivity.isFinishing())
          {
            ((arzs)localObject).show();
            anot.a(null, "dc00898", "", "", "0X8008F7A", "0X8008F7A", 0, 0, "", "", "", "");
            if (i == 1)
            {
              arwk.p("6006", "0", "0", paramBundle.getString(aryv.PARAM_VIA), paramBundle.getString("pageId") + "_" + paramBundle.getString("moduleId") + "_" + paramBundle.getString(aryv.PARAM_TASK_PACKNAME) + "_" + paramBundle.getString(aryv.PARAM_TASK_APPID) + "_" + paramBundle.getString(aryv.PARAM_TASK_APK_ID));
              if (j == 1) {
                ThreadManager.getUIHandler().post(new MyAppApi.13(this, paramOnClickListener1, (arzs)localObject));
              }
            }
          }
        }
        catch (Exception paramActivity)
        {
          paramActivity.printStackTrace();
          continue;
        }
        arwt.d("TIME-STATISTIC", "MyAppApi--showTipDialog---complete");
        this.jdField_a_of_type_Arzs = ((arzs)localObject);
        return;
        paramString2 = paramString1;
        paramString1 = (String)localObject;
        continue;
      }
      paramString1 = paramString2;
    }
  }
  
  protected void a(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener)
  {
    boolean bool = aryq.aHo();
    long l = aroi.a().getUin();
    int i;
    if ((bool) && (l > 0L) && (l != this.awQ))
    {
      i = 1;
      if (i != 0) {
        break label115;
      }
      if (this.b == null) {
        break label106;
      }
      if (getApiLevel() > 2) {
        break label85;
      }
      ((TMAssistantCallYYB_V1)a()).startToAuthorized(paramActivity, this.b, "2");
      label74:
      this.b = null;
    }
    label85:
    label106:
    label115:
    arwy localarwy;
    do
    {
      return;
      i = 0;
      break;
      ((TMAssistantCallYYB_V2)a()).startToAuthorized(paramActivity, this.b, "2");
      break label74;
      arwt.e("MyAppApi", "startToAuthorizedDirect mLastAuthorizeParam = null, needCarryQQIdentity = false");
      return;
      localarwy = new arwy();
      localarwy.a(new arzo(this, localarwy, l, paramActivity, paramOnClickListener));
    } while (!(paramActivity instanceof BaseActivity));
    localarwy.a(((BaseActivity)paramActivity).getAppRuntime(), 710020706L, "com.tencent.android.qqdownloader");
  }
  
  public void a(Activity paramActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    arwt.d("TIME-STATISTIC", "MyAppApi--handleDownloadAction");
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramActivity) >= 6) {
      paramBundle.putLong("OuterCall_MyAppApi_HandleDownloadAction", System.currentTimeMillis());
    }
    int i = -1;
    try
    {
      j = a().checkQQDownloaderInstalled();
      i = j;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        boolean bool5;
        DownloadInfo localDownloadInfo;
        localException1.printStackTrace();
        continue;
        bool1 = false;
      }
      if (i == 2) {
        break label307;
      }
    }
    boolean bool2 = paramBundle.getBoolean(aryv.PARAM_AUTO_DOWNLOAD, false);
    boolean bool3 = paramBundle.getBoolean(aryv.PARAM_AUTO_INSTALL, true);
    int k = paramBundle.getInt(aryv.PARAM_TO_PAGETYPE);
    int j = paramBundle.getInt(aryv.PARAM_ACTIONCODE);
    String str3 = paramBundle.getString(aryv.PARAM_VIA);
    String str2 = paramBundle.getString(aryv.PARAM_SNG_APPID);
    int m = paramBundle.getInt("dialogType");
    int n = paramBundle.getInt(aryv.PARAM_PATCH_SIZE, 0);
    int i1 = paramBundle.getInt(aryv.cDA, 0);
    boolean bool4 = aryq.aHp();
    bool5 = aryq.aHr();
    arwt.d("OpenConfig-MyAppApi", " useMyAppFlag = " + bool4);
    localDownloadInfo = aryy.a().c(str2);
    boolean bool1;
    if ((localDownloadInfo != null) && (localDownloadInfo.downloadType == 1))
    {
      bool1 = true;
      if (((bool4) && (bool5)) || (bool1)) {
        break label295;
      }
      if (paramOnClickListener != null)
      {
        arwt.v("MyAppApi", "allowMyApp=" + bool4 + " allowMyAppDownload=" + bool5 + " taskExist=" + bool1);
        paramOnClickListener.onClick(null, 0);
      }
      arxt.br("200", str3, str2);
    }
    for (;;)
    {
      return;
      label295:
      if (i == 1) {
        label307:
        if ((this.jdField_a_of_type_Arzs != null) && (this.jdField_a_of_type_Arzs.isShowing())) {
          if (this.jdField_a_of_type_Arzs.getActivity() == paramActivity)
          {
            arwt.v("MyAppApi", "mTipDialog is showing return");
            return;
          }
        }
      }
      try
      {
        this.jdField_a_of_type_Arzs.dismiss();
        label351:
        for (this.jdField_a_of_type_Arzs = null; (!aryq.aHq()) || ((j != 2) && (j != 12)); this.jdField_a_of_type_Arzs = null)
        {
          arwt.v("MyAppApi", "not allowShowDialog return actionCode = " + j);
          if (paramOnClickListener != null) {
            paramOnClickListener.onClick(null, 0);
          }
          arxt.br("200", str3, str2);
          return;
        }
        ThreadManager.getSubThreadHandler().post(new MyAppApi.5(this, str3, str2));
        bool4 = aryq.aHl();
        arzr localarzr = new arzr(this, bool2, paramOnClickListener, paramBundle, k, bool4, paramActivity, str3, bool1, bool3, str2, m);
        arzk.b localb = new arzk.b(paramOnClickListener, str3, str2);
        arzk.a locala = new arzk.a(str3, str2);
        String str1 = null;
        Object localObject = str1;
        if (i1 > 0)
        {
          localObject = str1;
          if (n > 0)
          {
            k = i1 - n;
            localObject = str1;
            if (k > 0) {
              localObject = asaa.gv(k);
            }
          }
        }
        str1 = paramBundle.getString("source");
        ThreadManager.getUIHandler().post(new MyAppApi.7(this, paramActivity, j, i, (String)localObject, localarzr, localb, locala, str1, bool4, paramBundle));
        ThreadManager.getSubThreadHandler().post(new MyAppApi.8(this, str3, str2));
        this.af = paramOnClickListener;
        return;
        if (i != 0) {
          continue;
        }
        if ((aryq.aHs()) || (bool1))
        {
          paramOnClickListener = arxt.cj(str3, "YYB");
          if (k == 0) {
            a(paramActivity, paramBundle, bool2, bool3);
          }
          while ((localObject == null) && ((j == 2) || (j == 12)))
          {
            arxt.br("202", paramOnClickListener, str2);
            return;
            a(paramActivity, paramBundle, bool2, bool3);
          }
          arxt.br("200", paramOnClickListener, str2);
          return;
        }
        if (paramOnClickListener != null) {
          paramOnClickListener.onClick(null, 0);
        }
        arxt.br("200", str3, str2);
        return;
      }
      catch (Exception localException2)
      {
        break label351;
      }
    }
  }
  
  public void a(Activity paramActivity, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    arwt.d("MyAppApi", "startDownloadYyb");
    Bundle localBundle = new Bundle();
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "https://a.app.qq.com/o/myapp-down?g_f=991310";
    }
    localBundle.putString(aryv.PARAM_SNG_APPID, "1101070898");
    localBundle.putString(aryv.PARAM_URL, str);
    localBundle.putString(aryv.PARAM_TASK_PACKNAME, "com.tencent.android.qqdownloader");
    localBundle.putInt(aryv.PARAM_ACTIONCODE, 2);
    localBundle.putString(aryv.PARAM_VIA, paramString2);
    localBundle.putString(aryv.PARAM_APPNAME, asaa.cDP);
    if (paramInt == 1) {
      localBundle.putBoolean(aryv.PARAM_BLOCK_NOTIFY, true);
    }
    for (;;)
    {
      localBundle.putInt(aryv.cDD, paramInt);
      localBundle.putString(aryv.PARAM_NOTIFYKEY, "yyb");
      localBundle.putString(aryv.PARAM_TASK_APPID, "5848");
      localBundle.putBoolean(aryv.PARAM_AUTO_DOWNLOAD, true);
      localBundle.putBoolean(aryv.PARAM_AUTO_INSTALL, paramBoolean);
      localBundle.putInt(aryv.PARAM_TO_PAGETYPE, 1);
      aryr.d(paramActivity, localBundle, "biz_src_yyb", null, 0);
      return;
      localBundle.putBoolean(aryv.PARAM_BLOCK_NOTIFY, false);
    }
  }
  
  protected void a(Context paramContext, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    arwt.d("TIME-STATISTIC", "MyAppApi--startToDownloadTaskList");
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramContext) >= 6) {
      paramBundle.putLong("OuterCall_MyAppApi_StartToDownloadList", System.currentTimeMillis());
    }
    if ((paramBundle == null) || (paramContext == null)) {
      return;
    }
    TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = a(paramBundle);
    boolean bool = aryq.aHo();
    long l = aroi.a().getUin();
    int i;
    if ((bool) && (l > 0L) && (l != this.awQ)) {
      i = 1;
    }
    Object localObject;
    label296:
    int j;
    while ((i == 0) || (paramContext == null) || (!(paramContext instanceof BaseActivity)))
    {
      localObject = a(localTMAssistantCallYYBParamStruct, paramBundle);
      aryy.a().j((DownloadInfo)localObject);
      try
      {
        arwt.v("State_Log", "OpenSDK startToDownloadTaskList param SNGAppId=" + localTMAssistantCallYYBParamStruct.SNGAppId + " apkId=" + localTMAssistantCallYYBParamStruct.taskApkId + " taskAppId=" + localTMAssistantCallYYBParamStruct.taskAppId + " packageName=" + localTMAssistantCallYYBParamStruct.taskPackageName + " version=" + localTMAssistantCallYYBParamStruct.taskVersion + " uin=" + localTMAssistantCallYYBParamStruct.uin + " via=" + localTMAssistantCallYYBParamStruct.via);
        arwt.d("TIME-STATISTIC", "mDownloadSdk.startToDownloadTaskList");
        if (getApiLevel() > 2) {
          break label296;
        }
        ((TMAssistantCallYYB_V1)a()).startToDownloadTaskList(paramContext, localTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2);
        return;
      }
      catch (Exception paramContext)
      {
        arwt.e("MyAppApi", "--startToDownloadTaskList--Exception = " + paramContext);
        return;
      }
      i = 0;
      continue;
      i = paramBundle.getInt(aryv.PARAM_ACTIONCODE);
      j = H(paramBundle);
      if (i != 3) {
        break label401;
      }
      paramBoolean1 = false;
      paramBoolean2 = false;
    }
    label401:
    for (;;)
    {
      ((TMAssistantCallYYB_V2)a()).startToDownloadTaskList(paramContext, localTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, j);
      return;
      localObject = new arwy();
      ((arwy)localObject).a(new arzm(this, (arwy)localObject, localTMAssistantCallYYBParamStruct, paramBundle, l, paramContext, paramBoolean1, paramBoolean2));
      if (!(paramContext instanceof BaseActivity)) {
        break;
      }
      ((arwy)localObject).a(((BaseActivity)paramContext).getAppRuntime(), 710020706L, "com.tencent.android.qqdownloader");
      return;
    }
  }
  
  public void a(Context paramContext, JSONArray paramJSONArray, int paramInt, String paramString1, String paramString2)
  {
    int j = 2;
    if (paramJSONArray == null) {}
    int k;
    do
    {
      return;
      k = paramJSONArray.length();
    } while (k == 0);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < k)
    {
      JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
      if (localJSONObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = new TMAssistantCallYYBParamStruct();
        localTMAssistantCallYYBParamStruct.recommendId = localJSONObject.optString("recommendId");
        localTMAssistantCallYYBParamStruct.channelId = localJSONObject.optString(aryv.cDE);
        localTMAssistantCallYYBParamStruct.taskPackageName = localJSONObject.optString(aryv.PARAM_TASK_PACKNAME);
        localTMAssistantCallYYBParamStruct.taskVersion = localJSONObject.optInt(aryv.PARAM_TASK_VERSION);
        localTMAssistantCallYYBParamStruct.via = localJSONObject.optString(aryv.PARAM_VIA);
        localTMAssistantCallYYBParamStruct.taskApkId = localJSONObject.optString(aryv.PARAM_TASK_APK_ID);
        localTMAssistantCallYYBParamStruct.taskAppId = localJSONObject.optString(aryv.PARAM_TASK_APPID);
        localTMAssistantCallYYBParamStruct.SNGAppId = localJSONObject.optString(aryv.PARAM_TASK_APPID);
        if (TextUtils.isEmpty(localTMAssistantCallYYBParamStruct.SNGAppId)) {
          localTMAssistantCallYYBParamStruct.SNGAppId = localJSONObject.optString(aryv.PARAM_SNG_APPID);
        }
        if (TextUtils.isEmpty(localTMAssistantCallYYBParamStruct.via)) {
          localTMAssistantCallYYBParamStruct.via = paramString1;
        }
        localTMAssistantCallYYBParamStruct.source = paramString2;
        localArrayList.add(localTMAssistantCallYYBParamStruct);
      }
    }
    i = j;
    if (paramInt == 2) {
      i = 3;
    }
    ThreadManager.excute(new MyAppApi.9(this, paramContext, localArrayList, i, paramString1), 16, null, true);
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener, Activity paramActivity)
  {
    ThreadManager.getSubThreadHandler().post(new MyAppApi.14(this, paramString, paramOnClickListener, paramActivity));
  }
  
  public boolean a(Context paramContext, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    arwt.d("TIME-STATISTIC", "MyAppApi--startToAppDetail ");
    if (paramBundle == null) {
      return false;
    }
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramContext) >= 6) {
      paramBundle.putLong("OuterCall_MyAppApi_StartToAppDetail", System.currentTimeMillis());
    }
    TMAssistantCallYYBParamStruct localTMAssistantCallYYBParamStruct = a(paramBundle);
    if (!aryr.sA(localTMAssistantCallYYBParamStruct.SNGAppId)) {
      return false;
    }
    boolean bool = aryq.aHo();
    long l = aroi.a().getUin();
    if ((bool) && (l > 0L) && (l != this.awQ)) {}
    for (int i = 1;; i = 0)
    {
      Object localObject;
      if ((i == 0) || (paramContext == null) || (!(paramContext instanceof BaseActivity)))
      {
        localObject = a(localTMAssistantCallYYBParamStruct, paramBundle);
        aryy.a().j((DownloadInfo)localObject);
      }
      for (;;)
      {
        try
        {
          arwt.v("State_Log", "OpenSDK startToAppDetail param SNGAppId=" + localTMAssistantCallYYBParamStruct.SNGAppId + " apkId=" + localTMAssistantCallYYBParamStruct.taskApkId + " taskAppId=" + localTMAssistantCallYYBParamStruct.taskAppId + " source=" + localTMAssistantCallYYBParamStruct.source + " packageName=" + localTMAssistantCallYYBParamStruct.taskPackageName + " version=" + localTMAssistantCallYYBParamStruct.taskVersion + " uin=" + localTMAssistantCallYYBParamStruct.uin + " via=" + localTMAssistantCallYYBParamStruct.via + " autoDownload=" + paramBoolean1 + " autoInstall=" + paramBoolean2);
          arwt.d("TIME-STATISTIC", "mDownloadSdk.startToAppDetail");
          if (getApiLevel() <= 2)
          {
            ((TMAssistantCallYYB_V1)a()).startToAppDetail(paramContext, localTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2);
          }
          else
          {
            i = paramBundle.getInt(aryv.PARAM_ACTIONCODE);
            int j = H(paramBundle);
            if (i == 3)
            {
              paramBoolean1 = false;
              paramBoolean2 = false;
              ((TMAssistantCallYYB_V2)a()).startToAppDetail(paramContext, localTMAssistantCallYYBParamStruct, paramBoolean1, paramBoolean2, j);
            }
          }
        }
        catch (Exception paramContext)
        {
          arwt.w("MyAppApi", "startToAppDetail err", paramContext);
          return false;
        }
        localObject = new arwy();
        ((arwy)localObject).a(new arzl(this, (arwy)localObject, localTMAssistantCallYYBParamStruct, paramBundle, l, paramContext, paramBoolean1, paramBoolean2));
        if ((paramContext instanceof BaseActivity)) {
          ((arwy)localObject).a(((BaseActivity)paramContext).getAppRuntime(), 710020706L, "com.tencent.android.qqdownloader");
        }
        return true;
      }
      return true;
    }
  }
  
  public boolean aHA()
  {
    return this.coN;
  }
  
  public boolean aHB()
  {
    boolean bool2 = false;
    Object localObject = BaseActivity.sTopActivity.getPackageManager();
    boolean bool1 = bool2;
    if (localObject != null) {}
    try
    {
      localObject = ((PackageManager)localObject).getPackageInfo("com.tencent.android.qqdownloader", 0);
      bool1 = bool2;
      if (localObject != null)
      {
        int i = ((PackageInfo)localObject).versionCode;
        bool1 = bool2;
        if (i >= 7090000) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    return false;
  }
  
  protected boolean aHw()
  {
    return !TMAssistantCallYYB_V1.isExistActoin(this.mTaskId);
  }
  
  public boolean aHy()
  {
    return (aHx()) && (aryq.aHp()) && (aryq.aHs());
  }
  
  public boolean aHz()
  {
    return getApiLevel() > 2;
  }
  
  public void aU(boolean paramBoolean, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.ddC = paramBoolean;
      this.cDK = paramString;
    } while (!this.ddC);
    SharedPreferences.Editor localEditor = aroi.a().getContext().getSharedPreferences("showTost_pf", 0).edit();
    localEditor.putBoolean("showToast", this.ddC);
    localEditor.putString("toast_msg", paramString);
    localEditor.commit();
  }
  
  public long addDownloadTaskFromTmast(Bundle paramBundle)
  {
    try
    {
      arwt.d("MyAppApi", "--addDownloadTaskFromTmast--params = " + paramBundle);
      if (paramBundle == null) {
        return -1L;
      }
      paramBundle.getString("url");
      long l = a().addDownloadTaskFromTmast(paramBundle);
      return l;
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
    return -1L;
  }
  
  protected long b(Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    arwt.d("MyAppApi", "--addDownloadTaskFromAppDetail--params = " + paramBundle + "autoDownload = " + paramBoolean1);
    if (paramBundle == null) {
      return -1L;
    }
    paramBundle = a(paramBundle);
    this.c = paramBundle;
    return a().addDownloadTaskFromAppDetail(paramBundle, paramBoolean1, paramBoolean1);
  }
  
  public void b(Activity paramActivity, Bundle paramBundle, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramActivity) >= 6) {
      paramBundle.putLong("OuterCall_MyAppApi_HandleDownloadAction", System.currentTimeMillis());
    }
    int i = -1;
    try
    {
      j = a().checkQQDownloaderInstalled();
      i = j;
    }
    catch (Exception localException)
    {
      int j;
      boolean bool1;
      boolean bool2;
      int k;
      int m;
      String str2;
      DownloadInfo localDownloadInfo;
      for (;;)
      {
        boolean bool3;
        boolean bool4;
        String str1;
        localException.printStackTrace();
        continue;
        j = 0;
      }
      if ((i != 2) && (i != 1)) {
        break label244;
      }
      if (paramOnClickListener == null) {
        break label233;
      }
      paramOnClickListener.onClick(null, 0);
      arxt.br("202", str2, localException);
      return;
      if ((!aryq.aHs()) && (j == 0)) {
        break label331;
      }
      if (k != 0) {
        break label308;
      }
      a(paramActivity, paramBundle, bool1, bool2);
      for (;;)
      {
        paramActivity = arxt.cj(str2, "YYB");
        if ((localDownloadInfo != null) || ((m != 2) && (m != 12))) {
          break;
        }
        arxt.br("202", paramActivity, localException);
        return;
        a(paramActivity, paramBundle, bool1, bool2);
      }
      arxt.br("200", paramActivity, localException);
      return;
      if (paramOnClickListener == null) {
        break label343;
      }
      paramOnClickListener.onClick(null, 0);
      arxt.br("200", str2, localException);
    }
    bool1 = paramBundle.getBoolean(aryv.PARAM_AUTO_DOWNLOAD, false);
    bool2 = paramBundle.getBoolean(aryv.PARAM_AUTO_INSTALL, true);
    k = paramBundle.getInt(aryv.PARAM_TO_PAGETYPE);
    m = paramBundle.getInt(aryv.PARAM_ACTIONCODE);
    bool3 = aryq.aHp();
    bool4 = aryq.aHr();
    str1 = paramBundle.getString(aryv.PARAM_SNG_APPID);
    str2 = paramBundle.getString(aryv.PARAM_VIA);
    localDownloadInfo = aryy.a().c(str1);
    if ((localDownloadInfo != null) && (localDownloadInfo.downloadType == 1))
    {
      j = 1;
      arwt.d("OpenConfig-MyAppApi", " useMyAppFlag = " + bool3);
      if (((bool3) && (bool4)) || (j != 0)) {
        break label209;
      }
      if (paramOnClickListener != null) {
        paramOnClickListener.onClick(null, 0);
      }
      arxt.br("200", str2, str1);
    }
    label209:
    label233:
    label244:
    return;
  }
  
  public void b(String paramString, DialogInterface.OnClickListener paramOnClickListener, Activity paramActivity)
  {
    for (;;)
    {
      String str3;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        String str1 = localJSONObject.optString("appid", "");
        localJSONObject.optString("myAppid", "");
        localJSONObject.optString("apkId", "");
        Object localObject2 = localJSONObject.optString("versionCode", "");
        String str2 = localJSONObject.optString("via", "");
        localJSONObject.optString("appPackageName", "");
        str3 = localJSONObject.optString("appName", acfp.m(2131708620));
        localJSONObject.optString("channelId", "");
        Object localObject1 = localJSONObject.optString("appAuthorizedStr", "");
        Bundle localBundle = new Bundle();
        paramString = (String)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          paramString = "1";
        }
        int i = Integer.parseInt(paramString);
        localBundle.putString(aryv.PARAM_SNG_APPID, localJSONObject.optString("appid", ""));
        localBundle.putString(aryv.PARAM_TASK_APPID, localJSONObject.optString("myAppid", ""));
        localBundle.putString(aryv.PARAM_TASK_APK_ID, localJSONObject.optString("apkId"));
        localBundle.putInt(aryv.PARAM_TASK_VERSION, i);
        localBundle.putString(aryv.PARAM_TASK_PACKNAME, localJSONObject.optString("appPackageName"));
        localBundle.putString(aryv.PARAM_VIA, localJSONObject.optString("via"));
        localBundle.putString(aryv.PARAM_APPNAME, localJSONObject.optString("appName"));
        localBundle.putString(aryv.PARAM_CHANNELID, localJSONObject.optString("channelId"));
        localBundle.putString(aryv.cDC, localJSONObject.optString("channel"));
        localBundle.putString(aryv.PARAM_UIN, localJSONObject.optString("uin"));
        this.b = a(localBundle);
        this.b.actionFlag = "2";
        if (aHx())
        {
          a(paramActivity, paramOnClickListener);
          return;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramString = (String)localObject1;
          boolean bool = aryq.aHl();
          localObject1 = new arzp(this, localBundle, bool, paramActivity, str2, paramOnClickListener, str1);
          paramOnClickListener = new arzk.b(paramOnClickListener, str2, str1);
          localObject2 = new arzk.a(str2, str1);
          localBundle.putString(aryv.PARAM_WORDING, paramString);
          a(paramActivity, 1, 1, "0", (DialogInterface.OnClickListener)localObject1, paramOnClickListener, (DialogInterface.OnCancelListener)localObject2, "biz_src_yyb", bool, localBundle);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      paramString = str3 + acfp.m(2131708617);
    }
  }
  
  public boolean b(Context paramContext, Bundle paramBundle)
  {
    arwt.d("TIME-STATISTIC", "MyAppApi--startToWebView");
    if (paramBundle == null) {
      return false;
    }
    paramBundle = paramBundle.getString("url");
    arwt.d("TIME-STATISTIC", "mDownloadSdk.startToAppDetail");
    a().startToWebView(paramContext, paramBundle);
    return true;
  }
  
  protected void bxb()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    arzq localarzq = new arzq(this);
    aroi.a().getContext().registerReceiver(localarzq, localIntentFilter);
  }
  
  public boolean c(Context paramContext, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return false;
    }
    arwt.d("TIME-STATISTIC", "mDownloadSdk.startToDownloadListWithParams");
    a().startToDownloadTaskListWithParams(paramContext, paramBundle);
    return true;
  }
  
  public void cu(Activity paramActivity)
  {
    ThreadManager.getSubThreadHandler().post(new MyAppApi.3(this, paramActivity));
  }
  
  public void cv(Activity paramActivity)
  {
    long l = System.currentTimeMillis() - this.awO;
    arwt.d("MyAppApi", "judgeInstallFlag -- mInstalledFlag = " + this.ddz + "mInstallTime = " + this.awO + " countTime =" + l);
    int i;
    if (this.ddz)
    {
      if ((this.awO != -1L) && (l <= 180000L)) {
        break label334;
      }
      i = 1;
      if (!aHx()) {
        break label401;
      }
      if (aHw()) {
        break label339;
      }
      this.ddA = false;
      label106:
      if ((!this.ddA) && (i == 0))
      {
        if (this.mTaskId != -1L) {
          a().removeDownloadTask(this.mTaskId);
        }
        if (!aryq.aHs()) {
          break label376;
        }
        if (this.jdField_a_of_type_Arzk$d != null)
        {
          if (this.jdField_a_of_type_Arzk$d.dix != 0) {
            break label347;
          }
          a(paramActivity, this.jdField_a_of_type_Arzk$d.y, this.jdField_a_of_type_Arzk$d.autoDownload, this.jdField_a_of_type_Arzk$d.ddH);
        }
      }
    }
    for (;;)
    {
      eml();
      if ((!this.ddC) && (!aHx()))
      {
        paramActivity = aroi.a().getContext().getSharedPreferences("showTost_pf", 0);
        this.ddC = paramActivity.getBoolean("showToast", false);
        this.cDK = paramActivity.getString("toast_msg", "");
      }
      if (this.ddC)
      {
        if (!aHx()) {
          new Handler(Looper.getMainLooper()).postDelayed(new MyAppApi.4(this), 2000L);
        }
        this.ddC = false;
        paramActivity = aroi.a().getContext().getSharedPreferences("showTost_pf", 0).edit();
        paramActivity.putBoolean("showToast", this.ddC);
        paramActivity.commit();
      }
      return;
      label334:
      i = 0;
      break;
      label339:
      this.ddA = true;
      break label106;
      label347:
      a(paramActivity, this.jdField_a_of_type_Arzk$d.y, this.jdField_a_of_type_Arzk$d.autoDownload, this.jdField_a_of_type_Arzk$d.ddH);
      continue;
      label376:
      if ((i != 0) || (this.af == null)) {
        continue;
      }
      this.af.onClick(null, 0);
      continue;
      try
      {
        label401:
        if (new File(aroi.a().getContext().getFilesDir() + File.separator + "yyb_via_info.txt").exists()) {
          aroi.a().getContext().deleteFile("yyb_via_info.txt");
        }
        label461:
        if ((this.ddA) || (i != 0)) {
          continue;
        }
        if (this.mTaskId != -1L) {
          a().removeDownloadTask(this.mTaskId);
        }
        if ((i != 0) || (this.af == null)) {
          continue;
        }
        this.af.onClick(null, 0);
      }
      catch (Exception paramActivity)
      {
        break label461;
      }
    }
  }
  
  public void cw(Activity paramActivity)
  {
    new asaa.a(paramActivity, null).execute(new Void[0]);
  }
  
  public void cx(Activity paramActivity)
  {
    if ((this.ddD) && (this.b != null))
    {
      if (!aHw())
      {
        a();
        if (aHx())
        {
          if (this.mTaskId != -1L) {
            a().removeDownloadTask(this.mTaskId);
          }
          a(paramActivity, null);
        }
      }
      this.ddD = false;
      eml();
      return;
    }
    this.ddD = false;
    this.b = null;
    eml();
  }
  
  public long d(Bundle paramBundle)
  {
    try
    {
      arwt.d("MyAppApi", "--addDownloadTaskFromAppDetail--params = " + paramBundle);
      if (paramBundle == null) {
        return -1L;
      }
      String str = paramBundle.getString("url");
      if (!TextUtils.isEmpty(str))
      {
        if ((str.startsWith("tmast")) || (str.startsWith("tpmast"))) {
          return a().addDownloadTaskFromTmast(paramBundle);
        }
        long l = a().addDownloadTaskFromWebview(paramBundle);
        return l;
      }
    }
    catch (Exception paramBundle)
    {
      paramBundle.printStackTrace();
    }
    return -1L;
  }
  
  public void emi()
  {
    if (getApiLevel() <= 2) {}
    for (this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB = TMAssistantCallYYB_V1.getInstance();; this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB = TMAssistantCallYYB_V2.getInstance())
    {
      this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.initTMAssistantCallYYBApi(aroi.a().getContext());
      registerListener();
      return;
    }
  }
  
  public void emj()
  {
    this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB = TMAssistantCallYYB_V2.getInstance();
    this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.initTMAssistantCallYYBApi(aroi.a().getContext());
    registerListener();
  }
  
  protected void eml()
  {
    arwt.d("MyAppApi", "clearInstallParam");
    this.af = null;
    this.jdField_a_of_type_Arzk$d = null;
    this.ddz = false;
    this.ddA = false;
    this.c = null;
  }
  
  public void emm()
  {
    this.awQ = 0L;
  }
  
  public void g(Activity paramActivity, String paramString1, String paramString2)
  {
    if (!"biz_src_yyb".equals(paramString2))
    {
      long l2 = aryq.ie();
      l1 = l2;
      if (l2 > 0L) {}
    }
    for (long l1 = 2000L;; l1 = 0L)
    {
      ThreadManager.getSubThreadHandler().postDelayed(new MyAppApi.17(this, paramActivity, paramString1), l1);
      return;
    }
  }
  
  public void g(Activity paramActivity, String paramString, boolean paramBoolean)
  {
    ThreadManager.getSubThreadHandler().postDelayed(new MyAppApi.19(this, paramBoolean, paramActivity, paramString), 0L);
  }
  
  public int getApiLevel()
  {
    int i = TMAssistantCallYYB_V1.getQQDownloadApiLevel(aroi.a().getContext());
    if (!aewh.g("com.tencent.android.qqdownloader", BaseActivity.sTopActivity)) {
      i = 3;
    }
    return i;
  }
  
  public void onDestroy()
  {
    try
    {
      this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.unregisterListener(this.jdField_a_of_type_ComTencentTmassistantsdkITMAssistantCallBackListener);
      this.jdField_a_of_type_ComTencentTmassistantsdkInternalOpenSDKTMAssistantBaseCallYYB.destroyQQDownloaderOpenSDK();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          jdField_a_of_type_Arzk = null;
          return;
        }
        finally {}
        localException = localException;
        arwt.d("MyAppApi", "onDestroy>>>", localException);
      }
    }
  }
  
  public void r(Activity paramActivity, String paramString, int paramInt)
  {
    arwt.d("MyAppApi", "downloadYyb");
    if (paramInt == 1) {
      aryr.cancelNotification("_1101070898");
    }
    if (this.jdField_a_of_type_Arzk$f == null)
    {
      this.jdField_a_of_type_Arzk$f = new arzk.f();
      aryy.a().a(this.jdField_a_of_type_Arzk$f);
    }
    Object localObject = aryy.a().c("1101070898");
    arwt.d("MyAppApi", "---startDownloadYYB---");
    if (localObject != null)
    {
      if (paramInt == 1)
      {
        ((DownloadInfo)localObject).isAutoInstall = false;
        ((DownloadInfo)localObject).ddi = true;
      }
      for (((DownloadInfo)localObject).from = 1;; ((DownloadInfo)localObject).from = 0)
      {
        ((DownloadInfo)localObject).via = paramString;
        aryy.a().j((DownloadInfo)localObject);
        aryy.a().b((DownloadInfo)localObject);
        return;
        ((DownloadInfo)localObject).isAutoInstall = true;
        ((DownloadInfo)localObject).ddi = false;
      }
    }
    String str = aryq.DB();
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "https://a.app.qq.com/o/myapp-down?g_f=991310";
    }
    a(paramActivity, (String)localObject, paramString, paramInt, false);
  }
  
  protected void registerListener()
  {
    a().registerListener(this.jdField_a_of_type_ComTencentTmassistantsdkITMAssistantCallBackListener);
  }
  
  public class a
    implements DialogInterface.OnCancelListener
  {
    String appId;
    String cDN;
    
    public a(String paramString1, String paramString2)
    {
      this.cDN = arxt.cj(paramString1, "NEWYYB");
      this.appId = paramString2;
    }
    
    public void onCancel(DialogInterface paramDialogInterface)
    {
      arzk.this.Xs(this.appId);
      arxt.br("720", this.cDN, this.appId);
    }
  }
  
  public class b
    implements DialogInterface.OnClickListener
  {
    DialogInterface.OnClickListener Q;
    String appId;
    String cDN;
    
    public b(DialogInterface.OnClickListener paramOnClickListener, String paramString1, String paramString2)
    {
      this.Q = paramOnClickListener;
      this.cDN = arxt.cj(paramString1, "NEWYYB");
      this.appId = paramString2;
    }
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      if (this.Q != null) {
        this.Q.onClick(paramDialogInterface, paramInt);
      }
      arzk.this.af = null;
      arzk.this.a = null;
      arxt.br("710", this.cDN, this.appId);
    }
  }
  
  public class c
    extends asaa.a
  {
    arzk.d b;
    
    public c(Activity paramActivity, arzk.d paramd)
    {
      super();
      this.b = paramd;
    }
    
    protected void onCancelled()
    {
      super.onCancelled();
      if (this.b.t != null) {
        this.b.t.onClick(null, 0);
      }
    }
    
    protected void onPostExecute(Boolean paramBoolean)
    {
      emo();
      if (paramBoolean.booleanValue())
      {
        if (asaa.aHC())
        {
          arzk.this.ddz = true;
          arzk.this.ddA = false;
          long l = -1L;
          switch (this.b.dix)
          {
          case 1: 
          default: 
            l = arzk.this.a(this.b.y, this.b.autoDownload, this.b.ddH);
          }
          for (;;)
          {
            arzk.this.mTaskId = l;
            arzk.this.awO = System.currentTimeMillis();
            if ((paramBoolean.booleanValue()) && (this.b.y != null))
            {
              paramBoolean = arxt.cj(this.b.y.getString(aryv.PARAM_VIA), "NEWYYB");
              arxt.br("311", paramBoolean, this.b.y.getString(aryv.PARAM_SNG_APPID));
              Context localContext = aroi.a().getContext();
              if (localContext != null) {
                arxt.w(localContext, "312", paramBoolean, this.b.y.getString(aryv.PARAM_SNG_APPID));
              }
            }
            if ((arzk.this.a != null) && (arzk.this.a.isShowing())) {
              arzk.this.a.dismiss();
            }
            return;
            arzk.this.ddD = true;
            if (arzk.this.b != null)
            {
              l = arzk.this.a().addDownloadTaskFromAuthorize(arzk.this.b, "2");
            }
            else
            {
              arwt.e("MyAppApi", "CopyAndInstallTask->onPostExecute mLastAuthorizeParam = null");
              continue;
              l = arzk.this.b(this.b.y, this.b.autoDownload, this.b.ddH);
              continue;
              l = arzk.this.d(this.b.y);
            }
          }
        }
        if (this.b.t != null) {
          this.b.t.onClick(null, 0);
        }
        arzk.this.af = null;
        return;
      }
      if (this.b.t != null) {
        this.b.t.onClick(null, 0);
      }
      arzk.this.af = null;
    }
  }
  
  public class d
  {
    public boolean autoDownload;
    public boolean ddH;
    public int dix;
    public DialogInterface.OnClickListener t;
    public Bundle y;
    
    public d() {}
  }
  
  public class e
    implements ITMAssistantCallBackListener
  {
    protected e() {}
    
    public void onDownloadTaskProgressChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, long paramLong1, long paramLong2)
    {
      arzk.a(arzk.this, true);
      arwt.i("MyAppApi", "onDownloadTaskProgressChanged  receiveDataLen:" + paramLong1 + ",totalDataLen:" + paramLong2);
      int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
      aryy localaryy = aryy.a();
      DownloadInfo localDownloadInfo2 = localaryy.c(paramTMAssistantCallYYBParamStruct.SNGAppId);
      DownloadInfo localDownloadInfo1 = localDownloadInfo2;
      if (localDownloadInfo2 == null)
      {
        localDownloadInfo1 = arzk.this.a(paramTMAssistantCallYYBParamStruct, null);
        localaryy.j(localDownloadInfo1);
      }
      localDownloadInfo1.progress = i;
      localDownloadInfo1.setState(2);
      localaryy.b(2, localDownloadInfo1);
      arvv.a().a(paramTMAssistantCallYYBParamStruct, i);
      arwt.v("MyAppApi", "onDownloadTaskProgressChanged info state=" + localDownloadInfo1.getState() + " progress=" + localDownloadInfo1.progress);
    }
    
    public void onDownloadTaskStateChanged(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt1, int paramInt2, String paramString)
    {
      arzk.this.ddA = true;
      arzk.a(arzk.this, true);
      arwt.i("MyAppApi", "onDownloadTaskStateChanged");
      ThreadManager.getSubThreadHandler().post(new MyAppApi.QQDownloadListener.1(this, paramTMAssistantCallYYBParamStruct, paramInt1, paramInt2, paramString));
    }
    
    public void onQQDownloaderInvalid()
    {
      arwt.i("MyAppApi", acfp.m(2131708616));
      ThreadManager.getSubThreadHandler().post(new MyAppApi.QQDownloadListener.2(this));
    }
    
    public void onServiceFree()
    {
      arwt.i("MyAppApi", "OnServiceFree");
      try
      {
        ((TMAssistantCallYYB_V2)arzk.this.a).releaseIPCConnected();
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  public class f
    implements aryx
  {
    protected f() {}
    
    public void installSucceed(String paramString1, String paramString2)
    {
      if ((paramString1.equals("1101070898")) && (paramString2.equals("com.tencent.android.qqdownloader")))
      {
        if ((arzk.this.jdField_a_of_type_Arzs != null) && (arzk.this.jdField_a_of_type_Arzs.isShowing())) {
          arzk.this.jdField_a_of_type_Arzs.dismiss();
        }
        aryy.a().b(arzk.this.jdField_a_of_type_Arzk$f);
        arzk.this.jdField_a_of_type_Arzk$f = null;
      }
    }
    
    public void onDownloadCancel(DownloadInfo paramDownloadInfo)
    {
      if ((paramDownloadInfo != null) && (paramDownloadInfo.appId.equals("1101070898")))
      {
        arwt.d("MyAppApi", "onDownloadCancel");
        if ((arzk.this.jdField_a_of_type_Arzs != null) && (arzk.this.jdField_a_of_type_Arzs.isShowing()) && (arzk.this.ddB)) {
          arzk.this.jdField_a_of_type_Arzs.iq(paramDownloadInfo.progress, paramDownloadInfo.getState());
        }
        aryy.a().b(arzk.this.jdField_a_of_type_Arzk$f);
        arzk.this.jdField_a_of_type_Arzk$f = null;
      }
    }
    
    public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
    {
      if ((paramDownloadInfo != null) && (paramDownloadInfo.appId.equals("1101070898")))
      {
        arwt.d("MyAppApi", "onDownloadError");
        if ((paramDownloadInfo.progress != 100) && (paramDownloadInfo.state != 4)) {
          break label46;
        }
        onDownloadFinish(paramDownloadInfo);
      }
      label46:
      while ((arzk.this.jdField_a_of_type_Arzs == null) || (!arzk.this.jdField_a_of_type_Arzs.isShowing()) || (!arzk.this.ddB)) {
        return;
      }
      arzk.this.jdField_a_of_type_Arzs.iq(paramDownloadInfo.progress, paramDownloadInfo.getState());
    }
    
    public void onDownloadFinish(DownloadInfo paramDownloadInfo)
    {
      label213:
      long l2;
      long l1;
      if ((paramDownloadInfo != null) && (paramDownloadInfo.appId.equals("1101070898")))
      {
        if (!arzk.a(arzk.this)) {
          break label384;
        }
        UpgradeDetailWrapper localUpgradeDetailWrapper = aqap.a().b();
        if ((localUpgradeDetailWrapper != null) && (localUpgradeDetailWrapper.a != null))
        {
          aqma.SJ(true);
          aqma.XA(localUpgradeDetailWrapper.a.dYn);
          aqai.ecP();
          arwt.d("NewUpgradeDialog", "pre download success state saved!");
        }
        arwt.d("MyAppApi", "onDownloadFinish");
        if ((arzk.this.jdField_a_of_type_Arzs != null) && (arzk.this.jdField_a_of_type_Arzs.isShowing()) && (arzk.this.ddB)) {
          arzk.this.jdField_a_of_type_Arzs.iq(100, 4);
        }
        arwt.d("MyAppApi", "mInstallParam: " + arzk.this.jdField_a_of_type_Arzk$d);
        if (arzk.this.jdField_a_of_type_Arzk$d != null)
        {
          if (!arzk.this.jdField_a_of_type_Arzk$d.ddH) {
            break label411;
          }
          ThreadManager.getSubThreadHandler().postDelayed(new MyAppApi.YYBDownloadListener.1(this, paramDownloadInfo), 500L);
          arzk.this.ddz = true;
          arzk.this.ddA = false;
          l2 = 0L;
          l1 = l2;
          switch (arzk.this.jdField_a_of_type_Arzk$d.dix)
          {
          case 1: 
          default: 
            l1 = arzk.this.a(arzk.this.jdField_a_of_type_Arzk$d.y, arzk.this.jdField_a_of_type_Arzk$d.autoDownload, arzk.this.jdField_a_of_type_Arzk$d.ddH);
          }
        }
      }
      for (;;)
      {
        arzk.this.mTaskId = l1;
        arzk.this.awO = System.currentTimeMillis();
        aryy.a().b(arzk.this.jdField_a_of_type_Arzk$f);
        arzk.this.jdField_a_of_type_Arzk$f = null;
        if (("ANDROID.QQ.YYBXZGAMECENTER".equals(paramDownloadInfo.via)) || ("ANDROID.QQ.NEWYYBXZGAMECENTER".equals(paramDownloadInfo.via))) {
          tbb.a(null, "765", "205011", paramDownloadInfo.appId, "76501", "1", "156");
        }
        return;
        label384:
        anot.a(null, "dc00898", "", "", "0X8008F7E", "0X8008F7E", 0, 0, "", "", "", "");
        break;
        label411:
        if ((arxn.Ni() != 1) || (!aryq.aHn())) {
          break label213;
        }
        ThreadManager.getSubThreadHandler().postDelayed(new MyAppApi.YYBDownloadListener.2(this, paramDownloadInfo), 500L);
        arzk.this.ddz = true;
        arzk.this.ddA = false;
        break label213;
        arzk.this.ddD = true;
        if (arzk.this.b != null)
        {
          l1 = arzk.this.a().addDownloadTaskFromAuthorize(arzk.this.b, "2");
        }
        else
        {
          arwt.e("MyAppApi", "CopyAndInstallTask->onPostExecute mLastAuthorizeParam = null");
          l1 = l2;
          continue;
          l1 = arzk.this.b(arzk.this.jdField_a_of_type_Arzk$d.y, arzk.this.jdField_a_of_type_Arzk$d.autoDownload, arzk.this.jdField_a_of_type_Arzk$d.ddH);
          continue;
          l1 = arzk.this.d(arzk.this.jdField_a_of_type_Arzk$d.y);
        }
      }
    }
    
    public void onDownloadPause(DownloadInfo paramDownloadInfo)
    {
      if ((paramDownloadInfo != null) && (paramDownloadInfo.appId.equals("1101070898")))
      {
        arwt.d("MyAppApi", "onDownloadPause");
        if ((arzk.this.jdField_a_of_type_Arzs != null) && (arzk.this.jdField_a_of_type_Arzs.isShowing()) && (arzk.this.ddB)) {
          arzk.this.jdField_a_of_type_Arzs.iq(paramDownloadInfo.progress, paramDownloadInfo.getState());
        }
      }
    }
    
    public void onDownloadUpdate(List<DownloadInfo> paramList)
    {
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
          if (localDownloadInfo.appId.equals("1101070898"))
          {
            arwt.d("MyAppApi", "onDownloadUpdate STATE = " + localDownloadInfo.getState());
            if ((arzk.this.jdField_a_of_type_Arzs != null) && (arzk.this.jdField_a_of_type_Arzs.isShowing()) && (arzk.this.ddB)) {
              arzk.this.jdField_a_of_type_Arzs.iq(localDownloadInfo.progress, localDownloadInfo.getState());
            }
          }
        }
      }
    }
    
    public void onDownloadWait(DownloadInfo paramDownloadInfo)
    {
      if ((paramDownloadInfo != null) && (paramDownloadInfo.appId.equals("1101070898")))
      {
        arwt.d("MyAppApi", "onDownloadWait");
        if ((arzk.this.jdField_a_of_type_Arzs != null) && (arzk.this.jdField_a_of_type_Arzs.isShowing()) && (arzk.this.ddB)) {
          arzk.this.jdField_a_of_type_Arzs.iq(paramDownloadInfo.progress, paramDownloadInfo.getState());
        }
      }
    }
    
    public void packageReplaced(String paramString1, String paramString2) {}
    
    public void uninstallSucceed(String paramString1, String paramString2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arzk
 * JD-Core Version:    0.7.0.1
 */