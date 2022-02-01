package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import kbp;
import mye.b;
import mza;
import nce;
import nce.a;

public class VideoUIManager$9
  implements Runnable
{
  public VideoUIManager$9(mza parammza, int paramInt) {}
  
  public void run()
  {
    if ((mza.a(this.this$0) != null) && (mza.a(this.this$0).d != null))
    {
      nce.a locala = new nce.a("", "", mza.a(this.this$0).d.mVideoVid, mza.a(this.this$0).d.innerUniqueID).a((int)mza.a(this.this$0).d.mChannelID);
      kbp.a(null, "", "0X8008AD0", "0X8008AD0", 0, 0, "", "", "", locala.a().toJsonString(), false);
      kbp.a(null, "", "0X8009B57", "0X8009B57", 0, 0, String.valueOf(this.aWw), "", "", locala.a().toJsonString(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.9
 * JD-Core Version:    0.7.0.1
 */