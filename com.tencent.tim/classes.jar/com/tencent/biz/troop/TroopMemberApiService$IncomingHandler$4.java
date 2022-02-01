package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageRecord;

class TroopMemberApiService$IncomingHandler$4
  implements Runnable
{
  TroopMemberApiService$IncomingHandler$4(TroopMemberApiService.a parama, TroopManager paramTroopManager, String paramString1, String paramString2, Bundle paramBundle, int paramInt) {}
  
  public void run()
  {
    MessageRecord localMessageRecord = this.c.a(this.aEy, this.aEz);
    if (localMessageRecord != null)
    {
      this.val$data.putLong("lastMsgTime", localMessageRecord.time);
      this.val$data.putString("lastMsgContent", localMessageRecord.msg);
      this.val$data.putInt("seq", this.val$seq);
    }
    for (;;)
    {
      this.a.d.j(72, this.val$data);
      return;
      this.val$data.putLong("lastMsgTime", 0L);
      this.val$data.putString("lastMsgContent", "");
      this.val$data.putInt("seq", this.val$seq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.4
 * JD-Core Version:    0.7.0.1
 */