import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.hotpic.HotPicMainPanel;

public class ahzb
  implements View.OnTouchListener
{
  public ahzb(HotPicMainPanel paramHotPicMainPanel) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    HotPicMainPanel.a(this.b);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahzb
 * JD-Core Version:    0.7.0.1
 */