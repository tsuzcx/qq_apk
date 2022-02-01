package com.tencent.android.tpush;

import android.content.Context;
import android.content.Intent;
import com.jg.JgMethodChecked;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.logging.TLogger;

final class XGPushConfig$2
  implements Runnable
{
  XGPushConfig$2(Context paramContext, int paramInt) {}
  
  @JgMethodChecked(author=1, fComment="确认已进行安全校验", lastDate="20150316", reviewer=3, vComment={com.jg.EType.RECEIVERCHECK, com.jg.EType.INTENTCHECK})
  public void run()
  {
    try
    {
      Intent localIntent = new Intent(this.a.getPackageName() + "com.tencent.android.xg.vip.action.SET_HTINTERVALMS.V4");
      localIntent.putExtra("interval", this.b);
      BroadcastAgent.sendBroadcast(this.a, localIntent);
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.e("XGPushConfig", "setHeartbeatInterval ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPushConfig.2
 * JD-Core Version:    0.7.0.1
 */