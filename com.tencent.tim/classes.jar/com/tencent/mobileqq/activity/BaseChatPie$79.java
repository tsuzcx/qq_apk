package com.tencent.mobileqq.activity;

import acff;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import mqq.os.MqqHandler;

class BaseChatPie$79
  implements Runnable
{
  BaseChatPie$79(BaseChatPie paramBaseChatPie, acff paramacff) {}
  
  public void run()
  {
    NoC2CExtensionInfo localNoC2CExtensionInfo = this.d.a(this.this$0.sessionInfo.aTl, this.this$0.sessionInfo.cZ, true);
    if ((localNoC2CExtensionInfo != null) && (localNoC2CExtensionInfo.audioPanelType != -1) && (this.this$0.a != null)) {
      this.this$0.uiHandler.obtainMessage(40, localNoC2CExtensionInfo.audioPanelType, this.this$0.sessionInfo.cZ).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.79
 * JD-Core Version:    0.7.0.1
 */