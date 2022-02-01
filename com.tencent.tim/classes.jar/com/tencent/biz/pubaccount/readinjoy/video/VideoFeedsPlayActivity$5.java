package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketProgressView;
import kbp;
import nce;
import nce.a;

class VideoFeedsPlayActivity$5
  implements Runnable
{
  VideoFeedsPlayActivity$5(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void run()
  {
    int i = 3;
    VideoFeedsPlayActivity.a(this.this$0).refresh();
    Object localObject = VideoFeedsPlayActivity.a(this.this$0).f();
    nce.a locala1 = new nce.a((VideoInfo)localObject);
    nce.a locala2;
    if (localObject != null)
    {
      localObject = ((VideoInfo)localObject).Wz;
      locala2 = locala1.a("icon_position", Integer.valueOf(3));
      if (!VideoFeedsPlayActivity.b(this.this$0)) {
        break label111;
      }
    }
    for (;;)
    {
      locala2.a("icon_status", Integer.valueOf(i)).h((String)localObject);
      kbp.a(null, "", "0X800ABBB", "0X800ABBB", 0, 0, "", "", (String)localObject, locala1.a().toJsonString(), false);
      return;
      localObject = "";
      break;
      label111:
      if (VideoFeedsPlayActivity.a(this.this$0).getCurrentState() == 1) {
        i = 2;
      } else {
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity.5
 * JD-Core Version:    0.7.0.1
 */