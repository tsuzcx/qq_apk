package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.qphone.base.util.QLog;
import psu;
import psx;

class QQStoryItemBuilder$8
  implements Runnable
{
  QQStoryItemBuilder$8(QQStoryItemBuilder paramQQStoryItemBuilder, String paramString1, QQStoryItemBuilder.b paramb, long paramLong, String paramString2, boolean paramBoolean) {}
  
  public void run()
  {
    StoryVideoItem localStoryVideoItem = ((psu)psx.a(5)).a(this.val$vid);
    if ((localStoryVideoItem == null) || (TextUtils.isEmpty(localStoryVideoItem.mVideoUrl)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder setVideoView 1: storyVideoItem = " + localStoryVideoItem);
      }
      ((Activity)this.this$0.mContext).runOnUiThread(new QQStoryItemBuilder.8.1(this));
      this.this$0.a(this.b, this.val$vid, this.rJ, this.bhH);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.share", 2, "QQStoryItemBuilder setVideoView 2: storyVideoItem = " + localStoryVideoItem);
    }
    this.this$0.a(this.b, this.rJ, localStoryVideoItem, this.bhH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder.8
 * JD-Core Version:    0.7.0.1
 */