package com.tencent.mobileqq.gamecenter.web;

import abmt;
import java.util.HashMap;
import java.util.Map;
import tbb;

class QQGameFeedWebFragment$10
  implements Runnable
{
  QQGameFeedWebFragment$10(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void run()
  {
    QQGameFeedWebFragment.a(this.this$0, false, 0);
    this.this$0.enterAIO();
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(24), "1");
    localHashMap.put(Integer.valueOf(4), "20");
    tbb.a(abmt.getAppInterface(), "769", "205036", "", "76901", "1", "160", localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.10
 * JD-Core Version:    0.7.0.1
 */