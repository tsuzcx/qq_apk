import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;

public class yni
  implements View.OnTouchListener
{
  public yni(VideoPlayerView paramVideoPlayerView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    VideoPlayerView.a(this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yni
 * JD-Core Version:    0.7.0.1
 */