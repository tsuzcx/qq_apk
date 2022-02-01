package com.tencent.mobileqq.shortvideo.filter;

import com.tencent.sveffects.SLog;

class QQMTVFilter$1
  implements Runnable
{
  QQMTVFilter$1(QQMTVFilter paramQQMTVFilter, boolean paramBoolean) {}
  
  public void run()
  {
    SLog.d("QQMTVFilter", "useFrameTime:" + this.val$bDecodeTime);
    QQMTVFilter.access$002(this.this$0, this.val$bDecodeTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQMTVFilter.1
 * JD-Core Version:    0.7.0.1
 */