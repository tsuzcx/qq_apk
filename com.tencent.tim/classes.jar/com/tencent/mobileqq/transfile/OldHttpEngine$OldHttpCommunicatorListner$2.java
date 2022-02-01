package com.tencent.mobileqq.transfile;

import aoll;
import aomj.a;
import aonc;
import aqog;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class OldHttpEngine$OldHttpCommunicatorListner$2
  extends TimerTask
{
  public OldHttpEngine$OldHttpCommunicatorListner$2(aomj.a parama, aoll paramaoll) {}
  
  public void run()
  {
    boolean bool = true;
    int i;
    if ((QLog.isColorLevel()) && (this.g != null))
    {
      i = this.g.dPG;
      if (this.g.mHttpMethod != 1) {
        break label94;
      }
    }
    for (;;)
    {
      aonc.a(i, bool, this.g.mFileType, this.g.mMsgId, "scheduleRetry", "mIsCancelled:" + this.a.cQ);
      if (!this.a.cQ.get()) {
        break;
      }
      return;
      label94:
      bool = false;
    }
    this.a.f.P(9004, -1, "nonetwork");
    this.a.b(this.a.f, this.a.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner.2
 * JD-Core Version:    0.7.0.1
 */