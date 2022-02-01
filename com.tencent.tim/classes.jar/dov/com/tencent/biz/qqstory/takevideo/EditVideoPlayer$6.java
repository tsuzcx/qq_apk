package dov.com.tencent.biz.qqstory.takevideo;

import ayhk;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import ram;

public class EditVideoPlayer$6
  implements Runnable
{
  public EditVideoPlayer$6(ayhk paramayhk, int paramInt) {}
  
  public void run()
  {
    ram.b("Q.qqstory.record.EditVideoPlayer", "setPlayMode %d", Integer.valueOf(this.aJf));
    VideoSourceHelper.nativeSetPlayMode(this.aJf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.6
 * JD-Core Version:    0.7.0.1
 */