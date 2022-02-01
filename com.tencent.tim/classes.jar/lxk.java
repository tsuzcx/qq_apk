import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;

class lxk
  implements View.OnTouchListener
{
  lxk(lxg paramlxg, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.dO.setDuplicateParentStateEnabled(true);
      this.dN.setDuplicateParentStateEnabled(true);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lxk
 * JD-Core Version:    0.7.0.1
 */