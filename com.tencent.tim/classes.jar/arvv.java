import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appstore.dl.DownloadManagerV2.10;
import com.tencent.open.appstore.dl.DownloadManagerV2.11;
import com.tencent.open.appstore.dl.DownloadManagerV2.12;
import com.tencent.open.appstore.dl.DownloadManagerV2.13;
import com.tencent.open.appstore.dl.DownloadManagerV2.14;
import com.tencent.open.appstore.dl.DownloadManagerV2.15;
import com.tencent.open.appstore.dl.DownloadManagerV2.16;
import com.tencent.open.appstore.dl.DownloadManagerV2.19;
import com.tencent.open.appstore.dl.DownloadManagerV2.2;
import com.tencent.open.appstore.dl.DownloadManagerV2.20;
import com.tencent.open.appstore.dl.DownloadManagerV2.21;
import com.tencent.open.appstore.dl.DownloadManagerV2.22;
import com.tencent.open.appstore.dl.DownloadManagerV2.23;
import com.tencent.open.appstore.dl.DownloadManagerV2.24;
import com.tencent.open.appstore.dl.DownloadManagerV2.3;
import com.tencent.open.appstore.dl.DownloadManagerV2.4;
import com.tencent.open.appstore.dl.DownloadManagerV2.5;
import com.tencent.open.appstore.dl.DownloadManagerV2.6;
import com.tencent.open.appstore.dl.DownloadManagerV2.7;
import com.tencent.open.appstore.dl.DownloadManagerV2.8;
import com.tencent.open.appstore.dl.DownloadManagerV2.9;
import com.tencent.open.appstore.notice.NoticeReceiver;
import com.tencent.open.appstore.receiver.InstallStateReceiver;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.replacemonitor.replace.ReplaceMonitor;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantbase.common.TMAssistantDownloadConst;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import com.tencent.tmassistantsdk.TMAssistantCallYYBTaskInfo;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
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

