import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.ConvertIFramesRunnable;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.ConvertIFramesRunnable.1.1;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.ConvertIFramesRunnable.1.2;
import dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.a;

public class ayiv
  implements amal
{
  public ayiv(HWEditLocalVideoPlayer.ConvertIFramesRunnable paramConvertIFramesRunnable, HWEditLocalVideoPlayer.a parama) {}
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    ram.e("Q.qqstory.record.HWEditLocalVideoPlayer", "encode error errorCode = " + paramInt + " Exception = " + paramThrowable);
    if (this.b.bqE == 0)
    {
      this.b.bqE = 1;
      this.b.mFrameRate = 3;
      ram.w("Q.qqstory.record.HWEditLocalVideoPlayer", "Reencode i frame video by mIFrameInterval = " + this.b.bqE + " mFrameRate = " + this.b.mFrameRate);
      this.b.this$0.l(this.b, 1000L);
      return;
    }
    ram.w("Q.qqstory.record.HWEditLocalVideoPlayer", "Reencode i frame video failed");
    try
    {
      ambe.j(paramThrowable);
      this.b.this$0.l(new HWEditLocalVideoPlayer.ConvertIFramesRunnable.1.2(this), 0L);
      return;
    }
    catch (Throwable paramThrowable)
    {
      for (;;)
      {
        paramThrowable.printStackTrace();
      }
    }
  }
  
  public void auv() {}
  
  public void btD() {}
  
  public void kf(String paramString)
  {
    this.a.mIFrameVideoPath = paramString;
    ram.w("Q.qqstory.record.HWEditLocalVideoPlayer", "onEncodeFinish  iframe file filePath = " + paramString);
    this.b.this$0.l(new HWEditLocalVideoPlayer.ConvertIFramesRunnable.1.1(this), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayiv
 * JD-Core Version:    0.7.0.1
 */