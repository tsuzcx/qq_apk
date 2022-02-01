package com.tencent.av.gaudio;

import android.graphics.Bitmap;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import jjc;
import mqq.os.MqqHandler;

class GaInviteLockActivity$11
  implements Runnable
{
  GaInviteLockActivity$11(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  public void run()
  {
    int i = this.this$0.mUinType;
    long l = this.this$0.mGroupId;
    int j = jjc.cJ(this.this$0.aqx);
    String str1 = this.this$0.mApp.getDisplayName(i, String.valueOf(l), null);
    String str2 = this.this$0.mApp.getDisplayName(j, String.valueOf(this.this$0.mf), String.valueOf(this.this$0.mGroupId));
    Bitmap localBitmap = this.this$0.mApp.a(j, String.valueOf(this.this$0.mf), null, true, true);
    QLog.w(this.this$0.TAG, 1, "mAsyncSubThreadRunnable[groupName," + str1 + "],[peerName," + str2 + "]");
    if ((!this.this$0.isFinishing()) && (GaInviteLockActivity.a(this.this$0) != null))
    {
      GaInviteLockActivity.a(this.this$0).removeCallbacks(GaInviteLockActivity.a(this.this$0));
      GaInviteLockActivity.a(this.this$0).a(str1, str2, localBitmap);
      GaInviteLockActivity.a(this.this$0).post(GaInviteLockActivity.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.11
 * JD-Core Version:    0.7.0.1
 */