package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import aypq;
import aypq.a;
import java.lang.ref.WeakReference;

public class VideoFrameLoader$1
  implements Runnable
{
  public VideoFrameLoader$1(aypq paramaypq) {}
  
  public void run()
  {
    aypq.a locala = null;
    if (aypq.a(this.this$0) != null) {
      locala = (aypq.a)aypq.a(this.this$0).get();
    }
    if (locala != null) {
      locala.onLoadStart();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.1
 * JD-Core Version:    0.7.0.1
 */