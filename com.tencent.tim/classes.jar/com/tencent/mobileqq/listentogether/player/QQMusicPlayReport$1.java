package com.tencent.mobileqq.listentogether.player;

import anpc;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public final class QQMusicPlayReport$1
  implements Runnable
{
  public QQMusicPlayReport$1(boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    if (this.cln) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("qqmusicplay_report_key_play_cache", str);
      localHashMap.put("qqmusicplay_report_key_net_type", String.valueOf(this.val$netType));
      anpc.a(BaseApplication.getContext()).collectPerformance("", "qqmusicplay_report_tag_play_cache", true, 0L, 0L, localHashMap, "");
      if (QLog.isColorLevel()) {}
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.player.QQMusicPlayReport.1
 * JD-Core Version:    0.7.0.1
 */