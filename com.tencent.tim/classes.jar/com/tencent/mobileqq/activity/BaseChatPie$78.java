package com.tencent.mobileqq.activity;

import acff;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import mqq.os.MqqHandler;

class BaseChatPie$78
  implements Runnable
{
  BaseChatPie$78(BaseChatPie paramBaseChatPie, acff paramacff) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = this.d.a(this.this$0.sessionInfo.aTl, true);
    if ((localExtensionInfo != null) && (localExtensionInfo.audioPanelType != -1) && (this.this$0.a != null)) {
      this.this$0.uiHandler.obtainMessage(40, localExtensionInfo.audioPanelType, this.this$0.sessionInfo.cZ).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.78
 * JD-Core Version:    0.7.0.1
 */