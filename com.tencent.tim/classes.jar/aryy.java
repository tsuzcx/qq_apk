import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.img.ImageCache;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager.1;
import com.tencent.open.downloadnew.DownloadManager.11;
import com.tencent.open.downloadnew.DownloadManager.12;
import com.tencent.open.downloadnew.DownloadManager.13;
import com.tencent.open.downloadnew.DownloadManager.14;
import com.tencent.open.downloadnew.DownloadManager.15;
import com.tencent.open.downloadnew.DownloadManager.17;
import com.tencent.open.downloadnew.DownloadManager.18;
import com.tencent.open.downloadnew.DownloadManager.2;
import com.tencent.open.downloadnew.DownloadManager.20;
import com.tencent.open.downloadnew.DownloadManager.21;
import com.tencent.open.downloadnew.DownloadManager.3;
import com.tencent.open.downloadnew.DownloadManager.4;
import com.tencent.open.downloadnew.DownloadManager.6;
import com.tencent.open.downloadnew.DownloadManager.7;
import com.tencent.open.downloadnew.DownloadManager.8;
import com.tencent.open.downloadnew.DownloadManager.9;
import com.tencent.open.downloadnew.common.PackageInstallReceiver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.ITMAssistantDownloadLogListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import com.tencent.tmdownloader.TMAssistantDownloadSettingClient;
import cooperation.qappcenter.QAppCenterPluginProxyActivityTools;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.os.MqqHandler;

public class aryy
{
  public static final String DOWNLOAD_PATH = File.separator + "tencent" + File.separator + ".qqdownload" + File.separator;
  protected static aryy a;
  protected static final byte[] ho = new byte[1];
  private arzg a;
  protected PackageInstallReceiver a;
  public ITMAssistantDownloadLogListener a;
  protected long awD;
  protected long awE;
  private aryo jdField_b_of_type_Aryo = new arzc(this);
  private aryp jdField_b_of_type_Aryp;
  public ITMAssistantDownloadClientListener b;
  protected TMAssistantDownloadClient c;
  public boolean ddk;
  protected boolean ddy;
  protected final int elc = 1000;
  protected WeakReference<AppInterface> iN;
  public ConcurrentHashMap<String, DownloadInfo> jn = new ConcurrentHashMap();
  protected ConcurrentLinkedQueue<aryx> listeners = new ConcurrentLinkedQueue();
  protected String mClientKey = "";
  
  protected aryy()
  {
    this.jdField_b_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener = new arze(this);
    this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadLogListener = new arzd(this);
    arwt.d("DownloadManager_", "DownloadManager create QQ5.0");
    this.jdField_a_of_type_Arzg = arzg.a();
    this.jdField_a_of_type_ComTencentOpenDownloadnewCommonPackageInstallReceiver = new PackageInstallReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addDataScheme("package");
    localIntentFilter.addAction("android.intent.action.PACKAGE_ADDED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
    localIntentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
    aroi.a().getContext().registerReceiver(this.jdField_a_of_type_ComTencentOpenDownloadnewCommonPackageInstallReceiver, localIntentFilter);
    asae.a().a(ThreadManager.getSubThreadHandler().getLooper());
    a(arzy.a());
    a(asae.a());
    ThreadManager.excute(new DownloadManager.2(this), 32, null, true);
  }
  
  /* Error */
  public static boolean PN()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 194	aryy:jdField_a_of_type_Aryy	Laryy;
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
    //   6	2	1	localaryy	aryy
    //   23	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	23	finally
  }
  
