package com.tencent.mobileqq.gamecenter.web;

import com.tencent.mobileqq.qipc.QIPCClientHelper;
import java.util.ArrayList;

class QQGameFeedWebFragment$MessageQGameReceiver$1
  implements Runnable
{
  QQGameFeedWebFragment$MessageQGameReceiver$1(QQGameFeedWebFragment.b paramb, ArrayList paramArrayList) {}
  
  public void run()
  {
    QQGameFeedWebFragment.a(this.b.this$0, this.gf);
    QIPCClientHelper.getInstance().callServer("QQGameIPCModule", "clearUnreadMsg", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.MessageQGameReceiver.1
 * JD-Core Version:    0.7.0.1
 */