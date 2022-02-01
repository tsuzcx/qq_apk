import android.os.Handler;
import com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer;
import com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.ConvertIFramesRunnable;
import com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.ConvertIFramesRunnable.1.1;
import com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.ConvertIFramesRunnable.1.2;
import com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.a;

public class req
  implements amal
{
  public req(HWEditLocalVideoPlayer.ConvertIFramesRunnable paramConvertIFramesRunnable, HWEditLocalVideoPlayer.a parama) {}
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    ram.e("Q.qqstory.record.HWEditLocalVideoPlayer", "encode error errorCode = " + paramInt + " Exception = " + paramThrowable);
    if (this.b.bqE == 0)
    {
      this.b.bqE = 1;
      this.b.mFrameRate = 3;
      ram.w("Q.qqstory.record.HWEditLocalVideoPlayer", "Reencode i frame video by mIFrameInterval = " + this.b.bqE + " mFrameRate = " + this.b.mFrameRate);
      HWEditLocalVideoPlayer.a(this.b.this$0).postDelayed(this.b, 1000L);
      return;
    }
    ram.w("Q.qqstory.record.HWEditLocalVideoPlayer", "Reencode i frame video failed");
    try
    {
      ambe.j(paramThrowable);
      HWEditLocalVideoPlayer.a(this.b.this$0).post(new HWEditLocalVideoPlayer.ConvertIFramesRunnable.1.2(this));
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
    HWEditLocalVideoPlayer.a(this.b.this$0).post(new HWEditLocalVideoPlayer.ConvertIFramesRunnable.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     req
 * JD-Core Version:    0.7.0.1
 */