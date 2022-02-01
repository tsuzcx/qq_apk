package com.tencent.tim.vendorpush;

import auqf;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.qphone.base.util.BaseApplication;

public final class VendorPushHelper$1
  implements Runnable
{
  public void run()
  {
    XGPushConfig.enablePullUpOtherApp(BaseApplication.getContext(), false);
    XGPushConfig.enableOtherPush(BaseApplication.getContext(), true);
    long l = System.currentTimeMillis();
    XGPushManager.registerPush(BaseApplication.getContext(), new auqf(this, l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.vendorpush.VendorPushHelper.1
 * JD-Core Version:    0.7.0.1
 */