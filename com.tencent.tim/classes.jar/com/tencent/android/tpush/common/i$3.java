package com.tencent.android.tpush.common;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.ChannelUtils;
import com.tencent.tpns.baseapi.base.util.CommonHelper;

final class i$3
  implements Runnable
{
  i$3(Context paramContext) {}
  
  public void run()
  {
    try
    {
      PackageManager localPackageManager = this.a.getPackageManager();
      if (localPackageManager == null) {
        return;
      }
      String str = i.b();
      TLogger.i("filter components", "deviceType: " + str);
      if ((!ChannelUtils.isBrandXiaoMi()) && (!ChannelUtils.isBrandBlackShark()) && (((Boolean)CommonHelper.getMetaData(this.a, "tpns-disable-component-xiaomi", Boolean.valueOf(true))).booleanValue()))
      {
        i.a(localPackageManager, this.a, "com.xiaomi.push.service.XMPushService");
        i.a(localPackageManager, this.a, "com.xiaomi.push.service.XMJobService");
        i.a(localPackageManager, this.a, "com.xiaomi.mipush.sdk.PushMessageHandler");
        i.a(localPackageManager, this.a, "com.xiaomi.mipush.sdk.MessageHandleService");
        i.a(localPackageManager, this.a, "com.xiaomi.push.service.receivers.NetworkStatusReceiver");
        i.a(localPackageManager, this.a, "com.xiaomi.push.service.receivers.PingReceiver");
        i.a(localPackageManager, this.a, "com.tencent.android.mipush.XMPushMessageReceiver");
      }
      if ((!ChannelUtils.isBrandHuaWei()) && (!ChannelUtils.isBrandHonor()))
      {
        TLogger.i("filter components", "disable device huawei");
        if (((Boolean)CommonHelper.getMetaData(this.a, "tpns-disable-component-huawei-v4", Boolean.valueOf(true))).booleanValue())
        {
          i.a(localPackageManager, this.a, "com.huawei.agconnect.core.provider.AGConnectInitializeProvider");
          i.a(localPackageManager, this.a, "com.huawei.agconnect.core.ServiceDiscovery");
          i.a(localPackageManager, this.a, "com.tencent.android.hwpushv3.HWHmsMessageService");
          i.a(localPackageManager, this.a, "com.huawei.hms.support.api.push.PushMsgReceiver");
          i.a(localPackageManager, this.a, "com.huawei.hms.support.api.push.PushReceiver");
          i.a(localPackageManager, this.a, "com.huawei.hms.support.api.push.PushProvider");
        }
      }
      if ((!ChannelUtils.isBrandMeiZu()) && (((Boolean)CommonHelper.getMetaData(this.a, "tpns-disable-component-meizu", Boolean.valueOf(true))).booleanValue()))
      {
        i.a(localPackageManager, this.a, "com.tencent.android.mzpush.MZPushMessageReceiver");
        i.a(localPackageManager, this.a, "com.meizu.cloud.pushsdk.SystemReceiver");
        i.a(localPackageManager, this.a, "com.meizu.cloud.pushsdk.NotificationService");
      }
      if ((!"oppo".equals(str)) && (!"oneplus".equals(str)) && (!"realme".equals(str)) && (((Boolean)CommonHelper.getMetaData(this.a, "tpns-disable-component-oppo", Boolean.valueOf(true))).booleanValue()))
      {
        i.a(localPackageManager, this.a, "com.heytap.msp.push.service.CompatibleDataMessageCallbackService");
        i.a(localPackageManager, this.a, "com.heytap.msp.push.service.DataMessageCallbackService");
      }
      if ((!"vivo".equals(str)) && (((Boolean)CommonHelper.getMetaData(this.a, "tpns-disable-component-vivo", Boolean.valueOf(true))).booleanValue()))
      {
        i.a(localPackageManager, this.a, "com.vivo.push.sdk.service.CommandClientService");
        i.a(localPackageManager, this.a, "com.vivo.push.sdk.LinkProxyClientActivity");
        i.a(localPackageManager, this.a, "com.tencent.android.vivopush.VivoPushMessageReceiver");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      TLogger.w("Util", "unexpected for disableComponents", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.common.i.3
 * JD-Core Version:    0.7.0.1
 */