import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;

public class aape
  implements View.OnTouchListener
{
  public aape(EditLocalVideoActivity paramEditLocalVideoActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if (EditLocalVideoActivity.a(this.this$0).isPlaying()) {
        if (EditLocalVideoActivity.b(this.this$0))
        {
          EditLocalVideoActivity.b(this.this$0, false);
          EditLocalVideoActivity.a(this.this$0).pause();
          EditLocalVideoActivity.a(this.this$0).setVisibility(0);
        }
      }
      while (!EditLocalVideoActivity.b(this.this$0)) {
        return true;
      }
      EditLocalVideoActivity.a(this.this$0).start();
      EditLocalVideoActivity.b(this.this$0, true);
      EditLocalVideoActivity.a(this.this$0).setVisibility(4);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aape
 * JD-Core Version:    0.7.0.1
 */