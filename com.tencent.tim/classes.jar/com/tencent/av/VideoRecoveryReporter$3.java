package com.tencent.av;

import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public final class VideoRecoveryReporter$3
  implements Runnable
{
  public VideoRecoveryReporter$3(int paramInt, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("close_reason", String.valueOf(this.val$reason));
    anpc.a(BaseApplication.getContext()).collectPerformance("", "av_recovery_close2", true, this.val$duration, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.VideoRecoveryReporter.3
 * JD-Core Version:    0.7.0.1
 */