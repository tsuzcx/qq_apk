package com.tencent.android.tpush;

import android.content.Context;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.PushPreferences;

class XGPushConfig$Build$1
  implements Runnable
{
  XGPushConfig$Build$1(XGPushConfig.Build paramBuild, int paramInt) {}
  
  public void run()
  {
    try
    {
      PushPreferences.putInt(XGPushConfig.Build.access$000(this.b), "com.tencent.android.tpush.log_level," + XGPushConfig.Build.access$000(this.b).getPackageName(), this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.w("XGPushConfig", "XGPushConfig.Build.setLogLevel sharedPf put error " + localThrowable.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushConfig.Build.1
 * JD-Core Version:    0.7.0.1
 */