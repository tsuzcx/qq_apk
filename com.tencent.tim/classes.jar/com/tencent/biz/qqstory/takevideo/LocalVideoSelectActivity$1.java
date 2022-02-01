package com.tencent.biz.qqstory.takevideo;

import android.content.Intent;
import com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;

class LocalVideoSelectActivity$1
  implements Runnable
{
  LocalVideoSelectActivity$1(LocalVideoSelectActivity paramLocalVideoSelectActivity) {}
  
  public void run()
  {
    int i = 0;
    if (this.this$0.getIntent().getBooleanExtra("readinjoy_video", false)) {
      i = 1;
    }
    LocalVideoSelectActivity.a(this.this$0).a(LocalVideoSelectActivity.a(this.this$0), (int)LocalVideoSelectActivity.a(this.this$0).mDuration, LocalVideoSelectActivity.a(this.this$0), LocalVideoSelectActivity.b(this.this$0), LocalVideoSelectActivity.a(this.this$0), LocalVideoSelectActivity.b(this.this$0), i);
    LocalVideoSelectActivity.a(this.this$0).a(this.this$0.scrollX, this.this$0.startIndex, this.this$0.endIndex, this.this$0.endTime, this.this$0.startTime);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.LocalVideoSelectActivity", 2, "mScrollFrameSelectBar.post  scrollX : " + this.this$0.scrollX + "startIndex : " + this.this$0.startIndex + " endIndex : " + this.this$0.endIndex + " endTime : " + this.this$0.endTime + " startTime : " + this.this$0.startTime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity.1
 * JD-Core Version:    0.7.0.1
 */