package com.tencent.biz.pubaccount.readinjoy.video;

import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;
import mzk;

public class VideoVolumeController$1
  implements Runnable
{
  public VideoVolumeController$1(mzk parammzk) {}
  
  public void run()
  {
    if (mzk.a(this.this$0)) {
      if (mzk.a(this.this$0) != null) {
        mzk.a(this.this$0).requestAudioFocus(null, 3, 2);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoVolumeController", 2, "mRequestOrAbandonAudioFocusCallBack isFocusAudio:" + mzk.a(this.this$0));
      }
      return;
      if (mzk.a(this.this$0) != null) {
        mzk.a(this.this$0).abandonAudioFocus(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeController.1
 * JD-Core Version:    0.7.0.1
 */