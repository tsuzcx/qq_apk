package com.tencent.av.gaudio;

import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import inx;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

class GaInviteLockActivity$2
  implements Runnable
{
  GaInviteLockActivity$2(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  public void run()
  {
    if (GaInviteLockActivity.a(this.this$0) == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.TAG, 2, "mTaskCheckRunnable before" + GaInviteLockActivity.a(this.this$0) + ";currentMemberSize=" + GaInviteLockActivity.a(this.this$0).size());
      }
      if (GaInviteLockActivity.a(this.this$0))
      {
        long l = AudioHelper.hF() / 1000L;
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = GaInviteLockActivity.a(this.this$0).iterator();
        while (localIterator.hasNext())
        {
          inx localinx = (inx)localIterator.next();
          if (localinx.mg + 60L > l) {
            localArrayList.add(localinx);
          } else if (QLog.isColorLevel()) {
            QLog.d(this.this$0.TAG, 2, "mTaskCheckRunnable " + localinx.mg + ";otherTimestamp=" + l);
          }
        }
        GaInviteLockActivity.a(this.this$0, localArrayList);
      }
      GaInviteLockActivity.a(this.this$0).postDelayed(GaInviteLockActivity.a(this.this$0), 10000L);
    } while (!QLog.isColorLevel());
    QLog.d(this.this$0.TAG, 2, "mTaskCheckRunnable after" + GaInviteLockActivity.a(this.this$0) + ";currentMemberSize=" + GaInviteLockActivity.a(this.this$0).size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.2
 * JD-Core Version:    0.7.0.1
 */