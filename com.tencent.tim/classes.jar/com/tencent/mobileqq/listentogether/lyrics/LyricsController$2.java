package com.tencent.mobileqq.listentogether.lyrics;

import aipd;
import com.tencent.qphone.base.util.QLog;

public class LyricsController$2
  implements Runnable
{
  public LyricsController$2(aipd paramaipd) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, "mDelayUpdateLyricsFloatWindowRunnable isForeground: " + this.this$0.mIsForeground + " mFloatParams:" + this.this$0.a);
    }
    aipd.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController.2
 * JD-Core Version:    0.7.0.1
 */