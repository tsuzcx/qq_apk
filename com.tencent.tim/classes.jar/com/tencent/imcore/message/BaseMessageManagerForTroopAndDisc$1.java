package com.tencent.imcore.message;

import android.os.Bundle;
import apdd;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import tnu;

public class BaseMessageManagerForTroopAndDisc$1
  implements Runnable
{
  public BaseMessageManagerForTroopAndDisc$1(tnu paramtnu, long paramLong1, long paramLong2, int paramInt, long paramLong3, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    long l = Math.min(this.EC, this.ED);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager.trooptroop_pull_msg.troop_parallel_pull_msg.trooptroop_pull_msg", 2, "--->>pkgIndex : " + this.bCB + " beginSeq:" + this.EE + " fixEndSeq:" + l);
    }
    this.this$0.b.a().u(this.val$uin, this.EE, l);
    this.this$0.app.a().a(this.val$uin, this.EE, l, true, this.T, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.1
 * JD-Core Version:    0.7.0.1
 */