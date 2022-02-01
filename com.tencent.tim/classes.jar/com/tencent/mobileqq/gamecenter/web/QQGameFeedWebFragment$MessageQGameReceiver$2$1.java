package com.tencent.mobileqq.gamecenter.web;

import android.support.v4.app.FragmentActivity;
import com.tencent.qphone.base.util.QLog;

class QQGameFeedWebFragment$MessageQGameReceiver$2$1
  implements Runnable
{
  QQGameFeedWebFragment$MessageQGameReceiver$2$1(QQGameFeedWebFragment.MessageQGameReceiver.2 param2) {}
  
  public void run()
  {
    if ((this.a.b.this$0.getActivity() != null) && (!this.a.b.this$0.getActivity().isFinishing()))
    {
      QLog.d("GameWebPage", 4, "receiver broadcast,web page loaded");
      QQGameFeedWebFragment.b(this.a.b.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.MessageQGameReceiver.2.1
 * JD-Core Version:    0.7.0.1
 */