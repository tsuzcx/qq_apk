package com.huawei.hms.support.api.opendevice;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.opendevice.OaidResp;
import com.huawei.hms.support.log.HMSLog;

class HuaweiOpendeviceApiImpl$1
  extends PendingResultImpl<OaidResult, OaidResp>
{
  HuaweiOpendeviceApiImpl$1(HuaweiOpendeviceApiImpl paramHuaweiOpendeviceApiImpl, ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
  {
    super(paramApiClient, paramString, paramIMessageEntity);
  }
  
  public OaidResult a(OaidResp paramOaidResp)
  {
    if (paramOaidResp == null)
    {
      HMSLog.e("OpenIdentifierApiImpl", "getOaid OaidResp is null");
      return null;
    }
    Status localStatus = paramOaidResp.getCommonStatus();
    if (localStatus == null)
    {
      HMSLog.e("OpenIdentifierApiImpl", "getOaid commonStatus is null");
      return null;
    }
    HMSLog.i("OpenIdentifierApiImpl", "getOaid onComplete:" + localStatus.getStatusCode());
    OaidResult localOaidResult = new OaidResult();
    localOaidResult.setStatus(localStatus);
    localOaidResult.setId(paramOaidResp.getId());
    localOaidResult.setTrackLimited(paramOaidResp.isTrackLimited());
    localOaidResult.setSettingIntent(paramOaidResp.getSettingIntent());
    return localOaidResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.opendevice.HuaweiOpendeviceApiImpl.1
 * JD-Core Version:    0.7.0.1
 */