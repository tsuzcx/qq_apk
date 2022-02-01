package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.ArrayList;
import java.util.Iterator;
import mht;
import msa;
import myi;

class VideoFeedsPlayManager$5
  implements Runnable
{
  VideoFeedsPlayManager$5(VideoFeedsPlayManager paramVideoFeedsPlayManager) {}
  
  public void run()
  {
    if ((VideoFeedsPlayManager.a(this.this$0) != null) && ((VideoFeedsPlayManager.a(this.this$0).qe() == 5) || (VideoFeedsPlayManager.a(this.this$0).qe() == 2)))
    {
      VideoFeedsPlayManager.a(this.this$0).restart();
      if (VideoFeedsPlayManager.b(this.this$0).jdField_a_of_type_Msa != null) {
        VideoFeedsPlayManager.b(this.this$0).jdField_a_of_type_Msa.b(VideoFeedsPlayManager.b(this.this$0));
      }
      if (VideoFeedsPlayManager.a(this.this$0) != null)
      {
        Iterator localIterator = VideoFeedsPlayManager.a(this.this$0).iterator();
        while (localIterator.hasNext()) {
          ((VideoFeedsPlayManager.d)localIterator.next()).b(VideoFeedsPlayManager.b(this.this$0));
        }
      }
      if (VideoFeedsPlayManager.d(this.this$0)) {
        VideoFeedsPlayManager.b(this.this$0).jdField_a_of_type_Mht.aSm = mht.aSj;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.5
 * JD-Core Version:    0.7.0.1
 */