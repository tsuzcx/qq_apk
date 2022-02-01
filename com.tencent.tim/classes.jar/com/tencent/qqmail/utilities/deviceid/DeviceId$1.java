package com.tencent.qqmail.utilities.deviceid;

import android.content.Context;

final class DeviceId$1
  implements Runnable
{
  DeviceId$1(Context paramContext) {}
  
  public void run()
  {
    DeviceId.initDeviceId(this.val$context);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.deviceid.DeviceId.1
 * JD-Core Version:    0.7.0.1
 */