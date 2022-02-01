import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class lfk
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public lfk(VideoView paramVideoView) {}
  
  public void onGlobalLayout()
  {
    if ((VideoView.a(this.this$0) == VideoView.aOy) && (!this.this$0.ajU))
    {
      if ((this.this$0.isShown()) && (VideoView.a(this.this$0).get() != 3))
      {
        VideoView.a(this.this$0).set(3);
        QLog.d("gifvideo.VideoView", 1, "show to play");
        this.this$0.kH();
      }
      if ((!this.this$0.isShown()) && (VideoView.a(this.this$0).get() != 5))
      {
        VideoView.a(this.this$0).set(5);
        QLog.d("gifvideo.VideoView", 1, "unshow to stop");
        this.this$0.stop();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lfk
 * JD-Core Version:    0.7.0.1
 */