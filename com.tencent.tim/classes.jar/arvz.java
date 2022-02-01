import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.apkupdate.logic.data.ApkUpdateDetail;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.appstore.dl.DownloadProxy.2;
import com.tencent.open.appstore.dl.DownloadProxy.3;
import com.tencent.open.appstore.dl.DownloadProxy.6;
import com.tencent.open.appstore.dl.DownloadProxy.7;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.TMAssistantCallYYB_V1;
import com.tencent.tmdatasourcesdk.ITMAssistantExchangeURLListenner;
import com.tencent.tmdatasourcesdk.TMAssistantGetAppDetailTool;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class arvz
{
  private static volatile arvz a;
  private ITMAssistantExchangeURLListenner b = new arwa(this);
  private ConcurrentHashMap<String, Integer> jm = new ConcurrentHashMap();
  private final Object mLock = new Object();
  
  public static boolean G(Bundle paramBundle)
  {
    if (paramBundle.getInt(aryv.PARAM_ACTIONCODE) == 5)
    {
      String str2 = paramBundle.getString(aryv.PARAM_URL);
      if (TextUtils.isEmpty(str2))
      {
        arwt.e("DownloadResolver", "[installApp] url is empty");
        return false;
      }
      String str3 = paramBundle.getString(aryv.PARAM_TASK_PACKNAME);
      String str4 = paramBundle.getString(aryv.PARAM_VIA);
      String str5 = paramBundle.getString(aryv.PARAM_APPNAME);
      Object localObject = paramBundle.getString(aryv.PARAM_EXTRA_INFO);
      String str6 = paramBundle.getString("appId");
      String str7 = paramBundle.getString("apkId", "");
      String str8 = paramBundle.getString("recommendId", "");
      String str9 = paramBundle.getString(aryv.cDE, "");
      String str10 = paramBundle.getString("sourceFromServer", "");
      String str11 = paramBundle.getString("pageId", "");
      String str12 = paramBundle.getString("moduleId", "");
      String str13 = paramBundle.getString("positionId", "");
      String str14 = paramBundle.getString("big_brother_ref_source_key", "");
      String str1 = paramBundle.getString("big_brother_source_key");
      arxt.X("305", str4, str6, (String)localObject);
      localObject = arvv.a().e(str2);
      if (localObject == null)
      {
        localObject = new DownloadInfo();
        ((DownloadInfo)localObject).appId = str6;
        ((DownloadInfo)localObject).urlStr = str2.trim();
        ((DownloadInfo)localObject).packageName = str3;
        ((DownloadInfo)localObject).pushTitle = str5;
        ((DownloadInfo)localObject).via = str4;
        ((DownloadInfo)localObject).cDG = paramBundle.getString(aryv.PARAM_TASK_APPID);
        ((DownloadInfo)localObject).cCL = paramBundle.getString(aryv.PARAM_TASK_APK_ID);
        ((DownloadInfo)localObject).versionCode = paramBundle.getInt(aryv.PARAM_TASK_VERSION);
        ((DownloadInfo)localObject).extraData = paramBundle.getString(aryv.PARAM_EXTRA_INFO);
        ((DownloadInfo)localObject).cCL = str7;
        ((DownloadInfo)localObject).recommendId = str8;
        ((DownloadInfo)localObject).cCM = str10;
        ((DownloadInfo)localObject).channelId = str9;
        ((DownloadInfo)localObject).pageId = str11;
        ((DownloadInfo)localObject).kx = str12;
        ((DownloadInfo)localObject).cDH = str13;
        ((DownloadInfo)localObject).source = str1;
        ((DownloadInfo)localObject).ce("big_brother_ref_source_key", str14);
        ((DownloadInfo)localObject).emb();
        paramBundle = (Bundle)localObject;
      }
      for (;;)
      {
        return arvv.a().d(paramBundle);
        if (!TextUtils.isEmpty(str4)) {
          ((DownloadInfo)localObject).via = str4;
        }
        if (!TextUtils.isEmpty(str14)) {
          ((DownloadInfo)localObject).ce("big_brother_ref_source_key", str14);
        }
        paramBundle = (Bundle)localObject;
        if (!TextUtils.isEmpty(str1))
        {
          ((DownloadInfo)localObject).source = str1;
          paramBundle = (Bundle)localObject;
        }
      }
    }
    return false;
  }
  
  public static arvz a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new arvz();
      }
      return a;
    }
    finally {}
  }
  
  private String a(TMAssistantDownloadTaskInfo paramTMAssistantDownloadTaskInfo)
  {
    if (paramTMAssistantDownloadTaskInfo == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[mSavePath=" + paramTMAssistantDownloadTaskInfo.mSavePath);
    localStringBuilder.append("\n");
    localStringBuilder.append("mState=" + paramTMAssistantDownloadTaskInfo.mState);
    localStringBuilder.append("\n");
    localStringBuilder.append("mReceiveDataLen=" + paramTMAssistantDownloadTaskInfo.mReceiveDataLen);
    localStringBuilder.append("\n");
    localStringBuilder.append("mTotalDataLen=" + paramTMAssistantDownloadTaskInfo.mTotalDataLen);
    localStringBuilder.append("\n");
    localStringBuilder.append("mContentType=" + paramTMAssistantDownloadTaskInfo.mContentType);
    localStringBuilder.append("\n");
    localStringBuilder.append("mTaskPackageName=" + paramTMAssistantDownloadTaskInfo.mTaskPackageName);
    localStringBuilder.append("\n");
    localStringBuilder.append("mTaskVersionCode=" + paramTMAssistantDownloadTaskInfo.mTaskVersionCode);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  private int b(Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail)
  {
    if ("biz_src_jc_update".equals(paramString)) {
      arxt.X("200", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(aryv.PARAM_EXTRA_INFO));
    }
    arwt.i("DownloadResolver", "[doDownloadActionBySDK] pParmas =" + paramBundle);
    String str1 = paramBundle.getString(aryv.PARAM_URL);
    if (TextUtils.isEmpty(str1))
    {
      arwt.e("DownloadResolver", "[doDownloadActionBySDK] url is empty");
      return -1;
    }
    String str13 = paramBundle.getString(aryv.PARAM_TASK_PACKNAME);
    int i = paramBundle.getInt(aryv.PARAM_ACTIONCODE);
    String str14 = paramBundle.getString(aryv.PARAM_VIA);
    String str15 = paramBundle.getString(aryv.PARAM_APPNAME);
    String str12 = paramBundle.getString(aryv.PARAM_ICON_URL);
    int j = paramBundle.getInt(aryv.PARAM_SHOW_NOTIFICATION);
    String str11 = paramBundle.getString(aryv.PARAM_EXTRA_INFO);
    boolean bool1 = paramBundle.getBoolean(aryv.PARAM_PATCH_UPDATE);
    boolean bool2 = paramBundle.getBoolean(aryv.PARAM_IS_APK, true);
    boolean bool3 = paramBundle.getBoolean("is_qq_self_update_task", false);
    boolean bool4 = paramBundle.getBoolean(aryv.PARAM_AUTO_INSTALL, true);
    boolean bool5 = paramBundle.getBoolean(aryv.PARAM_BLOCK_NOTIFY);
    int k = paramBundle.getInt(aryv.cDD, 0);
    boolean bool6 = paramBundle.getBoolean(aryv.PARAM_IS_AUTOINSTALL_BY_SDK, false);
    String str16 = paramBundle.getString("appId");
    String str2 = paramBundle.getString("apkId", "");
    String str3 = paramBundle.getString("recommendId", "");
    String str4 = paramBundle.getString(aryv.cDE, "");
    String str5 = paramBundle.getString("sourceFromServer", "");
    String str6 = paramBundle.getString("pageId", "");
    String str7 = paramBundle.getString("moduleId", "");
    String str8 = paramBundle.getString("positionId", "");
    String str9 = paramBundle.getString("sendTime", "");
    String str10 = paramBundle.getString("big_brother_ref_source_key", "");
    Object localObject2 = null;
    Object localObject1 = localObject2;
    switch (i)
    {
    default: 
      localObject1 = localObject2;
    }
    for (;;)
    {
      arvu.a(11, str1, i, localObject1);
      return 0;
      localObject1 = new DownloadInfo(str16, str1.trim(), str13, str15, str14, null, paramString, bool2);
      ((DownloadInfo)localObject1).ekZ = i;
      if (bool2)
      {
        ((DownloadInfo)localObject1).isAutoInstall = bool4;
        ((DownloadInfo)localObject1).ddi = bool5;
        label449:
        ((DownloadInfo)localObject1).from = k;
        ((DownloadInfo)localObject1).iconUrl = str12;
        ((DownloadInfo)localObject1).ell = j;
        ((DownloadInfo)localObject1).extraData = str11;
        ((DownloadInfo)localObject1).isAutoInstallBySDK = bool6;
        ((DownloadInfo)localObject1).elk = 0;
      }
      try
      {
        ((DownloadInfo)localObject1).versionCode = paramBundle.getInt(aryv.PARAM_TASK_VERSION);
        ((DownloadInfo)localObject1).fileSize = paramBundle.getLong(aryv.PARAM_DOWNLOADSIZE);
        label514:
        ((DownloadInfo)localObject1).cCL = str2;
        ((DownloadInfo)localObject1).recommendId = str3;
        ((DownloadInfo)localObject1).cCM = str5;
        ((DownloadInfo)localObject1).channelId = str4;
        ((DownloadInfo)localObject1).pageId = str6;
        ((DownloadInfo)localObject1).kx = str7;
        ((DownloadInfo)localObject1).cDH = str8;
        ((DownloadInfo)localObject1).ddx = bool3;
        if (!TextUtils.isEmpty(str9)) {
          ((DownloadInfo)localObject1).sendTime = str9;
        }
        ((DownloadInfo)localObject1).ce("big_brother_ref_source_key", str10);
        ((DownloadInfo)localObject1).emb();
        arwt.i("DownloadResolver", "[doDownloadActionBySDK] action == Downloader.ACTION_DOWNLOAD");
        arvv.a().b((DownloadInfo)localObject1);
        continue;
        ((DownloadInfo)localObject1).isAutoInstall = false;
        ((DownloadInfo)localObject1).ddi = true;
        ((DownloadInfo)localObject1).updateType = 2;
        break label449;
        localObject1 = new DownloadInfo(str16, str1.trim(), str13, str15, str14, null, paramString, bool2);
        ((DownloadInfo)localObject1).ekZ = i;
        ((DownloadInfo)localObject1).isAutoInstall = bool4;
        ((DownloadInfo)localObject1).ddi = bool5;
        ((DownloadInfo)localObject1).elk = 0;
        ((DownloadInfo)localObject1).versionCode = paramBundle.getInt(aryv.PARAM_TASK_VERSION);
        ((DownloadInfo)localObject1).extraData = str11;
        if ((paramApkUpdateDetail != null) && (((DownloadInfo)localObject1).versionCode != paramApkUpdateDetail.versioncode) && (paramApkUpdateDetail.versioncode != 0)) {
          ((DownloadInfo)localObject1).versionCode = paramApkUpdateDetail.versioncode;
        }
        if (!TextUtils.isEmpty(str9)) {
          ((DownloadInfo)localObject1).sendTime = str9;
        }
        ((DownloadInfo)localObject1).cCL = str2;
        ((DownloadInfo)localObject1).recommendId = str3;
        ((DownloadInfo)localObject1).cCM = str5;
        ((DownloadInfo)localObject1).channelId = str4;
        ((DownloadInfo)localObject1).pageId = str6;
        ((DownloadInfo)localObject1).kx = str7;
        ((DownloadInfo)localObject1).cDH = str8;
        ((DownloadInfo)localObject1).ddx = bool3;
        ((DownloadInfo)localObject1).ce("big_brother_ref_source_key", str10);
        ((DownloadInfo)localObject1).emb();
        arvv.a().b((DownloadInfo)localObject1);
        arwt.d("DownloadResolver", "[doDownloadActionBySDK] action == Downloader.ACTION_UPDATE " + bool1);
        continue;
        return arvv.a().fx(str1);
        localObject1 = localObject2;
        if (!bool2) {
          continue;
        }
        arxt.X("305", str14, str16, str11);
        paramString = arvv.a().e(str1);
        localObject1 = paramString;
        if (paramString == null)
        {
          localObject1 = new DownloadInfo();
          ((DownloadInfo)localObject1).appId = str16;
          ((DownloadInfo)localObject1).urlStr = str1.trim();
          ((DownloadInfo)localObject1).packageName = str13;
          ((DownloadInfo)localObject1).pushTitle = str15;
          ((DownloadInfo)localObject1).via = str14;
          ((DownloadInfo)localObject1).cDG = paramBundle.getString(aryv.PARAM_TASK_APPID);
          ((DownloadInfo)localObject1).versionCode = paramBundle.getInt(aryv.PARAM_TASK_VERSION);
          ((DownloadInfo)localObject1).ddw = paramBundle.getBoolean(aryv.PARAM_IS_APK, true);
          ((DownloadInfo)localObject1).from = k;
          ((DownloadInfo)localObject1).iconUrl = str12;
          ((DownloadInfo)localObject1).elk = 0;
          ((DownloadInfo)localObject1).extraData = str11;
          if (!TextUtils.isEmpty(str9)) {
            ((DownloadInfo)localObject1).sendTime = str9;
          }
          ((DownloadInfo)localObject1).cCL = str2;
          ((DownloadInfo)localObject1).recommendId = str3;
          ((DownloadInfo)localObject1).cCM = str5;
          ((DownloadInfo)localObject1).channelId = str4;
          ((DownloadInfo)localObject1).pageId = str6;
          ((DownloadInfo)localObject1).kx = str7;
          ((DownloadInfo)localObject1).cDH = str8;
          ((DownloadInfo)localObject1).emb();
        }
        ((DownloadInfo)localObject1).ddx = bool3;
        ((DownloadInfo)localObject1).ce("big_brother_ref_source_key", str10);
        arvv.a().d((DownloadInfo)localObject1);
        continue;
        arvv.a().L(str1, true);
        localObject1 = localObject2;
      }
      catch (NumberFormatException paramBundle)
      {
        break label514;
      }
    }
  }
  
  public static void dJ(Bundle paramBundle)
  {
    aryr.dJ(paramBundle);
  }
  
  public static void dK(Bundle paramBundle)
  {
    aryr.dK(paramBundle);
  }
  
  private void e(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    arwt.i("DownloadResolver", "[doDownloadActionByMyApp] pParmas =" + paramBundle + " myAppConfig = " + paramInt);
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(paramActivity) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadActionByMyApp", System.currentTimeMillis());
    }
    if ("biz_src_jc_update".equals(paramString)) {
      arxt.X("300", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(aryv.PARAM_EXTRA_INFO));
    }
    Object localObject1;
    if (paramBundle.getInt(aryv.PARAM_TASK_VERSION, -10) < 0)
    {
      ??? = TMAssistantGetAppDetailTool.getInstance(this.b, aroi.a().getContext());
      localObject1 = paramBundle.getString(aryv.PARAM_TASK_PACKNAME);
      Object localObject3 = paramBundle.getString(aryv.cDC);
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
        ((TMAssistantGetAppDetailTool)???).exchangeUrlsFromPackageNames((ArrayList)localObject3);
      }
    }
    label295:
    do
    {
      synchronized (this.mLock)
      {
        try
        {
          this.mLock.wait(5000L);
          if (this.jm == null) {
            break label295;
          }
          localObject1 = (Integer)this.jm.remove(localObject1);
          if (localObject1 == null)
          {
            arvv.a().showToast(aroi.a().getContext().getString(2131696634));
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
      paramBundle.putInt(aryv.PARAM_TASK_VERSION, ((Integer)localObject1).intValue());
      if (paramApkUpdateDetail != null)
      {
        paramBundle.putInt(aryv.PARAM_PATCH_SIZE, paramApkUpdateDetail.patchsize);
        paramBundle.putInt(aryv.cDA, paramApkUpdateDetail.newapksize);
      }
      if (paramInt == 1)
      {
        paramBundle.putString("source", paramString);
        paramBundle.putInt("dialogType", 1);
        arzk.a().a(paramActivity, paramBundle, new arwb(this, paramBundle, paramString, paramApkUpdateDetail));
        return;
      }
    } while ((paramInt != 2) && (paramInt != 0));
    arzk.a().b(paramActivity, paramBundle, new arwc(this, paramBundle, paramString, paramApkUpdateDetail));
  }
  
  public static void t(Activity paramActivity, Bundle paramBundle)
  {
    aryr.t(paramActivity, paramBundle);
  }
  
  public void a(List<DownloadInfo> paramList, arzf paramarzf)
  {
    if (paramList == null)
    {
      arwt.i("DownloadResolver", "[queryByDownloadManagerV2] infos == null");
      return;
    }
    if (paramarzf == null) {
      arwt.i("DownloadResolver", "[queryByDownloadManagerV2] listener == null");
    }
    ThreadManager.getSubThreadHandler().post(new DownloadProxy.2(this, paramList, paramarzf));
  }
  
  public void d(Activity paramActivity, Bundle paramBundle, String paramString, ApkUpdateDetail paramApkUpdateDetail, int paramInt)
  {
    if (TMAssistantCallYYB_V1.getQQDownloadApiLevel(aroi.a().getContext()) >= 6) {
      paramBundle.putLong("OuterCall_DownloadApi_DoDownloadAction", System.currentTimeMillis());
    }
    if ("biz_src_jc_update".equals(paramString)) {
      arxt.X("100", "ANDROIDQQ.SELFUPDATE.FOLLOW.FOR.DEBUG", "100686848", paramBundle.getString(aryv.PARAM_EXTRA_INFO));
    }
    ThreadManager.getSubThreadHandler().post(new DownloadProxy.3(this, paramBundle, paramString, paramInt, paramActivity, paramApkUpdateDetail));
  }
  
  public void dy(String paramString, boolean paramBoolean)
  {
    ThreadManager.excute(new DownloadProxy.6(this, paramString, paramBoolean), 32, null, true);
  }
  
  public void dz(String paramString, boolean paramBoolean)
  {
    ThreadManager.excute(new DownloadProxy.7(this, paramString, paramBoolean), 32, null, true);
  }
  
  public List<DownloadInfo> gV()
  {
    long l1 = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = arvv.a().E();
    Object localObject3 = new StringBuilder().append("DownloadManagerV2 tasks:");
    if (localObject2 == null) {}
    for (Object localObject1 = "0";; localObject1 = Integer.valueOf(((Map)localObject2).size()))
    {
      arwt.i("DownloadResolver", localObject1);
      if ((localObject2 != null) && (((Map)localObject2).size() != 0)) {
        break;
      }
      arwt.e("DownloadResolver", "infos is null!!");
      return localArrayList;
    }
    localObject2 = new HashMap((Map)localObject2);
    localObject1 = new ArrayList();
    if (((Map)localObject2).size() > 0)
    {
      localObject2 = ((Map)localObject2).entrySet().iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        long l2 = System.currentTimeMillis();
        Object localObject4 = (String)((Map.Entry)localObject3).getKey();
        localObject3 = (DownloadInfo)((Map.Entry)localObject3).getValue();
        if ((((DownloadInfo)localObject3).downloadType == 0) && (!TextUtils.isEmpty(((DownloadInfo)localObject3).packageName)) && (((DownloadInfo)localObject3).ddw))
        {
          localArrayList.add(localObject3);
          localObject4 = arvv.a().b(((DownloadInfo)localObject3).urlStr);
          arwt.i("DownloadResolver", "\ninfo=" + ((DownloadInfo)localObject3).toString() + "\ntaskInfo:" + a((TMAssistantDownloadTaskInfo)localObject4));
        }
        for (;;)
        {
          ((List)localObject1).add(Long.valueOf(System.currentTimeMillis() - l2));
          break;
          arwt.e("DownloadResolver", "Info is not SDK && APK task!! \ninfo=" + ((DownloadInfo)localObject3).toString());
        }
      }
    }
    else
    {
      arwt.e("DownloadResolver", "infos is empty!!");
    }
    localObject2 = new Long[((List)localObject1).size()];
    ((List)localObject1).toArray((Object[])localObject2);
    arwt.e("DownloadResolver", "Total time Cost:" + (System.currentTimeMillis() - l1) + ";Every loop time cost:" + Arrays.toString((Object[])localObject2));
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arvz
 * JD-Core Version:    0.7.0.1
 */