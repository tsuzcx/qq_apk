import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.1;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager.2;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantbase.util.GlobalUtil;
import cooperation.wadl.ipc.WadlParams;
import cooperation.wadl.ipc.WadlResult;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

public class jzg
  implements aryx, awoe
{
  protected List<mrm> fP = new CopyOnWriteArrayList();
  protected List<mrm> fQ = new CopyOnWriteArrayList();
  public Context mContext;
  protected Handler mSubHandler;
  protected Handler mainHandler = new Handler(Looper.getMainLooper());
  
  public jzg(Context paramContext)
  {
    this.mContext = paramContext;
    this.mSubHandler = new Handler(ThreadManager.getSubThreadLooper());
    aBs();
    awok.a().a(this);
    arvv.a().a(this);
  }
  
  public static boolean B(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        return false;
        paramContext = arvv.a().f(paramString);
      } while ((paramContext == null) || (TextUtils.isEmpty(paramContext.filePath)));
      paramContext = paramContext.filePath;
    } while ((TextUtils.isEmpty(paramContext)) || (!new File(paramContext).exists()));
    return true;
  }
  
  public static int a(WadlResult paramWadlResult)
  {
    int i = 5;
    if (4 == paramWadlResult.bBa) {
      i = 3;
    }
    while (6 == paramWadlResult.bBa) {
      return i;
    }
    if (5 == paramWadlResult.bBa) {
      return 4;
    }
    if ((9 == paramWadlResult.bBa) || (10 == paramWadlResult.bBa)) {
      return 1;
    }
    if (7 == paramWadlResult.bBa) {
      return 6;
    }
    return 0;
  }
  
  private void a(Activity paramActivity, mrm parammrm)
  {
    int j = 0;
    int i = 0;
    if ((paramActivity == null) || (parammrm == null)) {
      return;
    }
    if ((TextUtils.isEmpty(parammrm.mDownloadUrl)) && (!TextUtils.isEmpty(parammrm.ajG))) {
      parammrm.mDownloadUrl = z(parammrm.ajG, 0);
    }
    if (TextUtils.isEmpty(parammrm.mDownloadUrl))
    {
      if (parammrm.advertisementInfo != null) {
        i = parammrm.advertisementInfo.progress;
      }
      for (;;)
      {
        a(parammrm, 6, i);
        return;
        if (parammrm.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null) {
          i = parammrm.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.progress;
        } else if (parammrm.gameAdComData != null) {
          i = parammrm.gameAdComData.progress;
        }
      }
    }
    String str1 = parammrm.mPackageName;
    String str2 = parammrm.mAppID;
    String str3 = parammrm.mDownloadUrl;
    String str4 = parammrm.mAppName;
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str4)))
    {
      if (parammrm.advertisementInfo != null) {
        i = parammrm.advertisementInfo.progress;
      }
      for (;;)
      {
        a(parammrm, 6, i);
        return;
        if (parammrm.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData != null)
        {
          i = parammrm.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.progress;
        }
        else
        {
          i = j;
          if (parammrm.gameAdComData != null) {
            i = parammrm.gameAdComData.progress;
          }
        }
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putString(aryv.PARAM_TASK_PACKNAME, str1);
    localBundle.putString(aryv.PARAM_SNG_APPID, str2);
    localBundle.putString(aryv.PARAM_URL, str3);
    localBundle.putString(aryv.PARAM_APPNAME, str4);
    localBundle.putInt(aryv.PARAM_ACTIONCODE, 2);
    localBundle.putInt(aryv.PARAM_WOWNLOAD_TYPE, 0);
    localBundle.putBoolean(aryv.PARAM_BLOCK_NOTIFY, false);
    localBundle.putInt(aryv.PARAM_SHOW_NOTIFICATION, 0);
    localBundle.putBoolean(aryv.PARAM_IS_APK, true);
    localBundle.putBoolean(aryv.PARAM_AUTO_INSTALL, true);
    localBundle.putBoolean(aryv.PARAM_SHOW_NETWORK_DIALOG, false);
    localBundle.putBoolean(aryv.PARAM_IS_AUTOINSTALL_BY_SDK, false);
    localBundle.putString("sendTime", "_" + GlobalUtil.calcMD5AsString(str3));
    if (!TextUtils.isEmpty(parammrm.via)) {
      localBundle.putString(aryv.PARAM_VIA, parammrm.via);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "startRealDownload pkg:" + str1 + ", appid:" + str2 + ", name:" + str4 + ", url:" + str3);
    }
    if (this.fP.contains(parammrm)) {
      this.fP.remove(parammrm);
    }
    this.fP.add(parammrm);
    arvz.a().d(paramActivity, localBundle, "biz_src_feeds_kandianads", null, 0);
  }
  
  private void a(mrm parammrm)
  {
    if (parammrm.jdField_a_of_type_CooperationWadlIpcWadlParams == null) {
      parammrm.jdField_a_of_type_CooperationWadlIpcWadlParams = a(parammrm);
    }
    b(parammrm);
    awok.a().h(parammrm.jdField_a_of_type_CooperationWadlIpcWadlParams);
    if (this.fP.contains(parammrm)) {
      this.fP.remove(parammrm);
    }
    this.fP.add(parammrm);
  }
  
  public static boolean a(Context paramContext, mrm parammrm)
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramContext != null)
    {
      if (parammrm != null) {
        break label22;
      }
      bool2 = bool1;
    }
    label22:
    String str1;
    String str2;
    DownloadInfo localDownloadInfo;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool2;
            str1 = parammrm.mPackageName;
            str2 = parammrm.mAppID;
            bool2 = bool1;
          } while (TextUtils.isEmpty(str1));
          bool2 = bool1;
        } while (TextUtils.isEmpty(str2));
        localDownloadInfo = arvv.a().f(str1);
        bool2 = bool1;
      } while (localDownloadInfo == null);
      parammrm = "";
      if (TextUtils.isEmpty(localDownloadInfo.filePath)) {
        break;
      }
      parammrm = localDownloadInfo.filePath;
      bool1 = bool3;
      if (!TextUtils.isEmpty(parammrm))
      {
        bool1 = bool3;
        if (new File(parammrm).exists()) {
          bool1 = true;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ADBaseAppDownloadManager", 2, "isPkgExist(" + bool1 + ") pkg:" + str1 + ", appid:" + str2 + ", path:" + parammrm);
    return bool1;
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
    if (localDownloadInfo.downloadType == 0)
    {
      localTMAssistantDownloadTaskInfo2 = arvv.a().b(localDownloadInfo.urlStr);
      paramContext = parammrm;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        paramContext = parammrm;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      parammrm = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localTMAssistantDownloadTaskInfo1 = arvv.a().a(localDownloadInfo);
        parammrm = paramContext;
      }
    }
    for (;;)
    {
      paramContext = parammrm;
      if (localTMAssistantDownloadTaskInfo1 != null)
      {
        paramContext = parammrm;
        if (localTMAssistantDownloadTaskInfo1.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo1.mSavePath;
        }
      }
      parammrm = paramContext;
      if (TextUtils.isEmpty(paramContext)) {
        break;
      }
      localDownloadInfo.filePath = paramContext;
      localDownloadInfo.setState(4);
      arvv.a().j(localDownloadInfo);
      parammrm = paramContext;
      break;
      localTMAssistantDownloadTaskInfo2 = arvv.a().a(localDownloadInfo);
      paramContext = parammrm;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        paramContext = parammrm;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      parammrm = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localTMAssistantDownloadTaskInfo1 = arvv.a().b(localDownloadInfo.urlStr);
        parammrm = paramContext;
      }
    }
  }
  
  public static boolean a(mrm parammrm, int paramInt)
  {
    do
    {
      try
      {
        if (!parammrm.anA) {
          break;
        }
        if (!TextUtils.isEmpty(parammrm.ajH)) {
          continue;
        }
        if (TextUtils.isEmpty(parammrm.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.ajH)) {
          break;
        }
      }
      catch (Exception parammrm)
      {
        return false;
      }
      if (TextUtils.isEmpty(parammrm.ajH)) {}
      for (parammrm = parammrm.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataAdData.ajH; new File(parammrm).exists(); parammrm = parammrm.ajH) {
        return true;
      }
    } while ((paramInt != 3) && (paramInt != 4));
    return false;
  }
  
  private void aBt()
  {
    arvv.a().b(this);
    this.mainHandler.removeCallbacksAndMessages(null);
    this.mSubHandler.removeCallbacksAndMessages(null);
  }
  
  protected WadlParams a(mrm parammrm)
  {
    WadlParams localWadlParams = new WadlParams(parammrm.mAppID, parammrm.mPackageName);
    localWadlParams.flags = 7;
    localWadlParams.ekZ = 2;
    localWadlParams.bLF = (parammrm.aaJ + "@" + parammrm.aaK);
    localWadlParams.apkUrl = parammrm.mDownloadUrl;
    localWadlParams.appName = parammrm.mAppName;
    localWadlParams.sourceId = "biz_src_feeds_kandianads";
    localWadlParams.via = "qq_vas_game";
    return localWadlParams;
  }
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt) {}
  
  protected void a(WadlResult paramWadlResult, int paramInt) {}
  
  public void a(mrm parammrm, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "startDownload " + parammrm.mPackageName + " progress " + paramInt);
    }
    parammrm.mState = 3;
    arvv.a().a(this);
    a((Activity)this.mContext, parammrm);
  }
  
  public void a(mrm parammrm, int paramInt1, int paramInt2) {}
  
  public void a(mrm parammrm, boolean paramBoolean)
  {
    if ((paramBoolean) && (parammrm.jdField_a_of_type_CooperationWadlIpcWadlParams == null)) {
      parammrm.jdField_a_of_type_CooperationWadlIpcWadlParams = a(parammrm);
    }
    if ((parammrm.anA) && (parammrm.jdField_a_of_type_CooperationWadlIpcWadlParams != null)) {
      awok.a().eE(0, parammrm.mAppID);
    }
    do
    {
      return;
      e(parammrm);
      parammrm = parammrm.mDownloadUrl;
    } while (TextUtils.isEmpty(parammrm));
    arvv.a().fx(parammrm);
  }
  
  public boolean a(mrm parammrm)
  {
    if (parammrm != null) {
      ThreadManager.excute(new ADBaseAppDownloadManager.1(this, parammrm), 128, null, true);
    }
    return false;
  }
  
  protected void aBs() {}
  
  protected void b(mrm parammrm) {}
  
  public void b(mrm parammrm, int paramInt)
  {
    ThreadManager.executeOnSubThread(new ADBaseAppDownloadManager.2(this, parammrm, paramInt));
  }
  
  public boolean b(mrm parammrm)
  {
    return true;
  }
  
  protected String c(JSONObject paramJSONObject)
  {
    Object localObject;
    if (paramJSONObject == null) {
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      try
      {
        paramJSONObject = paramJSONObject.optString("apkUrl");
        localObject = paramJSONObject;
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("ADBaseAppDownloadManager", 2, " parseDestLinkJson destLink = " + paramJSONObject);
            return paramJSONObject;
          }
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          paramJSONObject = "";
        }
      }
    }
    localException1.printStackTrace();
    QLog.d("ADBaseAppDownloadManager", 1, "parseDestLinkJson exception :" + localException1.toString());
    return paramJSONObject;
  }
  
  public void c(mrm parammrm)
  {
    if (parammrm.jdField_a_of_type_CooperationWadlIpcWadlParams == null) {
      parammrm.jdField_a_of_type_CooperationWadlIpcWadlParams = a(parammrm);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(parammrm.mAppID);
    if (!this.fQ.contains(parammrm))
    {
      this.fQ.clear();
      this.fQ.add(parammrm);
    }
    awok.a().fz(localArrayList);
    if (this.fP.contains(parammrm)) {
      this.fP.remove(parammrm);
    }
    this.fP.add(parammrm);
  }
  
  public boolean c(mrm parammrm)
  {
    return true;
  }
  
  protected String converStreamToString(InputStream paramInputStream)
    throws IOException
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      String str = paramInputStream.readLine();
      if (str == null) {
        break;
      }
      localStringBuffer.append(str);
    }
    return localStringBuffer.toString();
  }
  
  public void d(mrm parammrm)
  {
    if ((parammrm.anA) && (parammrm.jdField_a_of_type_CooperationWadlIpcWadlParams != null)) {
      awok.a().eE(0, parammrm.mAppID);
    }
    do
    {
      return;
      e(parammrm);
      parammrm = parammrm.mDownloadUrl;
    } while (TextUtils.isEmpty(parammrm));
    arvv.a().fx(parammrm);
  }
  
  public void doOnDestory()
  {
    aBt();
    awok.a().b(this);
    this.mContext = null;
  }
  
  public void e(mrm parammrm)
  {
    if ((TextUtils.isEmpty(parammrm.mDownloadUrl)) && (this.fP.size() > 0) && (parammrm.DV()))
    {
      Iterator localIterator = this.fP.iterator();
      while (localIterator.hasNext())
      {
        mrm localmrm = (mrm)localIterator.next();
        if ((localmrm.DV()) && (!TextUtils.isEmpty(localmrm.mDownloadUrl)) && (parammrm.e(localmrm))) {
          parammrm.mDownloadUrl = localmrm.mDownloadUrl;
        }
      }
    }
  }
  
  public void f(mrm parammrm)
  {
    if (parammrm.jdField_a_of_type_CooperationWadlIpcWadlParams == null) {
      parammrm.jdField_a_of_type_CooperationWadlIpcWadlParams = a(parammrm);
    }
    awok.a().c(parammrm.jdField_a_of_type_CooperationWadlIpcWadlParams);
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "installSucceed " + paramString2);
    }
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.appId = paramString1;
    localDownloadInfo.packageName = paramString2;
    a(localDownloadInfo, 1);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "onDownloadCancel " + paramDownloadInfo.packageName);
    }
    a(paramDownloadInfo, 7);
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "onDownloadError " + paramDownloadInfo.packageName);
    }
    a(paramDownloadInfo, 6);
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "onDownloadFinish " + paramDownloadInfo.packageName);
    }
    a(paramDownloadInfo, 5);
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "onDownloadPause " + paramDownloadInfo.packageName);
    }
    a(paramDownloadInfo, 4);
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ADBaseAppDownloadManager", 2, "onDownloadUpdate " + paramList.size());
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        a((DownloadInfo)paramList.next(), 3);
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "onDownloadWait " + paramDownloadInfo.packageName);
    }
  }
  
  public void onQueryCallback(ArrayList<WadlResult> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "onQueryCallback ");
    }
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      paramArrayList = this.fQ.iterator();
    }
    while (paramArrayList.hasNext())
    {
      a(new WadlResult(((mrm)paramArrayList.next()).jdField_a_of_type_CooperationWadlIpcWadlParams), 8);
      continue;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        a((WadlResult)paramArrayList.next(), 8);
      }
    }
  }
  
  public void onQueryCallbackVia(ArrayList<WadlResult> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "onQueryCallbackVia ");
    }
  }
  
  public void onWadlTaskStatusChanged(WadlResult paramWadlResult)
  {
    if ((paramWadlResult == null) || (paramWadlResult.jdField_a_of_type_CooperationWadlIpcWadlParams == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ADBaseAppDownloadManager", 2, "onWadlTaskStatusChanged，wadlResult.taskStatus=" + paramWadlResult.bBa);
      }
      if (4 == paramWadlResult.bBa)
      {
        a(paramWadlResult, 3);
        return;
      }
      if (6 == paramWadlResult.bBa)
      {
        a(paramWadlResult, 5);
        return;
      }
      if (5 == paramWadlResult.bBa)
      {
        a(paramWadlResult, 4);
        return;
      }
      if ((9 == paramWadlResult.bBa) || (10 == paramWadlResult.bBa))
      {
        a(paramWadlResult, 1);
        return;
      }
    } while (7 != paramWadlResult.bBa);
    a(paramWadlResult, 6);
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "packageReplaced " + paramString2);
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ADBaseAppDownloadManager", 2, "uninstallSucceed " + paramString2);
    }
  }
  
  /* Error */
  protected String z(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_1
    //   7: invokestatic 82	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifeq +6 -> 16
    //   13: aload 4
    //   15: areturn
    //   16: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +39 -> 58
    //   22: ldc 242
    //   24: iconst_2
    //   25: new 212	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 570
    //   35: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_1
    //   39: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc_w 572
    //   45: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload_2
    //   49: invokevirtual 394	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 254	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: invokestatic 240	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +29 -> 90
    //   64: ldc 242
    //   66: iconst_2
    //   67: new 212	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   74: ldc_w 574
    //   77: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_1
    //   81: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 254	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: new 576	java/net/URL
    //   93: dup
    //   94: aload_1
    //   95: invokespecial 577	java/net/URL:<init>	(Ljava/lang/String;)V
    //   98: invokevirtual 581	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   101: checkcast 583	java/net/HttpURLConnection
    //   104: astore_3
    //   105: aload_3
    //   106: ldc_w 585
    //   109: invokevirtual 588	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   112: aload_3
    //   113: ldc_w 590
    //   116: ldc_w 592
    //   119: invokevirtual 595	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_3
    //   123: ldc_w 597
    //   126: ldc_w 599
    //   129: invokevirtual 595	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload_3
    //   133: ldc_w 601
    //   136: ldc_w 603
    //   139: invokevirtual 595	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload_3
    //   143: sipush 3000
    //   146: invokevirtual 606	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   149: aload_3
    //   150: sipush 3000
    //   153: invokevirtual 609	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   156: aload_3
    //   157: invokevirtual 612	java/net/HttpURLConnection:getResponseCode	()I
    //   160: sipush 200
    //   163: if_icmpne +106 -> 269
    //   166: aload_0
    //   167: aload_3
    //   168: invokevirtual 616	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   171: invokevirtual 618	jzg:converStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   174: astore_1
    //   175: aload_1
    //   176: invokestatic 82	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   179: ifne +29 -> 208
    //   182: aload_0
    //   183: new 434	org/json/JSONObject
    //   186: dup
    //   187: aload_1
    //   188: invokespecial 619	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   191: invokevirtual 621	jzg:c	(Lorg/json/JSONObject;)Ljava/lang/String;
    //   194: astore_1
    //   195: aload_1
    //   196: astore 4
    //   198: aload_3
    //   199: ifnull -186 -> 13
    //   202: aload_3
    //   203: invokevirtual 624	java/net/HttpURLConnection:disconnect	()V
    //   206: aload_1
    //   207: areturn
    //   208: ldc 242
    //   210: iconst_1
    //   211: ldc_w 626
    //   214: invokestatic 254	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: aload 5
    //   219: astore_1
    //   220: goto -25 -> 195
    //   223: astore 5
    //   225: aload_3
    //   226: astore_1
    //   227: aload 5
    //   229: astore_3
    //   230: ldc 242
    //   232: iconst_1
    //   233: new 212	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   240: ldc_w 628
    //   243: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_3
    //   247: invokevirtual 445	java/lang/Exception:toString	()Ljava/lang/String;
    //   250: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 254	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: aload_1
    //   260: ifnull -247 -> 13
    //   263: aload_1
    //   264: invokevirtual 624	java/net/HttpURLConnection:disconnect	()V
    //   267: aconst_null
    //   268: areturn
    //   269: ldc 242
    //   271: iconst_1
    //   272: new 212	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 213	java/lang/StringBuilder:<init>	()V
    //   279: ldc_w 630
    //   282: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload_3
    //   286: invokevirtual 612	java/net/HttpURLConnection:getResponseCode	()I
    //   289: invokevirtual 394	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   292: invokevirtual 229	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 254	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   298: aload 5
    //   300: astore_1
    //   301: goto -106 -> 195
    //   304: astore 4
    //   306: aload_3
    //   307: astore_1
    //   308: aload 4
    //   310: astore_3
    //   311: aload_1
    //   312: ifnull +7 -> 319
    //   315: aload_1
    //   316: invokevirtual 624	java/net/HttpURLConnection:disconnect	()V
    //   319: aload_3
    //   320: athrow
    //   321: astore_3
    //   322: aconst_null
    //   323: astore_1
    //   324: goto -13 -> 311
    //   327: astore_3
    //   328: goto -17 -> 311
    //   331: astore_3
    //   332: aconst_null
    //   333: astore_1
    //   334: goto -104 -> 230
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	this	jzg
    //   0	337	1	paramString	String
    //   0	337	2	paramInt	int
    //   104	216	3	localObject1	Object
    //   321	1	3	localObject2	Object
    //   327	1	3	localObject3	Object
    //   331	1	3	localException1	Exception
    //   4	193	4	str	String
    //   304	5	4	localObject4	Object
    //   1	217	5	localObject5	Object
    //   223	76	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   105	195	223	java/lang/Exception
    //   208	217	223	java/lang/Exception
    //   269	298	223	java/lang/Exception
    //   105	195	304	finally
    //   208	217	304	finally
    //   269	298	304	finally
    //   90	105	321	finally
    //   230	259	327	finally
    //   90	105	331	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jzg
 * JD-Core Version:    0.7.0.1
 */