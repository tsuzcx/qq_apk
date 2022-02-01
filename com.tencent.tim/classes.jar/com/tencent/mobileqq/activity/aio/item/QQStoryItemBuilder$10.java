package com.tencent.mobileqq.activity.aio.item;

import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.qphone.base.util.QLog;

class QQStoryItemBuilder$10
  implements Runnable
{
  QQStoryItemBuilder$10(QQStoryItemBuilder paramQQStoryItemBuilder, QQStoryItemBuilder.b paramb, long paramLong) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share", 2, "showPlayIcon");
    }
    if (this.a == null) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.share", 2, "showPlayIcon: holder == null");
      }
    }
    Long localLong;
    do
    {
      return;
      localLong = (Long)this.a.a.getTag();
    } while ((localLong == null) || (localLong.longValue() != this.rJ));
    this.a.b.setDrawStatus(2);
    this.a.b.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.10
 * JD-Core Version:    0.7.0.1
 */