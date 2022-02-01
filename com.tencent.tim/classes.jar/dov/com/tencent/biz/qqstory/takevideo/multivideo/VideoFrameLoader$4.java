package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import aypq;
import aypq.a;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;

public class VideoFrameLoader$4
  implements Runnable
{
  public VideoFrameLoader$4(aypq paramaypq) {}
  
  public void run()
  {
    if (aypq.b(this.this$0) != aypq.a(this.this$0).size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFrameLoader", 2, "onDecodeError , framecount error!" + aypq.b(this.this$0) + "-" + aypq.a(this.this$0).size());
      }
      if ((!aypq.c(this.this$0)) && (aypq.a(this.this$0).size() == 0))
      {
        aypq.a(this.this$0, true);
        this.this$0.stop();
        aypq.a(this.this$0, new RetrieverDecodeRunnable(aypq.a(this.this$0), aypq.c(this.this$0), aypq.d(this.this$0), aypq.b(this.this$0), aypq.a(this.this$0), aypq.a(this.this$0), aypq.b(this.this$0), this.this$0));
        ThreadManager.post(aypq.a(this.this$0), 10, null, true);
        if (QLog.isColorLevel()) {
          QLog.d("VideoFrameLoader", 2, "onLoadEnd , retry with retriever!");
        }
      }
    }
    for (;;)
    {
      return;
      if (aypq.a(this.this$0) != null) {}
      for (aypq.a locala = (aypq.a)aypq.a(this.this$0).get(); locala != null; locala = null)
      {
        locala.eTj();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.4
 * JD-Core Version:    0.7.0.1
 */