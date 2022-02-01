package com.tencent.biz.qqstory.takevideo;

import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import ram;
import rdm;

public class EditVideoPlayer$5
  implements Runnable
{
  public EditVideoPlayer$5(rdm paramrdm, int paramInt, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    ram.b("Q.qqstory.record.EditVideoPlayer", "setMosaic %d", Integer.valueOf(this.bqw));
    VideoSourceHelper.nativeSetMosaic(this.bqw, this.bF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPlayer.5
 * JD-Core Version:    0.7.0.1
 */