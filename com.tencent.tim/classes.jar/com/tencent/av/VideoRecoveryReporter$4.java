package com.tencent.av;

import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public final class VideoRecoveryReporter$4
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    anpc.a(BaseApplication.getContext()).collectPerformance("", "av_fullscreen_notification_request", true, 0L, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.VideoRecoveryReporter.4
 * JD-Core Version:    0.7.0.1
 */