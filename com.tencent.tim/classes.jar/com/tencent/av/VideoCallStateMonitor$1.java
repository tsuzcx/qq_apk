package com.tencent.av;

import anpc;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import igx;
import java.util.HashMap;

public class VideoCallStateMonitor$1
  implements Runnable
{
  public VideoCallStateMonitor$1(igx paramigx, HashMap paramHashMap) {}
  
  public void run()
  {
    anpc.a(BaseApplication.getContext()).collectPerformance(igx.a(this.this$0).getCurrentAccountUin(), "av_memory_details", true, 0L, 0L, this.aK, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.VideoCallStateMonitor.1
 * JD-Core Version:    0.7.0.1
 */