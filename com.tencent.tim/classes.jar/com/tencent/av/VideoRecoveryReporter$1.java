package com.tencent.av;

import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public final class VideoRecoveryReporter$1
  implements Runnable
{
  public VideoRecoveryReporter$1(int paramInt, boolean paramBoolean, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("source", String.valueOf(this.val$source));
    anpc.a(BaseApplication.getContext()).collectPerformance("", "av_recovery_request2", this.vf, this.le, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.VideoRecoveryReporter.1
 * JD-Core Version:    0.7.0.1
 */