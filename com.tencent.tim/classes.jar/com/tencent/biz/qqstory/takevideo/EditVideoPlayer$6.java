package com.tencent.biz.qqstory.takevideo;

import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import ram;
import rdm;

public class EditVideoPlayer$6
  implements Runnable
{
  public EditVideoPlayer$6(rdm paramrdm, int paramInt) {}
  
  public void run()
  {
    ram.b("Q.qqstory.record.EditVideoPlayer", "setPlayMode %d", Integer.valueOf(this.aJf));
    VideoSourceHelper.nativeSetPlayMode(this.aJf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPlayer.6
 * JD-Core Version:    0.7.0.1
 */