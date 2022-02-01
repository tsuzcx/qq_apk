package com.huawei.hms.utils;

import android.text.TextUtils;
import com.huawei.hianalytics.hms.HiAnalyticsConf.Builder;
import com.huawei.hms.framework.network.grs.IQueryUrlCallBack;
import com.huawei.hms.support.log.HMSLog;

class HMSBIInitializer$1
  implements IQueryUrlCallBack
{
  HMSBIInitializer$1(HMSBIInitializer paramHMSBIInitializer) {}
  
  public void onCallBackFail(int paramInt)
  {
    HMSLog.e("HMSBIInitializer", "get grs failed, the errorcode is " + paramInt);
  }
  
  public void onCallBackSuccess(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      HMSBIInitializer.a(this.a).setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(0, paramString).setCollectURL(1, paramString).setAppID("com.huawei.hwid").create();
      HMSLog.i("HMSBIInitializer", "BI URL acquired successfully");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.utils.HMSBIInitializer.1
 * JD-Core Version:    0.7.0.1
 */