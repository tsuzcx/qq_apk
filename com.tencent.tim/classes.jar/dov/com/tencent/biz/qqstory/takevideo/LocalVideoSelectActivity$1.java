package dov.com.tencent.biz.qqstory.takevideo;

import android.content.Intent;
import com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;

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
    LocalVideoSelectActivity.a(this.this$0).setLocalVideoView(LocalVideoSelectActivity.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity.1
 * JD-Core Version:    0.7.0.1
 */