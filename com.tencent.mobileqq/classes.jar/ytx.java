import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.ad.tangram.statistics.AdAntiSpamForClick;

final class ytx
  implements View.OnTouchListener
{
  ytx(ytv paramytv) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    ytv localytv = this.a;
    ytv.a.onTouch(paramView, paramMotionEvent);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ytx
 * JD-Core Version:    0.7.0.1
 */