package com.tencent.mobileqq.listentogether.lyrics;

import aipd;
import anpc;
import com.tencent.common.app.BaseApplicationImpl;

public class LyricsController$4
  implements Runnable
{
  public LyricsController$4(aipd paramaipd, boolean paramBoolean) {}
  
  public void run()
  {
    anpc.a(BaseApplicationImpl.getContext()).collectPerformance("", "listen_together_float_window_permission_quality", this.cll, 0L, 0L, null, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController.4
 * JD-Core Version:    0.7.0.1
 */