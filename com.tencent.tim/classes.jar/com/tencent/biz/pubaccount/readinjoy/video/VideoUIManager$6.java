package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import kbp;
import kct;
import mye.b;
import mza;

public class VideoUIManager$6
  implements Runnable
{
  public VideoUIManager$6(mza parammza) {}
  
  public void run()
  {
    if ((mza.a(this.this$0) != null) && (mza.a(this.this$0).d != null)) {
      kbp.a(null, "", "0X8008ACD", "0X8008ACD", 0, 0, "", "", "", kct.a(mza.a(this.this$0).d.mVideoVid, mza.a(this.this$0).d.innerUniqueID, (int)mza.a(this.this$0).d.mChannelID, null), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.6
 * JD-Core Version:    0.7.0.1
 */