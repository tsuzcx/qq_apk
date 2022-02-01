package com.tencent.biz.pubaccount.readinjoy.video.bandwidth;

import myi;
import mzz;

public class VideoBufferRangeController$1
  implements Runnable
{
  public VideoBufferRangeController$1(mzz parammzz, myi parammyi, int[] paramArrayOfInt) {}
  
  public void run()
  {
    this.c.setHttpBufferRange(this.val$buffferRange[0], this.val$buffferRange[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.bandwidth.VideoBufferRangeController.1
 * JD-Core Version:    0.7.0.1
 */