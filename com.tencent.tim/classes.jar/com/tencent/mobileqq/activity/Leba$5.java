package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import avco;
import avcq;
import avmd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webprocess.WebProcessManager;

public class Leba$5
  implements Runnable
{
  Leba$5(Leba paramLeba) {}
  
  public void run()
  {
    Object localObject = this.this$0.app.getCurrentAccountUin();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      long l = WebProcessManager.bh((String)localObject);
      if (System.currentTimeMillis() - l < 604800000L) {
        WebProcessManager.E(Leba.V(), "key_health_dns_parse");
      }
      l = WebProcessManager.bj((String)localObject);
      if (System.currentTimeMillis() - l < 259200000L) {
        WebProcessManager.E(Leba.access$400(), "key_gamecenter_dns_parse");
      }
      l = WebProcessManager.g((String)localObject, "key_reader_click_time");
      if (System.currentTimeMillis() - l < 259200000L) {
        WebProcessManager.E(Leba.cI(), "key_reader_dns_parse");
      }
    }
    localObject = (avmd)this.this$0.app.getManager(129);
    if (localObject != null) {
      ((avmd)localObject).abM(6);
    }
    localObject = (avcq)this.this$0.app.getManager(142);
    if (localObject != null) {
      avco.a(((avcq)localObject).a(6), 500L);
    }
    ThreadManager.post(new Leba.5.1(this), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.5
 * JD-Core Version:    0.7.0.1
 */