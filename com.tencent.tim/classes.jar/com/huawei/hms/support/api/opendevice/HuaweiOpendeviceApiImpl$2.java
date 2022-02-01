package com.huawei.hms.support.api.opendevice;

import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.entity.opendevice.OdidResp;
import com.huawei.hms.support.log.HMSLog;

class HuaweiOpendeviceApiImpl$2
  extends PendingResultImpl<OdidResult, OdidResp>
{
  HuaweiOpendeviceApiImpl$2(HuaweiOpendeviceApiImpl paramHuaweiOpendeviceApiImpl, ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
  {
    super(paramApiClient, paramString, paramIMessageEntity);
  }
  
  public OdidResult a(OdidResp paramOdidResp)
  {
    if (paramOdidResp == null)
    {
      HMSLog.e("OpenIdentifierApiImpl", "getOdid OaidResp is null");
      return null;
    }
    Status localStatus = paramOdidResp.getCommonStatus();
    if (localStatus == null)
    {
      HMSLog.e("OpenIdentifierApiImpl", "getOdid commonStatus is null");
      return null;
    }
    HMSLog.i("OpenIdentifierApiImpl", "getOdid onComplete:" + localStatus.getStatusCode());
    OdidResult localOdidResult = new OdidResult();
    localOdidResult.setStatus(localStatus);
    localOdidResult.setId(paramOdidResp.getId());
    return localOdidResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.opendevice.HuaweiOpendeviceApiImpl.2
 * JD-Core Version:    0.7.0.1
 */