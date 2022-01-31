import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;

public class xkf
  implements View.OnTouchListener
{
  public xkf(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if (EditLocalVideoActivity.a(this.a).isPlaying()) {
        if (EditLocalVideoActivity.a(this.a))
        {
          EditLocalVideoActivity.c(this.a, false);
          EditLocalVideoActivity.a(this.a).pause();
          EditLocalVideoActivity.b(this.a).setVisibility(0);
        }
      }
      while (!EditLocalVideoActivity.a(this.a)) {
        return true;
      }
      EditLocalVideoActivity.a(this.a).start();
      EditLocalVideoActivity.c(this.a, true);
      EditLocalVideoActivity.b(this.a).setVisibility(4);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xkf
 * JD-Core Version:    0.7.0.1
 */