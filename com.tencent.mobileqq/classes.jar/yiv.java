import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;

public class yiv
  implements View.OnTouchListener
{
  public yiv(VideoPlayerView paramVideoPlayerView) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    VideoPlayerView.a(this.a);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yiv
 * JD-Core Version:    0.7.0.1
 */