package com.tencent.biz.subscribe.utils;

import com.tencent.qphone.base.util.BaseApplication;
import she;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tlm;
import tlm.a;
import tlm.b;

public class SubscribeAdDeviceInfoHelper$1
  implements Runnable
{
  public SubscribeAdDeviceInfoHelper$1(she paramshe) {}
  
  public void run()
  {
    Object localObject = new tlm.a();
    ((tlm.a)localObject).aJy = "1b0ad2";
    localObject = tlm.a(BaseApplication.getContext(), (tlm.a)localObject);
    she localshe = this.this$0;
    if (localObject != null) {}
    for (localObject = ((tlm.b)localObject).b;; localObject = null)
    {
      she.a(localshe, (qq_ad_get.QQAdGet.DeviceInfo)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeAdDeviceInfoHelper.1
 * JD-Core Version:    0.7.0.1
 */