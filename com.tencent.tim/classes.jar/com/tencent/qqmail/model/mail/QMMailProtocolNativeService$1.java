package com.tencent.qqmail.model.mail;

import android.os.Build.VERSION;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.protocol.Exchange.ActiveSyncMobileInfo;
import com.tencent.qqmail.protocol.SimpleOnProtocolListener;
import com.tencent.qqmail.utilities.deviceid.DeviceInfo;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import java.util.Locale;

class QMMailProtocolNativeService$1
  extends SimpleOnProtocolListener
{
  QMMailProtocolNativeService$1(QMMailProtocolNativeService paramQMMailProtocolNativeService) {}
  
  public Exchange.ActiveSyncMobileInfo onGetMobileInfo()
  {
    Object localObject = DeviceUtil.getDeviceInfos();
    Exchange.ActiveSyncMobileInfo localActiveSyncMobileInfo = new Exchange.ActiveSyncMobileInfo();
    localActiveSyncMobileInfo.model_ = ((DeviceInfo)localObject).MODEL;
    localActiveSyncMobileInfo.name_ = ((DeviceInfo)localObject).BRAND;
    localActiveSyncMobileInfo.os_ = ("Android " + ((DeviceInfo)localObject).releaseVersion);
    localActiveSyncMobileInfo.os_lang_ = Locale.getDefault().getLanguage();
    localActiveSyncMobileInfo.phone_number_ = ((DeviceInfo)localObject).PHONE_NUMBER;
    localActiveSyncMobileInfo.mobile_operator_ = ((DeviceInfo)localObject).MANUFACTURER;
    localActiveSyncMobileInfo.imei_ = ((DeviceInfo)localObject).IMEI;
    StringBuilder localStringBuilder = new StringBuilder().append("QQMail/Android/").append(AppConfig.getCodeVersion()).append("/");
    if (Build.VERSION.RELEASE == null) {}
    for (localObject = "";; localObject = Build.VERSION.RELEASE)
    {
      localActiveSyncMobileInfo.user_agent_ = ((String)localObject);
      return localActiveSyncMobileInfo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.QMMailProtocolNativeService.1
 * JD-Core Version:    0.7.0.1
 */