package com.tencent.qqmail.protocol;

import android.os.Build;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.deviceid.DeviceInfo;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;

public class CloudProtocolHelper
{
  private static final String TAG = "CloudProtocolHelper";
  private static String deviceId = "";
  
  public static CloudProtocolInfo getCommonInfo()
  {
    Object localObject = QMApplicationContext.sharedInstance();
    long l = ((QMApplicationContext)localObject).getVid();
    localObject = ((QMApplicationContext)localObject).getVidPwd();
    if ((l == 0L) || (((String)localObject).equals(""))) {
      return null;
    }
    return new CloudProtocolInfo(l, (String)localObject, getDeviceId(), DeviceUtil.getDeviceInfos().BRAND);
  }
  
  public static String getDeviceId()
  {
    if ((deviceId == null) || (deviceId.equals(""))) {
      deviceId = Aes.getPureDeviceToken();
    }
    return deviceId;
  }
  
  public static String getDeviceInfo()
  {
    return Build.MANUFACTURER + ":" + Build.DEVICE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.CloudProtocolHelper
 * JD-Core Version:    0.7.0.1
 */