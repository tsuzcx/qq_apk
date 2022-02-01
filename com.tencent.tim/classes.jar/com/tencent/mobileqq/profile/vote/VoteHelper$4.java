package com.tencent.mobileqq.profile.vote;

import alhr;
import android.os.Handler;
import android.os.Message;
import aqfu;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.qphone.base.util.QLog;

public class VoteHelper$4
  implements Runnable
{
  public VoteHelper$4(alhr paramalhr, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity.VoteHelper", 2, "updateCardProfileFromDb uin:" + this.val$uin);
    }
    CardProfile localCardProfile2 = aqfu.a(this.this$0.app, this.val$uin, 2);
    CardProfile localCardProfile1 = localCardProfile2;
    if (localCardProfile2 == null) {
      localCardProfile1 = aqfu.a(this.this$0.app, this.val$uin, 3);
    }
    if (localCardProfile1 != null)
    {
      localCardProfile1.updateTime(System.currentTimeMillis() / 1000L);
      this.this$0.mHandler.obtainMessage(9, localCardProfile1).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.vote.VoteHelper.4
 * JD-Core Version:    0.7.0.1
 */