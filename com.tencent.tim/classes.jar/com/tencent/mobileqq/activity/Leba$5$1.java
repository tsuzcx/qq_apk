package com.tencent.mobileqq.activity;

import ajqo;
import ajrk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import vfp;

public class Leba$5$1
  implements Runnable
{
  Leba$5$1(Leba.5 param5) {}
  
  public void run()
  {
    WebProcessManager localWebProcessManager = (WebProcessManager)this.a.this$0.app.getManager(13);
    if ((localWebProcessManager != null) && (localWebProcessManager.aFT())) {
      localWebProcessManager.a(202, new vfp(this));
    }
    this.a.this$0.bQK();
    if (ajrk.isColorLevel()) {
      ajrk.m("Q.lebatab.", new Object[] { "preload nearby process/tool process" });
    }
    ajqo.fl(this.a.this$0.app.getAccount(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Leba.5.1
 * JD-Core Version:    0.7.0.1
 */