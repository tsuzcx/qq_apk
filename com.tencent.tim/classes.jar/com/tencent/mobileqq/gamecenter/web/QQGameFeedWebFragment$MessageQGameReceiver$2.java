package com.tencent.mobileqq.gamecenter.web;

import com.tencent.mobileqq.gamecenter.web.view.GameContentView;

class QQGameFeedWebFragment$MessageQGameReceiver$2
  implements Runnable
{
  QQGameFeedWebFragment$MessageQGameReceiver$2(QQGameFeedWebFragment.b paramb) {}
  
  public void run()
  {
    if (QQGameFeedWebFragment.a(this.b.this$0) == null) {
      return;
    }
    QQGameFeedWebFragment.a(this.b.this$0).postDelayed(new QQGameFeedWebFragment.MessageQGameReceiver.2.1(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.MessageQGameReceiver.2
 * JD-Core Version:    0.7.0.1
 */