  /* Error */
  public static aryy a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 194	aryy:jdField_a_of_type_Aryy	Laryy;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnonnull +33 -> 41
    //   11: new 2	aryy
    //   14: dup
    //   15: invokespecial 199	aryy:<init>	()V
    //   18: putstatic 194	aryy:jdField_a_of_type_Aryy	Laryy;
    //   21: getstatic 194	aryy:jdField_a_of_type_Aryy	Laryy;
    //   24: ldc 201
    //   26: putfield 71	aryy:mClientKey	Ljava/lang/String;
    //   29: getstatic 194	aryy:jdField_a_of_type_Aryy	Laryy;
    //   32: invokevirtual 204	aryy:eme	()V
    //   35: getstatic 194	aryy:jdField_a_of_type_Aryy	Laryy;
    //   38: invokevirtual 207	aryy:elS	()V
    //   41: getstatic 194	aryy:jdField_a_of_type_Aryy	Laryy;
    //   44: astore_0
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload_0
    //   49: areturn
    //   50: astore_0
    //   51: aload_0
    //   52: invokevirtual 210	java/lang/Exception:printStackTrace	()V
    //   55: goto -14 -> 41
    //   58: astore_0
    //   59: ldc 2
    //   61: monitorexit
    //   62: aload_0
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	43	0	localaryy	aryy
    //   50	2	0	localException	Exception
    //   58	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	41	50	java/lang/Exception
    //   3	7	58	finally
    //   11	41	58	finally
    //   41	48	58	finally
    //   51	55	58	finally
    //   59	62	58	finally
  }
  
  private void a(DownloadInfo paramDownloadInfo, String paramString1, String paramString2)
  {
    if ((paramDownloadInfo.state != 4) && (paramDownloadInfo.isAutoInstallBySDK))
    {
      arwt.i("DownloadManager_", "isAutoInstallBySDK is true");
      if (TextUtils.isEmpty(paramString1)) {
        break label29;
      }
    }
    label29:
    label217:
    for (;;)
    {
      return;
      if (new File(paramString1).exists())
      {
        boolean bool = arxn.d(aroi.a().getContext(), paramString1, paramDownloadInfo.source, paramDownloadInfo.qH("big_brother_ref_source_key"));
        arub.a().a(100, paramDownloadInfo);
        for (;;)
        {
          if ((!bool) || (!paramString2.equals("com.tencent.android.qqdownloader")) || (!paramDownloadInfo.appId.equals("1101070898"))) {
            break label217;
          }
          arwt.v("DownloadManager_", "report yyb start install");
          String str = arxt.cj(paramDownloadInfo.via, "NEWYYB");
          arzk.a().emj();
          paramString2 = arzk.a().DC();
          paramString1 = paramString2;
          if (TextUtils.isEmpty(paramString2)) {
            paramString1 = paramDownloadInfo.appId;
          }
          arxt.X("311", str, paramString1, paramDownloadInfo.extraData);
          paramDownloadInfo = aroi.a().getContext();
          if (paramDownloadInfo == null) {
            break;
          }
          arxt.w(paramDownloadInfo, "312", str, paramString1);
          return;
          bool = arxn.d(aroi.a().getContext(), paramString1, paramDownloadInfo.source, paramDownloadInfo.qH("big_brother_ref_source_key"));
          arub.a().a(100, paramDownloadInfo);
        }
      }
    }
  }
  
  private void dI(Bundle paramBundle)
  {
    arwt.d("DownloadManager_", "receive write code msg......");
    if (paramBundle == null)
    {
      arwt.d("DownloadManager_", "receive write code msg but data is null......");
      return;
    }
    ThreadManager.excute(new DownloadManager.21(this, paramBundle), 32, null, true);
  }
  
  private void h(DownloadInfo paramDownloadInfo)
  {
    arwt.d("DownloadManager_", ">>startDownload downloadInfo:" + paramDownloadInfo);
    if (paramDownloadInfo.ddw) {
      ImageCache.a("app", arwr.aN(paramDownloadInfo.appId, 100), new aryz(this, paramDownloadInfo));
    }
    DownloadInfo localDownloadInfo = c(paramDownloadInfo.appId);
    Object localObject;
    if (localDownloadInfo != null) {
      if (a(localDownloadInfo, paramDownloadInfo))
      {
        localObject = localDownloadInfo;
        arwt.v("DownloadManager_", "startDownload() downloadInfo != null>>>downloadInfo.url=" + paramDownloadInfo.urlStr + "downloadInfo.isAutoInstall" + paramDownloadInfo.isAutoInstall + "+++++downloadInfo.downloadType=" + paramDownloadInfo.updateType + "  test" + c(paramDownloadInfo.appId));
        label155:
        j((DownloadInfo)localObject);
        if (("com.tencent.mobileqq".equals(((DownloadInfo)localObject).packageName)) && (isMainProcess())) {
          o((DownloadInfo)localObject);
        }
        if (((DownloadInfo)localObject).updateType != 1) {
          break label515;
        }
      }
    }
    label515:
    for (String str = ((DownloadInfo)localObject).cDF;; str = ((DownloadInfo)localObject).urlStr)
    {
      int i = ((DownloadInfo)localObject).updateType;
      HashMap localHashMap = new HashMap();
      localHashMap.put(TMAssistantDownloadConst.PARAM_APPID, ((DownloadInfo)localObject).appId);
      localHashMap.put(TMAssistantDownloadConst.PARAM_TASK_PACKNAME, ((DownloadInfo)localObject).packageName);
      localHashMap.put(TMAssistantDownloadConst.PARAM_TASK_VERSION, String.valueOf(((DownloadInfo)localObject).versionCode));
      localHashMap.put(TMAssistantDownloadConst.PARAM_VIA, ((DownloadInfo)localObject).via);
      localHashMap.put(TMAssistantDownloadConst.PARAM_UIN_TYPE, String.valueOf("qqNumber"));
      localHashMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, String.valueOf(2));
      localHashMap.put(TMAssistantDownloadConst.PARAM_ICON_URL, ((DownloadInfo)localObject).iconUrl);
      localHashMap.put(TMAssistantDownloadConst.PARAM_APP_NAME, ((DownloadInfo)localObject).pushTitle);
      localHashMap.put(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION, String.valueOf(((DownloadInfo)localObject).ell));
      localHashMap.put(TMAssistantDownloadConst.PARAM_IS_AUTOINSTALL_BY_SDK, String.valueOf(((DownloadInfo)localObject).isAutoInstallBySDK));
      localHashMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADSIZE, String.valueOf(((DownloadInfo)localObject).fileSize));
      ThreadManager.getSubThreadHandler().post(new DownloadManager.11(this, str, localHashMap, i, (DownloadInfo)localObject, localDownloadInfo, paramDownloadInfo));
      try
      {
        arvu.a((AppInterface)this.iN.get(), (DownloadInfo)localObject);
        return;
      }
      catch (Throwable paramDownloadInfo) {}
      localObject = paramDownloadInfo;
      break;
      localObject = "900";
      if (paramDownloadInfo.ekZ == 12) {
        localObject = "2000";
      }
      arxt.X((String)localObject, paramDownloadInfo.via, paramDownloadInfo.appId, paramDownloadInfo.extraData);
      arwt.v("DownloadManager_", "+++++startDownload()+++++ downloadInfo == null>>>downloadInfo.url=" + paramDownloadInfo.urlStr + "+++++downloadInfo.downloadType=" + paramDownloadInfo.updateType);
      localObject = paramDownloadInfo;
      break label155;
    }
  }
  
  private void i(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManager.15(this, paramDownloadInfo));
  }
  
  public static int kO(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 1;
    case 1: 
      return 20;
    case 2: 
      return 2;
    case 4: 
      return 4;
    case 3: 
      return 3;
    case 6: 
      return 10;
    }
    return -2;
  }
  
  private void p(DownloadInfo paramDownloadInfo)
  {
    arwt.d("DownloadManager_", "receive get code msg......");
    if (paramDownloadInfo == null)
    {
      arwt.d("DownloadManager_", "receive get code msg but info is null......");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new DownloadManager.20(this, paramDownloadInfo));
  }
  
  public void A(DownloadInfo paramDownloadInfo)
  {
    arwt.d("DownloadManager_", "patchNewApkSuccess DownloadInfo|" + paramDownloadInfo);
    p(paramDownloadInfo);
  }
  
  public void Un(boolean paramBoolean)
  {
    Object localObject1 = this.jn.values().iterator();
    int i = 0;
    String str = "";
    Object localObject2 = new ArrayList();
    if (((Iterator)localObject1).hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)((Iterator)localObject1).next();
      if ((localDownloadInfo == null) || (localDownloadInfo.state == 4) || (localDownloadInfo.state == 1) || (localDownloadInfo.downloadType != 1)) {
        break label293;
      }
      ((ArrayList)localObject2).add(localDownloadInfo);
      if ((!TextUtils.isEmpty(str)) || (arxn.appIsExists(localDownloadInfo.packageName))) {
        break label290;
      }
      str = localDownloadInfo.pushTitle;
      label117:
      i += 1;
    }
    label273:
    label290:
    label293:
    for (;;)
    {
      break;
      if (((ArrayList)localObject2).size() > 0)
      {
        localObject1 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (DownloadInfo)((Iterator)localObject1).next();
          ((DownloadInfo)localObject2).setState(10);
          b(10, (DownloadInfo)localObject2);
        }
      }
      boolean bool = QAppCenterPluginProxyActivityTools.ddT;
      if ((paramBoolean) && (i > 0))
      {
        localObject1 = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
          break label273;
        }
      }
      for (str = str + acfp.m(2131705284);; str = "")
      {
        str = str + i + acfp.m(2131705271);
        if (!bool) {
          break;
        }
        arxa.a().showToast(str, 1);
        return;
      }
      arzk.a().aU(true, str);
      return;
      break label117;
    }
  }
  
  public DownloadInfo a(String paramString, int paramInt)
  {
    paramString = e(paramString);
    if ((paramString != null) && (paramInt != -2)) {
      paramString.setState(paramInt);
    }
    return paramString;
  }
  
  public TMAssistantDownloadTaskInfo a(DownloadInfo paramDownloadInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString(aryv.PARAM_SNG_APPID, paramDownloadInfo.appId);
    localBundle.putString(aryv.PARAM_TASK_APPID, paramDownloadInfo.cDG);
    localBundle.putString(aryv.PARAM_TASK_APK_ID, paramDownloadInfo.cCL);
    localBundle.putString(aryv.PARAM_TASK_PACKNAME, paramDownloadInfo.packageName);
    localBundle.putInt(aryv.PARAM_TASK_VERSION, paramDownloadInfo.versionCode);
    localBundle.putString(aryv.PARAM_VIA, paramDownloadInfo.via);
    try
    {
      arwt.v("State_Log", "OpenSDK getTaskInfoFromMyApp param SNGAppId=" + paramDownloadInfo.appId + " apkId=" + paramDownloadInfo.cCL + " taskAppId=" + paramDownloadInfo.cDG + " packageName=" + paramDownloadInfo.packageName + " version=" + paramDownloadInfo.versionCode + " via=" + paramDownloadInfo.via);
      paramDownloadInfo = arzk.a().a(localBundle);
      if (paramDownloadInfo != null) {}
      try
      {
        arwt.v("State_Log", "OpenSDK getTaskInfoFromMyApp result taskInfo path=" + paramDownloadInfo.mSavePath + " state=" + paramDownloadInfo.mState);
        return paramDownloadInfo;
      }
      catch (Exception localException1) {}
      arwt.v("State_Log", "OpenSDK getTaskInfoFromMyApp result taskInfo is null");
      return paramDownloadInfo;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        paramDownloadInfo = null;
      }
    }
    arwt.d("DownloadManager_", "getTaskInfoFromMyApp>>>", localException1);
    return paramDownloadInfo;
  }
  
  public void a(int paramInt1, DownloadInfo paramDownloadInfo, int paramInt2, String paramString)
  {
    if (paramDownloadInfo == null) {}
    for (;;)
    {
      try
      {
        arwt.e("DownloadManager_", "notifyListener info == null id=" + paramInt1);
        return;
      }
      finally {}
      switch (paramInt1)
      {
      default: 
        break;
      case -2: 
        a(paramDownloadInfo, paramInt2, paramString);
        break;
      case 20: 
        arwt.v("DownloadManager_", acfp.m(2131705287) + this.listeners.size());
        paramString = this.listeners.iterator();
        while (paramString.hasNext()) {
          ((aryx)paramString.next()).onDownloadWait(paramDownloadInfo);
        }
      case 3: 
        arwt.v("DownloadManager_", acfp.m(2131705278) + this.listeners.size());
        paramString = this.listeners.iterator();
        while (paramString.hasNext()) {
          ((aryx)paramString.next()).onDownloadPause(paramDownloadInfo);
        }
      case 4: 
        arwt.v("DownloadManager_", acfp.m(2131705283) + this.listeners.size());
        paramString = this.listeners.iterator();
        while (paramString.hasNext()) {
          ((aryx)paramString.next()).onDownloadFinish(paramDownloadInfo);
        }
        arvu.a(2, null, 100, paramDownloadInfo);
        break;
      case 10: 
        arwt.v("DownloadManager_", acfp.m(2131705285) + this.listeners.size());
        this.jn.remove(paramDownloadInfo.appId);
        asac.a().Xv(paramDownloadInfo.appId);
        asab.a().Xt(paramDownloadInfo.sendTime);
        paramDownloadInfo.setState(10);
        arwt.v("DownloadManager_", "downloadInfo.state = " + paramDownloadInfo.getState());
        paramString = this.listeners.iterator();
        while (paramString.hasNext()) {
          ((aryx)paramString.next()).onDownloadCancel(paramDownloadInfo);
        }
      case 2: 
        if ((paramDownloadInfo.downloadType == 1) || (System.currentTimeMillis() - this.awD > 1000L))
        {
          this.awD = System.currentTimeMillis();
          arwt.v("DownloadManager_", acfp.m(2131705270) + this.listeners.size());
          paramDownloadInfo = ap(2);
          arwt.v("DownloadManager_", acfp.m(2131705277) + paramDownloadInfo.size());
          paramString = this.listeners.iterator();
          while (paramString.hasNext())
          {
            aryx localaryx = (aryx)paramString.next();
            arwt.v("DownloadManager_", "###下载1 listner name" + localaryx.getClass().getName());
            localaryx.onDownloadUpdate(paramDownloadInfo);
          }
        }
        break;
      case 6: 
        arwt.v("DownloadManager_", acfp.m(2131705286) + this.listeners.size());
        paramString = this.listeners.iterator();
        while (paramString.hasNext()) {
          ((aryx)paramString.next()).installSucceed(paramDownloadInfo.appId, paramDownloadInfo.packageName);
        }
      case 13: 
        arwt.v("DownloadManager_", acfp.m(2131705275) + this.listeners.size());
        paramString = this.listeners.iterator();
        while (paramString.hasNext()) {
          ((aryx)paramString.next()).packageReplaced(paramDownloadInfo.appId, paramDownloadInfo.packageName);
        }
      case 9: 
        arwt.v("DownloadManager_", acfp.m(2131705291) + this.listeners.size());
        paramString = this.listeners.iterator();
        while (paramString.hasNext()) {
          ((aryx)paramString.next()).uninstallSucceed(paramDownloadInfo.appId, paramDownloadInfo.packageName);
        }
      }
    }
  }
  
  public void a(aryx paramaryx)
  {
    try
    {
      if (!this.listeners.contains(paramaryx)) {
        this.listeners.add(paramaryx);
      }
      return;
    }
    finally
    {
      paramaryx = finally;
      throw paramaryx;
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt, String paramString)
  {
    this.ddy = false;
    if (paramDownloadInfo == null)
    {
      arwt.w("DownloadManager_", "handleDownloadErrorCallBack info == null code = " + paramInt + " msg = " + paramString);
      return;
    }
    arwt.w("DownloadManager_", "handleDownloadErrorCallBack code = " + paramInt + " msg = " + paramString);
    if ((paramInt >= 400) && (paramInt <= 599)) {}
    for (;;)
    {
      try
      {
        paramString = aroi.a().getContext().getString(2131696634);
      }
      catch (Exception paramDownloadInfo)
      {
        paramDownloadInfo.printStackTrace();
        return;
      }
      paramString = aroi.a().getContext().getString(2131696629);
      int i = 3;
      paramDownloadInfo.setState(i);
      arwt.v("DownloadManager_", acfp.m(2131705282) + this.listeners.size());
      Object localObject = this.listeners.iterator();
      if (((Iterator)localObject).hasNext())
      {
        ((aryx)((Iterator)localObject).next()).onDownloadError(paramDownloadInfo, paramInt, paramString, i);
        continue;
        arwt.v("DownloadManager_", acfp.m(2131705273));
        if ((paramDownloadInfo.packageName != null) && ("com.tencent.mobileqq".equals(paramDownloadInfo.packageName)) && (paramDownloadInfo.updateType != 1) && (isMainProcess()))
        {
          arwt.v("DownloadManager_", acfp.m(2131705274));
          ThreadManager.getSubThreadHandler().post(new DownloadManager.6(this, paramDownloadInfo));
          return;
        }
        paramDownloadInfo.setState(4);
        if (paramDownloadInfo.updateType == 1)
        {
          i(paramDownloadInfo);
          return;
        }
        ThreadManager.excute(new DownloadManager.7(this, paramDownloadInfo), 32, null, true);
        return;
        paramString = aroi.a().getContext().getString(2131696639);
        i = 3;
        continue;
        paramString = aroi.a().getContext().getString(2131696634);
        i = 3;
        continue;
        paramString = aroi.a().getContext().getString(2131696629);
        i = 3;
        continue;
        paramString = aroi.a().getContext().getString(2131696641);
        i = 3;
        continue;
        paramString = aroi.a().getContext().getString(2131696638);
        i = 3;
        continue;
        paramString = aroi.a().getContext().getString(2131696636);
        i = 3;
        continue;
        label459:
        int j;
        if (paramInt == 712)
        {
          localObject = aroi.a().getContext().getString(2131696631);
          j = 10;
          if ((BaseApplicationImpl.getApplication().getRuntime() instanceof AppInterface))
          {
            paramString = ((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getHandler(Conversation.class);
            if ((paramString != null) && (aqap.a().getDownloadState() == 4)) {
              paramString.obtainMessage(1134019).sendToTarget();
            }
          }
          i = j;
          paramString = (String)localObject;
          if (paramDownloadInfo == null) {
            continue;
          }
          if (paramDownloadInfo.updateType != 1) {
            break label597;
          }
        }
        label597:
        for (String str = paramDownloadInfo.cDF;; str = paramDownloadInfo.urlStr)
        {
          i = j;
          paramString = (String)localObject;
          if (str == null) {
            break;
          }
          ThreadManager.excute(new DownloadManager.8(this, str, paramDownloadInfo), 32, null, true);
          i = j;
          paramString = (String)localObject;
          break;
          localObject = aroi.a().getContext().getString(2131696632);
          break label459;
        }
        arwt.v("DownloadManager_", acfp.m(2131705292));
        i = 3;
      }
      else
      {
        if (TextUtils.isEmpty(paramString)) {
          break;
        }
        showToast(paramString);
        return;
        switch (paramInt)
        {
        }
      }
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, long paramLong)
  {
    if ((i() == null) || (i().get() == null)) {}
    while ((AppInterface)i().get() == null) {
      return;
    }
    int i = 14;
    if ("biz_src_yyb".equals(paramDownloadInfo.source)) {}
    for (;;)
    {
      Bundle localBundle1 = null;
      if (!TextUtils.isEmpty(paramDownloadInfo.pushTitle))
      {
        localBundle1 = new Bundle();
        localBundle1.putString("appname", paramDownloadInfo.pushTitle + ".apk");
      }
      arwt.d("DownloadManager_", "reportDownloadResult info.packageName = " + paramDownloadInfo.packageName + ",info.urlStr = " + paramDownloadInfo.urlStr + ",info.filePath = " + paramDownloadInfo.filePath);
      Intent localIntent = new Intent("com.opensdk.downloadmanager.renameFilename");
      Bundle localBundle2 = new Bundle();
      localBundle2.putString("filePath", paramDownloadInfo.filePath);
      localBundle2.putLong("dataLength", paramLong);
      localBundle2.putInt("fileSourceId", i);
      localBundle2.putBundle("otherData", localBundle1);
      localBundle2.putInt("peerType", -1);
      localIntent.putExtra("extraBundle", localBundle2);
      aroi.a().getContext().sendBroadcast(localIntent);
      return;
      if ("biz_src_zf_games".equals(paramDownloadInfo.source)) {
        i = 15;
      } else if ("biz_src_jc_update".equals(paramDownloadInfo.source)) {
        i = 17;
      } else if ("biz_src_news".equals(paramDownloadInfo.source)) {
        i = 18;
      } else if ("biz_src_jc_vip".equals(paramDownloadInfo.source)) {
        i = 40;
      } else {
        i = 40;
      }
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramDownloadInfo == null)
    {
      arwt.d("DownloadManager_", "trafficReport info == null code = " + paramInt);
      return;
    }
    arwt.d("DownloadManager_", "trafficReport code = " + paramInt);
    if ((paramInt >= 400) && (paramInt <= 599)) {
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.awM, "open appstore network error");
    }
    switch (paramInt)
    {
    default: 
      return;
    case -24: 
      a(paramDownloadInfo, 0L, paramLong1 - paramDownloadInfo.awM, "package invalid");
      return;
    case 0: 
    case 5: 
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.awM, "do not need to handle error");
      return;
    case 4: 
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.awM, "DownloadSDK_START_FAILED_EXISTED");
      return;
    case 1: 
    case 601: 
    case 602: 
    case 603: 
    case 605: 
    case 701: 
    case 702: 
    case 706: 
    case 707: 
    case 708: 
    case 709: 
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.awM, "network error");
      return;
    case 3: 
    case 600: 
    case 604: 
    case 700: 
    case 704: 
    case 705: 
      a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.awM, "download error");
      return;
    }
    a(paramDownloadInfo, paramLong1, paramLong1 - paramDownloadInfo.awM, "write file error");
  }
  
  public void a(DownloadInfo paramDownloadInfo, long paramLong1, long paramLong2, String paramString)
  {
    if (paramLong2 > 0L)
    {
      paramDownloadInfo.awM = paramLong1;
      j(paramDownloadInfo);
      j(paramString, paramLong2, paramDownloadInfo.source);
    }
  }
  
  /* Error */
  public void a(DownloadInfo paramDownloadInfo, ApkUpdateDetail paramApkUpdateDetail)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnull +11 -> 14
    //   6: aload_2
    //   7: getfield 946	com/tencent/apkupdate/logic/data/ApkUpdateDetail:updatemethod	I
    //   10: iconst_4
    //   11: if_icmpeq +19 -> 30
    //   14: ldc 102
    //   16: ldc_w 948
    //   19: invokestatic 110	arwt:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: aload_1
    //   24: invokevirtual 950	aryy:b	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: aload_2
    //   31: getfield 953	com/tencent/apkupdate/logic/data/ApkUpdateDetail:url	Ljava/lang/String;
    //   34: astore 5
    //   36: aload_2
    //   37: getfield 956	com/tencent/apkupdate/logic/data/ApkUpdateDetail:patchsize	I
    //   40: i2l
    //   41: lstore_3
    //   42: aload_2
    //   43: getfield 959	com/tencent/apkupdate/logic/data/ApkUpdateDetail:fileMd5	Ljava/lang/String;
    //   46: astore_2
    //   47: ldc 102
    //   49: new 41	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   56: ldc_w 960
    //   59: invokestatic 582	acfp:m	(I)Ljava/lang/String;
    //   62: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: lload_3
    //   66: ldc2_w 961
    //   69: ldiv
    //   70: invokevirtual 965	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   73: ldc_w 967
    //   76: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_2
    //   80: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 969
    //   86: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 5
    //   91: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 110	arwt:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: aload_1
    //   101: aload 5
    //   103: putfield 405	com/tencent/open/downloadnew/DownloadInfo:cDF	Ljava/lang/String;
    //   106: aload_1
    //   107: iconst_1
    //   108: putfield 383	com/tencent/open/downloadnew/DownloadInfo:updateType	I
    //   111: lload_3
    //   112: lconst_0
    //   113: lcmp
    //   114: ifle +8 -> 122
    //   117: aload_1
    //   118: lload_3
    //   119: putfield 476	com/tencent/open/downloadnew/DownloadInfo:fileSize	J
    //   122: aload_0
    //   123: aload_1
    //   124: invokevirtual 950	aryy:b	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   127: goto -100 -> 27
    //   130: astore_2
    //   131: ldc 102
    //   133: ldc_w 971
    //   136: aload_2
    //   137: invokestatic 973	arwt:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   140: aload_0
    //   141: aload_1
    //   142: invokevirtual 950	aryy:b	(Lcom/tencent/open/downloadnew/DownloadInfo;)V
    //   145: goto -118 -> 27
    //   148: astore_1
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_1
    //   152: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	aryy
    //   0	153	1	paramDownloadInfo	DownloadInfo
    //   0	153	2	paramApkUpdateDetail	ApkUpdateDetail
    //   41	78	3	l	long
    //   34	68	5	str	String
    // Exception table:
    //   from	to	target	type
    //   30	111	130	java/lang/Exception
    //   117	122	130	java/lang/Exception
    //   122	127	130	java/lang/Exception
    //   6	14	148	finally
    //   14	27	148	finally
    //   30	111	148	finally
    //   117	122	148	finally
    //   122	127	148	finally
    //   131	145	148	finally
  }
  
  public void a(ITMAssistantDownloadLogListener paramITMAssistantDownloadLogListener)
  {
    if (paramITMAssistantDownloadLogListener == null) {
      if (QLog.isColorLevel()) {
        QLog.i("DownloadManager_", 2, "unregisterLogListener logListener == null");
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("DownloadManager_", 2, "unregisterLogListener");
      }
      try
      {
        if (this.c != null)
        {
          this.c.unRegisterLogListener(paramITMAssistantDownloadLogListener);
          return;
        }
      }
      catch (Exception paramITMAssistantDownloadLogListener)
      {
        arwt.e("DownloadManager_", "unregisterLogListener Exception:", paramITMAssistantDownloadLogListener);
      }
    }
  }
  
  public boolean a(aryp paramaryp)
  {
    if (paramaryp == null) {
      return false;
    }
    this.jdField_b_of_type_Aryp = paramaryp;
    return true;
  }
  
  protected boolean a(DownloadInfo paramDownloadInfo1, DownloadInfo paramDownloadInfo2)
  {
    paramDownloadInfo1.isAutoInstall = paramDownloadInfo2.isAutoInstall;
    paramDownloadInfo1.ddi = paramDownloadInfo2.ddi;
    paramDownloadInfo1.downloadType = paramDownloadInfo2.downloadType;
    paramDownloadInfo1.via = paramDownloadInfo2.via;
    if (!TextUtils.isEmpty(paramDownloadInfo1.urlStr))
    {
      if (!paramDownloadInfo1.urlStr.equals(paramDownloadInfo2.urlStr))
      {
        dx(paramDownloadInfo2.appId, false);
        return false;
      }
    }
    else {
      paramDownloadInfo1.urlStr = paramDownloadInfo2.urlStr;
    }
    return true;
  }
  
  protected List<DownloadInfo> ap(int paramInt)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jn.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if (localDownloadInfo.getState() == paramInt) {
          localArrayList.add(localDownloadInfo);
        }
      }
    }
    finally {}
    return localList;
  }
  
  public int b(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return -30;
    }
    if (this.jdField_b_of_type_Aryp != null) {
      return this.jdField_b_of_type_Aryp.a(paramDownloadInfo.packageName, paramDownloadInfo.versionCode, paramDownloadInfo.filePath, null);
    }
    this.jdField_b_of_type_Aryp = null;
    return -40;
  }
  
  public DownloadInfo b(String paramString, int paramInt)
  {
    paramString = c(paramString);
    if (paramString != null)
    {
      int i = paramInt;
      if (paramInt == -2) {
        i = 3;
      }
      paramString.setState(i);
    }
    return paramString;
  }
  
  public TMAssistantDownloadTaskInfo b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo = b().getDownloadTaskState(paramString);
        if (localTMAssistantDownloadTaskInfo == null) {
          arwt.v("DownloadManager_", "getTaskInfoFromSDK null url=" + paramString);
        }
        return localTMAssistantDownloadTaskInfo;
      }
      catch (Exception localException)
      {
        arwt.e("DownloadManager_", "downloadSDKClient>>>", localException);
      }
      Object localObject = null;
    }
  }
  
  public TMAssistantDownloadClient b()
  {
    TMAssistantDownloadManager.getInstance(aroi.a().getContext()).getDownloadSDKClient(this.mClientKey).registerDownloadTaskListener(this.jdField_b_of_type_ComTencentTmdownloaderITMAssistantDownloadClientListener);
    if (QLog.isColorLevel())
    {
      QLog.i("DownloadManager_", 2, "registerLogListener!");
      TMAssistantDownloadManager.getInstance(aroi.a().getContext()).getDownloadSDKClient(this.mClientKey).registerLogListener(this.jdField_a_of_type_ComTencentTmdownloaderITMAssistantDownloadLogListener);
    }
    if (!this.ddy) {}
    try
    {
      TMAssistantDownloadSettingClient localTMAssistantDownloadSettingClient = TMAssistantDownloadManager.getInstance(aroi.a().getContext()).getDownloadSDKSettingClient();
      if (localTMAssistantDownloadSettingClient != null)
      {
        localTMAssistantDownloadSettingClient.setDownloadSDKMaxTaskNum(3);
        this.ddy = true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        arwt.e("DownloadManager_", "exception: " + localException.toString());
      }
    }
    this.c = TMAssistantDownloadManager.getInstance(aroi.a().getContext()).getDownloadSDKClient(this.mClientKey);
    return this.c;
  }
  
  public ConcurrentLinkedQueue<aryx> b()
  {
    try
    {
      ConcurrentLinkedQueue localConcurrentLinkedQueue = this.listeners;
      return localConcurrentLinkedQueue;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void b(int paramInt, DownloadInfo paramDownloadInfo)
  {
    a(paramInt, paramDownloadInfo, 0, "");
  }
  
  public void b(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    new Handler(Looper.getMainLooper()).post(new DownloadManager.17(this, paramBundle, paramActivity, paramString, paramApkUpdateDetail, paramInt));
  }
  
  public void b(aryx paramaryx)
  {
    try
    {
      if (this.listeners.contains(paramaryx)) {
        this.listeners.remove(paramaryx);
      }
      return;
    }
    finally
    {
      paramaryx = finally;
      throw paramaryx;
    }
  }
  
  public void b(DownloadInfo paramDownloadInfo)
  {
    try
    {
      h(paramDownloadInfo);
      return;
    }
    finally
    {
      paramDownloadInfo = finally;
      throw paramDownloadInfo;
    }
  }
  
  public boolean b(aryp paramaryp)
  {
    if (paramaryp == null) {}
    while ((this.jdField_b_of_type_Aryp == null) || (paramaryp != this.jdField_b_of_type_Aryp)) {
      return false;
    }
    this.jdField_b_of_type_Aryp = null;
    return true;
  }
  
  public List<DownloadInfo> bj(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    arwt.v("DownloadManager_", "getDownloadInfoById via == " + paramString);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jn.values().iterator();
    while (localIterator.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
      if ((!TextUtils.isEmpty(localDownloadInfo.via)) && (localDownloadInfo.via.equals(paramString))) {
        localArrayList.add(localDownloadInfo);
      }
    }
    arwt.v("DownloadManager_", "getDownloadInfoByVia result =" + localArrayList);
    return localArrayList;
  }
  
  public List<DownloadInfo> bk(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    paramString = bj(paramString);
    if ((paramString != null) && (paramString.size() > 0))
    {
      Iterator localIterator = paramString.iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if (localDownloadInfo != null) {
          if (localDownloadInfo.downloadType == 0)
          {
            if (localDownloadInfo.updateType == 1)
            {
              paramString = localDownloadInfo.cDF;
              label82:
              paramString = a().b(paramString);
              if (paramString == null) {
                break label230;
              }
              arwt.v("DownloadManager_", "queryDownloadInfosByVia sdk getReceiveDataLen=" + paramString.mReceiveDataLen + " getTotalDataLen=" + paramString.mTotalDataLen);
              localDownloadInfo.progress = ((int)((float)paramString.mReceiveDataLen * 100.0F / (float)paramString.mTotalDataLen));
              localDownloadInfo.setState(kO(paramString.mState));
              if (localDownloadInfo.updateType != 1) {
                break label218;
              }
              if (!TextUtils.isEmpty(localDownloadInfo.filePath)) {}
            }
            label218:
            for (localDownloadInfo.filePath = paramString.mSavePath;; localDownloadInfo.filePath = paramString.mSavePath)
            {
              localArrayList.add(localDownloadInfo);
              break;
              paramString = localDownloadInfo.urlStr;
              break label82;
            }
            label230:
            this.jn.remove(localDownloadInfo.appId);
            asac.a().Xv(localDownloadInfo.appId);
          }
          else
          {
            this.jn.remove(localDownloadInfo.appId);
            asac.a().Xv(localDownloadInfo.appId);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public DownloadInfo c(String paramString)
  {
    if (paramString == null)
    {
      arwt.v("DownloadManager_", "getDownloadInfoById appId == null");
      return null;
    }
    return (DownloadInfo)this.jn.get(paramString);
  }
  
  public DownloadInfo c(String paramString, int paramInt)
  {
    paramString = e(paramString);
    if (paramString != null)
    {
      paramString.setState(2);
      paramString.progress = paramInt;
    }
    return paramString;
  }
  
  public void cancelNotification(String paramString)
  {
    if ((paramString != null) && (paramString.trim().length() > 0)) {
      asab.a().Xt(paramString);
    }
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 81	aryy:listeners	Ljava/util/concurrent/ConcurrentLinkedQueue;
    //   4: invokevirtual 677	java/util/concurrent/ConcurrentLinkedQueue:iterator	()Ljava/util/Iterator;
    //   7: astore_1
    //   8: aload_1
    //   9: invokeinterface 547 1 0
    //   14: ifeq +40 -> 54
    //   17: aload_0
    //   18: aload_1
    //   19: invokeinterface 550 1 0
    //   24: checkcast 679	aryx
    //   27: invokevirtual 1126	aryy:b	(Laryx;)V
    //   30: goto -22 -> 8
    //   33: astore_1
    //   34: ldc 102
    //   36: ldc_w 1128
    //   39: aload_1
    //   40: invokestatic 666	arwt:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   43: ldc 2
    //   45: monitorenter
    //   46: aconst_null
    //   47: putstatic 194	aryy:jdField_a_of_type_Aryy	Laryy;
    //   50: ldc 2
    //   52: monitorexit
    //   53: return
    //   54: invokestatic 166	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   57: new 1130	com/tencent/open/downloadnew/DownloadManager$16
    //   60: dup
    //   61: aload_0
    //   62: invokespecial 1131	com/tencent/open/downloadnew/DownloadManager$16:<init>	(Laryy;)V
    //   65: invokevirtual 488	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   68: pop
    //   69: goto -26 -> 43
    //   72: astore_1
    //   73: ldc 2
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	aryy
    //   7	12	1	localIterator	Iterator
    //   33	7	1	localException	Exception
    //   72	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	8	33	java/lang/Exception
    //   8	30	33	java/lang/Exception
    //   54	69	33	java/lang/Exception
    //   46	53	72	finally
    //   73	76	72	finally
  }
  
  public void dx(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      arwt.w("DownloadManager_", "appid is empty");
      return;
    }
    Object localObject = c(paramString);
    if (localObject == null)
    {
      arwt.w("DownloadManager_", "clearDownloadInfo info == null");
      return;
    }
    arwt.v("DownloadManager_", "clearDownloadInfo info =" + ((DownloadInfo)localObject).toString());
    if (((DownloadInfo)localObject).downloadType == 0) {
      if (((DownloadInfo)localObject).updateType != 1) {
        break label124;
      }
    }
    label124:
    for (localObject = ((DownloadInfo)localObject).cDF;; localObject = ((DownloadInfo)localObject).urlStr)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ThreadManager.getSubThreadHandler().post(new DownloadManager.9(this, paramBoolean, (String)localObject));
      }
      this.jn.remove(paramString);
      asac.a().Xv(paramString);
      return;
    }
  }
  
  public DownloadInfo e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = this.jn.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if (((localDownloadInfo.updateType == 0) && (paramString.equals(localDownloadInfo.urlStr))) || ((localDownloadInfo.updateType == 1) && (paramString.equals(localDownloadInfo.cDF))) || ((localDownloadInfo.updateType == 2) && (paramString.equals(localDownloadInfo.urlStr)))) {
          return localDownloadInfo;
        }
      }
    }
    return null;
  }
  
  public boolean e(DownloadInfo paramDownloadInfo)
  {
    arwt.v("DownloadManager_", "refreshDownloadInfo DownloadInfo=" + paramDownloadInfo);
    DownloadInfo localDownloadInfo = c(paramDownloadInfo.appId);
    if (localDownloadInfo != null)
    {
      arwt.v("DownloadManager_", "refreshDownloadInfo cacheInfo =" + localDownloadInfo);
      Object localObject;
      if (localDownloadInfo.downloadType == 0)
      {
        arwt.v("DownloadManager_", "refreshDownloadInfo DownloadInfo.DOWNLOAD_TYPE_DOWNLOADSDK......");
        paramDownloadInfo.from = localDownloadInfo.from;
        if (localDownloadInfo.updateType == 1)
        {
          localObject = localDownloadInfo.cDF;
          localObject = a().b((String)localObject);
          if (localObject == null) {
            break label304;
          }
          arwt.v("DownloadManager_", "refreshDownloadInfo sdk getReceiveDataLen=" + ((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen + " getTotalDataLen=" + ((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen);
          paramDownloadInfo.progress = ((int)((float)((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen * 100.0F / (float)((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen));
          paramDownloadInfo.setState(kO(((TMAssistantDownloadTaskInfo)localObject).mState));
          paramDownloadInfo.downloadType = 0;
          if (localDownloadInfo.updateType != 1) {
            break label292;
          }
          if (!TextUtils.isEmpty(localDownloadInfo.filePath)) {
            break label280;
          }
          paramDownloadInfo.filePath = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
        }
        for (;;)
        {
          if (paramDownloadInfo.state == 4)
          {
            paramDownloadInfo.elm = localDownloadInfo.elm;
            if (paramDownloadInfo.elm != 0)
            {
              paramDownloadInfo.state = 3;
              j(localDownloadInfo);
            }
          }
          return true;
          localObject = localDownloadInfo.urlStr;
          break;
          label280:
          paramDownloadInfo.filePath = localDownloadInfo.filePath;
          continue;
          label292:
          paramDownloadInfo.filePath = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
        }
        label304:
        this.jn.remove(localDownloadInfo.appId);
        asac.a().Xv(localDownloadInfo.appId);
        paramDownloadInfo.state = -100;
        return true;
      }
      if (localDownloadInfo.downloadType == 1)
      {
        localObject = a(localDownloadInfo);
        if (localObject != null)
        {
          int j = kO(((TMAssistantDownloadTaskInfo)localObject).mState);
          int i = j;
          if (j == -2) {
            i = 3;
          }
          paramDownloadInfo.setState(i);
          paramDownloadInfo.downloadType = 1;
          paramDownloadInfo.filePath = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
          long l1 = ((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen;
          long l2 = ((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen;
          paramDownloadInfo.progress = ((int)((float)l1 * 100.0F / (float)l2));
          if (!arzk.a().aHz()) {
            paramDownloadInfo.progress = 0;
          }
          return true;
        }
        this.jn.remove(localDownloadInfo.appId);
        asac.a().Xv(localDownloadInfo.appId);
      }
    }
    return false;
  }
  
  public void elQ()
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManager.1(this));
  }
  
  protected void elS()
  {
    if (this.jn.size() > 200) {
      ThreadManager.getSubThreadHandler().postDelayed(new DownloadManager.18(this), 3000L);
    }
  }
  
  protected void eme()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new DownloadManager.3(this), 5000L);
    ThreadManager.getSubThreadHandler().postDelayed(new DownloadManager.4(this), 10000L);
  }
  
  public void emf()
  {
    try
    {
      Iterator localIterator = this.jn.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if ((localDownloadInfo != null) && ((localDownloadInfo.getState() == 2) || (localDownloadInfo.getState() == 20))) {
          fw(localDownloadInfo.appId);
        }
      }
    }
    finally {}
  }
  
  public void emg()
  {
    try
    {
      Iterator localIterator = this.jn.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if ((localDownloadInfo != null) && (localDownloadInfo.downloadType == 1) && ((localDownloadInfo.getState() == 2) || (localDownloadInfo.getState() == 20)))
        {
          localDownloadInfo.setState(3);
          b(3, localDownloadInfo);
        }
      }
    }
    finally {}
  }
  
  /* Error */
  public DownloadInfo f(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifne +57 -> 63
    //   9: aload_0
    //   10: getfield 76	aryy:jn	Ljava/util/concurrent/ConcurrentHashMap;
    //   13: invokevirtual 533	java/util/concurrent/ConcurrentHashMap:values	()Ljava/util/Collection;
    //   16: invokeinterface 539 1 0
    //   21: astore 4
    //   23: aload 4
    //   25: invokeinterface 547 1 0
    //   30: ifeq +33 -> 63
    //   33: aload 4
    //   35: invokeinterface 550 1 0
    //   40: checkcast 224	com/tencent/open/downloadnew/DownloadInfo
    //   43: astore_3
    //   44: aload_1
    //   45: aload_3
    //   46: getfield 396	com/tencent/open/downloadnew/DownloadInfo:packageName	Ljava/lang/String;
    //   49: invokevirtual 276	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   52: istore_2
    //   53: iload_2
    //   54: ifeq -31 -> 23
    //   57: aload_3
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: areturn
    //   63: aconst_null
    //   64: astore_1
    //   65: goto -6 -> 59
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: aload_1
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	aryy
    //   0	73	1	paramString	String
    //   52	2	2	bool	boolean
    //   43	15	3	localDownloadInfo	DownloadInfo
    //   21	13	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	23	68	finally
    //   23	53	68	finally
  }
  
  public int fw(String paramString)
  {
    Object localObject = c(paramString);
    if (localObject != null) {
      if (((DownloadInfo)localObject).updateType != 1) {
        break label76;
      }
    }
    label76:
    for (localObject = ((DownloadInfo)localObject).cDF;; localObject = ((DownloadInfo)localObject).urlStr)
    {
      ThreadManager.getSubThreadHandler().post(new DownloadManager.12(this, (String)localObject));
      arwt.v("DownloadManager_", "pause url=" + (String)localObject + ", appid=" + paramString);
      return 0;
    }
  }
  
  public WeakReference<AppInterface> i()
  {
    try
    {
      Object localObject1 = this.iN;
      if (localObject1 == null) {}
      try
      {
        if ((BaseApplicationImpl.getApplication().getRuntime() instanceof AppInterface))
        {
          localObject1 = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
          if (localObject1 != null) {
            this.iN = new WeakReference(localObject1);
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          arwt.e("DownloadManager_", "getQQAppInterface>>>", localException);
        }
      }
      localObject1 = this.iN;
      return localObject1;
    }
    finally {}
  }
  
  public boolean i(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = c(paramString1);
    if (paramString2 != null) {
      dx(paramString1, false);
    }
    if (paramString2 != null)
    {
      if (!paramBoolean) {
        break label33;
      }
      b(10, paramString2);
    }
    for (;;)
    {
      return true;
      try
      {
        label33:
        asab.a().Xt(paramString2.sendTime);
      }
      catch (Exception paramString1)
      {
        arwt.e("DownloadManager_", "downloadSDKClient>>>", paramString1);
      }
    }
  }
  
  public boolean isMainProcess()
  {
    return BaseApplicationImpl.sProcessId == 1;
  }
  
  public void j(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {}
    try
    {
      if (!TextUtils.isEmpty(paramDownloadInfo.appId))
      {
        arwt.d("DownloadManager_", "addDownloadInfo info.appId = " + paramDownloadInfo.appId + ",info.packageName = " + paramDownloadInfo.packageName + ",info.filePath = " + paramDownloadInfo.filePath);
        this.jn.put(paramDownloadInfo.appId, paramDownloadInfo);
        asac.a().j(paramDownloadInfo);
      }
      return;
    }
    finally
    {
      paramDownloadInfo = finally;
      throw paramDownloadInfo;
    }
  }
  
  public void j(String paramString1, long paramLong, String paramString2)
  {
    if (aqiw.getNetworkType(BaseApplication.getContext()) == 1) {
      if ("biz_src_yyb".equals(paramString2)) {
        paramString2 = new String[] { "param_WIFIAppCenterDefaultDownloadFlow", "param_WIFIFlow", "param_Flow" };
      }
    }
    for (;;)
    {
      if ((i() == null) || (paramString2 == null))
      {
        arwt.d("DownloadManager_", "application or tags is null");
        return;
        if ("biz_src_jc_update".equals(paramString2))
        {
          paramString2 = new String[] { "param_WIFIAppCenterQQUpdateDownloadFlow", "param_WIFIFlow", "param_Flow" };
          continue;
        }
        if ("biz_src_zf_games".equals(paramString2))
        {
          paramString2 = new String[] { "param_WIFIAppCenterGameCenterDownloadFlow", "param_WIFIFlow", "param_Flow" };
          continue;
        }
        if ("biz_src_jc_vip".equals(paramString2))
        {
          paramString2 = new String[] { "param_WIFIAppCenterOthersDownloadFlow", "param_WIFIFlow", "param_Flow" };
          continue;
          if ("biz_src_yyb".equals(paramString2))
          {
            paramString2 = new String[] { "param_XGAppCenterDefaultDownloadFlow", "param_XGFlow", "param_Flow" };
            continue;
          }
          if ("biz_src_jc_update".equals(paramString2))
          {
            paramString2 = new String[] { "param_XGAppCenterQQUpdateDownloadFlow", "param_XGFlow", "param_Flow" };
            continue;
          }
          if ("biz_src_zf_games".equals(paramString2))
          {
            paramString2 = new String[] { "param_XGAppCenterGameCenterDownloadFlow", "param_XGFlow", "param_Flow" };
            continue;
          }
          if ("biz_src_jc_vip".equals(paramString2)) {
            paramString2 = new String[] { "param_XGAppCenterOthersDownloadFlow", "param_XGFlow", "param_Flow" };
          }
        }
      }
      else
      {
        AppInterface localAppInterface = (AppInterface)i().get();
        if (localAppInterface == null)
        {
          arwt.d("DownloadManager_", "appinterface is null");
          return;
        }
        try
        {
          localAppInterface.sendAppDataIncerment(localAppInterface.getCurrentAccountUin(), paramString2, paramLong);
          arwt.d("DownloadManager_", "sendAppDataIncerment logMsg: " + paramString1 + " ,fileSize : " + paramLong);
          return;
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
          return;
        }
      }
      paramString2 = null;
    }
  }
  
  public boolean j(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = c(paramString1);
    if (paramString2 != null) {
      dx(paramString1, true);
    }
    if (paramString2 != null)
    {
      if (paramBoolean) {
        b(10, paramString2);
      }
    }
    else {
      return true;
    }
    try
    {
      asab.a().Xt(paramString2.sendTime);
      return true;
    }
    catch (Exception paramString1)
    {
      arwt.e("DownloadManager_", "downloadSDKClient>>>", paramString1);
    }
    return true;
  }
  
  public void o(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return;
    }
    if (this.jdField_b_of_type_Aryp != null)
    {
      this.jdField_b_of_type_Aryp.a(paramDownloadInfo.packageName, paramDownloadInfo.versionCode, null);
      return;
    }
    this.jdField_b_of_type_Aryp = null;
  }
  
  public String qK(String paramString)
  {
    paramString = c(paramString);
    if (paramString != null) {
      return paramString.source;
    }
    return "";
  }
  
  public String qz(String paramString)
  {
    paramString = c(paramString);
    if (paramString != null) {
      return paramString.filePath;
    }
    return "";
  }
  
  public boolean sB(String paramString)
  {
    paramString = a().c(paramString);
    return (paramString != null) && (paramString.getState() == 4);
  }
  
  public void setAppInterface(AppInterface paramAppInterface)
  {
    try
    {
      this.iN = new WeakReference(paramAppInterface);
      return;
    }
    finally
    {
      paramAppInterface = finally;
      throw paramAppInterface;
    }
  }
  
  public void showToast(String paramString)
  {
    try
    {
      if ((BaseActivity.sTopActivity.isResume()) && (System.currentTimeMillis() - this.awE > 1000L))
      {
        this.awE = System.currentTimeMillis();
        arxa.a().showToast(paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      arwt.e("DownloadManager_", "showToast>>>", paramString);
    }
  }
  
  public void x(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {}
    for (;;)
    {
      try
      {
        arwt.d("DownloadManager_", "complete info == null ");
        return;
      }
      finally {}
      if (((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) && ("com.tencent.mobileqq".equals(paramDownloadInfo.packageName)) && (accy.ad((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
        paramDownloadInfo.isAutoInstall = false;
      }
      arwt.v("DownloadManager_", "onDownload complete, info = " + paramDownloadInfo.toString());
      if (paramDownloadInfo.downloadType == 0)
      {
        if (paramDownloadInfo.updateType == 1) {
          i(paramDownloadInfo);
        } else {
          ThreadManager.getSubThreadHandler().post(new DownloadManager.13(this, paramDownloadInfo));
        }
      }
      else {
        ThreadManager.excute(new DownloadManager.14(this, paramDownloadInfo), 32, null, true);
      }
    }
  }
  
  public void y(DownloadInfo paramDownloadInfo)
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
    if (paramDownloadInfo == null)
    {
      arwt.v("DownloadManager_", "installDownload info == null");
      return;
    }
    if (!paramDownloadInfo.ddw)
    {
      arwt.v("DownloadManager_", "installDownload info is not apk");
      return;
    }
    Object localObject2 = "";
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
    Object localObject1;
    if (TextUtils.isEmpty(paramDownloadInfo.filePath)) {
      if (paramDownloadInfo.downloadType == 0)
      {
        localTMAssistantDownloadTaskInfo2 = b(paramDownloadInfo.urlStr);
        localObject1 = localObject2;
        if (localTMAssistantDownloadTaskInfo2 != null)
        {
          localObject1 = localObject2;
          if (localTMAssistantDownloadTaskInfo2.mState == 4) {
            localObject1 = localTMAssistantDownloadTaskInfo2.mSavePath;
          }
        }
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          localTMAssistantDownloadTaskInfo1 = a(paramDownloadInfo);
          localObject2 = localObject1;
        }
        localObject1 = localObject2;
        if (localTMAssistantDownloadTaskInfo1 != null)
        {
          localObject1 = localObject2;
          if (localTMAssistantDownloadTaskInfo1.mState == 4) {
            localObject1 = localTMAssistantDownloadTaskInfo1.mSavePath;
          }
        }
        localObject2 = localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramDownloadInfo.filePath = ((String)localObject1);
          paramDownloadInfo.setState(4);
          j(paramDownloadInfo);
        }
      }
    }
    for (localObject2 = localObject1;; localObject2 = paramDownloadInfo.filePath)
    {
      localObject1 = arxn.lh((String)localObject2);
      arwt.v("DownloadManager_", "installDownload localAPKPath=" + (String)localObject2 + ", apkPackageName=" + (String)localObject1 + " updateType=" + paramDownloadInfo.updateType);
      Log.v("DownloadManager_", "installDownload localAPKPath=" + (String)localObject2 + ", apkPackageName=" + (String)localObject1 + " updateType=" + paramDownloadInfo.updateType);
      if (localObject1 == null) {
        break label356;
      }
      arwt.d("DownloadManager_", "[installDownload] begin sendCheckDownloadReq pkgname=" + (String)localObject1);
      a(paramDownloadInfo, (String)localObject2, (String)localObject1);
      return;
      localTMAssistantDownloadTaskInfo2 = a(paramDownloadInfo);
      localObject1 = localObject2;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        localObject1 = localObject2;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          localObject1 = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break;
      }
      localTMAssistantDownloadTaskInfo1 = b(paramDownloadInfo.urlStr);
      localObject2 = localObject1;
      break;
    }
    label356:
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      arwt.v("DownloadManager_", "package invaild del file");
    }
    try
    {
      localObject1 = new File((String)localObject2);
      if (((File)localObject1).exists()) {
        ((File)localObject1).delete();
      }
      label392:
      a(-2, paramDownloadInfo, -24, "");
      return;
    }
    catch (Exception localException)
    {
      break label392;
    }
  }
  
  public void z(DownloadInfo paramDownloadInfo)
  {
    arwt.d("DownloadManager_", "onReveiveInstallIntent info=" + paramDownloadInfo);
    if (paramDownloadInfo.downloadType == 0) {
      arxt.X("310", paramDownloadInfo.via, paramDownloadInfo.appId, paramDownloadInfo.extraData);
    }
    if (!"5".equals(paramDownloadInfo.source)) {
      dx(paramDownloadInfo.appId, false);
    }
    asab.a().Xt(paramDownloadInfo.sendTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aryy
 * JD-Core Version:    0.7.0.1
 */