public class arvv
  implements ITMAssistantDownloadClientListener
{
  private static volatile arvv jdField_a_of_type_Arvv;
  private ConcurrentLinkedQueue<aryx> Q = new ConcurrentLinkedQueue();
  private aryo jdField_a_of_type_Aryo = new arvw(this);
  private aryp jdField_a_of_type_Aryp;
  private arzg jdField_a_of_type_Arzg;
  private NoticeReceiver jdField_a_of_type_ComTencentOpenAppstoreNoticeNoticeReceiver;
  private InstallStateReceiver jdField_a_of_type_ComTencentOpenAppstoreReceiverInstallStateReceiver;
  private long awD;
  private long awE;
  private TMAssistantDownloadClient b;
  private boolean ddk;
  private boolean ddl;
  private final int elc = 1000;
  private WeakReference<AppInterface> iN;
  private ConcurrentHashMap<String, DownloadInfo> jl = new ConcurrentHashMap();
  private String mClientKey;
  
  private arvv()
  {
    arwt.i("DownloadManagerV2", "DownloadManagerV2 init");
    this.mClientKey = "com.tencent.open.appstore.dl.DownloadManagerV2";
    Object localObject = new HashMap();
    ReplaceMonitor.get().init(aroi.a().getContext(), (Map)localObject);
    this.jdField_a_of_type_ComTencentOpenAppstoreReceiverInstallStateReceiver = new InstallStateReceiver();
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addDataScheme("package");
    ((IntentFilter)localObject).addAction("android.intent.action.PACKAGE_ADDED");
    ((IntentFilter)localObject).addAction("android.intent.action.PACKAGE_REMOVED");
    ((IntentFilter)localObject).addAction("android.intent.action.PACKAGE_REPLACED");
    this.jdField_a_of_type_ComTencentOpenAppstoreNoticeNoticeReceiver = new NoticeReceiver();
    IntentFilter localIntentFilter = new IntentFilter();
    String str = arug.getProcessName();
    str = "." + str.replace(":", ".");
    localIntentFilter.addAction(asad.cDR + str);
    localIntentFilter.addAction(asad.cDS + str);
    localIntentFilter.addAction(asad.cDT + str);
    localIntentFilter.addAction(asad.ACTION_DOWNLOAD_COMPLETE + str);
    localIntentFilter.addAction(asad.cDU + str);
    ThreadManager.excute(new DownloadManagerV2.2(this, (IntentFilter)localObject, localIntentFilter), 16, null, true);
    arwj.a().a(ThreadManager.getSubThreadHandler().getLooper());
    a(arwj.a());
    a(arzy.a());
    ThreadManager.excute(new DownloadManagerV2.3(this), 32, null, true);
    this.jdField_a_of_type_Arzg = arzg.a();
  }
  
  private boolean M(String paramString, boolean paramBoolean)
  {
    DownloadInfo localDownloadInfo = d(paramString);
    if (localDownloadInfo != null) {
      dx(paramString, false);
    }
    if (localDownloadInfo != null)
    {
      if (!paramBoolean) {
        break label33;
      }
      b(10, localDownloadInfo);
    }
    for (;;)
    {
      return true;
      try
      {
        label33:
        asab.a().Xt(localDownloadInfo.sendTime);
      }
      catch (Exception paramString)
      {
        arwt.e("DownloadManagerV2", "downloadSDKClient>>>", paramString);
      }
    }
  }
  
  private boolean O(String paramString, boolean paramBoolean)
  {
    DownloadInfo localDownloadInfo = d(paramString);
    if (localDownloadInfo != null) {
      dx(paramString, true);
    }
    if (localDownloadInfo != null)
    {
      if (paramBoolean) {
        b(10, localDownloadInfo);
      }
    }
    else {
      return true;
    }
    try
    {
      asab.a().Xt(localDownloadInfo.sendTime);
      return true;
    }
    catch (Exception paramString)
    {
      arwt.e("DownloadManagerV2", "downloadSDKClient>>>", paramString);
    }
    return true;
  }
  
  public static arvv a()
  {
    if (jdField_a_of_type_Arvv == null) {}
    try
    {
      if (jdField_a_of_type_Arvv == null)
      {
        jdField_a_of_type_Arvv = new arvv();
        jdField_a_of_type_Arvv.elR();
        jdField_a_of_type_Arvv.elS();
      }
      return jdField_a_of_type_Arvv;
    }
    finally {}
  }
  
  private DownloadInfo a(String paramString, int paramInt)
  {
    paramString = e(paramString);
    if ((paramString != null) && (paramInt != -2)) {
      paramString.setState(paramInt);
    }
    return paramString;
  }
  
  private DownloadInfo a(String paramString, long paramLong1, long paramLong2)
  {
    paramString = e(paramString);
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    if (paramString != null)
    {
      paramString.setState(2);
      paramString.progress = i;
      paramString.awN = paramLong2;
    }
    return paramString;
  }
  
  private TMAssistantDownloadClient a()
  {
    TMAssistantDownloadManager.getInstance(aroi.a().getContext()).getDownloadSDKClient(this.mClientKey).registerDownloadTaskListener(this);
    if (!this.ddl) {}
    try
    {
      TMAssistantDownloadSettingClient localTMAssistantDownloadSettingClient = TMAssistantDownloadManager.getInstance(aroi.a().getContext()).getDownloadSDKSettingClient();
      if (localTMAssistantDownloadSettingClient != null)
      {
        localTMAssistantDownloadSettingClient.setDownloadSDKMaxTaskNum(3);
        this.ddl = true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        arwt.e("DownloadManagerV2", "exception: " + localException.toString());
      }
    }
    this.b = TMAssistantDownloadManager.getInstance(aroi.a().getContext()).getDownloadSDKClient(this.mClientKey);
    return this.b;
  }
  
  private void a(int paramInt1, DownloadInfo paramDownloadInfo, int paramInt2, String paramString)
  {
    if (paramDownloadInfo == null) {}
    try
    {
      arwt.e("DownloadManagerV2", "notifyListener info == null id=" + paramInt1);
      return;
    }
    finally {}
    switch (paramInt1)
    {
    default: 
      paramInt1 = 1;
    }
    while (paramInt1 != 0)
    {
      arwt.i("DownloadManagerV2", "[notifyListener] Need Save Info:" + paramDownloadInfo);
      j(paramDownloadInfo);
      break;
      arwt.i("DownloadManagerV2", "[notifyListener] STATE_WAIT:" + this.Q.size());
      paramString = this.Q.iterator();
      for (;;)
      {
        if (paramString.hasNext())
        {
          ((aryx)paramString.next()).onDownloadWait(paramDownloadInfo);
          continue;
          arwt.i("DownloadManagerV2", "[notifyListener] STATE_PAUSE:" + this.Q.size());
          paramString = this.Q.iterator();
          while (paramString.hasNext()) {
            ((aryx)paramString.next()).onDownloadPause(paramDownloadInfo);
          }
          arwt.i("DownloadManagerV2", "[notifyListener] STATE_COMPLETE:" + this.Q.size());
          paramDownloadInfo.progress = 100;
          if (paramDownloadInfo.downloadType == 0) {
            arwk.u(paramDownloadInfo);
          }
          paramString = this.Q.iterator();
          while (paramString.hasNext()) {
            ((aryx)paramString.next()).onDownloadFinish(paramDownloadInfo);
          }
          arvu.a(12, null, 100, paramDownloadInfo);
          paramInt1 = 1;
          break;
          arwt.i("DownloadManagerV2", "[notifyListener] STATE_CANCEL:" + this.Q.size());
          k(paramDownloadInfo);
          asab.a().Xt(paramDownloadInfo.sendTime);
          paramDownloadInfo.setState(10);
          arwt.i("DownloadManagerV2", "downloadInfo.state = " + paramDownloadInfo.getState());
          paramString = this.Q.iterator();
          while (paramString.hasNext()) {
            ((aryx)paramString.next()).onDownloadCancel(paramDownloadInfo);
          }
          if (paramDownloadInfo.downloadType == 0)
          {
            arwk.v(paramDownloadInfo);
            paramInt1 = 0;
            break;
            if ((paramDownloadInfo.downloadType == 1) || (System.currentTimeMillis() - this.awD > 1000L))
            {
              this.awD = System.currentTimeMillis();
              arwt.i("DownloadManagerV2", "[notifyListener] STATE_DOWNLOADING:" + this.Q.size());
              paramString = ap(2);
              arwt.v("DownloadManagerV2", "[notifyListener] STATE_DOWNLOADING: infos size= " + paramString.size());
              Iterator localIterator = this.Q.iterator();
              while (localIterator.hasNext())
              {
                aryx localaryx = (aryx)localIterator.next();
                arwt.v("DownloadManagerV2", "[notifyListener] DownloadConstants.STATE_DOWNLOADING: listener name:" + localaryx.getClass().getName());
                localaryx.onDownloadUpdate(paramString);
              }
              a(paramDownloadInfo, paramInt2, paramString);
              paramInt1 = 1;
              break;
              arwt.i("DownloadManagerV2", "[notifyListener] PACKAGE_INSTALLED:" + this.Q.size());
              paramString = this.Q.iterator();
              while (paramString.hasNext()) {
                ((aryx)paramString.next()).installSucceed(paramDownloadInfo.appId, paramDownloadInfo.packageName);
              }
              arwt.i("DownloadManagerV2", "[notifyListener] PACKAGE_REPLACED:" + this.Q.size());
              paramString = this.Q.iterator();
              while (paramString.hasNext()) {
                ((aryx)paramString.next()).packageReplaced(paramDownloadInfo.appId, paramDownloadInfo.packageName);
              }
              arwt.i("DownloadManagerV2", "[notifyListener] PACKAGE_UNINSTALLED:" + this.Q.size());
              paramString = this.Q.iterator();
              while (paramString.hasNext()) {
                ((aryx)paramString.next()).uninstallSucceed(paramDownloadInfo.appId, paramDownloadInfo.packageName);
              }
              paramInt1 = 1;
              break;
            }
          }
          paramInt1 = 0;
          break;
        }
      }
      paramInt1 = 1;
      continue;
      paramInt1 = 1;
      continue;
      paramInt1 = 1;
      continue;
      paramInt1 = 1;
      continue;
      paramInt1 = 1;
    }
  }
  
  private void a(DownloadInfo paramDownloadInfo, int paramInt, String paramString)
  {
    this.ddl = false;
    if (paramDownloadInfo == null)
    {
      arwt.i("DownloadManagerV2", "[onDownloadError] info == null code = " + paramInt + " msg = " + paramString);
      return;
    }
    arwt.i("DownloadManagerV2", "[onDownloadError] errorCode = " + paramInt + " msg = " + paramString);
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        paramString = aroi.a().getContext().getString(2131696629);
        i = 3;
        paramDownloadInfo.setState(i);
        arwt.i("DownloadManagerV2", "[onDownloadError] ListenerSize:" + this.Q.size());
        Iterator localIterator = this.Q.iterator();
        if (!localIterator.hasNext()) {
          break label717;
        }
        ((aryx)localIterator.next()).onDownloadError(paramDownloadInfo, paramInt, paramString, i);
        continue;
        if (paramDownloadInfo.packageName == null) {
          break label530;
        }
      }
      catch (Exception paramDownloadInfo)
      {
        paramDownloadInfo.printStackTrace();
        return;
      }
      if (("com.tencent.mobileqq".equals(paramDownloadInfo.packageName)) && (paramDownloadInfo.updateType != 1) && (isMainProcess()))
      {
        g(paramDownloadInfo);
        return;
      }
      label530:
      paramDownloadInfo.setState(4);
      if (paramDownloadInfo.updateType == 1)
      {
        i(paramDownloadInfo);
        return;
      }
      f(paramDownloadInfo);
      return;
      paramString = aroi.a().getContext().getString(2131696639);
      int i = 3;
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
      if (paramInt == 712) {}
      for (paramString = aroi.a().getContext().getString(2131696631);; paramString = aroi.a().getContext().getString(2131696632))
      {
        e(paramDownloadInfo);
        i = 10;
        break;
      }
      label717:
      if ((!TextUtils.isEmpty(paramString)) && (paramInt != 6)) {
        showToast(paramString);
      }
      if (paramDownloadInfo.downloadType == 0)
      {
        arwk.b(paramDownloadInfo, paramInt, paramString);
        return;
      }
      arwt.e("DownloadManagerV2", "[onDownloadError] downloadType=DOWNLOAD_TYPE_MYAPP, shouldn't report!");
      return;
      i = 3;
    }
  }
  
  private void a(DownloadInfo paramDownloadInfo, String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((paramDownloadInfo.getState() != 4) && (paramDownloadInfo.isAutoInstallBySDK))
    {
      arwt.i("DownloadManagerV2", "isAutoInstallBySDK is true");
      if (TextUtils.isEmpty(paramString1)) {
        break label30;
      }
    }
    label30:
    label252:
    for (;;)
    {
      return;
      if (new File(paramString1).exists())
      {
        if (paramBoolean)
        {
          paramDownloadInfo.cDI = BaseApplicationImpl.getApplication().getQQProcessName();
          a(paramDownloadInfo, true);
        }
        paramBoolean = arxn.d(aroi.a().getContext(), paramString1, paramDownloadInfo.source, paramDownloadInfo.qH("big_brother_ref_source_key"));
        arwk.s(paramDownloadInfo);
        for (;;)
        {
          if ((!paramBoolean) || (!"com.tencent.android.qqdownloader".equals(paramString2)) || (!"1101070898".equals(paramDownloadInfo.appId))) {
            break label252;
          }
          arwt.v("DownloadManagerV2", "report yyb start install");
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
          if (paramBoolean)
          {
            paramDownloadInfo.cDI = BaseApplicationImpl.getApplication().getQQProcessName();
            a(paramDownloadInfo, true);
          }
          paramBoolean = arxn.d(aroi.a().getContext(), paramString1, paramDownloadInfo.source, paramDownloadInfo.qH("big_brother_ref_source_key"));
          arwk.s(paramDownloadInfo);
        }
      }
    }
  }
  
  private int b(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return -30;
    }
    if (this.jdField_a_of_type_Aryp != null) {
      return this.jdField_a_of_type_Aryp.a(paramDownloadInfo.packageName, paramDownloadInfo.versionCode, paramDownloadInfo.filePath, null);
    }
    this.jdField_a_of_type_Aryp = null;
    return -40;
  }
  
  private DownloadInfo b(String paramString, int paramInt)
  {
    paramString = g(paramString);
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
  
  private void d(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.7(this, paramDownloadInfo));
  }
  
  private void dI(Bundle paramBundle)
  {
    arwt.i("DownloadManagerV2", "[writeApkCodeAsync] ");
    if (paramBundle == null)
    {
      arwt.i("DownloadManagerV2", "[writeApkCodeAsync] data is null......");
      return;
    }
    ThreadManager.excute(new DownloadManagerV2.22(this, paramBundle), 32, null, true);
  }
  
  private void dx(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString))
    {
      arwt.w("DownloadManagerV2", "appid is empty");
      return;
    }
    DownloadInfo localDownloadInfo = d(paramString);
    if (localDownloadInfo == null)
    {
      arwt.w("DownloadManagerV2", "clearDownloadInfo info == null");
      return;
    }
    arwt.v("DownloadManagerV2", "clearDownloadInfo info =" + localDownloadInfo.toString());
    if (localDownloadInfo.downloadType == 0) {
      if (localDownloadInfo.updateType != 1) {
        break label113;
      }
    }
    label113:
    for (paramString = localDownloadInfo.cDF;; paramString = localDownloadInfo.urlStr)
    {
      if (!TextUtils.isEmpty(paramString)) {
        ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.15(this, paramBoolean, paramString));
      }
      k(localDownloadInfo);
      return;
    }
  }
  
  private void e(DownloadInfo paramDownloadInfo)
  {
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof AppInterface))
    {
      localObject = ((AppInterface)BaseApplicationImpl.getApplication().getRuntime()).getHandler(Conversation.class);
      if ((localObject != null) && (aqap.a().getDownloadState() == 4)) {
        ((MqqHandler)localObject).obtainMessage(1134019).sendToTarget();
      }
    }
    if (paramDownloadInfo.updateType == 1) {}
    for (Object localObject = paramDownloadInfo.cDF;; localObject = paramDownloadInfo.urlStr)
    {
      if (localObject != null) {
        ThreadManager.excute(new DownloadManagerV2.8(this, (String)localObject, paramDownloadInfo), 32, null, true);
      }
      return;
    }
  }
  
  private void elR()
  {
    ThreadManager.getSubThreadHandler().postDelayed(new DownloadManagerV2.5(this), 1000L);
  }
  
  private void f(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.excute(new DownloadManagerV2.9(this, paramDownloadInfo), 32, null, true);
  }
  
  private int fy(String paramString)
  {
    Object localObject = d(paramString);
    if (localObject != null) {
      if (((DownloadInfo)localObject).updateType != 1) {
        break label76;
      }
    }
    label76:
    for (localObject = ((DownloadInfo)localObject).cDF;; localObject = ((DownloadInfo)localObject).urlStr)
    {
      ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.14(this, (String)localObject));
      arwt.v("DownloadManagerV2", "pause url=" + (String)localObject + ", ticket=" + paramString);
      return 0;
    }
  }
  
  private DownloadInfo g(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = this.jl.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if (TextUtils.equals(localDownloadInfo.appId, paramString)) {
          return localDownloadInfo;
        }
      }
    }
    return null;
  }
  
  private void g(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.10(this, paramDownloadInfo));
  }
  
  private void h(DownloadInfo paramDownloadInfo)
  {
    arwt.i("DownloadManagerV2", ">>startDownload downloadInfo:" + paramDownloadInfo);
    Object localObject1 = d(paramDownloadInfo.ticket);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = arvt.a().d(paramDownloadInfo.ticket);
      arwt.i("DownloadManagerV2", ">>startDownload get from DB:" + localObject2);
    }
    localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((DownloadInfo)localObject2).getState() == 4)
      {
        localObject1 = localObject2;
        if (!new File(((DownloadInfo)localObject2).filePath).exists())
        {
          arwt.e("DownloadManagerV2", "[startDownload] info succeed, but file is deleted!info=" + localObject2);
          ((DownloadInfo)localObject2).emd();
          localObject1 = null;
        }
      }
    }
    if (localObject1 != null)
    {
      ((DownloadInfo)localObject1).downloadType = 0;
      ((DownloadInfo)localObject1).via = paramDownloadInfo.via;
      ((DownloadInfo)localObject1).source = paramDownloadInfo.source;
      ((DownloadInfo)localObject1).isAutoInstall = paramDownloadInfo.isAutoInstall;
      ((DownloadInfo)localObject1).cDJ = paramDownloadInfo.cDJ;
      arwt.v("DownloadManagerV2", "startDownload() downloadInfo != null>>>downloadInfo.url=" + ((DownloadInfo)localObject1).urlStr + "downloadInfo.isAutoInstall" + ((DownloadInfo)localObject1).isAutoInstall + "+++++downloadInfo.downloadType=" + ((DownloadInfo)localObject1).updateType + "  test" + d(((DownloadInfo)localObject1).ticket));
      paramDownloadInfo = (DownloadInfo)localObject1;
      paramDownloadInfo.cDI = BaseApplicationImpl.getApplication().getQQProcessName();
      arwt.i("DownloadManagerV2", ">>startDownload record download start process flag:" + paramDownloadInfo.cDI);
      a(paramDownloadInfo, true);
      if (("com.tencent.mobileqq".equals(paramDownloadInfo.packageName)) && (isMainProcess())) {
        o(paramDownloadInfo);
      }
      if (paramDownloadInfo.updateType != 1) {
        break label602;
      }
    }
    label602:
    for (localObject2 = paramDownloadInfo.cDF;; localObject2 = paramDownloadInfo.urlStr)
    {
      int i = paramDownloadInfo.updateType;
      HashMap localHashMap = new HashMap();
      localHashMap.put(TMAssistantDownloadConst.PARAM_APPID, paramDownloadInfo.appId);
      localHashMap.put(TMAssistantDownloadConst.PARAM_TASK_PACKNAME, paramDownloadInfo.packageName);
      localHashMap.put(TMAssistantDownloadConst.PARAM_TASK_VERSION, String.valueOf(paramDownloadInfo.versionCode));
      localHashMap.put(TMAssistantDownloadConst.PARAM_VIA, paramDownloadInfo.via);
      localHashMap.put(TMAssistantDownloadConst.PARAM_UIN_TYPE, String.valueOf("qqNumber"));
      localHashMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADTYPE, String.valueOf(2));
      localHashMap.put(TMAssistantDownloadConst.PARAM_ICON_URL, paramDownloadInfo.iconUrl);
      localHashMap.put(TMAssistantDownloadConst.PARAM_APP_NAME, paramDownloadInfo.pushTitle);
      localHashMap.put(TMAssistantDownloadConst.PARAM_SHOW_NOTIFICATION, String.valueOf(paramDownloadInfo.ell));
      localHashMap.put(TMAssistantDownloadConst.PARAM_IS_AUTOINSTALL_BY_SDK, String.valueOf(paramDownloadInfo.isAutoInstallBySDK));
      localHashMap.put(TMAssistantDownloadConst.PARAM_DOWNLOADSIZE, String.valueOf(paramDownloadInfo.fileSize));
      localHashMap.put(TMAssistantDownloadConst.PARAM_QQ_SOURCE_ID, paramDownloadInfo.source);
      ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.13(this, (String)localObject2, localHashMap, i, paramDownloadInfo, (DownloadInfo)localObject1));
      try
      {
        arvu.a((AppInterface)this.iN.get(), paramDownloadInfo);
        return;
      }
      catch (Throwable paramDownloadInfo) {}
      arwk.q(paramDownloadInfo);
      break;
    }
  }
  
  private void i(DownloadInfo paramDownloadInfo)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.16(this, paramDownloadInfo));
  }
  
  private void k(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null)
    {
      this.jl.remove(paramDownloadInfo.ticket);
      arvt.a().Xn(paramDownloadInfo.ticket);
    }
  }
  
  private static int kO(int paramInt)
  {
    return aryy.kO(paramInt);
  }
  
  private void o(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_Aryp != null)
    {
      this.jdField_a_of_type_Aryp.a(paramDownloadInfo.packageName, paramDownloadInfo.versionCode, null);
      return;
    }
    this.jdField_a_of_type_Aryp = null;
  }
  
  private void p(DownloadInfo paramDownloadInfo)
  {
    arwt.i("DownloadManagerV2", "[getApkCodeAsync]");
    if (paramDownloadInfo == null)
    {
      arwt.i("DownloadManagerV2", "[getApkCodeAsync] info is null......");
      return;
    }
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.21(this, paramDownloadInfo));
  }
  
  public ConcurrentHashMap<String, DownloadInfo> E()
  {
    return this.jl;
  }
  
  public boolean L(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return M(DownloadInfo.qI(paramString), paramBoolean);
  }
  
  public boolean N(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return O(DownloadInfo.qI(paramString), paramBoolean);
  }
  
  public void Un(boolean paramBoolean)
  {
    Object localObject1 = this.jl.values().iterator();
    int i = 0;
    String str = "";
    Object localObject2 = new ArrayList();
    if (((Iterator)localObject1).hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)((Iterator)localObject1).next();
      if ((localDownloadInfo == null) || (localDownloadInfo.getState() == 4) || (localDownloadInfo.getState() == 1) || (localDownloadInfo.downloadType != 1)) {
        break label295;
      }
      ((ArrayList)localObject2).add(localDownloadInfo);
      if ((!TextUtils.isEmpty(str)) || (arxn.appIsExists(localDownloadInfo.packageName))) {
        break label292;
      }
      str = localDownloadInfo.pushTitle;
      label118:
      i += 1;
    }
    label274:
    label292:
    label295:
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
          break label274;
        }
      }
      for (str = str + acfp.m(2131705288);; str = "")
      {
        str = str + i + acfp.m(2131705295);
        if (!bool) {
          break;
        }
        arxa.a().showToast(str, 1);
        return;
      }
      arzk.a().aU(true, str);
      return;
      break label118;
    }
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
      arwt.v("DownloadManagerV2", "OpenSDK getTaskInfoFromMyApp param SNGAppId=" + paramDownloadInfo.appId + " apkId=" + paramDownloadInfo.cCL + " taskAppId=" + paramDownloadInfo.cDG + " packageName=" + paramDownloadInfo.packageName + " version=" + paramDownloadInfo.versionCode + " via=" + paramDownloadInfo.via);
      paramDownloadInfo = arzk.a().a(localBundle);
      if (paramDownloadInfo != null) {}
      try
      {
        arwt.v("DownloadManagerV2", "OpenSDK getTaskInfoFromMyApp result taskInfo path=" + paramDownloadInfo.mSavePath + " state=" + paramDownloadInfo.mState);
        return paramDownloadInfo;
      }
      catch (Exception localException1) {}
      arwt.v("DownloadManagerV2", "OpenSDK getTaskInfoFromMyApp result taskInfo is null");
      return paramDownloadInfo;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        paramDownloadInfo = null;
      }
    }
    arwt.i("DownloadManagerV2", "getTaskInfoFromMyApp>>>" + localException1.getMessage());
    return paramDownloadInfo;
  }
  
  public void a(aryx paramaryx)
  {
    try
    {
      if (!this.Q.contains(paramaryx)) {
        this.Q.add(paramaryx);
      }
      return;
    }
    finally
    {
      paramaryx = finally;
      throw paramaryx;
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
      arwt.i("DownloadManagerV2", "reportDownloadResult info.packageName = " + paramDownloadInfo.packageName + ",info.urlStr = " + paramDownloadInfo.urlStr + ",info.filePath = " + paramDownloadInfo.filePath);
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
  
  /* Error */
  public void a(DownloadInfo paramDownloadInfo, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +19 -> 22
    //   6: aload_1
    //   7: invokevirtual 1098	com/tencent/open/downloadnew/DownloadInfo:emb	()V
    //   10: aload_1
    //   11: getfield 773	com/tencent/open/downloadnew/DownloadInfo:ticket	Ljava/lang/String;
    //   14: invokestatic 537	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: istore_3
    //   18: iload_3
    //   19: ifeq +6 -> 25
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    //   25: ldc 59
    //   27: new 129	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 1100
    //   37: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: getfield 455	com/tencent/open/downloadnew/DownloadInfo:appId	Ljava/lang/String;
    //   44: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc_w 1102
    //   50: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_1
    //   54: getfield 458	com/tencent/open/downloadnew/DownloadInfo:packageName	Ljava/lang/String;
    //   57: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: ldc_w 1055
    //   63: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: getfield 649	com/tencent/open/downloadnew/DownloadInfo:filePath	Ljava/lang/String;
    //   70: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 67	arwt:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_0
    //   80: getfield 43	arvv:jl	Ljava/util/concurrent/ConcurrentHashMap;
    //   83: aload_1
    //   84: getfield 773	com/tencent/open/downloadnew/DownloadInfo:ticket	Ljava/lang/String;
    //   87: aload_1
    //   88: invokevirtual 1103	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   91: pop
    //   92: new 1105	com/tencent/open/appstore/dl/DownloadManagerV2$17
    //   95: dup
    //   96: aload_0
    //   97: aload_1
    //   98: iload_2
    //   99: invokespecial 1108	com/tencent/open/appstore/dl/DownloadManagerV2$17:<init>	(Larvv;Lcom/tencent/open/downloadnew/DownloadInfo;Z)V
    //   102: bipush 32
    //   104: aconst_null
    //   105: iconst_1
    //   106: invokestatic 175	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   109: goto -87 -> 22
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	arvv
    //   0	117	1	paramDownloadInfo	DownloadInfo
    //   0	117	2	paramBoolean	boolean
    //   17	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   6	18	112	finally
    //   25	109	112	finally
  }
  
  public void a(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt)
  {
    DownloadInfo localDownloadInfo2 = g(paramTMAssistantCallYYBParamStruct.SNGAppId);
    DownloadInfo localDownloadInfo1 = localDownloadInfo2;
    if (localDownloadInfo2 == null)
    {
      localDownloadInfo1 = arzk.a().a(paramTMAssistantCallYYBParamStruct, null);
      j(localDownloadInfo1);
    }
    localDownloadInfo1.progress = paramInt;
    localDownloadInfo1.setState(2);
    b(2, localDownloadInfo1);
  }
  
  public void a(TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, int paramInt1, TMAssistantCallYYBTaskInfo paramTMAssistantCallYYBTaskInfo, int paramInt2, String paramString)
  {
    int i = kO(paramInt1);
    DownloadInfo localDownloadInfo = b(paramTMAssistantCallYYBParamStruct.SNGAppId, i);
    if ((localDownloadInfo == null) && (paramInt1 != 6))
    {
      paramTMAssistantCallYYBTaskInfo = arzk.a().a(paramTMAssistantCallYYBParamStruct, null);
      j(paramTMAssistantCallYYBTaskInfo);
      b(paramTMAssistantCallYYBParamStruct.SNGAppId, i);
    }
    for (paramTMAssistantCallYYBParamStruct = paramTMAssistantCallYYBTaskInfo; paramTMAssistantCallYYBParamStruct != null; paramTMAssistantCallYYBParamStruct = localDownloadInfo) {
      for (;;)
      {
        arwt.i("DownloadManagerV2", "onYYBDownloadTaskStateChanged notifyListener localState=" + i + " dlInfo=" + paramTMAssistantCallYYBParamStruct.toString());
        a(i, paramTMAssistantCallYYBParamStruct, paramInt2, paramString);
        return;
        if (((paramInt1 == 2) || (paramInt1 == 3)) && (arzk.a().aHz()))
        {
          if (paramTMAssistantCallYYBTaskInfo != null) {}
          try
          {
            long l1 = paramTMAssistantCallYYBTaskInfo.mReceiveDataLen;
            long l2 = paramTMAssistantCallYYBTaskInfo.mTotalDataLen;
            paramInt1 = (int)((float)l1 * 100.0F / (float)l2);
            localDownloadInfo.progress = paramInt1;
            arwt.i("DownloadManagerV2", "onYYBDownloadTaskStateChanged info progress = " + paramInt1);
            paramTMAssistantCallYYBParamStruct = localDownloadInfo;
          }
          catch (Exception paramTMAssistantCallYYBParamStruct)
          {
            arwt.e("DownloadManagerV2", "onYYBDownloadTaskStateChanged>>>", paramTMAssistantCallYYBParamStruct);
          }
        }
      }
    }
    arwt.i("DownloadManagerV2", "onYYBDownloadTaskStateChanged notifyListener error dlInfo == null");
  }
  
  public boolean a(aryp paramaryp)
  {
    if (paramaryp == null) {
      return false;
    }
    this.jdField_a_of_type_Aryp = paramaryp;
    return true;
  }
  
  public boolean a(DownloadInfo paramDownloadInfo, boolean paramBoolean)
  {
    Object localObject3 = null;
    if (paramDownloadInfo == null)
    {
      arwt.v("DownloadManagerV2", "installDownload info == null");
      return false;
    }
    if (!paramDownloadInfo.ddw)
    {
      arwt.v("DownloadManagerV2", "installDownload info is not apk");
      return false;
    }
    Object localObject1 = "";
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo;
    if (TextUtils.isEmpty(paramDownloadInfo.filePath)) {
      if (paramDownloadInfo.downloadType == 0)
      {
        localTMAssistantDownloadTaskInfo = b(paramDownloadInfo.urlStr);
        localObject2 = localObject1;
        if (localTMAssistantDownloadTaskInfo != null)
        {
          localObject2 = localObject1;
          if (localTMAssistantDownloadTaskInfo.mState == 4) {
            localObject2 = localTMAssistantDownloadTaskInfo.mSavePath;
          }
        }
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          localTMAssistantDownloadTaskInfo = a(paramDownloadInfo);
          localObject1 = localObject2;
          localObject3 = localTMAssistantDownloadTaskInfo;
          if (localTMAssistantDownloadTaskInfo != null)
          {
            paramDownloadInfo.downloadType = 1;
            localObject3 = localTMAssistantDownloadTaskInfo;
            localObject1 = localObject2;
          }
        }
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if (((TMAssistantDownloadTaskInfo)localObject3).mState == 4) {
            localObject2 = ((TMAssistantDownloadTaskInfo)localObject3).mSavePath;
          }
        }
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          paramDownloadInfo.filePath = ((String)localObject2);
          paramDownloadInfo.setState(4);
          j(paramDownloadInfo);
        }
      }
    }
    for (localObject1 = localObject2;; localObject1 = paramDownloadInfo.filePath)
    {
      if (new File((String)localObject1).canRead()) {
        break label301;
      }
      arwt.i("DownloadManagerV2", "can't read apk file. installDownload localAPKPath=" + (String)localObject1);
      return false;
      localTMAssistantDownloadTaskInfo = a(paramDownloadInfo);
      localObject2 = localObject1;
      if (localTMAssistantDownloadTaskInfo != null)
      {
        localObject2 = localObject1;
        if (localTMAssistantDownloadTaskInfo.mState == 4) {
          localObject2 = localTMAssistantDownloadTaskInfo.mSavePath;
        }
      }
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        break;
      }
      localObject3 = b(paramDownloadInfo.urlStr);
      localObject1 = localObject2;
      break;
    }
    label301:
    Object localObject2 = arxn.lh((String)localObject1);
    arwt.i("DownloadManagerV2", "installDownload localAPKPath=" + (String)localObject1 + ", apkPackageName=" + (String)localObject2 + " updateType=" + paramDownloadInfo.updateType);
    if (localObject2 != null)
    {
      arwt.d("DownloadManagerV2", "[installDownload] begin sendCheckDownloadReq pkgname=" + (String)localObject2);
      a(paramDownloadInfo, (String)localObject1, (String)localObject2, paramBoolean);
      return true;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      arwt.v("DownloadManagerV2", "package invaild del file");
    }
    try
    {
      localObject1 = new File((String)localObject1);
      if (((File)localObject1).exists()) {
        ((File)localObject1).delete();
      }
      label434:
      a(-2, paramDownloadInfo, -24, "");
      return false;
    }
    catch (Exception localException)
    {
      break label434;
    }
  }
  
  protected List<DownloadInfo> ap(int paramInt)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.jl.values().iterator();
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
  
  public TMAssistantDownloadTaskInfo b(String paramString)
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2 = null;
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
    if (!TextUtils.isEmpty(paramString)) {
      localTMAssistantDownloadTaskInfo1 = localTMAssistantDownloadTaskInfo2;
    }
    try
    {
      long l1 = System.currentTimeMillis();
      localTMAssistantDownloadTaskInfo1 = localTMAssistantDownloadTaskInfo2;
      TMAssistantDownloadClient localTMAssistantDownloadClient = a();
      localTMAssistantDownloadTaskInfo1 = localTMAssistantDownloadTaskInfo2;
      long l2 = System.currentTimeMillis();
      localTMAssistantDownloadTaskInfo1 = localTMAssistantDownloadTaskInfo2;
      localTMAssistantDownloadTaskInfo2 = localTMAssistantDownloadClient.getDownloadTaskState(paramString);
      localTMAssistantDownloadTaskInfo1 = localTMAssistantDownloadTaskInfo2;
      long l3 = System.currentTimeMillis();
      localTMAssistantDownloadTaskInfo1 = localTMAssistantDownloadTaskInfo2;
      arwt.e("NEW_QAPP_TIME_COST", "step1=" + (l2 - l1) + ",step2=" + (l3 - l2));
      localTMAssistantDownloadTaskInfo1 = localTMAssistantDownloadTaskInfo2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        arwt.e("DownloadManagerV2", "downloadSDKClient>>>", localException);
      }
    }
    if (localTMAssistantDownloadTaskInfo1 == null) {
      arwt.v("DownloadManagerV2", "getTaskInfoFromSDK null url=" + paramString);
    }
    return localTMAssistantDownloadTaskInfo1;
  }
  
  public void b(int paramInt, DownloadInfo paramDownloadInfo)
  {
    a(paramInt, paramDownloadInfo, 0, "");
  }
  
  public void b(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    new Handler(Looper.getMainLooper()).post(new DownloadManagerV2.19(this, paramBundle, paramActivity, paramString, paramApkUpdateDetail, paramInt));
  }
  
  public void b(aryx paramaryx)
  {
    try
    {
      if (this.Q.contains(paramaryx)) {
        this.Q.remove(paramaryx);
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
      ThreadManager.excute(new DownloadManagerV2.12(this, paramDownloadInfo), 16, null, true);
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
    while ((this.jdField_a_of_type_Aryp == null) || (paramaryp != this.jdField_a_of_type_Aryp)) {
      return false;
    }
    this.jdField_a_of_type_Aryp = null;
    return true;
  }
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo == null) {}
    for (;;)
    {
      try
      {
        arwt.i("DownloadManagerV2", "[onDownloadComplete] info == null ");
        return;
      }
      finally {}
      if (((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) && ("com.tencent.mobileqq".equals(paramDownloadInfo.packageName)) && (accy.ad((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()))) {
        paramDownloadInfo.isAutoInstall = false;
      }
      arwt.i("DownloadManagerV2", "[onDownloadComplete] complete, info = " + paramDownloadInfo.toString());
      if (paramDownloadInfo.downloadType == 0)
      {
        if (paramDownloadInfo.updateType == 1) {
          i(paramDownloadInfo);
        } else {
          d(paramDownloadInfo);
        }
      }
      else {
        ThreadManager.excute(new DownloadManagerV2.6(this, paramDownloadInfo), 32, null, true);
      }
    }
  }
  
  public void cancelNotification(String paramString)
  {
    if ((paramString != null) && (paramString.trim().length() > 0)) {
      asab.a().Xt(paramString);
    }
  }
  
  public DownloadInfo d(String paramString)
  {
    Object localObject;
    if (paramString == null)
    {
      arwt.v("DownloadManagerV2", "getDownloadInfoByTicket ticket == null");
      localObject = null;
    }
    DownloadInfo localDownloadInfo;
    do
    {
      return localObject;
      localDownloadInfo = (DownloadInfo)this.jl.get(paramString);
      localObject = localDownloadInfo;
    } while (localDownloadInfo != null);
    ThreadManager.excute(new DownloadManagerV2.11(this, paramString), 16, null, true);
    return localDownloadInfo;
  }
  
  public boolean d(DownloadInfo paramDownloadInfo)
  {
    return a(paramDownloadInfo, true);
  }
  
  public DownloadInfo e(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      arwt.v("DownloadManagerV2", "getDownloadInfoByTicket ticket == null");
      return null;
    }
    return d(DownloadInfo.qI(paramString));
  }
  
  public boolean e(DownloadInfo paramDownloadInfo)
  {
    arwt.v("DownloadManagerV2", "refreshDownloadInfo DownloadInfo=" + paramDownloadInfo);
    DownloadInfo localDownloadInfo = d(paramDownloadInfo.ticket);
    if (localDownloadInfo == null) {
      localDownloadInfo = f(paramDownloadInfo.packageName);
    }
    for (;;)
    {
      if (localDownloadInfo != null)
      {
        arwt.v("DownloadManagerV2", "refreshDownloadInfo cacheInfo =" + localDownloadInfo);
        Object localObject;
        if (localDownloadInfo.downloadType == 0)
        {
          arwt.v("DownloadManagerV2", "refreshDownloadInfo DownloadInfo.DOWNLOAD_TYPE_DOWNLOADSDK......");
          paramDownloadInfo.from = localDownloadInfo.from;
          if (localDownloadInfo.updateType == 1)
          {
            localObject = localDownloadInfo.cDF;
            localObject = a().b((String)localObject);
            if (localObject == null) {
              break label319;
            }
            arwt.v("DownloadManagerV2", "refreshDownloadInfo sdk getReceiveDataLen=" + ((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen + " getTotalDataLen=" + ((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen);
            paramDownloadInfo.progress = ((int)((float)((TMAssistantDownloadTaskInfo)localObject).mReceiveDataLen * 100.0F / (float)((TMAssistantDownloadTaskInfo)localObject).mTotalDataLen));
            paramDownloadInfo.setState(kO(((TMAssistantDownloadTaskInfo)localObject).mState));
            paramDownloadInfo.downloadType = 0;
            if (localDownloadInfo.updateType != 1) {
              break label307;
            }
            if (!TextUtils.isEmpty(localDownloadInfo.filePath)) {
              break label295;
            }
            paramDownloadInfo.filePath = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
          }
          for (;;)
          {
            if (paramDownloadInfo.getState() == 4)
            {
              paramDownloadInfo.elm = localDownloadInfo.elm;
              if (paramDownloadInfo.elm != 0)
              {
                paramDownloadInfo.setState(3);
                j(localDownloadInfo);
              }
            }
            return true;
            localObject = localDownloadInfo.urlStr;
            break;
            label295:
            paramDownloadInfo.filePath = localDownloadInfo.filePath;
            continue;
            label307:
            paramDownloadInfo.filePath = ((TMAssistantDownloadTaskInfo)localObject).mSavePath;
          }
          label319:
          k(localDownloadInfo);
          paramDownloadInfo.setState(-100);
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
          k(localDownloadInfo);
        }
      }
      return false;
    }
  }
  
  public void elQ()
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.4(this));
  }
  
  protected void elS()
  {
    if (this.jl.size() > 200) {
      ThreadManager.getSubThreadHandler().postDelayed(new DownloadManagerV2.20(this), 3000L);
    }
  }
  
  public DownloadInfo f(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Iterator localIterator = this.jl.values().iterator();
      while (localIterator.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
        if (paramString.equals(localDownloadInfo.packageName)) {
          return localDownloadInfo;
        }
      }
    }
    return null;
  }
  
  public void f(DownloadInfo paramDownloadInfo, int paramInt)
  {
    arwt.i("DownloadManagerV2", "onReveiveInstallIntent info=" + paramDownloadInfo);
    if (paramDownloadInfo.downloadType == 0) {
      arwk.g(paramDownloadInfo, paramInt);
    }
    if (!"5".equals(paramDownloadInfo.source)) {
      dx(paramDownloadInfo.ticket, false);
    }
    asab.a().Xt(paramDownloadInfo.sendTime);
  }
  
  public int fx(String paramString)
  {
    return fy(DownloadInfo.qI(paramString));
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
          arwt.e("DownloadManagerV2", "getQQAppInterface>>>", localException);
        }
      }
      localObject1 = this.iN;
      return localObject1;
    }
    finally {}
  }
  
  public boolean isMainProcess()
  {
    return BaseApplicationImpl.sProcessId == 1;
  }
  
  public void j(DownloadInfo paramDownloadInfo)
  {
    a(paramDownloadInfo, false);
  }
  
  public void l(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      a().b(9, paramDownloadInfo);
    }
  }
  
  public void m(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null)
    {
      f(paramDownloadInfo, 2);
      a().b(13, paramDownloadInfo);
    }
  }
  
  public void n(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null)
    {
      f(paramDownloadInfo, 1);
      a().b(6, paramDownloadInfo);
    }
  }
  
  public void onDownloadSDKTaskProgressChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString, long paramLong1, long paramLong2)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.24(this, paramString, paramLong1, paramLong2));
  }
  
  public void onDownloadSDKTaskStateChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadManagerV2.23(this, paramTMAssistantDownloadClient, paramInt1, paramString1, paramInt2, paramString2));
  }
  
  public void onDwonloadSDKServiceInvalid(TMAssistantDownloadClient paramTMAssistantDownloadClient)
  {
    arwt.e("DownloadManagerV2", "OnDwonloadSDKServiceInvalid");
  }
  
  public String qz(String paramString)
  {
    paramString = d(paramString);
    if (paramString != null) {
      return paramString.filePath;
    }
    return "";
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
      arwt.e("DownloadManagerV2", "showToast>>>", paramString);
    }
  }
  
  public List<DownloadInfo> y(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    Iterator localIterator = this.jl.values().iterator();
    while (localIterator.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)localIterator.next();
      if ((paramString.equals(localDownloadInfo.packageName)) && (localDownloadInfo.getState() == paramInt)) {
        localArrayList.add(localDownloadInfo);
      }
    }
    return localArrayList;
  }
  
  public List<DownloadInfo> z(String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    paramString = arvt.a().bi(paramString).iterator();
    while (paramString.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)paramString.next();
      if (localDownloadInfo.getState() == paramInt) {
        localArrayList.add(localDownloadInfo);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arvv
 * JD-Core Version:    0.7.0.1
 */