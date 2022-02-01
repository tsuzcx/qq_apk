package com.tencent.mobileqq.activity.aio.item;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;

class QQStoryItemBuilder$6
  implements Runnable
{
  QQStoryItemBuilder$6(QQStoryItemBuilder paramQQStoryItemBuilder, QQStoryItemBuilder.b paramb, long paramLong, StoryVideoItem paramStoryVideoItem) {}
  
  public void run()
  {
    Long localLong = (Long)this.a.a.getTag();
    if ((localLong == null) || (localLong.longValue() != this.Jc)) {
      return;
    }
    this.a.b.setDrawStatus(2);
    this.a.b.setVisibility(0);
    QQStoryItemBuilder.a(this.a.a, this.val$storyVideoItem.mVideoThumbnailUrl, this.this$0.bUz, this.this$0.bUA, this.this$0.dR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */