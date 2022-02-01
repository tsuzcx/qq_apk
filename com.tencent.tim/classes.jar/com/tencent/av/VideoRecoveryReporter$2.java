package com.tencent.av;

import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public final class VideoRecoveryReporter$2
  implements Runnable
{
  public VideoRecoveryReporter$2(boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    anpc.a(BaseApplication.getContext()).collectPerformance("", "av_recovery_result2", this.vf, this.val$timeCost, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.VideoRecoveryReporter.2
 * JD-Core Version:    0.7.0.1
 */