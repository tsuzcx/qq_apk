package com.tencent.mobileqq.listentogether.lyrics;

import aipb;
import aipd;
import com.tencent.qphone.base.util.QLog;

public class LyricsController$12
  implements Runnable
{
  public LyricsController$12(aipd paramaipd) {}
  
  public void run()
  {
    this.this$0.a.isForeground = true;
    if (this.this$0.clg)
    {
      if (aipd.a(this.this$0)) {
        break label77;
      }
      int i = this.this$0.a.des;
      String str = this.this$0.a.bPp;
      this.this$0.df(i, str);
      if (QLog.isColorLevel()) {
        QLog.d("LyricsController", 2, "ACTION_QQ_FOREGROUND no permission hideLyrics");
      }
    }
    return;
    label77:
    aipd.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController.12
 * JD-Core Version:    0.7.0.1
 */