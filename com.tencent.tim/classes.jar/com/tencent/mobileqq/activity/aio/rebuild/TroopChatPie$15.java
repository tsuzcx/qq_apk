package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Handler;
import android.os.Message;
import apsw;
import apsw.e;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;

class TroopChatPie$15
  implements Runnable
{
  TroopChatPie$15(TroopChatPie paramTroopChatPie, boolean paramBoolean) {}
  
  public void run()
  {
    apsw.e locale = ((apsw)this.this$0.app.getManager(48)).a(this.this$0.sessionInfo.aTl, this.uk);
    Message localMessage = this.this$0.bX.obtainMessage(2);
    localMessage.obj = locale;
    this.this$0.bX.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.15
 * JD-Core Version:    0.7.0.1
 */