package com.tencent.mobileqq.intervideo.huayang;

import aide;
import aidq;
import aids;
import android.os.Handler;

public class HuayangPluginNewDownloader$2
  implements Runnable
{
  public HuayangPluginNewDownloader$2(aidq paramaidq) {}
  
  public void run()
  {
    try
    {
      aidq.a(this.this$0);
      return;
    }
    catch (Throwable localThrowable)
    {
      aids.Lb("3228166");
      aide.j(new RuntimeException("huayangPluginManager downloadException", localThrowable));
      return;
    }
    finally
    {
      aidq.a(this.this$0).removeCallbacks(aidq.a(this.this$0));
      aidq.a(this.this$0, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangPluginNewDownloader.2
 * JD-Core Version:    0.7.0.1
 */