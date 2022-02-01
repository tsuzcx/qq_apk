package com.tencent.mobileqq.lyric.widget;

import aiwn;
import aixd;
import android.util.Log;

public class LyricViewController$3
  implements Runnable
{
  public LyricViewController$3(aixd paramaixd, aiwn paramaiwn1, aiwn paramaiwn2, aiwn paramaiwn3) {}
  
  public void run()
  {
    if (this.c == null) {
      Log.d("ModuleController", "setLyric -> pronounce is null");
    }
    if (this.d == null)
    {
      Log.d("ModuleController", "setLyric -> qrc is null");
      this.this$0.a.a(this.e, this.c);
      this.this$0.b = this.e;
      return;
    }
    this.this$0.a.a(this.d, this.c);
    this.this$0.b = this.d;
    this.this$0.dfO = this.this$0.b.sK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewController.3
 * JD-Core Version:    0.7.0.1
 */