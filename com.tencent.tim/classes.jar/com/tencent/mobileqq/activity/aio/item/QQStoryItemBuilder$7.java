package com.tencent.mobileqq.activity.aio.item;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.qphone.base.util.QLog;
import qem;

class QQStoryItemBuilder$7
  implements Runnable
{
  QQStoryItemBuilder$7(QQStoryItemBuilder paramQQStoryItemBuilder, String paramString, QQStoryItemBuilder.b paramb, StoryVideoItem paramStoryVideoItem, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQStoryItemBuilder", 2, "QQStoryItemBuilder handleGetVideo 3: fileName = " + this.axJ);
    }
    this.a.isPlaying = true;
    this.a.b.bwe();
    this.a.b.setVisibility(8);
    qem.a(this.a.e, this.val$storyVideoItem.mLocalMaskPath, this.val$storyVideoItem.mOriginalMaskPicUrl, false, this.this$0.bUz, this.this$0.bUA);
    this.this$0.a(this.a, this.Jc, this.val$storyVideoItem.mVideoWidth, this.val$storyVideoItem.mVideoHeight, this.val$storyVideoItem.mVideoThumbnailUrl, this.axJ);
    this.this$0.b(this.a, this.Jc, this.val$storyVideoItem, this.bhH);
    this.this$0.c(this.a, this.Jc, this.val$storyVideoItem, this.bhH);
    QQStoryItemBuilder.a(this.this$0, this.val$storyVideoItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.7
 * JD-Core Version:    0.7.0.1
 */