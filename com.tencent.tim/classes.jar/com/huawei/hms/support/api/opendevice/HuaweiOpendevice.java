package com.huawei.hms.support.api.opendevice;

import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions.NoOptions;

public class HuaweiOpendevice
{
  public static final HuaweiOpendeviceApi HuaweiOpendeviceApi = new HuaweiOpendeviceApiImpl();
  public static final Api<Api.ApiOptions.NoOptions> OPEN_DEVICE_API = new Api("HuaweiOpenDevice.API");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.support.api.opendevice.HuaweiOpendevice
 * JD-Core Version:    0.7.0.1
 */