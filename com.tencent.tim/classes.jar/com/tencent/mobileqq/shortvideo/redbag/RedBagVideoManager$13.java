package com.tencent.mobileqq.shortvideo.redbag;

import android.os.Bundle;
import anjo;
import anjx;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;

public class RedBagVideoManager$13
  implements Runnable
{
  public RedBagVideoManager$13(anjo paramanjo) {}
  
  public void run()
  {
    if (anjo.a(this.this$0) != null)
    {
      anjo.a(this.this$0).redBagStat = 1;
      long l = anjo.a(this.this$0).uniseq;
      String str = anjo.a(this.this$0).friendUin;
      int i = anjo.a(this.this$0).istroop;
      Bundle localBundle = new Bundle();
      localBundle.putLong("VALUE_MSG_UINSEQ", l);
      localBundle.putString("VALUE_MSG_FRIENDUIN", str);
      localBundle.putInt("VALUE_MSG_ISTROOP", i);
      localBundle.putString("VALUE_MSG_VIDEO_ID", anjo.a(this.this$0).shortVideoId);
      anjx.a().b("CMD_UPDATE_MSG_FOR_VIDEO_REDBAG_STAT", localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.13
 * JD-Core Version:    0.7.0.1
 */