package com.tencent.android.tpush;

import android.content.Context;
import android.content.Intent;
import com.jg.JgMethodChecked;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.PushPreferences;

final class XGPushConfig$1
  implements Runnable
{
  XGPushConfig$1(Context paramContext, boolean paramBoolean) {}
  
  @JgMethodChecked(author=1, fComment="确认已进行安全校验", lastDate="20150316", reviewer=3, vComment={com.jg.EType.RECEIVERCHECK, com.jg.EType.INTENTCHECK})
  public void run()
  {
    try
    {
      TLogger.enableDebug(this.a, this.b);
      Object localObject = this.a;
      String str = "com.tencent.android.tpush.debug," + this.a.getPackageName();
      if (this.b) {}
      for (int i = 1;; i = 0)
      {
        PushPreferences.putInt((Context)localObject, str, i);
        localObject = new Intent(this.a.getPackageName() + "com.tencent.android.xg.vip.action.ENABLE_DEBUG.V4");
        ((Intent)localObject).putExtra("debugMode", this.b);
        BroadcastAgent.sendBroadcast(this.a, (Intent)localObject);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("XGPushConfig", "enableDebug ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushConfig.1
 * JD-Core Version:    0.7.0.1
 */