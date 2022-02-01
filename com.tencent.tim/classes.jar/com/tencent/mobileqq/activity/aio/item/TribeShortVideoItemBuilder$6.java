package com.tencent.mobileqq.activity.aio.item;

import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.qphone.base.util.QLog;

class TribeShortVideoItemBuilder$6
  implements Runnable
{
  TribeShortVideoItemBuilder$6(TribeShortVideoItemBuilder paramTribeShortVideoItemBuilder, TribeShortVideoItemBuilder.b paramb, long paramLong) {}
  
  public void run()
  {
    if (this.a == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TribeShortVideoItemBuilder", 2, "showPlayIcon");
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */