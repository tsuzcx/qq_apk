package com.tencent.av;

import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public final class VideoSocketReconnectReporter$1
  implements Runnable
{
  public VideoSocketReconnectReporter$1(int paramInt1, int paramInt2) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("policy_type", String.valueOf(this.ame));
    localHashMap.put("net_type", String.valueOf(this.val$netType));
    anpc.a(BaseApplication.getContext()).collectPerformance("", "av_socket_recon_request2", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.VideoSocketReconnectReporter.1
 * JD-Core Version:    0.7.0.1
 */