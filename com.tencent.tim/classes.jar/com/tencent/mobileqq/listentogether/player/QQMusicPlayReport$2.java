package com.tencent.mobileqq.listentogether.player;

import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class QQMusicPlayReport$2
  implements Runnable
{
  public QQMusicPlayReport$2(int paramInt1, int paramInt2) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("qqmusicplay_report_key_seek_delay", String.valueOf(this.val$delay));
    localHashMap.put("qqmusicplay_report_key_net_type", String.valueOf(this.val$netType));
    anpc.a(BaseApplication.getContext()).collectPerformance("", "qqmusicplay_report_tag_seek_delay", true, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel()) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.player.QQMusicPlayReport.2
 * JD-Core Version:    0.7.0.1
 */