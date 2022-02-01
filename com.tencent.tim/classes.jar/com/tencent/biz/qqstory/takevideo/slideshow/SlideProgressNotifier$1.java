package com.tencent.biz.qqstory.takevideo.slideshow;

import android.app.Activity;
import arhz;
import com.tencent.qphone.base.util.QLog;

class SlideProgressNotifier$1
  implements Runnable
{
  SlideProgressNotifier$1(SlideProgressNotifier paramSlideProgressNotifier, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQProgressNotifier", 2, "SlideShowProgressUpdate : " + this.val$process + "%");
    }
    SlideProgressNotifier.a(this.this$0).setMessage(this.this$0.mContext.getString(2131701771) + " " + this.val$process + "%");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideProgressNotifier.1
 * JD-Core Version:    0.7.0.1
 */