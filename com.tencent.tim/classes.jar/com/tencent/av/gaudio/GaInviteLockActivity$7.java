package com.tencent.av.gaudio;

import com.tencent.av.VideoController;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class GaInviteLockActivity$7
  implements Runnable
{
  GaInviteLockActivity$7(GaInviteLockActivity paramGaInviteLockActivity, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    ArrayList localArrayList = this.this$0.a.a(this.aqK, this.iv);
    ThreadManager.getUIHandler().post(new GaInviteLockActivity.7.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.7
 * JD-Core Version:    0.7.0.1
 */