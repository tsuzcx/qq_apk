package com.tencent.av;

import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public final class VideoSocketReconnectReporter$2
  implements Runnable
{
  public VideoSocketReconnectReporter$2(int paramInt1, int paramInt2, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("policy_type", String.valueOf(this.ame));
    localHashMap.put("net_type", String.valueOf(this.val$netType));
    localHashMap.put("time_cost", String.valueOf(this.val$timeCost));
    anpc.a(BaseApplication.getContext()).collectPerformance("", "av_socket_recon_result2", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.VideoSocketReconnectReporter.2
 * JD-Core Version:    0.7.0.1
 */