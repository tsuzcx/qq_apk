import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.biz.qqstory.playvideo.VideoCoverListBar;

public class qgl
  implements View.OnTouchListener
{
  float downX = -1.0F;
  float downY = -1.0F;
  
  public qgl(VideoCoverListBar paramVideoCoverListBar, int paramInt) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      return false;
    case 0: 
      this.downX = paramMotionEvent.getX();
      this.downY = paramMotionEvent.getY();
      return false;
    }
    if (Math.abs(paramMotionEvent.getY() - this.downY) > Math.min(this.bmk, 40)) {
      rar.a("play_video", "slide_mini", 0, 0, new String[] { "2", "", "", VideoCoverListBar.a(this.this$0) });
    }
    this.downX = -1.0F;
    this.downY = -1.0F;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qgl
 * JD-Core Version:    0.7.0.1
 */