package com.tencent.mobileqq.microapp.apkg;

import Wallet.ApkgConfig;
import Wallet.GetMiniAppReq;
import aaai;
import aagd;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.microapp.ext.ManagerProxy;
import com.tencent.mobileqq.microapp.sdk.BaseLibInfo;
import com.tencent.mobileqq.microapp.sdk.LaunchParam;
import com.tencent.mobileqq.microapp.sdk.OnUpdateListener;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;
import zyb;

public class ApkgConfigManager
  implements Manager
{
  private static final String BASE_LIB_KEY_DEFAULT = "6VVmps6FEskvzUw+4t4BXEDUccolfE5bYliLLouIQUNUnYhBn/oSsktnohg3uFs0PDC+VDjsB2x7hkQ/G2m8OeCrSAYDQZwwmf1JZ+HYizxIj/i8SMs3ySNoCxiZc8s70BWR6wbjgRPt6p8+k3E5cS0Arcd+RwprVYpyDPuBiZg=";
  private static final String BASE_LIB_URL_DEFAULT = "https://i.gtimg.cn/channel/imglib/201811/upload_a84c998c33a7341a621a217cb90b7612.zip";
  private static final String BASE_LIB_VERSION_DEFAULT = "2.3.1";
  private static final String TAG = "ApkgConfigManager";
  private BaseLibInfo baseLibInfo;
  private QQAppInterface mApp;
  private a mConfig;
  
  public ApkgConfigManager(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApkgConfigManager", 2, "ApkgConfigManager init");
    }
    this.mApp = paramQQAppInterface;
    this.mConfig = a.a(paramQQAppInterface);
  }
  
  public static boolean isCanNavigate(MiniAppConfig paramMiniAppConfig1, MiniAppConfig paramMiniAppConfig2)
  {
    if ((paramMiniAppConfig1 == null) || (paramMiniAppConfig1.config == null) || (paramMiniAppConfig2 == null) || (paramMiniAppConfig2.config == null)) {
      return false;
    }
    if (LaunchParam.isCollectionPage(paramMiniAppConfig2.config.mini_appid)) {
      return true;
    }
    return aagd.j(paramMiniAppConfig1.config.union_id, paramMiniAppConfig2.config.union_id);
  }
  
  public BaseLibInfo getBaseLibInfo()
  {
    String str3;
    String str2;
    String str1;
    if (this.baseLibInfo == null)
    {
      aaai localaaai = ManagerProxy.getQWalletConfigManager(this.mApp);
      str3 = "";
      str2 = "";
      str1 = "";
      if (localaaai != null)
      {
        str3 = localaaai.a("miniapp", "", new String[] { "base_lib_url" });
        str2 = localaaai.a("miniapp", "", new String[] { "base_lib_key" });
        str1 = localaaai.a("miniapp", "", new String[] { "base_lib_version" });
      }
      if ((!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1))) {
        break label130;
      }
    }
    label130:
    for (this.baseLibInfo = new BaseLibInfo("https://i.gtimg.cn/channel/imglib/201811/upload_a84c998c33a7341a621a217cb90b7612.zip", "6VVmps6FEskvzUw+4t4BXEDUccolfE5bYliLLouIQUNUnYhBn/oSsktnohg3uFs0PDC+VDjsB2x7hkQ/G2m8OeCrSAYDQZwwmf1JZ+HYizxIj/i8SMs3ySNoCxiZc8s70BWR6wbjgRPt6p8+k3E5cS0Arcd+RwprVYpyDPuBiZg=", "2.3.1");; this.baseLibInfo = new BaseLibInfo(str3, str2, str1)) {
      return this.baseLibInfo;
    }
  }
  
  public MiniAppConfig getConfig(LaunchParam paramLaunchParam)
  {
    Object localObject = null;
    ApkgConfig localApkgConfig = this.mConfig.b(paramLaunchParam);
    paramLaunchParam = localObject;
    if (localApkgConfig != null) {
      paramLaunchParam = new MiniAppConfig(localApkgConfig, getBaseLibInfo());
    }
    return paramLaunchParam;
  }
  
  public MiniAppConfig getConfig(String paramString)
  {
    LaunchParam localLaunchParam = new LaunchParam();
    localLaunchParam.miniAppId = paramString;
    return getConfig(localLaunchParam);
  }
  
  public void getNewestConfig(LaunchParam paramLaunchParam, int paramInt, a parama)
  {
    GetMiniAppReq localGetMiniAppReq = new GetMiniAppReq(paramLaunchParam.miniAppId, paramInt, paramLaunchParam.getReqAction(), paramLaunchParam.extraKey);
    if (QLog.isColorLevel()) {
      QLog.d("ApkgConfigManager", 2, "getNewestConfig GetMiniAppReq|" + localGetMiniAppReq);
    }
    zyb.a(localGetMiniAppReq, new c(this, parama, paramLaunchParam));
  }
  
  public void onDestroy() {}
  
  public void tryUpdate(LaunchParam paramLaunchParam, int paramInt, OnUpdateListener paramOnUpdateListener)
  {
    if (paramInt == -1) {
      return;
    }
    getNewestConfig(paramLaunchParam, paramInt, new d(this, paramInt, paramOnUpdateListener));
  }
  
  public static abstract interface a
  {
    public abstract void onResult(int paramInt, MiniAppConfig paramMiniAppConfig, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.ApkgConfigManager
 * JD-Core Version:    0.7.0.1
 */