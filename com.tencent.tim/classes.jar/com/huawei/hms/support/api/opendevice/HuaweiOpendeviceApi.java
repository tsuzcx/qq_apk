package com.huawei.hms.support.api.opendevice;

import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.support.api.client.PendingResult;

public abstract interface HuaweiOpendeviceApi
{
  public abstract PendingResult<OaidResult> getOaid(HuaweiApiClient paramHuaweiApiClient);
  
  public abstract PendingResult<OdidResult> getOdid(HuaweiApiClient paramHuaweiApiClient);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.opendevice.HuaweiOpendeviceApi
 * JD-Core Version:    0.7.0.1
 */