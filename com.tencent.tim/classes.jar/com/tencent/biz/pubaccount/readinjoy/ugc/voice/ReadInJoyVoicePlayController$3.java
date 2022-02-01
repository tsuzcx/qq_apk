package com.tencent.biz.pubaccount.readinjoy.ugc.voice;

import android.media.AudioManager;
import com.tencent.qphone.base.util.QLog;
import mrh;

public class ReadInJoyVoicePlayController$3
  implements Runnable
{
  public ReadInJoyVoicePlayController$3(mrh parammrh) {}
  
  public void run()
  {
    if (mrh.a(this.this$0)) {
      if (mrh.a(this.this$0) != null) {
        mrh.a(this.this$0).requestAudioFocus(null, 3, 2);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(mrh.TAG, 2, "mRequestOrAbandonAudioFocusCallBack isFocusAudio:" + mrh.a(this.this$0));
      }
      return;
      if (mrh.a(this.this$0) != null) {
        mrh.a(this.this$0).abandonAudioFocus(null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.voice.ReadInJoyVoicePlayController.3
 * JD-Core Version:    0.7.0.1
 */