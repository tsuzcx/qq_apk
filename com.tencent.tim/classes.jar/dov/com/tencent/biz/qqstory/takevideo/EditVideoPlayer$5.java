package dov.com.tencent.biz.qqstory.takevideo;

import ayhk;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import ram;

public class EditVideoPlayer$5
  implements Runnable
{
  public EditVideoPlayer$5(ayhk paramayhk, int paramInt, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    ram.b("Q.qqstory.record.EditVideoPlayer", "setMosaic %d", Integer.valueOf(this.bqw));
    VideoSourceHelper.nativeSetMosaic(this.bqw, this.bF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoPlayer.5
 * JD-Core Version:    0.7.0.1
 */